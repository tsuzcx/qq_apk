package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kxm;
import lbz;
import lcc;
import lce;
import mjz;
import mkt;
import mmg;

public class ReadInJoyTopicSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, AdapterView.c
{
  private mmg a;
  private lce f = new mjz(this);
  private List<TopicInfo> jg = new ArrayList();
  public List<Map<String, CharSequence>> jh = new ArrayList();
  private View kY;
  private int mFrom;
  
  private static List<Map<String, CharSequence>> X(List<TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TopicInfo localTopicInfo = (TopicInfo)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("key_cover_url", localTopicInfo.jU());
      localHashMap.put("key_title", localTopicInfo.jS());
      localHashMap.put("key_summary", localTopicInfo.jT());
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  private void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.kY = this.mContentView.findViewById(2131379228);
    this.kY.setOnClickListener(this);
    this.a = new mmg(getActivity(), this.jh);
    paramViewGroup = (ListView)this.mContentView.findViewById(2131370584);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.addFooterView(paramLayoutInflater.inflate(2131560490, paramViewGroup, false));
    paramViewGroup.setAdapter(this.a);
    lbz.a().mV(null);
  }
  
  private void aC()
  {
    this.vg.changeBg(true);
    this.leftView.setText(2131690700);
    mkt.a(this);
  }
  
  private void aPC()
  {
    this.kY.setVisibility(0);
  }
  
  private void aPD()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.mFrom);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.b.startForResult(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyUgcSearchTopicFragment.class, 1000);
  }
  
  private void d(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", paramTopicInfo);
    getActivity().setResult(-1, localIntent);
    onBackEvent();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {
      this.mFrom = paramLayoutInflater.getInt("searchTopicFrom");
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560489;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = (TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC");
      if (paramIntent != null) {
        d(paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.kY.setVisibility(8);
      aPD();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jg.size())
    {
      d((TopicInfo)this.jg.get(paramInt));
      paramAdapterView = (TopicInfo)this.jg.get(paramInt);
      if (paramAdapterView == null) {
        break label70;
      }
    }
    label70:
    for (paramLong = paramAdapterView.cO();; paramLong = -1L)
    {
      kxm.a("0X800980A", this.mFrom, paramLong, "0");
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    lcc.a().c(this.f);
  }
  
  public void onResume()
  {
    super.onResume();
    aC();
    aPC();
    lcc.a().b(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment
 * JD-Core Version:    0.7.0.1
 */