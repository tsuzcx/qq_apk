package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.voip.VoipAddressBookActivity;
import com.tencent.mobileqq.activity.voip.VoipDialData;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;
import com.tencent.mobileqq.activity.voip.VoipPhoneNumber;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.CustomWidgetUtil;
import dpe;
import dpf;
import dpg;
import dph;
import dpi;
import dpj;
import dpk;
import dpl;
import dpm;
import dpo;
import dpp;
import dpq;
import dpr;
import dps;
import dpt;
import dpu;
import dpv;
import dpw;
import dpx;
import dpy;
import dpz;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.Constants.LogoutReason;
import mqq.app.NewIntent;
import protocol.KQQConfig.UpgradeInfo;

public class SplashActivity
  extends FrameActivity
  implements ActionBar.TabListener
{
  public static final int a = 0;
  private static volatile SplashActivity jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  public static final String a = "SplashActivity";
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "tab_index";
  public static boolean b = false;
  public static final int c = 2;
  public static final String c = "消息";
  public static final int d = 3;
  public static final String d = "联系人";
  public static final int e = 0;
  public static final String e = "动态";
  public static final int f = 0;
  public static final String f = "我";
  public static final int g = 1;
  public static final String g = "_icon";
  public static final int h = 3;
  public static final String h = "_num";
  public static final int i = 4;
  public static final String i = "_new";
  public static final int j = 300000;
  public static final int k = 16;
  public static final int l = 17;
  private static final String l = "qqi_public_account";
  public static final int m = 18;
  private static final String m = "qqi_public_account_first_login";
  public static final int n = 32;
  public static final int o = 33;
  public static final int p = 34;
  public static final int q = 35;
  public static final int r = 3;
  private static final int u = 7000;
  public Dialog a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private final Handler jdField_a_of_type_AndroidOsHandler = new dpe(this, Looper.getMainLooper());
  public View a;
  private SplashActivity.ViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivitySplashActivity$ViewPagerAdapter;
  public MainAssistObserver a;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  public AccountDetail a;
  private mobileqq_mp.GetPublicAccountDetailInfoResponse jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse;
  private QQTabWidget.onTabWidgetTouchMoveListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = new dpl(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = null;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private HashMap jdField_b_of_type_JavaUtilHashMap = null;
  private View c;
  public boolean c;
  public boolean d = false;
  public boolean e = true;
  private boolean f = true;
  public String j;
  int s;
  int t;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
  }
  
  public SplashActivity()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  private int a(String paramString)
  {
    int i2 = 0;
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_new");
    int i1 = i2;
    if ((localObject instanceof Boolean))
    {
      i1 = i2;
      if (((Boolean)localObject).booleanValue()) {
        i1 = 2;
      }
    }
    i2 = i1;
    if (i1 == 0)
    {
      localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_num");
      i2 = i1;
      if ((localObject instanceof Integer))
      {
        i2 = i1;
        if (((Integer)localObject).intValue() > 0) {
          i2 = 3;
        }
      }
    }
    if (i2 == 0)
    {
      localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_icon");
      if ((!(localObject instanceof Boolean)) || (!((Boolean)localObject).booleanValue())) {}
    }
    for (i1 = 1;; i1 = i2)
    {
      i2 = i1;
      if ("我".equals(paramString))
      {
        i2 = i1;
        if (i1 != 0) {
          i2 = 1;
        }
      }
      return i2;
    }
  }
  
  private View a(int paramInt, DragRelativeLayout paramDragRelativeLayout)
  {
    View localView = getLayoutInflater().inflate(2130903274, null);
    ((ImageView)localView.findViewById(2131231915)).setImageResource(paramInt);
    if (paramDragRelativeLayout != null) {}
    return localView;
  }
  
  private void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean(String.valueOf(paramInt), false))) {
      return;
    }
    new Handler().postDelayed(new dpw(this, paramInt), 2000L);
  }
  
  private void a(int paramInt, dpz paramdpz)
  {
    if (paramdpz == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, paramdpz.jdField_a_of_type_JavaLangString + " is execute");
        }
        if (paramInt == 2131230863)
        {
          paramdpz = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
          if ((paramdpz == null) || (paramdpz.a == null))
          {
            if (QLog.isColorLevel()) {
              QLog.w("SplashActivity", 2, "mWrapper is null");
            }
            QQToast.a(getApplicationContext(), 0, getResources().getString(2131559130), 0).b(getResources().getDimensionPixelSize(2131427376));
          }
          for (;;)
          {
            ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
            return;
            if (paramdpz.a.iUpgradeType == 0) {
              QQToast.a(getApplicationContext(), 0, getResources().getString(2131559130), 0).b(getResources().getDimensionPixelSize(2131427376));
            } else if ((paramdpz != null) && (paramdpz.a != null)) {
              UpgradeDetailActivity.a(this, UpgradeController.a().a(), false, false, true);
            }
          }
        }
        if (paramInt != 2131230865) {
          break;
        }
        ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
      } while (!PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this));
      f();
      return;
      if (paramInt == 2131230866)
      {
        e();
        return;
      }
    } while (paramdpz.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
    a(paramdpz.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
  }
  
  private void a(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("forward", -1))
    {
    }
    for (;;)
    {
      getIntent().removeExtra("forward");
      return;
      Intent localIntent = new Intent(this, ChatActivity.class);
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
        paramIntent.e = 100;
        paramIntent.f = 6;
        ProfileActivity.a(this, paramIntent);
      }
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    QLog.d("SplashActivity", 2, "saveCache");
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      QLog.d("SplashActivity", 2, paramAccountDetail.name);
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        localEntityManager.a(AccountDetail.class);
      }
    }
    for (;;)
    {
      localEntityManager.a();
      QLog.d("SplashActivity", 2, "saveCache exit");
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      localEntityManager.a(paramAccountDetail);
    }
  }
  
  private void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    AboutConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, paramResourcePluginInfo);
    if (paramResourcePluginInfo.strPkgName.equals("com.tx.abouthelp")) {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.d("sp", 2, "currentTabTag is null");
      }
    }
    View localView;
    do
    {
      return;
      localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (localView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("sp", 2, "tabview is null");
    return;
    StringBuilder localStringBuilder = new StringBuilder();
    label93:
    int i1;
    if ("消息".equals(paramString1))
    {
      localStringBuilder.append(getResources().getString(2131559121));
      if (QLog.isColorLevel()) {
        QLog.d("sp", 2, "tabTag=" + paramString1 + " currentTabTag=" + paramString2);
      }
      if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith(paramString2))) {
        localStringBuilder.append(getResources().getString(2131559125));
      }
      i1 = a(paramString1);
      paramString1 = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (i1 != 2) {
        break label373;
      }
      localStringBuilder.append(getResources().getString(2131559126));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sp", 2, "description is:" + localStringBuilder.toString());
      }
      localView.setContentDescription(localStringBuilder.toString());
      return;
      if ("联系人".equals(paramString1))
      {
        localStringBuilder.append(getResources().getString(2131559122));
        break label93;
      }
      if ("动态".equals(paramString1))
      {
        localStringBuilder.append(getResources().getString(2131559123));
        break label93;
      }
      if ("我".equals(paramString1))
      {
        localStringBuilder.append(getResources().getString(2131559124));
        break label93;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("sp", 2, "unknown tab");
      return;
      label373:
      if (i1 == 3)
      {
        paramString1 = paramString1.getText().toString();
        if ("99+".equals(paramString1)) {
          localStringBuilder.append(getResources().getString(2131559127));
        } else {
          localStringBuilder.append(getResources().getString(2131559128, new Object[] { paramString1 }));
        }
      }
      else if (i1 == 1)
      {
        localStringBuilder.append(getResources().getString(2131559129));
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("sp", 2, "all icon is not visible");
      }
    }
  }
  
  private View[] a(View paramView)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null) {
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(12);
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = ((DragRelativeLayout)paramView.findViewById(2131231910));
      View localView1 = a(2130840262, null);
      View localView2 = a(2130840261, null);
      View localView3 = a(2130840263, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localView1, localView2, localView3 };
      this.jdField_a_of_type_JavaUtilHashMap.put("消息", localView1);
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人", localView2);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", localView3);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息_num", localView1.findViewById(2131231916));
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人_num", localView2.findViewById(2131231916));
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", localView3.findViewById(2131231916));
      if (paramView == null) {
        break label239;
      }
    }
    label239:
    for (paramView = (QQTabWidget)paramView.findViewById(16908307);; paramView = (QQTabWidget)findViewById(16908307))
    {
      paramView.setTabWidgetMoveListener(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener);
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = ((DragRelativeLayout)findViewById(2131231910));
      break;
    }
  }
  
  private void b(int paramInt)
  {
    QLog.d("SplashActivity", 2, "follow");
    NewIntent localNewIntent = new NewIntent(this, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    localFollowRequest.uin.set(paramInt);
    localNewIntent.putExtra("data", localFollowRequest.toByteArray());
    localNewIntent.setObserver(new dpr(this, paramInt));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    QLog.d("SplashActivity", 2, "follow exit");
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getScheme() != null) && (paramIntent.getScheme().equals("tel")))
    {
      if (((PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b() >= 7)
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        VoipPhoneNumber localVoipPhoneNumber = new VoipPhoneNumber(paramIntent, getBaseContext());
        Intent localIntent = new Intent(this, VoipDialInterfaceActivity.class);
        localIntent.putExtra("dialData", new VoipDialData(localVoipPhoneNumber.b, localVoipPhoneNumber.jdField_a_of_type_JavaLangString));
        localIntent.putExtra("callNow", 0);
        startActivity(localIntent);
        QLog.i("System Phone", 0, paramIntent);
      }
    }
    else {
      return;
    }
    startActivity(new Intent(this, VoipAddressBookActivity.class));
  }
  
  private String c()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "getCurrentTabTag. mTabHost is null");
      }
      localObject = null;
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return localObject;
        str1 = "";
        str2 = a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        localObject = str1;
      } while (str2 == null);
      if (str2.equals(Conversation.class.getName())) {
        return "消息";
      }
      if (str2.equals(Contacts.class.getName())) {
        return "联系人";
      }
      localObject = str1;
    } while (!str2.equals(Leba.class.getName()));
    return "动态";
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.get("动态_num") instanceof TextView))
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get("动态_num");
      return (localTextView != null) && (localTextView.getVisibility() == 0);
    }
    return false;
  }
  
  private void j()
  {
    ((MessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).k();
  }
  
  private void k()
  {
    try
    {
      getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "showActionSheet");
    }
    e();
    if (isFinishing()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    new dpz().jdField_a_of_type_JavaLangString = getResources().getString(2131563137);
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a("com.tx.abouthelp");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "feedback plugin is add overmenu");
      }
      dpz localdpz = new dpz();
      localdpz.jdField_a_of_type_JavaLangString = getString(2131562102);
      localdpz.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
    }
    localObject = new dpz();
    ((dpz)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131562708);
    localArrayList.add(new Pair(Integer.valueOf(2131230865), localObject));
    localObject = new dpz();
    ((dpz)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131561751);
    localArrayList.add(new Pair(Integer.valueOf(2131230866), localObject));
    localObject = (ActionSheet)ActionSheetHelper.c(this, null);
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      if (2131230866 == ((Integer)((Pair)localArrayList.get(i1)).first).intValue()) {
        ((ActionSheet)localObject).d(((dpz)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((ActionSheet)localObject).c(((dpz)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((ActionSheet)localObject).a(new dpx(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new dpy(this));
    ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void m()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.a().iterator();
    ResourcePluginInfo localResourcePluginInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localResourcePluginInfo = (ResourcePluginInfo)((Iterator)localObject).next();
    } while ((TextUtils.isEmpty(localResourcePluginInfo.strPkgName)) || (!localResourcePluginInfo.strPkgName.equals("m.tx.apphelper.android")));
    for (long l1 = localResourcePluginInfo.uiResId;; l1 = 0L)
    {
      localObject = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if ((localObject == null) || ((!((GameCenterManagerImp)localObject).a(601L)) && ((l1 <= 0L) || (!((GameCenterManagerImp)localObject).a(l1))))) {
        break;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "initViewPager");
    }
    h();
    if (Build.VERSION.SDK_INT >= 11) {
      p();
    }
    ActionBar localActionBar = getSupportActionBar();
    localActionBar.setDisplayHomeAsUpEnabled(false);
    localActionBar.setDisplayShowHomeEnabled(false);
    localActionBar.setHomeButtonEnabled(false);
    localActionBar.setDisplayShowTitleEnabled(false);
    localActionBar.setDisplayShowCustomEnabled(true);
    localActionBar.setNavigationMode(2);
    if (c()) {
      localActionBar.setSplitBackgroundDrawable(new ColorDrawable(-16777216));
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131231911));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(3);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity$ViewPagerAdapter = new SplashActivity.ViewPagerAdapter(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity$ViewPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new dpm(this));
    o();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
    supportInvalidateOptionsMenu();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {
      this.jdField_a_of_type_ArrayOfAndroidViewView = a(null);
    }
    ActionBar localActionBar = getSupportActionBar();
    int i1 = 0;
    if (i1 < 3)
    {
      ActionBar.Tab localTab = localActionBar.newTab();
      localTab.setTabListener(this);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionBar.addTab(localTab);
        i1 += 1;
        break;
        this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130903274, new LinearLayout(this), false);
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[0] == null)
        {
          localTab.setIcon(2130840262);
        }
        else
        {
          localTab.setCustomView(this.jdField_b_of_type_AndroidViewView);
          continue;
          localTab.setIcon(2130840261);
          continue;
          localTab.setIcon(2130840263);
        }
      }
    }
  }
  
  private void p()
  {
    try
    {
      Object localObject = ActionBarActivity.class.getDeclaredField("mImpl");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      Field localField = Class.forName("android.support.v7.app.ActionBarActivityDelegate").getDeclaredField("mHasActionBar");
      localField.setAccessible(true);
      localField.setBoolean(localObject, true);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  private void q()
  {
    QLog.d("SplashActivity", 2, "mockWelcomeMessage");
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    String str = getResources().getString(2131559928);
    localMessageRecord.init(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), 1752794996L, 1752794996L, str, System.currentTimeMillis() / 1000L, -1000, 1008, System.currentTimeMillis() / 1000L);
    localMessageRecord.issend = 0;
    localMessageRecord.isread = false;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private void r()
  {
    QLog.d("SplashActivity", 2, "sendDetailInfoRequest");
    NewIntent localNewIntent = new NewIntent(this, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set(1752794996);
        label71:
        localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        localNewIntent.setObserver(new dpo(this));
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        QLog.d("SplashActivity", 2, "sendDetailInfoRequest exit");
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label71;
    }
  }
  
  private void s()
  {
    QLog.d("SplashActivity", 2, "retryGetInfo count = retryGetInfoCount");
    if (this.s < 5)
    {
      r();
      this.s += 1;
    }
  }
  
  private void t()
  {
    QLog.d("SplashActivity", 2, "follow");
    NewIntent localNewIntent = new NewIntent(this, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    localFollowRequest.uin.set(1752794996);
    localNewIntent.putExtra("data", localFollowRequest.toByteArray());
    localNewIntent.setObserver(new dpp(this));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    QLog.d("SplashActivity", 2, "follow exit");
  }
  
  private void u()
  {
    QLog.d("SplashActivity", 2, "retryFollow count = " + this.t);
    if (this.t < 5)
    {
      t();
      this.t += 1;
    }
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return b(getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624405);
    localDialog.setContentView(2130903219);
    TextView localTextView = (TextView)localDialog.findViewById(2131231469);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231029);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231472);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231473);
    if (paramString1 != null) {
      paramString1.setText(17039370);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {
      return;
    }
    String str1;
    String str2;
    label75:
    Object localObject;
    switch (paramInt1)
    {
    default: 
      str1 = "";
      switch (paramInt2)
      {
      default: 
        str2 = null;
        if (paramInt1 == 35)
        {
          localObject = a(Conversation.class);
          if (!(localObject instanceof Conversation)) {
            break label671;
          }
          localObject = ((Conversation)localObject).a;
        }
        break;
      }
      break;
    }
    label108:
    while ((localObject != null) && (str2 != null))
    {
      int i1;
      boolean bool;
      if ((paramObject instanceof Integer))
      {
        i1 = ((Integer)paramObject).intValue();
        bool = false;
      }
      for (;;)
      {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int i2;
        if (str2.equals(str1 + "_num"))
        {
          localSharedPreferences.edit().putInt(str2 + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i1).commit();
          this.jdField_b_of_type_JavaUtilHashMap.put(str2, paramObject);
          i2 = a(str1);
          if (i2 != 3) {
            break label650;
          }
          paramObject = this.jdField_b_of_type_JavaUtilHashMap.get(str1 + "_num");
          if (!(paramObject instanceof Integer)) {
            break label650;
          }
        }
        for (i1 = ((Integer)paramObject).intValue();; i1 = 0)
        {
          if (paramInt1 == 32) {
            i2 = 5;
          }
          for (;;)
          {
            if (QLog.isDevelopLevel())
            {
              paramObject = new StringBuilder();
              paramObject.append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(i2).append(",").append("num = ").append(i1).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localObject.toString()).append(" ]");
              QLog.d("SplashActivity", 4, paramObject.toString());
            }
            CustomWidgetUtil.a((TextView)localObject, i2, i1, 0);
            a(str1, c());
            return;
            str1 = "消息";
            break;
            str1 = "联系人";
            break;
            str1 = "动态";
            break;
            str1 = "我";
            break;
            str2 = str1 + "_num";
            break label75;
            str2 = str1 + "_icon";
            break label75;
            str2 = str1 + "_new";
            break label75;
            if (paramInt1 != 32) {
              break label665;
            }
            localObject = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131231916);
            break label108;
            if (!(paramObject instanceof Boolean)) {
              break label656;
            }
            bool = ((Boolean)paramObject).booleanValue();
            i1 = 0;
            break label137;
            localSharedPreferences.edit().putBoolean(str2 + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool).commit();
            break label216;
          }
        }
        i1 = 0;
        bool = false;
      }
      localObject = null;
      continue;
      localObject = null;
    }
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    String str = null;
    if (paramString.equals(Conversation.class.getName()))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Msg_tab", 0, 0, "", "", "", "");
      str = "消息";
    }
    for (;;)
    {
      new Handler().postDelayed(new dpv(this, i1), 100L);
      if (str != null)
      {
        a("消息", str);
        a("联系人", str);
        a("动态", str);
      }
      return;
      if (paramString.equals(Contacts.class.getName()))
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab", 0, 0, "", "", "", "");
        str = "联系人";
        i1 = 1;
      }
      else if (paramString.equals(Leba.class.getName()))
      {
        i1 = 2;
        paramString = a();
        if ((paramString != null) && ((paramString instanceof Leba))) {
          ((Leba)paramString).k();
        }
        m();
        if (d())
        {
          paramString = (RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
          if (paramString != null) {
            paramString.b(34);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.j();
        str = "动态";
      }
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public Dialog b(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624405);
    localDialog.setContentView(2130903162);
    TextView localTextView = (TextView)localDialog.findViewById(2131231469);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231029);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231472);
    if (paramString1 != null) {
      paramString1.setText(17039370);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231473);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public boolean c()
  {
    return (Build.MANUFACTURER != null) && (Build.MANUFACTURER.equals("Meizu")) && (Build.DISPLAY != null) && (Build.DISPLAY.compareTo("Flyme OS 2") >= 0);
  }
  
  public void d()
  {
    super.d();
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.j();
    }
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.c();
      jdField_a_of_type_Boolean = false;
      StartupTracker.a("Main_Start", null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (UserguideActivity.a(this))
    {
      paramBundle = new Intent(this, UserguideActivity.class);
      paramBundle.putExtra("userguide_type", 0);
      startActivity(paramBundle);
      finish();
      return false;
    }
    StartupTracker.a(null, "Main_Start");
    StartupTracker.a(null, "Main_OnCreat");
    super.doOnCreate(paramBundle);
    if ((jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "duplicate SplashActivity: " + jdField_a_of_type_ComTencentMobileqqActivitySplashActivity + ", " + this);
      }
      this.jdField_c_of_type_Boolean = true;
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b(getIntent());
      finish();
      return false;
    }
    jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = this;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isClearTaskBySystem = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver = new MainAssistObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_c_of_type_Boolean = true;
      finish();
      StartupTracker.a("Main_OnCreat", null);
      return false;
    }
    if ((NotificationActivity.a == null) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
    {
      startActivity(new Intent(this, LoginActivity.class));
      this.jdField_c_of_type_Boolean = true;
      finish();
      StartupTracker.a("Main_OnCreat", null);
      return false;
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      setContentView(this.jdField_c_of_type_AndroidViewView);
    }
    for (;;)
    {
      getWindow().setBackgroundDrawable(null);
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.j = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView = a(null);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      }
      try
      {
        paramBundle = (NotificationManager)getSystemService("notification");
        paramBundle.cancel(120);
        paramBundle.cancel(121);
        paramBundle.cancel(122);
        label343:
        if ((getIntent().getExtras() != null) && (getIntent().getExtras().containsKey("forward"))) {
          this.p = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.i();
        if (QLog.isColorLevel()) {
          QLog.d("Version", 2, "QQ_Version:6.0.0.6500");
        }
        QLog.sBuildNumber = "6.0.0.6500.2018-05-20.r24935.YingYongBao";
        StartupTracker.a("Main_OnCreat", null);
        n();
        paramBundle = getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        if ((paramBundle != null) && (!paramBundle.getBoolean("qqi_public_account", false))) {
          new Handler().postDelayed(new dpq(this), 2000L);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7000, 2000L);
        k();
        return true;
        setContentView(2130903273);
      }
      catch (Exception paramBundle)
      {
        break label343;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d();
        }
        ScreenCapture.clearSnapCacheFile(this);
      } while ((!isFinishing()) || (!h()));
      try
      {
        UniformDownloadMgr.a().c();
        if (QLog.isColorLevel()) {
          QLog.d("MemoryManager", 2, "MainActivity.onDestory.TMAssistantDownloadSDKManager.getInstance(BaseApplication.getContext()).closeAllService(BaseApplication.getContext()");
        }
        if (DownloadManager.a()) {
          DownloadManager.a().e();
        }
        AppNotificationManager.a().a();
        TMAssistantDownloadSDKManager.closeAllService(BaseApplication.getContext());
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          continue;
          boolean bool = false;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k();
      }
      if (this.d) {
        break;
      }
      bool = true;
      jdField_b_of_type_Boolean = bool;
    } while (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isClearTaskBySystem = jdField_b_of_type_Boolean;
    if (jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop = true;
      sendBroadcast(new Intent("mqq.intent.action.EXIT" + getPackageName()));
      return;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      l();
    }
    do
    {
      do
      {
        return true;
        if (paramInt != 4) {
          break;
        }
      } while (a().b());
      try
      {
        moveTaskToBack(true);
        return true;
      }
      catch (Throwable paramKeyEvent) {}
    } while (!QLog.isColorLevel());
    QLog.e("SplashActivity", 2, "", paramKeyEvent);
    return true;
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onNewIntent ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null)
      {
        bool = true;
        QLog.d("SplashActivity", 2, bool);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
        break label63;
      }
    }
    label63:
    do
    {
      return;
      bool = false;
      break;
      if ((getIntent().getExtras() != null) && (getIntent().getExtras().containsKey("forward"))) {
        this.p = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.i();
    } while (paramIntent.getExtras() == null);
    if (Boolean.valueOf(paramIntent.getExtras().getBoolean("EXIT", false)).booleanValue()) {
      finish();
    }
    if (paramIntent.getExtras().containsKey("tab_index"))
    {
      if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity$ViewPagerAdapter == null)) {
        break label255;
      }
      int i1 = paramIntent.getExtras().getInt("tab_index");
      if ((i1 >= 0) && (i1 < this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity$ViewPagerAdapter.getCount())) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i1);
      }
    }
    for (;;)
    {
      if (paramIntent.getIntExtra("forward", -1) == 2)
      {
        localObject = paramIntent.getParcelableExtra("AllInOne");
        if ((localObject instanceof ProfileActivity.AllInOne))
        {
          localObject = (ProfileActivity.AllInOne)localObject;
          ((ProfileActivity.AllInOne)localObject).e = 100;
          ((ProfileActivity.AllInOne)localObject).f = 6;
          ProfileActivity.a(this, (ProfileActivity.AllInOne)localObject);
        }
      }
      paramIntent.removeExtra("forward");
      return;
      label255:
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "MainActivity:onNewIntent mTabHost is null");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    e();
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = false;
    if (DrawerFrame.d == 2)
    {
      Handler localHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessageDelayed(1031, 1000L);
      }
    }
  }
  
  public void doOnResume()
  {
    StartupTracker.a(null, "Main_OnResume");
    if (DrawerFrame.d > 0)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localObject != null) {
        ((Handler)localObject).removeMessages(1031);
      }
      Conversation.o();
    }
    super.doOnResume();
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    Object localObject = getWindow();
    if ((((Window)localObject).getAttributes().flags & 0x400) != 0) {
      ((Window)localObject).clearFlags(1024);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getKickIntent() != null)
    {
      startActivity(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getKickIntent());
      return;
    }
    a(getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("theme_voice_setting_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), true))
    {
      localObject = ThemeUtil.getThemeInfo(this, ThemeUtil.getUserCurrentThemeId(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).status.equals("5")) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {}
    }
    for (boolean bool = false;; bool = true)
    {
      ((View)this.jdField_a_of_type_JavaUtilHashMap.get("消息")).setSoundEffectsEnabled(bool);
      ((View)this.jdField_a_of_type_JavaUtilHashMap.get("联系人")).setSoundEffectsEnabled(bool);
      ((View)this.jdField_a_of_type_JavaUtilHashMap.get("动态")).setSoundEffectsEnabled(bool);
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getDevLockIntent() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume start push");
        }
        new Handler().postDelayed(new dps(this), 800L);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume security detect push banner");
        }
        new Handler().postDelayed(new dpt(this), 800L);
      }
      StartupTracker.a("Main_OnResume", null);
      if (!jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.c();
      jdField_a_of_type_Boolean = false;
      StartupTracker.a("Main_Start", null);
      return;
    }
  }
  
  protected void doOnStart()
  {
    getSupportActionBar().show();
    super.doOnStart();
    if (this.f) {
      this.f = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (DrawerFrame.d > 0) {
      Conversation.o();
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_b_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  void f()
  {
    g();
    if (isFinishing()) {
      return;
    }
    Dialog localDialog = a(getResources().getString(2131559131), getResources().getString(2131559132), new dpf(this));
    Object localObject = (TextView)localDialog.findViewById(2131231473);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new dpg(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131231472);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new dph(this));
    }
    localObject = getString(2131561654);
    boolean bool = SettingCloneUtil.isContainValue(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.e = SettingCloneUtil.readValue(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131231665);
    if ((bool) && (this.e)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.e);
    ((CheckBox)localObject).setOnCheckedChangeListener(new dpi(this));
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void finish()
  {
    super.finish();
    if (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7000);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7000, 2000L);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    SharedPreUtils.a(getApplication(), "");
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.e();
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.j)) && (this.j.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {}
    }
    try
    {
      Object localObject = (NotificationManager)getSystemService("notification");
      ((NotificationManager)localObject).cancel(120);
      ((NotificationManager)localObject).cancel(121);
      ((NotificationManager)localObject).cancel(122);
      label149:
      this.j = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
      if (!SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis() / 1000L);
      }
      localObject = getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("qqi_public_account", false))) {
        new Handler().postDelayed(new dpu(this), 2000L);
      }
      return;
    }
    catch (Exception localException)
    {
      break label149;
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    Object localObject = new TextView(this);
    ((TextView)localObject).setTextColor(-16777216);
    ((TextView)localObject).setTextSize(getResources().getInteger(2131492867));
    ((TextView)localObject).setText(2131562674);
    localLinearLayout.addView((View)localObject);
    localObject = new CheckBox(this);
    ((CheckBox)localObject).setTextColor(-16777216);
    ((CheckBox)localObject).setText(2131561445);
    ((CheckBox)localObject).setChecked(true);
    localLinearLayout.addView((View)localObject);
    return DialogUtil.a(this, 230).setTitle(getString(2131562675)).addView(localLinearLayout).setPositiveButton(2131562722, new dpk(this, (CheckBox)localObject)).setNegativeButton(2131561444, new dpj(this, (CheckBox)localObject));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "MainActivity:onLogout");
    }
    SharedPreUtils.a(getApplication(), "");
    if (TroopAssistantManager.a().d()) {
      TroopAssistantManager.a().a(false);
    }
    TroopAssistantManager.a().d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    LoadingStateManager.a().a(1);
    super.onLogout(paramLogoutReason);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131230865)
    {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
      if (!PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this)) {
        return true;
      }
      f();
    }
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.a(paramMenuItem);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onPostThemeChanged()
  {
    Frame localFrame = a(Conversation.class);
    if (localFrame != null) {
      ((Conversation)localFrame).z_();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "onPrepareOptionsMenu");
    }
    paramMenu.clear();
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.a(paramMenu);
    }
    if (c()) {
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 2131230865, 0, getString(2131562708)), 0);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {}
  
  public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramTab.getPosition());
  }
  
  public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {}
  
  public void preloadUi()
  {
    try
    {
      this.jdField_c_of_type_AndroidViewView = getLayoutInflater().inflate(2130903273, null);
      a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(BaseApplicationImpl.a).inflate(2130903152, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SplashActivity", 2, "", localThrowable);
    }
  }
  
  protected void w_()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity
 * JD-Core Version:    0.7.0.1
 */