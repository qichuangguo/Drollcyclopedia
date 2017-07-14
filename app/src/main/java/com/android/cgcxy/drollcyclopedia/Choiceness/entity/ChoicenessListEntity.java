package com.android.cgcxy.drollcyclopedia.Choiceness.entity;

import com.android.cgcxy.drollcyclopedia.base.BaseEntity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26092 on 2017/7/13.
 * 精选
 */

public class ChoicenessListEntity extends BaseEntity{
    public List<ChoicenessEntity> mChoicenessEntities=new ArrayList<>();

    @Override
    public void initWithJson(JSONObject jsonObject) {
        if(null!=jsonObject){
            JSONArray jsonArray=optJSONArray(jsonObject,"data");
            if(null!=jsonArray){
                for (int i=0;i<jsonArray.length();i++){
                    ChoicenessEntity choicenessEntity=new ChoicenessEntity();
                    choicenessEntity.initWithJson(optJSONObject(jsonArray,i));
                    mChoicenessEntities.add(choicenessEntity);
                }
            }
        }
    }
}
