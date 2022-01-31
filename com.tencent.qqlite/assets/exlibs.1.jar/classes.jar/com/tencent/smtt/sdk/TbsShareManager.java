package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

public class TbsShareManager
{
  static final String APP_VERSION = "app_version";
  static final String CORE_PACKAGENAME = "core_packagename";
  static final String CORE_PATH = "core_path";
  static final String CORE_VERSION = "core_version";
  private static final String TAG = "TbsShareManager";
  static final String TBS_FOLDER_NAME = "tbs";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  private static boolean core_info_already_read = false;
  private static boolean core_info_shared;
  private static String mAppVersion;
  private static String mAvailableCorePath = null;
  private static int mAvailableCoreVersion = 0;
  private static String mSrcPackageName = null;
  private static Context sAppContext;
  private static boolean sIsThirdPartyApp;
  
  static
  {
    core_info_shared = false;
    mAppVersion = null;
  }
  
  private static boolean checkCoreInOthers(Context paramContext)
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "com.tencent.mm";
    arrayOfString[1] = "com.tencent.mobileqq";
    arrayOfString[2] = "com.tencent.mtt";
    arrayOfString[3] = "com.qzone";
    arrayOfString[4] = "com.tencent.x5sdk.demo";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (mAvailableCoreVersion == getSharedTbsCoreVersion(paramContext, str))
      {
        paramContext = getPackageContext(paramContext, str);
        mAvailableCorePath = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext).getAbsolutePath();
        mSrcPackageName = str;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean checkCoreInfo(Context paramContext)
  {
    if (mSrcPackageName == null) {}
    while (mAvailableCoreVersion != getSharedTbsCoreVersion(paramContext, mSrcPackageName)) {
      return false;
    }
    return true;
  }
  
  private static boolean closeX5(Context paramContext)
  {
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  private static int findCoreForThirdPartyApp(Context paramContext)
  {
    loadProperties(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + mAvailableCoreVersion + " mAvailableCorePath is " + mAvailableCorePath + " mSrcPackageName is " + mSrcPackageName);
    if ((!checkCoreInfo(paramContext)) && (!checkCoreInOthers(paramContext)))
    {
      mAvailableCoreVersion = 0;
      mAvailableCorePath = null;
      mSrcPackageName = null;
      TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
    }
    if ((mAvailableCoreVersion > 0) && (QbSdk.isX5Disabled(paramContext, mAvailableCoreVersion)))
    {
      mAvailableCoreVersion = 0;
      mAvailableCorePath = null;
      mSrcPackageName = null;
      TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
    }
    return mAvailableCoreVersion;
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    if (paramContext == null) {}
    int i;
    do
    {
      return false;
      i = getSharedTbsCoreVersion(paramContext, "com.tencent.x5sdk.demo");
    } while (i <= 0);
    Object localObject = getPackageContext(paramContext, "com.tencent.x5sdk.demo");
    localObject = TbsInstaller.getInstance().getTbsCoreShareDir((Context)localObject).getAbsolutePath();
    writeProperties(paramContext, Integer.toString(i), "com.tencent.x5sdk.demo", (String)localObject, "1");
    return true;
  }
  
  static Context getAvailableTbsCoreHostContext(Context paramContext)
  {
    isShareTbsCoreAvailable(paramContext);
    if (mSrcPackageName == null) {
      return null;
    }
    return getPackageContext(paramContext, mSrcPackageName);
  }
  
  static String getAvailableTbsCorePath(Context paramContext)
  {
    isShareTbsCoreAvailable(paramContext);
    return mAvailableCorePath;
  }
  
  static int getAvailableTbsCoreVersion(Context paramContext)
  {
    isShareTbsCoreAvailable(paramContext);
    return mAvailableCoreVersion;
  }
  
  private static Context getPackageContext(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString);
    if (paramContext == null) {
      return 0;
    }
    return TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
  }
  
  private static File getTbsCorePrivateDir(Context paramContext)
  {
    File localFile = new File(paramContext.getDir("tbs", 0), "core_private");
    if (localFile != null)
    {
      paramContext = localFile;
      if (!localFile.isDirectory())
      {
        paramContext = localFile;
        if (!localFile.mkdir()) {
          paramContext = null;
        }
      }
      return paramContext;
    }
    return null;
  }
  
  private static File getTbsCorePrivateFile(Context paramContext, String paramString)
  {
    paramContext = getTbsCorePrivateDir(paramContext);
    if (paramContext == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramString = new File(paramContext, paramString);
      if (paramString == null) {
        break;
      }
      paramContext = paramString;
    } while (paramString.exists());
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = TbsInstaller.getInstance().getTbsShareDir(paramContext);
    if (paramContext == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramString = new File(paramContext, paramString);
      if (paramString == null) {
        break;
      }
      paramContext = paramString;
    } while (paramString.exists());
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static boolean isCoreShutDown(Context paramContext, int paramInt)
  {
    return QbSdk.isX5Disabled(paramContext, paramInt);
  }
  
  static boolean isShareTbsCoreAvailable(Context paramContext)
  {
    if (isShareTbsCoreAvailableInner(paramContext)) {
      return true;
    }
    TbsLog.e("TbsShareManager", "isShareTbsCoreAvailable forceSysWebViewInner!");
    QbSdk.forceSysWebViewInner();
    return false;
  }
  
  static boolean isShareTbsCoreAvailableInner(Context paramContext)
  {
    try
    {
      if (mAvailableCoreVersion == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (mAvailableCoreVersion == 0) {
        return false;
      }
      if ((mAvailableCoreVersion != 0) && (getSharedTbsCoreVersion(paramContext, mSrcPackageName) == mAvailableCoreVersion)) {
        return true;
      }
      mAvailableCorePath = null;
      mAvailableCoreVersion = 0;
      TbsLog.e("TbsShareManager", "isShareTbsCoreAvailableInner forceSysWebViewInner!");
      QbSdk.forceSysWebViewInner();
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    try
    {
      if ((sAppContext != null) && (sAppContext.equals(paramContext.getApplicationContext()))) {
        return sIsThirdPartyApp;
      }
      sAppContext = paramContext.getApplicationContext();
      paramContext = sAppContext.getPackageName();
      if ((paramContext.equals("com.tencent.mm")) || (paramContext.equals("com.tencent.mtt")) || (paramContext.equals("com.tencent.mobileqq")) || (paramContext.equals("com.tencent.x5sdk.demo")) || (paramContext.equals("com.tencent.mtt.sdk.test")) || (paramContext.equals("com.qzone")))
      {
        sIsThirdPartyApp = false;
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      sIsThirdPartyApp = true;
    }
    return true;
  }
  
  /* Error */
  private static void loadProperties(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 51	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_3
    //   20: aload 4
    //   22: astore_2
    //   23: aload_0
    //   24: ldc 250
    //   26: invokestatic 252	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnonnull +29 -> 60
    //   34: iconst_0
    //   35: ifeq -24 -> 11
    //   38: new 254	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 255	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   51: goto -40 -> 11
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    //   60: aload 4
    //   62: astore_2
    //   63: new 257	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_0
    //   72: new 262	java/util/Properties
    //   75: dup
    //   76: invokespecial 263	java/util/Properties:<init>	()V
    //   79: astore_2
    //   80: aload_2
    //   81: aload_0
    //   82: invokevirtual 267	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   85: aload_2
    //   86: ldc 17
    //   88: ldc 103
    //   90: invokevirtual 271	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: ldc 103
    //   96: aload_3
    //   97: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifne +14 -> 114
    //   103: aload_3
    //   104: invokestatic 275	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: iconst_0
    //   108: invokestatic 281	java/lang/Math:max	(II)I
    //   111: putstatic 43	com/tencent/smtt/sdk/TbsShareManager:mAvailableCoreVersion	I
    //   114: aload_2
    //   115: ldc 11
    //   117: ldc 103
    //   119: invokevirtual 271	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_3
    //   123: ldc 103
    //   125: aload_3
    //   126: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifne +7 -> 136
    //   132: aload_3
    //   133: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   136: aload_2
    //   137: ldc 14
    //   139: ldc 103
    //   141: invokevirtual 271	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_3
    //   145: ldc 103
    //   147: aload_3
    //   148: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifne +7 -> 158
    //   154: aload_3
    //   155: putstatic 41	com/tencent/smtt/sdk/TbsShareManager:mAvailableCorePath	Ljava/lang/String;
    //   158: aload_2
    //   159: ldc 8
    //   161: ldc 103
    //   163: invokevirtual 271	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   166: astore_2
    //   167: ldc 103
    //   169: aload_2
    //   170: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifne +7 -> 180
    //   176: aload_2
    //   177: putstatic 49	com/tencent/smtt/sdk/TbsShareManager:mAppVersion	Ljava/lang/String;
    //   180: iconst_1
    //   181: putstatic 51	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 284	java/io/FileInputStream:close	()V
    //   192: goto -181 -> 11
    //   195: astore_2
    //   196: aload_3
    //   197: astore_0
    //   198: aload_2
    //   199: astore_3
    //   200: aload_0
    //   201: astore_2
    //   202: aload_3
    //   203: invokevirtual 229	java/lang/Throwable:printStackTrace	()V
    //   206: aload_0
    //   207: ifnull -196 -> 11
    //   210: aload_0
    //   211: invokevirtual 284	java/io/FileInputStream:close	()V
    //   214: goto -203 -> 11
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   222: goto -211 -> 11
    //   225: astore_0
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 284	java/io/FileInputStream:close	()V
    //   234: aload_0
    //   235: athrow
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   241: goto -7 -> 234
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   249: goto -57 -> 192
    //   252: astore_3
    //   253: aload_0
    //   254: astore_2
    //   255: aload_3
    //   256: astore_0
    //   257: goto -31 -> 226
    //   260: astore_3
    //   261: goto -61 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   6	2	1	bool	boolean
    //   22	155	2	localObject1	Object
    //   195	4	2	localThrowable1	Throwable
    //   201	30	2	localContext1	Context
    //   236	2	2	localException	Exception
    //   254	1	2	localContext2	Context
    //   19	184	3	localObject2	Object
    //   252	4	3	localObject3	Object
    //   260	1	3	localThrowable2	Throwable
    //   16	45	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	46	java/lang/Exception
    //   3	7	54	finally
    //   38	46	54	finally
    //   47	51	54	finally
    //   188	192	54	finally
    //   210	214	54	finally
    //   218	222	54	finally
    //   230	234	54	finally
    //   234	236	54	finally
    //   237	241	54	finally
    //   245	249	54	finally
    //   23	30	195	java/lang/Throwable
    //   63	72	195	java/lang/Throwable
    //   210	214	217	java/lang/Exception
    //   23	30	225	finally
    //   63	72	225	finally
    //   202	206	225	finally
    //   230	234	236	java/lang/Exception
    //   188	192	244	java/lang/Exception
    //   72	114	252	finally
    //   114	136	252	finally
    //   136	158	252	finally
    //   158	180	252	finally
    //   180	184	252	finally
    //   72	114	260	java/lang/Throwable
    //   114	136	260	java/lang/Throwable
    //   136	158	260	java/lang/Throwable
    //   158	180	260	java/lang/Throwable
    //   180	184	260	java/lang/Throwable
  }
  
  /* Error */
  private static int readCoreVersionFromConfig(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: aload 5
    //   13: astore_3
    //   14: aload_0
    //   15: ldc 250
    //   17: invokestatic 252	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull +22 -> 44
    //   25: iload_2
    //   26: istore_1
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 254	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 255	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: ldc 2
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: aload 5
    //   46: astore_3
    //   47: new 257	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_0
    //   56: new 262	java/util/Properties
    //   59: dup
    //   60: invokespecial 263	java/util/Properties:<init>	()V
    //   63: astore_3
    //   64: aload_3
    //   65: aload_0
    //   66: invokevirtual 267	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload_3
    //   70: ldc 17
    //   72: ldc 103
    //   74: invokevirtual 271	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_3
    //   78: ldc 103
    //   80: aload_3
    //   81: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifne +23 -> 107
    //   87: aload_3
    //   88: invokestatic 275	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   91: iconst_0
    //   92: invokestatic 281	java/lang/Math:max	(II)I
    //   95: istore_1
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 284	java/io/FileInputStream:close	()V
    //   104: goto -65 -> 39
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 284	java/io/FileInputStream:close	()V
    //   115: iload_2
    //   116: istore_1
    //   117: goto -78 -> 39
    //   120: astore_3
    //   121: aload 4
    //   123: astore_0
    //   124: aload_3
    //   125: astore 4
    //   127: aload_0
    //   128: astore_3
    //   129: aload 4
    //   131: invokevirtual 229	java/lang/Throwable:printStackTrace	()V
    //   134: aload_0
    //   135: ifnull +7 -> 142
    //   138: aload_0
    //   139: invokevirtual 284	java/io/FileInputStream:close	()V
    //   142: bipush 254
    //   144: istore_1
    //   145: goto -106 -> 39
    //   148: astore_0
    //   149: aload_3
    //   150: ifnull +7 -> 157
    //   153: aload_3
    //   154: invokevirtual 284	java/io/FileInputStream:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    //   165: astore_3
    //   166: aload_3
    //   167: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   170: goto -13 -> 157
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   178: goto -36 -> 142
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   186: iload_2
    //   187: istore_1
    //   188: goto -149 -> 39
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   196: goto -92 -> 104
    //   199: astore_0
    //   200: aload_0
    //   201: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   204: goto -89 -> 115
    //   207: astore 4
    //   209: aload_0
    //   210: astore_3
    //   211: aload 4
    //   213: astore_0
    //   214: goto -65 -> 149
    //   217: astore 4
    //   219: goto -92 -> 127
    //   222: astore_0
    //   223: goto -63 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramContext	Context
    //   26	162	1	i	int
    //   1	186	2	j	int
    //   13	75	3	localObject1	Object
    //   120	5	3	localThrowable1	Throwable
    //   128	26	3	localContext1	Context
    //   165	2	3	localException	Exception
    //   210	1	3	localContext2	Context
    //   9	121	4	localObject2	Object
    //   207	5	4	localObject3	Object
    //   217	1	4	localThrowable2	Throwable
    //   6	39	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	120	java/lang/Throwable
    //   47	56	120	java/lang/Throwable
    //   14	21	148	finally
    //   47	56	148	finally
    //   129	134	148	finally
    //   31	39	159	finally
    //   138	142	159	finally
    //   153	157	159	finally
    //   157	159	159	finally
    //   166	170	159	finally
    //   174	178	159	finally
    //   182	186	159	finally
    //   153	157	165	java/lang/Exception
    //   138	142	173	java/lang/Exception
    //   31	39	181	java/lang/Exception
    //   100	104	191	java/lang/Exception
    //   111	115	199	java/lang/Exception
    //   56	96	207	finally
    //   56	96	217	java/lang/Throwable
    //   100	104	222	finally
    //   111	115	222	finally
    //   192	196	222	finally
    //   200	204	222	finally
  }
  
  private static void shareAllDirsAndFiles(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    paramTbsLinuxToolsJni.Chmod(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    label42:
    File localFile;
    if (i < j)
    {
      localFile = paramFile[i];
      if (!localFile.isFile()) {
        break label111;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label95;
      }
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      i += 1;
      break label42;
      break;
      label95:
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "644");
      continue;
      label111:
      if (localFile.isDirectory()) {
        shareAllDirsAndFiles(paramContext, paramTbsLinuxToolsJni, localFile);
      } else {
        TbsLog.e("TbsShareManager", "unknown file type.", true);
      }
    }
  }
  
  static void shareTbsCore(Context paramContext)
  {
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      shareAllDirsAndFiles(paramContext, localTbsLinuxToolsJni, TbsInstaller.getInstance().getTbsCoreShareDir(paramContext));
      localTbsLinuxToolsJni.Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      closeX5(paramContext);
    }
    label216:
    for (;;)
    {
      return;
      if (paramInt > mAvailableCoreVersion)
      {
        int i = readCoreVersionFromConfig(paramContext);
        if ((i < 0) || (paramInt <= i)) {
          break;
        }
        Object localObject2 = new String[5];
        localObject2[0] = "com.tencent.mm";
        localObject2[1] = "com.tencent.mobileqq";
        localObject2[2] = "com.tencent.mtt";
        localObject2[3] = "com.qzone";
        localObject2[4] = "com.tencent.x5sdk.demo";
        int j = localObject2.length;
        i = 0;
        for (;;)
        {
          for (;;)
          {
            if (i >= j) {
              break label216;
            }
            Object localObject1 = localObject2[i];
            if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject1))
            {
              localObject2 = getPackageContext(paramContext, (String)localObject1);
              localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir((Context)localObject2).getAbsolutePath();
              i = AppUtil.getAppVersionCode(paramContext);
              writeProperties(paramContext, Integer.toString(paramInt), (String)localObject1, (String)localObject2, Integer.toString(i));
              try
              {
                localObject1 = getTbsShareFile(paramContext, "core_info");
                if ((core_info_shared) || (localObject1 == null)) {
                  break;
                }
                localObject2 = new TbsLinuxToolsJni(sAppContext);
                ((TbsLinuxToolsJni)localObject2).Chmod(((File)localObject1).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject2).Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
                core_info_shared = true;
                return;
              }
              catch (Throwable paramContext)
              {
                paramContext.printStackTrace();
                return;
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 7
    //   8: astore 5
    //   10: aload_0
    //   11: ldc 250
    //   13: invokestatic 252	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   16: astore 8
    //   18: aload 8
    //   20: ifnonnull +11 -> 31
    //   23: new 254	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 255	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: aload 7
    //   33: astore 5
    //   35: new 257	java/io/FileInputStream
    //   38: dup
    //   39: aload 8
    //   41: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_0
    //   45: new 262	java/util/Properties
    //   48: dup
    //   49: invokespecial 263	java/util/Properties:<init>	()V
    //   52: astore 5
    //   54: aload 5
    //   56: aload_0
    //   57: invokevirtual 267	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   60: aload 5
    //   62: ldc 17
    //   64: aload_1
    //   65: invokevirtual 334	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   68: pop
    //   69: aload 5
    //   71: ldc 11
    //   73: aload_2
    //   74: invokevirtual 334	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   77: pop
    //   78: aload 5
    //   80: ldc 14
    //   82: aload_3
    //   83: invokevirtual 334	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   86: pop
    //   87: aload 5
    //   89: ldc 8
    //   91: aload 4
    //   93: invokevirtual 334	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   96: pop
    //   97: aload 5
    //   99: new 336	java/io/FileOutputStream
    //   102: dup
    //   103: aload 8
    //   105: invokespecial 337	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   108: aconst_null
    //   109: invokevirtual 341	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   112: iconst_0
    //   113: putstatic 51	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   116: aload_0
    //   117: invokevirtual 284	java/io/FileInputStream:close	()V
    //   120: return
    //   121: astore_1
    //   122: aload 6
    //   124: astore_0
    //   125: aload_0
    //   126: astore 5
    //   128: aload_1
    //   129: invokevirtual 229	java/lang/Throwable:printStackTrace	()V
    //   132: aload_0
    //   133: invokevirtual 284	java/io/FileInputStream:close	()V
    //   136: return
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   142: return
    //   143: astore_0
    //   144: aload 5
    //   146: invokevirtual 284	java/io/FileInputStream:close	()V
    //   149: aload_0
    //   150: athrow
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   156: goto -7 -> 149
    //   159: astore_0
    //   160: goto -22 -> 138
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   168: goto -48 -> 120
    //   171: astore_1
    //   172: aload_0
    //   173: astore 5
    //   175: aload_1
    //   176: astore_0
    //   177: goto -33 -> 144
    //   180: astore_1
    //   181: goto -56 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   0	184	1	paramString1	String
    //   0	184	2	paramString2	String
    //   0	184	3	paramString3	String
    //   0	184	4	paramString4	String
    //   8	166	5	localObject1	Object
    //   4	119	6	localObject2	Object
    //   1	31	7	localObject3	Object
    //   16	88	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   10	18	121	java/lang/Throwable
    //   35	45	121	java/lang/Throwable
    //   132	136	137	java/lang/Exception
    //   10	18	143	finally
    //   35	45	143	finally
    //   128	132	143	finally
    //   144	149	151	java/lang/Exception
    //   23	31	159	java/lang/Exception
    //   116	120	163	java/lang/Exception
    //   45	116	171	finally
    //   45	116	180	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */