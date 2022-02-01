package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ceo;
import cep;
import ceq;
import ceu;
import cev;
import cex;
import cey;
import cez;
import cfa;
import cfb;
import cfc;
import cfe;
import cff;
import cfg;
import cfi;
import cfj;
import cfk;
import cfl;
import cfm;
import cfn;
import cfo;
import cfp;
import cft;
import cfu;
import cfv;
import cfw;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentOptionBar;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
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
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.newfriend.NewFriendPushListener;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
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
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.CustomHorizontalLoadingBar;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.TraceUtils;
import java.io.File;
import java.lang.ref.WeakReference;
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
  public static final int A = 1019;
  public static final int B = 1020;
  public static final int C = 1021;
  public static final int D = 1022;
  public static final int E = 1023;
  public static final int F = 1024;
  public static final int G = 1025;
  public static final int H = 1026;
  public static final int I = 1029;
  public static final int J = 1030;
  public static final int K = 1031;
  public static final int L = 9001;
  public static final int M = 9002;
  public static final int N = 16;
  protected static final int O = 1;
  protected static final int P = 0;
  protected static final int Q = 1;
  protected static final int R = 2;
  protected static final int S = 3;
  protected static final int T = 4096;
  protected static final int U = 4097;
  protected static final int V = 4098;
  protected static final int W = 6;
  public static final int a = 10000;
  protected static final long a = 300000L;
  public static final String a = "conversation";
  public static WeakReference a;
  public static final boolean a = true;
  private static final int ad = 17;
  private static final int ae = 12;
  private static final int af = 11;
  private static final int ag = 10;
  private static final int ah = 9;
  private static final int ai = 8;
  private static final int am = 5;
  private static final int an = 1;
  private static final int ao = 2;
  private static final int ap = 3;
  private static final int aq = 4;
  public static final int b = 10001;
  public static final String b = "from";
  public static final int c = 10002;
  protected static final String c = "conversation_head_edu";
  public static final int d = 1009;
  private static final String jdField_d_of_type_JavaLangString = "Q.recent";
  public static final int e = 11340003;
  private static final String jdField_e_of_type_JavaLangString = "0X8004066";
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
  public static final int t = 1134023;
  public static final int u = 1134024;
  public static final int v = 1010;
  public static final int w = 1013;
  public static final int x = 1014;
  public static final int y = 1016;
  public static final int z = 1017;
  private long M = 0L;
  public int X = 4096;
  public int Y;
  public int Z;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cfb(this);
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private cfw jdField_a_of_type_Cfw;
  public QQSettingMe a;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog;
  public BannerManager a;
  public DrawerFrame a;
  private LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private RecentCallHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
  private RecentOptionBar jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar;
  private RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  protected BizTroopObserver a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ceu(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new cfv(this);
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new cey(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new cev(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cfp(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ceq(this);
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new cez(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new cft(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new cep(this);
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new cex(this);
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private NewFriendPushListener jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener = new cfk(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new cfa(this);
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ceo(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private CustomHorizontalLoadingBar jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar;
  protected StringBuilder a;
  Comparator jdField_a_of_type_JavaUtilComparator = new cfl(this);
  protected List a;
  protected float[] a;
  public TranslateAnimation[] a;
  private int aj = 0;
  private int ak = -1;
  private int al;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new cfc(this);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private List jdField_b_of_type_JavaUtilList = new ArrayList(40);
  protected boolean b;
  private long jdField_c_of_type_Long;
  private BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new cff(this);
  private Handler jdField_c_of_type_AndroidOsHandler = new cfe(this);
  private long jdField_d_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  
  public Conversation()
  {
    this.jdField_b_of_type_Long = 2000L;
    this.e = false;
    this.d = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new cfu(this);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 6.0F, 0.0F, -8.0F, 0.0F, 10.0F, 0.0F, -10.0F, 0.0F, 8.0F, 0.0F, -6.0F, 0.0F };
  }
  
  private void A()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = ((DragRelativeLayout)a().findViewById(2131231912));
    this.jdField_a_of_type_Cfw = new cfw(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this.jdField_a_of_type_Cfw, false);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131231116));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231420));
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231422);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231421));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231423));
    l();
    this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar = ((CustomHorizontalLoadingBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231430));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = new RecentCallHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetLinearLayout, this, this);
    }
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231428));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130838138);
    Object localObject = a().getLayoutInflater().inflate(2130903931, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, a(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager = new BannerManager(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    localObject = RecentDataListManager.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((List)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131231427));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar = new RecentOptionBar(this.jdField_a_of_type_AndroidWidgetLinearLayout, a(), this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  private void B()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent", 4, "initUiLater, isLoadUILater = " + this.j);
    }
    if (this.j) {
      return;
    }
    this.j = true;
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a().getString(2131558439));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2130903325, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.f();
    }
    a(1010, 0L, false);
    a(1023, 0L, false);
    z();
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(12);
    F();
  }
  
  private void C()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    a(1010, 0L, false);
    a(1023, 0L, false);
    if (this.X == 4097)
    {
      this.Y = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1029, 500L);
    }
    z();
    VipBannerInfo.a(this);
    if (!this.jdField_b_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2);
    }
  }
  
  private void D()
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    a().a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    if (localObject != null) {
      ((RedTouchManager)localObject).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { LbsTransfileProcessor.class, BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    a().b.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    try
    {
      localObject = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      a().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = new IntentFilter("android.intent.action.TIME_SET");
      ((IntentFilter)localObject).addAction("android.intent.action.DATE_CHANGED");
      ((IntentFilter)localObject).addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.recent", 2, localException.toString());
    }
  }
  
  private void E()
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
      localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localObject != null) {
        ((QCallFacade)localObject).deleteObserver(this);
      }
      localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (localObject != null) {
        ((RedTouchManager)localObject).deleteObserver(this);
      }
    }
    try
    {
      localObject = a();
      ((BaseActivity)localObject).b.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      ((BaseActivity)localObject).unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
      ((BaseActivity)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      ((BaseActivity)localObject).unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.recent", 2, localException.toString());
    }
  }
  
  private void F()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "initDrawerFrame, " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      return;
    }
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(localBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ViewGroup localViewGroup1 = (ViewGroup)localBaseActivity.findViewById(2131231912);
    ViewGroup localViewGroup2 = (ViewGroup)LayoutInflater.from(localBaseActivity).inflate(2130903621, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(localBaseActivity, localViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a, localViewGroup2);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(new cfi(this));
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
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
  
  private void a(String paramString)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      QQToast.a(BaseApplication.getContext(), 2131562452, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131427376));
    }
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
  
  private String b()
  {
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade == null) {
      return "";
    }
    int i1 = localQQMessageFacade.f();
    if (i1 == 0) {
      return "";
    }
    if (i1 > 99) {
      return "(99+)";
    }
    return "(" + i1 + ")";
  }
  
  private void c(long paramLong)
  {
    if (this.f) {
      a(1016, paramLong, true);
    }
  }
  
  private void c(Message paramMessage)
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
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new cfm(this));
  }
  
  public static void d(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.setDrawerEnabled(paramBoolean);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameEnable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  public static boolean d()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get(); localDrawerFrame == null; localDrawerFrame = null) {
      return false;
    }
    if ((localDrawerFrame.b()) || (localDrawerFrame.c())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(6);
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
  
  public static void n()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null) {
        localDrawerFrame.d();
      }
      return;
    }
  }
  
  public static void o()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if ((localDrawerFrame != null) && (localDrawerFrame.b())) {
        localDrawerFrame.c();
      }
      return;
    }
  }
  
  private void q()
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
    k();
    BaseApplicationImpl.a.onActivityFocusChanged(a(), true);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b("9998", 0) == null) {}
    String str;
    do
    {
      return;
      str = SystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((str != null) && (!str.equals("")));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.w();
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.q());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.q() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
    }
  }
  
  private void t()
  {
    if (this.k) {
      this.k = false;
    }
    do
    {
      return;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
    } while ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null));
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
    int i1 = this.ak + 1;
    label108:
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
            label136:
            if (i2 <= 0) {
              break label200;
            }
            this.ak = i1;
          }
        }
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.ak + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.k(), 0);
        return;
      }
      s();
      this.ak = -1;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a();
      return;
      i2 = 0;
      break label136;
      label200:
      break label108;
    }
  }
  
  private void u()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.M);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (str != null)
      {
        TimeManager.a().a(str);
        TimeManager.a().a();
        this.M = l1;
      }
    }
  }
  
  private void v()
  {
    x();
    c(800L);
    e(true);
  }
  
  private void w()
  {
    if (!LoadingStateManager.a().c()) {
      a(false, false);
    }
  }
  
  private void x()
  {
    if (LoadingStateManager.a().c()) {
      LoadingStateManager.a().a(3);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      QZoneShareAlbumAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void z()
  {
    if ((!this.a_) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a())) {
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
      localObject1 = ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView;
      ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramLayoutInflater.inflate(2130903152, null);
      }
      StartupTracker.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  protected String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      return a(2131560958);
    }
    return a(2131561807) + b();
  }
  
  protected void a()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Conversation.ConversationHandler(this);
    A();
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
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while (a() == null);
                  a().e(false);
                  return;
                } while ((-1 != paramInt2) || (paramIntent == null) || (this.jdField_b_of_type_AndroidOsHandler == null));
                localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
                ((Message)localObject).what = 17;
                ((Message)localObject).obj = paramIntent;
                ((Message)localObject).sendToTarget();
                return;
              } while (paramInt2 != 0);
              p();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k();
              return;
            } while ((-1 != paramInt2) || (paramIntent == null));
            paramIntent = paramIntent.getStringExtra("roomId");
          } while (paramIntent == null);
          Object localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().getApplicationContext(), paramIntent);
          Intent localIntent = new Intent(a(), ChatActivity.class);
          localIntent.putExtra("uin", paramIntent);
          localIntent.putExtra("uintype", 3000);
          localIntent.putExtra("uinname", (String)localObject);
          RecentUtil.a(localIntent);
          a(localIntent);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
          return;
        } while ((-1 != paramInt2) || (paramIntent == null));
        paramIntent = paramIntent.getStringExtra("roomId");
      } while (paramIntent == null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_shortcut_launch", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramIntent, true, false, null);
      return;
    } while (paramInt2 != -1);
    QQToast.a(a(), 2, a(2131563073), 0).b(a().d());
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a()) {
        this.f = false;
      }
      if (this.f) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView);
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
      paramRecentBaseData = localRecentUserProxy.a().iterator();
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
  
  protected void a(int paramInt, List paramList)
  {
    if (-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a())
    {
      this.jdField_a_of_type_Cfw.a(paramInt, paramList);
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        if (AppSetting.k) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q();
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
      if (AppSetting.k) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.C();
      b(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10001, null));
      e(false);
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
  
  public void a(int paramInt, boolean paramBoolean)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (str != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + paramInt + ", tag = " + str);
      }
      return;
      if (paramBoolean)
      {
        str = "0X800402E";
      }
      else
      {
        str = "0X800402F";
        continue;
        str = "0X8004032";
        continue;
        str = "0X8004030";
        continue;
        str = "0X8004031";
      }
    }
  }
  
  public void a(long paramLong)
  {
    a(0, 10, Long.valueOf(paramLong));
  }
  
  /* Error */
  public void a(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1144	android/os/Message:what	I
    //   4: ldc 115
    //   6: if_icmpne +13 -> 19
    //   9: aload_0
    //   10: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   13: bipush 8
    //   15: iconst_0
    //   16: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   19: aload_1
    //   20: getfield 1144	android/os/Message:what	I
    //   23: ldc 141
    //   25: if_icmpeq +14 -> 39
    //   28: aload_0
    //   29: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: invokevirtual 1338	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   35: ifne +4 -> 39
    //   38: return
    //   39: aload_1
    //   40: getfield 1144	android/os/Message:what	I
    //   43: lookupswitch	default:+297->340, 1009:+298->341, 1010:+576->619, 1014:+1145->1188, 1016:+1151->1194, 1017:+1171->1214, 1019:+1442->1485, 1020:+1183->1226, 1021:+1455->1498, 1022:+1471->1514, 1023:+624->667, 1024:+1486->1529, 1025:+524->567, 1026:+489->532, 1029:+319->362, 1030:+1501->1544, 1031:+1506->1549, 10000:+1188->1231, 10001:+529->572, 10002:+555->598, 1134010:+860->903, 1134011:+879->922, 1134012:+995->1038, 1134013:+1038->1081, 1134014:+1096->1139, 1134015:+957->1000, 1134018:+750->793, 1134019:+779->822, 1134020:+835->878, 1134021:+898->941, 1134022:+916->959, 1134023:+1177->1220, 1134024:+934->977, 11340003:+731->774, 11340004:+841->884, 11340006:+1107->1150, 11340007:+1126->1169
    //   341: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +12 -> 356
    //   347: ldc 109
    //   349: iconst_2
    //   350: ldc_w 1340
    //   353: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_0
    //   357: lconst_0
    //   358: invokevirtual 1342	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   361: return
    //   362: invokestatic 505	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   365: ifeq +45 -> 410
    //   368: ldc 109
    //   370: iconst_4
    //   371: new 507	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 1344
    //   381: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_0
    //   385: getfield 326	com/tencent/mobileqq/activity/Conversation:X	I
    //   388: invokevirtual 857	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: ldc_w 917
    //   394: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_0
    //   398: getfield 214	com/tencent/mobileqq/activity/Conversation:e	Z
    //   401: invokevirtual 517	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 521	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: aload_0
    //   411: getfield 326	com/tencent/mobileqq/activity/Conversation:X	I
    //   414: sipush 4097
    //   417: if_icmpne -379 -> 38
    //   420: aload_0
    //   421: getfield 397	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   424: ifnull -386 -> 38
    //   427: aload_0
    //   428: getfield 214	com/tencent/mobileqq/activity/Conversation:e	Z
    //   431: ifeq -393 -> 38
    //   434: aload_0
    //   435: getfield 578	com/tencent/mobileqq/activity/Conversation:Y	I
    //   438: ifle +10 -> 448
    //   441: aload_0
    //   442: getfield 1346	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation	[Landroid/view/animation/TranslateAnimation;
    //   445: ifnonnull +9 -> 454
    //   448: aload_0
    //   449: iconst_0
    //   450: invokevirtual 1348	com/tencent/mobileqq/activity/Conversation:c	(Z)V
    //   453: return
    //   454: aload_0
    //   455: getfield 578	com/tencent/mobileqq/activity/Conversation:Y	I
    //   458: bipush 6
    //   460: if_icmpge -422 -> 38
    //   463: invokestatic 505	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   466: ifeq +32 -> 498
    //   469: ldc 109
    //   471: iconst_4
    //   472: new 507	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 1350
    //   482: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_0
    //   486: getfield 578	com/tencent/mobileqq/activity/Conversation:Y	I
    //   489: invokevirtual 857	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: invokevirtual 521	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_0
    //   499: iconst_0
    //   500: putfield 1352	com/tencent/mobileqq/activity/Conversation:Z	I
    //   503: aload_0
    //   504: getfield 1346	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation	[Landroid/view/animation/TranslateAnimation;
    //   507: aload_0
    //   508: getfield 1352	com/tencent/mobileqq/activity/Conversation:Z	I
    //   511: aaload
    //   512: invokevirtual 1357	android/view/animation/TranslateAnimation:reset	()V
    //   515: aload_0
    //   516: getfield 397	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   519: aload_0
    //   520: getfield 1346	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation	[Landroid/view/animation/TranslateAnimation;
    //   523: aload_0
    //   524: getfield 1352	com/tencent/mobileqq/activity/Conversation:Z	I
    //   527: aaload
    //   528: invokevirtual 1361	android/widget/ImageView:startAnimation	(Landroid/view/animation/Animation;)V
    //   531: return
    //   532: aload_0
    //   533: getfield 580	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   536: sipush 1026
    //   539: invokevirtual 799	android/os/Handler:removeMessages	(I)V
    //   542: aload_0
    //   543: getfield 733	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame	Lcom/tencent/mobileqq/activity/recent/DrawerFrame;
    //   546: ifnull -508 -> 38
    //   549: aload_0
    //   550: getfield 733	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame	Lcom/tencent/mobileqq/activity/recent/DrawerFrame;
    //   553: invokevirtual 909	com/tencent/mobileqq/activity/recent/DrawerFrame:b	()Z
    //   556: ifeq -518 -> 38
    //   559: aload_0
    //   560: getfield 733	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame	Lcom/tencent/mobileqq/activity/recent/DrawerFrame;
    //   563: invokevirtual 938	com/tencent/mobileqq/activity/recent/DrawerFrame:d	()V
    //   566: return
    //   567: aload_0
    //   568: invokespecial 1362	com/tencent/mobileqq/activity/Conversation:q	()V
    //   571: return
    //   572: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +12 -> 587
    //   578: ldc 109
    //   580: iconst_2
    //   581: ldc_w 1364
    //   584: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   587: aload_0
    //   588: aload_1
    //   589: invokevirtual 1310	com/tencent/mobileqq/activity/Conversation:b	(Landroid/os/Message;)V
    //   592: aload_0
    //   593: iconst_1
    //   594: invokespecial 808	com/tencent/mobileqq/activity/Conversation:e	(Z)V
    //   597: return
    //   598: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +12 -> 613
    //   604: ldc 109
    //   606: iconst_2
    //   607: ldc_w 1366
    //   610: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: aload_0
    //   614: aload_1
    //   615: invokevirtual 1310	com/tencent/mobileqq/activity/Conversation:b	(Landroid/os/Message;)V
    //   618: return
    //   619: aload_0
    //   620: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   623: invokevirtual 1367	com/tencent/mobileqq/activity/recent/BannerManager:a	()Z
    //   626: ifeq +22 -> 648
    //   629: aload_0
    //   630: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   633: bipush 14
    //   635: iconst_2
    //   636: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   639: aload_0
    //   640: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   643: aload_1
    //   644: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   647: return
    //   648: aload_0
    //   649: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   652: bipush 14
    //   654: iconst_0
    //   655: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   658: aload_0
    //   659: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   662: aconst_null
    //   663: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   666: return
    //   667: invokestatic 1374	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   670: aload_0
    //   671: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   674: invokevirtual 1376	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   677: ifeq +45 -> 722
    //   680: aload_0
    //   681: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   684: bipush 12
    //   686: invokevirtual 1378	com/tencent/mobileqq/activity/recent/BannerManager:a	(I)I
    //   689: iconst_2
    //   690: if_icmpeq -652 -> 38
    //   693: aload_0
    //   694: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   697: bipush 12
    //   699: iconst_2
    //   700: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   703: aload_0
    //   704: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   707: aload_1
    //   708: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   711: invokestatic 1374	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   714: aload_0
    //   715: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   718: invokevirtual 1379	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   721: return
    //   722: invokestatic 1374	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   725: aload_0
    //   726: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   729: aload_0
    //   730: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   733: invokevirtual 599	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   736: invokevirtual 1380	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   739: ifeq -701 -> 38
    //   742: aload_0
    //   743: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   746: bipush 12
    //   748: invokevirtual 1378	com/tencent/mobileqq/activity/recent/BannerManager:a	(I)I
    //   751: iconst_2
    //   752: if_icmpne -714 -> 38
    //   755: aload_0
    //   756: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   759: bipush 12
    //   761: iconst_0
    //   762: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   765: aload_0
    //   766: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   769: aload_1
    //   770: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   773: return
    //   774: aload_0
    //   775: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   778: bipush 8
    //   780: iconst_2
    //   781: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   784: aload_0
    //   785: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   788: aload_1
    //   789: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   792: return
    //   793: aload_0
    //   794: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   797: bipush 10
    //   799: iconst_2
    //   800: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   803: aload_0
    //   804: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   807: bipush 8
    //   809: iconst_0
    //   810: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   813: aload_0
    //   814: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   817: aload_1
    //   818: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   821: return
    //   822: aload_0
    //   823: getfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   826: ifnull +15 -> 841
    //   829: aload_0
    //   830: getfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   833: invokevirtual 1383	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   836: aload_0
    //   837: aconst_null
    //   838: putfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   841: aload_0
    //   842: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   845: bipush 10
    //   847: iconst_0
    //   848: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   851: aload_0
    //   852: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   855: aload_1
    //   856: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   859: return
    //   860: astore 5
    //   862: aload_0
    //   863: aconst_null
    //   864: putfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   867: goto -26 -> 841
    //   870: astore_1
    //   871: aload_0
    //   872: aconst_null
    //   873: putfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   876: aload_1
    //   877: athrow
    //   878: aload_0
    //   879: aload_1
    //   880: invokespecial 1385	com/tencent/mobileqq/activity/Conversation:c	(Landroid/os/Message;)V
    //   883: return
    //   884: aload_0
    //   885: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   888: bipush 8
    //   890: iconst_0
    //   891: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   894: aload_0
    //   895: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   898: aload_1
    //   899: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   902: return
    //   903: aload_0
    //   904: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   907: bipush 16
    //   909: iconst_2
    //   910: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   913: aload_0
    //   914: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   917: aload_1
    //   918: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   921: return
    //   922: aload_0
    //   923: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   926: bipush 16
    //   928: iconst_0
    //   929: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   932: aload_0
    //   933: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   936: aload_1
    //   937: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   940: return
    //   941: aload_0
    //   942: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   945: iconst_4
    //   946: iconst_2
    //   947: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   950: aload_0
    //   951: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   954: aload_1
    //   955: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   958: return
    //   959: aload_0
    //   960: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   963: iconst_4
    //   964: iconst_0
    //   965: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   968: aload_0
    //   969: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   972: aload_1
    //   973: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   976: return
    //   977: aload_1
    //   978: getfield 1216	android/os/Message:arg1	I
    //   981: istore_2
    //   982: aload_0
    //   983: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   986: iconst_5
    //   987: iload_2
    //   988: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   991: aload_0
    //   992: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   995: aload_1
    //   996: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   999: return
    //   1000: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1003: ifeq +12 -> 1015
    //   1006: ldc 109
    //   1008: iconst_2
    //   1009: ldc_w 1387
    //   1012: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1015: aload_0
    //   1016: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1019: bipush 6
    //   1021: iconst_0
    //   1022: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1025: invokestatic 927	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   1028: iconst_0
    //   1029: invokevirtual 1388	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   1032: aload_0
    //   1033: aload_1
    //   1034: invokevirtual 1310	com/tencent/mobileqq/activity/Conversation:b	(Landroid/os/Message;)V
    //   1037: return
    //   1038: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1041: ifeq +12 -> 1053
    //   1044: ldc 109
    //   1046: iconst_2
    //   1047: ldc_w 1390
    //   1050: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1053: aload_0
    //   1054: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1057: bipush 6
    //   1059: iconst_0
    //   1060: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1063: invokestatic 927	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   1066: iconst_0
    //   1067: invokevirtual 1388	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   1070: aload_0
    //   1071: aload_1
    //   1072: invokevirtual 1310	com/tencent/mobileqq/activity/Conversation:b	(Landroid/os/Message;)V
    //   1075: aload_0
    //   1076: iconst_1
    //   1077: invokespecial 808	com/tencent/mobileqq/activity/Conversation:e	(Z)V
    //   1080: return
    //   1081: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1084: ifeq +12 -> 1096
    //   1087: ldc 109
    //   1089: iconst_2
    //   1090: ldc_w 1392
    //   1093: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1096: aload_0
    //   1097: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1100: bipush 6
    //   1102: invokevirtual 913	com/tencent/mobileqq/activity/recent/BannerManager:a	(I)Z
    //   1105: ifne +21 -> 1126
    //   1108: aload_0
    //   1109: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1112: bipush 6
    //   1114: iconst_2
    //   1115: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1118: aload_0
    //   1119: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1122: aload_1
    //   1123: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1126: invokestatic 927	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   1129: iconst_1
    //   1130: invokevirtual 1388	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   1133: aload_0
    //   1134: iconst_1
    //   1135: invokespecial 808	com/tencent/mobileqq/activity/Conversation:e	(Z)V
    //   1138: return
    //   1139: aload_0
    //   1140: aconst_null
    //   1141: invokevirtual 1310	com/tencent/mobileqq/activity/Conversation:b	(Landroid/os/Message;)V
    //   1144: aload_0
    //   1145: iconst_1
    //   1146: invokespecial 808	com/tencent/mobileqq/activity/Conversation:e	(Z)V
    //   1149: return
    //   1150: aload_0
    //   1151: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1154: bipush 14
    //   1156: iconst_0
    //   1157: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1160: aload_0
    //   1161: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1164: aload_1
    //   1165: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1168: return
    //   1169: aload_0
    //   1170: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1173: bipush 14
    //   1175: iconst_2
    //   1176: invokevirtual 1335	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1179: aload_0
    //   1180: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1183: aload_1
    //   1184: invokevirtual 1369	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1187: return
    //   1188: aload_0
    //   1189: lconst_0
    //   1190: invokevirtual 1342	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   1193: return
    //   1194: aload_0
    //   1195: iconst_0
    //   1196: putfield 216	com/tencent/mobileqq/activity/Conversation:f	Z
    //   1199: aload_0
    //   1200: getfield 424	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   1203: ifnull -1165 -> 38
    //   1206: aload_0
    //   1207: getfield 424	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   1210: invokevirtual 1394	com/tencent/mobileqq/fpsreport/FPSSwipListView:B	()V
    //   1213: return
    //   1214: aload_0
    //   1215: lconst_0
    //   1216: invokevirtual 1342	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   1219: return
    //   1220: aload_0
    //   1221: iconst_1
    //   1222: putfield 237	com/tencent/mobileqq/activity/Conversation:k	Z
    //   1225: return
    //   1226: aload_0
    //   1227: invokespecial 1395	com/tencent/mobileqq/activity/Conversation:B	()V
    //   1230: return
    //   1231: invokestatic 1040	java/lang/System:currentTimeMillis	()J
    //   1234: aload_0
    //   1235: getfield 220	com/tencent/mobileqq/activity/Conversation:d	J
    //   1238: lsub
    //   1239: invokestatic 1044	java/lang/Math:abs	(J)J
    //   1242: lstore_3
    //   1243: invokestatic 505	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1246: ifeq +48 -> 1294
    //   1249: ldc 109
    //   1251: iconst_4
    //   1252: new 507	java/lang/StringBuilder
    //   1255: dup
    //   1256: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1259: ldc_w 1397
    //   1262: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: aload_1
    //   1266: getfield 1216	android/os/Message:arg1	I
    //   1269: invokevirtual 857	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1272: ldc_w 917
    //   1275: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: lload_3
    //   1279: invokevirtual 1400	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1282: ldc_w 919
    //   1285: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: invokevirtual 521	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1291: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1294: aload_1
    //   1295: getfield 870	android/os/Message:obj	Ljava/lang/Object;
    //   1298: checkcast 1249	java/util/List
    //   1301: astore 5
    //   1303: aload 5
    //   1305: invokeinterface 1253 1 0
    //   1310: astore 6
    //   1312: aload 6
    //   1314: invokeinterface 1258 1 0
    //   1319: ifeq +38 -> 1357
    //   1322: aload 6
    //   1324: invokeinterface 1261 1 0
    //   1329: checkcast 1020	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   1332: astore 7
    //   1334: aload 7
    //   1336: invokevirtual 1262	com/tencent/mobileqq/activity/recent/RecentBaseData:a	()I
    //   1339: sipush 6000
    //   1342: if_icmpne -30 -> 1312
    //   1345: aload 7
    //   1347: aload_0
    //   1348: ldc_w 1401
    //   1351: invokevirtual 1118	com/tencent/mobileqq/activity/Conversation:a	(I)Ljava/lang/String;
    //   1354: putfield 1403	com/tencent/mobileqq/activity/recent/RecentBaseData:a	Ljava/lang/String;
    //   1357: aload_1
    //   1358: getfield 1219	android/os/Message:arg2	I
    //   1361: iconst_1
    //   1362: if_icmpeq +67 -> 1429
    //   1365: lload_3
    //   1366: aload_0
    //   1367: getfield 208	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_Long	J
    //   1370: lcmp
    //   1371: ifge +58 -> 1429
    //   1374: aload_0
    //   1375: aload 5
    //   1377: putfield 1405	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1380: invokestatic 1408	android/os/Message:obtain	()Landroid/os/Message;
    //   1383: astore_1
    //   1384: aload_1
    //   1385: sipush 10000
    //   1388: putfield 1144	android/os/Message:what	I
    //   1391: aload_1
    //   1392: aload_0
    //   1393: getfield 1405	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1396: putfield 870	android/os/Message:obj	Ljava/lang/Object;
    //   1399: aload_1
    //   1400: iconst_0
    //   1401: putfield 1216	android/os/Message:arg1	I
    //   1404: aload_1
    //   1405: iconst_1
    //   1406: putfield 1219	android/os/Message:arg2	I
    //   1409: aload_0
    //   1410: getfield 580	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1413: aload_1
    //   1414: aload_0
    //   1415: getfield 208	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_Long	J
    //   1418: lload_3
    //   1419: lsub
    //   1420: ldc2_w 1409
    //   1423: ladd
    //   1424: invokevirtual 1414	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   1427: pop
    //   1428: return
    //   1429: aload_1
    //   1430: getfield 1219	android/os/Message:arg2	I
    //   1433: iconst_1
    //   1434: if_icmpne +40 -> 1474
    //   1437: aload 5
    //   1439: aload_0
    //   1440: getfield 1405	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1443: if_acmpne +26 -> 1469
    //   1446: iconst_1
    //   1447: istore_2
    //   1448: iload_2
    //   1449: ifeq -1411 -> 38
    //   1452: aload_0
    //   1453: iconst_0
    //   1454: aload_0
    //   1455: getfield 1405	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1458: invokevirtual 1415	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   1461: aload_0
    //   1462: invokestatic 1040	java/lang/System:currentTimeMillis	()J
    //   1465: putfield 220	com/tencent/mobileqq/activity/Conversation:d	J
    //   1468: return
    //   1469: iconst_0
    //   1470: istore_2
    //   1471: goto -23 -> 1448
    //   1474: aload_0
    //   1475: aload 5
    //   1477: putfield 1405	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1480: iconst_1
    //   1481: istore_2
    //   1482: goto -34 -> 1448
    //   1485: aload_0
    //   1486: iconst_1
    //   1487: aload_1
    //   1488: getfield 870	android/os/Message:obj	Ljava/lang/Object;
    //   1491: checkcast 1249	java/util/List
    //   1494: invokevirtual 1415	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   1497: return
    //   1498: aload_0
    //   1499: getfield 411	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   1502: ifnull -1464 -> 38
    //   1505: aload_0
    //   1506: getfield 411	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   1509: aload_1
    //   1510: invokevirtual 1416	com/tencent/mobileqq/activity/recent/RecentCallHelper:a	(Landroid/os/Message;)V
    //   1513: return
    //   1514: aload_0
    //   1515: getfield 411	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   1518: ifnull -1480 -> 38
    //   1521: aload_0
    //   1522: getfield 411	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   1525: invokevirtual 1417	com/tencent/mobileqq/activity/recent/RecentCallHelper:f	()V
    //   1528: return
    //   1529: aload_0
    //   1530: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1533: ifnull -1495 -> 38
    //   1536: aload_0
    //   1537: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1540: invokevirtual 1305	com/tencent/mobileqq/app/QQAppInterface:C	()V
    //   1543: return
    //   1544: aload_0
    //   1545: invokespecial 1418	com/tencent/mobileqq/activity/Conversation:C	()V
    //   1548: return
    //   1549: getstatic 1420	com/tencent/mobileqq/activity/recent/DrawerFrame:d	I
    //   1552: ifle -1514 -> 38
    //   1555: invokestatic 1422	com/tencent/mobileqq/activity/Conversation:o	()V
    //   1558: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1559	0	this	Conversation
    //   0	1559	1	paramMessage	Message
    //   981	501	2	i1	int
    //   1242	177	3	l1	long
    //   860	1	5	localException	Exception
    //   1301	175	5	localList	List
    //   1310	13	6	localIterator	Iterator
    //   1332	14	7	localRecentBaseData	RecentBaseData
    // Exception table:
    //   from	to	target	type
    //   829	836	860	java/lang/Exception
    //   829	836	870	finally
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ThreadPriorityManager.a(true);
      paramView = null;
      if ((paramRecentBaseData instanceof RecentUserBaseData)) {
        paramView = ((RecentUserBaseData)paramRecentBaseData).a();
      }
      a(RecentUtil.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean), paramView);
      if (paramRecentBaseData != null)
      {
        paramRecentBaseData.b();
        this.h = true;
      }
      return;
    }
    Object localObject2;
    Object localObject1;
    String str1;
    if ((paramRecentBaseData instanceof RecentCallItem))
    {
      localObject2 = (RecentCallItem)paramRecentBaseData;
      localObject1 = ((RecentCallItem)localObject2).a();
      switch (((RecentCallItem)localObject2).c())
      {
      case 2: 
      default: 
        str1 = "99";
        localObject2 = localObject1;
        localObject1 = str1;
      }
    }
    for (;;)
    {
      for (;;)
      {
        int i1;
        String str2;
        if (localObject2 != null)
        {
          i1 = ((QCallRecent)localObject2).type;
          paramRecentBaseData = null;
          str1 = null;
          if (i1 == 1006) {
            str1 = ((QCallRecent)localObject2).uin;
          }
          for (;;)
          {
            str2 = ((QCallRecent)localObject2).troopUin;
            if ((paramView == null) || (paramView.getId() != 2131232933)) {
              break label341;
            }
            paramView = new Intent(a(), QCallDetailActivity.class);
            paramView.putExtra("uin", ((QCallRecent)localObject2).uin);
            paramView.putExtra("troop_uin", ((QCallRecent)localObject2).troopUin);
            paramView.putExtra("uintype", i1);
            paramView.putExtra("uinname", paramString);
            a(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
            return;
            str1 = "0";
            localObject2 = localObject1;
            localObject1 = str1;
            break;
            str1 = "1";
            localObject2 = localObject1;
            localObject1 = str1;
            break;
            str1 = "2";
            localObject2 = localObject1;
            localObject1 = str1;
            break;
            paramRecentBaseData = ((QCallRecent)localObject2).uin;
          }
          label341:
          paramBoolean = true;
          if (((QCallRecent)localObject2).isVideo()) {
            paramBoolean = false;
          }
          if (((QCallRecent)localObject2).type != 3000) {}
        }
        try
        {
          Long.parseLong(paramRecentBaseData);
          label371:
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004066", "0X8004066", 0, 0, "", "", "", "");
          return;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i1, paramRecentBaseData, paramString, str1, paramBoolean, str2, true, true, null, "");
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (((QCallRecent)localObject2).isVideo())
          {
            paramView = "1";
            ReportController.b(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject1, "", "");
            paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!((QCallRecent)localObject2).isMissedCall()) {
              break label537;
            }
          }
          label537:
          for (paramView = "0";; paramView = "1")
          {
            ReportController.b(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
            return;
            paramView = "0";
            break;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "onRecentBaseDataClick|call is null, data = " + paramRecentBaseData);
          return;
        }
        catch (NumberFormatException paramView)
        {
          break label371;
        }
      }
      localObject1 = "99";
      localObject2 = null;
    }
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean)
  {
    paramContactsSearchableRecentUser = paramContactsSearchableRecentUser.a();
    a(RecentUtil.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContactsSearchableRecentUser, paramString, paramBoolean), paramContactsSearchableRecentUser);
    paramView = new SearchHistory();
    paramView.type = paramContactsSearchableRecentUser.type;
    paramView.uin = paramContactsSearchableRecentUser.uin;
    paramView.troopUin = paramContactsSearchableRecentUser.troopUin;
    paramView.displayName = paramString;
    paramContactsSearchableRecentUser = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (paramContactsSearchableRecentUser == null) {
      return;
    }
    paramContactsSearchableRecentUser.a(paramView);
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if ((paramView != null) && (paramView.getId() == 2131231432))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
      paramView = new Intent(a(), ForwardRecentActivity.class);
      paramView.putExtra("forward_type", 13);
      a(paramView);
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    z();
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = null;
      if ((paramRecentBaseData instanceof RecentUserBaseData)) {
        localObject = ((RecentUserBaseData)paramRecentBaseData).a();
      }
      if (localObject != null) {
        RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject);
      }
    }
    do
    {
      return;
      localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    } while ((localObject == null) || (paramRecentBaseData == null));
    ((QCallFacade)localObject).a(paramRecentBaseData.a(), paramRecentBaseData.a());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    for (;;)
    {
      return;
      this.aj = paramInt;
      if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
        if ((paramInt == 0) || (paramInt == 1))
        {
          this.ak = (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.q() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.k());
          if (this.ak < -1) {
            this.ak = -1;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
          }
        }
      }
      while ((paramInt == 0) && (this.h))
      {
        a(100L);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramAbsListView, paramInt);
            if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean))
            {
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onScrollStateChanged list idle refresh list");
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_b_of_type_AndroidOsHandler);
            }
          }
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Object localObject = a();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4]))) {
      a(i1, paramRecentBaseData, paramString2, false);
    }
    label148:
    label365:
    label373:
    do
    {
      do
      {
        do
        {
          break label148;
          while (Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3])))
          {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramRecentBaseData.a(), true, true, null);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800416A", "0X800416A", 0, 0, "1", "", paramString2, "");
            return;
            if (Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5]))) {
              a(i1, paramRecentBaseData, paramString2, true);
            }
          }
          if (Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2])))
          {
            String str;
            if (i1 == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800416A", "0X800416A", 0, 0, "0", "", paramString2, "");
              paramString2 = null;
              str = paramRecentBaseData.b();
              localObject = null;
              paramString1 = null;
              if (i1 != 1006) {
                break label365;
              }
              localObject = paramRecentBaseData.a();
              if ((i1 == 1000) || (i1 == 1004))
              {
                paramString1 = null;
                if ((paramRecentBaseData instanceof RecentUserBaseData)) {
                  paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
                }
                if (paramString1 != null) {
                  break label373;
                }
              }
            }
            for (paramString1 = null;; paramString1 = paramString1.troopUin)
            {
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i1, paramString2, str, (String)localObject, true, paramString1, true, true, null, "");
              return;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800416A", "0X800416A", 0, 0, "2", "", paramString2, "");
              break;
              paramString2 = paramRecentBaseData.a();
              break label261;
            }
          }
          if (!Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4]))) {
            break;
          }
          if (i1 == 7000)
          {
            SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", "0", paramString2, "");
            return;
          }
        } while (i1 != 5000);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, false);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", "0", paramString2, "");
        return;
        if (!Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5]))) {
          break;
        }
        if (i1 == 7000)
        {
          SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", "1", paramString2, "");
          return;
        }
      } while (i1 != 5000);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, true);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", "1", paramString2, "");
      return;
    } while ((i1 != 1) || (!Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]))));
    label261:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800416B", "0X800416B", 0, 0, "0", "", paramString2, "");
  }
  
  protected void a(List paramList)
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
          if ((localRecentBaseData != null) && (localRecentBaseData.A > 0)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.a()).append("-").append(localRecentBaseData.a()).append("-").append(localRecentBaseData.A).append(" , ");
          }
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("]");
      QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
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
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(14, 0);
    RecentDataListManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramLogoutReason);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    TimeManager.a().e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.d();
    }
    if (AppSetting.k) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(true);
    }
    this.e = true;
    a().getWindow().setSoftInputMode(32);
    BannerManager localBannerManager;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      paramBoolean = LoadingStateManager.a().e();
      localBannerManager = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (!paramBoolean) {
        break label291;
      }
    }
    label291:
    for (int i1 = 2;; i1 = 0)
    {
      localBannerManager.a(6, i1);
      LoadingStateManager.a().b(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      SubAccountBaseActivity.a = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent != null))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent = null;
      }
      this.aj = 0;
      if (!this.i) {
        break;
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new cfn(this), 1000L);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1031);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a();
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1030, 1000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1025, 3000L);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar.setVisibility(8);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    boolean bool1 = true;
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
      if (!this.f) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null)
    {
      do
      {
        do
        {
          return true;
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
          i();
          y();
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
      } while (!QLog.isColorLevel());
      QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(6)) || (bool2)) {}
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsHandler, bool1);
      bool1 = false;
      continue;
      bool1 = NetworkUtil.e(BaseApplication.getContext());
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    return ((this.e) || (paramMessage.arg1 != 0)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
  }
  
  public boolean a(Menu paramMenu)
  {
    paramMenu.clear();
    BaseActivity localBaseActivity = a();
    if ((localBaseActivity != null) && ((localBaseActivity instanceof SplashActivity))) {}
    for (boolean bool = ((SplashActivity)localBaseActivity).c();; bool = false)
    {
      paramMenu = paramMenu.add(0, 4, 0, a().getString(2131562830));
      if (bool) {}
      for (int i1 = 2130839697;; i1 = 2130839694)
      {
        paramMenu.setIcon(i1);
        MenuItemCompat.setShowAsAction(paramMenu, 1);
        return true;
      }
    }
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar == null) {
      return false;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.c();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.e();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a();
      }
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
      if (!this.f) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.b(paramInt, paramView, paramListView);
  }
  
  public void b(long paramLong)
  {
    if (PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean("conversation_head_edu" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true)) {}
    for (int i1 = 4097;; i1 = 4098)
    {
      this.X = i1;
      if (this.X == 4097)
      {
        this.Y = 0;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1029, paramLong);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "initHeadEduFlag, [" + this.X + "]");
      }
      return;
    }
  }
  
  void b(Message paramMessage)
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
          break label232;
        }
        v();
        label50:
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "refreshStatusInfo bShowNetBar=" + bool);
        }
        LoadingStateManager.a().a(bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5, 0);
          }
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
          if (!bool) {
            break label239;
          }
          i1 = 2;
          label129:
          paramMessage.a(1, i1);
          bool = LoadingStateManager.a().e();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
          if (!bool) {
            break label244;
          }
        }
      }
    }
    label232:
    label239:
    label244:
    for (int i1 = i2;; i1 = 0)
    {
      paramMessage.a(6, i1);
      LoadingStateManager.a().b(bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(null);
      return;
      bool = true;
      break;
      if (paramMessage.obj.toString().equals(a(2131562452)))
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
      w();
      break label50;
      i1 = 0;
      break label129;
    }
  }
  
  /* Error */
  protected void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 505	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +48 -> 51
    //   6: ldc 109
    //   8: iconst_4
    //   9: new 507	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1710
    //   19: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 517	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 917
    //   29: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 233	com/tencent/mobileqq/activity/Conversation:i	Z
    //   36: invokevirtual 517	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 919
    //   42: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 521	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 524	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 564	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   55: ifnonnull +18 -> 73
    //   58: aload_0
    //   59: new 566	android/os/Handler
    //   62: dup
    //   63: invokestatic 1715	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Looper;
    //   66: aload_0
    //   67: invokespecial 1718	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   70: putfield 564	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   73: iload_1
    //   74: ifeq +21 -> 95
    //   77: aload_0
    //   78: getfield 743	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe	Lcom/tencent/mobileqq/activity/QQSettingMe;
    //   81: ifnull +14 -> 95
    //   84: aload_0
    //   85: getfield 743	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe	Lcom/tencent/mobileqq/activity/QQSettingMe;
    //   88: aload_0
    //   89: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 1719	com/tencent/mobileqq/activity/QQSettingMe:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   95: aload_0
    //   96: invokespecial 1721	com/tencent/mobileqq/activity/Conversation:D	()V
    //   99: iload_1
    //   100: ifeq +264 -> 364
    //   103: invokestatic 927	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   106: invokevirtual 1722	com/tencent/mobileqq/managers/LoadingStateManager:a	()V
    //   109: invokestatic 481	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   112: invokevirtual 1591	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()V
    //   115: aload_0
    //   116: getfield 216	com/tencent/mobileqq/activity/Conversation:f	Z
    //   119: ifeq +22 -> 141
    //   122: aload_0
    //   123: getfield 424	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   126: ifnull +15 -> 141
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 216	com/tencent/mobileqq/activity/Conversation:f	Z
    //   134: aload_0
    //   135: getfield 424	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   138: invokevirtual 1723	com/tencent/mobileqq/fpsreport/FPSSwipListView:C	()V
    //   141: aload_0
    //   142: getfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   145: ifnull +15 -> 160
    //   148: aload_0
    //   149: getfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   152: invokevirtual 1383	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   160: aload_0
    //   161: getfield 454	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar	Lcom/tencent/mobileqq/activity/recent/LocalSearchBar;
    //   164: ifnull +14 -> 178
    //   167: aload_0
    //   168: getfield 454	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar	Lcom/tencent/mobileqq/activity/recent/LocalSearchBar;
    //   171: aload_0
    //   172: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   175: invokevirtual 1724	com/tencent/mobileqq/activity/recent/LocalSearchBar:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   178: aload_0
    //   179: getfield 1235	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   182: ifnull +14 -> 196
    //   185: aload_0
    //   186: getfield 1235	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   189: aload_0
    //   190: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   193: invokevirtual 1725	com/tencent/mobileqq/activity/recent/RecentTroopMenuOption:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   196: aload_0
    //   197: getfield 468	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   200: ifnull +47 -> 247
    //   203: aload_0
    //   204: getfield 468	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   207: aload_0
    //   208: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: invokevirtual 1726	com/tencent/mobileqq/activity/recent/RecentAdapter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   214: aload_0
    //   215: getfield 564	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   218: ifnull +29 -> 247
    //   221: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +12 -> 236
    //   227: ldc 109
    //   229: iconst_2
    //   230: ldc_w 1728
    //   233: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_0
    //   237: iconst_1
    //   238: bipush 10
    //   240: lconst_0
    //   241: invokestatic 948	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: invokevirtual 951	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   247: aload_0
    //   248: getfield 411	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   251: ifnull +60 -> 311
    //   254: aload_0
    //   255: getfield 411	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   258: aload_0
    //   259: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   262: invokevirtual 1729	com/tencent/mobileqq/activity/recent/RecentCallHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   265: aload_0
    //   266: getfield 564	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   269: ifnull +42 -> 311
    //   272: invokestatic 607	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +12 -> 287
    //   278: ldc 109
    //   280: iconst_2
    //   281: ldc_w 1728
    //   284: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: invokestatic 1408	android/os/Message:obtain	()Landroid/os/Message;
    //   290: astore_2
    //   291: aload_2
    //   292: bipush 16
    //   294: putfield 1144	android/os/Message:what	I
    //   297: aload_2
    //   298: iconst_1
    //   299: putfield 1216	android/os/Message:arg1	I
    //   302: aload_0
    //   303: getfield 564	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   306: aload_2
    //   307: invokevirtual 1223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   310: pop
    //   311: aload_0
    //   312: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   315: ifnull +10 -> 325
    //   318: aload_0
    //   319: getfield 461	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   322: invokevirtual 1730	com/tencent/mobileqq/activity/recent/BannerManager:d	()V
    //   325: aload_0
    //   326: getfield 233	com/tencent/mobileqq/activity/Conversation:i	Z
    //   329: ifeq +13 -> 342
    //   332: aload_0
    //   333: getfield 564	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   336: bipush 12
    //   338: invokevirtual 570	android/os/Handler:sendEmptyMessage	(I)Z
    //   341: pop
    //   342: aload_0
    //   343: sipush 4096
    //   346: putfield 326	com/tencent/mobileqq/activity/Conversation:X	I
    //   349: aload_0
    //   350: invokevirtual 404	com/tencent/mobileqq/activity/Conversation:l	()V
    //   353: aload_0
    //   354: sipush 1010
    //   357: ldc2_w 1531
    //   360: iconst_1
    //   361: invokespecial 560	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   364: aload_0
    //   365: sipush 10001
    //   368: ldc2_w 581
    //   371: iconst_0
    //   372: invokespecial 560	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   375: aload_0
    //   376: invokevirtual 1732	com/tencent/mobileqq/activity/Conversation:h	()V
    //   379: return
    //   380: astore_2
    //   381: aload_0
    //   382: aconst_null
    //   383: putfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   386: goto -226 -> 160
    //   389: astore_2
    //   390: aload_0
    //   391: aconst_null
    //   392: putfield 791	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   395: aload_2
    //   396: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	Conversation
    //   0	397	1	paramBoolean	boolean
    //   290	17	2	localMessage	Message
    //   380	1	2	localException	Exception
    //   389	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   148	155	380	java/lang/Exception
    //   148	155	389	finally
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a(true);
      return true;
    }
    return super.b();
  }
  
  protected void c()
  {
    super.c();
    t();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "statHeadIconEdu, [" + paramBoolean + "," + this.X + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1029);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageView.getAnimation();
      if (localObject != null) {
        ((Animation)localObject).reset();
      }
    }
    while ((!this.e) || (this.X != 4097)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation == null)
    {
      localObject = new cfj(this);
      this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation = new TranslateAnimation[this.jdField_a_of_type_ArrayOfFloat.length - 1];
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation.length)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[i1] = new TranslateAnimation(this.jdField_a_of_type_ArrayOfFloat[i1], this.jdField_a_of_type_ArrayOfFloat[(i1 + 1)], 0.0F, 0.0F);
        if (i1 % 2 == 0)
        {
          this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[i1].setInterpolator(a(), 17432582);
          label198:
          if (i1 != this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation.length - 1) {
            break label257;
          }
          this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[i1].setDuration(80L);
        }
        for (;;)
        {
          this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[i1].setAnimationListener((Animation.AnimationListener)localObject);
          i1 += 1;
          break;
          this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[i1].setInterpolator(a(), 17432581);
          break label198;
          label257:
          this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[i1].setDuration(50L);
        }
      }
    }
    this.Z = 0;
    this.Y = 0;
    this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[this.Z].reset();
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[this.Z]);
  }
  
  protected boolean c()
  {
    return (this.aj != 0) && (this.aj != 1);
  }
  
  protected void d()
  {
    super.d();
    if (AppSetting.k) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
    }
    TimeManager.a().d();
    this.e = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.c();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a();
    }
    c(true);
    if (DrawerFrame.d == 2) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1031, 1000L);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void e()
  {
    this.g = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    TimeManager.a().b();
    E();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.e();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.a().a();
    PubAccountAssistantManager.a().a();
    TroopRemindSettingManager.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a(null, null, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = null;
    NewFriendManager localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localNewFriendManager != null) {
      localNewFriendManager.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.O, 7000);
    super.e();
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
    E();
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 1338	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 710	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   24: aload_0
    //   25: invokevirtual 1823	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   28: aload_0
    //   29: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: bipush 36
    //   34: invokevirtual 641	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   37: checkcast 721	com/tencent/mobileqq/qcall/QCallFacade
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +8 -> 50
    //   45: aload_2
    //   46: aload_0
    //   47: invokevirtual 1824	com/tencent/mobileqq/qcall/QCallFacade:addObserver	(Ljava/util/Observer;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: invokespecial 808	com/tencent/mobileqq/activity/Conversation:e	(Z)V
    //   55: aload_0
    //   56: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   59: bipush 32
    //   61: invokevirtual 641	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   64: checkcast 1812	com/tencent/mobileqq/app/NewFriendManager
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull -55 -> 14
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 339	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener	Lcom/tencent/mobileqq/newfriend/NewFriendPushListener;
    //   77: invokevirtual 1815	com/tencent/mobileqq/app/NewFriendManager:a	(Lcom/tencent/mobileqq/newfriend/NewFriendPushListener;)V
    //   80: goto -66 -> 14
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	Conversation
    //   9	2	1	bool	boolean
    //   40	33	2	localObject1	Object
    //   83	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	83	finally
    //   17	41	83	finally
    //   45	50	83	finally
    //   50	68	83	finally
    //   72	80	83	finally
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
      r();
      TroopAssistantManager.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      u();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
      paramMessage = RecentDataListManager.a().a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject3 = a();
      if (localObject1 != null) {}
      for (i1 = ((List)localObject1).size();; i1 = 0)
      {
        ConversationDataFactory.a((List)localObject1, (QQAppInterface)localObject2, (Context)localObject3, paramMessage, i1);
        Collections.sort(paramMessage, this.jdField_a_of_type_JavaUtilComparator);
        localObject1 = new ArrayList(paramMessage);
        Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000, 0, 0, localObject1).sendToTarget();
        a(paramMessage);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.e();
        }
        this.jdField_b_of_type_JavaUtilList.clear();
        this.al = 0;
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
        TraceUtils.a();
        return true;
      }
    }
    if (paramMessage.what == 9)
    {
      if (!a(paramMessage)) {
        return true;
      }
      u();
      localObject2 = RecentDataListManager.a().a();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
      ((List)localObject2).clear();
      if (localObject3 == null)
      {
        i1 = 0;
        if (i1 <= 99) {
          break label1673;
        }
        i1 = 99;
      }
    }
    label1673:
    for (;;)
    {
      int i2 = 0;
      label369:
      if (i2 < i1)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject3).get(i2);
        String str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.type);
        localObject1 = RecentDataListManager.a().a(str);
        if (localObject1 == null)
        {
          paramMessage = ConversationDataFactory.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          RecentDataListManager.a().a(paramMessage, str);
        }
        for (;;)
        {
          if (paramMessage != null) {
            ((List)localObject2).add(paramMessage);
          }
          i2 += 1;
          break label369;
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
      }
      Collections.sort((List)localObject2, this.jdField_a_of_type_JavaUtilComparator);
      paramMessage = new ArrayList((Collection)localObject2);
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000, 0, 0, paramMessage).sendToTarget();
      a((List)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.e();
      }
      if (this.al <= 9) {
        this.al = 0;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
      break;
      if (paramMessage.what == 8)
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
                break label827;
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
            label827:
            localObject3 = RecentDataListManager.a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
            if ((this.jdField_b_of_type_JavaUtilList.contains(localObject3)) || (this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(((RecentBaseData)localObject2).a(), -2147483648))))
            {
              ((RecentBaseData)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
              ((List)localObject1).add(localObject2);
            }
          }
        }
        Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1019, 0, 0, localObject1).sendToTarget();
        a(paramMessage);
        if (this.al <= 8)
        {
          this.al = 0;
          this.jdField_b_of_type_JavaUtilList.clear();
        }
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        break;
      }
      boolean bool;
      if (paramMessage.what == 17) {
        label1261:
        for (;;)
        {
          try
          {
            localObject2 = (Intent)paramMessage.obj;
            if (localObject2 == null) {
              return true;
            }
            localObject1 = ((Intent)localObject2).getExtras().getString("watermark_photo_path");
            paramMessage = (Message)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramMessage = ((Intent)localObject2).getData().getPath();
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.zebra.", 2, paramMessage);
            }
            if (TextUtils.isEmpty(paramMessage)) {
              break;
            }
            localObject1 = new File(AppConstants.ap);
            if (!((File)localObject1).exists()) {
              ((File)localObject1).mkdirs();
            }
            localObject1 = AppConstants.ap + System.currentTimeMillis() + ".jpg";
            bool = FileUtils.c(paramMessage, (String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.i("Q.zebra.", 2, "REQUEST_CODE_WATER_MARK, path = " + (String)localObject1 + ", bRet = " + bool);
            }
            if (!bool) {
              break label1261;
            }
            FileUtils.d(paramMessage);
            paramMessage = (Message)localObject1;
            b(new cfo(this, paramMessage));
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.zebra.", 2, paramMessage.toString());
          break;
        }
      }
      if (paramMessage.what == 11)
      {
        bool = a(paramMessage);
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
        while (i2 >= this.al)
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
          this.al = i2;
        }
        if ((!this.i) || (this.jdField_b_of_type_AndroidOsHandler.hasMessages(this.al))) {
          break;
        }
        long l2 = Math.abs(System.currentTimeMillis() - this.jdField_c_of_type_Long);
        l1 = Math.max(this.jdField_b_of_type_Long - l2, l1);
        localObject1 = Message.obtain();
        ((Message)localObject1).arg1 = paramMessage.arg1;
        ((Message)localObject1).what = this.al;
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, l1);
        break;
      }
      if (paramMessage.what == 12)
      {
        QZoneShareAlbumAssistantManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        TroopAssistantManager.a().j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramMessage = PubAccountAssistantManager.a();
        if (paramMessage != null) {
          paramMessage.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      }
      if (paramMessage.what != 16) {
        break;
      }
      if (!a(paramMessage)) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_AndroidOsHandler);
      break;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.f = true;
      x();
      e(true);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(6);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e();
    c(60000L);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void j()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent", 4, "onDrawComplete, [" + this.i + "," + this.g + "]");
    }
    if ((!this.i) && (!this.g))
    {
      q();
      StartupTracker.a("Recent_Start", null);
    }
    while (!this.i) {
      return;
    }
    a(1030, 0L, true);
  }
  
  public void k()
  {
    RecentCallHelper localRecentCallHelper;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      if ((!this.e) || (this.jdField_b_of_type_Boolean)) {
        break label51;
      }
      localRecentCallHelper = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
      if (c()) {
        break label46;
      }
    }
    label46:
    for (boolean bool = true;; bool = false)
    {
      localRecentCallHelper.a(bool, true, this.jdField_b_of_type_AndroidOsHandler);
      return;
    }
    label51:
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean = true;
  }
  
  public void l()
  {
    ThreadManager.a().post(new cfg(this));
  }
  
  public void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setHeadEduFlag, [" + this.X + "]");
    }
    if (this.X == 4097)
    {
      c(true);
      this.X = 4098;
      PreferenceManager.getDefaultSharedPreferences(a()).edit().putBoolean("conversation_head_edu" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false).commit();
    }
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a(true);
    }
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131231425)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8);
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramRadioGroup = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (paramRadioGroup != null) {
          paramRadioGroup.b(MessageCache.a());
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.g();
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!this.jdField_b_of_type_Boolean) {
        break label318;
      }
    }
    label318:
    for (paramRadioGroup = "0";; paramRadioGroup = "1")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_tab", 0, 0, paramRadioGroup, "", "", "");
      return;
      if (paramInt != 2131231426) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "Conversation onCheckedChanged is listview scrolling =" + c() + ";mDelayRefresh=" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_b_of_type_AndroidOsHandler);
        }
      }
      this.jdField_b_of_type_Boolean = false;
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_AndroidWidgetImageView) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(2131562239));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a();
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(2131563215));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
          return;
        } while ((paramView != this.jdField_a_of_type_AndroidViewView) || (this.jdField_a_of_type_AndroidViewView == null));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
          F();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a();
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "My_settab", 0, 0, "", "", "", "");
      } while ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0));
      paramView = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    } while (paramView == null);
    paramView.b(35);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(a(), paramViewStub, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this, this, this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = (MessageRecord)paramObject;
      if ((!((MessageRecord)localObject).isSendFromLocal()) || (((MessageRecord)localObject).msgtype != -2002)) {}
    }
    label32:
    label104:
    do
    {
      do
      {
        do
        {
          break label32;
          for (;;)
          {
            return;
            if ((!((MessageRecord)localObject).isSendFromLocal()) || (((MessageRecord)localObject).msgtype != -2000) || (this.e))
            {
              int i2;
              int i1;
              if ((((MessageRecord)localObject).isSendFromLocal()) && (!this.e))
              {
                i2 = 2;
                i1 = 9;
                localObject = RecentDataListManager.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
                a(i2, i1, localObject);
                if (!(paramObservable instanceof QCallFacade)) {
                  break;
                }
                if (!(paramObject instanceof Boolean)) {
                  break label299;
                }
                boolean bool = ((Boolean)paramObject).booleanValue();
                if ((!this.jdField_b_of_type_Boolean) && (bool))
                {
                  paramObservable = null;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                    paramObservable = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
                  }
                  if (paramObservable != null) {
                    paramObservable.a(false);
                  }
                }
              }
              for (;;)
              {
                if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager == null)) {
                  break label304;
                }
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.f();
                return;
                if ((!this.e) && (this.jdField_a_of_type_AndroidOsHandler != null) && (RecentUtil.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1024))) {
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1024, 100L);
                }
                localObject = Long.valueOf(0L);
                i1 = 10;
                i2 = 0;
                break;
                if ((paramObject instanceof RecentUser))
                {
                  a(200L);
                  break label104;
                }
                if (!AppConstants.O.equals(String.valueOf(paramObject))) {
                  break label104;
                }
                a(8, AppConstants.O, 7000);
                break label104;
                k();
              }
            }
          }
        } while ((!(paramObservable instanceof RedTouchManager)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo)));
        paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
        paramObservable = ((RedTouchManager)paramObservable).a(paramObject);
      } while ((paramObservable == null) || (paramObservable.size() <= 0));
      paramObservable = (VipBannerInfo)paramObservable.get(0);
    } while ((paramObservable.e < 1) || (paramObservable.e > 4));
    label299:
    label304:
    VipBannerInfo.b(this);
  }
  
  public void z_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */