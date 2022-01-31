package com.tencent.mobileqq.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SplashActivityCore;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PrivacyDeclareHelper.Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSigObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.observer.SdCardChangeListener;
import com.tencent.mobileqq.redtouch.RedTouchInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import eht;
import ehu;
import ehv;
import ehw;
import ehx;
import ehy;
import ehz;
import eia;
import eib;
import eic;
import eid;
import eie;
import eif;
import eig;
import eih;
import eii;
import eij;
import eim;
import ein;
import eiu;
import eiw;
import eix;
import eiy;
import eiz;
import ejc;
import ejd;
import eje;
import ejg;
import eji;
import ejj;
import java.io.PrintStream;
import java.util.Timer;
import mqq.app.AppRuntime;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import protocol.KQQConfig.UpgradeInfo;

public class MainAssistObserver
{
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler = new ein(this, Looper.getMainLooper());
  public SplashActivity a;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new eii(this);
  public FriendListObserver a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new eiz(this);
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = new eig(this);
  public PrivacyDeclareHelper.Callback a;
  private SecSigObserver jdField_a_of_type_ComTencentMobileqqAppSecSigObserver = new eij(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new eid(this);
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new eih(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new eic(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new eib(this);
  SdCardChangeListener jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = null;
  public MainAcitivityReportHelper a;
  public QQCustomDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new eie(this);
  public boolean a;
  public int b;
  private ResourcePluginListener jdField_b_of_type_ComTencentMobileqqConfigResourcePluginListener = new eif(this);
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private int c = 0;
  
  public MainAssistObserver(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 131072257;
    this.jdField_a_of_type_ComTencentMobileqqAppPrivacyDeclareHelper$Callback = new eia(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new eim(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper = new MainAcitivityReportHelper(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
  }
  
  private void a(int paramInt)
  {
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(0)).b(paramInt);
  }
  
  private void a(ejj paramejj)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity).inflate(2130903218, null);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131231660);
    Button localButton = (Button)localLinearLayout.findViewById(2131231661);
    localButton.setEnabled(false);
    localTextView.setOnClickListener(new ejg(this, localTextView, localButton));
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230);
    localQQCustomDialog.addView(localLinearLayout);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563352));
    localQQCustomDialog.setDividerGone();
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setBottomLayoutGone();
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setOnDismissListener(new eji(this));
    localButton.setOnClickListener(new ehu(this, localTextView, paramejj, localQQCustomDialog));
    localQQCustomDialog.show();
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return false;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(9);
    if (localQZoneManagerImp != null) {
      return localQZoneManagerImp.a(QZoneManager.FeedType.friendSpace) > 0;
    }
    return false;
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return false;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(11);
    if (localGameCenterManagerImp != null) {
      return localGameCenterManagerImp.a();
    }
    return false;
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return false;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(11);
    if (localGameCenterManagerImp != null) {
      return localGameCenterManagerImp.b();
    }
    return false;
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a().getSharedPreferences("mobileQQi", 0).getBoolean("individuation_newflag", true);
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity).inflate(2130903220, null);
    Object localObject = (RadioGroup)localLinearLayout.findViewById(2131231664);
    RadioButton localRadioButton1 = (RadioButton)localLinearLayout.findViewById(2131231665);
    RadioButton localRadioButton2 = (RadioButton)localLinearLayout.findViewById(2131231666);
    Button localButton = (Button)localLinearLayout.findViewById(2131231663);
    localButton.setEnabled(false);
    ((RadioGroup)localObject).setOnCheckedChangeListener(new ejc(this, localRadioButton1, localRadioButton2, localButton));
    localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230);
    ((QQCustomDialog)localObject).addView(localLinearLayout);
    ((QQCustomDialog)localObject).setDividerGone();
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).setBottomLayoutGone();
    ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
    ((QQCustomDialog)localObject).setOnDismissListener(new ejd(this, localRadioButton2));
    localButton.setOnClickListener(new eje(this, localRadioButton1, (QQCustomDialog)localObject, localRadioButton2));
    ((QQCustomDialog)localObject).show();
  }
  
  private void n()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, null, null, 2131561842, 2131562463, null, null);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    localQQCustomDialog.setMessage(2131563364);
    localQQCustomDialog.setDividerGone();
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    ehx localehx = new ehx(this);
    ehy localehy = new ehy(this);
    localQQCustomDialog.setOnDismissListener(new ehz(this));
    localQQCustomDialog.setPositiveButton(2131562463, localehx);
    localQQCustomDialog.setNegativeButton(2131561842, localehy);
    localQQCustomDialog.show();
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(9);
    if (localQZoneManagerImp != null) {
      return localQZoneManagerImp.a(QZoneManager.FeedType.mySpacefeed);
    }
    return 0;
  }
  
  public UpgradeDetailWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.b(this.jdField_b_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(this.jdField_a_of_type_ComTencentMobileqqAppSecSigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = new SdCardChangeListener(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener.a(0);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addDataScheme("file");
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener, localIntentFilter);
    if (Build.VERSION.RELEASE.startsWith("L"))
    {
      System.out.println("SecShell : art L");
      return;
    }
    l();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt1, paramInt2, paramObject);
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", 0);
    localIntent.putExtra("logoutForEUunder16", true);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundSettingActivity.f();
    BadgeUtils.d(paramQQAppInterface.a(), 0);
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("unreadcount", 0).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    }
    int i = QQSettingUtil.a(paramActivity, paramQQAppInterface.a());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.a(), i + 1);
    paramActivity.startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  public void a(SplashActivity paramSplashActivity)
  {
    if (!paramSplashActivity.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
      paramSplashActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).requests(new eiu(this, paramSplashActivity));
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    SystemUtil.a(BaseApplicationImpl.getContext());
    boolean bool2;
    if ((AppSetting.a == 537032257) && (SplashActivityCore.checkDebugVersion(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramQQAppInterface)))
    {
      bool2 = true;
      return bool2;
    }
    Object localObject;
    if (NotificationActivity.a == null)
    {
      ReportLog.a(paramQQAppInterface.getAccount());
      localObject = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "QQIniUrl");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        ReportLog.g = ((String)localObject).trim();
      }
      ReportLog.a(null, "SplashActivity onCreate()");
      localObject = paramQQAppInterface.a();
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label308;
      }
      localObject = "0";
    }
    label308:
    for (;;)
    {
      ((ServerConfigManager)paramQQAppInterface.getManager(4)).report((byte)4, "", AppSetting.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, (String)localObject));
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getSharedPreferences("mobileQQi", 0);
      localObject = paramQQAppInterface.edit();
      ((SharedPreferences.Editor)localObject).remove("firstTimeRun");
      ((SharedPreferences.Editor)localObject).commit();
      SplashActivityCore.reportDeviceStat(paramQQAppInterface, "", this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getAppRuntime().isLogin()) {
        if (GesturePWDUtils.getSplashLock(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getAppRuntime().getAccount()))
        {
          GesturePWDUtils.setStartFromSplash(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, true);
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, LoginActivity.class));
        }
        bool2 = bool1;
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("SplashActivity", 4, "MainActivity firstInit : " + bool1);
        return bool1;
        GesturePWDUtils.mEnterFromSplash = false;
        bool1 = false;
        continue;
        GesturePWDUtils.mEnterFromSplash = false;
        bool1 = true;
      }
      return false;
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return 0;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(11);
    if (localGameCenterManagerImp != null) {
      return localGameCenterManagerImp.a();
    }
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.d(this.jdField_b_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.c(this.jdField_a_of_type_ComTencentMobileqqAppSecSigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener);
  }
  
  public void c()
  {
    ThreadManager.a().schedule(new eht(this), 500L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b;
      if (this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.c(localQQAppInterface);
      }
      BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  public void e()
  {
    new Timer().schedule(new eiy(this), 500L);
  }
  
  public void f()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563349));
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563363), new ehv(this));
    localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131561842), new ehw(this));
    localQQCustomDialog.show();
  }
  
  public void g()
  {
    int j = 1;
    int k = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b;
    int i = k;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null)
    {
      i = k;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label177;
        }
        i = 1;
        if (i == 0) {
          break label404;
        }
        if (ConfigHandler.a((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp)) {
          break label182;
        }
        i = j;
      }
    }
    label404:
    for (;;)
    {
      try
      {
        localObject = ((RedTouchManager)((QQAppInterface)localObject).getManager(34)).b();
        if (((RedTouchInfo)localObject).h <= 0) {
          break label187;
        }
        a(35, 16, Integer.valueOf(((RedTouchInfo)localObject).h));
        a(35, 17, Boolean.valueOf(false));
        a(35, 18, Boolean.valueOf(false));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label177:
      i = 0;
      break;
      label182:
      i = 0;
      continue;
      label187:
      if (localException.g > 0)
      {
        a(35, 17, Boolean.valueOf(true));
        a(35, 16, Integer.valueOf(0));
        a(35, 18, Boolean.valueOf(false));
        return;
      }
      if ((localException.f > 0) || (localException.i > 0))
      {
        if (i != 0)
        {
          a(35, 17, Boolean.valueOf(true));
          a(35, 16, Integer.valueOf(0));
          a(35, 18, Boolean.valueOf(false));
          return;
        }
        a(35, 18, Boolean.valueOf(true));
        a(35, 16, Integer.valueOf(0));
        a(35, 17, Boolean.valueOf(false));
        return;
      }
      if (i != 0)
      {
        a(35, 17, Boolean.valueOf(true));
        a(35, 16, Integer.valueOf(0));
        a(35, 18, Boolean.valueOf(false));
        return;
      }
      a(35, 16, Integer.valueOf(0));
      a(35, 17, Boolean.valueOf(false));
      a(35, 18, Boolean.valueOf(false));
      return;
    }
  }
  
  public void h()
  {
    int i;
    int j;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b;
      localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(34)).a();
      i = ((RedTouchInfo)localObject).g;
      j = ((RedTouchInfo)localObject).f;
      k = ((RedTouchInfo)localObject).i;
      if (a() + b() > 0)
      {
        a(34, 16, Integer.valueOf(a() + b()));
        a(34, 17, Boolean.valueOf(false));
        a(34, 18, Boolean.valueOf(false));
      }
    }
    else
    {
      return;
    }
    if (i > 0)
    {
      a(34, 17, Boolean.valueOf(true));
      a(34, 18, Boolean.valueOf(false));
      a(34, 16, Integer.valueOf(0));
      return;
    }
    if ((j > 0) || (k > 0) || (a()))
    {
      a(34, 17, Boolean.valueOf(false));
      a(34, 18, Boolean.valueOf(true));
      a(34, 16, Integer.valueOf(0));
      return;
    }
    a(34, 17, Boolean.valueOf(false));
    a(34, 18, Boolean.valueOf(false));
    a(34, 16, Integer.valueOf(0));
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b;
    g();
    Object localObject = (NewFriendManager)localQQAppInterface.getManager(32);
    if ((localQQAppInterface.a() != null) && (localQQAppInterface.a().b(AppConstants.R, 4000))) {}
    for (int i = ((NewFriendManager)localObject).a();; i = 0)
    {
      localObject = localQQAppInterface.a();
      if (localObject != null)
      {
        a(32, 16, Integer.valueOf(i + ((QQMessageFacade)localObject).f()));
        localObject = new Intent("com.tencent.qqi.syncQQMessage");
        localQQAppInterface.a().sendBroadcast((Intent)localObject);
      }
      h();
      return;
    }
  }
  
  public void j()
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b != null) && (GesturePWDUtils.getGestureUnlockFailed(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a())))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131562890);
      if (GesturePWDUtils.getGestureUnlockFailedType(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity) != 1) {
        break label167;
      }
    }
    label167:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563130);; localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563043))
    {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, str, (String)localObject, 2131561746, 2131562791, new eiw(this), new eix(this)).show();
      return;
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(9);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localQZoneManager.a(2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a.e();
      }
    }
  }
  
  public void l()
  {
    System.out.println("consolidateMethod");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver
 * JD-Core Version:    0.7.0.1
 */