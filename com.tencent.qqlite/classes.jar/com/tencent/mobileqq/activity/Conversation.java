package com.tencent.mobileqq.activity;

import agg;
import agh;
import agl;
import agm;
import ago;
import agp;
import agq;
import agr;
import ags;
import agt;
import agv;
import agw;
import agx;
import agy;
import agz;
import aha;
import ahb;
import ahc;
import ahd;
import ahe;
import ahf;
import ahi;
import ahj;
import ahk;
import ahl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.newfriend.NewFriendPushListener;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.LbsTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.CustomHorizontalLoadingBar;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.Constants.LogoutReason;

public class Conversation
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, RadioGroup.OnCheckedChangeListener, UpgradeTipsDialog.OnPreparedListener, OnRecentUserOpsListener, AppConstants, AbsListView.OnScrollListener, OverScrollViewListener, Observer
{
  public static final int A = 1020;
  public static final int B = 1021;
  public static final int C = 1022;
  public static final int D = 1023;
  public static final int E = 1024;
  public static final int F = 1025;
  public static final int G = 1030;
  public static final int H = 1134026;
  public static final int I = 1035;
  public static final int J = 9001;
  public static final int K = 16;
  protected static final int L = 1;
  protected static final int M = 0;
  protected static final int N = 1;
  protected static final int O = 2;
  protected static final int P = 3;
  public static final int Q = 0;
  public static final int R = 1;
  private static final int V = 12;
  private static final int W = 11;
  private static final int X = 10;
  private static final int Y = 9;
  private static final int Z = 8;
  public static final int a = 10000;
  protected static final long a = 300000L;
  public static final String a = "conversation";
  private static final int ad = 5;
  public static final int b = 10001;
  public static final String b = "from";
  public static final int c = 10002;
  public static final String c = "conversation_index";
  public static final int d = 1009;
  private static final String jdField_d_of_type_JavaLangString = "Q.recent";
  public static final int e = 11340003;
  public static final int f = 11340004;
  public static final int g = 11340006;
  public static final int h = 11340007;
  public static final int i = 1134010;
  public static final int j = 1134011;
  public static final int k = 1134012;
  public static final int l = 1134013;
  public static final int m = 1134014;
  public static final int n = 1134015;
  public static final int o = 1134018;
  public static final int p = 1134019;
  public static final int q = 1134020;
  public static final int r = 1134021;
  public static final int s = 1134022;
  public static final int t = 1134024;
  public static final int u = 1010;
  public static final int v = 1013;
  public static final int w = 1014;
  public static final int x = 1016;
  public static final int y = 1017;
  public static final int z = 1019;
  private ahl jdField_a_of_type_Ahl;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new agr(this);
  protected Handler.Callback a;
  public Handler a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected QQSettingMe a;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog;
  private SearchResultDialog jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  public BannerManager a;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  protected BizTroopObserver a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new agl(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new ahk(this);
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new agp(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new agm(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ahf(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new agh(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ahi(this);
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ago(this);
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private NewFriendPushListener jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener = new agt(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new agq(this);
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new agw(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  final AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ahb(this);
  private CustomHorizontalLoadingBar jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar;
  protected StringBuilder a;
  Comparator jdField_a_of_type_JavaUtilComparator = new agv(this);
  public List a;
  public boolean a;
  private int aa = 0;
  private int ab = -1;
  private int ac;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new ags(this);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private List jdField_b_of_type_JavaUtilList = new ArrayList(40);
  protected boolean b;
  private long jdField_c_of_type_Long;
  private Handler jdField_c_of_type_AndroidOsHandler = new ahc(this);
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private long e = 0L;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
  public Conversation()
  {
    this.jdField_b_of_type_Long = 2000L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new agg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ahj(this);
  }
  
  private void A()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    a(1010, 0L, false);
    a(1023, 0L, false);
    x();
    VipBannerInfo.a(this);
    if (!this.jdField_b_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2);
    }
    B();
  }
  
  private void B()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "addObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localObject != null) {
      ((RedTouchManager)localObject).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { LbsTransfileProcessor.class, BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    a().app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    try
    {
      localObject = new IntentFilter("com.tencent.qqlite.action.PC_STATUS_MANAGE");
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = new IntentFilter("android.intent.action.TIME_SET");
      ((IntentFilter)localObject).addAction("android.intent.action.DATE_CHANGED");
      ((IntentFilter)localObject).addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.recent", 2, localException.toString());
    }
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "removeObservers");
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
      localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
      if (localObject != null) {
        ((RedTouchManager)localObject).deleteObserver(this);
      }
    }
    try
    {
      localObject = a();
      ((BaseActivity)localObject).app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      ((BaseActivity)localObject).unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      ((BaseActivity)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.recent", 2, localException.toString());
    }
  }
  
  private int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    long l1 = Math.max(paramRecentUser1.lastmsgtime, paramRecentUser1.lastmsgdrafttime);
    long l2 = Math.max(paramRecentUser2.lastmsgtime, paramRecentUser2.lastmsgdrafttime);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
  
  private void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  private int b(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    long l1 = paramRecentUser1.showUpTime;
    long l2 = paramRecentUser2.showUpTime;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
  
  private void b(long paramLong)
  {
    if (this.f) {
      a(1016, paramLong, true);
    }
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((ConfigHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new ahd(this));
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "changeConversationLoadingState|[" + paramBoolean + "," + bool1 + "," + bool2 + "]");
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(3);
    }
    if ((bool1) || (bool2)) {
      a(false, true);
    }
    do
    {
      do
      {
        return;
        int i1 = LoadingStateManager.a().a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "changeConversationLoadingState|loadingState = " + i1);
        }
        switch (i1)
        {
        default: 
          return;
        case 0: 
        case 3: 
          a(false, false);
          return;
        case 1: 
          a(true, false);
        }
      } while (this.jdField_c_of_type_AndroidOsHandler.hasMessages(4));
      this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 180000L);
      return;
      a(true, false);
    } while (this.jdField_c_of_type_AndroidOsHandler.hasMessages(3));
    this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 180000L);
    return;
    a(false, true);
  }
  
  private void o()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.i);
    }
    if (this.i) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1025);
    this.i = true;
    if (!this.j) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    m();
    BaseApplicationImpl.a.onActivityFocusChanged(a(), true);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b("9998", 0) == null) {}
    String str;
    do
    {
      return;
      str = SystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((str != null) && (!str.equals("")));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.q());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.q() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
    }
  }
  
  private void s()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
    int i1 = this.ab + 1;
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
        if (!(localObject instanceof RecentBaseData))
        {
          i1 += 1;
        }
        else
        {
          localObject = (RecentBaseData)localObject;
          if (((RecentBaseData)localObject).a())
          {
            i2 = ((RecentBaseData)localObject).b();
            label124:
            if (i2 <= 0) {
              break label173;
            }
            this.ab = i1;
          }
        }
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.ab + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.k(), 0);
        return;
      }
      q();
      this.ab = -1;
      return;
      i2 = 0;
      break label124;
      label173:
      break;
    }
  }
  
  private void t()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.e);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (str != null)
      {
        TimeManager.a().a(str);
        TimeManager.a().a();
        this.e = l1;
      }
    }
  }
  
  private void u()
  {
    w();
    b(800L);
    c(true);
  }
  
  private void v()
  {
    if (!LoadingStateManager.a().c()) {
      a(false, false);
    }
  }
  
  private void w()
  {
    if (LoadingStateManager.a().c()) {
      LoadingStateManager.a().a(3);
    }
  }
  
  private void x()
  {
    if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.show();
      ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ConfigHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131297286));
    this.jdField_a_of_type_Ahl = new ahl(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Ahl, false);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131296564));
    this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar = ((CustomHorizontalLoadingBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296882));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296881));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837635);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager = new BannerManager(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    List localList = RecentDataListManager.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(localList);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
  }
  
  private void z()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent", 4, "initUiLater, isLoadUILater = " + this.j);
    }
    if (this.j) {
      return;
    }
    this.j = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2130903274, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) && (this.jdField_b_of_type_Boolean)) {}
    a(1010, 0L, false);
    a(1023, 0L, false);
    x();
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(12);
  }
  
  public int a()
  {
    return 2;
  }
  
  protected int a(String paramString, int paramInt)
  {
    int i2 = 4;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = 0;
    case 1000: 
    case 1004: 
    case 1006: 
    case 0: 
      do
      {
        return i1;
        i1 = i2;
      } while (!RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
      return 1;
    case 3000: 
      return 2;
    case 1: 
      if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(paramString)) {
        return 7;
      }
      break;
    case 1001: 
    case 1003: 
      return 5;
    case 1005: 
      return 6;
    case 1008: 
    case 1009: 
    case 1020: 
    case 1022: 
      return 7;
    case 5000: 
      return 8;
    case 7200: 
      return 9;
    case 6000: 
      return 10;
    case 7000: 
      return 11;
    }
    return 3;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    StartupTracker.a(null, "Recent_Start");
    StartupTracker.a(null, "Recent_CreateView");
    Object localObject1 = a();
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localObject1;
      localObject1 = ((SplashActivity)localObject2).a;
      ((SplashActivity)localObject2).a = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramLayoutInflater.inflate(2130903127, null);
      }
      StartupTracker.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  protected String a()
  {
    String str = a(2131362950);
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i1;
    if (localQQMessageFacade != null)
    {
      i1 = localQQMessageFacade.e();
      if (i1 > 0) {}
    }
    else
    {
      return str;
    }
    if (i1 > 99) {
      return str + "(99+)";
    }
    return str + "(" + i1 + ")";
  }
  
  protected void a()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    y();
    b(false);
    StartupTracker.a("Recent_OnCreate", null);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    }
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
              return;
            } while (a() == null);
            a().setCanLock(false);
            return;
          } while (paramInt2 != 0);
          r();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
          return;
        } while ((-1 != paramInt2) || (paramIntent == null));
        paramIntent = paramIntent.getStringExtra("roomId");
      } while (paramIntent == null);
      String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().getApplicationContext(), paramIntent);
      Intent localIntent = new Intent(a(), ChatActivity.class);
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", str);
      RecentUtil.a(localIntent);
      a(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
      return;
    } while (paramInt2 != -1);
    QQToast.a(a(), 2, a(2131364144), 0).b(a().getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (this.jdField_b_of_type_AndroidOsHandler == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshRecentList|invalidate to refresh");
      }
      return;
    }
    if (!c())
    {
      this.h = false;
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(11);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramObject;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
    this.h = true;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
    {
      if (this.f) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str1;
    RecentUserProxy localRecentUserProxy;
    String str2;
    int i1;
    if (paramBoolean)
    {
      str1 = "1";
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      str2 = paramRecentBaseData.a();
      if (paramInt != 5000) {
        break label150;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, paramBoolean);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", str1, paramString, "");
      i1 = a(paramRecentBaseData.a(), paramInt);
      paramRecentBaseData = localRecentUserProxy.b().iterator();
      paramInt = 0;
      label109:
      if (!paramRecentBaseData.hasNext()) {
        break label337;
      }
      if (((RecentUser)paramRecentBaseData.next()).showUpTime == 0L) {
        break label376;
      }
      paramInt += 1;
    }
    label150:
    label239:
    label245:
    label376:
    for (;;)
    {
      break label109;
      str1 = "0";
      break;
      i1 = paramRecentBaseData.a();
      if ((str2 == null) || (str2.length() == 0) || (localRecentUserProxy == null))
      {
        if (QLog.isColorLevel())
        {
          paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
          if (str2 != null) {
            break label239;
          }
          paramBoolean = true;
          paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
          if (localRecentUserProxy != null) {
            break label245;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          QLog.d("Q.recent", 2, paramBoolean);
          return;
          paramBoolean = false;
          break;
        }
      }
      RecentUser localRecentUser = localRecentUserProxy.b(str2, i1);
      paramString = localRecentUser;
      if (localRecentUser == null)
      {
        paramString = new RecentUser();
        paramString.uin = str2;
        paramString.type = i1;
      }
      if (paramBoolean) {}
      for (paramString.showUpTime = System.currentTimeMillis();; paramString.showUpTime = 0L)
      {
        localRecentUserProxy.a(paramString);
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1009);
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, str1, String.valueOf(paramInt), String.valueOf(i1), "");
      return;
    }
  }
  
  protected void a(int paramInt, RecentUser paramRecentUser)
  {
    if ((paramRecentUser == null) || (paramInt == 0)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshAfterClick|[" + paramRecentUser + "," + paramInt + "]");
      }
    }
    do
    {
      return;
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(paramRecentUser.uin);
      }
    } while ((paramInt & 0x2) == 0);
    a(8, paramRecentUser.uin, paramRecentUser.type);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(0, paramInt1, RecentDataListManager.a(paramString, paramInt2));
  }
  
  public void a(int paramInt, List paramList)
  {
    if (-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a())
    {
      this.jdField_a_of_type_Ahl.a(paramInt, paramList);
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        if (AppSetting.l) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o();
        }
      }
      return;
    }
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList != null) {
        break label194;
      }
    }
    label194:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.i("Q.recent", 4, i1 + "]");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        if (paramInt != 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      }
      if (AppSetting.l) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.y();
      a(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10001, null));
      c(false);
      return;
    }
    if (paramList == null)
    {
      paramInt = 0;
      label210:
      i1 = 0;
      label212:
      if (i1 < paramInt)
      {
        localObject = (RecentBaseData)paramList.get(i1);
        if (localObject != null) {
          break label251;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label212;
      break;
      paramInt = paramList.size();
      break label210;
      label251:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((RecentBaseData)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    a(0, 10, Long.valueOf(paramLong));
  }
  
  public void a(Message paramMessage)
  {
    int i2 = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
    }
    boolean bool;
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        bool = false;
        if (!bool) {
          break label231;
        }
        u();
        label50:
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "refreshStatusInfo bShowNetBar=" + bool);
        }
        LoadingStateManager.a().a(bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(4, 0);
          }
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
          if (!bool) {
            break label238;
          }
          i1 = 2;
          label129:
          paramMessage.a(1, i1);
          bool = LoadingStateManager.a().e();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
          if (!bool) {
            break label243;
          }
        }
      }
    }
    label231:
    label238:
    label243:
    for (int i1 = i2;; i1 = 0)
    {
      paramMessage.a(5, i1);
      LoadingStateManager.a().b(bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(null);
      return;
      bool = true;
      break;
      if (paramMessage.obj.toString().equals(a(2131362790)))
      {
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          bool = false;
          break;
        }
        bool = true;
        break;
      }
      bool = false;
      break;
      v();
      break label50;
      i1 = 0;
      break label129;
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new agx(this, a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new agy(this, paramView, l1));
    localTranslateAnimation2.setAnimationListener(new agz(this, paramView));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(new aha(this, paramView, localTranslateAnimation2));
    paramView.startAnimation(localTranslateAnimation1);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      StartupTracker.a(null, "AIO_Click_cost");
      ThreadPriorityManager.a(true);
      if (!(paramRecentBaseData instanceof RecentUserBaseData)) {
        break label74;
      }
    }
    label74:
    for (paramView = ((RecentUserBaseData)paramRecentBaseData).a();; paramView = null)
    {
      a(RecentUtil.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean), paramView);
      if (paramRecentBaseData != null)
      {
        paramRecentBaseData.b();
        this.h = true;
      }
      StartupTracker.a("AIO_Click_cost", null);
      return;
    }
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean)
  {
    paramView = paramContactsSearchableRecentUser.a();
    a(RecentUtil.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean), paramView);
    paramContactsSearchableRecentUser = new SearchHistory();
    paramContactsSearchableRecentUser.type = paramView.type;
    paramContactsSearchableRecentUser.uin = paramView.uin;
    paramContactsSearchableRecentUser.troopUin = paramView.troopUin;
    paramContactsSearchableRecentUser.displayName = paramString;
    paramString = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        paramString.a(paramContactsSearchableRecentUser);
        paramContactsSearchableRecentUser = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      } while (paramContactsSearchableRecentUser == null);
      paramView = paramContactsSearchableRecentUser.c(paramView.uin);
    } while ((paramView == null) || (paramView.gathtertype != 1));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C58", "0X8004C58", 2, 0, "", "", "", "");
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if ((paramView == null) && (QLog.isDevelopLevel())) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    x();
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      RecentUser localRecentUser = null;
      if ((paramRecentBaseData instanceof RecentUserBaseData)) {
        localRecentUser = ((RecentUserBaseData)paramRecentBaseData).a();
      }
      if (localRecentUser != null) {
        RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    for (;;)
    {
      return;
      this.aa = paramInt;
      if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
      {
        if ((paramInt != 0) && (paramInt != 1)) {
          break label93;
        }
        this.ab = (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.q() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.k());
        if (this.ab < -1) {
          this.ab = -1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
        }
      }
      while ((paramInt == 0) && (this.h))
      {
        a(100L);
        return;
        label93:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
      a(i1, paramRecentBaseData, paramString2, false);
    }
    for (;;)
    {
      if ((i1 == 1) && (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]))))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800416B", "0X800416B", 0, 0, "0", "", paramString2, "");
      }
      return;
      if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3]))) {
        a(i1, paramRecentBaseData, paramString2, true);
      }
    }
  }
  
  protected void a(List paramList)
  {
    int i1 = 0;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, [");
      }
    }
    else {
      if (paramList != null) {
        break label143;
      }
    }
    for (;;)
    {
      i1 -= 1;
      while (i1 >= 0)
      {
        RecentUser localRecentUser = (RecentUser)paramList.get(i1);
        if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
        {
          paramList.remove(i1);
          if (QLog.isDevelopLevel()) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(i1).append(",").append(localRecentUser.type).append(";");
          }
        }
        i1 -= 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      break;
      label143:
      i1 = paramList.size();
    }
    if (QLog.isDevelopLevel())
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("]");
      QLog.i("Q.recent", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.f))
    {
      this.f = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.B();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(12, 0);
    RecentDataListManager.a().a();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i2 = 2;
    super.a(paramBoolean);
    TimeManager.a().e();
    if (AppSetting.l) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(true);
    }
    this.jdField_c_of_type_Boolean = true;
    a().getWindow().setSoftInputMode(32);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      paramBoolean = LoadingStateManager.a().e();
      BannerManager localBannerManager = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (paramBoolean)
      {
        i1 = 2;
        localBannerManager.a(5, i1);
        LoadingStateManager.a().b(paramBoolean);
        if (!FileViewMusicService.a().a()) {
          break label261;
        }
        i1 = 1;
        label95:
        localBannerManager = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
        if (i1 == 0) {
          break label266;
        }
        i1 = i2;
        label107:
        localBannerManager.a(16, i1);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent != null))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent = null;
      }
      this.aa = 0;
      if (!this.i) {
        break label271;
      }
      if (this.jdField_b_of_type_Long != 1000L) {
        this.jdField_b_of_type_Long = 1000L;
      }
      if (!this.j) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1020);
      }
      if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      }
      a(0L);
      m();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1030, 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      return;
      i1 = 0;
      break;
      label261:
      i1 = 0;
      break label95;
      label266:
      i1 = 0;
      break label107;
      label271:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1025, 3000L);
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext)
  {
    super.a(paramBoolean, paramContext);
    if ((paramBoolean) && ((paramContext instanceof OnDrawCompleteListener))) {
      new Handler().postDelayed(new ahe(this, paramContext), 800L);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar.setVisibility(8);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.f)) {}
    do
    {
      do
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
        e_();
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
    } while (!QLog.isColorLevel());
    QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
    return true;
  }
  
  protected boolean a(Message paramMessage)
  {
    return ((this.jdField_c_of_type_Boolean) || (paramMessage.arg1 != 0)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.i();
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.f)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  protected void b(List paramList)
  {
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("unreadinfo, [");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if ((localRecentBaseData != null) && (localRecentBaseData.v > 0)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.a()).append("-").append(localRecentBaseData.a()).append("-").append(localRecentBaseData.v).append(" , ");
          }
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("]");
      QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  /* Error */
  protected void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 307	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +48 -> 51
    //   6: ldc 88
    //   8: iconst_4
    //   9: new 627	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 628	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1409
    //   19: invokevirtual 634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 637	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 639
    //   29: invokevirtual 634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 202	com/tencent/mobileqq/activity/Conversation:i	Z
    //   36: invokevirtual 637	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 641
    //   42: invokevirtual 634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 642	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 530	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   55: ifnonnull +18 -> 73
    //   58: aload_0
    //   59: new 945	com/tencent/mobileqq/utils/CustomHandler
    //   62: dup
    //   63: invokestatic 1413	com/tencent/mobileqq/app/ThreadManager:c	()Landroid/os/Looper;
    //   66: aload_0
    //   67: invokespecial 954	com/tencent/mobileqq/utils/CustomHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   70: putfield 530	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   73: iload_1
    //   74: ifeq +21 -> 95
    //   77: aload_0
    //   78: getfield 1394	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe	Lcom/tencent/mobileqq/activity/QQSettingMe;
    //   81: ifnull +14 -> 95
    //   84: aload_0
    //   85: getfield 1394	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe	Lcom/tencent/mobileqq/activity/QQSettingMe;
    //   88: aload_0
    //   89: getfield 326	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 1414	com/tencent/mobileqq/activity/QQSettingMe:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   95: aload_0
    //   96: invokespecial 1416	com/tencent/mobileqq/activity/Conversation:C	()V
    //   99: iload_1
    //   100: ifeq +182 -> 282
    //   103: invokestatic 650	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   106: invokevirtual 1417	com/tencent/mobileqq/managers/LoadingStateManager:a	()V
    //   109: invokestatic 871	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   112: invokevirtual 1331	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()V
    //   115: aload_0
    //   116: getfield 185	com/tencent/mobileqq/activity/Conversation:f	Z
    //   119: ifeq +22 -> 141
    //   122: aload_0
    //   123: getfield 542	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   126: ifnull +15 -> 141
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 185	com/tencent/mobileqq/activity/Conversation:f	Z
    //   134: aload_0
    //   135: getfield 542	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   138: invokevirtual 1418	com/tencent/mobileqq/fpsreport/FPSSwipListView:C	()V
    //   141: aload_0
    //   142: getfield 533	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   145: ifnull +15 -> 160
    //   148: aload_0
    //   149: getfield 533	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   152: invokevirtual 1421	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 533	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   160: aload_0
    //   161: getfield 1052	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   164: ifnull +14 -> 178
    //   167: aload_0
    //   168: getfield 1052	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   171: aload_0
    //   172: getfield 326	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   175: invokevirtual 1422	com/tencent/mobileqq/activity/recent/RecentTroopMenuOption:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   178: aload_0
    //   179: getfield 539	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   182: ifnull +47 -> 229
    //   185: aload_0
    //   186: getfield 539	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   189: aload_0
    //   190: getfield 326	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   193: invokevirtual 1423	com/tencent/mobileqq/activity/recent/RecentAdapter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   196: aload_0
    //   197: getfield 530	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   200: ifnull +29 -> 229
    //   203: invokestatic 380	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +12 -> 218
    //   209: ldc 88
    //   211: iconst_2
    //   212: ldc_w 1425
    //   215: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: iconst_1
    //   220: bipush 10
    //   222: lconst_0
    //   223: invokestatic 673	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   226: invokevirtual 676	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   229: aload_0
    //   230: getfield 621	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   233: ifnull +10 -> 243
    //   236: aload_0
    //   237: getfield 621	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   240: invokevirtual 1427	com/tencent/mobileqq/activity/recent/BannerManager:c	()V
    //   243: aload_0
    //   244: getfield 202	com/tencent/mobileqq/activity/Conversation:i	Z
    //   247: ifeq +13 -> 260
    //   250: aload_0
    //   251: getfield 530	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   254: bipush 12
    //   256: invokevirtual 597	android/os/Handler:sendEmptyMessage	(I)Z
    //   259: pop
    //   260: aload_0
    //   261: sipush 1035
    //   264: ldc2_w 1275
    //   267: iconst_0
    //   268: invokespecial 315	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   271: aload_0
    //   272: sipush 1010
    //   275: ldc2_w 1275
    //   278: iconst_1
    //   279: invokespecial 315	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   282: aload_0
    //   283: sipush 10001
    //   286: ldc2_w 1428
    //   289: iconst_0
    //   290: invokespecial 315	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   293: aload_0
    //   294: invokevirtual 1431	com/tencent/mobileqq/activity/Conversation:j	()V
    //   297: return
    //   298: astore_2
    //   299: aload_0
    //   300: aconst_null
    //   301: putfield 533	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   304: goto -144 -> 160
    //   307: astore_2
    //   308: aload_0
    //   309: aconst_null
    //   310: putfield 533	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   313: aload_2
    //   314: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	Conversation
    //   0	315	1	paramBoolean	boolean
    //   298	1	2	localException	Exception
    //   307	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   148	155	298	java/lang/Exception
    //   148	155	307	finally
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void c()
  {
    super.c();
    s();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean c()
  {
    return (this.aa != 0) && (this.aa != 1);
  }
  
  protected void d()
  {
    super.d();
    if (AppSetting.l) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
    }
    TimeManager.a().d();
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  protected void e()
  {
    this.g = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    TimeManager.a().b();
    D();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.a().a();
    TroopRemindSettingManager.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.c();
    }
    NewFriendManager localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    if (localNewFriendManager != null) {
      localNewFriendManager.a(null);
    }
    super.e();
  }
  
  public void e_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.f = true;
      w();
      c(true);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5);
      if ((bool1) || (bool2)) {
        b(800L);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e();
    b(60000L);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent", 4, "fillData()");
    }
    b(true);
  }
  
  protected void g()
  {
    D();
  }
  
  public void h()
  {
    a(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    TraceUtils.a("conv.handleMessage");
    if ((this.g) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i1;
    if (paramMessage.what == 10)
    {
      if (!a(paramMessage)) {
        return true;
      }
      p();
      TroopAssistantManager.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      t();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      a((List)localObject1);
      paramMessage = RecentDataListManager.a().a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject3 = a();
      if (localObject1 != null)
      {
        i1 = ((List)localObject1).size();
        ConversationDataFactory.a((List)localObject1, (QQAppInterface)localObject2, (Context)localObject3, paramMessage, i1);
        Collections.sort(paramMessage, this.jdField_a_of_type_JavaUtilComparator);
        localObject1 = new ArrayList(paramMessage);
        Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000, 0, 0, localObject1).sendToTarget();
        b(paramMessage);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.d();
        }
        this.jdField_b_of_type_JavaUtilList.clear();
        this.ac = 0;
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
      }
    }
    label372:
    label1404:
    do
    {
      for (;;)
      {
        TraceUtils.a();
        return true;
        i1 = 0;
        break;
        int i2;
        if (paramMessage.what == 9)
        {
          if (!a(paramMessage)) {
            return true;
          }
          t();
          localObject2 = RecentDataListManager.a().a();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
          a((List)localObject3);
          ((List)localObject2).clear();
          RecentUser localRecentUser;
          String str;
          if (localObject3 == null)
          {
            i1 = 0;
            i2 = 0;
            if (i2 >= i1) {
              break label561;
            }
            localRecentUser = (RecentUser)((List)localObject3).get(i2);
            str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.type);
            localObject1 = RecentDataListManager.a().a(str);
            if (localObject1 != null) {
              break label474;
            }
            paramMessage = ConversationDataFactory.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
            RecentDataListManager.a().a(paramMessage, str);
          }
          for (;;)
          {
            if (paramMessage != null) {
              ((List)localObject2).add(paramMessage);
            }
            i2 += 1;
            break label372;
            i1 = ((List)localObject3).size();
            break;
            paramMessage = (Message)localObject1;
            if (this.jdField_b_of_type_JavaUtilList != null) {
              if (!this.jdField_b_of_type_JavaUtilList.contains(str))
              {
                paramMessage = (Message)localObject1;
                if (!this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(localRecentUser.uin, -2147483648))) {}
              }
              else
              {
                if ((localObject1 instanceof RecentUserBaseData)) {
                  ((RecentUserBaseData)localObject1).a(localRecentUser);
                }
                ((RecentBaseData)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
                paramMessage = (Message)localObject1;
              }
            }
          }
          Collections.sort((List)localObject2, this.jdField_a_of_type_JavaUtilComparator);
          paramMessage = new ArrayList((Collection)localObject2);
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000, 0, 0, paramMessage).sendToTarget();
          b((List)localObject2);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.d();
          }
          if (this.ac <= 9) {
            this.ac = 0;
          }
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          }
        }
        else if (paramMessage.what == 8)
        {
          if (!a(paramMessage)) {
            return true;
          }
          paramMessage = RecentDataListManager.a().a();
          if ((this.jdField_b_of_type_JavaUtilList == null) || (paramMessage == null))
          {
            i1 = 0;
            localObject1 = new ArrayList(i1);
            i2 = 0;
            if (i2 >= i1) {}
          }
          else
          {
            for (;;)
            {
              try
              {
                localObject2 = (RecentBaseData)paramMessage.get(i2);
                if (localObject2 != null) {
                  break label830;
                }
                i2 += 1;
              }
              catch (Exception paramMessage)
              {
                if (!QLog.isDevelopLevel()) {
                  continue;
                }
                QLog.e("Q.recent", 4, paramMessage.toString());
                return true;
              }
              i1 = paramMessage.size();
              break;
              localObject3 = RecentDataListManager.a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
              if ((this.jdField_b_of_type_JavaUtilList.contains(localObject3)) || (this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(((RecentBaseData)localObject2).a(), -2147483648))))
              {
                ((RecentBaseData)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
                ((List)localObject1).add(localObject2);
              }
            }
          }
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1019, 0, 0, localObject1).sendToTarget();
          b(paramMessage);
          if (this.ac <= 8)
          {
            this.ac = 0;
            this.jdField_b_of_type_JavaUtilList.clear();
          }
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          }
        }
        else if (paramMessage.what == 11)
        {
          boolean bool = a(paramMessage);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.i + "," + bool + "]");
          }
          if (!bool) {
            return true;
          }
          i2 = paramMessage.arg2;
          if ((i2 == 8) || (i2 == 9))
          {
            localObject1 = (String)paramMessage.obj;
            if (!this.jdField_b_of_type_JavaUtilList.contains(localObject1)) {
              this.jdField_b_of_type_JavaUtilList.add(localObject1);
            }
            l1 = 0L;
          }
          while (i2 >= this.ac)
          {
            i1 = 8;
            for (;;)
            {
              if (i1 < i2)
              {
                this.jdField_b_of_type_AndroidOsHandler.removeMessages(i1);
                i1 += 1;
                continue;
                l1 = ((Long)paramMessage.obj).longValue();
                break;
              }
            }
            this.ac = i2;
          }
          if ((this.i) && (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(this.ac)))
          {
            long l2 = Math.abs(System.currentTimeMillis() - this.jdField_c_of_type_Long);
            l1 = Math.max(this.jdField_b_of_type_Long - l2, l1);
            localObject1 = Message.obtain();
            ((Message)localObject1).arg1 = paramMessage.arg1;
            ((Message)localObject1).what = this.ac;
            this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, l1);
          }
        }
        else
        {
          if (paramMessage.what != 12) {
            break label1404;
          }
          TroopAssistantManager.a().j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramMessage = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          if (paramMessage != null) {
            paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          } else if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
          }
        }
      }
    } while ((paramMessage.what != 16) || (a(paramMessage)));
    label474:
    return true;
  }
  
  public void i()
  {
    d();
  }
  
  /* Error */
  public void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 326	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 1392	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 326	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 491	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   24: aload_0
    //   25: invokevirtual 1588	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   28: aload_0
    //   29: iconst_1
    //   30: invokespecial 569	com/tencent/mobileqq/activity/Conversation:c	(Z)V
    //   33: aload_0
    //   34: getfield 202	com/tencent/mobileqq/activity/Conversation:i	Z
    //   37: ifeq +8 -> 45
    //   40: aload_0
    //   41: lconst_0
    //   42: invokevirtual 1278	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   45: aload_0
    //   46: getfield 326	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   49: bipush 31
    //   51: invokevirtual 420	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   54: checkcast 1462	com/tencent/mobileqq/app/NewFriendManager
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull -45 -> 14
    //   62: aload_2
    //   63: aload_0
    //   64: getfield 288	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener	Lcom/tencent/mobileqq/newfriend/NewFriendPushListener;
    //   67: invokevirtual 1465	com/tencent/mobileqq/app/NewFriendManager:a	(Lcom/tencent/mobileqq/newfriend/NewFriendPushListener;)V
    //   70: goto -56 -> 14
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	Conversation
    //   9	2	1	bool	boolean
    //   57	6	2	localNewFriendManager	NewFriendManager
    //   73	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	73	finally
    //   17	45	73	finally
    //   45	58	73	finally
    //   62	70	73	finally
  }
  
  public void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent", 4, "onDrawComplete, [" + this.i + "," + this.g + "]");
    }
    if ((!this.i) && (!this.g))
    {
      o();
      StartupTracker.a("Recent_Start", null);
    }
    while (!this.i) {
      return;
    }
    a(1030, 0L, true);
  }
  
  public void m() {}
  
  void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label14:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {}
  
  public void onClick(View paramView) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).isSendFromLocal()) && (((MessageRecord)localObject).msgtype == -2002)) {
        break label32;
      }
    }
    label32:
    label95:
    label254:
    for (;;)
    {
      return;
      if ((!((MessageRecord)localObject).isSendFromLocal()) || (((MessageRecord)localObject).msgtype != -2000) || (this.jdField_c_of_type_Boolean))
      {
        int i2;
        int i1;
        if ((((MessageRecord)localObject).isSendFromLocal()) && (!this.jdField_c_of_type_Boolean))
        {
          i2 = 2;
          i1 = 9;
          localObject = RecentDataListManager.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
          a(i2, i1, localObject);
        }
        for (;;)
        {
          if ((!(paramObservable instanceof RedTouchManager)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo))) {
            break label254;
          }
          paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
          paramObservable = ((RedTouchManager)paramObservable).a(paramObject);
          if ((paramObservable == null) || (paramObservable.size() <= 0)) {
            break;
          }
          paramObservable = (VipBannerInfo)paramObservable.get(0);
          if ((paramObservable.e < 1) || (paramObservable.e > 4)) {
            break;
          }
          VipBannerInfo.b(this);
          return;
          if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null) && (RecentUtil.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1024))) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1024, 100L);
          }
          localObject = Long.valueOf(0L);
          i1 = 10;
          i2 = 0;
          break label95;
          if ((paramObject instanceof RecentUser)) {
            a(200L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */