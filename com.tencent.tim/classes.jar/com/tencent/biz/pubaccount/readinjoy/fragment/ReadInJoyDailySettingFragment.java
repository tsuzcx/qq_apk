package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import awit;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import kww;
import lik;
import org.json.JSONArray;
import org.json.JSONException;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private List<lik> P = new ArrayList();
  private final String TAG = "ReadInJoyDailySettingFragment";
  private kww b;
  private List<lik> gL = new ArrayList();
  private RecyclerView h;
  
  private void aKR()
  {
    lik locallik = new lik();
    locallik.key = "open_reason";
    locallik.id = ((String)awit.f("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)awit.f("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {}
    for (;;)
    {
      locallik.jdField_if = new ArrayList();
      locallik.jdField_if.add("");
      locallik.eS = new ArrayList();
      locallik.eS.add("");
      locallik.eS.add("1");
      locallik.eS.add("0");
      this.gL.add(locallik);
      return;
      if (!"0".equals(str)) {
        locallik.value = "";
      }
    }
  }
  
  private void aKS()
  {
    Object localObject = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
    if (localObject != null) {
      try
      {
        localObject = new JSONArray((String)localObject);
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            lik locallik = lik.a(((JSONArray)localObject).optJSONObject(i));
            this.P.add(locallik);
            i += 1;
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void aKT()
  {
    aKR();
    aKS();
    this.b.notifyDataSetChanged();
  }
  
  private void initUI()
  {
    if (this.mContentView != null)
    {
      this.h = ((RecyclerView)this.mContentView.findViewById(2131370014));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      this.h.setLayoutManager(localLinearLayoutManager);
      this.b = new kww(getActivity(), this.P, this.gL);
      this.h.setAdapter(this.b);
      aKT();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560343;
  }
  
  public void onDestroy()
  {
    int j = 0;
    JSONArray localJSONArray;
    int i;
    if (this.gL.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = 0;
      while (i < this.gL.size())
      {
        localJSONArray.put(((lik)this.gL.get(i)).toJSONObject());
        i += 1;
      }
      awit.H("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.P.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.P.size())
      {
        localJSONArray.put(((lik)this.P.get(i)).toJSONObject());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    lik.ju();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailySettingFragment
 * JD-Core Version:    0.7.0.1
 */