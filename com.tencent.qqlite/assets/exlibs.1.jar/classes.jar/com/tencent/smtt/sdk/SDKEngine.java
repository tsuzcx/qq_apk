package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.libwebp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

class SDKEngine
{
  public static final String COUNT_PROPERTIES = "count.prop";
  private static final String GET_CALLED_COUNT_KEY = "getCalledCount";
  private static final String LOGTAG = "SDKEngine";
  private static final int MSG_CHECK_X5CORE_INSTALLED = 101;
  private static final int MSG_CLEAR_DEXOPT_THREAD = 100;
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  private static final String STR_TIMESTAMP = "timestamp";
  public static final String X5QQBROWSER_PKG_NAME;
  public static final String X5_ASSETS_CONF_PATH = "webkit/qbx5.conf";
  public static final String X5_CONF = "qbx5.conf";
  public static final String X5_CONF_CORE_VER = "browser_core_version";
  public static final String X5_CONF_TIMESTAMP = "browser_core_build_number";
  public static final String X5_CORE_FOLDER_NAME = "x5core";
  public static final String X5_FILE_DEX = "webview_dex.jar";
  public static final String X5_FILE_INTERFACES_DEX = "webview_interfaces_dex.jar";
  public static final String X5_PROPERTIES = "x5.prop";
  public static final String X5_SHARE_FOLDER_NAME = "x5_share";
  public static final String X5_SO = "libmttwebcore.so";
  private static int checkTimeDelay = 0;
  private static int checkTimesCount = 0;
  private static int checkTimesMax = 0;
  private static boolean getX5CoreNeedRebootCalled = false;
  private static int iInitCount = 0;
  private static boolean isCompatibleChecked = false;
  private static int mCoreVersion = 0;
  private static String mCoreVersionString;
  private static boolean mDexDone = false;
  private static SDKEngine mInstance = null;
  private static boolean mQBTimesTampDiff = false;
  private static String mQBTimestampFinish;
  private static String mQBTimestampStart;
  private static int mRebootCalledTimes = 0;
  private static int mRebootCalledTimesMax = 0;
  private static boolean mX5CoreInstalled = false;
  private static final int sMinSupportCoreVersion = 25102;
  private File mBrowserX5CorePath = null;
  private File mBrowserX5SharePath = null;
  private Context mContext = null;
  private Handler mDexHandler = null;
  private HandlerThread mDexHandlerThread = null;
  private File mSoPath = null;
  private Handler mUIHandler = null;
  private boolean mUsedX5 = false;
  private WebViewWizardBase mWizard = null;
  private File mX5CorePath = null;
  
  static
  {
    if ((System.getProperty("os.arch").toLowerCase().contains("x86")) || (System.getProperty("os.arch").toLowerCase().contains("i686"))) {}
    for (String str = "com.tencent.mtt.x86";; str = "com.tencent.mtt")
    {
      X5QQBROWSER_PKG_NAME = str;
      mCoreVersion = 0;
      mCoreVersionString = null;
      iInitCount = 0;
      isCompatibleChecked = false;
      getX5CoreNeedRebootCalled = false;
      mQBTimesTampDiff = false;
      mDexDone = false;
      mX5CoreInstalled = false;
      mQBTimestampStart = "";
      mQBTimestampFinish = "";
      mRebootCalledTimesMax = 5;
      mRebootCalledTimes = 1;
      checkTimesMax = 5;
      checkTimesCount = 0;
      checkTimeDelay = 5000;
      return;
    }
  }
  
  public static void compareQBTimestampForReboot(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    mQBTimestampFinish = getQBAssetTimestamp(paramContext);
    QbSdkLog.d("X5CoreNeedReboot", "SDKEngine--compareQBTimestampForReboot mQBTimestampFinish = " + mQBTimestampFinish);
    if (mQBTimestampFinish.equals(""))
    {
      mQBTimesTampDiff = false;
      return;
    }
    if (!mQBTimestampFinish.equals(mQBTimestampStart))
    {
      mQBTimesTampDiff = true;
      return;
    }
    mQBTimesTampDiff = false;
  }
  
