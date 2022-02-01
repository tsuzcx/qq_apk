package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import apgy;
import apgz;
import apgz.a;
import arhz;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;

public class BeginnerGuideFragment
  extends PublicBaseFragment
  implements ComplexGuidViewPager.a
{
  private arhz jdField_a_of_type_Arhz;
  private a jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiBeginnerGuideFragment$a;
  protected ComplexGuidViewPager a;
  private boolean aMH;
  private int dUh;
  private QQAppInterface mApp;
  private Bundle mArguments;
  private View mContentView;
  
  private void WJ(int paramInt)
  {
    bF();
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, new Object[] { "onBeginnerGuidePreparedFailed (" + paramInt + ") ", Log.getStackTraceString(new RuntimeException("trace")) });
    }
    getActivity().finish();
  }
  
  private boolean aBc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment prepareBeginnerGuideForSubmit");
    }
    if ((!this.aMH) && (this.dUh >= 0)) {
      switch (this.dUh)
      {
      case 5: 
      case 6: 
      default: 
        str2 = "";
        str1 = "";
        i = -1000;
        if ((i < 0) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
          WJ(-1000);
        }
        break;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        String str2;
        String str1;
        int i;
        for (;;)
        {
          return false;
          str2 = "https://sqimg.qq.com/qq_product_operations/qq_troop_homework/beginner_guide_src/submit_arithmetic.zip";
          str1 = "986db0ad9ec2954f958193a7c819463f";
          i = this.dUh;
          continue;
          str2 = "https://sqimg.qq.com/qq_product_operations/qq_troop_homework/beginner_guide_src/submit_recite.zip";
          str1 = "df711d27a3d4a9de6cce3e1eb2254878";
          i = this.dUh;
        }
        try
        {
          String str3 = new File(new URL(str2).getFile()).getName();
          new apgy(this.mApp, str2, str3, str1).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiBeginnerGuideFragment$a, i, false);
          return true;
        }
        catch (Exception localException) {}
      } while (!QLog.isColorLevel());
      QLog.d("BeginnerGuideFragment", 2, "download manager init error ", localException);
      return false;
    }
    QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment prepareBeginnerGuideForSubmit failed");
    return false;
  }
  
  public static void e(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("BeginnerGuideFragment:page_type", true);
    localIntent.putExtra("BeginnerGuideFragment:hw_type", paramInt);
    PublicFragmentActivity.start(paramActivity, localIntent, BeginnerGuideFragment.class);
    paramActivity.overridePendingTransition(2130772367, 2130772002);
  }
  
  public static void f(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("BeginnerGuideFragment:page_type", false);
    localIntent.putExtra("BeginnerGuideFragment:hw_type", paramInt);
    PublicFragmentActivity.start(paramActivity, localIntent, BeginnerGuideFragment.class);
    paramActivity.overridePendingTransition(2130772367, 2130772002);
  }
  
  private void gj(String paramString, int paramInt)
  {
    bF();
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "onBeginnerGuidePrepared, " + paramString + ", " + paramInt);
    }
    refreshUI();
  }
  
  private void refreshUI()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager == null) {
      return;
    }
    apgz localapgz = ((TroopManager)this.mApp.getManager(52)).a;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localapgz != null)
    {
      if (!this.aMH) {
        break label135;
      }
      localObject1 = localObject2;
      switch (this.dUh)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    while ((localObject1 != null) && (((apgz.a)localObject1).cpa != null) && (((apgz.a)localObject1).BW != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setData(((apgz.a)localObject1).cpa, ((apgz.a)localObject1).BW);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.invalidate();
      return;
      localObject1 = localapgz.b;
      continue;
      localObject1 = localapgz.a;
      continue;
      label135:
      switch (this.dUh)
      {
      case 5: 
      case 6: 
      default: 
        localObject1 = localObject2;
        break;
      case 4: 
        localObject1 = localapgz.c;
        break;
      case 7: 
        localObject1 = localapgz.d;
      }
    }
  }
  
  protected void am(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_Arhz == null)
        {
          this.jdField_a_of_type_Arhz = new arhz(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Arhz.setCancelable(false);
          this.jdField_a_of_type_Arhz.show();
        }
        this.jdField_a_of_type_Arhz.setMessage(paramInt);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setVisibility(4);
    }
  }
  
  protected void bF()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Arhz.dismiss();
      label24:
      this.jdField_a_of_type_Arhz = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void dZw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment onActionBtnClicked");
    }
    getActivity().doOnBackPressed();
  }
  
  public void dZx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment onSkitBtnClicked");
    }
    dZw();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    getActivity().getWindow().addFlags(67108864);
    super.onActivityCreated(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment create view");
    }
    this.mApp = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiBeginnerGuideFragment$a = new a(this, Looper.myLooper());
    this.mArguments = getArguments();
    if (this.mArguments != null)
    {
      this.dUh = this.mArguments.getInt("BeginnerGuideFragment:hw_type", -1000);
      if (!this.mArguments.containsKey("BeginnerGuideFragment:page_type")) {
        break label184;
      }
      this.aMH = this.mArguments.getBoolean("BeginnerGuideFragment:page_type", true);
    }
    for (;;)
    {
      boolean bool = aBc();
      this.mContentView = paramLayoutInflater.inflate(2131560808, paramViewGroup, false);
      if (this.mContentView == null) {
        getActivity().finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager = ((ComplexGuidViewPager)this.mContentView.findViewById(2131365124));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setOnActionBtnClickListener(this);
      refreshUI();
      if (bool) {
        am(2131699653);
      }
      paramLayoutInflater = this.mContentView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label184:
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment create view failed, cannot determine which page to show");
      }
      getActivity().finish();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiBeginnerGuideFragment$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiBeginnerGuideFragment$a.removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772002, 2130772369);
  }
  
  static class a
    extends Handler
  {
    private WeakReference<BeginnerGuideFragment> ia;
    
    a(BeginnerGuideFragment paramBeginnerGuideFragment, Looper paramLooper)
    {
      super();
      this.ia = new WeakReference(paramBeginnerGuideFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      BeginnerGuideFragment localBeginnerGuideFragment = (BeginnerGuideFragment)this.ia.get();
      if (localBeginnerGuideFragment == null) {}
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1110: 
          if (QLog.isColorLevel()) {
            QLog.d("BeginnerGuideFragment", 2, "parse config from network success");
          }
          break;
        }
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
      BeginnerGuideFragment.a(localBeginnerGuideFragment, (String)paramMessage.obj, paramMessage.arg1);
      return;
      BeginnerGuideFragment.a(localBeginnerGuideFragment, paramMessage.what);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment
 * JD-Core Version:    0.7.0.1
 */