package com.android.cgcxy.drollcyclopedia.fragments;


import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.android.cgcxy.drollcyclopedia.base.BaseVolleyData;
import com.android.cgcxy.drollcyclopedia.Choiceness.adapter.ChoicenessAdapter;
import com.android.cgcxy.drollcyclopedia.Choiceness.entity.ChoicenessEntity;
import com.android.cgcxy.drollcyclopedia.Choiceness.entity.ChoicenessListEntity;
import com.android.cgcxy.drollcyclopedia.R;
import com.android.cgcxy.drollcyclopedia.base.BaseFragment;
import com.android.cgcxy.drollcyclopedia.base.Constant;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 精选
 * A simple {@link Fragment} subclass.
 */
public class ChoicenessFragment extends BaseFragment {

    private ChoicenessListEntity mChoicenessListEntity = new ChoicenessListEntity();
    private List<ChoicenessEntity> mChoicenessEntity = new ArrayList<>();

    private ListView lv_fragment_choiceness;
    private ChoicenessAdapter mChoicenessAdapter;

    public ChoicenessFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_choiceness;
    }

    @Override
    protected void initView() {
        lv_fragment_choiceness = (ListView) getView().findViewById(R.id.lv_fragment_choiceness);
    }

    @Override
    protected void onAfterActivityCreated() {

        BaseVolleyData.getJSONObject(Constant.SELECTION_URL, new BaseVolleyData.VolleyJsonCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                mChoicenessListEntity.initWithJson(result);
                mChoicenessEntity.addAll(mChoicenessListEntity.mChoicenessEntities);
                mChoicenessAdapter = new ChoicenessAdapter(mActivity, mChoicenessEntity);
                lv_fragment_choiceness.setAdapter(mChoicenessAdapter);

            }
        });
    }
}
