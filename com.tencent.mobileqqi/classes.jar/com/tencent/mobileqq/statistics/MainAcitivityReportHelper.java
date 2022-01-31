package com.tencent.mobileqq.statistics;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import gom;
import gon;
import goo;
import gop;
import goq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

public class MainAcitivityReportHelper
{
  static final String jdField_a_of_type_JavaLangString = "search";
  private static int jdField_b_of_type_Int = 0;
  private static final long jdField_b_of_type_Long = 86400000L;
  static final String jdField_b_of_type_JavaLangString = "add_contact";
  private static int jdField_c_of_type_Int = 0;
  static final String jdField_c_of_type_JavaLangString = "plugin_manage";
  public static final String d = "friend";
  public static final String e = "troop";
  public static final String f = "discussion";
  private static final String g = "Menu_Quit";
  private int jdField_a_of_type_Int = 0;
  public long a;
  public Handler a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new gon(this);
  public WeakReference a;
  
  static
  {
    b = 60000;
    c = 50000;
  }
  
  public MainAcitivityReportHelper(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new gom(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSplashActivity);
  }
  
  private Activity a()
  {
    SplashActivity localSplashActivity = (SplashActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSplashActivity != null) {
      return localSplashActivity.a();
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject = ((InputMethodManager)localObject).getInputMethodList();
      int i;
      if (localObject == null) {
        i = 0;
      }
      while (j < i)
      {
        localStringBuffer.append(((InputMethodInfo)((List)localObject).get(j)).loadLabel(paramContext.getPackageManager()));
        localStringBuffer.append(';');
        j += 1;
        continue;
        i = ((List)localObject).size();
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      paramContext = localStringBuffer.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQi", 0).edit();
    paramContext.putInt("menu_quit_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    new gop(paramContext, paramLong, paramString).execute(new Void[0]);
  }
  
  private void a(StatisticCollector paramStatisticCollector)
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SplashActivity)localObject).b;
    } while (localObject == null);
    HashMap localHashMap = new HashMap();
    int i = 89050;
    if (SkinEngine.IS_PROBLEM_MIUI)
    {
      localHashMap.put("param_FailCode", Integer.toString(i));
      if ((!BaseApplicationImpl.jdField_a_of_type_Boolean) || (SkinEngine.IS_PROBLEM_MIUI)) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      paramStatisticCollector.a(((QQAppInterface)localObject).a(), "report_skin_engine_enable", bool, 0L, 0L, localHashMap, "");
      return;
      i = 89051;
      break;
    }
  }
  
  private static int b(Context paramContext)
  {
    return Math.min(paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  private static int b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQi", 0).getInt("menu_quit_" + paramString, 0);
  }
  
  private void b(StatisticCollector paramStatisticCollector)
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SplashActivity)localObject).b;
    } while (localObject == null);
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity");
    HashMap localHashMap = new HashMap();
    int i = localActivityManager.getMemoryClass();
    localHashMap.put("param_FailCode", Integer.toString(89000 + i));
    paramStatisticCollector.a(((QQAppInterface)localObject).a(), "report_mem_cache_size", false, i, 0L, localHashMap, "");
  }
  
  private static String c(Context paramContext)
  {
    int i = b(paramContext);
    int j = DeviceInfoUtil.b();
    paramContext = new StringBuilder("reportMainSartPerformance");
    if (i >= 720)
    {
      paramContext.append("Large");
      if (j != 1) {
        break label64;
      }
      paramContext.append("_1Core");
    }
    for (;;)
    {
      return paramContext.toString();
      paramContext.append("Small");
      break;
      label64:
      if (j == 2) {
        paramContext.append("_2Core");
      } else {
        paramContext.append("_4Core");
      }
    }
  }
  
  private static void d(String paramString)
  {
    new goq(paramString).execute(new Void[0]);
  }
  
  private static void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a().getApplicationContext();
    String str = Settings.Secure.getString(((Context)localObject).getContentResolver(), "default_input_method");
    localObject = a((Context)localObject);
    ReportController.b(paramQQAppInterface, "CliOper", "", paramQQAppInterface.a(), "Type_input", "Type_input", 0, 0, "", "", str, (String)localObject);
  }
  
  public void a()
  {
    SplashActivity localSplashActivity = (SplashActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSplashActivity == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = localSplashActivity.b;
    } while (localQQAppInterface == null);
    Contacts.c = 0;
    Contacts.b = 0;
    Contacts.d = 0;
    Contacts.jdField_a_of_type_Int = 0;
    Leba.f = 0;
    AssistantSettingActivity.jdField_a_of_type_Int = 0;
    DiscussionInfoCardActivity.c();
    MttBrowerWrapper.jdField_a_of_type_Int = 0;
    localSplashActivity.getSharedPreferences("mobileQQi", 0).edit().putInt("online_friend_enter_count_" + localQQAppInterface.a(), 0).commit();
    StatisticTroopAssist.a(a(), localQQAppInterface.a());
    StatisticAssist.a(localQQAppInterface, a(), localQQAppInterface.a());
    QQSettingUtil.a(a(), localQQAppInterface.a(), 0);
    a(a(), localQQAppInterface.a(), 0);
    ThemeUtil.resetThemeSwitchTimes(localQQAppInterface);
    ChatBackgroundSettingActivity.b(a(), localQQAppInterface.a());
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i = b(a(), paramQQAppInterface.a());
    a(a(), paramQQAppInterface.a(), i + 1);
  }
  
  public void a(String paramString)
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = ((SplashActivity)localObject).getSharedPreferences("mobileQQi", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("friend_click_count_" + paramString, Contacts.c);
    ((SharedPreferences.Editor)localObject).putInt("troop_click_count_" + paramString, Contacts.b);
    ((SharedPreferences.Editor)localObject).putInt("discussion_click_count_" + paramString, Contacts.d);
    ((SharedPreferences.Editor)localObject).putInt("search_click_count_" + paramString, Contacts.jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject).putInt("plugin_manage_click_count_" + paramString, Leba.f);
    ((SharedPreferences.Editor)localObject).putInt("clear_pic_buf_count_" + paramString, AssistantSettingActivity.jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject).putInt("share_disc_url_btn_click_count_" + paramString, DiscussionInfoCardActivity.c);
    ((SharedPreferences.Editor)localObject).putInt("discussion_url_copy_count_" + paramString, DiscussionInfoCardActivity.d);
    ((SharedPreferences.Editor)localObject).putInt("discussion_url_forward_count_" + paramString, DiscussionInfoCardActivity.e);
    ((SharedPreferences.Editor)localObject).putInt("discussion_url_click_count_" + paramString, MttBrowerWrapper.jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject).commit();
    if (QLog.isColorLevel()) {
      QLog.d("ActionReport", 2, "store data while exit app");
    }
    b(paramString);
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.e("MainActivityReportHandler", 2, "onResume send msg count:" + this.jdField_a_of_type_Int);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      c(paramQQAppInterface.getAccount());
      StatisticCollector.a(BaseApplication.getContext()).e(paramQQAppInterface.a());
    }
    if (paramQQAppInterface != null) {}
    for (String str = paramQQAppInterface.a();; str = null)
    {
      d(str);
      if (QLog.isDevelopLevel()) {
        QLog.d("MainAcitivityReportHelper", 4, "start");
      }
      ThreadManager.a().schedule(new goo(this, paramQQAppInterface), 60000L);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 180000L);
      return;
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "uin : " + paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Friend Tab Click Count : " + Contacts.c);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Troop Tab Click Count : " + Contacts.b);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Discussion Tab Click Count : " + Contacts.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Search Button Button Click Count : " + Contacts.jdField_a_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Plugin Manage Button Click Count : " + Leba.f);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Clear Picture Buffer Count : " + AssistantSettingActivity.jdField_a_of_type_Int);
      }
      localObject = ((SplashActivity)localObject).getSharedPreferences("mobileQQi", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Enter Online Friend Count : " + ((SharedPreferences)localObject).getInt(new StringBuilder().append("online_friend_enter_count_").append(paramString).toString(), 0));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Share Disc Url Btn Click Count : " + DiscussionInfoCardActivity.c);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Discussion Url Copy Count : " + DiscussionInfoCardActivity.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActionReport", 2, "Discussion Url Forward Count : " + DiscussionInfoCardActivity.e);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ActionReport", 2, "Discussion Url Click Count : " + MttBrowerWrapper.jdField_a_of_type_Int);
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramQQAppInterface != null)
    {
      a(paramQQAppInterface.getAccount());
      StatisticCollector.a(BaseApplication.getContext()).d(paramQQAppInterface.a());
    }
  }
  
  public void c(String paramString)
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = ((SplashActivity)localObject).getSharedPreferences("mobileQQi", 0);
    Contacts.c = ((SharedPreferences)localObject).getInt("friend_click_count_" + paramString, 0);
    Contacts.b = ((SharedPreferences)localObject).getInt("troop_click_count_" + paramString, 0);
    Contacts.d = ((SharedPreferences)localObject).getInt("discussion_click_count_" + paramString, 0);
    Contacts.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("search_click_count_" + paramString, 0);
    Leba.f = ((SharedPreferences)localObject).getInt("plugin_manage_click_count_" + paramString, 0);
    AssistantSettingActivity.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("clear_pic_buf_count_" + paramString, 0);
    DiscussionInfoCardActivity.c = ((SharedPreferences)localObject).getInt("share_disc_url_btn_click_count", 0);
    DiscussionInfoCardActivity.d = ((SharedPreferences)localObject).getInt("discussion_url_copy_count", 0);
    DiscussionInfoCardActivity.e = ((SharedPreferences)localObject).getInt("discussion_url_forward_count", 0);
    MttBrowerWrapper.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("discussion_url_click_count", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.MainAcitivityReportHelper
 * JD-Core Version:    0.7.0.1
 */