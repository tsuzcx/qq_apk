package com.tencent.TMG.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final String ENCRYPT_KET = "strKey";
  private static final String FILE_NAME = "crash";
  private static final String LOG_FILE_NAME_SUFFIX = ".trace";
  private static final String PATH;
  public static final String REPORT_URL = "https://avlab.qq.com:8080/crashreport?action=crashreport";
  private static final String SO_LIBRARY_NAME = "crash_catcher";
  private static final String TAG = CrashHandler.class.getSimpleName() + "runhw";
  private static CrashHandler sInstance;
  private Context mContext;
  private Thread.UncaughtExceptionHandler mDefaultCrashHandler;
  
  static
  {
    PATH = Environment.getExternalStorageDirectory().getPath() + "/test/log/";
    sInstance = new CrashHandler();
    System.loadLibrary("crash_catcher");
  }
  
  public static void dumpExceptionToSDCard(String paramString)
  {
    NetUtil.debugInfo(TAG, "dumpExceptionToSDCard(String): ");
    sInstance.dumpExceptionToSDCard(new Exception(paramString));
    Process.killProcess(Process.myPid());
  }
  
  /* Error */
  private String dumpPhoneInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/tencent/TMG/utils/CrashHandler:mContext	Landroid/content/Context;
    //   4: invokevirtual 117	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 111	com/tencent/TMG/utils/CrashHandler:mContext	Landroid/content/Context;
    //   13: invokevirtual 120	android/content/Context:getPackageName	()Ljava/lang/String;
    //   16: iconst_1
    //   17: invokevirtual 126	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   20: astore_3
    //   21: ldc 128
    //   23: astore_1
    //   24: new 34	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   31: ldc 128
    //   33: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: getfield 133	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   40: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: new 34	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: bipush 95
    //   62: invokevirtual 136	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   65: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: aload_2
    //   70: astore_1
    //   71: new 34	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   78: aload_2
    //   79: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: getfield 140	android/content/pm/PackageInfo:versionCode	I
    //   86: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: new 34	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   102: aload_2
    //   103: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 145
    //   108: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: new 34	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   124: aload_2
    //   125: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 150	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   131: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: new 34	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   147: aload_2
    //   148: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 152
    //   153: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore_2
    //   160: aload_2
    //   161: astore_1
    //   162: new 34	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   169: aload_2
    //   170: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 155	android/os/Build$VERSION:SDK_INT	I
    //   176: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: astore_2
    //   183: aload_2
    //   184: astore_1
    //   185: new 34	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   192: aload_2
    //   193: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 157
    //   198: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore_2
    //   205: aload_2
    //   206: astore_1
    //   207: new 34	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   214: aload_2
    //   215: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 162	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   221: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore_2
    //   228: aload_2
    //   229: astore_1
    //   230: new 34	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   237: aload_2
    //   238: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 164
    //   243: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: astore_2
    //   250: aload_2
    //   251: astore_1
    //   252: new 34	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   259: aload_2
    //   260: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: getstatic 167	android/os/Build:MODEL	Ljava/lang/String;
    //   266: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: astore_2
    //   273: aload_2
    //   274: astore_1
    //   275: new 34	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   282: aload_2
    //   283: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc 169
    //   288: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: astore_2
    //   295: aload_2
    //   296: astore_1
    //   297: new 34	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   304: aload_2
    //   305: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: getstatic 172	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   311: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore_2
    //   318: aload_2
    //   319: areturn
    //   320: astore_2
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_2
    //   324: invokevirtual 175	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   327: aload_1
    //   328: areturn
    //   329: astore_2
    //   330: goto -7 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	CrashHandler
    //   7	321	1	localObject	Object
    //   46	273	2	str	String
    //   320	4	2	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   329	1	2	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   20	63	3	localPackageInfo	android.content.pm.PackageInfo
    // Exception table:
    //   from	to	target	type
    //   8	21	320	android/content/pm/PackageManager$NameNotFoundException
    //   24	47	329	android/content/pm/PackageManager$NameNotFoundException
    //   49	69	329	android/content/pm/PackageManager$NameNotFoundException
    //   71	93	329	android/content/pm/PackageManager$NameNotFoundException
    //   95	115	329	android/content/pm/PackageManager$NameNotFoundException
    //   117	138	329	android/content/pm/PackageManager$NameNotFoundException
    //   140	160	329	android/content/pm/PackageManager$NameNotFoundException
    //   162	183	329	android/content/pm/PackageManager$NameNotFoundException
    //   185	205	329	android/content/pm/PackageManager$NameNotFoundException
    //   207	228	329	android/content/pm/PackageManager$NameNotFoundException
    //   230	250	329	android/content/pm/PackageManager$NameNotFoundException
    //   252	273	329	android/content/pm/PackageManager$NameNotFoundException
    //   275	295	329	android/content/pm/PackageManager$NameNotFoundException
    //   297	318	329	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static CrashHandler getInstance()
  {
    return sInstance;
  }
  
  private native void registerSigaction();
  
  public void dumpExceptionToSDCard(Throwable paramThrowable)
  {
    NetUtil.debugInfo(TAG, "dumpExceptionToSDCard(Throwable): ");
    NetUtil.debugInfo(TAG, "dumpExceptionToSDCard: msg = " + paramThrowable.getMessage() + "\n");
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      NetUtil.debugInfo(TAG, "sdcard unmounted,skip dump exception");
      return;
    }
    Object localObject1 = new File(PATH);
    if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdirs()))
    {
      NetUtil.debugInfo(TAG, "dumpExceptionToSDCard: dir not exist");
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l));
    Object localObject2 = new File(PATH + "crash" + ".trace");
    try
    {
      if ((!((File)localObject2).exists()) && (!((File)localObject2).createNewFile()))
      {
        NetUtil.debugInfo(TAG, "dumpExceptionToSDCard: file not exist");
        return;
      }
    }
    catch (Exception paramThrowable)
    {
      paramThrowable.printStackTrace();
      NetUtil.debugInfo(TAG, "dump crash info failed");
      return;
    }
    localObject2 = new PrintWriter(new BufferedWriter(new FileWriter((File)localObject2, true)));
    ((PrintWriter)localObject2).println((String)localObject1);
    ((PrintWriter)localObject2).println();
    paramThrowable.printStackTrace((PrintWriter)localObject2);
    ((PrintWriter)localObject2).close();
  }
  
  public String encrypt(String paramString1, String paramString2)
  {
    int m = 0;
    byte[] arrayOfByte = paramString1.getBytes();
    paramString2 = paramString2.getBytes();
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= paramString1.length()) {
        break;
      }
      arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ paramString2[i]));
      k = i + 1;
      i = k;
      if (k == paramString2.length) {
        i = 0;
      }
      j += 1;
    }
    while (k < 10)
    {
      System.out.println(arrayOfByte[k]);
      k += 1;
    }
    return new String(arrayOfByte);
  }
  
  public void init(Context paramContext) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    dumpExceptionToSDCard(paramThrowable);
    paramThrowable.printStackTrace();
    if (this.mDefaultCrashHandler != null)
    {
      this.mDefaultCrashHandler.uncaughtException(paramThread, paramThrowable);
      return;
    }
    Process.killProcess(Process.myPid());
  }
  
  public native void unregisterSigaction();
  
  /* Error */
  public void uploadCrashInfoToServer()
  {
    // Byte code:
    //   0: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   3: ldc_w 297
    //   6: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 62	java/io/File
    //   12: dup
    //   13: new 34	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   20: getstatic 69	com/tencent/TMG/utils/CrashHandler:PATH	Ljava/lang/String;
    //   23: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 13
    //   28: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 16
    //   33: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: aload 5
    //   46: invokevirtual 207	java/io/File:exists	()Z
    //   49: ifeq +247 -> 296
    //   52: new 299	java/io/BufferedReader
    //   55: dup
    //   56: new 301	java/io/FileReader
    //   59: dup
    //   60: aload 5
    //   62: invokespecial 304	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   65: invokespecial 307	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   68: astore_3
    //   69: aload_3
    //   70: astore_2
    //   71: new 34	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   78: astore 6
    //   80: aload_3
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnull +35 -> 125
    //   93: aload_3
    //   94: astore_2
    //   95: aload 6
    //   97: aload 4
    //   99: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_3
    //   104: astore_2
    //   105: aload 6
    //   107: getstatic 313	java/io/File:separator	Ljava/lang/String;
    //   110: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: astore_2
    //   116: aload_3
    //   117: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   120: astore 4
    //   122: goto -34 -> 88
    //   125: aload_3
    //   126: astore_2
    //   127: aload_0
    //   128: new 34	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   135: aload_0
    //   136: invokespecial 315	com/tencent/TMG/utils/CrashHandler:dumpPhoneInfo	()Ljava/lang/String;
    //   139: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 6
    //   144: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: ldc 10
    //   155: invokevirtual 317	com/tencent/TMG/utils/CrashHandler:encrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 4
    //   160: aload_3
    //   161: astore_2
    //   162: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   165: new 34	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 319
    //   175: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 4
    //   180: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 321
    //   186: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload 4
    //   191: invokevirtual 271	java/lang/String:length	()I
    //   194: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_3
    //   204: astore_2
    //   205: aload 4
    //   207: invokevirtual 268	java/lang/String:getBytes	()[B
    //   210: astore 6
    //   212: iconst_0
    //   213: istore_1
    //   214: iload_1
    //   215: bipush 10
    //   217: if_icmpge +22 -> 239
    //   220: aload_3
    //   221: astore_2
    //   222: getstatic 275	java/lang/System:out	Ljava/io/PrintStream;
    //   225: aload 6
    //   227: iload_1
    //   228: baload
    //   229: invokevirtual 279	java/io/PrintStream:println	(I)V
    //   232: iload_1
    //   233: iconst_1
    //   234: iadd
    //   235: istore_1
    //   236: goto -22 -> 214
    //   239: aload_3
    //   240: astore_2
    //   241: ldc 20
    //   243: aload 4
    //   245: invokestatic 324	com/tencent/TMG/utils/NetUtil:post	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: astore 4
    //   250: aload_3
    //   251: astore_2
    //   252: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   255: new 34	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 326
    //   265: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 4
    //   270: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_3
    //   280: astore_2
    //   281: aload 5
    //   283: invokevirtual 329	java/io/File:delete	()Z
    //   286: pop
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 330	java/io/BufferedReader:close	()V
    //   295: return
    //   296: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   299: ldc_w 332
    //   302: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aconst_null
    //   306: astore_3
    //   307: goto -20 -> 287
    //   310: astore_2
    //   311: aload_2
    //   312: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   315: return
    //   316: astore 4
    //   318: aconst_null
    //   319: astore_3
    //   320: aload_3
    //   321: astore_2
    //   322: aload 4
    //   324: invokevirtual 236	java/lang/Exception:printStackTrace	()V
    //   327: aload_3
    //   328: ifnull -33 -> 295
    //   331: aload_3
    //   332: invokevirtual 330	java/io/BufferedReader:close	()V
    //   335: return
    //   336: astore_2
    //   337: aload_2
    //   338: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   341: return
    //   342: astore_3
    //   343: aconst_null
    //   344: astore_2
    //   345: aload_2
    //   346: ifnull +7 -> 353
    //   349: aload_2
    //   350: invokevirtual 330	java/io/BufferedReader:close	()V
    //   353: aload_3
    //   354: athrow
    //   355: astore_2
    //   356: aload_2
    //   357: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   360: goto -7 -> 353
    //   363: astore_3
    //   364: goto -19 -> 345
    //   367: astore 4
    //   369: goto -49 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	CrashHandler
    //   213	23	1	i	int
    //   70	211	2	localBufferedReader1	java.io.BufferedReader
    //   310	2	2	localIOException1	java.io.IOException
    //   321	1	2	localBufferedReader2	java.io.BufferedReader
    //   336	2	2	localIOException2	java.io.IOException
    //   344	6	2	localObject1	Object
    //   355	2	2	localIOException3	java.io.IOException
    //   68	264	3	localBufferedReader3	java.io.BufferedReader
    //   342	12	3	localObject2	Object
    //   363	1	3	localObject3	Object
    //   86	183	4	str	String
    //   316	7	4	localException1	Exception
    //   367	1	4	localException2	Exception
    //   42	240	5	localFile	File
    //   78	148	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   291	295	310	java/io/IOException
    //   9	69	316	java/lang/Exception
    //   296	305	316	java/lang/Exception
    //   331	335	336	java/io/IOException
    //   9	69	342	finally
    //   296	305	342	finally
    //   349	353	355	java/io/IOException
    //   71	80	363	finally
    //   82	88	363	finally
    //   95	103	363	finally
    //   105	114	363	finally
    //   116	122	363	finally
    //   127	160	363	finally
    //   162	203	363	finally
    //   205	212	363	finally
    //   222	232	363	finally
    //   241	250	363	finally
    //   252	279	363	finally
    //   281	287	363	finally
    //   322	327	363	finally
    //   71	80	367	java/lang/Exception
    //   82	88	367	java/lang/Exception
    //   95	103	367	java/lang/Exception
    //   105	114	367	java/lang/Exception
    //   116	122	367	java/lang/Exception
    //   127	160	367	java/lang/Exception
    //   162	203	367	java/lang/Exception
    //   205	212	367	java/lang/Exception
    //   222	232	367	java/lang/Exception
    //   241	250	367	java/lang/Exception
    //   252	279	367	java/lang/Exception
    //   281	287	367	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.CrashHandler
 * JD-Core Version:    0.7.0.1
 */