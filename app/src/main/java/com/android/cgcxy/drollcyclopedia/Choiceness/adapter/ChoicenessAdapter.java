package com.android.cgcxy.drollcyclopedia.Choiceness.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.cgcxy.drollcyclopedia.Choiceness.entity.ChoicenessEntity;
import com.android.cgcxy.drollcyclopedia.R;
import com.android.cgcxy.drollcyclopedia.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26092 on 2017/7/13.
 * 精选主页
 */

public class ChoicenessAdapter extends BaseAdapter {

    private List<ChoicenessEntity> mChoicenessEntities = new ArrayList<>();
    private BaseActivity mContext;

    public ChoicenessAdapter(BaseActivity constant, List<ChoicenessEntity> choicenessEntities) {
        this.mChoicenessEntities = choicenessEntities;
        this.mContext = constant;
    }

    @Override
    public int getCount() {
        return mChoicenessEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ChoicenessAdapter.HolderView holderView;
        if (null == convertView) {
            holderView = new ChoicenessAdapter.HolderView();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_choiceness, null);
            holderView.tv_item_fragment_choiceness_user_name = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_user_name);
            holderView.iv_item_fragment_choiceness_avatar = (ImageView) convertView.findViewById(R.id.iv_item_fragment_choiceness_avatar);
            holderView.tv_item_fragment_choiceness_content = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_content);
            holderView.tv_item_fragment_choiceness_comment_total = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_comment_total);
            holderView.tv_item_fragment_choiceness_dislike_start = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_dislike_start);
            holderView.tv_item_fragment_choiceness_like_start = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_like_start);
            holderView.tv_item_fragment_choiceness_share = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_share);
            holderView.iv_item_fragment_choiceness_media_data = (ImageView) convertView.findViewById(R.id.iv_item_fragment_choiceness_media_data);
            holderView.iv_item_fragment_choiceness_media_data_gif = (ImageView) convertView.findViewById(R.id.iv_item_fragment_choiceness_media_data_gif);

            holderView.ll_item_fragment_choiceness_hot_comment = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_choiceness_hot_comment);
            holderView.ll_item_fragment_choiceness_hot_comment.setVisibility(View.GONE);
            holderView.tv_item_fragment_choiceness_hot_comment_author = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_hot_comment_author);
            holderView.tv_item_fragment_choiceness_hot_comment_like = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_hot_comment_like);
            holderView.tv_item_fragment_choiceness_hot_comment_message = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_hot_comment_message);
            convertView.setTag(holderView);
        } else {
            holderView = (ChoicenessAdapter.HolderView) convertView.getTag();
        }
        ChoicenessEntity choicenessEntity = mChoicenessEntities.get(position);
        holderView.tv_item_fragment_choiceness_user_name.setText(choicenessEntity.user_name);
        holderView.tv_item_fragment_choiceness_content.setText(choicenessEntity.title);
        holderView.tv_item_fragment_choiceness_comment_total.setText(/*"评论 " + */choicenessEntity.comment_total);
        holderView.tv_item_fragment_choiceness_dislike_start.setText(/*"讨厌 " +*/ choicenessEntity.dislike_start);
        holderView.tv_item_fragment_choiceness_like_start.setText(/*"喜欢 " + */choicenessEntity.like_start);
        Picasso.with(mContext).load(choicenessEntity.avatar).into(holderView.iv_item_fragment_choiceness_avatar);

        String[] resolution = choicenessEntity.resolution.split("x");
        if (choicenessEntity.mediaDataMap.get(0).get("format").equals("JPEG")) {
            holderView.iv_item_fragment_choiceness_media_data_gif.setVisibility(View.GONE);
            holderView.iv_item_fragment_choiceness_media_data.setVisibility(View.VISIBLE);
            Glide
                    .with(mContext)
                    .load(choicenessEntity.origin_pic_url)
                    .override(Integer.parseInt(resolution[0]), Integer.parseInt(resolution[1]))
                    .into(holderView.iv_item_fragment_choiceness_media_data);
        } else if (choicenessEntity.mediaDataMap.get(0).get("format").equals("GIF")) {
            holderView.iv_item_fragment_choiceness_media_data.setVisibility(View.GONE);
            holderView.iv_item_fragment_choiceness_media_data_gif.setVisibility(View.VISIBLE);
            Glide
                    .with(mContext)
                    .load(choicenessEntity.origin_pic_url)
                    .asBitmap()
                    .override(Integer.parseInt(resolution[0]), Integer.parseInt(resolution[1]))
                    .into(holderView.iv_item_fragment_choiceness_media_data_gif);

        }


        //评论
        if (!choicenessEntity._id.equals("0")) {
            holderView.ll_item_fragment_choiceness_hot_comment.setVisibility(View.VISIBLE);
            holderView.tv_item_fragment_choiceness_hot_comment_author.setText(choicenessEntity.author);
            holderView.tv_item_fragment_choiceness_hot_comment_like.setText(/*"赞 "+*/choicenessEntity.like);
            holderView.tv_item_fragment_choiceness_hot_comment_message.setText(choicenessEntity.message);
        } else {
            holderView.ll_item_fragment_choiceness_hot_comment.setVisibility(View.GONE);
        }
        holderView.tv_item_fragment_choiceness_like_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holderView.tv_item_fragment_choiceness_like_start.setTextColor(mContext.getResources().getColor(R.color.FFCF24));
                mContext.showToast("屌 +1");
            }
        });
        holderView.tv_item_fragment_choiceness_dislike_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holderView.tv_item_fragment_choiceness_dislike_start.setTextColor(mContext.getResources().getColor(R.color.FFCF24));
                mContext.showToast("坑 +1");
            }
        });
        holderView.tv_item_fragment_choiceness_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"分享",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    class HolderView {
        //姓名、文本、评论
        TextView tv_item_fragment_choiceness_user_name, tv_item_fragment_choiceness_content, tv_item_fragment_choiceness_comment_total,
                tv_item_fragment_choiceness_dislike_start, tv_item_fragment_choiceness_like_start,tv_item_fragment_choiceness_share;
        //头像、图片
        ImageView iv_item_fragment_choiceness_avatar, iv_item_fragment_choiceness_media_data,iv_item_fragment_choiceness_media_data_gif;
        //评论
        LinearLayout ll_item_fragment_choiceness_hot_comment;
        TextView tv_item_fragment_choiceness_hot_comment_author, tv_item_fragment_choiceness_hot_comment_like, tv_item_fragment_choiceness_hot_comment_message;

    }
}