  private void doDexOptimize(final Context paramContext)
  {
    if (this.mDexHandlerThread == null)
    {
      this.mDexHandlerThread = new HandlerThread("X5DexOptimize");
      this.mDexHandlerThread.start();
    }
    if (this.mDexHandler == null)
    {
      this.mDexHandler = new Handler(this.mDexHandlerThread.getLooper());
      int i = 0;
      if (getCurrentRuntimeValue().toString().contains("ART")) {
        i = 2000;
      }
      this.mDexHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          WebViewWizardBase localWebViewWizardBase = new WebViewWizardBase();
          localWebViewWizardBase.setWizardMode(true, true);
          Context localContext = SDKEngine.getPackageContext(paramContext, SDKEngine.X5QQBROWSER_PKG_NAME);
          if (localContext == null) {
            return;
          }
          Object localObject1 = localContext.getDir("x5_share", 0);
          Object localObject2 = new File((File)localObject1, "x5core");
          localContext = paramContext;
          localObject1 = new File((File)localObject1, "webview_interfaces_dex.jar").getAbsolutePath();
          localObject2 = new File((File)localObject2, "webview_dex.jar").getAbsolutePath();
          String str = SDKEngine.this.mX5CorePath.getAbsolutePath();
          localWebViewWizardBase.setDexLoader(localContext, new String[] { localObject1, localObject2 }, str);
          SDKEngine.this.mUIHandler.removeMessages(100);
          SDKEngine.this.mUIHandler.sendEmptyMessage(100);
        }
      }, i);
    }
  }
  
  private String getCalledCountKey()
  {
    if ((mQBTimestampStart.equals("")) || (mQBTimestampFinish.equals(""))) {
      return null;
    }
    return mQBTimestampStart + mQBTimestampFinish;
  }
  
  @TargetApi(9)
  private String getCurrentNativeLibraryDir(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 9) {
      return paramContext.getApplicationInfo().nativeLibraryDir;
    }
    if (i > 4) {
      return paramContext.getApplicationInfo().dataDir + "/lib";
    }
    return paramContext.getFilesDir().getParentFile().getPath() + "/lib";
  }
  
  /* Error */
  private CharSequence getCurrentRuntimeValue()
  {
    // Byte code:
    //   0: ldc_w 336
    //   3: invokestatic 342	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   6: astore_1
    //   7: aload_1
    //   8: ldc_w 344
    //   11: iconst_2
    //   12: anewarray 338	java/lang/Class
    //   15: dup
    //   16: iconst_0
    //   17: ldc 110
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: ldc 110
    //   24: aastore
    //   25: invokevirtual 348	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +9 -> 39
    //   33: ldc_w 350
    //   36: astore_1
    //   37: aload_1
    //   38: areturn
    //   39: aload_2
    //   40: aload_1
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: ldc_w 352
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc_w 354
    //   56: aastore
    //   57: invokevirtual 360	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 110	java/lang/String
    //   63: astore_2
    //   64: ldc_w 362
    //   67: aload_2
    //   68: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifeq +7 -> 78
    //   74: ldc_w 354
    //   77: areturn
    //   78: ldc_w 364
    //   81: aload_2
    //   82: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +7 -> 92
    //   88: ldc_w 278
    //   91: areturn
    //   92: aload_2
    //   93: astore_1
    //   94: ldc_w 366
    //   97: aload_2
    //   98: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifeq -64 -> 37
    //   104: ldc_w 368
    //   107: areturn
    //   108: astore_1
    //   109: ldc_w 370
    //   112: areturn
    //   113: astore_1
    //   114: ldc_w 372
    //   117: areturn
    //   118: astore_1
    //   119: ldc_w 374
    //   122: areturn
    //   123: astore_1
    //   124: ldc_w 376
    //   127: areturn
    //   128: astore_1
    //   129: ldc_w 378
    //   132: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	SDKEngine
    //   6	88	1	localObject1	Object
    //   108	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   113	1	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   118	1	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   123	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   128	1	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   28	70	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	74	108	java/lang/IllegalAccessException
    //   78	88	108	java/lang/IllegalAccessException
    //   94	104	108	java/lang/IllegalAccessException
    //   39	74	113	java/lang/reflect/InvocationTargetException
    //   78	88	113	java/lang/reflect/InvocationTargetException
    //   94	104	113	java/lang/reflect/InvocationTargetException
    //   7	29	118	java/lang/NoSuchMethodException
    //   39	74	118	java/lang/NoSuchMethodException
    //   78	88	118	java/lang/NoSuchMethodException
    //   94	104	118	java/lang/NoSuchMethodException
    //   0	7	123	java/lang/ClassNotFoundException
    //   7	29	123	java/lang/ClassNotFoundException
    //   39	74	123	java/lang/ClassNotFoundException
    //   78	88	123	java/lang/ClassNotFoundException
    //   94	104	123	java/lang/ClassNotFoundException
    //   39	74	128	java/lang/IllegalArgumentException
    //   78	88	128	java/lang/IllegalArgumentException
    //   94	104	128	java/lang/IllegalArgumentException
  }
  
  public static SDKEngine getInstance(boolean paramBoolean)
  {
    if ((mInstance == null) && (paramBoolean)) {
      mInstance = new SDKEngine();
    }
    return mInstance;
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
  
  public static String getQBAssetTimestamp(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = getPackageContext(paramContext, X5QQBROWSER_PKG_NAME);
      if (paramContext == null) {
        return "";
      }
      paramContext = getX5Config(paramContext.getAssets().open("webkit/qbx5.conf"));
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.getProperty("browser_core_build_number", "");
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static int getQQBrowserCoreVersion(Context paramContext)
  {
    initX5CoreVersionIfNeed(paramContext);
    return mCoreVersion;
  }
  
  private static Properties getX5Config(InputStream paramInputStream)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(paramInputStream);
      paramInputStream.close();
      return localProperties;
    }
    catch (UnsupportedEncodingException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  /* Error */
  private static void initX5CoreVersionIfNeed(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 128	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_2
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 126	com/tencent/smtt/sdk/SDKEngine:X5QQBROWSER_PKG_NAME	Ljava/lang/String;
    //   20: invokestatic 219	com/tencent/smtt/sdk/SDKEngine:getPackageContext	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Context;
    //   23: astore 5
    //   25: aload 5
    //   27: ifnonnull +21 -> 48
    //   30: iconst_0
    //   31: ifeq -25 -> 6
    //   34: new 434	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 435	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   47: return
    //   48: aload_2
    //   49: astore_1
    //   50: new 317	java/io/File
    //   53: dup
    //   54: new 317	java/io/File
    //   57: dup
    //   58: aload 5
    //   60: ldc 57
    //   62: iconst_0
    //   63: invokevirtual 439	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   66: ldc 45
    //   68: invokespecial 442	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: ldc 36
    //   73: invokespecial 442	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: astore 5
    //   78: aload 5
    //   80: ifnull +107 -> 187
    //   83: aload_2
    //   84: astore_1
    //   85: aload 5
    //   87: invokevirtual 445	java/io/File:exists	()Z
    //   90: ifeq +97 -> 187
    //   93: aload_2
    //   94: astore_1
    //   95: new 410	java/util/Properties
    //   98: dup
    //   99: invokespecial 422	java/util/Properties:<init>	()V
    //   102: astore 4
    //   104: aload_2
    //   105: astore_1
    //   106: new 447	java/io/FileInputStream
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 450	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: astore_2
    //   116: aload 4
    //   118: aload_2
    //   119: invokevirtual 426	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   122: aload_2
    //   123: invokevirtual 451	java/io/FileInputStream:close	()V
    //   126: aload 4
    //   128: ldc 39
    //   130: invokevirtual 452	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   133: putstatic 130	com/tencent/smtt/sdk/SDKEngine:mCoreVersionString	Ljava/lang/String;
    //   136: getstatic 130	com/tencent/smtt/sdk/SDKEngine:mCoreVersionString	Ljava/lang/String;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnonnull +18 -> 159
    //   144: aload_2
    //   145: ifnull -139 -> 6
    //   148: aload_2
    //   149: invokevirtual 451	java/io/FileInputStream:close	()V
    //   152: return
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   158: return
    //   159: getstatic 130	com/tencent/smtt/sdk/SDKEngine:mCoreVersionString	Ljava/lang/String;
    //   162: invokestatic 458	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putstatic 128	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 451	java/io/FileInputStream:close	()V
    //   176: getstatic 128	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   179: ifne -173 -> 6
    //   182: aload_0
    //   183: invokestatic 463	com/tencent/smtt/sdk/QbSdk:installX5	(Landroid/content/Context;)V
    //   186: return
    //   187: aload_2
    //   188: astore_1
    //   189: iconst_0
    //   190: putstatic 128	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   193: aload 4
    //   195: astore_2
    //   196: goto -28 -> 168
    //   199: astore_1
    //   200: aload_3
    //   201: astore_2
    //   202: aload_1
    //   203: astore_3
    //   204: aload_2
    //   205: astore_1
    //   206: aload_3
    //   207: invokevirtual 392	java/lang/Exception:printStackTrace	()V
    //   210: aload_2
    //   211: astore_1
    //   212: iconst_0
    //   213: putstatic 128	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   216: aload_2
    //   217: ifnull -41 -> 176
    //   220: aload_2
    //   221: invokevirtual 451	java/io/FileInputStream:close	()V
    //   224: goto -48 -> 176
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   232: goto -56 -> 176
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   240: goto -64 -> 176
    //   243: astore_0
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 451	java/io/FileInputStream:close	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   259: goto -7 -> 252
    //   262: astore_0
    //   263: aload_2
    //   264: astore_1
    //   265: goto -21 -> 244
    //   268: astore_3
    //   269: goto -65 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	Context
    //   15	174	1	localObject1	Object
    //   199	4	1	localException1	Exception
    //   205	7	1	localObject2	Object
    //   227	2	1	localIOException1	IOException
    //   235	14	1	localIOException2	IOException
    //   254	2	1	localIOException3	IOException
    //   264	1	1	localObject3	Object
    //   10	254	2	localObject4	Object
    //   8	199	3	localObject5	Object
    //   268	1	3	localException2	Exception
    //   12	182	4	localProperties	Properties
    //   23	88	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	42	java/io/IOException
    //   148	152	153	java/io/IOException
    //   16	25	199	java/lang/Exception
    //   50	78	199	java/lang/Exception
    //   85	93	199	java/lang/Exception
    //   95	104	199	java/lang/Exception
    //   106	116	199	java/lang/Exception
    //   189	193	199	java/lang/Exception
    //   220	224	227	java/io/IOException
    //   172	176	235	java/io/IOException
    //   16	25	243	finally
    //   50	78	243	finally
    //   85	93	243	finally
    //   95	104	243	finally
    //   106	116	243	finally
    //   189	193	243	finally
    //   206	210	243	finally
    //   212	216	243	finally
    //   248	252	254	java/io/IOException
    //   116	140	262	finally
    //   159	168	262	finally
    //   116	140	268	java/lang/Exception
    //   159	168	268	java/lang/Exception
  }
  
  private static boolean isCompatible(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    try
    {
      if (!isCompatibleChecked)
      {
        bool1 = bool2;
        if (paramInt <= 25206)
        {
          bool1 = bool2;
          if (paramInt >= 25200) {
            bool1 = false;
          }
        }
        isCompatibleChecked = true;
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    finally
    {
      isCompatibleChecked = true;
    }
  }
  
  private boolean isRebootCalledTimesOK()
  {
    if (getCalledCountKey() == null) {
      return true;
    }
    Object localObject = new File(this.mX5CorePath, "count.prop");
    if (!((File)localObject).exists())
    {
      setCountProp(1);
      return true;
    }
    try
    {
      localObject = new FileInputStream((File)localObject);
      try
      {
        Properties localProperties = new Properties();
        localProperties.load((InputStream)localObject);
        int i = Integer.valueOf(localProperties.getProperty(getCalledCountKey(), "1")).intValue();
        QbSdkLog.d("X5CoreNeedReboot", "SDKEngine--isRebootCalledTimesOK count_int = " + i);
        mRebootCalledTimes = i;
        if (i > mRebootCalledTimesMax) {
          break label162;
        }
        localProperties.setProperty(getCalledCountKey(), String.valueOf(i + 1));
        localProperties.store(new FileOutputStream(new File(this.mX5CorePath, "count.prop")), null);
        return true;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      label156:
      label162:
      break label156;
    }
    localException1.printStackTrace();
    return false;
    return false;
  }
  
  /* Error */
  private boolean needDexOptimize(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 168	com/tencent/smtt/sdk/SDKEngine:mX5CorePath	Ljava/io/File;
    //   4: invokevirtual 509	java/io/File:listFiles	()[Ljava/io/File;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +9 -> 18
    //   12: aload_1
    //   13: arraylength
    //   14: iconst_1
    //   15: if_icmpgt +5 -> 20
    //   18: iconst_1
    //   19: ireturn
    //   20: new 317	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 168	com/tencent/smtt/sdk/SDKEngine:mX5CorePath	Ljava/io/File;
    //   28: ldc 54
    //   30: invokespecial 442	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 445	java/io/File:exists	()Z
    //   38: ifeq -20 -> 18
    //   41: aconst_null
    //   42: astore_1
    //   43: aconst_null
    //   44: astore 4
    //   46: new 447	java/io/FileInputStream
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 450	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_3
    //   55: new 410	java/util/Properties
    //   58: dup
    //   59: invokespecial 422	java/util/Properties:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 426	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   68: aload_1
    //   69: ldc 29
    //   71: invokevirtual 452	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +15 -> 91
    //   79: aload_1
    //   80: invokestatic 512	com/tencent/smtt/sdk/QbSdk:getX5CoreTimestamp	()Ljava/lang/String;
    //   83: invokevirtual 516	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   86: istore_2
    //   87: iload_2
    //   88: ifne +20 -> 108
    //   91: aload_3
    //   92: ifnull -74 -> 18
    //   95: aload_3
    //   96: invokevirtual 451	java/io/FileInputStream:close	()V
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   106: iconst_1
    //   107: ireturn
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 451	java/io/FileInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_1
    //   127: aload 4
    //   129: astore_3
    //   130: aload_1
    //   131: astore 4
    //   133: aload_3
    //   134: astore_1
    //   135: aload 4
    //   137: invokevirtual 392	java/lang/Exception:printStackTrace	()V
    //   140: aload_3
    //   141: ifnull -123 -> 18
    //   144: aload_3
    //   145: invokevirtual 451	java/io/FileInputStream:close	()V
    //   148: iconst_1
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: astore_3
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 451	java/io/FileInputStream:close	()V
    //   166: aload_3
    //   167: athrow
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore 4
    //   178: aload_3
    //   179: astore_1
    //   180: aload 4
    //   182: astore_3
    //   183: goto -25 -> 158
    //   186: astore 4
    //   188: goto -55 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	SDKEngine
    //   0	191	1	paramContext	Context
    //   86	2	2	bool	boolean
    //   33	112	3	localObject1	Object
    //   157	22	3	localObject2	Object
    //   182	1	3	localObject3	Object
    //   44	92	4	localContext	Context
    //   176	5	4	localObject4	Object
    //   186	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   95	99	101	java/io/IOException
    //   112	116	118	java/io/IOException
    //   46	55	126	java/lang/Exception
    //   144	148	150	java/io/IOException
    //   46	55	157	finally
    //   135	140	157	finally
    //   162	166	168	java/io/IOException
    //   55	75	176	finally
    //   79	87	176	finally
    //   55	75	186	java/lang/Exception
    //   79	87	186	java/lang/Exception
  }
  
  private void setCountProp(int paramInt)
  {
    QbSdkLog.d("X5CoreNeedReboot", "SDKEngine--setCountProp i = " + paramInt);
    Properties localProperties = new Properties();
    localProperties.setProperty(getCalledCountKey(), String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.mX5CorePath, "count.prop")), null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  void checkX5CoreInstalled()
  {
    mX5CoreInstalled = false;
    this.mUIHandler.sendEmptyMessageDelayed(101, checkTimeDelay);
    QbSdkLog.d("X5CoreNeedReboot", "SDKEngine--checkX5CoreInstalled()--MSG_CHECK_X5CORE_INSTALLED");
  }
  
  public boolean getX5CoreNeedReboot()
  {
    if (isX5Core()) {}
    boolean bool;
    do
    {
      return false;
      if ((!mQBTimesTampDiff) && (!mDexDone) && (!mX5CoreInstalled)) {
        break label103;
      }
      bool = true;
      QbSdkLog.d("X5CoreNeedReboot", "SDKEngine--getX5CoreNeedReboot  mQBTimesTampDiff = " + mQBTimesTampDiff + " mDexDone = " + mDexDone + " mX5CoreInstalled = " + mX5CoreInstalled);
      if (!bool) {
        break;
      }
      if (getX5CoreNeedRebootCalled) {
        break label108;
      }
      getX5CoreNeedRebootCalled = true;
    } while (!isRebootCalledTimesOK());
    label103:
    label108:
    while (mRebootCalledTimes < mRebootCalledTimesMax)
    {
      return bool;
      bool = false;
      break;
    }
    return false;
  }
  
  public void init(Context paramContext)
  {
    label328:
    for (;;)
    {
      boolean bool1;
      try
      {
        this.mContext = paramContext.getApplicationContext();
        iInitCount += 1;
        this.mX5CorePath = paramContext.getDir("x5core", 0);
        bool1 = QbSdk.canLoadX5(paramContext);
        initX5CoreVersionIfNeed(paramContext);
        if (mCoreVersion < 25102)
        {
          bool1 = false;
          if (mCoreVersion != 0) {
            QbSdkLog.e("QbSdk", "sys WebView: version too low");
          }
        }
        else
        {
          if (!isCompatible(mCoreVersion, this.mX5CorePath.toString()))
          {
            bool1 = false;
            QbSdk.forceSysWebViewInner();
            QbSdkLog.e("QbSdk", "sys WebView: not Compatible");
          }
          if (!bool1) {
            break label705;
          }
          if (!needDexOptimize(paramContext)) {
            break label206;
          }
          doDexOptimize(paramContext);
          this.mWizard = new WebViewWizardBase();
          this.mUsedX5 = false;
          this.mWizard.setWizardMode(false, false);
          QbSdkLog.e("QbSdk", "sys WebView: need dexopt");
          if (!this.mUsedX5)
          {
            mQBTimestampStart = getQBAssetTimestamp(paramContext);
            QbSdkLog.d("X5CoreNeedReboot", "SDKEngine--init()--mQBTimestampStart=" + mQBTimestampStart);
          }
          return;
        }
        QbSdkLog.i("QbSdk", "sys WebView: no x5");
        continue;
        bool1 = this.mUsedX5;
      }
      finally {}
      label206:
      if (!bool1)
      {
        try
        {
          if (paramContext.getPackageManager().getPackageInfo(X5QQBROWSER_PKG_NAME, 64).signatures[0].toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
            break label328;
          }
          this.mUsedX5 = false;
          this.mWizard = new WebViewWizardBase();
          this.mWizard.setWizardMode(false, false);
          QbSdk.forceSysWebViewInner();
          QbSdkLog.e("QbSdk", "sys WebView: signature check failed");
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          this.mUsedX5 = false;
          this.mWizard = new WebViewWizardBase();
          this.mWizard.setWizardMode(false, false);
          QbSdk.forceSysWebViewInner();
          QbSdkLog.e("QbSdk", "sys WebView: check sig exception");
        }
        continue;
        this.mWizard = new WebViewWizardBase();
        this.mWizard.setWizardMode(true, true);
        Context localContext = getPackageContext(paramContext, X5QQBROWSER_PKG_NAME);
        if (localContext == null)
        {
          this.mUsedX5 = false;
          this.mWizard.setWizardMode(false, false);
          QbSdk.forceSysWebViewInner();
          QbSdkLog.e("QbSdk", "sys WebView: null x5 context");
        }
        else
        {
          bool1 = false;
          try
          {
            this.mBrowserX5SharePath = localContext.getDir("x5_share", 0);
            this.mBrowserX5CorePath = new File(this.mBrowserX5SharePath, "x5core");
            WebViewWizardBase localWebViewWizardBase = this.mWizard;
            String str1 = new File(this.mBrowserX5SharePath, "webview_interfaces_dex.jar").getAbsolutePath();
            String str2 = new File(this.mBrowserX5CorePath, "webview_dex.jar").getAbsolutePath();
            String str3 = this.mX5CorePath.getAbsolutePath();
            localWebViewWizardBase.setDexLoader(paramContext, new String[] { str1, str2 }, str3);
            this.mSoPath = new File(getCurrentNativeLibraryDir(localContext));
            libwebp.loadWepLibraryIfNeed(paramContext, this.mSoPath.getAbsolutePath());
            this.mWizard.setContextHolderDevelopMode(true);
            boolean bool2 = this.mWizard.setContextHolderParams(paramContext, this.mSoPath.getAbsolutePath());
            bool1 = bool2;
            if (!bool1)
            {
              this.mUsedX5 = false;
              this.mWizard.setContextHolderDevelopMode(false);
              this.mWizard.setWizardMode(false, false);
              QbSdk.forceSysWebViewInner();
              QbSdkLog.e("QbSdk", "sys WebView: failed to load so.");
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
              QbSdkLog.e("QbSdk", "sys WebView: exception while loading so.");
            }
            if (iInitCount == 1)
            {
              this.mWizard.setContextHolderDevelopMode(true);
              this.mWizard.setSdkVersion(1);
              this.mWizard.initCookieModule(paramContext);
              this.mWizard.SmttResource_UpdateContext(localContext);
              this.mUsedX5 = true;
              continue;
            }
            this.mWizard = new WebViewWizardBase();
            this.mUsedX5 = false;
            this.mWizard.setWizardMode(false, false);
            QbSdk.forceSysWebViewInner();
            QbSdkLog.e("QbSdk", "sys WebView: not first time.");
            this.mWizard.SmttResource_UpdateContext(null);
          }
          continue;
          this.mWizard = new WebViewWizardBase();
          this.mUsedX5 = false;
          this.mWizard.setWizardMode(false, false);
          QbSdkLog.e("QbSdk", "canload5 is false.");
        }
      }
    }
  }
  
  public boolean isX5Core()
  {
    return this.mUsedX5;
  }
  
  public WebViewWizardBase wizard()
  {
    return this.mWizard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SDKEngine
 * JD-Core Version:    0.7.0.1
 */