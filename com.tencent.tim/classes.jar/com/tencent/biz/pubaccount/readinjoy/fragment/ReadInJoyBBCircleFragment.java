package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.a;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kbp;
import kfs;
import kfv;
import kni;
import kvv;
import kxm;
import kxy;
import lal;
import lbz;
import lcd;
import lcm;
import mqq.app.AppRuntime;
import nny;

public class ReadInJoyBBCircleFragment
  extends ReadInJoyBaseFragment
  implements KandianSubscribeManager.a
{
  protected kfs a;
  private kxy b = new kxy();
  private boolean hasInit;
  private View mContentView;
  private Context mContext;
  
  private void aKB()
  {
    Object localObject = getActivity();
    if (localObject == null) {}
    KandianRedDotInfo localKandianRedDotInfo;
    do
    {
      return;
      localObject = ((Activity)localObject).getIntent();
      localKandianRedDotInfo = KandianSubscribeManager.f();
    } while (localKandianRedDotInfo == null);
    ((Intent)localObject).putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
  }
  
  private void aKC()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyBBCircleFragment.1(this));
  }
  
  private void init()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.hasInit;
        if (bool) {
          return;
        }
        if ((this.mContext == null) || (this.mContentView == null)) {
          continue;
        }
        Object localObject = (ViewGroup)this.mContentView.findViewById(2131376777);
        this.jdField_a_of_type_Kfs = ((kfs)kxm.dy.remove(Integer.valueOf(70)));
        if (this.jdField_a_of_type_Kfs == null)
        {
          this.jdField_a_of_type_Kfs = new kfs((Activity)this.mContext);
          this.jdField_a_of_type_Kfs.oD(70);
          this.jdField_a_of_type_Kfs.setChannelType(0);
          this.jdField_a_of_type_Kfs.i((ViewGroup)localObject);
          this.jdField_a_of_type_Kfs.onCreate();
          this.jdField_a_of_type_Kfs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$a, this.mChannelCoverId);
          localObject = this.jdField_a_of_type_Kfs.af();
          if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
            ((ReadInJoyBaseListViewGroup)localObject).aWc();
          }
          lcm.a(0, kvv.D(), 0);
          ((KandianSubscribeManager)kxm.getAppRuntime().getManager(280)).a(this);
          this.hasInit = true;
          continue;
        }
        this.jdField_a_of_type_Kfs.i(localViewGroup);
      }
      finally {}
      this.jdField_a_of_type_Kfs.aBZ();
      this.jdField_a_of_type_Kfs.aBY();
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (!this.hasInit) {
      init();
    }
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onResume();
    }
    QLog.d("ReadInJoyBBCircleFragment", 2, "[notifyShowSelf] show!");
    aKB();
    kbp.a(null, "", "0X80093F0", "0X80093F0", 0, 0, "", "", "", "", false);
    ((KandianSubscribeManager)kxm.getAppRuntime().getManager(280)).a(this);
    if ((this.jdField_a_of_type_Kfs != null) && ((this.jdField_a_of_type_Kfs.af() instanceof ReadInJoyListViewGroup)))
    {
      paramActivity = ((ReadInJoyListViewGroup)this.jdField_a_of_type_Kfs.af()).bf().iterator();
      while (paramActivity.hasNext())
      {
        paramBundle = (nny)paramActivity.next();
        if ((paramBundle instanceof ReadInJoyDiandianHeaderController)) {
          paramBundle.onRefresh();
        }
      }
    }
  }
  
  public void aCc()
  {
    super.aCc();
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onPause();
    }
  }
  
  public void aCe()
  {
    super.aCe();
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.aCe();
    }
  }
  
  public void aCv()
  {
    aKB();
  }
  
  public void aIq()
  {
    super.aIq();
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.lP(true);
    }
  }
  
  public int nh()
  {
    return 70;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    View localView = this.jdField_a_of_type_Kfs.af();
    if (((localView instanceof ReadInJoyListViewGroup)) && (((ReadInJoyListViewGroup)localView).onBackPressed())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    if ((this.mContext != null) && (Build.VERSION.SDK_INT >= 11)) {
      ((Activity)this.mContext).getWindow().setFlags(16777216, 16777216);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mContentView = paramLayoutInflater.inflate(2131560381, paramViewGroup, false);
    if ((!getUserVisibleHint()) && (kxm.AR())) {}
    for (;;)
    {
      VideoReport.setPageId(this.mContentView, "8014");
      VideoReport.setPageParams(this.mContentView, new lal().a(70L).a());
      paramLayoutInflater = this.mContentView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      init();
    }
  }
  
  public void onDestroy()
  {
    aKC();
    super.onDestroy();
    lbz.a().aJg();
    if (this.jdField_a_of_type_Kfs != null)
    {
      this.jdField_a_of_type_Kfs.onDestroy();
      localObject = this.jdField_a_of_type_Kfs.af();
      if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
        ((ReadInJoyBaseListViewGroup)localObject).aWd();
      }
    }
    this.jdField_a_of_type_Kfs = null;
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject != null)
    {
      localObject = (lcd)((QQAppInterface)localObject).getManager(163);
      if ((localObject != null) && (((lcd)localObject).b() != null))
      {
        localObject = ((lcd)localObject).b().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).aMy();
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    ((KandianSubscribeManager)kxm.getAppRuntime().getManager(280)).b(this);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.aBZ();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Kfs != null) && (this.ajy)) {
      this.jdField_a_of_type_Kfs.onResume();
    }
    kni.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onStart();
    }
    this.b.wakeUp();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onStop();
    }
    if (!BaseActivity.mAppForground) {
      this.b.aIc();
    }
    if (getActivity().isFinishing())
    {
      lcm.a(1, kvv.D(), 0);
      kvv.aHA();
    }
  }
  
  public void qc(int paramInt)
  {
    super.qc(paramInt);
    if (this.jdField_a_of_type_Kfs != null)
    {
      this.jdField_a_of_type_Kfs.lP(true);
      return;
    }
    kfv.oK(nh());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */