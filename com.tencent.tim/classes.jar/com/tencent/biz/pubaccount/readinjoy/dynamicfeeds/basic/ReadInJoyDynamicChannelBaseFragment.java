package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import auwz;
import auwz.b;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lam;
import lan;
import lan.a;
import lap;
import las;
import lbg;
import lbk;
import npi;

public abstract class ReadInJoyDynamicChannelBaseFragment
  extends ReadInJoyBaseFragment
  implements auwz.b, lam, lap
{
  public final String TAG = "ReadInJoyDynamicChannelBaseFragment";
  public XRecyclerView a;
  public String adY = "0X8007626";
  protected String adZ = "0X8007625";
  protected boolean aeK;
  protected boolean aiP = true;
  public int mChannelID = -1;
  protected String mChannelName;
  public int mChannelType;
  protected List<View> mHeaderViews = new ArrayList();
  protected int mSpanCount = 1;
  
  public static npi a(String paramString)
  {
    npi localnpi2 = npi.a(paramString, false);
    npi localnpi1 = localnpi2;
    if (localnpi2 == null) {
      localnpi1 = npi.a(paramString, true);
    }
    return localnpi1;
  }
  
  private void aIr()
  {
    Object localObject1 = a(getServiceId());
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "initOfflineConfig failed, templateFactory is null.");
      return;
    }
    if (((npi)localObject1).getColumnCount() > 0) {
      this.mSpanCount = ((npi)localObject1).getColumnCount();
    }
    localObject1 = ((npi)localObject1).a();
    if (localObject1 != null)
    {
      String str1 = ((lan)localObject1).eF("expose_t_name");
      String str2 = ((lan)localObject1).eF("click_t_name");
      if (!TextUtils.isEmpty(str1)) {
        this.adY = str1;
      }
      if (!TextUtils.isEmpty(str2)) {
        this.adZ = str2;
      }
      str1 = ((lan)localObject1).eF("is_support_pull_refresh");
      if (!TextUtils.isEmpty(str1)) {
        this.aiP = str1.equals("1");
      }
      str1 = ((lan)localObject1).eG("is_need_id_list");
      boolean bool = false;
      if (!TextUtils.isEmpty(str1)) {
        bool = str1.equals("1");
      }
      str1 = ((lan)localObject1).eG("cgi");
      str2 = ((lan)localObject1).eG("request_pre_process");
      String str3 = ((lan)localObject1).eG("receive_pre_process");
      Object localObject2 = new a();
      ((a)localObject2).aea = str1;
      ((a)localObject2).aiQ = bool;
      ((a)localObject2).aeb = str2;
      ((a)localObject2).aec = str3;
      Object localObject3 = lbg.a();
      if (localObject3 != null) {
        ((lbg)localObject3).a(this.mChannelID, (a)localObject2);
      }
      int j = ((lan)localObject1).of();
      localObject2 = new ArrayList();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          localObject3 = ((lan)localObject1).a(i);
          if (localObject3 != null)
          {
            b localb = new b();
            localb.styleID = ((lan.a)localObject3).adW;
            localb.proteusData = ((lan.a)localObject3).adX;
            localb.aea = ((lan)localObject1).k(i, "cgi");
            localb.aeb = ((lan)localObject1).k(i, "request_pre_process");
            localb.aec = ((lan)localObject1).k(i, "receive_pre_process");
            ((List)localObject2).add(localb);
          }
          i += 1;
        }
        localObject1 = lbk.a();
        if (localObject1 != null) {
          ((lbk)localObject1).q(this.mChannelID, (List)localObject2);
        }
      }
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.mSpanCount), "\n", "mExposedTName = ", this.adY, "\n", "mClickTName = ", this.adZ, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.aiP), "\n", "bodyIsNeedIDList = ", Boolean.valueOf(bool), "\n", "bodyCGI = ", str1, "\n", "bodyReqJSMethod = ", str2, "\n", "bodyRecJSMethod = ", str3, "\n", "headerConfigSize = ", Integer.valueOf(j), "\n" });
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.mSpanCount), "\n", "mExposedTName = ", this.adY, "\n", "mClickTName = ", this.adZ, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.aiP), "\n", "config is null." });
  }
  
  public static String bl(int paramInt)
  {
    return "dynamic_feeds_" + paramInt;
  }
  
  private void init()
  {
    aIr();
    this.a = new XRecyclerView(getActivity());
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(this.mSpanCount, 1);
    localStaggeredGridLayoutManager.setGapStrategy(0);
    this.a.a().setLayoutManager(localStaggeredGridLayoutManager);
    this.a.a().setOnBindHeaderObserver(this);
    this.a.a().addOnScrollListener(new las(this, localStaggeredGridLayoutManager));
    initAdapter();
    aIn();
  }
  
  public boolean Bq()
  {
    return true;
  }
  
  public boolean Br()
  {
    return true;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    ie();
  }
  
  public void aCc()
  {
    super.aCc();
  }
  
  public void aIp()
  {
    super.aIp();
    mQ(true);
  }
  
  public void aIq()
  {
    super.aIq();
    mQ(true);
  }
  
  protected void aIs()
  {
    if ((this.mHeaderViews == null) || (this.mHeaderViews.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.mHeaderViews.iterator();
    while (localIterator.hasNext()) {
      cp((View)localIterator.next());
    }
    this.mHeaderViews.clear();
  }
  
  protected void co(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "addHeader.");
    if (!this.mHeaderViews.contains(paramView)) {
      this.mHeaderViews.add(paramView);
    }
    Object localObject = this.a.a();
    if (!((RecyclerViewWithHeaderFooter)localObject).W(paramView)) {
      ((RecyclerViewWithHeaderFooter)localObject).addHeaderView(paramView);
    }
    localObject = (auwz)((RecyclerViewWithHeaderFooter)localObject).getAdapter();
    if (!((auwz)localObject).W(paramView)) {
      ((auwz)localObject).co(paramView);
    }
    notifyDataSetChanged();
  }
  
  protected void cp(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "removeHeader.");
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.a.a();
    localRecyclerViewWithHeaderFooter.al(paramView);
    ((auwz)localRecyclerViewWithHeaderFooter.getAdapter()).cp(paramView);
    notifyDataSetChanged();
  }
  
  protected String getServiceId()
  {
    return "dynamic_feeds_" + this.mChannelID;
  }
  
  protected void mQ(boolean paramBoolean)
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.post(new ReadInJoyDynamicChannelBaseFragment.1(this));
    } while (!paramBoolean);
    this.a.post(new ReadInJoyDynamicChannelBaseFragment.2(this));
  }
  
  public int nh()
  {
    return this.mChannelID;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.mChannelID = paramBundle.getInt("channel_id");
      this.mChannelType = paramBundle.getInt("channel_type");
      this.mChannelName = paramBundle.getString("channel_name");
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 1, new Object[] { "onCreate, mChannelID = ", Integer.valueOf(this.mChannelID), ", mChannelType = ", Integer.valueOf(this.mChannelType), ", mChannelName = ", this.mChannelName });
    init();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.a;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void qc(int paramInt)
  {
    super.qc(paramInt);
    mQ(true);
  }
  
  public static class a
  {
    public String aea;
    public String aeb;
    public String aec;
    public boolean aiQ;
  }
  
  public static class b
  {
    public String aea;
    public String aeb;
    public String aec;
    public String proteusData;
    public String styleID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment
 * JD-Core Version:    0.7.0.1
 */