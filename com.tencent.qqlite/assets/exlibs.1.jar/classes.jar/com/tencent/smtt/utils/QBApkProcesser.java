package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QBApkProcesser
{
  private static final String Config_Name_QBApkPath = "FileDownloadPath";
  private static final String Config_Verify_Info = "FileDownloadVerifyInfo";
  private static final String DEMOIniPath = "/data/data/com.tencent.x5sdk.demo/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static final String DOWNLOAD_URL = "downloadurl";
  private static final int MSG_DOWNLOAD_QB = 2;
  private static final int MSG_INSTALL_QB = 1;
  private static final int MSG_OPEN_URL = 0;
  private static final String PAGE_URL = "url";
  private static final int QBAPK_DOWNLOAD = 1;
  private static final int QBAPK_INSTALLED = 2;
  private static final int QBAPK_UNDOWNLOAD = 0;
  private static final String QB_APK_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  private static final String QB_CLASS_NAME = "com.tencent.mtt.MainActivity";
  private static final String QB_PACKAGE_NAME = "com.tencent.mtt";
  private static final String QQIniPath = "/data/data/com.tencent.mobileqq/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static final String QZONEIniPath = "/data/data/com.qzone/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static final String SCHEME_TBSQB_DOWNLOADE = "tbsqbdownload://";
  private static final String TAG = "QBApkUtils";
  private static final String WXIniPath = "/data/data/com.tencent.mm/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static QBApkProcesser mInstance = null;
  private Handler mHandler = null;
  
  private int checkQBApkStatus(Context paramContext)
  {
    if (getInstalledPKGInfo("com.tencent.mtt", paramContext, 128) != null) {
      return 2;
    }
    if (!TextUtils.isEmpty(getQBApkPath(paramContext))) {
      return 1;
    }
    return 0;
  }
  
  private void downloadQB(Context paramContext, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = new Object[] { paramContext, paramString };
    this.mHandler.sendMessage(localMessage);
  }
  
  private void downloadQBInThread(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() > 0))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.addFlags(268435456);
      paramContext.startActivity(paramString);
    }
  }
  
  public static QBApkProcesser getInstance()
  {
    if (mInstance == null) {
      mInstance = new QBApkProcesser();
    }
    return mInstance;
  }
  
  private String getQBApkPath(Context paramContext)
  {
    Object localObject = parseQBApkIni(paramContext);
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      paramContext = (String)((Map)localObject).get("FileDownloadPath");
      localObject = (String)((Map)localObject).get("FileDownloadVerifyInfo");
      if (TextUtils.isEmpty(paramContext)) {
        paramContext = "";
      }
      File localFile;
      do
      {
        return paramContext;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return "";
        }
        localFile = new File(paramContext);
        if (!localFile.exists()) {
          return "";
        }
      } while (TextUtils.equals(Md5Utils.getMD5(localFile.lastModified() + ""), (CharSequence)localObject));
    }
    return "";
  }
  
  private void installQB(Context paramContext)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext };
    this.mHandler.sendMessage(localMessage);
  }
  
  private void installQBInThread(Context paramContext)
  {
    try
    {
      Object localObject = getQBApkPath(paramContext);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType(Uri.fromFile((File)localObject), "application/vnd.android.package-archive");
        paramContext.startActivity(localIntent);
        QBInstallerRecorder.getInstance(paramContext).recordQBInstaller(paramContext.getApplicationInfo().processName);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void openUrlByQB(Context paramContext, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = new Object[] { paramContext, paramString };
    this.mHandler.sendMessage(localMessage);
  }
  
  public static void openUrlByQBInThread(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() > 0)) {
      MttLoader.loadUrl(paramContext, paramString, null);
    }
  }
  
  private Map<String, String> parseIni(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    localObject2 = null;
    for (;;)
    {
      try
      {
        localObject1 = new HashMap();
      }
      catch (Throwable paramString)
      {
        int j;
        int i;
        Object localObject3;
        Object localObject1 = localObject2;
        continue;
        i += 1;
        continue;
      }
      try
      {
        paramString = paramString.split("\n");
        j = paramString.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject2 = paramString[i];
        if ((localObject2 == null) || (localObject2.length() <= 0)) {
          continue;
        }
        localObject3 = localObject2.trim().split("=", 2);
        if ((localObject3 == null) || (localObject3.length < 2)) {
          continue;
        }
        localObject2 = localObject3[0];
        localObject3 = localObject3[1];
        if ((localObject2 == null) || (localObject2.length() <= 0)) {
          continue;
        }
        ((Map)localObject1).put(localObject2, localObject3);
      }
      catch (Throwable paramString) {}
    }
    paramString.printStackTrace();
    return localObject1;
    return localObject1;
  }
  
  /* Error */
  private Map<String, String> parseQBApkIni(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: ldc 172
    //   11: astore_2
    //   12: aload 8
    //   14: astore_3
    //   15: new 174	java/io/File
    //   18: dup
    //   19: ldc 56
    //   21: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +17 -> 45
    //   31: aload 4
    //   33: astore_1
    //   34: aload 8
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 181	java/io/File:exists	()Z
    //   42: ifne +16 -> 58
    //   45: aload 8
    //   47: astore_3
    //   48: new 174	java/io/File
    //   51: dup
    //   52: ldc 44
    //   54: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +16 -> 75
    //   62: aload_1
    //   63: astore 5
    //   65: aload 8
    //   67: astore_3
    //   68: aload_1
    //   69: invokevirtual 181	java/io/File:exists	()Z
    //   72: ifne +17 -> 89
    //   75: aload 8
    //   77: astore_3
    //   78: new 174	java/io/File
    //   81: dup
    //   82: ldc 47
    //   84: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore 5
    //   89: aload 7
    //   91: astore 4
    //   93: aload_2
    //   94: astore_1
    //   95: aload 5
    //   97: ifnull +61 -> 158
    //   100: aload 7
    //   102: astore 4
    //   104: aload_2
    //   105: astore_1
    //   106: aload 8
    //   108: astore_3
    //   109: aload 5
    //   111: invokevirtual 181	java/io/File:exists	()Z
    //   114: ifeq +44 -> 158
    //   117: aload 8
    //   119: astore_3
    //   120: new 280	java/io/FileInputStream
    //   123: dup
    //   124: aload 5
    //   126: invokespecial 283	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore_1
    //   130: aload_1
    //   131: invokestatic 289	com/tencent/smtt/utils/FileUtil:toByteArray	(Ljava/io/InputStream;)[B
    //   134: astore_3
    //   135: aload_3
    //   136: ifnull +119 -> 255
    //   139: new 126	java/lang/String
    //   142: dup
    //   143: aload_3
    //   144: ldc_w 291
    //   147: invokespecial 294	java/lang/String:<init>	([BLjava/lang/String;)V
    //   150: astore_3
    //   151: aload_3
    //   152: astore_2
    //   153: aload_1
    //   154: astore 4
    //   156: aload_2
    //   157: astore_1
    //   158: aload_1
    //   159: astore_3
    //   160: aload 4
    //   162: ifnull +10 -> 172
    //   165: aload 4
    //   167: invokevirtual 297	java/io/FileInputStream:close	()V
    //   170: aload_1
    //   171: astore_3
    //   172: aload_0
    //   173: aload_3
    //   174: invokespecial 299	com/tencent/smtt/utils/QBApkProcesser:parseIni	(Ljava/lang/String;)Ljava/util/Map;
    //   177: areturn
    //   178: astore 4
    //   180: aload 6
    //   182: astore_1
    //   183: aload_1
    //   184: astore_3
    //   185: aload 4
    //   187: invokevirtual 243	java/lang/Throwable:printStackTrace	()V
    //   190: aload_2
    //   191: astore_3
    //   192: aload_1
    //   193: ifnull -21 -> 172
    //   196: aload_1
    //   197: invokevirtual 297	java/io/FileInputStream:close	()V
    //   200: aload_2
    //   201: astore_3
    //   202: goto -30 -> 172
    //   205: astore_3
    //   206: aload_2
    //   207: astore_1
    //   208: aload_3
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   214: aload_1
    //   215: astore_3
    //   216: goto -44 -> 172
    //   219: astore_1
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 297	java/io/FileInputStream:close	()V
    //   228: aload_1
    //   229: athrow
    //   230: astore_2
    //   231: aload_2
    //   232: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   235: goto -7 -> 228
    //   238: astore_2
    //   239: goto -29 -> 210
    //   242: astore_2
    //   243: aload_1
    //   244: astore_3
    //   245: aload_2
    //   246: astore_1
    //   247: goto -27 -> 220
    //   250: astore 4
    //   252: goto -69 -> 183
    //   255: aload_1
    //   256: astore 4
    //   258: aload_2
    //   259: astore_1
    //   260: goto -102 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	QBApkProcesser
    //   0	263	1	paramContext	Context
    //   11	200	2	localObject1	Object
    //   230	2	2	localIOException1	java.io.IOException
    //   238	1	2	localIOException2	java.io.IOException
    //   242	17	2	localObject2	Object
    //   14	188	3	localObject3	Object
    //   205	4	3	localIOException3	java.io.IOException
    //   215	30	3	localContext1	Context
    //   24	142	4	localObject4	Object
    //   178	8	4	localThrowable1	Throwable
    //   250	1	4	localThrowable2	Throwable
    //   256	1	4	localContext2	Context
    //   63	62	5	localObject5	Object
    //   1	180	6	localObject6	Object
    //   7	94	7	localObject7	Object
    //   4	114	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   15	26	178	java/lang/Throwable
    //   37	45	178	java/lang/Throwable
    //   48	58	178	java/lang/Throwable
    //   68	75	178	java/lang/Throwable
    //   78	89	178	java/lang/Throwable
    //   109	117	178	java/lang/Throwable
    //   120	130	178	java/lang/Throwable
    //   196	200	205	java/io/IOException
    //   15	26	219	finally
    //   37	45	219	finally
    //   48	58	219	finally
    //   68	75	219	finally
    //   78	89	219	finally
    //   109	117	219	finally
    //   120	130	219	finally
    //   185	190	219	finally
    //   224	228	230	java/io/IOException
    //   165	170	238	java/io/IOException
    //   130	135	242	finally
    //   139	151	242	finally
    //   130	135	250	java/lang/Throwable
    //   139	151	250	java/lang/Throwable
  }
  
  private boolean verifyQBApk(Context paramContext, File paramFile)
  {
    if (paramContext == null) {}
    while (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(ApkUtil.getSignatureFromApk(paramContext, paramFile))) {
      return false;
    }
    return true;
  }
  
  public PackageInfo getInstalledPKGInfo(String paramString, Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, paramInt);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public boolean hiJackUrl(Context paramContext, String paramString)
  {
    boolean bool = true;
    if (paramString != null) {}
    String str;
    Object localObject1;
    label199:
    do
    {
      try
      {
        if (!paramString.startsWith("tbsqbdownload://")) {
          break label199;
        }
        paramString = paramString.substring("tbsqbdownload://".length());
        str = null;
        String[] arrayOfString1 = null;
        Object localObject2 = null;
        String[] arrayOfString2 = paramString.split(",");
        localObject1 = localObject2;
        if (arrayOfString2.length <= 1) {
          continue;
        }
        localObject1 = arrayOfString2[0].split("=");
        paramString = arrayOfString1;
        if (localObject1.length > 1)
        {
          paramString = arrayOfString1;
          if ("url".equalsIgnoreCase(localObject1[0])) {
            paramString = arrayOfString2[0].substring("url".length() + 1);
          }
        }
        arrayOfString1 = arrayOfString2[1].split("=");
        localObject1 = localObject2;
        str = paramString;
        if (arrayOfString1.length <= 1) {
          continue;
        }
        localObject1 = localObject2;
        str = paramString;
        if (!"downloadurl".equalsIgnoreCase(arrayOfString1[0])) {
          continue;
        }
        localObject1 = arrayOfString2[1].substring("downloadurl".length() + 1);
        str = paramString;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      int i = checkQBApkStatus(paramContext);
      if (i == 2)
      {
        openUrlByQB(paramContext, str);
        return true;
        return false;
      }
      if (i == 1)
      {
        installQB(paramContext);
        return true;
      }
      if (i != 0) {
        break;
      }
      downloadQB(paramContext, (String)localObject1);
      return true;
    } while ((str != null) && (localObject1 != null));
    bool = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.QBApkProcesser
 * JD-Core Version:    0.7.0.1
 */