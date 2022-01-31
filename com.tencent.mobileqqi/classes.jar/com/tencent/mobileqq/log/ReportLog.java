package com.tencent.mobileqq.log;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import gen;
import geo;
import gep;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class ReportLog
  extends CrashHandler
{
  static final int jdField_a_of_type_Int = 10000001;
  public static ProgressDialog a;
  private static Handler jdField_a_of_type_AndroidOsHandler = new gen(Looper.getMainLooper());
  private static IHttpCommunicatorListener jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener = new geo();
  public static final String a = "/Tencent/MobileQQ/log/";
  private static Thread.UncaughtExceptionHandler jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler;
  public static boolean a = false;
  private static final byte[] jdField_a_of_type_ArrayOfByte;
  static final int jdField_b_of_type_Int = 10000002;
  public static final String b = "log.txt";
  private static boolean jdField_b_of_type_Boolean = false;
  private static byte[] jdField_b_of_type_ArrayOfByte;
  public static String c;
  public static final String d = "Network";
  public static final String e = "Video";
  public static final String f = "LBS";
  public static String g = "http://bugtrace.3g.qq.com/upload/1/0";
  private static final String h = "ReportLog";
  private static final String i = "dump.hprof";
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = "9u23fh$jkf^%43hj".getBytes();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_ArrayOfByte = null;
    j = "0";
    k = "";
    l = "";
    m = "";
    c = "/Tencent/MobileQQ/log/";
  }
  
  public ReportLog()
  {
    if (jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      paramContext = new File(Environment.getExternalStorageDirectory().getPath() + paramString);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    jdField_a_of_type_AndroidOsHandler.post(new gep(paramActivity, paramString));
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (jdField_b_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      jdField_b_of_type_Boolean = paramBoolean;
    } while (!paramBoolean);
    try
    {
      c = a(paramContext, "/Tencent/MobileQQ/log/") + "/";
      k = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      l = Build.MODEL;
      m = Build.VERSION.RELEASE;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.utils.httputils.HttpCommunicator paramHttpCommunicator, Context paramContext, ProgressDialog paramProgressDialog)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: getstatic 217	com/tencent/common/config/AppSetting:a	I
    //   6: ldc 219
    //   8: ldc 66
    //   10: invokestatic 225	com/tencent/qphone/base/util/QLog:doReportLogSelf	(ILjava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_2
    //   19: putstatic 227	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   22: new 134	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   29: aload_1
    //   30: ldc 13
    //   32: invokestatic 178	com/tencent/mobileqq/log/ReportLog:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 180
    //   40: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: putstatic 74	com/tencent/mobileqq/log/ReportLog:c	Ljava/lang/String;
    //   49: new 128	java/io/File
    //   52: dup
    //   53: new 134	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   60: getstatic 74	com/tencent/mobileqq/log/ReportLog:c	Ljava/lang/String;
    //   63: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 21
    //   68: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 8
    //   79: aload 8
    //   81: invokevirtual 151	java/io/File:exists	()Z
    //   84: ifeq -67 -> 17
    //   87: aconst_null
    //   88: ldc 229
    //   90: iconst_1
    //   91: invokestatic 232	com/tencent/mobileqq/log/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   94: iconst_1
    //   95: putstatic 58	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   98: aload 8
    //   100: invokevirtual 236	java/io/File:length	()J
    //   103: lstore 4
    //   105: lload 4
    //   107: l2i
    //   108: newarray byte
    //   110: astore 7
    //   112: new 238	java/io/BufferedInputStream
    //   115: dup
    //   116: new 240	java/io/FileInputStream
    //   119: dup
    //   120: aload 8
    //   122: invokespecial 243	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: invokespecial 246	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore_2
    //   129: lload 4
    //   131: l2i
    //   132: istore_3
    //   133: aload_2
    //   134: astore_1
    //   135: aload_2
    //   136: aload 7
    //   138: iconst_0
    //   139: iload_3
    //   140: invokevirtual 250	java/io/BufferedInputStream:read	([BII)I
    //   143: i2l
    //   144: lload 4
    //   146: lcmp
    //   147: ifeq +41 -> 188
    //   150: aload_2
    //   151: astore_1
    //   152: new 211	java/lang/Exception
    //   155: dup
    //   156: ldc 252
    //   158: invokespecial 253	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_1
    //   163: aload_2
    //   164: astore_0
    //   165: aload_1
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: aload_2
    //   170: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   173: aload_0
    //   174: ifnull -157 -> 17
    //   177: aload_0
    //   178: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   181: return
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: aload_2
    //   189: astore_1
    //   190: aload_2
    //   191: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   194: aload 8
    //   196: invokevirtual 263	java/io/File:delete	()Z
    //   199: pop
    //   200: getstatic 60	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   203: ifnonnull +12 -> 215
    //   206: ldc_w 265
    //   209: invokevirtual 54	java/lang/String:getBytes	()[B
    //   212: putstatic 60	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   215: getstatic 64	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   218: ifnonnull +8 -> 226
    //   221: ldc 62
    //   223: putstatic 64	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   226: new 267	KQQ/UploadInfo
    //   229: dup
    //   230: invokespecial 268	KQQ/UploadInfo:<init>	()V
    //   233: astore_1
    //   234: aload_1
    //   235: getstatic 217	com/tencent/common/config/AppSetting:a	I
    //   238: i2l
    //   239: putfield 272	KQQ/UploadInfo:lAppID	J
    //   242: aload_1
    //   243: getstatic 64	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   246: invokestatic 278	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: putfield 281	KQQ/UploadInfo:lFromMID	J
    //   252: aload_1
    //   253: lconst_0
    //   254: putfield 284	KQQ/UploadInfo:lToMID	J
    //   257: aload_1
    //   258: iconst_1
    //   259: putfield 288	KQQ/UploadInfo:shType	S
    //   262: aload_1
    //   263: getstatic 60	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   266: putfield 291	KQQ/UploadInfo:vSignature	[B
    //   269: aload_1
    //   270: invokevirtual 294	KQQ/UploadInfo:toByteArray	()[B
    //   273: astore_1
    //   274: new 296	com/tencent/qphone/base/util/Cryptor
    //   277: dup
    //   278: invokespecial 297	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   281: aload_1
    //   282: getstatic 56	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ArrayOfByte	[B
    //   285: invokevirtual 301	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   288: astore_1
    //   289: new 303	KQQ/HttpUploadReq
    //   292: dup
    //   293: invokespecial 304	KQQ/HttpUploadReq:<init>	()V
    //   296: astore_2
    //   297: aload_2
    //   298: aload_1
    //   299: putfield 307	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   302: aload_2
    //   303: aload 7
    //   305: putfield 310	KQQ/HttpUploadReq:vFileData	[B
    //   308: new 312	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   311: dup
    //   312: getstatic 98	com/tencent/mobileqq/log/ReportLog:g	Ljava/lang/String;
    //   315: aload_2
    //   316: invokevirtual 313	KQQ/HttpUploadReq:toByteArray	()[B
    //   319: getstatic 94	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener	Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   322: invokespecial 316	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;)V
    //   325: astore_1
    //   326: aload_1
    //   327: ldc_w 318
    //   330: invokevirtual 320	com/tencent/mobileqq/utils/httputils/HttpMsg:c	(Ljava/lang/String;)V
    //   333: aload_0
    //   334: aload_1
    //   335: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   338: pop
    //   339: iconst_0
    //   340: putstatic 58	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   343: iconst_0
    //   344: ifeq -327 -> 17
    //   347: new 327	java/lang/NullPointerException
    //   350: dup
    //   351: invokespecial 328	java/lang/NullPointerException:<init>	()V
    //   354: athrow
    //   355: astore_0
    //   356: aload_0
    //   357: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   360: return
    //   361: astore_0
    //   362: aload 6
    //   364: astore_1
    //   365: aload_1
    //   366: ifnull +7 -> 373
    //   369: aload_1
    //   370: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   373: aload_0
    //   374: athrow
    //   375: astore_1
    //   376: aload_1
    //   377: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   380: goto -7 -> 373
    //   383: astore_0
    //   384: goto -19 -> 365
    //   387: astore_2
    //   388: aconst_null
    //   389: astore_0
    //   390: goto -223 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramHttpCommunicator	com.tencent.mobileqq.utils.httputils.HttpCommunicator
    //   0	393	1	paramContext	Context
    //   0	393	2	paramProgressDialog	ProgressDialog
    //   132	8	3	n	int
    //   103	42	4	l1	long
    //   1	362	6	localObject	java.lang.Object
    //   110	194	7	arrayOfByte	byte[]
    //   77	118	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   135	150	162	java/lang/Exception
    //   152	162	162	java/lang/Exception
    //   190	194	162	java/lang/Exception
    //   177	181	182	java/io/IOException
    //   347	355	355	java/io/IOException
    //   94	129	361	finally
    //   194	215	361	finally
    //   215	226	361	finally
    //   226	343	361	finally
    //   369	373	375	java/io/IOException
    //   135	150	383	finally
    //   152	162	383	finally
    //   169	173	383	finally
    //   190	194	383	finally
    //   94	129	387	java/lang/Exception
    //   194	215	387	java/lang/Exception
    //   215	226	387	java/lang/Exception
    //   226	343	387	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    j = paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!jdField_b_of_type_Boolean) {}
    while (jdField_a_of_type_Boolean) {
      return;
    }
    a(paramString1, paramString2, true);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 128	java/io/File
    //   6: dup
    //   7: getstatic 334	com/tencent/mobileqq/app/AppConstants:ao	Ljava/lang/String;
    //   10: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 151	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 154	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 336	java/io/FileWriter
    //   29: dup
    //   30: new 128	java/io/File
    //   33: dup
    //   34: new 134	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   41: getstatic 334	com/tencent/mobileqq/app/AppConstants:ao	Ljava/lang/String;
    //   44: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 21
    //   49: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: iconst_1
    //   59: invokespecial 339	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   62: astore_3
    //   63: aload_3
    //   64: new 134	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 341
    //   74: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 68	com/tencent/mobileqq/log/ReportLog:k	Ljava/lang/String;
    //   80: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 343
    //   86: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: getstatic 70	com/tencent/mobileqq/log/ReportLog:l	Ljava/lang/String;
    //   92: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 345
    //   98: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 72	com/tencent/mobileqq/log/ReportLog:m	Ljava/lang/String;
    //   104: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 347
    //   110: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 349
    //   116: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   125: aload_3
    //   126: ldc_w 354
    //   129: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   132: new 356	android/text/format/Time
    //   135: dup
    //   136: invokespecial 357	android/text/format/Time:<init>	()V
    //   139: astore 4
    //   141: aload 4
    //   143: invokevirtual 360	android/text/format/Time:setToNow	()V
    //   146: aload_3
    //   147: new 134	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   154: aload 4
    //   156: ldc_w 362
    //   159: invokevirtual 366	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   162: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 368
    //   168: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   177: aload_3
    //   178: ldc_w 370
    //   181: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   184: aload_3
    //   185: ldc_w 354
    //   188: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: ifnull +33 -> 225
    //   195: aload_3
    //   196: new 134	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 372
    //   206: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 374
    //   216: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   225: aload_3
    //   226: aload_1
    //   227: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   230: aload_3
    //   231: ldc_w 354
    //   234: invokevirtual 352	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   237: aload_3
    //   238: invokevirtual 375	java/io/FileWriter:close	()V
    //   241: iconst_0
    //   242: ifeq +11 -> 253
    //   245: new 327	java/lang/NullPointerException
    //   248: dup
    //   249: invokespecial 328	java/lang/NullPointerException:<init>	()V
    //   252: athrow
    //   253: return
    //   254: astore_1
    //   255: aload 4
    //   257: astore_0
    //   258: aload_1
    //   259: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   262: aload_0
    //   263: ifnull -10 -> 253
    //   266: aload_0
    //   267: invokevirtual 375	java/io/FileWriter:close	()V
    //   270: return
    //   271: astore_0
    //   272: return
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_1
    //   277: ifnull +7 -> 284
    //   280: aload_1
    //   281: invokevirtual 375	java/io/FileWriter:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: return
    //   288: astore_1
    //   289: goto -5 -> 284
    //   292: astore_0
    //   293: aload_3
    //   294: astore_1
    //   295: goto -19 -> 276
    //   298: astore_3
    //   299: aload_0
    //   300: astore_1
    //   301: aload_3
    //   302: astore_0
    //   303: goto -27 -> 276
    //   306: astore_1
    //   307: aload_3
    //   308: astore_0
    //   309: goto -51 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString1	String
    //   0	312	1	paramString2	String
    //   0	312	2	paramBoolean	boolean
    //   13	281	3	localObject1	java.lang.Object
    //   298	10	3	localObject2	java.lang.Object
    //   1	255	4	localTime	android.text.format.Time
    // Exception table:
    //   from	to	target	type
    //   3	26	254	java/lang/Exception
    //   26	63	254	java/lang/Exception
    //   266	270	271	java/lang/Exception
    //   3	26	273	finally
    //   26	63	273	finally
    //   245	253	286	java/lang/Exception
    //   280	284	288	java/lang/Exception
    //   63	191	292	finally
    //   195	225	292	finally
    //   225	241	292	finally
    //   258	262	298	finally
    //   63	191	306	java/lang/Exception
    //   195	225	306	java/lang/Exception
    //   225	241	306	java/lang/Exception
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    if ((paramThrowable instanceof OutOfMemoryError)) {
      a(BaseActivity.a, "uncaughtException");
    }
    MobileQQ localMobileQQ = (MobileQQ)BaseApplication.getContext();
    try
    {
      k = localMobileQQ.getPackageManager().getPackageInfo(localMobileQQ.getPackageName(), 0).versionName;
      l = Build.MODEL;
      m = Build.VERSION.RELEASE;
      label59:
      paramThread = new ByteArrayOutputStream();
      paramThrowable.printStackTrace(new PrintStream(paramThread));
      paramThread = new StringBuilder(new String(paramThread.toByteArray()));
      if ((paramThrowable instanceof OutOfMemoryError))
      {
        System.gc();
        paramThread.append("\n");
        paramThread.append(BitmapManager.a());
        paramThread.append("\n");
      }
      a("crash", paramThread.toString(), true);
      paramThrowable = BaseActivity.a;
      paramThread = paramThrowable;
      if (paramThrowable == null) {
        paramThread = localMobileQQ;
      }
      paramThread.startActivity(new Intent(paramThread, NotificationActivity.class).addFlags(268435456).putExtra("type", 3));
      localMobileQQ.crashed();
      localMobileQQ.QQProcessExit(true);
      return;
    }
    catch (Exception paramThread)
    {
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLog
 * JD-Core Version:    0.7.0.1
 */