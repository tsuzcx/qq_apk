package com.tencent.mobileqq.activity;

import acc;
import ace;
import acf;
import acg;
import ach;
import ack;
import acl;
import acm;
import acn;
import aco;
import acp;
import acq;
import acu;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ChatBackgroundManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatBackgroundSettingActivity
  extends IphoneTitleBarActivity
{
  public static Handler a;
  public static final String a;
  public static final String b = "__other_thumb";
  static final int jdField_c_of_type_Int = 0;
  static final int d = 1;
  public static final int e = 0;
  public static final String e = "OPENVIP_DOWN";
  public static final int f = 1;
  public static final String f = "OPENVIP_SET";
  public static final int g = 2;
  public static final String g = "OPENVIP_BUTTON";
  public static final String h = "XUFEI_VIP";
  static final int i = 0;
  public static final String i = "XUFEI_SVIP";
  static final int j = 1;
  public static String j;
  public static int l = 0;
  static final int m = 1;
  private static final int p = 0;
  private static final int q = 1;
  public float a;
  public int a;
  public acq a;
  public Activity a;
  private Uri jdField_a_of_type_AndroidNetUri;
  public View a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SVIPHandler a;
  UniPayHandler.UniPayUpdateListener jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener = new acc(this);
  private UniPayHandler jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
  public ChatBackgroundInfo a;
  public ChatBackgroundManager a;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new acp(this);
  public MyGridView a;
  public ArrayList a;
  public HashMap a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public Handler b;
  public View b;
  public ChatBackgroundInfo b;
  public ArrayList b;
  public HashMap b;
  private View jdField_c_of_type_AndroidViewView;
  public String c;
  public String d;
  public int h = 0;
  public int k;
  private int n;
  private int o;
  
  static
  {
    jdField_a_of_type_JavaLangString = ChatBackgroundSettingActivity.class.getSimpleName();
    jdField_a_of_type_AndroidOsHandler = new acu(BaseApplication.getContext().getMainLooper());
  }
  
  public ChatBackgroundSettingActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new acf(this);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQLite", 0).getInt(a(paramString), 0);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).getString("chat_uniform_bg", "null");
    if ((paramContext == null) || (paramContext.trim().length() == 0) || (paramContext.equals("null"))) {
      return "default_bg";
    }
    if (paramContext.equals("none")) {
      return "gray_bg";
    }
    int i1 = paramContext.lastIndexOf(File.separatorChar);
    if ((i1 >= 0) && (i1 < paramContext.length() - 1))
    {
      paramString = paramContext.substring(0, i1 + 1);
      if (AppConstants.bb.equals(paramString))
      {
        paramString = paramContext.substring(i1 + 1);
        i1 = paramString.lastIndexOf('.');
        paramContext = paramString;
        if (i1 >= 0) {
          paramContext = paramString.substring(0, i1);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "picName is:" + paramContext);
        }
        return "offical_bg_" + paramContext;
      }
      return "other_bg";
    }
    throw new IllegalStateException("picPath is illegal,picPath is:" + paramContext);
  }
  
  static String a(String paramString)
  {
    return "chat_background_switch_times_" + paramString;
  }
  
  public static ArrayList a()
  {
    for (;;)
    {
      int i1;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = FileUtils.a(new File(ChatBackgroundManagerImp.jdField_c_of_type_JavaLangString));
        localObject1 = new JSONObject((String)((String)localObject1).subSequence(((String)localObject1).indexOf("{"), ((String)localObject1).length() - 1)).getJSONObject("data").getJSONArray("chatBackground");
        int i2 = ((JSONArray)localObject1).length();
        i1 = 0;
        if (i1 < i2)
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
          String str1 = ((JSONObject)localObject2).getString("id");
          String str2 = ((JSONObject)localObject2).getString("name");
          String str3 = ((JSONObject)localObject2).getString("background");
          String str4 = ((JSONObject)localObject2).getString("thumbnail");
          localObject2 = ((JSONObject)localObject2).getString("viponly");
          if (((String)localObject2).equals("1")) {
            break label245;
          }
          ChatBackgroundInfo localChatBackgroundInfo = new ChatBackgroundInfo();
          localChatBackgroundInfo.id = str1;
          localChatBackgroundInfo.url = ("http://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/" + str3);
          localChatBackgroundInfo.thumb_url = ("http://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/" + str4);
          localChatBackgroundInfo.name = str2;
          localChatBackgroundInfo.type = ((String)localObject2);
          localArrayList.add(localChatBackgroundInfo);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      return localException;
      label245:
      i1 += 1;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("QQLite", 0);
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "uin is empty,not save switch bg times");
      }
    }
    int i1;
    do
    {
      return;
      paramString = a(paramString);
      i1 = paramContext.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "oldCount is:" + i1);
      }
      paramContext = paramContext.edit();
      i1 += 1;
      paramContext.putInt(paramString, i1);
      paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "save count is:" + i1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    l = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    j = null;
    paramQQAppInterface.a(new ace(paramString, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(j, Integer.valueOf(1));
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + j);
    }
    paramStatisticCollector.b(paramQQAppInterface, paramString, localHashMap);
  }
  
  private void a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.a());
      localJSONObject.put("openMonth", paramInt);
      localJSONObject.put("aid", "mvip.gexinghua.android.beijingmall");
      localJSONObject.put("offerId", "1450000515");
      localJSONObject.put("serviceName", "QQ会员");
      localJSONObject.put("serviceCode", "LTMCLUB");
      PayBridgeActivity.a(this, localJSONObject.toString(), 4, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).getString("chat_uniform_bg", "null");
    if ((paramContext == null) || (paramContext.trim().length() == 0) || (paramContext.equals("null"))) {
      paramString = "null";
    }
    do
    {
      return paramString;
      if (paramContext.equals("none")) {
        return "none";
      }
      int i1 = paramContext.lastIndexOf(File.separatorChar);
      paramString = paramContext.substring(0, i1 + 1);
      if (!AppConstants.ba.equals(paramString)) {
        break;
      }
      paramString = paramContext.substring(i1 + 1);
      i1 = paramString.lastIndexOf('.');
      paramContext = paramString;
      if (i1 >= 0) {
        paramContext = paramString.substring(0, i1);
      }
      paramString = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "picName is:" + paramContext);
    return paramContext;
    return "__other_thumb";
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("QQLite", 0);
    paramString = a(paramString);
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, 0);
    paramContext.commit();
  }
  
  private void b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.a());
      localJSONObject.put("openMonth", paramInt);
      localJSONObject.put("aid", "mvip.gexinghua.android.beijingmall");
      localJSONObject.put("offerId", "1450000516");
      localJSONObject.put("serviceName", "超级会员");
      localJSONObject.put("serviceCode", "CJCLUBT");
      PayBridgeActivity.a(this, localJSONObject.toString(), 4, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void f()
  {
    j = null;
    l = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "ChatBackgroundSettingActivity destroy() is called");
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131296683));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131296674);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("uin");
    ((TextView)findViewById(2131296681)).requestFocus();
    this.jdField_a_of_type_AndroidAppActivity = this;
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new acg(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)findViewById(2131296682));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setTranscriptMode(0);
    this.jdField_a_of_type_Acq = new acq(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Acq);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setOnItemClickListener(new ach(this));
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { HttpDownloadFileProcessor.class });
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_b_of_type_AndroidViewView = ((ViewGroup)findViewById(2131296676)).getChildAt(0);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131296794).setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131296796).setVisibility(8);
    ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131296792)).setImageResource(2130839278);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new ack(this));
    b();
    a();
    if (!new File(ChatBackgroundManagerImp.jdField_c_of_type_JavaLangString).exists()) {
      ThreadManager.a(new acl(this));
    }
  }
  
  private void h()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      String str = ChatActivityUtils.b(localBundle.getInt("uintype", 999));
      int i1 = localBundle.getInt("bg_replace_entrance", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " uin_type : " + str + " entrance_type ： " + i1);
      }
      if (i1 != 999) {
        ReportController.b(this.app, "CliOper", "", "", "background", "bkground_replace", i1, 0, str, "", "", "");
      }
    }
  }
  
  public void a()
  {
    String str1 = this.app.a();
    Object localObject = getSharedPreferences("uniPaySp_" + str1, 0);
    String str2 = ((SharedPreferences)localObject).getString("sUin", "");
    int i1 = ((SharedPreferences)localObject).getInt("isShowOpen", 0);
    int i2 = ((SharedPreferences)localObject).getInt("iUinpPayType", 0);
    int i3 = Integer.valueOf(((SharedPreferences)localObject).getString("open_month", "3")).intValue();
    localObject = (QQAppInterface)super.getAppRuntime();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296679));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131296680));
    if ((str2 != null) && (str1 != null) && (str2.equals(str1)))
    {
      if (i1 != 1) {
        break label506;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      switch (i2)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetButton);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new acm(this, i3));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131364280);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364080);
      this.h = 0;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363613);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364080);
      this.h = 1;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131364281);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364081);
      this.h = 2;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363614);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364081);
      this.h = 2;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363616);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364083);
      this.h = 2;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363619);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364083);
      this.h = 2;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363617);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364081);
      this.h = 2;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363615);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364082);
      this.h = 1;
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363618);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364082);
      this.h = 1;
      continue;
      label506:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void a(int paramInt, ChatBackgroundInfo paramChatBackgroundInfo)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_JavaUtilHashMap.get(paramChatBackgroundInfo.id) != null) && (this.jdField_b_of_type_JavaUtilHashMap.get(paramChatBackgroundInfo.id) != null)) {}
    for (int i1 = (int)(((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramChatBackgroundInfo.id)).longValue() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramChatBackgroundInfo.id)).longValue());; i1 = 0) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "download chatbg report actionResult=" + paramInt + ",chatbgId=" + paramChatBackgroundInfo.id);
        }
        int i2 = NetworkUtil.a(this.jdField_a_of_type_AndroidAppActivity);
        ReportController.b(this.app, "CliOper", "", "", "chatbackground", "BjIDXiazai", 0, paramInt, paramChatBackgroundInfo.id, "", i2 + "", String.valueOf(i1));
        return;
      }
      catch (Exception paramChatBackgroundInfo)
      {
        paramChatBackgroundInfo.printStackTrace();
        return;
      }
    }
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int i2 = getWindowManager().getDefaultDisplay().getWidth();
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(i3, i4);
    int i1 = paramTextView.getMeasuredWidth();
    paramView.measure(i3, i4);
    i3 = paramView.getMeasuredWidth();
    float f1 = getResources().getDisplayMetrics().density;
    i2 = i2 - i3 - (int)(40 * f1 + 0.5F);
    if (i1 > i2)
    {
      paramTextView.setMaxWidth(i2 - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  protected boolean a()
  {
    setResult(0);
    finish();
    return false;
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("chat_background_path_" + this.app.a(), 0);
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.d = localSharedPreferences.getString("chat_uniform_bg", "null");
    }
    for (;;)
    {
      runOnUiThread(new aco(this, a()));
      return;
      this.d = localSharedPreferences.getString(this.jdField_c_of_type_JavaLangString, null);
      if (this.d == null) {
        this.d = localSharedPreferences.getString("chat_uniform_bg", "null");
      }
    }
  }
  
  public void c()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i1).findViewById(2131296793).setVisibility(8);
      i1 += 1;
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131296793).setVisibility(8);
  }
  
  public void d()
  {
    ChatBackground.b(this, this.app.a(), this.jdField_c_of_type_JavaLangString, this.d);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramInt1 == 16)) {}
    while (paramInt1 != 200) {
      return;
    }
    c();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    e();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewB(2130903081);
    setTitle(getString(2131363544));
    ReportController.b(this.app, "CliOper", "", "", "chatbackground", "BjFanwen", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler = ((SVIPHandler)this.app.a(12));
    this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager = ((ChatBackgroundManager)this.app.getManager(50));
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.b();
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler = ((UniPayHandler)this.app.a(38));
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
    g();
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (paramIntent != null)
      {
        this.d = paramIntent;
        d();
        QQToast.a(this, 2131363546, 0).a();
        ReportController.b(this.app, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "DIY", "", "", "");
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    acn localacn = new acn(this);
    this.app.a(localacn);
  }
  
  public void e()
  {
    if (getResources().getConfiguration().orientation == 2) {}
    View localView1;
    for (this.o = 5;; this.o = 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(this.o);
      this.n = getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      int i1 = (int)(this.jdField_a_of_type_Float * 8.0F);
      this.jdField_a_of_type_Int = ((int)((this.n - (this.o + 1) * i1) / this.o));
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(2);
      int i2 = (int)Math.ceil((this.jdField_a_of_type_JavaUtilArrayList.size() + 1) / this.o);
      int i3 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getLayoutParams().height = ((i1 + i3) * i2);
      localView1 = this.jdField_b_of_type_AndroidViewView;
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_Int;
      localLayoutParams.height = this.jdField_a_of_type_Int;
      localView1.setLayoutParams(localLayoutParams);
      View localView2 = localView1.findViewById(2131296796);
      i1 = (localLayoutParams.height - (int)(this.jdField_a_of_type_Float * 8.0F)) * 31 / 132;
      localView2.setPadding((int)(this.jdField_a_of_type_Float * 4.0F), localLayoutParams.height - i1 - (int)(this.jdField_a_of_type_Float * 4.0F), (int)(this.jdField_a_of_type_Float * 4.0F), (int)(this.jdField_a_of_type_Float * 4.0F));
      if (SkinEngine.getInstances().getSkinRootPath() != null)
      {
        findViewById(2131296675).setVisibility(0);
        findViewById(2131296676).setVisibility(0);
        localView1 = localView1.findViewById(2131296793);
        if ((this.d != null) && (this.d.length() != 0) && (!"null".equals(this.d))) {
          break;
        }
        localView1.setVisibility(0);
      }
      return;
    }
    localView1.setVisibility(8);
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: aload_0
    //   4: iload_1
    //   5: iload_2
    //   6: aload_3
    //   7: invokespecial 930	com/tencent/mobileqq/app/IphoneTitleBarActivity:onActivityResult	(IILandroid/content/Intent;)V
    //   10: iload_1
    //   11: iconst_4
    //   12: if_icmpne +191 -> 203
    //   15: aload_3
    //   16: ifnull +187 -> 203
    //   19: aload_3
    //   20: ldc_w 932
    //   23: invokevirtual 467	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 7
    //   28: aload_3
    //   29: ldc_w 934
    //   32: invokevirtual 467	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_3
    //   36: new 249	org/json/JSONObject
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 260	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 6
    //   46: aload 6
    //   48: ldc_w 936
    //   51: invokevirtual 282	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokestatic 939	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   57: istore_2
    //   58: aload 6
    //   60: ldc_w 941
    //   63: invokevirtual 282	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokestatic 939	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   69: istore_1
    //   70: aload 6
    //   72: ldc_w 943
    //   75: invokevirtual 282	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: invokestatic 939	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: istore 5
    //   83: iload 5
    //   85: istore 4
    //   87: aload 6
    //   89: ifnull +114 -> 203
    //   92: iload_2
    //   93: ifne +110 -> 203
    //   96: iload_1
    //   97: ifne +106 -> 203
    //   100: iload 4
    //   102: ifne +101 -> 203
    //   105: ldc 18
    //   107: aload 7
    //   109: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: ifeq +129 -> 241
    //   115: aload_0
    //   116: getfield 945	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo	Lcom/tencent/mobileqq/data/ChatBackgroundInfo;
    //   119: ifnull +66 -> 185
    //   122: new 151	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   129: getstatic 207	com/tencent/mobileqq/app/AppConstants:bb	Ljava/lang/String;
    //   132: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: getfield 945	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo	Lcom/tencent/mobileqq/data/ChatBackgroundInfo;
    //   139: getfield 297	com/tencent/mobileqq/data/ChatBackgroundInfo:id	Ljava/lang/String;
    //   142: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 947
    //   148: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore_3
    //   155: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   158: invokestatic 950	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   161: ifne +58 -> 219
    //   164: aload_0
    //   165: getfield 476	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   168: aload_0
    //   169: invokevirtual 953	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:getBaseContext	()Landroid/content/Context;
    //   172: ldc_w 954
    //   175: invokevirtual 955	android/content/Context:getString	(I)Ljava/lang/String;
    //   178: iconst_0
    //   179: invokestatic 961	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   182: invokevirtual 964	android/widget/Toast:show	()V
    //   185: aload_0
    //   186: getfield 397	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   189: bipush 38
    //   191: invokevirtual 804	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   194: checkcast 820	com/tencent/mobileqq/app/UniPayHandler
    //   197: ldc_w 590
    //   200: invokevirtual 827	com/tencent/mobileqq/app/UniPayHandler:a	(Ljava/lang/String;)V
    //   203: return
    //   204: astore_3
    //   205: iconst_m1
    //   206: istore_2
    //   207: aconst_null
    //   208: astore 6
    //   210: iconst_m1
    //   211: istore_1
    //   212: aload_3
    //   213: invokevirtual 430	org/json/JSONException:printStackTrace	()V
    //   216: goto -129 -> 87
    //   219: aload_0
    //   220: getfield 397	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: invokevirtual 522	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   226: aload_0
    //   227: getfield 945	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo	Lcom/tencent/mobileqq/data/ChatBackgroundInfo;
    //   230: getfield 302	com/tencent/mobileqq/data/ChatBackgroundInfo:url	Ljava/lang/String;
    //   233: aload_3
    //   234: invokevirtual 967	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   237: pop
    //   238: goto -53 -> 185
    //   241: ldc 21
    //   243: aload 7
    //   245: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq -63 -> 185
    //   251: aload_0
    //   252: getfield 969	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_b_of_type_ComTencentMobileqqDataChatBackgroundInfo	Lcom/tencent/mobileqq/data/ChatBackgroundInfo;
    //   255: ifnull -70 -> 185
    //   258: aload_0
    //   259: getfield 754	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:d	Ljava/lang/String;
    //   262: astore 6
    //   264: ldc_w 590
    //   267: astore_3
    //   268: new 151	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   275: getstatic 207	com/tencent/mobileqq/app/AppConstants:bb	Ljava/lang/String;
    //   278: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: getfield 969	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_b_of_type_ComTencentMobileqqDataChatBackgroundInfo	Lcom/tencent/mobileqq/data/ChatBackgroundInfo;
    //   285: getfield 297	com/tencent/mobileqq/data/ChatBackgroundInfo:id	Ljava/lang/String;
    //   288: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 947
    //   294: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore 7
    //   302: new 190	java/io/File
    //   305: dup
    //   306: aload 7
    //   308: invokespecial 242	java/io/File:<init>	(Ljava/lang/String;)V
    //   311: invokevirtual 556	java/io/File:exists	()Z
    //   314: ifeq +70 -> 384
    //   317: aload_0
    //   318: invokevirtual 778	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:c	()V
    //   321: aload_0
    //   322: aload 7
    //   324: putfield 754	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:d	Ljava/lang/String;
    //   327: aload_0
    //   328: getfield 754	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:d	Ljava/lang/String;
    //   331: astore_3
    //   332: aload_0
    //   333: getfield 971	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   336: ldc_w 536
    //   339: invokevirtual 537	android/view/View:findViewById	(I)Landroid/view/View;
    //   342: bipush 8
    //   344: invokevirtual 538	android/view/View:setVisibility	(I)V
    //   347: aload_0
    //   348: getfield 971	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   351: ldc_w 539
    //   354: invokevirtual 537	android/view/View:findViewById	(I)Landroid/view/View;
    //   357: bipush 8
    //   359: invokevirtual 538	android/view/View:setVisibility	(I)V
    //   362: aload_0
    //   363: getfield 971	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   366: ldc_w 767
    //   369: invokevirtual 537	android/view/View:findViewById	(I)Landroid/view/View;
    //   372: iconst_0
    //   373: invokevirtual 538	android/view/View:setVisibility	(I)V
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 973	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:k	I
    //   381: putfield 94	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_b_of_type_Int	I
    //   384: aload 6
    //   386: aload_3
    //   387: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifne +42 -> 432
    //   393: aload_0
    //   394: getfield 468	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   397: ifnull +16 -> 413
    //   400: aload_0
    //   401: getfield 468	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   404: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   407: invokevirtual 178	java/lang/String:length	()I
    //   410: ifne +14 -> 424
    //   413: aload_0
    //   414: aload_0
    //   415: getfield 397	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   418: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   421: invokestatic 975	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   424: aload_0
    //   425: invokevirtual 837	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:d	()V
    //   428: aload_0
    //   429: invokespecial 343	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:h	()V
    //   432: aload_0
    //   433: getfield 397	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   436: ldc_w 588
    //   439: ldc_w 590
    //   442: ldc_w 590
    //   445: ldc_w 679
    //   448: ldc_w 848
    //   451: iconst_0
    //   452: iconst_0
    //   453: aload_0
    //   454: getfield 969	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity:jdField_b_of_type_ComTencentMobileqqDataChatBackgroundInfo	Lcom/tencent/mobileqq/data/ChatBackgroundInfo;
    //   457: getfield 297	com/tencent/mobileqq/data/ChatBackgroundInfo:id	Ljava/lang/String;
    //   460: ldc_w 590
    //   463: ldc_w 590
    //   466: ldc_w 590
    //   469: invokestatic 597	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   472: goto -287 -> 185
    //   475: astore_3
    //   476: iconst_m1
    //   477: istore_1
    //   478: iconst_m1
    //   479: istore_2
    //   480: goto -268 -> 212
    //   483: astore_3
    //   484: iconst_m1
    //   485: istore_1
    //   486: goto -274 -> 212
    //   489: astore_3
    //   490: goto -278 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	ChatBackgroundSettingActivity
    //   0	493	1	paramInt1	int
    //   0	493	2	paramInt2	int
    //   0	493	3	paramIntent	Intent
    //   1	100	4	i1	int
    //   81	3	5	i2	int
    //   44	341	6	localObject	Object
    //   26	297	7	str	String
    // Exception table:
    //   from	to	target	type
    //   36	46	204	org/json/JSONException
    //   46	58	475	org/json/JSONException
    //   58	70	483	org/json/JSONException
    //   70	83	489	org/json/JSONException
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  public void onPostThemeChanged()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatBackgroundSettingActivity
 * JD-Core Version:    0.7.0.1
 */