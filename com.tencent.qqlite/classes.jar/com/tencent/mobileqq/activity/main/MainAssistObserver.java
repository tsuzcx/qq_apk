package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cek;
import cel;
import cem;
import cep;
import ceq;
import cer;
import ces;
import cew;
import cex;
import cey;
import cez;
import cfa;
import cfb;
import cfc;
import cfd;
import cfe;
import cff;
import cfg;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSigObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.observer.SdCardChangeListener;
import com.tencent.mobileqq.redtouch.RedTouchInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.PrintStream;
import java.util.Timer;
import mqq.app.AppRuntime;
import protocol.KQQConfig.UpgradeInfo;

public class MainAssistObserver
{
  static final long jdField_a_of_type_Long = 1728000000L;
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler = new ces(this, Looper.getMainLooper());
  public SplashActivity a;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new cel(this);
  public FriendListObserver a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cfa(this);
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = new cff(this);
  private SecSigObserver jdField_a_of_type_ComTencentMobileqqAppSecSigObserver = new cem(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new cfd(this);
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new cfg(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new cfc(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new cey(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new cfb(this);
  SdCardChangeListener jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = null;
  public MainAcitivityReportHelper a;
  public QQCustomDialog a;
  private ResourcePluginListener b = new cfe(this);
  
  public MainAssistObserver(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cep(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper = new MainAcitivityReportHelper(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
    if (localQZoneManagerImp != null) {
      return localQZoneManagerImp.a(QZoneManager.FeedType.friendSpace) > 0;
    }
    return false;
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(11);
    if (localGameCenterManagerImp != null) {
      return localGameCenterManagerImp.a();
    }
    return false;
  }
  
  private boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getPackageManager();
    try
    {
      long l = new File(((PackageManager)localObject).getApplicationInfo(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getPackageName(), 0).sourceDir).lastModified();
      if (System.currentTimeMillis() - l >= 1728000000L)
      {
        localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 0);
        ((QQCustomDialog)localObject).setTitle("debug版过期了不能用，请下最新版本");
        ((QQCustomDialog)localObject).setPositiveButton("ok", new ceq(this));
        ((QQCustomDialog)localObject).setOnDismissListener(new cer(this, paramQQAppInterface));
        ((QQCustomDialog)localObject).show();
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return false;
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(11);
    if (localGameCenterManagerImp != null) {
      return localGameCenterManagerImp.b();
    }
    return false;
  }
  
  int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    return 0;
  }
  
  public UpgradeDetailWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppSecSigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(37)).b();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = new SdCardChangeListener(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener.a(0);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addDataScheme("file");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener, localIntentFilter);
      if (Build.VERSION.RELEASE.startsWith("L"))
      {
        System.out.println("SecShell : art L");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, localException.getMessage());
        }
      }
      k();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt1, paramInt2, paramObject);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    SystemUtil.a(BaseApplicationImpl.getContext());
    if ((AppSetting.a == 537032257) && (b(paramQQAppInterface))) {
      return bool2;
    }
    if (NotificationActivity.a == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getAppRuntime().isLogin()) {
        if (GesturePWDUtils.getSplashLock(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getAppRuntime().getAccount()))
        {
          GesturePWDUtils.setStartFromSplash(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, true);
          bool1 = false;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, LoginActivity.class));
        return bool1;
        GesturePWDUtils.mEnterFromSplash = false;
        bool1 = false;
        continue;
        GesturePWDUtils.mEnterFromSplash = false;
      }
    }
    return false;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
    if (localQZoneManagerImp != null) {
      return localQZoneManagerImp.a(QZoneManager.FeedType.mySpacefeed);
    }
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.d(this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppSecSigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener);
    ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(37)).c();
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(11);
    if (localGameCenterManagerImp != null) {
      return localGameCenterManagerImp.a();
    }
    return 0;
  }
  
  public void c()
  {
    ThreadManager.a().schedule(new cek(this), 500L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.c(localQQAppInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  public void e()
  {
    new Timer().schedule(new cez(this), 500L);
  }
  
  public void f()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
        break label131;
      }
    }
    for (;;)
    {
      if ((i != 0) && (!ConfigHandler.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp))) {}
      try
      {
        if (((RedTouchManager)localQQAppInterface.getManager(32)).b().a() == -1) {
          break;
        }
        a(35, 18, Boolean.valueOf(true));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label131:
      i = 0;
    }
    a(35, 18, Boolean.valueOf(false));
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(32)).a();
    int k = ((RedTouchInfo)localObject).h;
    int i = ((RedTouchInfo)localObject).g;
    int m = ((RedTouchInfo)localObject).j;
    localObject = ((RedTouchInfo)localObject).b;
    int j = ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(55)).a();
    if (j > 0) {
      i = j;
    }
    for (;;)
    {
      j = b();
      int n = c();
      int i1 = a();
      int i2 = j + n + i1;
      if (i2 > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.dating", 2, "MainAssistObserver updateTbLebaNotify QzonMsgCount:" + j + " gameCenterCount: " + n + " datingunreadCount:" + i1);
        }
        a(34, 16, Integer.valueOf(i2));
        a(34, 17, Boolean.valueOf(false));
        a(34, 18, Boolean.valueOf(false));
        a(34, 19, Boolean.valueOf(false));
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a(34, 19, localObject);
        a(34, 16, Integer.valueOf(0));
        a(34, 17, Boolean.valueOf(false));
        a(34, 18, Boolean.valueOf(false));
        return;
      }
      if (k > 0)
      {
        a(34, 17, Boolean.valueOf(true));
        a(34, 18, Boolean.valueOf(false));
        a(34, 16, Integer.valueOf(0));
        a(34, 19, Boolean.valueOf(false));
        return;
      }
      if ((i > 0) || (m > 0) || (a()))
      {
        a(34, 17, Boolean.valueOf(false));
        a(34, 18, Boolean.valueOf(true));
        a(34, 16, Integer.valueOf(0));
        a(34, 19, Boolean.valueOf(false));
        return;
      }
      a(34, 17, Boolean.valueOf(false));
      a(34, 18, Boolean.valueOf(false));
      a(34, 16, Integer.valueOf(0));
      a(34, 19, Boolean.valueOf(false));
      return;
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    f();
    Object localObject = localQQAppInterface.a();
    if (localObject != null)
    {
      a(32, 16, Integer.valueOf(((QQMessageFacade)localObject).e()));
      localObject = new Intent("com.tencent.qq.syncQQMessage");
      localQQAppInterface.a().sendBroadcast((Intent)localObject);
    }
    g();
  }
  
  public void i()
  {
    if (GesturePWDUtils.getStartFromSplash(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "gesturepwd auto islock true.");
      }
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, GesturePWDUnlockActivity.class);
      ((Intent)localObject).putExtra("key_gesture_from_splash", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject);
    }
    GesturePWDUtils.setStartFromSplash(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, false);
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null) && (GesturePWDUtils.getGestureUnlockFailed(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a())))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131364029);
      if (GesturePWDUtils.getGestureUnlockFailedType(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity) != 1) {
        break label167;
      }
    }
    label167:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131364030);; localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131364031))
    {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, str, (String)localObject, 2131362790, 2131364028, new cew(this), new cex(this)).show();
      return;
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localQZoneManager.a(2);
      }
    }
  }
  
  public void k()
  {
    System.out.println("consolidateMethod");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver
 * JD-Core Version:    0.7.0.1
 */