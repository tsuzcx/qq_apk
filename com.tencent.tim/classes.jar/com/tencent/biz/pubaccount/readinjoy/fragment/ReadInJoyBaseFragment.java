package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqnm;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.c;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.a;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kfv;
import kxm;
import kxm.b;
import lbz;
import lcc;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import mst;
import org.json.JSONException;

public abstract class ReadInJoyBaseFragment
  extends PublicBaseFragment
  implements KandianMergeManager.c
{
  public static final HashMap<Integer, Integer> dg = new HashMap();
  public final String TAG = "ReadInJoyBaseFragment";
  protected a a;
  ReadinjoyTabFrame.a a;
  protected boolean ajy;
  protected boolean ajz;
  protected KandianMergeManager b = (KandianMergeManager)this.mApp.getManager(162);
  protected QQAppInterface mApp = (QQAppInterface)kxm.getAppRuntime();
  int mChannelCoverId;
  LayoutInflater mInflater;
  private int mPos = -1;
  
  private void aKE()
  {
    View localView = getView();
    if (localView != null) {
      if (!Bq()) {
        break label55;
      }
    }
    label55:
    for (int i = ox();; i = 0)
    {
      if (Br()) {}
      for (int j = oy();; j = 0)
      {
        if ((i > 0) || (j > 0)) {
          localView.setPadding(0, i, 0, j);
        }
        return;
      }
    }
  }
  
  public static void cn(int paramInt1, int paramInt2)
  {
    dg.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public static int di(int paramInt)
  {
    Integer localInteger = (Integer)dg.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  private void n(MessageRecord paramMessageRecord)
  {
    if ((awit.aMH()) && ((getActivity() instanceof SplashActivity))) {
      return;
    }
    o(paramMessageRecord);
    this.b.m(paramMessageRecord);
    this.b.aIM();
  }
  
  private void o(MessageRecord paramMessageRecord)
  {
    if ((awit.Vs()) && ((this instanceof ReadInJoyRecommendFeedsFragment))) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyBaseFragment.1(this, paramMessageRecord));
    }
  }
  
  public boolean BR()
  {
    return this.ajy;
  }
  
  public boolean BS()
  {
    return false;
  }
  
  public boolean BT()
  {
    return false;
  }
  
  protected boolean Bq()
  {
    return (this.ajz) && (((this instanceof ReadInJoyViolaChannelFragment)) || ((this instanceof ReadInJoyBBCircleFragment)) || ((this instanceof ReadInJoyFragmentWithSubChannel)));
  }
  
  protected boolean Br()
  {
    return (this.ajz) && (((this instanceof ReadInJoyViolaChannelFragment)) || ((this instanceof ReadInJoyFragmentWithSubChannel)) || ((this instanceof ReadInJoySubChannelFragment)));
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$a = parama;
  }
  
  public void a(ReadinjoyTabFrame.a parama, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$a = parama;
    this.mChannelCoverId = paramInt;
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    n(paramMessageRecord);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    QLog.d(ReadInJoyBaseFragment.class.getSimpleName(), 2, getClass().getSimpleName() + " notifyShowSelf");
    if (this.b == null)
    {
      this.mApp = ((QQAppInterface)kxm.getAppRuntime());
      this.b = ((KandianMergeManager)this.mApp.getManager(162));
    }
    this.b.a(this);
    mst.a().setChannelId(nh());
    int i;
    if (this.ajz)
    {
      i = nh();
      if (i != -1)
      {
        kfv.oI(i);
        paramActivity = kfv.b(i);
        if (paramActivity == null) {
          break label190;
        }
        dg.put(Integer.valueOf(i), paramActivity);
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "notifyShowSelf, channelID = ", Integer.valueOf(i), ", entryPath = ", Integer.valueOf(di(i)) });
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$a.np(true);
      }
      return;
      label190:
      dg.put(Integer.valueOf(i), Integer.valueOf(2));
      try
      {
        kfv.G("0X8009B94", "", new kxm.b().a("source", "301").a(i).b("style", 0).build());
      }
      catch (JSONException paramActivity)
      {
        QLog.d("ReadInJoyBaseFragment", 2, "report click channel bar exception, e = ", paramActivity);
      }
    }
  }
  
  public void aCc()
  {
    QLog.d(ReadInJoyBaseFragment.class.getSimpleName(), 2, getClass().getSimpleName() + " notifyHideSelf");
    if (this.b == null)
    {
      this.mApp = ((QQAppInterface)kxm.getAppRuntime());
      this.b = ((KandianMergeManager)this.mApp.getManager(162));
    }
    this.b.b(this);
    if (this.ajz)
    {
      int i = nh();
      if ((i != -1) && (kfv.dc(i))) {
        aCe();
      }
      if (i != -1) {
        kfv.i(i, this.mPos, jp());
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$a.np(false);
    }
  }
  
  public void aCe() {}
  
  public void aIp() {}
  
  public void aIq() {}
  
  public void aKD() {}
  
  public void aw(Bundle paramBundle) {}
  
  public void f(MessageRecord paramMessageRecord)
  {
    n(paramMessageRecord);
  }
  
  public void finish()
  {
    getActivity().finish();
  }
  
  public void g(MessageRecord paramMessageRecord)
  {
    lbz.a().aJm();
    n(paramMessageRecord);
  }
  
  public int getPos()
  {
    return this.mPos;
  }
  
  public void i(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String jp()
  {
    return "0";
  }
  
  public abstract int nh();
  
  public void no(boolean paramBoolean)
  {
    this.ajz = paramBoolean;
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    lcc.a().a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    this.b = ((KandianMergeManager)this.mApp.getManager(162));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mInflater = paramLayoutInflater;
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.b != null)
      {
        this.b.b(this);
        this.b = null;
      }
      this.mApp = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onStart()
  {
    super.onStart();
    aKE();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public int ox()
  {
    try
    {
      Resources localResources = getActivity().getResources();
      i = localResources.getDimensionPixelSize(2131299627);
      j = localResources.getDimensionPixelSize(2131299219);
      int k = localResources.getDimensionPixelSize(2131299221);
      int m = ImmersiveUtils.getStatusBarHeight(getActivity());
      i = k + (i + j) + m;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        localException.printStackTrace();
        int i = 0;
      }
    }
    j = i;
    if (i <= 0) {
      j = aqnm.dpToPx(80.5F) + ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    return j;
  }
  
  public int oy()
  {
    try
    {
      int i = getActivity().getResources().getDimensionPixelSize(2131297695);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void qc(int paramInt) {}
  
  public void setPos(int paramInt)
  {
    this.mPos = paramInt;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, isVisibleToUser = ", Boolean.valueOf(paramBoolean), ", mIsShowingSelf = ", Boolean.valueOf(this.ajy) });
    this.ajy = paramBoolean;
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, mChannelID = ", Integer.valueOf(nh()) });
    if (paramBoolean)
    {
      a(false, getActivity(), null);
      return;
    }
    aCc();
  }
  
  public static abstract interface a
  {
    public abstract void np(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment
 * JD-Core Version:    0.7.0.1
 */