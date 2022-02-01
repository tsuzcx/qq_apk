package com.tencent.mobileqq.activity;

import aahb;
import aavp;
import acix;
import aeam;
import aiae;
import aizd;
import alji;
import aljk;
import aljs;
import aljt;
import anbb;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import ankt;
import anmk;
import anot;
import anoz;
import aqha;
import aqhv;
import aqik;
import aqju;
import aqmq;
import awit;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.minigame.ui.GameActivity3;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jsp;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import swu;
import tzc;
import vvs;
import vvt;
import wiq;
import wit;
import wja;

public class SplashActivity
  extends FragmentActivity
{
  public static long GW;
  public static volatile int bKT = 1;
  public static int bKU;
  public static int bKV;
  public static volatile boolean bax = true;
  public static volatile WeakReference<SplashActivity> dO;
  private long GV;
  private long GX = -1L;
  private BroadcastReceiver aG;
  private String aOk;
  private String aOl;
  private String aQe = "";
  private int bKW = -2;
  public View[] u;
  public View uQ;
  public View uR;
  
  static
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("SplashActivity escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.sSplashActivityEscapedMsg = str + "\n" + Log.getStackTraceString(localThrowable);
        return;
      }
    }
    BaseApplicationImpl.sSplashActivityEscapedMsg = "";
  }
  
  private boolean K(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("open_chatfragment", false))
    {
      aahb.b(this.app, paramIntent);
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      aw(false, 0);
      return true;
    }
    return false;
  }
  
  private boolean L(Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getBooleanExtra("open_kandian_tab_fragment", false)) && (awit.Vs()))
    {
      setIntent(paramIntent);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        bKT = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).I = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "tryOpenKandianTab type : " + i);
        }
        return true;
        ch(paramIntent);
        i = 1;
      }
    }
    return false;
  }
  
  private boolean M(Intent paramIntent)
  {
    return false;
  }
  
  private boolean N(Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_now_tab_fragment", false)) && (this.app.a().abu))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        bKT = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).I = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
        return true;
      }
      ch(paramIntent);
      return true;
    }
    return false;
  }
  
  private boolean O(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent.getBooleanExtra("jump_to_story", false))
    {
      Intent localIntent = new Intent(this, QQStoryMainActivity.class);
      localIntent.replaceExtras(paramIntent.getExtras());
      startActivity(localIntent);
      bool = true;
    }
    return bool;
  }
  
  private boolean QI()
  {
    SplashActivity localSplashActivity = null;
    if (dO != null) {
      localSplashActivity = (SplashActivity)dO.get();
    }
    if ((localSplashActivity != null) && (localSplashActivity != this) && (!localSplashActivity.isFinishing()))
    {
      int i = getTaskId();
      int j = localSplashActivity.getTaskId();
      QLog.d("SplashActivity", 1, "checkDuplication, " + localSplashActivity + ", " + j + ", " + this + ", " + i);
      if (i == j) {
        return true;
      }
      localSplashActivity.finish();
    }
    return false;
  }
  
  private boolean QK()
  {
    if ((aljs.needJump) && (aljs.a != null) && (a(this, this.app, aljs.a)))
    {
      finish();
      return false;
    }
    if ((SplashMiniGameStarter.needJump) && (a(this, this.app)))
    {
      finish();
      return false;
    }
    return true;
  }
  
  private boolean QL()
  {
    i = -1;
    Intent localIntent = getIntent();
    try
    {
      str = localIntent.getStringExtra("uin");
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int j;
        long l;
        label57:
        String str = "";
        QLog.e("SplashActivity", 2, localException1, new Object[0]);
        continue;
        if (i != this.bKW) {
          bool = false;
        } else if (l - this.GX > 800L) {
          bool = false;
        } else {
          bool = true;
        }
      }
    }
    try
    {
      j = localIntent.getIntExtra("uintype", -1);
      i = j;
      l = SystemClock.uptimeMillis();
      if (TextUtils.isEmpty(str)) {
        break label179;
      }
      if (str.equals(this.aQe)) {
        break label135;
      }
      bool = false;
    }
    catch (Exception localException2)
    {
      break label120;
      bool = false;
      break label57;
    }
    if (!bool)
    {
      this.GX = l;
      this.aQe = str;
      this.bKW = i;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "highFrequencyOpenSameAio " + bool);
    }
    return bool;
  }
  
  public static boolean a(SplashActivity paramSplashActivity, AppInterface paramAppInterface)
  {
    QLog.d("SplashActivity", 2, "jumpMiniGameAction");
    MiniAppReportManager.splashMiniGameClickReport(SplashMiniGameStarter.curData);
    SplashMiniGameStarter.needJump = false;
    SplashMiniGameStarter.setHasJumped();
    paramAppInterface = new Intent(BaseApplicationImpl.getApplication(), GameActivity3.class);
    paramAppInterface.addFlags(805371904);
    paramAppInterface.putExtra("fromSplash", true);
    paramAppInterface.putExtra("processName", "com.tencent.mobileqq:mini3");
    paramAppInterface.putExtra("startDuration", System.currentTimeMillis());
    paramAppInterface.putExtra("splashData", SplashMiniGameStarter.curData);
    paramSplashActivity.startActivity(paramAppInterface);
    paramSplashActivity.overridePendingTransition(17432576, 17432577);
    return true;
  }
  
  public static boolean a(SplashActivity paramSplashActivity, QQAppInterface paramQQAppInterface, aljt paramaljt)
  {
    if (paramaljt == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i = paramaljt.mJumpType;
        aljs.needJump = false;
        switch (i)
        {
        case 1: 
          if (TextUtils.isEmpty(paramaljt.bWP))
          {
            QLog.i("QSplash@QbossSplashUtil", 1, "jumpH5Url is null");
            return false;
          }
          Intent localIntent = new Intent(paramSplashActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", paramaljt.bWP);
          localIntent.putExtra("key_from_splash_ad", true);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
          paramSplashActivity.startActivity(localIntent);
          if (paramQQAppInterface != null) {
            aljs.S(paramaljt.bWR, null, 2);
          }
          break;
        case 4: 
          if (TextUtils.isEmpty(paramaljt.bWP))
          {
            QLog.i("QSplash@QbossSplashUtil", 1, "scheme is null");
            return false;
          }
          aqik.c(paramQQAppInterface, paramSplashActivity, paramaljt.bWP).ace();
          if (paramQQAppInterface != null)
          {
            aljs.S(paramaljt.bWR, null, 2);
            return false;
          }
          break;
        case 2: 
        case 3: 
        default: 
          return false;
        }
      }
      catch (Exception paramSplashActivity)
      {
        return false;
      }
    }
    return true;
  }
  
  private void bOJ()
  {
    String str2;
    if (GesturePWDUtils.getGestureUnlockFailed(this, this.app.getCurrentAccountUin()))
    {
      str2 = getString(2131694300);
      if (GesturePWDUtils.getGestureUnlockFailedType(this) != 1) {
        break label73;
      }
    }
    label73:
    for (String str1 = getString(2131694303);; str1 = getString(2131694302))
    {
      aqha.a(this, 230, str2, str1, 2131721058, 2131694301, new vvs(this), new vvt(this)).show();
      return;
    }
  }
  
  public static void bVD()
  {
    ankt.bmw();
    com.tencent.widget.XPanelContainer.evb = 0;
  }
  
  private void bVE()
  {
    if (wja.bcD) {}
    do
    {
      return;
      wja.bcE = getIntent().getBooleanExtra("traceviewSwitch", false);
      wja.bcF = getIntent().getBooleanExtra("forbidChatFont", false);
      wja.bcG = getIntent().getBooleanExtra("forbidHeadPendant", false);
      wja.bcH = getIntent().getBooleanExtra("forbidChatBubble", false);
      wja.logcatDBOperation = getIntent().getBooleanExtra("logDBOperation", false);
      com.tencent.mobileqq.app.ThreadSetting.logcatBgTaskMonitor = getIntent().getBooleanExtra("logBgTaskMonitor", false);
      wja.bcD = true;
    } while (!QLog.isColorLevel());
    QLog.d("SplashActivity", 2, "traceviewSwitch: " + wja.bcE + " isForbidChatFontFun: " + wja.bcF + " isForbidHeadPendantFun: " + wja.bcG + " isForbidChatBubbleFun: " + wja.bcH + " logcatDBOperation: " + wja.logcatDBOperation + " isEnableAutoDumpLeak: " + AppSetting.isEnableAutoDumpLeak);
  }
  
  private void cf(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward", -1);
    int j = paramIntent.getIntExtra("uintype", -1);
    if ((i > 0) && ((j == 1035) || (j == 1041) || (j == 1042)) && (this.app.iz(284)))
    {
      ((aizd)this.app.getManager(284)).R(this, paramIntent);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      getIntent().removeExtra("forward");
      return;
      Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", paramIntent.getStringExtra("uin"));
      localIntent.putExtra("uintype", paramIntent.getIntExtra("uintype", 0));
      localIntent.putExtra("yuyin", paramIntent.getBooleanExtra("yuyin", false));
      localIntent.putExtra("uinname", paramIntent.getStringExtra("uinname"));
      localIntent.putExtra("enterchatwin", true);
      startActivity(localIntent);
      getIntent().removeExtra("fromMsgBox");
      continue;
      paramIntent = paramIntent.getParcelableExtra("AllInOne");
      if ((paramIntent instanceof ProfileActivity.AllInOne))
      {
        paramIntent = (ProfileActivity.AllInOne)paramIntent;
        paramIntent.bIZ = 100;
        paramIntent.bJa = 6;
        ProfileActivity.b(this, paramIntent);
        continue;
        paramIntent = paramIntent.getStringExtra("url");
        localIntent = new Intent(this, QQBrowserActivity.class);
        if (j != -1)
        {
          localIntent.putExtra("uintype", j);
          if ((j == 1030) && (this.app.iz(240)))
          {
            ((aeam)this.app.getManager(240)).a(null);
            if (QLog.isColorLevel()) {
              QLog.d("CampusNoticeManager", 2, "remove campus notice");
            }
          }
        }
        localIntent.putExtra("url", paramIntent);
        startActivity(localIntent);
      }
    }
  }
  
  public boolean QJ()
  {
    if ((this.app != null) && (this.app.bIV)) {
      QLog.d("SplashActivity", 1, "LastExitTaskUnfinished finish");
    }
    Object localObject1;
    do
    {
      return true;
      if ((NotificationActivity.a != null) && (!NotificationActivity.a.isFinishing()))
      {
        QLog.d("SplashActivity", 1, "needFinish, notification activity exists");
        localObject1 = NotificationActivity.a.getIntent();
        NotificationActivity.a.finish();
        startActivity((Intent)localObject1);
        return false;
      }
      if (!UserguideActivity.a(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("SplashActivity", 2, "showUserGuide");
    return true;
    if ((this.app == null) || ((!this.app.isLogin()) && (this.app.getKickIntent() == null)))
    {
      Object localObject2 = getSharedPreferences("UserGuide", 0);
      localObject1 = ((SharedPreferences)localObject2).getString("qq_version", "");
      String str1 = ((SharedPreferences)localObject2).getString("qq_version_full", "");
      String str2 = AppSetting.nT();
      localObject2 = ((SharedPreferences)localObject2).edit();
      if (!TextUtils.equals((CharSequence)localObject1, "3058")) {
        ((SharedPreferences.Editor)localObject2).putString("qq_version_pre", (String)localObject1);
      }
      if (!TextUtils.equals(str1, str2)) {
        ((SharedPreferences.Editor)localObject2).putString("qq_version_full_pre", str1);
      }
      ((SharedPreferences.Editor)localObject2).putString("qq_version", "3058");
      ((SharedPreferences.Editor)localObject2).putString("qq_version_full", str2);
      ((SharedPreferences.Editor)localObject2).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, String.format("update version pre[%s, %s], cur[%s, %s]", new Object[] { localObject1, str1, "3058", str2 }));
      }
      startActivity(new Intent(this, LoginActivity.class));
      return true;
    }
    return false;
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramInt, paramRedTypeInfo);
    }
  }
  
  public void aw(boolean paramBoolean, int paramInt)
  {
    wit.a().bYr();
    ThreadRegulator.a().JW(1);
    bKU = tzc.a().a(0, 1, 0, 0, 2000, 301, 4L, Process.myTid(), "openAIO");
    anoz.a().B("ChatFragment", true);
    aqmq.bU(null, "AIO_Start_cost");
    if ((wja.a(this, this.app, paramBoolean, getIntent())) || (QL())) {}
    label530:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, paramInt + "|openAIO|" + getIntent().getIntExtra("uintype", -1));
      }
      paramBoolean = getIntent().getBooleanExtra("open_chatfragment_withanim", false);
      Object localObject2 = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
      Object localObject1 = ((FragmentManager)localObject2).findFragmentByTag(ChatFragment.class.getName());
      localObject2 = ((FragmentManager)localObject2).findFragmentByTag(MainFragment.class.getName());
      if (localObject2 != null)
      {
        ((MainFragment)localObject2).bRz();
        if (((MainFragment)localObject2).getCurrentTab() != MainFragment.bIk) {
          ((MainFragment)localObject2).setCurrentTab(MainFragment.bIk);
        }
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "openAIO f != null ");
        }
        ChatFragment localChatFragment = (ChatFragment)localObject1;
        localChatFragment.bJy();
        bKT = 2;
        if (localChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
        {
          QLog.w("SplashActivity", 1, "ChatFragment state error, trying to recreate it.");
          localChatFragment = ChatFragment.a();
          localFragmentTransaction.remove((Fragment)localObject1);
          localFragmentTransaction.add(16908290, localChatFragment, ChatFragment.class.getName());
          localFragmentTransaction.hide((Fragment)localObject2);
          localFragmentTransaction.commitAllowingStateLoss();
        }
      }
      for (;;)
      {
        if (!getIntent().getBooleanExtra("activepull_push_flag", false)) {
          break label530;
        }
        anot.a(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        return;
        if (!((Fragment)localObject1).isVisible())
        {
          if ((paramBoolean) && (acix.getNumberOfCores() > 1)) {
            localFragmentTransaction.setCustomAnimations(2130772090, 2130772097);
          }
          localFragmentTransaction.show((Fragment)localObject1);
          localFragmentTransaction.hide((Fragment)localObject2);
          localFragmentTransaction.commitAllowingStateLoss();
          continue;
          if (Math.abs(SystemClock.uptimeMillis() - this.GV) < 1000L)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("SplashActivity", 2, "openAIO hasOpenedAIO true, renturn ");
            return;
          }
          this.GV = SystemClock.uptimeMillis();
          if ((paramBoolean) && (acix.getNumberOfCores() > 1)) {
            localFragmentTransaction.setCustomAnimations(2130772090, 2130772097);
          }
          localObject1 = ChatFragment.a();
          bKT = 2;
          localFragmentTransaction.add(16908290, (Fragment)localObject1, ChatFragment.class.getName());
          localFragmentTransaction.hide((Fragment)localObject2);
          localFragmentTransaction.commitAllowingStateLoss();
          wit.a().bYr();
          if (QLog.isColorLevel()) {
            QLog.i("SplashActivity", 2, "openAIO f == null ");
          }
        }
      }
    }
  }
  
  public void bRy()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).bRy();
    }
  }
  
  public void bVF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 4, "clearAIO");
    }
    wit.a().bYr();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment1 = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    Fragment localFragment2 = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localFragment2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "clearAIO");
      }
      localObject = ((FragmentManager)localObject).beginTransaction();
      if (localFragment2.isVisible())
      {
        bKT = 1;
        ((FragmentTransaction)localObject).hide(localFragment2);
        if (localFragment1 != null) {
          break label133;
        }
        ((FragmentTransaction)localObject).add(16908290, MainFragment.a(), MainFragment.class.getName());
      }
    }
    for (;;)
    {
      ((FragmentTransaction)localObject).remove(localFragment2).commitAllowingStateLoss();
      if (aavp.a().isSelected()) {
        aavp.a().detach();
      }
      return;
      label133:
      ((FragmentTransaction)localObject).show(localFragment1);
    }
  }
  
  public void cg(Intent paramIntent)
  {
    Object localObject2 = null;
    int i = paramIntent.getIntExtra("extra_pull_active_push_type", 0);
    if (i == 0) {
      return;
    }
    Object localObject1;
    if (i == 2)
    {
      paramIntent = paramIntent.getStringExtra("extra_pull_active_push_url");
      localObject1 = new Intent(this.app.getApp(), QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramIntent);
    }
    for (;;)
    {
      if (localObject1 != null) {
        startActivity((Intent)localObject1);
      }
      anot.a(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      return;
      localObject1 = localObject2;
      if (i == 1) {
        switch (paramIntent.getIntExtra("extra_pull_active_push_subtype", 0))
        {
        default: 
          localObject1 = localObject2;
          break;
        case 1: 
          new aqhv(this.app, this).acL();
          localObject1 = localObject2;
          break;
        case 2: 
          new aqhv(this.app, this).aEi();
          localObject1 = localObject2;
          break;
        case 3: 
          localObject1 = new Intent(this.app.getApp(), ActivateFriendActivity.class);
          ((Intent)localObject1).putExtra("af_key_from", 4);
          break;
        case 4: 
          localObject1 = new Intent(this.app.getApp(), NearbyActivity.class);
          ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
          break;
        case 5: 
          HotChatManager.w(this, false);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void ch(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "openMainFragment");
    }
    Object localObject = getSupportFragmentManager();
    MainFragment localMainFragment = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localMainFragment == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "openMainFragment mainfragment is null");
      }
      return;
    }
    FragmentTransaction localFragmentTransaction;
    if (bKT != 1)
    {
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localObject = (ChatFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    }
    try
    {
      if (paramIntent.getBooleanExtra("switch_anim", false)) {
        localFragmentTransaction.setCustomAnimations(2130772096, 2130772091);
      }
      bKT = 1;
      localFragmentTransaction.show(localMainFragment);
      localFragmentTransaction.hide((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      if ((localObject != null) && (((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
      {
        if ((((ChatFragment)localObject).jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.beq) && (((ChatFragment)localObject).jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bes) && (!((ChatFragment)localObject).jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode)) {
          ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        }
      }
      else
      {
        localMainFragment.doOnNewIntent(paramIntent);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("SplashActivity", 2, localException, new Object[0]);
        continue;
        if ((((ChatFragment)localObject).jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.ber) && (((ChatFragment)localObject).jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bet) && (!((ChatFragment)localObject).jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode)) {
          ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        } else {
          ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if ((localFragment != null) && (localFragment.isVisible())) {
      ((ChatFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      return;
      localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    } while (localObject == null);
    ((MainFragment)localObject).doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: getstatic 83	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   3: ifnull +583 -> 586
    //   6: getstatic 83	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   9: invokevirtual 926	java/lang/String:length	()I
    //   12: ifle +574 -> 586
    //   15: iconst_1
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +44 -> 62
    //   21: new 101	android/content/Intent
    //   24: dup
    //   25: aload_0
    //   26: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   29: invokespecial 928	android/content/Intent:<init>	(Landroid/content/Intent;)V
    //   32: astore_3
    //   33: aload_3
    //   34: ldc_w 929
    //   37: invokevirtual 349	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   40: pop
    //   41: aload_0
    //   42: invokespecial 930	android/support/v4/app/FragmentActivity:finish	()V
    //   45: aload_0
    //   46: aload_3
    //   47: iconst_m1
    //   48: aconst_null
    //   49: invokespecial 934	android/support/v4/app/FragmentActivity:superStartActivityForResult	(Landroid/content/Intent;ILandroid/os/Bundle;)V
    //   52: ldc2_w 935
    //   55: invokestatic 942	java/lang/Thread:sleep	(J)V
    //   58: iconst_m1
    //   59: invokestatic 945	java/lang/System:exit	(I)V
    //   62: aconst_null
    //   63: ldc_w 947
    //   66: invokestatic 950	aqmq:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aconst_null
    //   70: ldc_w 952
    //   73: invokestatic 950	aqmq:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aconst_null
    //   77: ldc_w 954
    //   80: invokestatic 950	aqmq:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 957	com/tencent/mobileqq/activity/SplashActivity:mActNeedImmersive	Z
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 959	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   93: pop
    //   94: ldc_w 954
    //   97: aconst_null
    //   98: invokestatic 950	aqmq:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 961	com/tencent/mobileqq/activity/SplashActivity:QJ	()Z
    //   105: ifne +10 -> 115
    //   108: aload_0
    //   109: invokespecial 963	com/tencent/mobileqq/activity/SplashActivity:QI	()Z
    //   112: ifeq +23 -> 135
    //   115: aload_0
    //   116: invokevirtual 258	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   119: ldc_w 952
    //   122: aconst_null
    //   123: invokestatic 950	aqmq:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc_w 947
    //   129: aconst_null
    //   130: invokestatic 950	aqmq:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_0
    //   136: invokespecial 965	com/tencent/mobileqq/activity/SplashActivity:QK	()Z
    //   139: ifeq +445 -> 584
    //   142: aload_0
    //   143: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   146: invokevirtual 968	android/content/Intent:getAction	()Ljava/lang/String;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +33 -> 184
    //   154: ldc_w 970
    //   157: aload_3
    //   158: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +23 -> 184
    //   164: aload_0
    //   165: invokevirtual 258	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: ldc 188
    //   173: iconst_2
    //   174: aload_1
    //   175: iconst_0
    //   176: anewarray 313	java/lang/Object
    //   179: invokestatic 317	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   182: iconst_1
    //   183: ireturn
    //   184: new 238	java/lang/ref/WeakReference
    //   187: dup
    //   188: aload_0
    //   189: invokespecial 973	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   192: putstatic 236	com/tencent/mobileqq/activity/SplashActivity:dO	Ljava/lang/ref/WeakReference;
    //   195: aload_1
    //   196: ifnull +40 -> 236
    //   199: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +12 -> 214
    //   205: ldc 188
    //   207: iconst_2
    //   208: ldc_w 975
    //   211: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   218: ldc 99
    //   220: iconst_0
    //   221: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   224: pop
    //   225: aload_0
    //   226: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   229: ldc 136
    //   231: iconst_0
    //   232: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   235: pop
    //   236: aload_0
    //   237: getfield 109	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   240: iconst_0
    //   241: putfield 978	com/tencent/mobileqq/app/QQAppInterface:isClearTaskBySystem	Z
    //   244: aload_0
    //   245: invokespecial 980	com/tencent/mobileqq/activity/SplashActivity:bVE	()V
    //   248: aload_0
    //   249: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   252: astore_3
    //   253: aload_3
    //   254: invokevirtual 226	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   257: ifnull +79 -> 336
    //   260: aload_3
    //   261: invokevirtual 226	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   264: ldc_w 531
    //   267: invokevirtual 986	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   270: ifne +18 -> 288
    //   273: aload_3
    //   274: ldc_w 988
    //   277: iconst_0
    //   278: invokevirtual 105	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   281: ifeq +27 -> 308
    //   284: aload_1
    //   285: ifnonnull +23 -> 308
    //   288: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +12 -> 303
    //   294: ldc 188
    //   296: iconst_2
    //   297: ldc_w 990
    //   300: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload_0
    //   304: iconst_0
    //   305: putfield 993	com/tencent/mobileqq/activity/SplashActivity:mCanLock	Z
    //   308: aload_0
    //   309: aload_0
    //   310: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   313: ldc_w 995
    //   316: invokevirtual 285	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   319: putfield 997	com/tencent/mobileqq/activity/SplashActivity:aOk	Ljava/lang/String;
    //   322: aload_0
    //   323: aload_0
    //   324: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   327: ldc_w 999
    //   330: invokevirtual 285	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   333: putfield 1001	com/tencent/mobileqq/activity/SplashActivity:aOl	Ljava/lang/String;
    //   336: aload_0
    //   337: aload_0
    //   338: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   341: invokespecial 1003	com/tencent/mobileqq/activity/SplashActivity:K	(Landroid/content/Intent;)Z
    //   344: ifne +247 -> 591
    //   347: aload_0
    //   348: aload_0
    //   349: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   352: invokespecial 1005	com/tencent/mobileqq/activity/SplashActivity:N	(Landroid/content/Intent;)Z
    //   355: ifne +236 -> 591
    //   358: aload_0
    //   359: aload_0
    //   360: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   363: invokespecial 1007	com/tencent/mobileqq/activity/SplashActivity:L	(Landroid/content/Intent;)Z
    //   366: ifne +225 -> 591
    //   369: aload_0
    //   370: aload_0
    //   371: invokevirtual 123	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   374: invokespecial 1009	com/tencent/mobileqq/activity/SplashActivity:M	(Landroid/content/Intent;)Z
    //   377: ifeq +194 -> 571
    //   380: goto +211 -> 591
    //   383: iload_2
    //   384: ifne +33 -> 417
    //   387: aload_0
    //   388: invokevirtual 146	com/tencent/mobileqq/activity/SplashActivity:getSupportFragmentManager	()Landroid/support/v4/app/FragmentManager;
    //   391: astore_1
    //   392: iconst_1
    //   393: putstatic 35	com/tencent/mobileqq/activity/SplashActivity:bKT	I
    //   396: aload_1
    //   397: invokevirtual 152	android/support/v4/app/FragmentManager:beginTransaction	()Landroid/support/v4/app/FragmentTransaction;
    //   400: ldc 171
    //   402: invokestatic 167	com/tencent/mobileqq/activity/MainFragment:a	()Lcom/tencent/mobileqq/activity/MainFragment;
    //   405: ldc 154
    //   407: invokevirtual 159	java/lang/Class:getName	()Ljava/lang/String;
    //   410: invokevirtual 177	android/support/v4/app/FragmentTransaction:add	(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;
    //   413: invokevirtual 181	android/support/v4/app/FragmentTransaction:commitAllowingStateLoss	()I
    //   416: pop
    //   417: invokestatic 1015	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   420: new 1017	com/tencent/mobileqq/activity/SplashActivity$1
    //   423: dup
    //   424: aload_0
    //   425: invokespecial 1018	com/tencent/mobileqq/activity/SplashActivity$1:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   428: ldc2_w 811
    //   431: invokevirtual 1024	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   434: pop
    //   435: aload_0
    //   436: aload_3
    //   437: invokespecial 1026	com/tencent/mobileqq/activity/SplashActivity:O	(Landroid/content/Intent;)Z
    //   440: pop
    //   441: iconst_1
    //   442: putstatic 1029	com/tencent/common/app/BaseApplicationImpl:appMainActivityHasLanuch	Z
    //   445: ldc_w 952
    //   448: aconst_null
    //   449: invokestatic 950	aqmq:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: getstatic 1034	com/tencent/widget/immersive/ImmersiveUtils:dly	Z
    //   455: ifne +29 -> 484
    //   458: aload_0
    //   459: invokevirtual 1037	com/tencent/mobileqq/activity/SplashActivity:isInMultiWindow	()Z
    //   462: ifne +22 -> 484
    //   465: aload_0
    //   466: invokevirtual 1041	com/tencent/mobileqq/activity/SplashActivity:getWindow	()Landroid/view/Window;
    //   469: invokevirtual 1047	android/view/Window:getDecorView	()Landroid/view/View;
    //   472: new 1049	com/tencent/mobileqq/activity/SplashActivity$2
    //   475: dup
    //   476: aload_0
    //   477: invokespecial 1050	com/tencent/mobileqq/activity/SplashActivity$2:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   480: invokevirtual 1056	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   483: pop
    //   484: invokestatic 1060	com/tencent/mobileqq/activity/SplashActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   487: astore_1
    //   488: getstatic 35	com/tencent/mobileqq/activity/SplashActivity:bKT	I
    //   491: iconst_1
    //   492: if_icmpne +43 -> 535
    //   495: aload_0
    //   496: invokevirtual 1061	com/tencent/mobileqq/activity/SplashActivity:getCurrentTab	()I
    //   499: getstatic 747	com/tencent/mobileqq/activity/MainFragment:bIk	I
    //   502: if_icmpne +33 -> 535
    //   505: aload_1
    //   506: invokevirtual 1066	java/util/ArrayList:size	()I
    //   509: iconst_2
    //   510: if_icmpgt +25 -> 535
    //   513: aload_1
    //   514: invokevirtual 1066	java/util/ArrayList:size	()I
    //   517: iconst_2
    //   518: if_icmpne +21 -> 539
    //   521: ldc_w 1068
    //   524: aload_1
    //   525: iconst_0
    //   526: invokevirtual 1071	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   529: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   532: ifne +7 -> 539
    //   535: iconst_0
    //   536: putstatic 37	com/tencent/mobileqq/activity/SplashActivity:bax	Z
    //   539: getstatic 35	com/tencent/mobileqq/activity/SplashActivity:bKT	I
    //   542: iconst_1
    //   543: if_icmpne -361 -> 182
    //   546: aload_3
    //   547: invokestatic 1076	aljk:a	(Landroid/content/Intent;)Lalji;
    //   550: astore_1
    //   551: aload_1
    //   552: ifnull -370 -> 182
    //   555: aload_1
    //   556: aload_0
    //   557: getfield 109	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   560: aload_0
    //   561: invokevirtual 1080	com/tencent/mobileqq/activity/SplashActivity:getActivity	()Landroid/app/Activity;
    //   564: invokevirtual 1085	alji:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Z
    //   567: pop
    //   568: goto -386 -> 182
    //   571: iconst_0
    //   572: istore_2
    //   573: goto -190 -> 383
    //   576: astore_3
    //   577: goto -519 -> 58
    //   580: astore_1
    //   581: goto -245 -> 336
    //   584: iconst_0
    //   585: ireturn
    //   586: iconst_0
    //   587: istore_2
    //   588: goto -571 -> 17
    //   591: iconst_1
    //   592: istore_2
    //   593: goto -210 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	SplashActivity
    //   0	596	1	paramBundle	Bundle
    //   16	577	2	i	int
    //   32	515	3	localObject	Object
    //   576	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	170	java/lang/Exception
    //   21	52	170	java/lang/Exception
    //   58	62	170	java/lang/Exception
    //   62	115	170	java/lang/Exception
    //   115	133	170	java/lang/Exception
    //   135	150	170	java/lang/Exception
    //   154	168	170	java/lang/Exception
    //   184	195	170	java/lang/Exception
    //   199	214	170	java/lang/Exception
    //   214	236	170	java/lang/Exception
    //   236	284	170	java/lang/Exception
    //   288	303	170	java/lang/Exception
    //   303	308	170	java/lang/Exception
    //   336	380	170	java/lang/Exception
    //   387	417	170	java/lang/Exception
    //   417	484	170	java/lang/Exception
    //   484	535	170	java/lang/Exception
    //   535	539	170	java/lang/Exception
    //   539	551	170	java/lang/Exception
    //   555	568	170	java/lang/Exception
    //   52	58	576	java/lang/Exception
    //   308	336	580	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnDestroy");
    }
    if (this.aG != null) {}
    try
    {
      unregisterReceiver(this.aG);
      this.aG = null;
      if (QQPlayerService.isPlaying())
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "QQPlayerService stopPlayMusic");
        }
        QQPlayerService.eG(getApplicationContext());
      }
      bVD();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("SplashActivity", 1, "", localThrowable);
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject;
    Fragment localFragment;
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "doOnKeyDown");
      }
      localObject = getSupportFragmentManager();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment == null) || (!localFragment.isVisible()))
      {
        localObject = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
        if (localObject != null) {
          return ((MainFragment)localObject).doOnKeyDown(paramInt, paramKeyEvent);
        }
      }
      else
      {
        ((ChatFragment)localFragment).onBackEvent();
        return true;
      }
    }
    if (paramInt == 82)
    {
      localObject = getSupportFragmentManager();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment == null) || (!localFragment.isVisible()))
      {
        localObject = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
        if (localObject != null) {
          return ((MainFragment)localObject).doOnKeyDown(paramInt, paramKeyEvent);
        }
      }
    }
    if (((paramInt == 24) || (paramInt == 25)) && (aiae.a(this).aoF()))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("VolumeBtnDown");
      sendBroadcast((Intent)localObject);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    try
    {
      super.doOnNewIntent(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "doOnNewIntent");
      }
      if (QJ())
      {
        finish();
        return;
      }
      localObject = paramIntent.getAction();
      if ((localObject != null) && ("QQ_ACTION_MENU_QUIT".equals(localObject)))
      {
        finish();
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("SplashActivity", 2, paramIntent, new Object[0]);
      return;
    }
    Object localObject = paramIntent.getExtras();
    if (paramIntent.getIntExtra("fromCmGame", 0) == 1) {
      overridePendingTransition(0, 0);
    }
    int i = getIntent().getIntExtra("uintype", -1);
    if (i == 10005)
    {
      getIntent().removeExtra("uintype");
      QLog.e("SplashActivity", 1, "wtf 10005 aio" + paramIntent);
    }
    if ((i != 10005) && (localObject != null))
    {
      if (K(paramIntent)) {
        return;
      }
      if (Boolean.valueOf(((Bundle)localObject).getBoolean("EXIT", false)).booleanValue()) {
        finish();
      }
      if (((Bundle)localObject).getBoolean("activepull_push_flag"))
      {
        setIntent(paramIntent);
        cg(paramIntent);
        return;
      }
      if ((((Bundle)localObject).getInt("fragment_id") == 1) && (bKT != 1))
      {
        setIntent(paramIntent);
        ch(paramIntent);
        paramIntent = aljk.a(paramIntent);
        if (paramIntent == null) {
          return;
        }
        paramIntent.d(this.app, getActivity());
        return;
      }
    }
    if (bKT == 1)
    {
      localObject = (MainFragment)getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        setIntent(paramIntent);
        ((MainFragment)localObject).doOnNewIntent(paramIntent);
        paramIntent = aljk.a(paramIntent);
        if (paramIntent != null) {
          paramIntent.d(this.app, getActivity());
        }
      }
    }
  }
  
  public void doOnPause()
  {
    if (isInMultiWindow())
    {
      Object localObject = getSupportFragmentManager();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        localObject = (ChatFragment)localFragment;
        ((ChatFragment)localFragment).bJz();
      }
      do
      {
        return;
        localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      } while (localFragment == null);
      ((MainFragment)localFragment).bJz();
      super.doOnPause();
      return;
    }
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    boolean bool2 = true;
    ArrayList localArrayList;
    Object localObject3;
    boolean bool1;
    try
    {
      super.doOnResume();
      AbstractVideoImage.resumeAll();
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "doOnResume");
      }
      bOJ();
      localObject1 = getWindow();
      if ((((Window)localObject1).getAttributes().flags & 0x400) != 0) {
        ((Window)localObject1).clearFlags(1024);
      }
      if (this.app.getKickIntent() != null)
      {
        QLog.d("SplashActivity", 1, "doOnResume finish, kickIntent exists");
        startActivity(this.app.getKickIntent());
        return;
      }
      cf(getIntent());
      localObject8 = this.app.getDevLockIntent();
      if (localObject8 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume start push");
        }
        localObject5 = "";
        localObject7 = "";
        str2 = "";
        str3 = "";
        localArrayList = new ArrayList();
        localObject1 = str3;
        localObject3 = str2;
        localObject4 = localObject7;
        bool1 = bool2;
      }
    }
    catch (Exception localException1)
    {
      Object localObject1;
      Object localObject8;
      Object localObject5;
      Object localObject7;
      String str2;
      String str3;
      Object localObject4;
      String str1;
      QLog.e("SplashActivity", 2, localException1, new Object[0]);
      return;
    }
    try
    {
      str1 = ((Intent)localObject8).getStringExtra("tipMsg");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      bool2 = ((Intent)localObject8).getBooleanExtra("canCancel", true);
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      localObject7 = ((Intent)localObject8).getStringExtra("title");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      str2 = ((Intent)localObject8).getStringExtra("secondTitle");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      str3 = ((Intent)localObject8).getStringExtra("thirdTitle");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      localObject8 = ((Intent)localObject8).getStringArrayListExtra("wordsList");
      localObject5 = str1;
      localObject4 = localObject7;
      str1 = str2;
      localObject3 = str3;
      localObject1 = localObject8;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject6 = localObject3;
        localObject3 = localException1;
        Object localObject2 = localArrayList;
        bool2 = bool1;
        break;
        try
        {
          if ((NotifyPCActiveActivity.a != null) || (!(BaseActivity.sTopActivity instanceof SplashActivity))) {
            break label484;
          }
          startActivity(localObject2);
        }
        catch (Throwable localThrowable) {}
      }
      if (!QLog.isColorLevel()) {
        break label484;
      }
      QLog.i("SplashActivity", 2, "", localThrowable);
      break label484;
      Fragment localFragment = ((FragmentManager)localObject3).findFragmentByTag(MainFragment.class.getName());
      if (localFragment == null) {
        break label657;
      }
      ((MainFragment)localFragment).bJz();
      break label657;
    }
    localObject7 = new Intent(this, DevlockPushActivity.class);
    ((Intent)localObject7).putExtra("canCancel", bool2);
    ((Intent)localObject7).putExtra("tipMsg", (String)localObject5);
    ((Intent)localObject7).putExtra("title", localObject4);
    ((Intent)localObject7).putExtra("secondTitle", str1);
    ((Intent)localObject7).putExtra("thirdTitle", (String)localObject3);
    ((Intent)localObject7).putStringArrayListExtra("wordsList", (ArrayList)localObject1);
    startActivity((Intent)localObject7);
    if ((this.app.isLogin()) && (this.app.getAccount().equals(BaseApplicationImpl.getApplication().getPCActiveUin())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "onResume start push");
      }
      if (!isResume()) {
        return;
      }
      localObject1 = BaseApplicationImpl.getApplication().getPCActiveNoticeIntent();
      if (localObject1 != null) {
        break label691;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "Intent is null");
      }
    }
    label484:
    aqmq.track(null, "Main_Resume_PCActive");
    if ((!TextUtils.isEmpty(this.app.getAccount())) && (!"0".equals(this.app.getAccount()))) {
      ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.3(this), 800L);
    }
    aqmq.track("Main_Resume_PCActive", null);
    ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.4(this), 800L);
    localObject1 = getIntent();
    if ((((Intent)localObject1).getExtras() != null) && (((Intent)localObject1).getBooleanExtra(anbb.ccQ, false)))
    {
      ((Intent)localObject1).removeExtra(anbb.ccQ);
      ThreadManager.post(new SplashActivity.5(this), 8, null, false);
    }
    if (isInMultiWindow())
    {
      localObject3 = getSupportFragmentManager();
      localObject1 = ((FragmentManager)localObject3).findFragmentByTag(ChatFragment.class.getName());
      if ((localObject1 != null) && (((Fragment)localObject1).isVisible()))
      {
        localObject3 = (ChatFragment)localObject1;
        ((ChatFragment)localObject1).bJz();
      }
    }
    else
    {
      label657:
      swu.bBC();
      return;
    }
    label691:
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnStart");
    }
    if ((this.aOk != null) && (this.aOk.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.aOl)))
    {
      aqhv localaqhv = aqik.c(this.app, this, this.aOk);
      localaqhv.setPkgName(this.aOl);
      localaqhv.ace();
      this.aOk = null;
      this.aOl = null;
    }
  }
  
  public void doOnStop()
  {
    if (isInMultiWindow())
    {
      super.doOnPause();
      AbstractVideoImage.pauseAll();
      ApngImage.pauseAll();
      super.doOnStop();
      return;
    }
    super.doOnStop();
  }
  
  public void f(int paramInt1, int paramInt2, Object paramObject)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).f(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "finish()");
    }
    FragmentManager localFragmentManager = getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "finish clearAIO");
      }
      localFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    super.finish();
    if ((dO != null) && (dO.get() == this)) {
      dO = null;
    }
  }
  
  public String getActivityName()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SplashActivity");
    if (bKT == 1) {}
    for (String str = "_MainFragment";; str = "_ChatFragment") {
      return str;
    }
  }
  
  public String getCIOPageName()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (bKT == 1) {}
    for (Object localObject = MainFragment.class.getName();; localObject = ChatFragment.class.getName())
    {
      localObject = localFragmentManager.findFragmentByTag((String)localObject);
      if (localObject == null) {
        break;
      }
      return ((Fragment)localObject).getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public ComponentName getComponentName()
  {
    ComponentName localComponentName2 = super.getComponentName();
    ComponentName localComponentName1 = localComponentName2;
    if (localComponentName2 == null) {
      localComponentName1 = new ComponentName(getApplicationContext(), SplashActivity.class);
    }
    return localComponentName1;
  }
  
  public int getCurrentTab()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      return ((MainFragment)localFragment).getCurrentTab();
    }
    return 0;
  }
  
  public String getPreProcess()
  {
    return "com.tencent.tim:peak";
  }
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).onAccountChanged();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).onAccountChanged();
    }
    wiq.aQ(this.app);
    anmk.q(BaseApplicationImpl.getContext(), this.app.getLongAccountUin());
  }
  
  public void onAccoutChangeFailed()
  {
    super.onAccoutChangeFailed();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).onAccoutChangeFailed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (FrameHelperActivity.gg != null)
    {
      DrawerFrame localDrawerFrame = (DrawerFrame)FrameHelperActivity.gg.get();
      if (localDrawerFrame != null) {
        localDrawerFrame.onConfigurationChanged(paramConfiguration);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      return localChatFragment.onCreateDialog(paramInt);
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((dO != null) && (dO.get() == this)) {
      dO = null;
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    bVF();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).onLogout(paramLogoutReason);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).wl(paramBoolean);
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localObject != null) {
      ((MainFragment)localObject).onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject1 = getSupportFragmentManager();
    Object localObject2 = ((FragmentManager)localObject1).findFragmentByTag(MainFragment.class.getName());
    if (localObject2 != null) {
      ((MainFragment)localObject2).onPostThemeChanged();
    }
    localObject1 = ((FragmentManager)localObject1).findFragmentByTag(ChatFragment.class.getName());
    if (localObject1 != null) {
      ((ChatFragment)localObject1).onPostThemeChanged();
    }
    if (!"1000".equals(ThemeUtil.getCurrentThemeId()))
    {
      if (getAppInterface() != null)
      {
        localObject1 = getAppInterface().getHandler(Conversation.class);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 1050;
        ((MqqHandler)localObject1).sendMessage((Message)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "onPostThemeChanged: hide theme overdue tips");
      }
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.onPrepareDialog(paramInt, paramDialog);
    }
  }
  
  public void preloadUi()
  {
    try
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      this.u = MainFragment.a(localLayoutInflater);
      this.uQ = localLayoutInflater.inflate(2131559111, null);
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.uQ.findViewById(2131376842);
      if (localFPSSwipListView != null) {
        this.uR = localLayoutInflater.inflate(2131563008, localFPSSwipListView, false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SplashActivity", 1, "", localThrowable);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.getWindow().setFormat(-3);
  }
  
  public String setLastActivityName()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      return ((MainFragment)localFragment).setLastActivityName();
    }
    return super.setLastActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity
 * JD-Core Version:    0.7.0.1
 */