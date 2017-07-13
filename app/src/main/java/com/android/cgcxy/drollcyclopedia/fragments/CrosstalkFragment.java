package com.android.cgcxy.drollcyclopedia.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.cgcxy.drollcyclopedia.R;
import com.android.cgcxy.drollcyclopedia.adapter.CrosstalkRecycleAdapter;
import com.android.cgcxy.drollcyclopedia.base.BaseFragment;
import com.android.cgcxy.drollcyclopedia.base.Constant;
import com.android.cgcxy.drollcyclopedia.bean.CrosstalkBean;
import com.android.cgcxy.drollcyclopedia.presenter.DataPresenterImpl;

import java.util.List;

/**段子
 * A simple {@link Fragment} subclass.
 */
public class CrosstalkFragment extends BaseFragment implements ShowView{


    private RecyclerView recyclerView;
    private CrosstalkRecycleAdapter adapter;

    public CrosstalkFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_crosstalk;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CrosstalkRecycleAdapter();
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onAfterActivityCreated() {

        DataPresenterImpl dataPresenter = new DataPresenterImpl(this,getActivity());
        dataPresenter.getCrosstalkTimeJsonData(Constant.CROSSTALKTIME);
    }

    @Override
    public <T> void setData(T t) {
        adapter.setCrosstalkBean((List<CrosstalkBean>)t);
        adapter.notifyDataSetChanged();

    }
}
