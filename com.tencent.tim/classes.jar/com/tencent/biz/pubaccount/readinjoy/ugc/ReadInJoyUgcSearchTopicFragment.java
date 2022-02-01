package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import awit;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo.a;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kxm;
import lbz;
import lcc;
import lce;
import mka;
import mkb;
import mkc;
import mkd;
import mke;
import mkf;
import mkg;
import mkh;
import mkt;
import mmg;

public class ReadInJoyUgcSearchTopicFragment
  extends PublicBaseFragment
  implements AdapterView.OnItemClickListener
{
  private EditText I;
  private final String TAG = "ReadInJoyUgcSearchTopicFragment";
  private String ajk;
  private final String ajl = "";
  private boolean ani;
  private mmg b;
  private long gR;
  private TextWatcher h = new mkc(this);
  private lce i = new mkb(this);
  private List<Map<String, CharSequence>> ji = new ArrayList();
  private List<TopicInfo> jj = new ArrayList();
  private View kZ;
  private View la;
  private int mFrom;
  private ListView mListView;
  private lce mObserver = new mka(this);
  
  private Map<String, CharSequence> F()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_cover_url", "create_topic");
    localHashMap.put("key_title", "#" + this.ajk);
    localHashMap.put("key_summary", "");
    return localHashMap;
  }
  
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
  
  private void aLz()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.mListView.getWindowToken(), 0);
    }
  }
  
  private void aPE()
  {
    this.I.setText("");
  }
  
  private void cL(View paramView)
  {
    paramView.setOnClickListener(new mkd(this));
  }
  
  private void cM(View paramView)
  {
    paramView.findViewById(2131364098).setOnClickListener(new mke(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void cN(View paramView)
  {
    this.I = ((EditText)paramView.findViewById(2131379228));
    this.I.setOnTouchListener(new mkh(this));
    this.I.addTextChangedListener(this.h);
    this.I.requestFocus();
  }
  
  private void d(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", paramTopicInfo);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  private void initListView(View paramView)
  {
    this.mListView = ((ListView)paramView.findViewById(2131370593));
    this.mListView.getLayoutParams().height = -1;
    this.kZ = paramView.findViewById(2131370575);
    this.la = paramView.findViewById(2131366438);
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnTouchListener(new mkf(this));
    this.b = new mmg(getActivity(), this.ji);
    this.b.setViewBinder(new mkg(this));
    paramView = LayoutInflater.from(getActivity()).inflate(2131560490, this.mListView, false);
    this.mListView.addFooterView(paramView, null, false);
    this.mListView.setDivider(null);
    this.mListView.setAdapter(this.b);
  }
  
  private void n(List<String> paramList, List<TopicInfo> paramList1)
  {
    if ((paramList1.size() > 0) && (paramList.size() > 0) && (TextUtils.equals((CharSequence)paramList.get(0), this.ajk)))
    {
      this.kZ.setVisibility(0);
      this.la.setVisibility(4);
      this.jj.clear();
      this.jj.addAll(paramList1);
      this.ji.clear();
      this.ji.addAll(X(paramList1));
      this.b.notifyDataSetChanged();
      kxm.a(this.mFrom, this.jj, "0");
    }
    while (TextUtils.isEmpty(this.ajk)) {
      return;
    }
    this.kZ.setVisibility(0);
    this.jj.clear();
    this.ji.clear();
    if (awit.aMI())
    {
      this.jj.add(TopicInfo.a().a(true).b(this.gR).c("https://sqimg.qq.com/qq_product_operations/kan/images/topic-cover-default.jpg").d("https://sqimg.qq.com/qq_product_operations/kan/images/topic-head-default.jpg").b("").a(this.ajk).a());
      this.ji.add(F());
    }
    this.b.notifyDataSetChanged();
    kxm.a(this.mFrom, this.jj, "1");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2130772077, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.gR = kxm.getLongAccountUin();
    lcc.a().b(this.mObserver);
    lcc.a().b(this.i);
    paramLayoutInflater = paramLayoutInflater.inflate(2131560495, paramViewGroup, false);
    cN(paramLayoutInflater);
    initListView(paramLayoutInflater);
    cM(paramLayoutInflater);
    cL(paramLayoutInflater);
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.mFrom = paramViewGroup.getInt("searchTopicFrom");
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    lcc.a().c(this.mObserver);
    lcc.a().c(this.i);
    super.onDestroyView();
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130772080);
    super.onFinish();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jj.size() == paramInt) {}
    while (this.ani)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (this.jj.size() == 1) {}
    for (TopicInfo localTopicInfo1 = (TopicInfo)this.jj.get(0);; localTopicInfo1 = null)
    {
      if ((localTopicInfo1 != null) && (localTopicInfo1.DF()))
      {
        this.ani = true;
        lbz.a().b(localTopicInfo1);
        break;
      }
      d((TopicInfo)this.jj.get(paramInt));
      TopicInfo localTopicInfo2 = (TopicInfo)this.jj.get(paramInt);
      if (localTopicInfo1 != null) {}
      for (long l = localTopicInfo2.cO();; l = -1L)
      {
        kxm.a("0X800980A", this.mFrom, l, "0");
        break;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    mkt.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment
 * JD-Core Version:    0.7.0.1
 */