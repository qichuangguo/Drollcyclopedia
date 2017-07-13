package com.android.cgcxy.drollcyclopedia.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.cgcxy.drollcyclopedia.R;
import com.android.cgcxy.drollcyclopedia.bean.CrosstalkBean;
import com.android.cgcxy.drollcyclopedia.mode.RefreshListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/13.
 */

public class CrosstalkRecycleAdapter extends RecyclerView.Adapter<CrosstalkRecycleAdapter.ViewHold> {

    public void setCrosstalkBean(List<CrosstalkBean> crosstalkBean) {
        this.crosstalkBean = crosstalkBean;
    }

    private Context mContext;
    public List<CrosstalkBean> crosstalkBean;

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.crosstalk_recycle_item, parent,false);
        ViewHold viewHold = new ViewHold(inflate);
        return viewHold;
    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {
        if (crosstalkBean==null){
            return;
        }
        String content = crosstalkBean.get(position).getContent();
        System.out.println("======content===="+content);
        holder.tv_content.setText(content);
        holder.tv_name.setText(crosstalkBean.get(position).getUser_name());
        Picasso.with(mContext).load(crosstalkBean.get(position).getAvatar()).into(holder.image_ico);
    }

    @Override
    public int getItemCount() {
        if (crosstalkBean!=null && crosstalkBean.size()>0){
            return crosstalkBean.size();
        }
        return 0;
    }

    public class ViewHold extends RecyclerView.ViewHolder{

        protected TextView tv_content,tv_name;
        protected ImageView image_ico;

        public ViewHold(View itemView) {
            super(itemView);
            tv_content= (TextView) itemView.findViewById(R.id.tv_content);
            image_ico= (ImageView) itemView.findViewById(R.id.image_ico);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);

        }
    }


}
