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
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import dwz;
import dxa;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class ReportLog
  extends CrashHandler
{
  static final int jdField_a_of_type_Int = 10000001;
  public static ProgressDialog a;
  private static Handler jdField_a_of_type_AndroidOsHandler = new dwz(Looper.getMainLooper());
  private static IHttpCommunicatorListener jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener = new dxa();
  public static final String a = "/Tencent/QQLite/log/";
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
  
  static
  {
    jdField_a_of_type_ArrayOfByte = "9u23fh$jkf^%43hj".getBytes();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_ArrayOfByte = null;
    j = "0";
    c = "/Tencent/QQLite/log/";
  }
  
  public ReportLog()
  {
    if (jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    ReportLogHelper.a(paramActivity, paramString, jdField_a_of_type_AndroidOsHandler);
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
      c = ReportLogHelper.a(paramContext, "/Tencent/QQLite/log/") + "/";
      ReportLogHelper.b = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      ReportLogHelper.c = Build.MODEL;
      ReportLogHelper.d = Build.VERSION.RELEASE;
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
    //   3: getstatic 167	com/tencent/common/config/AppSetting:a	I
    //   6: ldc 169
    //   8: ldc 171
    //   10: invokestatic 177	com/tencent/qphone/base/util/QLog:doReportLogSelf	(ILjava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_2
    //   19: putstatic 179	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   22: new 109	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   29: aload_1
    //   30: ldc 13
    //   32: invokestatic 113	com/tencent/mobileqq/log/ReportLogHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 119
    //   40: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: putstatic 63	com/tencent/mobileqq/log/ReportLog:c	Ljava/lang/String;
    //   49: new 181	java/io/File
    //   52: dup
    //   53: new 109	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   60: getstatic 63	com/tencent/mobileqq/log/ReportLog:c	Ljava/lang/String;
    //   63: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 21
    //   68: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 8
    //   79: aload 8
    //   81: invokevirtual 188	java/io/File:exists	()Z
    //   84: ifeq -67 -> 17
    //   87: aconst_null
    //   88: ldc 190
    //   90: iconst_1
    //   91: invokestatic 193	com/tencent/mobileqq/log/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   94: iconst_1
    //   95: putstatic 55	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   98: aload 8
    //   100: invokevirtual 197	java/io/File:length	()J
    //   103: lstore 4
    //   105: lload 4
    //   107: l2i
    //   108: newarray byte
    //   110: astore 7
    //   112: new 199	java/io/BufferedInputStream
    //   115: dup
    //   116: new 201	java/io/FileInputStream
    //   119: dup
    //   120: aload 8
    //   122: invokespecial 204	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: invokespecial 207	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   140: invokevirtual 211	java/io/BufferedInputStream:read	([BII)I
    //   143: i2l
    //   144: lload 4
    //   146: lcmp
    //   147: ifeq +41 -> 188
    //   150: aload_2
    //   151: astore_1
    //   152: new 161	java/lang/Exception
    //   155: dup
    //   156: ldc 213
    //   158: invokespecial 214	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_1
    //   163: aload_2
    //   164: astore_0
    //   165: aload_1
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: aload_2
    //   170: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   173: aload_0
    //   174: ifnull -157 -> 17
    //   177: aload_0
    //   178: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   181: return
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: aload_2
    //   189: astore_1
    //   190: aload_2
    //   191: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   194: aload 8
    //   196: invokevirtual 224	java/io/File:delete	()Z
    //   199: pop
    //   200: getstatic 57	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   203: ifnonnull +11 -> 214
    //   206: ldc 226
    //   208: invokevirtual 51	java/lang/String:getBytes	()[B
    //   211: putstatic 57	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   214: getstatic 61	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   217: ifnonnull +8 -> 225
    //   220: ldc 59
    //   222: putstatic 61	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   225: new 228	KQQ/UploadInfo
    //   228: dup
    //   229: invokespecial 229	KQQ/UploadInfo:<init>	()V
    //   232: astore_1
    //   233: aload_1
    //   234: getstatic 167	com/tencent/common/config/AppSetting:a	I
    //   237: i2l
    //   238: putfield 233	KQQ/UploadInfo:lAppID	J
    //   241: aload_1
    //   242: getstatic 61	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   245: invokestatic 239	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   248: putfield 242	KQQ/UploadInfo:lFromMID	J
    //   251: aload_1
    //   252: lconst_0
    //   253: putfield 245	KQQ/UploadInfo:lToMID	J
    //   256: aload_1
    //   257: iconst_1
    //   258: putfield 249	KQQ/UploadInfo:shType	S
    //   261: aload_1
    //   262: getstatic 57	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   265: putfield 252	KQQ/UploadInfo:vSignature	[B
    //   268: aload_1
    //   269: invokevirtual 255	KQQ/UploadInfo:toByteArray	()[B
    //   272: astore_1
    //   273: new 257	com/tencent/qphone/base/util/Cryptor
    //   276: dup
    //   277: invokespecial 258	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   280: aload_1
    //   281: getstatic 53	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ArrayOfByte	[B
    //   284: invokevirtual 262	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   287: astore_1
    //   288: new 264	KQQ/HttpUploadReq
    //   291: dup
    //   292: invokespecial 265	KQQ/HttpUploadReq:<init>	()V
    //   295: astore_2
    //   296: aload_2
    //   297: aload_1
    //   298: putfield 268	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   301: aload_2
    //   302: aload 7
    //   304: putfield 271	KQQ/HttpUploadReq:vFileData	[B
    //   307: new 273	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   310: dup
    //   311: getstatic 87	com/tencent/mobileqq/log/ReportLog:g	Ljava/lang/String;
    //   314: aload_2
    //   315: invokevirtual 274	KQQ/HttpUploadReq:toByteArray	()[B
    //   318: getstatic 83	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener	Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   321: invokespecial 277	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;)V
    //   324: astore_1
    //   325: aload_1
    //   326: ldc_w 279
    //   329: invokevirtual 281	com/tencent/mobileqq/utils/httputils/HttpMsg:c	(Ljava/lang/String;)V
    //   332: aload_0
    //   333: aload_1
    //   334: invokevirtual 286	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   337: pop
    //   338: iconst_0
    //   339: putstatic 55	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   342: iconst_0
    //   343: ifeq -326 -> 17
    //   346: new 288	java/lang/NullPointerException
    //   349: dup
    //   350: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   353: athrow
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   359: return
    //   360: astore_0
    //   361: aload 6
    //   363: astore_1
    //   364: aload_1
    //   365: ifnull +7 -> 372
    //   368: aload_1
    //   369: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   372: aload_0
    //   373: athrow
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   379: goto -7 -> 372
    //   382: astore_0
    //   383: goto -19 -> 364
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_0
    //   389: goto -222 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramHttpCommunicator	com.tencent.mobileqq.utils.httputils.HttpCommunicator
    //   0	392	1	paramContext	Context
    //   0	392	2	paramProgressDialog	ProgressDialog
    //   132	8	3	k	int
    //   103	42	4	l	long
    //   1	361	6	localObject	java.lang.Object
    //   110	193	7	arrayOfByte	byte[]
    //   77	118	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   135	150	162	java/lang/Exception
    //   152	162	162	java/lang/Exception
    //   190	194	162	java/lang/Exception
    //   177	181	182	java/io/IOException
    //   346	354	354	java/io/IOException
    //   94	129	360	finally
    //   194	214	360	finally
    //   214	225	360	finally
    //   225	342	360	finally
    //   368	372	374	java/io/IOException
    //   135	150	382	finally
    //   152	162	382	finally
    //   169	173	382	finally
    //   190	194	382	finally
    //   94	129	386	java/lang/Exception
    //   194	214	386	java/lang/Exception
    //   214	225	386	java/lang/Exception
    //   225	342	386	java/lang/Exception
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
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ReportLogHelper.a(paramString1, paramString2, paramBoolean);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    if ((paramThrowable instanceof OutOfMemoryError)) {
      a(BaseActivity.sTopActivity, "uncaughtException");
    }
    MobileQQ localMobileQQ = (MobileQQ)BaseApplication.getContext();
    try
    {
      ReportLogHelper.b = localMobileQQ.getPackageManager().getPackageInfo(localMobileQQ.getPackageName(), 0).versionName;
      ReportLogHelper.c = Build.MODEL;
      ReportLogHelper.d = Build.VERSION.RELEASE;
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
      paramThrowable = BaseActivity.sTopActivity;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLog
 * JD-Core Version:    0.7.0.1
 */