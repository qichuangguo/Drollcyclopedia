package com.android.cgcxy.drollcyclopedia.fragments;


import android.support.v4.app.Fragment;
import com.android.cgcxy.drollcyclopedia.R;
import com.android.cgcxy.drollcyclopedia.base.BaseFragment;
import com.android.cgcxy.drollcyclopedia.base.Constant;
import com.android.cgcxy.drollcyclopedia.presenter.DataPresenter;
import com.android.cgcxy.drollcyclopedia.presenter.DataPresenterImpl;

/**段子
 * A simple {@link Fragment} subclass.
 */
public class CrosstalkFragment extends BaseFragment implements ShowView{


    public CrosstalkFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_crosstalk;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onAfterActivityCreated() {
        DataPresenterImpl dataPresenter = new DataPresenterImpl(this,getActivity());
        dataPresenter.getData(Constant.CROSSTALKTIME);
    }

}
