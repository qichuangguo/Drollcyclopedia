package com.android.cgcxy.drollcyclopedia.Choiceness;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.cgcxy.drollcyclopedia.Choiceness.entity.ChoicenessEntity;
import com.android.cgcxy.drollcyclopedia.R;
import com.android.cgcxy.drollcyclopedia.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.squareup.picasso.Picasso;

/**
 * 精选详情页
 */
public class ChoicenessDetailsActivity extends BaseActivity implements View.OnClickListener {

    //姓名、文本、评论
    private TextView tv_activity_details_choiceness_user_name, tv_activity_details_choiceness_content, tv_activity_details_choiceness_comment_total,
            tv_activity_details_choiceness_like_start, tv_activity_details_choiceness_dislike_start,tv_activity_details_choiceness_report;
    //头像、图片
    private ImageView iv_activity_details_choiceness_avatar, iv_activity_details_choiceness_media_data,iv_title_left,iv_activity_details_choiceness_media_data_gif;
    //评论
    private LinearLayout ll_activity_details_choiceness_hot_comment;
    private TextView tv_activity_details_choiceness_hot_comment_author, tv_activity_details_choiceness_hot_comment_like, tv_activity_details_choiceness_hot_comment_message;

    private ChoicenessEntity mChoicenessEntity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_choiceness_details;
    }
    int i = 1;

    @Override
    protected void onAfterActivityCreate() {
        if (null != getIntent().getSerializableExtra("choicenessEntity")) {
            mChoicenessEntity = (ChoicenessEntity) getIntent().getSerializableExtra("choicenessEntity");
        } else {
            finish();
        }
        iv_activity_details_choiceness_avatar = (ImageView) findViewById(R.id.iv_activity_details_choiceness_avatar);
        iv_activity_details_choiceness_media_data = (ImageView) findViewById(R.id.iv_activity_details_choiceness_media_data);
        iv_activity_details_choiceness_media_data_gif = (ImageView) findViewById(R.id.iv_activity_details_choiceness_media_data_gif);
        iv_title_left = (ImageView) findViewById(R.id.iv_title_left);

        tv_activity_details_choiceness_user_name = (TextView) findViewById(R.id.tv_activity_details_choiceness_user_name);
        tv_activity_details_choiceness_content = (TextView) findViewById(R.id.tv_activity_details_choiceness_content);
        tv_activity_details_choiceness_like_start = (TextView) findViewById(R.id.tv_activity_details_choiceness_like_start);
        tv_activity_details_choiceness_dislike_start = (TextView) findViewById(R.id.tv_activity_details_choiceness_dislike_start);
        tv_activity_details_choiceness_comment_total = (TextView) findViewById(R.id.tv_activity_details_choiceness_comment_total);
        tv_activity_details_choiceness_report = (TextView) findViewById(R.id.tv_activity_details_choiceness_report);

        ll_activity_details_choiceness_hot_comment = (LinearLayout) findViewById(R.id.ll_activity_details_choiceness_hot_comment);
        tv_activity_details_choiceness_hot_comment_author = (TextView) findViewById(R.id.tv_activity_details_choiceness_hot_comment_author);
        tv_activity_details_choiceness_hot_comment_like = (TextView) findViewById(R.id.tv_activity_details_choiceness_hot_comment_like);
        tv_activity_details_choiceness_hot_comment_message = (TextView) findViewById(R.id.tv_activity_details_choiceness_hot_comment_message);

        iv_title_left.setOnClickListener(this);
        tv_activity_details_choiceness_report.setOnClickListener(this);
        tv_activity_details_choiceness_like_start.setOnClickListener(this);
        tv_activity_details_choiceness_dislike_start.setOnClickListener(this);
        tv_activity_details_choiceness_comment_total.setOnClickListener(this);
        tv_activity_details_choiceness_hot_comment_like.setOnClickListener(this);

        initView();
    }

    @Override
    protected void initView() {
        Picasso.with(this).load(mChoicenessEntity.avatar).into(iv_activity_details_choiceness_avatar);
        tv_activity_details_choiceness_user_name.setText(mChoicenessEntity.user_name);
        tv_activity_details_choiceness_content.setText(mChoicenessEntity.title);

        String[] resolution = mChoicenessEntity.resolution.split("x");
        if (mChoicenessEntity.mediaDataMap.get(0).get("format").equals("JPEG")) {
            iv_activity_details_choiceness_media_data_gif.setVisibility(View.GONE);
            iv_activity_details_choiceness_media_data.setVisibility(View.VISIBLE);
            Glide.with(this).load(mChoicenessEntity.origin_pic_url).override(Integer.parseInt(resolution[0]), Integer.parseInt(resolution[1])).into(iv_activity_details_choiceness_media_data);
        } else if (mChoicenessEntity.mediaDataMap.get(0).get("format").equals("GIF")) {
            iv_activity_details_choiceness_media_data.setVisibility(View.GONE);
            iv_activity_details_choiceness_media_data_gif.setVisibility(View.VISIBLE);
            Glide.with(this).load(mChoicenessEntity.origin_pic_url).override(Integer.parseInt(resolution[0]), Integer.parseInt(resolution[1])).into(iv_activity_details_choiceness_media_data_gif);
        }
        tv_activity_details_choiceness_like_start.setText(mChoicenessEntity.like_start);
        tv_activity_details_choiceness_dislike_start.setText(mChoicenessEntity.dislike_start);

        tv_activity_details_choiceness_comment_total.setText(mChoicenessEntity.comment_total);
        //评论
        if (!mChoicenessEntity._id.equals("0")) {
            ll_activity_details_choiceness_hot_comment.setVisibility(View.VISIBLE);
            tv_activity_details_choiceness_hot_comment_author.setText(mChoicenessEntity.author);
            tv_activity_details_choiceness_hot_comment_like.setText(mChoicenessEntity.like);
            tv_activity_details_choiceness_hot_comment_message.setText(mChoicenessEntity.message);
        } else {
            ll_activity_details_choiceness_hot_comment.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        if (tv_activity_details_choiceness_like_start == view) {
            tv_activity_details_choiceness_like_start.setTextColor(this.getResources().getColor(R.color.base_bg));
            showToast("屌 +1");
        } else if (tv_activity_details_choiceness_dislike_start == view) {
            tv_activity_details_choiceness_dislike_start.setTextColor(this.getResources().getColor(R.color.base_bg));
            showToast("坑 +1");
        }else if(iv_title_left == view){
            finish();
        }else if (tv_activity_details_choiceness_hot_comment_like == view){
           if (i == 1){
            tv_activity_details_choiceness_hot_comment_like.setTextColor(getResources().getColor(R.color.base_bg));
            tv_activity_details_choiceness_hot_comment_like.setText((Integer.parseInt(mChoicenessEntity.like)+i)+"");
               i= 0 ;
           }
        }else if (tv_activity_details_choiceness_comment_total == view){
            if (i ==  1){
                tv_activity_details_choiceness_comment_total.setTextColor(getResources().getColor(R.color.base_bg));
                tv_activity_details_choiceness_comment_total.setText("");
            }
        }else if (tv_activity_details_choiceness_report == view){
            Toast.makeText(this,"已举报",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 启动activity
     */
    public static void launchActivity(Activity context, ChoicenessEntity choicenessEntity) {
        Intent intent = new Intent(context, ChoicenessDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("choicenessEntity", choicenessEntity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


}
