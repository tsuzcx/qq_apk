import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.log.ReportLog.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class aivn
  extends CrashHandler
{
  static ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private static aqoi jdField_a_of_type_Aqoi = new aivp();
  public static String bPC = "https://bugtrace.3g.qq.com/upload/1/0";
  private static boolean clV;
  private static Thread.UncaughtExceptionHandler defaultHandler;
  private static Handler handler;
  public static boolean isUploading;
  private static final byte[] k = "9u23fh$jkf^%43hj".getBytes();
  public static String path;
  private static byte[] sig;
  private static String uin = "0";
  
  static
  {
    path = "/Tencent/Tim/log/";
    handler = new aivo(Looper.getMainLooper());
  }
  
  public aivn()
  {
    if (defaultHandler == null) {
      defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void E(Context paramContext, boolean paramBoolean)
  {
    if (clV == paramBoolean) {}
    do
    {
      return;
      clV = paramBoolean;
    } while (!paramBoolean);
    try
    {
      path = aivq.A(paramContext, "/Tencent/Tim/log/") + "/";
      aivq.bPD = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      aivq.model = Build.MODEL;
      aivq.bPE = Build.VERSION.RELEASE;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.utils.httputils.HttpCommunicator paramHttpCommunicator, Context paramContext, ProgressDialog paramProgressDialog, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: invokestatic 150	com/tencent/common/config/AppSetting:getAppId	()I
    //   6: ldc 152
    //   8: ldc 154
    //   10: aload_3
    //   11: aload 4
    //   13: invokestatic 160	com/tencent/qphone/base/util/QLog:doReportLogSelf	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_2
    //   22: putstatic 162	aivn:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   25: new 83	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: ldc 39
    //   35: invokestatic 90	aivq:A	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 96
    //   43: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: putstatic 41	aivn:path	Ljava/lang/String;
    //   52: new 164	java/io/File
    //   55: dup
    //   56: new 83	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   63: getstatic 41	aivn:path	Ljava/lang/String;
    //   66: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 166
    //   71: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 169	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore 9
    //   82: aload 9
    //   84: invokevirtual 173	java/io/File:exists	()Z
    //   87: ifeq -67 -> 20
    //   90: aconst_null
    //   91: ldc 175
    //   93: iconst_1
    //   94: invokestatic 179	aivn:appendLog	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   97: iconst_1
    //   98: putstatic 181	aivn:isUploading	Z
    //   101: aload 9
    //   103: invokevirtual 185	java/io/File:length	()J
    //   106: lstore 6
    //   108: lload 6
    //   110: l2i
    //   111: newarray byte
    //   113: astore 4
    //   115: new 187	java/io/BufferedInputStream
    //   118: dup
    //   119: new 189	java/io/FileInputStream
    //   122: dup
    //   123: aload 9
    //   125: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 195	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore_2
    //   132: lload 6
    //   134: l2i
    //   135: istore 5
    //   137: aload_2
    //   138: astore_1
    //   139: aload_2
    //   140: aload 4
    //   142: iconst_0
    //   143: iload 5
    //   145: invokevirtual 199	java/io/BufferedInputStream:read	([BII)I
    //   148: i2l
    //   149: lload 6
    //   151: lcmp
    //   152: ifeq +41 -> 193
    //   155: aload_2
    //   156: astore_1
    //   157: new 142	java/lang/Exception
    //   160: dup
    //   161: ldc 201
    //   163: invokespecial 202	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: astore_1
    //   168: aload_2
    //   169: astore_0
    //   170: aload_1
    //   171: astore_2
    //   172: aload_0
    //   173: astore_1
    //   174: aload_2
    //   175: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   178: aload_0
    //   179: ifnull -159 -> 20
    //   182: aload_0
    //   183: invokevirtual 208	java/io/BufferedInputStream:close	()V
    //   186: return
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   192: return
    //   193: aload_2
    //   194: astore_1
    //   195: aload_2
    //   196: invokevirtual 208	java/io/BufferedInputStream:close	()V
    //   199: aload 9
    //   201: invokevirtual 212	java/io/File:delete	()Z
    //   204: pop
    //   205: getstatic 214	aivn:sig	[B
    //   208: ifnonnull +179 -> 387
    //   211: ldc 216
    //   213: invokevirtual 31	java/lang/String:getBytes	()[B
    //   216: putstatic 214	aivn:sig	[B
    //   219: goto +168 -> 387
    //   222: new 218	KQQ/UploadInfo
    //   225: dup
    //   226: invokespecial 219	KQQ/UploadInfo:<init>	()V
    //   229: astore_2
    //   230: aload_2
    //   231: invokestatic 150	com/tencent/common/config/AppSetting:getAppId	()I
    //   234: i2l
    //   235: putfield 223	KQQ/UploadInfo:lAppID	J
    //   238: aload_2
    //   239: aload_1
    //   240: invokestatic 229	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   243: putfield 232	KQQ/UploadInfo:lFromMID	J
    //   246: aload_2
    //   247: lconst_0
    //   248: putfield 235	KQQ/UploadInfo:lToMID	J
    //   251: aload_2
    //   252: iconst_1
    //   253: putfield 239	KQQ/UploadInfo:shType	S
    //   256: aload_2
    //   257: getstatic 214	aivn:sig	[B
    //   260: putfield 242	KQQ/UploadInfo:vSignature	[B
    //   263: aload_2
    //   264: invokevirtual 245	KQQ/UploadInfo:toByteArray	()[B
    //   267: astore_1
    //   268: new 247	com/tencent/qphone/base/util/Cryptor
    //   271: dup
    //   272: invokespecial 248	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   275: aload_1
    //   276: getstatic 33	aivn:k	[B
    //   279: invokevirtual 252	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   282: astore_1
    //   283: new 254	KQQ/HttpUploadReq
    //   286: dup
    //   287: invokespecial 255	KQQ/HttpUploadReq:<init>	()V
    //   290: astore_2
    //   291: aload_2
    //   292: aload_1
    //   293: putfield 258	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   296: aload_2
    //   297: aload 4
    //   299: putfield 261	KQQ/HttpUploadReq:vFileData	[B
    //   302: new 263	aqog
    //   305: dup
    //   306: getstatic 65	aivn:bPC	Ljava/lang/String;
    //   309: aload_2
    //   310: invokevirtual 264	KQQ/HttpUploadReq:toByteArray	()[B
    //   313: getstatic 61	aivn:jdField_a_of_type_Aqoi	Laqoi;
    //   316: invokespecial 267	aqog:<init>	(Ljava/lang/String;[BLaqoi;)V
    //   319: astore_1
    //   320: aload_1
    //   321: ldc_w 269
    //   324: invokevirtual 272	aqog:setRequestMethod	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: aload_1
    //   329: invokevirtual 277	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;)I
    //   332: pop
    //   333: iconst_0
    //   334: putstatic 181	aivn:isUploading	Z
    //   337: iconst_0
    //   338: ifeq -318 -> 20
    //   341: new 279	java/lang/NullPointerException
    //   344: dup
    //   345: invokespecial 280	java/lang/NullPointerException:<init>	()V
    //   348: athrow
    //   349: astore_0
    //   350: aload_0
    //   351: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   354: return
    //   355: astore_0
    //   356: aload 8
    //   358: astore_1
    //   359: aload_1
    //   360: ifnull +7 -> 367
    //   363: aload_1
    //   364: invokevirtual 208	java/io/BufferedInputStream:close	()V
    //   367: aload_0
    //   368: athrow
    //   369: astore_1
    //   370: aload_1
    //   371: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   374: goto -7 -> 367
    //   377: astore_0
    //   378: goto -19 -> 359
    //   381: astore_2
    //   382: aconst_null
    //   383: astore_0
    //   384: goto -212 -> 172
    //   387: aload_3
    //   388: astore_1
    //   389: aload_3
    //   390: ifnonnull -168 -> 222
    //   393: ldc 35
    //   395: astore_1
    //   396: goto -174 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramHttpCommunicator	com.tencent.mobileqq.utils.httputils.HttpCommunicator
    //   0	399	1	paramContext	Context
    //   0	399	2	paramProgressDialog	ProgressDialog
    //   0	399	3	paramString1	String
    //   0	399	4	paramString2	String
    //   135	9	5	i	int
    //   106	44	6	l	long
    //   1	356	8	localObject	Object
    //   80	120	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   139	155	167	java/lang/Exception
    //   157	167	167	java/lang/Exception
    //   195	199	167	java/lang/Exception
    //   182	186	187	java/io/IOException
    //   341	349	349	java/io/IOException
    //   97	132	355	finally
    //   199	219	355	finally
    //   222	337	355	finally
    //   363	367	369	java/io/IOException
    //   139	155	377	finally
    //   157	167	377	finally
    //   174	178	377	finally
    //   195	199	377	finally
    //   97	132	381	java/lang/Exception
    //   199	219	381	java/lang/Exception
    //   222	337	381	java/lang/Exception
  }
  
  public static void appendLog(String paramString1, String paramString2, boolean paramBoolean)
  {
    aivq.appendLog(paramString1, paramString2, paramBoolean);
  }
  
  private boolean c(Throwable paramThrowable)
  {
    boolean bool = true;
    if ((paramThrowable == null) || (1 != BaseApplicationImpl.sProcessId) || (System.currentTimeMillis() - anpc.ans > 600000L)) {}
    Object localObject2;
    do
    {
      return false;
      localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    } while (!((SharedPreferences)localObject2).getBoolean("key_not_exit_enable", false));
    Object localObject1 = paramThrowable.toString();
    int m;
    int j;
    int i;
    label180:
    int i2;
    label212:
    int n;
    try
    {
      localObject3 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_type", null);
      localObject2 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_stack", null);
      if ((localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label353;
      }
      localObject3 = ((String)localObject3).split("\\|");
      m = localObject3.length;
      j = 0;
      i = 0;
      if (j >= m) {
        break label365;
      }
      CharSequence localCharSequence = localObject3[j];
      if (!((String)localObject1).contains(localCharSequence)) {
        break label358;
      }
      QLog.d("ReportLog", 1, new Object[] { "exMsg = ", localObject1, ",crash = ", localCharSequence });
      i = 1;
    }
    catch (Throwable paramThrowable)
    {
      Object localObject3;
      int i3;
      int i1;
      QLog.e("ReportLog", 1, "isNotExitSafeMode has some error", paramThrowable);
      return false;
    }
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).split("\\|");
      paramThrowable = paramThrowable.getStackTrace();
      i2 = paramThrowable.length;
      m = 0;
      i = 0;
      break label370;
      localObject2 = ((StackTraceElement)localObject2).toString();
      i3 = localObject1.length;
      i1 = 0;
      for (;;)
      {
        n = i;
        if (i1 < i3)
        {
          localObject3 = localObject1[i1];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
          {
            QLog.d("ReportLog", 1, new Object[] { "stackElemStr = ", localObject2, ",crash = ", localObject3 });
            n = 1;
          }
        }
        else
        {
          m += 1;
          i = n;
          break;
        }
        i1 += 1;
      }
    }
    label353:
    label358:
    label365:
    label370:
    do
    {
      bool = false;
      break label402;
      n = 0;
      continue;
      j = 0;
      break label180;
      j += 1;
      break;
      j = i;
      break label180;
      n = i;
      if (m < i2)
      {
        localObject2 = paramThrowable[m];
        if (i == 0) {
          break label212;
        }
        n = i;
      }
    } while ((n == 0) || (j == 0));
    label402:
    return bool;
  }
  
  public static void gB(String paramString1, String paramString2)
  {
    if (!clV) {}
    while (isUploading) {
      return;
    }
    appendLog(paramString1, paramString2, true);
  }
  
  public static void setUserUin(String paramString)
  {
    uin = paramString;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QLog.d("ReportLog", 1, "uncaughtException java crash=" + paramThrowable);
    if (paramThrowable != null)
    {
      String str = paramThrowable.toString();
      if ((!TextUtils.isEmpty(str)) && (str.contains("java.util.concurrent.TimeoutException")) && (str.contains(".finalize() timed out after"))) {
        return;
      }
    }
    if (c(paramThrowable))
    {
      swu.showToastForSafeModeTest(acfp.m(2131713903));
      anpc.cJd = true;
      annt.e(new Throwable(paramThrowable), "notExitOnSafeMode");
      if (Looper.myLooper() != null) {
        for (;;)
        {
          try
          {
            Looper.loop();
            continue;
            if (c(paramThread)) {
              continue;
            }
          }
          catch (Throwable paramThread)
          {
            QLog.d("ReportLog", 1, "uncaughtException loop throwable=", paramThread);
          }
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break;
          }
          System.exit(0);
        }
      }
      try
      {
        paramThread.run();
        return;
      }
      catch (Throwable paramThrowable)
      {
        QLog.d("ReportLog", 1, "uncaughtException run throwable=", paramThrowable);
        try
        {
          paramThread.interrupt();
          return;
        }
        catch (Throwable paramThread)
        {
          QLog.d("ReportLog", 1, "uncaughtException interrupt throwable=", paramThread);
          return;
        }
      }
    }
    super.uncaughtException(paramThread, paramThrowable);
    long l = System.currentTimeMillis();
    QLog.d("ReportLog", 1, "uncaughtException trySave cost=" + (System.currentTimeMillis() - l));
    HeavyTaskExecutor.cPs();
    QLog.d("ReportLog", 1, "uncaughtException HeavyTask cost=" + (System.currentTimeMillis() - l));
    paramThread = MobileQQ.sMobileQQ;
    try
    {
      aivq.bPD = paramThread.getPackageManager().getPackageInfo(paramThread.getPackageName(), 0).versionName;
      aivq.model = Build.MODEL;
      aivq.bPE = Build.VERSION.RELEASE;
      label295:
      paramThread.crashed();
      paramThread.sendBroadcast(new Intent("qqplayer_exit_action"));
      QQMusicPlayService.LS("ReportLog");
      paramThread = new ReportLog.3(this, paramThread);
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(paramThread);
        return;
      }
      paramThread.run();
      return;
    }
    catch (Exception paramThrowable)
    {
      break label295;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivn
 * JD-Core Version:    0.7.0.1
 */