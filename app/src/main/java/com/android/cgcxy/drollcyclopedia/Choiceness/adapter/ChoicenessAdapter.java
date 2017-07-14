package com.android.cgcxy.drollcyclopedia.Choiceness.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.drollcyclopedia.Choiceness.entity.ChoicenessEntity;
import com.android.cgcxy.drollcyclopedia.R;
import com.android.cgcxy.drollcyclopedia.base.BaseActivity;
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
        ChoicenessAdapter.HolderView holderView;
        if (null == convertView) {
            holderView = new ChoicenessAdapter.HolderView();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_choiceness, null);
            holderView.tv_item_fragment_choiceness_user_name = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_user_name);
            holderView.iv_item_fragment_choiceness_avatar = (ImageView) convertView.findViewById(R.id.iv_item_fragment_choiceness_avatar);
            holderView.tv_item_fragment_choiceness_content = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_content);
            holderView.tv_item_fragment_choiceness_comment_total = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_comment_total);
            holderView.tv_item_fragment_choiceness_dislike_start = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_dislike_start);
            holderView.tv_item_fragment_choiceness_like_start = (TextView) convertView.findViewById(R.id.tv_item_fragment_choiceness_like_start);
            convertView.setTag(holderView);
        } else {
            holderView = (ChoicenessAdapter.HolderView) convertView.getTag();
        }
        holderView.tv_item_fragment_choiceness_user_name.setText(mChoicenessEntities.get(position).user_name);
        holderView.tv_item_fragment_choiceness_content.setText(mChoicenessEntities.get(position).title);
        holderView.tv_item_fragment_choiceness_comment_total.setText("评论 "+mChoicenessEntities.get(position).comment_total);
        holderView.tv_item_fragment_choiceness_dislike_start.setText("讨厌 "+mChoicenessEntities.get(position).dislike_start);
        holderView.tv_item_fragment_choiceness_like_start.setText("喜欢 "+mChoicenessEntities.get(position).like_start);
        Picasso.with(mContext).load(mChoicenessEntities.get(position).avatar).into(holderView.iv_item_fragment_choiceness_avatar);
        return convertView;
    }

    class HolderView {
        //姓名、文本、评论
        TextView tv_item_fragment_choiceness_user_name,tv_item_fragment_choiceness_content,tv_item_fragment_choiceness_comment_total,
                tv_item_fragment_choiceness_dislike_start,tv_item_fragment_choiceness_like_start;
        //头像
        ImageView iv_item_fragment_choiceness_avatar;
    }
}
