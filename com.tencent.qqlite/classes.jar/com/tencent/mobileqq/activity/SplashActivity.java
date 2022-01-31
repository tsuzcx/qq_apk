package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bkr;
import bks;
import bkt;
import bku;
import bkv;
import bkw;
import bkx;
import bky;
import bla;
import blb;
import blc;
import bld;
import ble;
import blf;
import blg;
import blh;
import bli;
import blj;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.mobileqq.app.FrameActivity.TabInfo;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQUnderlinePageIndicator;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.Constants.LogoutReason;
import protocol.KQQConfig.UpgradeInfo;

public class SplashActivity
  extends FrameActivity
{
  public static final int a = 0;
  private static volatile SplashActivity jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
  public static final String a = "SplashActivity";
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "http://mma.qq.com/feedback/qqlite.html#_rc=mqq_faq_feedback?fid=1113";
  public static boolean b = false;
  public static final int c = 2;
  public static final String c = "tab_index";
  public static final int d = 0;
  public static final String d = "消息";
  public static final int e = 0;
  public static final String e = "联系人";
  public static final int f = 1;
  public static final String f = "动态";
  private static boolean f = false;
  public static final int g = 3;
  public static final String g = "我";
  private static final boolean g = true;
  public static final int h = 4;
  public static final String h = "_icon";
  public static final int i = 300000;
  public static final String i = "_num";
  public static final int j = 16;
  public static final String j = "_new";
  public static final int k = 17;
  public static final String k = "_text";
  public static final int l = 18;
  public static final int m = 19;
  public static final int n = 32;
  public static final int o = 33;
  public static final int p = 34;
  public static final int q = 35;
  public Dialog a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bkw(this);
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bli jdField_a_of_type_Bli;
  public MainAssistObserver a;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQUnderlinePageIndicator jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  private List jdField_a_of_type_JavaUtilList;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = null;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private HashMap jdField_b_of_type_JavaUtilHashMap = null;
  public boolean c = false;
  public boolean d = false;
  public boolean e = true;
  public String l;
  private String n = null;
  private String o = null;
  
  static
  {
    if (!"Success".equals(BaseApplicationImpl.jdField_a_of_type_JavaLangString))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.jdField_a_of_type_JavaLangString;
      try
      {
        throw new IllegalAccessError("SplashActivity escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.c = str + "\n" + Log.getStackTraceString(localThrowable);
      }
    }
    for (;;)
    {
      f = false;
      jdField_a_of_type_Boolean = true;
      jdField_b_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
      return;
      BaseApplicationImpl.c = "";
    }
  }
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_new");
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      return 2;
    }
    localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_num");
    if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0)) {
      return 3;
    }
    localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_icon");
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      return 1;
    }
    paramString = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_text");
    if (((paramString instanceof String)) && (!TextUtils.isEmpty((String)paramString))) {
      return 5;
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, DragFrameLayout paramDragFrameLayout)
  {
    View localView = findViewById(paramInt1);
    ((TextView)localView.findViewById(2131297054)).setText(paramInt2);
    if (paramDragFrameLayout != null)
    {
      DragTextView localDragTextView = (DragTextView)localView.findViewById(2131298865);
      localDragTextView.setOnModeChangeListener(paramDragFrameLayout);
      localDragTextView.setDragViewType(2);
    }
    return localView;
  }
  
  private void a(int paramInt, blj paramblj)
  {
    if (paramblj == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, paramblj.jdField_a_of_type_JavaLangString + " is execute");
        }
        if (paramInt == 2131296388)
        {
          paramblj = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
          if ((paramblj == null) || (paramblj.a == null))
          {
            if (QLog.isColorLevel()) {
              QLog.w("SplashActivity", 2, "mWrapper is null");
            }
            QQToast.a(getApplicationContext(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131492887));
          }
          for (;;)
          {
            ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
            return;
            if (paramblj.a.iUpgradeType == 0) {
              QQToast.a(getApplicationContext(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131492887));
            } else if ((paramblj != null) && (paramblj.a != null)) {
              UpgradeDetailActivity.a(this, UpgradeController.a().a(), false, false, true);
            }
          }
        }
        if (paramInt != 2131296390) {
          break;
        }
        ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
      } while (!PhoneNumLoginImpl.a().a(this.app, this));
      e();
      return;
      if (paramInt == 2131296391)
      {
        c();
        return;
      }
    } while (paramblj.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
    a(paramblj.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
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
        paramIntent.f = 100;
        paramIntent.g = 6;
        ProfileActivity.b(this, paramIntent);
      }
    }
  }
  
  private void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    AboutConfig.a(this.app, this, paramResourcePluginInfo);
    if (paramResourcePluginInfo.strPkgName.equals("com.tx.abouthelp")) {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      paramString2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while (paramString2 == null);
    StringBuilder localStringBuilder = new StringBuilder();
    label51:
    int i1;
    if ("消息".equals(paramString1))
    {
      localStringBuilder.append("消息栏");
      i1 = a(paramString1);
      paramString1 = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (i1 != 2) {
        break label152;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      paramString2.setContentDescription(localStringBuilder.toString());
      return;
      if ("联系人".equals(paramString1))
      {
        localStringBuilder.append("联系人栏");
        break label51;
      }
      if (!"我".equals(paramString1)) {
        break;
      }
      localStringBuilder.append("我");
      break label51;
      label152:
      if (i1 == 3)
      {
        paramString1 = paramString1.getText().toString();
        if ("99+".equals(paramString1)) {
          localStringBuilder.append("多于99条未读");
        } else {
          localStringBuilder.append(paramString1 + "条未读");
        }
      }
      else if (i1 == 1)
      {
        localStringBuilder.append("有新消息");
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
    if (paramView != null) {}
    View localView1;
    View localView2;
    for (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131297286));; this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)findViewById(2131297286)))
    {
      paramView = a(2131297289, 2131362947, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localView1 = a(2131297290, 2131362948, null);
      localView2 = a(2131297291, 2131363563, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { paramView, localView1, localView2 };
      View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
      int i2 = arrayOfView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfView[i1].setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        i1 += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("消息", paramView);
    this.jdField_a_of_type_JavaUtilHashMap.put("联系人", localView1);
    this.jdField_a_of_type_JavaUtilHashMap.put("我", localView2);
    this.jdField_a_of_type_JavaUtilHashMap.put("消息_num", paramView.findViewById(2131298865));
    this.jdField_a_of_type_JavaUtilHashMap.put("联系人_num", localView1.findViewById(2131298865));
    this.jdField_a_of_type_JavaUtilHashMap.put("我_num", localView2.findViewById(2131298865));
    return this.jdField_a_of_type_ArrayOfAndroidViewView;
  }
  
  private String c()
  {
    String str = ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).jdField_a_of_type_JavaLangString;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str != null)
    {
      if (!str.equals(Conversation.class.getName())) {
        break label49;
      }
      localObject1 = "消息";
    }
    label49:
    do
    {
      return localObject1;
      if (str.equals(Contacts.class.getName())) {
        return "联系人";
      }
      localObject1 = localObject2;
    } while (!str.equals(QQSetting.class.getName()));
    return "我";
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.get("我_num") instanceof TextView))
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get("我_num");
      return (localTextView != null) && (localTextView.getVisibility() == 0);
    }
    return false;
  }
  
  private void h()
  {
    if (AIOUtils.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        AIOUtils.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("traceviewSwitch", false);
        AIOUtils.c = getIntent().getBooleanExtra("forbidChatFont", false);
        AIOUtils.d = getIntent().getBooleanExtra("forbidHeadPendant", false);
        AIOUtils.e = getIntent().getBooleanExtra("forbidChatBubble", false);
        AIOUtils.f = getIntent().getBooleanExtra("logDBOperation", false);
        AIOUtils.jdField_a_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SplashActivity", 2, "traceviewSwitch: " + AIOUtils.jdField_b_of_type_Boolean + " isForbidChatFontFun: " + AIOUtils.c + " isForbidHeadPendantFun: " + AIOUtils.d + " isForbidChatBubbleFun: " + AIOUtils.e + " logcatDBOperation: " + AIOUtils.f);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SplashActivity", 2, "", localException);
          }
        }
      }
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "showActionSheet");
    }
    c();
    if (isFinishing()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new blj();
    ((blj)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131363742);
    localArrayList.add(new Pair(Integer.valueOf(2131296388), localObject));
    localObject = this.app.a().a("com.tx.abouthelp");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "feedback plugin is add overmenu");
      }
      blj localblj = new blj();
      localblj.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localblj.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131296389), localblj));
    }
    localObject = new blj();
    ((blj)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131363053);
    localArrayList.add(new Pair(Integer.valueOf(2131296390), localObject));
    localObject = new blj();
    ((blj)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131363124);
    localArrayList.add(new Pair(Integer.valueOf(2131296391), localObject));
    localObject = (ActionSheet)ActionSheetHelper.a(this, null, 2131624120);
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      if (2131296391 == ((Integer)((Pair)localArrayList.get(i1)).first).intValue()) {
        ((ActionSheet)localObject).d(((blj)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((ActionSheet)localObject).c(((blj)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((ActionSheet)localObject).a(new ble(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new blf(this));
    ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void j()
  {
    ReportController.b(this.app, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    if ((this.app == null) || (this.app.a == null)) {
      return;
    }
    Object localObject = this.app.a.a().iterator();
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
      localObject = (GameCenterManagerImp)this.app.getManager(11);
      if ((localObject == null) || ((!((GameCenterManagerImp)localObject).a(601L)) && ((l1 <= 0L) || (!((GameCenterManagerImp)localObject).a(l1))))) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator = ((QQUnderlinePageIndicator)findViewById(2131297292));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator.setContents(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator.setFades(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator.setDragFrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    DragTextView localDragTextView = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get("消息_num");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator.setDragTextView(localDragTextView);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297141));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297287)).setFocusable(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296908));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296909));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296910));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("搜索");
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("更多");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838062);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bkx(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838060);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bky(this));
  }
  
  private void m()
  {
    Intent localIntent = new Intent(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131364085));
    localIntent.putExtra("param_done_button_wording", jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131363981));
    localIntent.putExtra("param_done_button_highlight_wording", jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131363982));
    localIntent.putExtra("param_max", 49);
    localIntent.putExtra("multi_chat", true);
    localIntent.setFlags(603979776);
    jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivityForResult(localIntent, 1300);
    jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.overridePendingTransition(2130968590, 2130968591);
    ReportController.b(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
  }
  
  private void n()
  {
    Intent localIntent = new Intent(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, AddContactsActivity.class);
    jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity(localIntent);
    ReportController.b(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    Intent localIntent = new Intent(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    ReportController.b(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return b(getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624120);
    localDialog.setContentView(2130903187);
    TextView localTextView = (TextView)localDialog.findViewById(2131296912);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296473);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296915);
    if (paramString1 != null) {
      paramString1.setText(2131362801);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296916);
    if (paramString1 != null) {
      paramString1.setText(2131362802);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {
      return;
    }
    String str2 = "";
    String str1;
    Object localObject;
    switch (paramInt1)
    {
    default: 
      str1 = "";
      switch (paramInt2)
      {
      default: 
        localObject = null;
        label83:
        if (!(this.jdField_a_of_type_JavaUtilHashMap.get(str1 + "_num") instanceof TextView)) {}
        break;
      }
      break;
    }
    for (TextView localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(str1 + "_num"); (localTextView != null) && (localObject != null); localTextView = null)
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
        label177:
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        label256:
        int i2;
        int i3;
        int i4;
        int i5;
        if (((String)localObject).equals(str1 + "_num"))
        {
          localSharedPreferences.edit().putInt((String)localObject + this.app.getAccount(), i1).commit();
          this.jdField_b_of_type_JavaUtilHashMap.put(localObject, paramObject);
          i2 = 0;
          i1 = a(str1);
          i3 = i2;
          if (i1 == 3)
          {
            paramObject = this.jdField_b_of_type_JavaUtilHashMap.get(str1 + "_num");
            i3 = i2;
            if ((paramObject instanceof Integer)) {
              i3 = ((Integer)paramObject).intValue();
            }
          }
          paramObject = str2;
          if (i1 == 5)
          {
            localObject = this.jdField_b_of_type_JavaUtilHashMap.get(str1 + "_text");
            paramObject = str2;
            if ((localObject instanceof String)) {
              paramObject = (String)localObject;
            }
          }
          i2 = 0;
          if (paramInt1 != 32) {
            break label967;
          }
          if (i3 <= 99) {
            break label906;
          }
          i4 = getResources().getDimensionPixelSize(2131493075);
          i5 = getResources().getDimensionPixelSize(2131493072);
          i1 = 4;
          i2 = 2130839406;
          label439:
          localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
          if (localObject != null)
          {
            ((RelativeLayout.LayoutParams)localObject).setMargins(i5, i4, 0, 0);
            localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        label906:
        label936:
        label967:
        for (;;)
        {
          int i6;
          if (paramInt1 == 34)
          {
            if (i1 != 1) {
              break label936;
            }
            i4 = getResources().getDimensionPixelSize(2131493074);
            i6 = getResources().getDimensionPixelSize(2131493073);
            i5 = i4;
          }
          for (;;)
          {
            localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).setMargins(i5, i6, 0, 0);
              localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(i1).append(",").append("num = ").append(i3).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
              QLog.d("SplashActivity", 4, ((StringBuilder)localObject).toString());
            }
            CustomWidgetUtil.a(localTextView, i1, i3, i2, 99, paramObject);
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
            localObject = str1 + "_num";
            break label83;
            localObject = str1 + "_icon";
            break label83;
            localObject = str1 + "_new";
            break label83;
            localObject = str1 + "_text";
            break label83;
            if (!(paramObject instanceof Boolean)) {
              break label970;
            }
            bool = ((Boolean)paramObject).booleanValue();
            i1 = 0;
            break label177;
            localSharedPreferences.edit().putBoolean((String)localObject + this.app.getAccount(), bool).commit();
            break label256;
            i4 = getResources().getDimensionPixelSize(2131493073);
            i5 = getResources().getDimensionPixelSize(2131493072);
            i2 = 0;
            break label439;
            i4 = getResources().getDimensionPixelSize(2131493075);
            i5 = getResources().getDimensionPixelSize(2131493072);
            i6 = i4;
          }
        }
        label970:
        i1 = 0;
        bool = false;
      }
    }
  }
  
  public Dialog b(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624120);
    localDialog.setContentView(2130903135);
    TextView localTextView = (TextView)localDialog.findViewById(2131296912);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296473);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296915);
    if (paramString1 != null) {
      paramString1.setText(17039370);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296916);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected String b_()
  {
    return super.b_();
  }
  
  public void c()
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
  
  public void d()
  {
    super.d();
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.l();
    }
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.c();
      jdField_a_of_type_Boolean = false;
      if (isResume()) {
        runOnUiThread(new blc(this));
      }
      StartupTracker.a("Main_Start", null);
    }
    if (!MultiMsgManager.a().a()) {
      MultiMsgManager.a().a(this.app);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    StartupTracker.a(null, "Main_Start");
    StartupTracker.a(null, "Main_OnCreat");
    super.doOnCreate(paramBundle);
    if ((jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "duplicate SplashActivity: " + jdField_a_of_type_ComTencentMobileqqActivitySplashActivity + ", " + this);
      }
      this.c = true;
      finish();
      return false;
    }
    jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = this;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
    this.app.isClearTaskBySystem = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver = new MainAssistObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(this.app))
    {
      this.c = true;
      finish();
      StartupTracker.a("Main_OnCreat", null);
      return false;
    }
    if ((NotificationActivity.a == null) && (!this.app.isLogin()))
    {
      startActivity(new Intent(this, LoginActivity.class));
      this.c = true;
      finish();
      StartupTracker.a("Main_OnCreat", null);
      return false;
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      setContentView(this.jdField_b_of_type_AndroidViewView);
    }
    for (;;)
    {
      getWindow().setBackgroundDrawable(null);
      if (this.app != null)
      {
        this.l = this.app.getAccount();
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131297293));
        }
        if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView = a(null);
        }
        a(0, Conversation.class, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
        a(1, Contacts.class, this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
        a(2, QQSetting.class, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
        this.jdField_a_of_type_JavaUtilList = a();
        this.jdField_a_of_type_Bli = new bli(this, null);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Bli);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
        ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_AndroidViewView.setSelected(true);
        k();
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetQQUnderlinePageIndicator);
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
        l();
      }
      try
      {
        paramBundle = (NotificationManager)getSystemService("notification");
        paramBundle.cancel(120);
        paramBundle.cancel(121);
        paramBundle.cancel(122);
        label436:
        if (getIntent().getExtras() != null) {}
        try
        {
          if (getIntent().getExtras().containsKey("forward")) {
            this.t = false;
          }
          this.n = getIntent().getStringExtra("jump_action_from_h5");
          this.o = getIntent().getStringExtra("package_from_h5");
        }
        catch (Exception paramBundle)
        {
          label495:
          break label495;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.i();
        if (QLog.isColorLevel()) {
          QLog.d("Version", 2, "QQ_Version:3.5.0.660");
        }
        QLog.sBuildNumber = "3.5.0.660.2016-06-24.r108360.YingYongBao";
        StartupTracker.a("Main_OnCreat", null);
        return true;
        setContentView(2130903231);
      }
      catch (Exception paramBundle)
      {
        break label436;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.c) {}
    do
    {
      do
      {
        return;
        if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d();
        }
        ScreenCapture.clearSnapCacheFile(this);
      } while (!isFinishing());
      try
      {
        UniformDownloadMgr.a().b();
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
        if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
          break label241;
        }
        this.app.startPCActivePolling(this.app.getAccount(), "exitApp");
        this.app.b(true);
        return;
        this.app.b(false);
      }
      if (this.d) {
        break;
      }
      bool = true;
      jdField_b_of_type_Boolean = bool;
    } while (this.app == null);
    this.app.isClearTaskBySystem = jdField_b_of_type_Boolean;
    if (jdField_b_of_type_Boolean)
    {
      this.app.isBackground_Stop = true;
      sendBroadcast(new Intent("mqql.intent.action.EXIT" + getPackageName()));
      return;
    }
    label241:
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      i();
    }
    do
    {
      do
      {
        return true;
        if (paramInt != 4) {
          break;
        }
      } while (a().d());
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
    int i1;
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if ((getIntent().getExtras() != null) && (getIntent().getExtras().containsKey("forward"))) {
          this.t = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.i();
        localObject = paramIntent.getExtras();
      } while (localObject == null);
      if (Boolean.valueOf(((Bundle)localObject).getBoolean("EXIT", false)).booleanValue()) {
        finish();
      }
      if (!((Bundle)localObject).containsKey("tab_index")) {
        break label252;
      }
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
        break label316;
      }
      i1 = ((Bundle)localObject).getInt("tab_index");
      if ((i1 == 0) && (1 == ((Bundle)localObject).getInt("conversation_index", -1))) {
        try
        {
          ((Conversation)a(Conversation.class)).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i1);
          return;
        }
        catch (Exception paramIntent)
        {
          return;
        }
      }
      if ((i1 != 0) || (i1 != a())) {
        break label229;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("SplashActivity", 4, "doOnNewIntent, same tab");
    return;
    label229:
    if ((i1 >= 0) && (i1 < this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount())) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i1);
    }
    for (;;)
    {
      label252:
      if (paramIntent.getIntExtra("forward", -1) == 2)
      {
        localObject = paramIntent.getParcelableExtra("AllInOne");
        if ((localObject instanceof ProfileActivity.AllInOne))
        {
          localObject = (ProfileActivity.AllInOne)localObject;
          ((ProfileActivity.AllInOne)localObject).f = 100;
          ((ProfileActivity.AllInOne)localObject).g = 6;
          ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
        }
      }
      paramIntent.removeExtra("forward");
      return;
      label316:
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "MainActivity:onNewIntent mTabHost is null");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    c();
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = false;
  }
  
  public void doOnResume()
  {
    StartupTracker.a(null, "Main_OnResume");
    super.doOnResume();
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    Object localObject = getWindow();
    if ((((Window)localObject).getAttributes().flags & 0x400) != 0) {
      ((Window)localObject).clearFlags(1024);
    }
    if (this.app.getKickIntent() != null) {
      startActivity(this.app.getKickIntent());
    }
    do
    {
      return;
      a(getIntent());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null);
    if (!jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.a());
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("theme_voice_setting_" + this.app.a(), true))
    {
      localObject = ThemeUtil.getThemeInfo(this, ThemeUtil.getUserCurrentThemeId(this.app));
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).status.equals("5")) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {}
    }
    for (boolean bool = false;; bool = true)
    {
      ((View)this.jdField_a_of_type_JavaUtilHashMap.get("消息")).setSoundEffectsEnabled(bool);
      ((View)this.jdField_a_of_type_JavaUtilHashMap.get("联系人")).setSoundEffectsEnabled(bool);
      ((View)this.jdField_a_of_type_JavaUtilHashMap.get("我")).setSoundEffectsEnabled(bool);
      if (this.app.getDevLockIntent() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume start push");
        }
        new Handler().postDelayed(new bkr(this), 800L);
      }
      if (this.app.a() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume security detect push banner");
        }
        new Handler().postDelayed(new bla(this), 800L);
      }
      if ((!TextUtils.isEmpty(this.app.getAccount())) && (!"0".equals(this.app.getAccount())))
      {
        bool = SettingCloneUtil.readValue(this.app.a(), this.app.getAccount(), null, "pcactive_notice_key", false);
        if ((!SettingCloneUtil.readValue(this.app.a(), this.app.getAccount(), null, "pcactive_has_notice", false)) && (bool))
        {
          QLog.d("SplashActivity", 1, "PCActive tips");
          SettingCloneUtil.writeValue(this.app.a(), this.app.getAccount(), null, "pcactive_has_notice", true);
          new Handler().postDelayed(new blb(this), 800L);
        }
      }
      StartupTracker.a("Main_OnResume", null);
      return;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.n != null) && (this.n.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.o)))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.n);
      localJumpAction.b(this.o);
      localJumpAction.b();
      this.n = null;
      this.o = null;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  void e()
  {
    f();
    if (isFinishing()) {
      return;
    }
    Dialog localDialog = a("退出", "你确定退出QQ？", new blg(this));
    Object localObject = (TextView)localDialog.findViewById(2131296916);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new blh(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131296915);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new bks(this));
    }
    localObject = getString(2131363748);
    boolean bool = SettingCloneUtil.isContainValue(this, this.app.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.e = SettingCloneUtil.readValue(this, this.app.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131297087);
    if ((bool) && (this.e)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.e);
    ((CheckBox)localObject).setOnCheckedChangeListener(new bkt(this));
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void f()
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
  
  public void finish()
  {
    super.finish();
    if (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  public void g()
  {
    Intent localIntent = new Intent(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, Face2FaceActivity.class);
    jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity(localIntent);
    ReportController.b(jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "CliOper", "", "", "0X80049EF", "0X80049EF", 0, 0, "", "", "", "");
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    SharedPreUtils.a(getApplication(), "");
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.e();
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.l)) && (this.l.equals(this.app.getAccount()))) {}
    }
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
      localNotificationManager.cancel(120);
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(122);
      label124:
      this.l = this.app.getAccount();
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
      return;
    }
    catch (Exception localException)
    {
      break label124;
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
    ((TextView)localObject).setTextSize(getResources().getInteger(2131558400));
    ((TextView)localObject).setText(2131363255);
    localLinearLayout.addView((View)localObject);
    localObject = new CheckBox(this);
    ((CheckBox)localObject).setTextColor(-16777216);
    ((CheckBox)localObject).setText(2131363256);
    ((CheckBox)localObject).setChecked(true);
    localLinearLayout.addView((View)localObject);
    return DialogUtil.a(this, 230).setTitle(getString(2131363257)).addView(localLinearLayout).setPositiveButton(2131363258, new bkv(this, (CheckBox)localObject)).setNegativeButton(2131363259, new bku(this, (CheckBox)localObject));
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
    TroopAssistantManager.a().d(this.app);
    LoadingStateManager.a().a(1);
    super.onLogout(paramLogoutReason);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool1;
    boolean bool2;
    if (paramMenuItem.getItemId() == 2131296759)
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
      paramMenuItem = "";
      if (this.app.e()) {
        paramMenuItem = this.app.a();
      }
      bool1 = localSharedPreferences.getBoolean("notToastPushMsg" + paramMenuItem, true);
      bool2 = localSharedPreferences.getBoolean("login_auto" + paramMenuItem, false);
      if (!isFinishing()) {}
    }
    else
    {
      return false;
    }
    if ((bool1) || (!bool2))
    {
      showDialog(0);
      return false;
    }
    showDialog(0);
    return false;
  }
  
  public void onPostThemeChanged()
  {
    Frame localFrame = a(Conversation.class);
    if (localFrame != null) {
      ((Conversation)localFrame).b();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onTabChanged(String paramString)
  {
    int i1 = 0;
    super.onTabChanged(paramString);
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    DragTextView localDragTextView;
    if (paramString.equals(Conversation.class.getName()))
    {
      ReportController.b(this.app, "CliOper", "", "", "Msg_tab", "Msg_tab", 0, 0, "", "", "", "");
      localDragTextView = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get("消息_num");
      if (i1 != 0) {
        break label181;
      }
    }
    label181:
    for (paramString = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;; paramString = null)
    {
      localDragTextView.setOnModeChangeListener(paramString);
      new Handler().postDelayed(new bld(this, i1), 100L);
      return;
      if (paramString.equals(Contacts.class.getName()))
      {
        i1 = 1;
        break;
      }
      if (!paramString.equals(QQSetting.class.getName())) {
        break;
      }
      int i2 = 2;
      paramString = a();
      i1 = i2;
      if (paramString == null) {
        break;
      }
      i1 = i2;
      if (!(paramString instanceof QQSetting)) {
        break;
      }
      boolean bool = d();
      ((QQSetting)paramString).b(bool);
      i1 = i2;
      break;
    }
  }
  
  public void preloadUi()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130903231, null);
      a(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).inflate(2130903127, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SplashActivity", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity
 * JD-Core Version:    0.7.0.1
 */