package com.tencent.mobileqq.app;

import acep;
import aces;
import acet;
import aceu;
import acev;
import acew;
import acex;
import acey;
import acez;
import acfa;
import acjf;
import acjf.a;
import acyg;
import ahei;
import akjp;
import akrv;
import akrv.b;
import akrv.c;
import akth;
import akti;
import akwp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import anpc;
import anxk;
import aqdj;
import aqeu;
import aqgz;
import aqha;
import aura;
import auvn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.a;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import njn;
import tls;

public class FrameHelperActivity
  extends FrameFragment
  implements View.OnClickListener, Animation.AnimationListener
{
  public static boolean bHr;
  public static WeakReference<DrawerFrame> gg;
  public View AY;
  private TranslateAnimation F;
  private TranslateAnimation G;
  public acjf.a a;
  public ahei a;
  private akrv.c jdField_a_of_type_Akrv$c = new acev(this);
  public akrv a;
  public akth a;
  private BatteryBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver;
  private a jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$a;
  private d jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d;
  public DrawerFrame.a[] a;
  public DrawerFrame b;
  private Card b;
  private boolean bHn;
  private boolean bHo;
  private boolean bHp;
  private boolean bHq = true;
  private int cuX = 3;
  private int cuY = 0;
  private int cuZ = -2147483548;
  public ViewGroup dU;
  private VasQuickUpdateManager.CallBacker f;
  protected ViewTreeObserver.OnGlobalLayoutListener h = new aces(this);
  private boolean mIsDestroyed;
  private boolean mIsForeground = true;
  public Handler mUiHandler;
  private Dialog x;
  private ImageView yd;
  
  public FrameHelperActivity()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$a = new DrawerFrame.a[] { null, null, null, null };
    this.jdField_a_of_type_Acjf$a = new acfa(this);
    this.jdField_a_of_type_Ahei = new acet(this);
    this.jdField_a_of_type_Akth = new aceu(this);
  }
  
  private int Ar()
  {
    acep localacep = b();
    if ((localacep instanceof Conversation)) {}
    do
    {
      return 1;
      if ((localacep instanceof Contacts)) {
        return 3;
      }
    } while (!(localacep instanceof Leba));
    return 4;
  }
  
  private void EM(boolean paramBoolean)
  {
    RandomCoverView localRandomCoverView;
    ImageView localImageView1;
    ImageView localImageView2;
    if (this.dU != null)
    {
      localRandomCoverView = (RandomCoverView)this.dU.findViewById(2131380003);
      localImageView1 = (ImageView)this.dU.findViewById(2131363633);
      localImageView2 = (ImageView)this.dU.findViewById(2131381291);
      if (!ThemeUtil.isNowThemeIsDefault(getActivity().app, paramBoolean, null)) {}
    }
    else
    {
      try
      {
        localRandomCoverView.setVisibility(0);
        if (!this.mUiHandler.hasMessages(14)) {
          this.mUiHandler.sendEmptyMessage(14);
        }
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localRandomCoverView.setVisibility(8);
          localOutOfMemoryError.printStackTrace();
        }
      }
    }
    localImageView1.setVisibility(8);
    localRandomCoverView.e().setImageDrawable(null);
    localRandomCoverView.setVisibility(8);
    localImageView2.setImageResource(2130845853);
    localImageView2.setVisibility(0);
  }
  
  public static void EN(boolean paramBoolean)
  {
    if (gg != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)gg.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.isTouchable = false;
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameTouchable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  public static void EO(boolean paramBoolean)
  {
    if (gg != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)gg.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.setDrawerEnabled(false);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameEnable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  public static boolean ZW()
  {
    if (gg != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)gg.get(); localDrawerFrame == null; localDrawerFrame = null) {
      return false;
    }
    if ((localDrawerFrame.Wt()) || (localDrawerFrame.Wu())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static FrameHelperActivity a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = ((FragmentActivity)paramBaseActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (paramBaseActivity != null) {
      return (FrameHelperActivity)paramBaseActivity;
    }
    return null;
  }
  
  private void b(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataCard != null) {
      if (this.jdField_b_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.lQQMasterLogindays = this.jdField_b_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
        if ((this.jdField_b_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_b_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_b_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.lQQMasterLogindays))) {
          break label157;
        }
        localObject = String.format(getString(2131695584), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.lQQMasterLogindays - this.jdField_b_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.x == null) {
        break label225;
      }
      paramQQAppInterface = (TextView)this.x.findViewById(2131365863);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.requestFocus();
        paramQQAppInterface.setText((CharSequence)localObject);
        paramQQAppInterface.setContentDescription((CharSequence)localObject);
      }
      this.x.show();
      return;
      FriendProfileCardActivity.lQQMasterLogindays = 30L;
      break;
      label157:
      if (this.jdField_b_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.lQQMasterLogindays)
      {
        localObject = String.format(getString(2131695585), new Object[] { Integer.valueOf((int)this.jdField_b_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = getString(2131695586);
        continue;
        localObject = getString(2131695586);
      }
    }
    label225:
    this.x = new ReportDialog(paramFragmentActivity, 2131756467);
    this.x.setContentView(2131559127);
    TextView localTextView = (TextView)this.x.findViewById(2131365867);
    if (localTextView != null) {
      localTextView.setText(getString(2131695581));
    }
    localTextView = (TextView)this.x.findViewById(2131365863);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.x.findViewById(2131365852);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131721058);
      ((TextView)localObject).setOnClickListener(new acew(this, paramQQAppInterface));
    }
    localObject = (TextView)this.x.findViewById(2131365858);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131695583);
      ((TextView)localObject).setOnClickListener(new acex(this, paramQQAppInterface, paramFragmentActivity));
    }
    this.x.setOnDismissListener(new acey(this));
    this.x.show();
  }
  
  private void bME()
  {
    QLog.i("Q.recent", 1, "frameHelper_initDrawerFrame: mDrawerFrame=  " + this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame + "mDrawerBg= " + this.dU + "mIsInflated = " + this.bHp);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$a.wP(true);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d == null)
      {
        localObject = (Conversation)a(Conversation.class);
        if (localObject != null) {
          ((Conversation)localObject).bMs();
        }
      }
      if (!this.bHp) {
        bMs();
      }
      Object localObject = (ViewGroup)getActivity().findViewById(2131365363);
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(getActivity(), (ViewGroup)localObject, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.s(), null, this.dU, this);
        if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$a.wP(true);
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(new acez(this));
        cIA();
        gg = new WeakReference(this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
        EN(false);
        EO(false);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.i("Q.recent", 1, "frameHelper_initDrawerFrame exception, " + localException.toString());
        }
      }
    }
  }
  
  private void cIC()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.app == null)) {
      QLog.d("Q.recent", 1, "checkLocationPermission, activity or app is null");
    }
    int i;
    do
    {
      AppRuntime.Status localStatus;
      long l;
      do
      {
        return;
        localStatus = localFragmentActivity.app.getOnlineStatusNonSync();
        l = akti.a().k(localFragmentActivity.app);
      } while ((localStatus != AppRuntime.Status.online) || (l != -1L));
      i = localFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
      if (i != 0)
      {
        aqha.b(localFragmentActivity, 2131700564);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatus", 2, new Object[] { "granted:", Integer.valueOf(i) });
  }
  
  private void cIE()
  {
    if ((this.jdField_a_of_type_Akrv != null) && (this.jdField_a_of_type_Akrv.isShowing())) {
      this.jdField_a_of_type_Akrv.nN(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "closeAccountPanel");
    }
  }
  
  private void cIv()
  {
    ThreadManager.post(new FrameHelperActivity.2(this), 5, null, true);
  }
  
  private void cIw()
  {
    this.bHo = true;
    this.AY = getActivity().findViewById(2131370213);
    tls.dp2px(5.0F, getResources());
    cIy();
    bFq();
  }
  
  private void cIx()
  {
    if (this.jdField_a_of_type_Akrv != null) {
      return;
    }
    anxk.m(getActivity().app, true);
    this.jdField_a_of_type_Akrv = new akrv(getActivity());
    this.jdField_a_of_type_Akrv.a(this.jdField_a_of_type_Akrv$c);
    this.jdField_a_of_type_Akrv.a(new c(this));
  }
  
  private void cIz()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label41;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Wt()) {
        this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.cuu();
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerShadowFlag(true);
    return;
    label41:
    this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.cut();
  }
  
  private void co(QQAppInterface paramQQAppInterface)
  {
    if (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) {
      return;
    }
    paramQQAppInterface.execute(new FrameHelperActivity.6(this, paramQQAppInterface));
  }
  
  public static void cuA()
  {
    if (gg != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)gg.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null) {
        localDrawerFrame.cuA();
      }
      return;
    }
  }
  
  public static void cuz()
  {
    if (gg != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)gg.get();; localDrawerFrame = null)
    {
      if ((localDrawerFrame != null) && (localDrawerFrame.Wt())) {
        localDrawerFrame.cuz();
      }
      return;
    }
  }
  
  public void EP(boolean paramBoolean)
  {
    bHr = paramBoolean;
    if (bHr) {
      njn.a().pM(false);
    }
  }
  
  public void IW(int paramInt) {}
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.destroy();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.apply();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i = aqeu.J(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    aqeu.z(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    paramActivity.startActivity(localIntent);
    if (QQPlayerService.isPlaying())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$a = parama;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (parama != null)) {
      parama.wP(true);
    }
  }
  
  public void a(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d = paramd;
  }
  
  public void bFq() {}
  
  void bMs()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "frameHelper_inflateUI, " + this.bHp + "mDrawerBgView=" + this.dU);
        }
        if (!this.bHp)
        {
          localObject1 = getActivity();
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Object localObject1 = LayoutInflater.from(getActivity());
        try
        {
          this.dU = ((ViewGroup)((LayoutInflater)localObject1).inflate(2131561679, null));
          this.yd = ((ImageView)this.dU.findViewById(2131363403));
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "frameHelper_inflateUI|mDrawerBgView= " + this.dU);
          }
          this.bHp = true;
        }
        catch (Exception localException2)
        {
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label313;
          }
        }
        localObject1 = "in main thread ";
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, (String)localObject1 + localException2.toString());
        }
        try
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("device_mode", aqgz.getDeviceModel());
          ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
          anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
          String str2 = getActivity().app.getCurrentAccountUin();
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label330;
          }
          localanpc.collectPerformance(str2, "actFrameHelperSubInflate", false, l, 0L, (HashMap)localObject1, "");
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.recent", 2, localException1.toString());
        continue;
        String str1 = "not in main thread ";
      }
      finally {}
      label313:
      this.dU = null;
      this.bHp = false;
      continue;
      label330:
      l = 1L;
    }
  }
  
  public void bRF() {}
  
  protected void bRG() {}
  
  public acep c()
  {
    return b();
  }
  
  void cIA()
  {
    ThemeBackground.applyThemeBg(super.getActivity().app, this.yd, 0, 0, "-conversation-");
  }
  
  public void cIB()
  {
    this.mUiHandler.removeMessages(10);
    this.mUiHandler.removeMessages(11);
  }
  
  public void cID()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "unRegisterBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver != null)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver);
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "unRegisterBatteryBroadcastReceiver success");
        }
      }
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (localFragmentActivity.app != null)) {
        localFragmentActivity.app.cID();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Q.recent", 1, localThrowable, new Object[] { "unRegisterBatteryBroadcastReceiver fail" });
    }
  }
  
  public void cIF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onAfterAddObservers");
    }
    if (this.mUiHandler != null) {
      this.mUiHandler.sendEmptyMessage(18);
    }
  }
  
  public void cIy()
  {
    Object localObject1 = getActivity();
    if ((this.mIsDestroyed) || (localObject1 == null) || (((FragmentActivity)localObject1).app == null)) {
      return;
    }
    Object localObject2 = getActivity().app.getCurrentAccountUin();
    Drawable localDrawable = aqdj.g(1, 1);
    localObject1 = aqdj.a(((FragmentActivity)localObject1).app, 1, (String)localObject2, 1, localDrawable, localDrawable, null);
    handleMessage(this.mUiHandler.obtainMessage(12, localObject1));
    localObject2 = new StringBuilder().append("FrameHelperActivity, updateSelfFace:");
    if (localObject1 != null) {}
    for (localObject1 = ((aqdj)localObject1).aF();; localObject1 = "")
    {
      QLog.i("Q.qqhead.freq", 1, localObject1);
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Akrv != null) {
      this.jdField_a_of_type_Akrv.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Wt()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from doOnActivityResult");
      }
      this.mUiHandler.sendEmptyMessage(14);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void g(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = null;
    if ((getActivity() == null) || (getActivity().app == null))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("doDrawerActionReport, getActivity =  ").append(getActivity()).append(" app = ");
        if (getActivity() != null) {
          break label78;
        }
      }
      for (;;)
      {
        QLog.i("Q.recent", 2, localObject);
        return;
        label78:
        localObject = getActivity().app;
      }
    }
    switch (paramInt1)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        anot.a(getActivity().app, "CliOper", "", "", (String)localObject, (String)localObject, paramInt2, 0, "", "", "", "");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + paramInt1 + ", tag = " + (String)localObject);
      return;
      if (paramBoolean)
      {
        localObject = "0X800402E";
      }
      else
      {
        localObject = "0X800402F";
        continue;
        localObject = "0X8004032";
        continue;
        localObject = "0X8004030";
        continue;
        localObject = "0X8004031";
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.mIsDestroyed) || (getActivity() == null)) {}
    do
    {
      ArrayList localArrayList;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                switch (paramMessage.what)
                {
                case 13: 
                case 7: 
                case 8: 
                case 15: 
                case 16: 
                default: 
                  return false;
                }
              } while (this.bHo);
              cIw();
              return false;
              if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
                bME();
              }
            } while ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Ws()));
            this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.cuw();
            return false;
            if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.aJ(getActivity().app);
            }
            this.mUiHandler.sendEmptyMessage(3);
            if (QLog.isColorLevel()) {
              QLog.d("Q.recent", 2, "start updateOnlineStatus");
            }
            bFq();
            anxk.m(getActivity().app, true);
            return false;
            if (paramMessage.arg1 == 0)
            {
              ThreadManager.getSubThreadHandler().post(new FrameHelperActivity.8(this));
              paramMessage = Message.obtain();
              paramMessage.what = 2;
              paramMessage.arg1 = 1;
              this.mUiHandler.sendMessageDelayed(paramMessage, 20000L);
              return false;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, "frameHelper_infalter time out, need do in UI thread ");
            }
            this.mUiHandler.sendEmptyMessage(9);
            return false;
            cIy();
            return false;
            cIA();
          } while ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Wt()));
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from MSG_SET_DIYBG, drawerOpened?" + this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Wt());
          }
          aura.ewq();
          this.mUiHandler.sendEmptyMessage(14);
          return false;
          this.mUiHandler.removeMessages(2);
          bME();
          cIx();
          return false;
          if (!this.bHo) {
            cIw();
          }
          if (this.F == null)
          {
            this.F = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131299628));
            this.F.setDuration(150L);
            this.F.setFillAfter(true);
          }
          this.F.setAnimationListener(this);
          return false;
          if (!this.bHo) {
            cIw();
          }
          if (this.G == null)
          {
            this.G = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131299628), 0.0F);
            this.G.setDuration(150L);
          }
          this.G.setAnimationListener(this);
          return false;
          if (!this.bHo) {
            cIw();
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace now");
        return false;
        co(getActivity().app);
        return false;
        if ((!this.mIsForeground) || (this.bHn)) {
          break;
        }
        paramMessage = (acjf)getActivity().app.getManager(257);
        localArrayList = paramMessage.cB();
      } while ((localArrayList.size() <= 0) || (!acyg.a(getActivity(), localArrayList)));
      paramMessage.dJ(localArrayList);
      return false;
    } while (!QLog.isColorLevel());
    QLog.e("QIMNewFriend", 2, "showDialog|mIsForeground = " + this.mIsForeground + ",isDrawerOpen = " + this.bHn);
    return false;
    bFq();
    return false;
    cIC();
    return false;
  }
  
  public void k(Card paramCard)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((FragmentActivity)localObject).getAppInterface() == null) || (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) || (paramCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d == null)) {
      return;
    }
    localObject = ((FragmentActivity)localObject).app;
    RandomCoverView localRandomCoverView = (RandomCoverView)this.dU.findViewById(2131380003);
    String str = (String)paramCard.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from net,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!aura.aJA()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "card.isNoCover()=" + paramCard.isNoCover());
      }
      if ((!aura.a((QQAppInterface)localObject, paramCard)) && (paramCard.isNoCover()))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.wR(false);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.4(this, localRandomCoverView));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.wR(true);
      ThreadManager.getUIHandler().post(new FrameHelperActivity.5(this, localRandomCoverView));
      this.f = aura.a(getActivity(), (QQAppInterface)localObject, paramCard, localRandomCoverView, str, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d, this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Ws());
      return;
    }
    if (aura.aJA())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "account has logouted,restart to fetch coverUrl");
      }
      aura.ewr();
      this.cuX = 3;
    }
    co((QQAppInterface)localObject);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.F) {}
    while (paramAnimation != this.G) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.onConfigurationChanged(paramConfiguration);
    }
    cIE();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mUiHandler = new Handler(Looper.getMainLooper(), new b(this));
    this.mIsDestroyed = false;
    cIv();
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.onDestroy();
    }
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)getActivity().app.getManager(184);
    if (this.f != null) {
      localVasQuickUpdateManager.removeCallBacker(this.f);
    }
    this.mUiHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Akrv != null)
    {
      this.jdField_a_of_type_Akrv.onDestory();
      this.jdField_a_of_type_Akrv = null;
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    cID();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.bKT != 1) && (!this.aTK)) {
      return;
    }
    this.mIsForeground = false;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Wu())) {
      this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.cuv();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Wt()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.onPause();
      auvn localauvn = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.a(aura.aRP);
      if (localauvn == null) {
        break label169;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] delay one second  and stop UpSideDown Animation");
      }
      this.mUiHandler.postDelayed(new FrameHelperActivity.3(this, localauvn), 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akrv != null) {
        this.jdField_a_of_type_Akrv.onPause();
      }
      ((akjp)getActivity().app.getManager(160)).RV(1);
      return;
      label169:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] dynamicDrawable is null");
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    EM(true);
    cIz();
    cIA();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.bKT != 1) {
      return;
    }
    this.mIsForeground = true;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityRecentDrawerFrame.Wt()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.onResume();
      cIy();
      auvn localauvn = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$d.a(aura.aRP);
      if (localauvn == null) {
        break label167;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] p UpSideDown Animation");
      }
      localauvn.start();
    }
    for (;;)
    {
      ApngImage.pauseAll();
      ApngImage.playByTag(1);
      if (this.mUiHandler.hasMessages(17)) {
        this.mUiHandler.removeMessages(17);
      }
      this.mUiHandler.sendEmptyMessageDelayed(17, 200L);
      bFq();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] updateOnlineStatus");
      }
      if (this.jdField_a_of_type_Akrv == null) {
        break;
      }
      this.jdField_a_of_type_Akrv.onResume();
      return;
      label167:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] dynamicDrawable is null");
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.bKT != 1) {}
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.bKT != 1) && (!this.aTK)) {
      return;
    }
    cIE();
  }
  
  public static abstract interface a
  {
    public abstract void wP(boolean paramBoolean);
  }
  
  static class b
    implements Handler.Callback
  {
    private WeakReference<FrameHelperActivity> mRef;
    
    b(FrameHelperActivity paramFrameHelperActivity)
    {
      this.mRef = new WeakReference(paramFrameHelperActivity);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      FrameHelperActivity localFrameHelperActivity = (FrameHelperActivity)this.mRef.get();
      if (localFrameHelperActivity != null) {
        localFrameHelperActivity.handleMessage(paramMessage);
      }
      return false;
    }
  }
  
  static final class c
    implements akrv.b
  {
    private WeakReference<FrameHelperActivity> mActivity;
    
    c(FrameHelperActivity paramFrameHelperActivity)
    {
      this.mActivity = new WeakReference(paramFrameHelperActivity);
    }
    
    public void cIH()
    {
      FrameHelperActivity localFrameHelperActivity = (FrameHelperActivity)this.mActivity.get();
      if (localFrameHelperActivity == null) {}
      FragmentActivity localFragmentActivity;
      QQAppInterface localQQAppInterface;
      do
      {
        do
        {
          return;
          localFragmentActivity = localFrameHelperActivity.getActivity();
        } while ((localFragmentActivity == null) || (localFragmentActivity.getAppInterface() == null));
        localQQAppInterface = localFragmentActivity.app;
      } while ((!akwp.a().a(localQQAppInterface, localFragmentActivity)) || ((FrameHelperActivity.a(localFrameHelperActivity) != null) && (FrameHelperActivity.a(localFrameHelperActivity).isShowing())));
      FrameHelperActivity.a(localFrameHelperActivity, localQQAppInterface, localFragmentActivity);
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800A00D", "0X800A00D", 0, 0, "", "", "", "");
    }
  }
  
  public static abstract interface d
  {
    public abstract auvn a(String paramString);
    
    public abstract void a(String paramString, auvn paramauvn);
    
    public abstract void aJ(QQAppInterface paramQQAppInterface);
    
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract void onConfigurationChanged(Configuration paramConfiguration);
    
    public abstract void onDestroy();
    
    public abstract void onPause();
    
    public abstract void onResume();
    
    public abstract ViewGroup s();
    
    public abstract void wR(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */