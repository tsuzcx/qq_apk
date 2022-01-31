package com.tencent.mobileqq.activity;

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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import cam;
import cao;
import cap;
import caq;
import car;
import cas;
import cat;
import cau;
import cav;
import cax;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import protocol.KQQConfig.GetResourceReqInfo;

public class ChatBackgroundSettingActivity
  extends IphoneTitleBarActivity
{
  public static Handler a;
  public static final String a = "__other_thumb";
  public static int c = 0;
  public static String c;
  static final int jdField_d_of_type_Int = 1;
  private static final String jdField_d_of_type_JavaLangString;
  public float a;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  public Activity a;
  private Uri jdField_a_of_type_AndroidNetUri;
  public View a;
  public cav a;
  private ConfigHandler jdField_a_of_type_ComTencentMobileqqAppConfigHandler;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new cam(this);
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new cat(this);
  public MyGridView a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private View b;
  public String b;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int f;
  
  static
  {
    d = ChatBackgroundSettingActivity.class.getSimpleName();
    jdField_a_of_type_AndroidOsHandler = new cax(BaseApplication.getContext().getMainLooper());
    jdField_c_of_type_Int = 0;
  }
  
  public ChatBackgroundSettingActivity()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQi", 0).getInt(a(paramString), 0);
  }
  
  public static String a(Context paramContext, List paramList, String paramString)
  {
    int i = 0;
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).getString("chat_uniform_bg", "null");
    if ((paramContext == null) || (paramContext.trim().length() == 0) || (paramContext.equals("null"))) {
      return "default_bg";
    }
    if (paramContext.equals("none")) {
      return "gray_bg";
    }
    int j = paramContext.lastIndexOf(File.separatorChar);
    if ((j >= 0) && (j < paramContext.length() - 1))
    {
      paramString = paramContext.substring(0, j + 1);
      if (AppConstants.aW.equals(paramString))
      {
        if ((paramList == null) || (paramList.size() == 0)) {
          return "other_bg";
        }
        paramContext = paramContext.substring(j + 1);
        j = paramContext.lastIndexOf('.');
        if (j < 0) {
          break label305;
        }
        paramContext = paramContext.substring(0, j);
      }
    }
    label305:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "picName is:" + paramContext);
      }
      j = paramList.size();
      while (i < j)
      {
        paramString = (ChatBackgroundSettingActivity.PicInfo)paramList.get(i);
        if ((paramString.jdField_b_of_type_JavaLangString != null) && (paramString.jdField_b_of_type_JavaLangString.equals(paramContext))) {
          return "offical_bg_" + String.valueOf(i + 2);
        }
        i += 1;
      }
      return "other_bg";
      return "other_bg";
      throw new IllegalStateException("picPath is illegal,picPath is:" + paramContext);
    }
  }
  
  static String a(String paramString)
  {
    return "chat_background_switch_times_" + paramString;
  }
  
  /* Error */
  public static List a()
  {
    // Byte code:
    //   0: invokestatic 220	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   3: astore 5
    //   5: new 79	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 80	java/util/ArrayList:<init>	()V
    //   12: astore 4
    //   14: new 222	java/io/FileInputStream
    //   17: dup
    //   18: getstatic 225	com/tencent/mobileqq/app/AppConstants:aU	Ljava/lang/String;
    //   21: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload 5
    //   27: aload_2
    //   28: ldc 228
    //   30: invokeinterface 234 3 0
    //   35: aload 5
    //   37: invokeinterface 237 1 0
    //   42: istore_0
    //   43: aconst_null
    //   44: astore_3
    //   45: goto +265 -> 310
    //   48: aload 5
    //   50: invokeinterface 240 1 0
    //   55: istore_0
    //   56: aload_1
    //   57: astore_3
    //   58: goto +252 -> 310
    //   61: aload 5
    //   63: invokeinterface 243 1 0
    //   68: astore 6
    //   70: aload_3
    //   71: astore_1
    //   72: ldc 245
    //   74: aload 6
    //   76: invokevirtual 249	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   79: ifne -31 -> 48
    //   82: ldc 251
    //   84: aload 6
    //   86: invokevirtual 249	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   89: ifeq +27 -> 116
    //   92: new 189	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity$PicInfo
    //   95: dup
    //   96: invokespecial 252	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity$PicInfo:<init>	()V
    //   99: astore_1
    //   100: goto -52 -> 48
    //   103: astore_1
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 257	java/io/InputStream:close	()V
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: areturn
    //   116: ldc_w 259
    //   119: aload 6
    //   121: invokevirtual 249	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   124: ifeq +57 -> 181
    //   127: aload_3
    //   128: astore_1
    //   129: aload_3
    //   130: ifnull -82 -> 48
    //   133: aload_3
    //   134: aload 5
    //   136: aconst_null
    //   137: ldc_w 261
    //   140: invokeinterface 264 3 0
    //   145: invokevirtual 129	java/lang/String:trim	()Ljava/lang/String;
    //   148: putfield 266	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity$PicInfo:a	Ljava/lang/String;
    //   151: aload_3
    //   152: aload 5
    //   154: invokeinterface 269 1 0
    //   159: invokevirtual 129	java/lang/String:trim	()Ljava/lang/String;
    //   162: putfield 270	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity$PicInfo:d	Ljava/lang/String;
    //   165: aload_3
    //   166: astore_1
    //   167: goto -119 -> 48
    //   170: astore_1
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 257	java/io/InputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: aload_3
    //   182: astore_1
    //   183: ldc_w 272
    //   186: aload 6
    //   188: invokevirtual 249	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   191: ifeq -143 -> 48
    //   194: aload_3
    //   195: astore_1
    //   196: aload_3
    //   197: ifnull -149 -> 48
    //   200: aload_3
    //   201: aload 5
    //   203: aconst_null
    //   204: ldc_w 261
    //   207: invokeinterface 264 3 0
    //   212: invokevirtual 129	java/lang/String:trim	()Ljava/lang/String;
    //   215: putfield 191	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity$PicInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   218: aload_3
    //   219: aload 5
    //   221: invokeinterface 269 1 0
    //   226: invokevirtual 129	java/lang/String:trim	()Ljava/lang/String;
    //   229: putfield 274	com/tencent/mobileqq/activity/ChatBackgroundSettingActivity$PicInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   232: aload_3
    //   233: astore_1
    //   234: goto -186 -> 48
    //   237: aload_3
    //   238: astore_1
    //   239: ldc 251
    //   241: aload 5
    //   243: invokeinterface 243 1 0
    //   248: invokevirtual 249	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   251: ifeq -203 -> 48
    //   254: aload_3
    //   255: astore_1
    //   256: aload_3
    //   257: ifnull -209 -> 48
    //   260: aload 4
    //   262: aload_3
    //   263: invokevirtual 277	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   266: pop
    //   267: aconst_null
    //   268: astore_1
    //   269: goto -221 -> 48
    //   272: aload 4
    //   274: astore_1
    //   275: aload_2
    //   276: ifnull -162 -> 114
    //   279: aload_2
    //   280: invokevirtual 257	java/io/InputStream:close	()V
    //   283: aload 4
    //   285: areturn
    //   286: astore_1
    //   287: aload 4
    //   289: areturn
    //   290: astore_1
    //   291: goto -179 -> 112
    //   294: astore_2
    //   295: goto -116 -> 179
    //   298: astore_1
    //   299: aconst_null
    //   300: astore_2
    //   301: goto -130 -> 171
    //   304: astore_1
    //   305: aconst_null
    //   306: astore_2
    //   307: goto -203 -> 104
    //   310: iload_0
    //   311: iconst_1
    //   312: if_icmpeq -40 -> 272
    //   315: aload_3
    //   316: astore_1
    //   317: iload_0
    //   318: tableswitch	default:+30 -> 348, 0:+-270->48, 1:+-270->48, 2:+-257->61, 3:+-81->237
    //   349: astore_1
    //   350: goto -302 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	276	0	i	int
    //   56	44	1	localObject1	Object
    //   103	1	1	localException1	java.lang.Exception
    //   113	54	1	localObject2	Object
    //   170	10	1	localObject3	Object
    //   182	93	1	localObject4	Object
    //   286	1	1	localIOException1	java.io.IOException
    //   290	1	1	localIOException2	java.io.IOException
    //   298	1	1	localObject5	Object
    //   304	1	1	localException2	java.lang.Exception
    //   316	34	1	localObject6	Object
    //   24	256	2	localFileInputStream	java.io.FileInputStream
    //   294	1	2	localIOException3	java.io.IOException
    //   300	7	2	localObject7	Object
    //   44	305	3	localObject8	Object
    //   12	276	4	localArrayList	ArrayList
    //   3	239	5	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   68	119	6	str	String
    // Exception table:
    //   from	to	target	type
    //   25	43	103	java/lang/Exception
    //   48	56	103	java/lang/Exception
    //   61	70	103	java/lang/Exception
    //   72	100	103	java/lang/Exception
    //   116	127	103	java/lang/Exception
    //   133	165	103	java/lang/Exception
    //   183	194	103	java/lang/Exception
    //   200	232	103	java/lang/Exception
    //   239	254	103	java/lang/Exception
    //   260	267	103	java/lang/Exception
    //   25	43	170	finally
    //   48	56	170	finally
    //   61	70	170	finally
    //   72	100	170	finally
    //   116	127	170	finally
    //   133	165	170	finally
    //   183	194	170	finally
    //   200	232	170	finally
    //   239	254	170	finally
    //   260	267	170	finally
    //   279	283	286	java/io/IOException
    //   108	112	290	java/io/IOException
    //   175	179	294	java/io/IOException
    //   14	25	298	finally
    //   14	25	304	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQi", 0);
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e(d, 2, "uin is empty,not save switch bg times");
      }
    }
    int i;
    do
    {
      return;
      paramString = a(paramString);
      i = paramContext.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "oldCount is:" + i);
      }
      paramContext = paramContext.edit();
      i += 1;
      paramContext.putInt(paramString, i);
      paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.d(d, 2, "save count is:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    jdField_c_of_type_JavaLangString = null;
    paramQQAppInterface.a(new cau(paramString, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(jdField_c_of_type_JavaLangString, Integer.valueOf(1));
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + jdField_c_of_type_JavaLangString);
    }
    paramStatisticCollector.b(paramQQAppInterface, paramString, localHashMap);
  }
  
  public static String b(Context paramContext, List paramList, String paramString)
  {
    int i = 0;
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).getString("chat_uniform_bg", "null");
    if ((paramContext == null) || (paramContext.trim().length() == 0) || (paramContext.equals("null"))) {
      return "null";
    }
    if (paramContext.equals("none")) {
      return "none";
    }
    int j = paramContext.lastIndexOf(File.separatorChar);
    paramString = paramContext.substring(0, j + 1);
    if (AppConstants.aW.equals(paramString))
    {
      if ((paramList == null) || (paramList.size() == 0)) {
        return "__other_thumb";
      }
      paramContext = paramContext.substring(j + 1);
      j = paramContext.lastIndexOf('.');
      if (j < 0) {
        break label242;
      }
      paramContext = paramContext.substring(0, j);
    }
    label242:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "picName is:" + paramContext);
      }
      j = paramList.size();
      while (i < j)
      {
        paramString = (ChatBackgroundSettingActivity.PicInfo)paramList.get(i);
        if ((paramString.jdField_b_of_type_JavaLangString != null) && (paramString.jdField_b_of_type_JavaLangString.equals(paramContext))) {
          return paramString.a;
        }
        i += 1;
      }
      return "__other_thumb";
      return "__other_thumb";
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQi", 0);
    paramString = a(paramString);
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, 0);
    paramContext.commit();
  }
  
  private String d()
  {
    Display localDisplay = getWindowManager().getDefaultDisplay();
    int i = localDisplay.getHeight();
    int j = localDisplay.getWidth();
    if (((j >= 480) && (i >= 800)) || ((j >= 800) && (i >= 480))) {
      return "QQCHATPic_hdpi_720";
    }
    return "QQCHATPic_ldpi_240";
  }
  
  public static void f()
  {
    jdField_c_of_type_JavaLangString = null;
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "ChatBackgroundSettingActivity destroy() is called");
    }
  }
  
  private void g()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      String str = ChatActivityUtils.b(localBundle.getInt("uintype", 999));
      int i = localBundle.getInt("bg_replace_entrance", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " uin_type : " + str + " entrance_type ： " + i);
      }
      if (i != 999) {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "background", "bkground_replace", i, 0, str, "", "", "");
      }
    }
  }
  
  public void a()
  {
    List localList = null;
    SharedPreferences localSharedPreferences = getSharedPreferences("chat_background_path_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("chat_uniform_bg", "null");
    }
    for (;;)
    {
      if (new File(AppConstants.aU).exists()) {
        localList = a();
      }
      if (localList != null) {
        this.jdField_a_of_type_Long = getSharedPreferences("chat_background_version", 0).getLong("chat_background_version", 0L);
      }
      runOnUiThread(new cas(this, localList));
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(new GetResourceReqInfo[] { this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(d(), this.jdField_a_of_type_Long) });
      return;
      this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString(this.jdField_e_of_type_JavaLangString, null);
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("chat_uniform_bg", "null");
      }
    }
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i).findViewById(2131231327).setVisibility(8);
      i += 1;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131231327).setVisibility(8);
  }
  
  protected boolean b()
  {
    setResult(0);
    finish();
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int i = 0;
    label10:
    Object localObject;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (ChatBackgroundSettingActivity.PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localObject != null) {
        break label44;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label44:
      String str = AppConstants.aV + ((ChatBackgroundSettingActivity.PicInfo)localObject).a + ".png";
      if ((!new File(str).exists()) && (localObject != null))
      {
        localObject = ((ChatBackgroundSettingActivity.PicInfo)localObject).d;
        this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a((String)localObject, str);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramInt1 == 16)) {}
    while (paramInt1 != 200) {
      return;
    }
    b();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    e();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c(2130903103);
    setTitle(getString(2131561696));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231213);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("uin");
    ((TextView)findViewById(2131231216)).requestFocus();
    this.jdField_a_of_type_AndroidAppActivity = this;
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new cao(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)findViewById(2131231217));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setTranscriptMode(0);
    this.jdField_a_of_type_Cav = new cav(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Cav);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setOnItemClickListener(new cap(this));
    this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler = ((ConfigHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(4));
    a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { HttpDownloadFileProcessor.class });
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)findViewById(2131231215)).getChildAt(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131231328).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131231329).setVisibility(8);
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231326)).setImageResource(2130840058);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new caq(this));
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
        this.jdField_b_of_type_JavaLangString = paramIntent;
        v_();
        QQToast.a(this, 2131562538, 0).a();
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
    car localcar = new car(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(localcar);
  }
  
  public void e()
  {
    if (getResources().getConfiguration().orientation == 2) {}
    View localView1;
    for (this.f = 5;; this.f = 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(this.f);
      this.jdField_e_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      int i = (int)(this.jdField_a_of_type_Float * 8.0F);
      this.jdField_a_of_type_Int = ((int)((this.jdField_e_of_type_Int - (this.f + 1) * i) / this.f));
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(2);
      int j = (int)Math.ceil((this.jdField_a_of_type_JavaUtilArrayList.size() + 1) / this.f);
      int k = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getLayoutParams().height = ((i + k) * j);
      localView1 = this.jdField_a_of_type_AndroidViewView;
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_Int;
      localLayoutParams.height = this.jdField_a_of_type_Int;
      localView1.setLayoutParams(localLayoutParams);
      View localView2 = localView1.findViewById(2131231329);
      i = (localLayoutParams.height - (int)(this.jdField_a_of_type_Float * 8.0F)) * 31 / 132;
      localView2.setPadding((int)(this.jdField_a_of_type_Float * 4.0F), localLayoutParams.height - i - (int)(this.jdField_a_of_type_Float * 4.0F), (int)(this.jdField_a_of_type_Float * 4.0F), (int)(this.jdField_a_of_type_Float * 4.0F));
      if (SkinEngine.getInstances().getSkinRootPath() != null)
      {
        findViewById(2131231214).setVisibility(0);
        findViewById(2131231215).setVisibility(0);
        localView1 = localView1.findViewById(2131231327);
        if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() != 0) && (!"null".equals(this.jdField_b_of_type_JavaLangString))) {
          break;
        }
        localView1.setVisibility(0);
      }
      return;
    }
    localView1.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void onPostThemeChanged()
  {
    e();
  }
  
  public void v_()
  {
    ChatBackground.b(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatBackgroundSettingActivity
 * JD-Core Version:    0.7.0.1
 */