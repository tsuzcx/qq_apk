package com.tencent.mobileqq.extendfriend.fragment;

import acku;
import afsg;
import afsi;
import afsi.a;
import afsr;
import afux;
import afuy;
import afuz;
import afva;
import afwz;
import afxn;
import afxv;
import afxx;
import aizy;
import altq;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.a;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import jll.a;

public class ExtendFriendFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SimpleSlidingIndicator.a, SimpleSlidingIndicator.b
{
  private static volatile boolean caZ;
  private static volatile boolean cba = true;
  private View Cc;
  private View Cd;
  private TextView RL;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private ExtendFriendCampusFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment;
  private a jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$a = new afuz(this);
  private ExtendFriendSquareFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
  private ExtendFriendLimitChatMatchFragment jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
  private afsi jdField_b_of_type_Afsi;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private afsr c = new afuy(this);
  private ViewGroup cJ;
  private int cUF = -1;
  private int cUG = -1;
  private int cUH = -1;
  private boolean cbb;
  private boolean cbc;
  private acku jdField_d_of_type_Acku = new afux(this);
  private Fragment jdField_d_of_type_AndroidSupportV4AppFragment;
  private String[] eZ;
  private DialogInterface.OnDismissListener g = new afva(this);
  private long ie;
  private boolean isDestroyed;
  private int[] ld;
  private FragmentActivity mActivity;
  private QQAppInterface mApp;
  private ViewGroup mContainer;
  private FragmentManager mFragmentManager;
  
  private void Ns(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendFragment", 2, String.format("redDotTouchClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    altq localaltq = (altq)this.mApp.getManager(36);
    Object localObject = "";
    if (this.cUG == paramInt) {
      localObject = "7720.772001";
    }
    for (;;)
    {
      localaltq.OS((String)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) && (this.ld.length > paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.tC(this.ld[paramInt]);
      }
      dcK();
      return;
      if (this.cUF == paramInt)
      {
        String str = "7720.772003";
        BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("7720.772003");
        localObject = str;
        if (localAppInfo != null)
        {
          localObject = str;
          if (localAppInfo.num.get() > 0)
          {
            localObject = new LpReportInfo_pf00064();
            ((LpReportInfo_pf00064)localObject).actionType = 230;
            ((LpReportInfo_pf00064)localObject).subactionType = 2;
            ((LpReportInfo_pf00064)localObject).reserves = 1;
            LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
            localObject = str;
          }
        }
      }
    }
  }
  
  static void dcA()
  {
    cba = false;
  }
  
  private void dcB()
  {
    if ((this.isDestroyed) || (this.cbb)) {
      return;
    }
    this.cbb = true;
    dcE();
    dcF();
    dcM();
    dcK();
    dcC();
  }
  
  private void dcC()
  {
    if (this.mApp != null)
    {
      altq localaltq = (altq)this.mApp.getManager(36);
      if (localaltq.getAppInfoByPath("7720.772001").iNewFlag.get() == 1)
      {
        localaltq.OS("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.postDelayed(new ExtendFriendFragment.5(this), 1500L);
      }
    }
  }
  
  private void dcD()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new ExtendFriendFragment.6(this));
  }
  
  private void dcE()
  {
    String[] arrayOfString = new String[10];
    int[] arrayOfInt = new int[10];
    if (this.jdField_b_of_type_Afsi != null)
    {
      afsi.a locala = this.jdField_b_of_type_Afsi.a();
      if ((locala == null) || (locala.cTZ != 1)) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((caZ) && (cba))
      {
        arrayOfString[0] = getString(2131701093);
        arrayOfInt[0] = 2131366593;
        this.cUF = 0;
      }
      for (int j = 1;; j = 0)
      {
        arrayOfString[j] = getString(2131701202);
        arrayOfInt[j] = 2131366601;
        this.cUG = j;
        j += 1;
        if (i != 0)
        {
          arrayOfString[j] = getString(2131701162);
          arrayOfInt[j] = 2131366594;
          this.cUH = j;
        }
        for (i = j + 1;; i = j)
        {
          if (i == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
            this.RL.setText(getString(2131701202));
            this.RL.setVisibility(0);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabClickListener(this);
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(0);
            this.RL.setVisibility(8);
            this.eZ = new String[i];
            this.ld = new int[i];
            System.arraycopy(arrayOfString, 0, this.eZ, 0, i);
            System.arraycopy(arrayOfInt, 0, this.ld, 0, i);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.eZ, this.ld);
          }
        }
      }
    }
  }
  
  private void dcF()
  {
    if (this.cJ != null) {
      this.cJ.setVisibility(0);
    }
    if (this.cUF == 0) {
      dcH();
    }
    while (this.cUG != 0) {
      return;
    }
    dcG();
  }
  
  private void dcG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadSquareFragment");
    }
    if (this.mFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = new ExtendFriendSquareFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.Np(this.cUG);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$a);
      }
      if (this.jdField_d_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        break label155;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.isAdded()) {
        break label127;
      }
      this.mFragmentManager.beginTransaction().hide(this.jdField_d_of_type_AndroidSupportV4AppFragment).add(2131365382, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, "squareFragment").commitAllowingStateLoss();
    }
    for (;;)
    {
      dcJ();
      this.jdField_d_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
      return;
      label127:
      this.mFragmentManager.beginTransaction().hide(this.jdField_d_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).commitAllowingStateLoss();
    }
    label155:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.dcj();
  }
  
  private void dcH()
  {
    QLog.d("ExtendFriendFragment", 2, "loadExtendFeedsFragment");
    if (this.mFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment = new ExtendFriendCampusFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.Np(this.cUF);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$a);
      }
      if (this.jdField_d_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment) {
        break label160;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.isAdded()) {
        break label132;
      }
      this.mFragmentManager.beginTransaction().hide(this.jdField_d_of_type_AndroidSupportV4AppFragment).add(2131365382, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment, "campusFragment").commitAllowingStateLoss();
      dcJ();
      this.jdField_d_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.EW(this.cUF);
      return;
      label132:
      this.mFragmentManager.beginTransaction().hide(this.jdField_d_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment).commitAllowingStateLoss();
      break;
      label160:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.dcj();
    }
  }
  
  private void dcI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadChatFragment");
    }
    if (this.mFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment != null) {
        break label105;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment = new ExtendFriendLimitChatMatchFragment();
      if (this.jdField_d_of_type_AndroidSupportV4AppFragment != this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.isAdded()) {
          break label115;
        }
        this.mFragmentManager.beginTransaction().hide(this.jdField_d_of_type_AndroidSupportV4AppFragment).add(2131365382, this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment, "chatFragment").commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      dcJ();
      this.jdField_d_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
      return;
      label105:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.ddk();
      break;
      label115:
      this.mFragmentManager.beginTransaction().hide(this.jdField_d_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment).commitAllowingStateLoss();
    }
  }
  
  private void dcJ()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == this.jdField_d_of_type_AndroidSupportV4AppFragment)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.dck();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment == this.jdField_d_of_type_AndroidSupportV4AppFragment))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.ddi();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.ddj();
    }
  }
  
  private void dcK()
  {
    if ((this.mActivity == null) || (this.mApp == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null)) {
      return;
    }
    try
    {
      Object localObject = (altq)this.mApp.getManager(36);
      if (this.cUG != -1)
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)localObject).getAppInfoByPath("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.b(this.ld[this.cUG], localAppInfo);
      }
      if (this.cUF != -1)
      {
        localObject = ((altq)localObject).getAppInfoByPath("7720.772003");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.b(this.ld[this.cUF], (BusinessInfoCheckUpdate.AppInfo)localObject);
        if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).num.get() > 0))
        {
          localObject = new LpReportInfo_pf00064();
          ((LpReportInfo_pf00064)localObject).actionType = 230;
          ((LpReportInfo_pf00064)localObject).subactionType = 1;
          ((LpReportInfo_pf00064)localObject).reserves = 1;
          LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
        }
      }
      aizy.a(this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch, this.mApp);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendFragment", 1, "updateExtendRedDot fail.", localException);
    }
  }
  
  private void dcL()
  {
    if (this.cUH != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.cUH, true);
      return;
    }
    QLog.e("ExtendFriendFragment", 1, "match un init");
  }
  
  private void dcM()
  {
    afsg localafsg = (afsg)this.mApp.getBusinessHandler(127);
    if (localafsg != null) {
      localafsg.bU(true, true);
    }
  }
  
  private boolean jA(int paramInt)
  {
    return (paramInt == this.cUH) || (paramInt == this.cUF) || (paramInt == this.cUG);
  }
  
  public int d(int paramInt, boolean paramBoolean)
  {
    String str;
    Object localObject;
    if (paramInt == this.cUG)
    {
      dcG();
      str = "";
      localObject = "";
      SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.c();
      if ((localSosoLbsInfo == null) || (localSosoLbsInfo.a == null)) {
        break label183;
      }
      localObject = localSosoLbsInfo.a;
      if (!TextUtils.isEmpty(((SosoInterface.SosoLocation)localObject).city)) {
        str = ((SosoInterface.SosoLocation)localObject).city;
      }
      localObject = String.format("%s;%s", new Object[] { Double.valueOf(((SosoInterface.SosoLocation)localObject).cd), Double.valueOf(((SosoInterface.SosoLocation)localObject).ce) });
    }
    for (;;)
    {
      anot.a(this.mActivity.app, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", str, (String)localObject);
      for (;;)
      {
        this.jdField_b_of_type_Afsi.Nf(paramInt);
        Ns(paramInt);
        return 0;
        if (paramInt == this.cUH)
        {
          dcI();
          if (paramBoolean) {
            afxv.a().NF(1);
          }
        }
        else if (paramInt == this.cUF)
        {
          dcH();
        }
      }
      label183:
      str = "";
    }
  }
  
  public void hf(int paramInt)
  {
    if (paramInt == this.cUG) {
      dcG();
    }
    do
    {
      return;
      if (paramInt == this.cUH)
      {
        dcI();
        return;
      }
    } while (paramInt != this.cUF);
    dcH();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 == 1031) || (paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 2)) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if ((paramInt1 != -1) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
      paramInt1 = 20121205;
      continue;
      paramInt1 = 20121206;
      continue;
      paramInt1 = 20121207;
      continue;
      paramInt1 = 20121208;
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
      if (this.mActivity != null)
      {
        this.mActivity.doOnBackPressed();
        continue;
        if (this.mActivity != null)
        {
          anot.a(this.mActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
          MatchChatMsgListFragment.ap(this.mActivity, 0);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendFragment", 4, "onCreate");
    super.onCreate(paramBundle);
    this.isDestroyed = false;
    this.cbb = false;
    this.mActivity = getActivity();
    this.mApp = this.mActivity.app;
    if (this.mApp != null)
    {
      this.mFragmentManager = this.mActivity.getSupportFragmentManager();
      this.jdField_b_of_type_Afsi = ((afsi)this.mApp.getManager(264));
      this.jdField_b_of_type_Afsi.Nf(0);
      this.mApp.addObserver(this.jdField_d_of_type_Acku);
      this.mApp.addObserver(this.c);
      paramBundle = (WebProcessManager)this.mActivity.app.getManager(13);
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendFragment", 2, "onCreate, preload web process");
        }
        paramBundle.egu();
      }
    }
    afxv.a().ddM();
    this.ie = System.currentTimeMillis();
    anot.a(this.mActivity.app, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
    afsi.a(this.mActivity, this.mApp);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("ExtendFriendFragment", 4, "onCreateView " + caZ);
    this.mContainer = ((ViewGroup)paramLayoutInflater.inflate(2131561314, null));
    this.cJ = ((ViewGroup)this.mContainer.findViewById(2131379823));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.mContainer.findViewById(2131378499));
    this.RL = ((TextView)this.mContainer.findViewById(2131381081));
    this.Cc = this.mContainer.findViewById(2131379804);
    this.Cd = this.mContainer.findViewById(2131372394);
    if (this.cJ != null)
    {
      this.cJ.setVisibility(4);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramLayoutInflater = (FrameLayout.LayoutParams)this.cJ.getLayoutParams();
        paramLayoutInflater.topMargin = ImmersiveUtils.getStatusBarHeight(this.mActivity);
        this.cJ.setLayoutParams(paramLayoutInflater);
      }
    }
    paramLayoutInflater = this.mContainer.findViewById(2131379803);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(this);
    }
    if (this.Cc != null)
    {
      this.Cc.setOnClickListener(this);
      this.Cc.setOnTouchListener(new jll.a());
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.Cc != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.Cc).a(53).a();
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.f(25);
    }
    int i;
    if (this.Cd != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.mActivity.app);
      paramLayoutInflater = this.Cd;
      if (bool)
      {
        i = 0;
        paramLayoutInflater.setVisibility(i);
      }
    }
    else
    {
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = ((ExtendFriendSquareFragment)this.mFragmentManager.findFragmentByTag("squareFragment"));
      }
      if (!caZ) {
        break label381;
      }
      dcB();
    }
    for (;;)
    {
      ((afsi)this.mActivity.app.getManager(264)).dbS();
      paramLayoutInflater = this.mContainer;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 8;
      break;
      label381:
      dcD();
    }
  }
  
  public void onDestroy()
  {
    ((afsi)this.mActivity.app.getManager(264)).dbT();
    QLog.i("ExtendFriendFragment", 4, "onDestroy");
    this.isDestroyed = true;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_d_of_type_Acku);
      this.mApp.removeObserver(this.c);
    }
    afxn.F(this.mApp, false);
    int i = (int)((System.currentTimeMillis() - this.ie) / 1000L);
    if ((this.ie > 0L) && (i > 0) && (i < 86400))
    {
      if (this.mApp != null) {
        anot.a(this.mApp, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i, "", "", "", "");
      }
      afxv.a().NE(i);
    }
    afxx.a(this.mApp).destroy();
    this.jdField_b_of_type_Afsi.Nf(-1);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i = paramIntent.getIntExtra("position", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, String.format("onNewIntent position=%s", new Object[] { Integer.valueOf(i) }));
    }
    if ((i >= 0) && (jA(i))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(i, false);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.resumeAll();
  }
  
  public void onStart()
  {
    super.onStart();
    if (!this.cbc) {
      this.cbc = afwz.a(this.mActivity, this.mApp, this.g);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dcN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment
 * JD-Core Version:    0.7.0.1
 */