package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.libwebp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class SDKEngine
{
  private static final int MSG_CLEAR_DEXOPT_THREAD = 100;
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  private static final String STR_TIMESTAMP = "timestamp";
  public static final String X5QQBROWSER_PKG_NAME = "com.tencent.mtt";
  public static final String X5_CONF = "qbx5.conf";
  public static final String X5_CONF_CORE_VER = "browser_core_version";
  public static final String X5_CORE_FOLDER_NAME = "x5core";
  public static final String X5_FILE_DEX = "webview_dex.jar";
  public static final String X5_FILE_INTERFACES_DEX = "webview_interfaces_dex.jar";
  public static final String X5_PROPERTIES = "x5.prop";
  public static final String X5_SHARE_FOLDER_NAME = "x5_share";
  public static final String X5_SO = "libmttwebcore.so";
  private static int iInitCount = 0;
  private static boolean isCompatibleChecked = false;
  private static int mCoreVersion = 0;
  private static SDKEngine mInstance = null;
  private static final int sMinSupportCoreVersion = 25102;
  private File mBrowserX5CorePath = null;
  private File mBrowserX5SharePath = null;
  private Handler mDexHandler = null;
  private HandlerThread mDexHandlerThread = null;
  private File mSoPath = null;
  private Handler mUIHandler = null;
  private boolean mUsedX5 = false;
  private WebViewWizardBase mWizard = null;
  private File mX5CorePath = null;
  
  static
  {
    mCoreVersion = 0;
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
      this.mDexHandler.post(new Runnable()
      {
        public void run()
        {
          WebViewWizardBase localWebViewWizardBase = new WebViewWizardBase();
          localWebViewWizardBase.setWizardMode(true, true);
          Context localContext = SDKEngine.this.getPackageContext(paramContext, "com.tencent.mtt");
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
      });
    }
  }
  
  public static SDKEngine getInstance(boolean paramBoolean)
  {
    if ((mInstance == null) && (paramBoolean)) {
      mInstance = new SDKEngine();
    }
    return mInstance;
  }
  
  private Context getPackageContext(Context paramContext, String paramString)
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
  
  public static int getQQBrowserCoreVersion()
  {
    return mCoreVersion;
  }
  
  /* Error */
  private void initX5CoreVersionIfNeed(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 73	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aload 4
    //   14: astore_2
    //   15: aload_0
    //   16: aload_1
    //   17: ldc 21
    //   19: invokespecial 124	com/tencent/smtt/sdk/SDKEngine:getPackageContext	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Context;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnonnull +21 -> 45
    //   27: iconst_0
    //   28: ifeq -22 -> 6
    //   31: new 175	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 176	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   44: return
    //   45: aload 4
    //   47: astore_2
    //   48: new 179	java/io/File
    //   51: dup
    //   52: new 179	java/io/File
    //   55: dup
    //   56: aload_1
    //   57: ldc 42
    //   59: iconst_0
    //   60: invokevirtual 183	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   63: ldc 30
    //   65: invokespecial 186	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   68: ldc 24
    //   70: invokespecial 186	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore_1
    //   74: aload 4
    //   76: astore_2
    //   77: new 188	java/util/Properties
    //   80: dup
    //   81: invokespecial 189	java/util/Properties:<init>	()V
    //   84: astore 5
    //   86: aload 4
    //   88: astore_2
    //   89: new 191	java/io/FileInputStream
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: astore_1
    //   98: aload 5
    //   100: aload_1
    //   101: invokevirtual 198	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   104: aload_1
    //   105: invokevirtual 201	java/io/FileInputStream:close	()V
    //   108: aload 5
    //   110: ldc 27
    //   112: invokevirtual 205	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_2
    //   116: aload_2
    //   117: ifnonnull +18 -> 135
    //   120: aload_1
    //   121: ifnull -115 -> 6
    //   124: aload_1
    //   125: invokevirtual 201	java/io/FileInputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   134: return
    //   135: aload_2
    //   136: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   139: putstatic 73	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   142: aload_1
    //   143: ifnull +77 -> 220
    //   146: aload_1
    //   147: invokevirtual 201	java/io/FileInputStream:close	()V
    //   150: return
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   156: return
    //   157: astore_2
    //   158: aload_3
    //   159: astore_1
    //   160: aload_2
    //   161: astore_3
    //   162: aload_1
    //   163: astore_2
    //   164: aload_3
    //   165: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   168: aload_1
    //   169: astore_2
    //   170: iconst_0
    //   171: putstatic 73	com/tencent/smtt/sdk/SDKEngine:mCoreVersion	I
    //   174: aload_1
    //   175: ifnull -169 -> 6
    //   178: aload_1
    //   179: invokevirtual 201	java/io/FileInputStream:close	()V
    //   182: return
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   188: return
    //   189: astore_1
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 201	java/io/FileInputStream:close	()V
    //   198: aload_1
    //   199: athrow
    //   200: astore_2
    //   201: aload_2
    //   202: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   205: goto -7 -> 198
    //   208: astore_3
    //   209: aload_1
    //   210: astore_2
    //   211: aload_3
    //   212: astore_1
    //   213: goto -23 -> 190
    //   216: astore_3
    //   217: goto -55 -> 162
    //   220: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	SDKEngine
    //   0	221	1	paramContext	Context
    //   14	122	2	localObject1	Object
    //   157	4	2	localException1	Exception
    //   163	32	2	localContext1	Context
    //   200	2	2	localIOException	IOException
    //   210	1	2	localContext2	Context
    //   11	154	3	localObject2	Object
    //   208	4	3	localObject3	Object
    //   216	1	3	localException2	Exception
    //   8	79	4	localObject4	Object
    //   84	25	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   31	39	39	java/io/IOException
    //   124	128	129	java/io/IOException
    //   146	150	151	java/io/IOException
    //   15	23	157	java/lang/Exception
    //   48	74	157	java/lang/Exception
    //   77	86	157	java/lang/Exception
    //   89	98	157	java/lang/Exception
    //   178	182	183	java/io/IOException
    //   15	23	189	finally
    //   48	74	189	finally
    //   77	86	189	finally
    //   89	98	189	finally
    //   164	168	189	finally
    //   170	174	189	finally
    //   194	198	200	java/io/IOException
    //   98	116	208	finally
    //   135	142	208	finally
    //   98	116	216	java/lang/Exception
    //   135	142	216	java/lang/Exception
  }
  
  private static boolean isCompatible(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (!isCompatibleChecked)
        {
          bool1 = bool2;
          if (paramInt <= 25206)
          {
            bool1 = bool2;
            if (paramInt >= 25200)
            {
              if (paramString.indexOf("/com.tencent.mm/") > 0) {
                break label79;
              }
              bool1 = bool2;
              if (paramString.indexOf("/com.qzone/") > 0) {
                break label79;
              }
            }
          }
          isCompatibleChecked = true;
        }
        else
        {
          return bool1;
        }
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
      label79:
      bool1 = false;
    }
  }
  
  /* Error */
  private boolean needDexOptimize(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/tencent/smtt/sdk/SDKEngine:mX5CorePath	Ljava/io/File;
    //   4: invokevirtual 231	java/io/File:listFiles	()[Ljava/io/File;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +9 -> 18
    //   12: aload_1
    //   13: arraylength
    //   14: iconst_1
    //   15: if_icmpgt +5 -> 20
    //   18: iconst_1
    //   19: ireturn
    //   20: new 179	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 85	com/tencent/smtt/sdk/SDKEngine:mX5CorePath	Ljava/io/File;
    //   28: ldc 39
    //   30: invokespecial 186	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 235	java/io/File:exists	()Z
    //   38: ifeq -20 -> 18
    //   41: aconst_null
    //   42: astore_1
    //   43: aconst_null
    //   44: astore 4
    //   46: new 191	java/io/FileInputStream
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_3
    //   55: new 188	java/util/Properties
    //   58: dup
    //   59: invokespecial 189	java/util/Properties:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 198	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   68: aload_1
    //   69: ldc 18
    //   71: invokevirtual 205	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +15 -> 91
    //   79: aload_1
    //   80: invokestatic 241	com/tencent/smtt/sdk/QbSdk:getX5CoreTimestamp	()Ljava/lang/String;
    //   83: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   86: istore_2
    //   87: iload_2
    //   88: ifne +20 -> 108
    //   91: aload_3
    //   92: ifnull -74 -> 18
    //   95: aload_3
    //   96: invokevirtual 201	java/io/FileInputStream:close	()V
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   106: iconst_1
    //   107: ireturn
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 201	java/io/FileInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_1
    //   127: aload 4
    //   129: astore_3
    //   130: aload_1
    //   131: astore 4
    //   133: aload_3
    //   134: astore_1
    //   135: aload 4
    //   137: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   140: aload_3
    //   141: ifnull -123 -> 18
    //   144: aload_3
    //   145: invokevirtual 201	java/io/FileInputStream:close	()V
    //   148: iconst_1
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: astore_3
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 201	java/io/FileInputStream:close	()V
    //   166: aload_3
    //   167: athrow
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 177	java/io/IOException:printStackTrace	()V
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
  
  public void init(Context paramContext)
  {
    for (;;)
    {
      boolean bool1;
      try
      {
        iInitCount += 1;
        this.mX5CorePath = paramContext.getDir("x5core", 0);
        bool1 = QbSdk.canLoadX5(paramContext);
        initX5CoreVersionIfNeed(paramContext);
        if (mCoreVersion < 25102) {
          bool1 = false;
        }
        if (!isCompatible(mCoreVersion, this.mX5CorePath.toString()))
        {
          bool1 = false;
          QbSdk.forceSysWebView(true);
        }
        if (!bool1) {
          break label557;
        }
        if (needDexOptimize(paramContext))
        {
          doDexOptimize(paramContext);
          this.mWizard = new WebViewWizardBase();
          this.mUsedX5 = false;
          this.mWizard.setWizardMode(false, false);
          return;
        }
        bool1 = this.mUsedX5;
        if (bool1) {
          continue;
        }
        try
        {
          if (paramContext.getPackageManager().getPackageInfo("com.tencent.mtt", 64).signatures[0].toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
            break label219;
          }
          this.mUsedX5 = false;
          this.mWizard = new WebViewWizardBase();
          this.mWizard.setWizardMode(false, false);
          QbSdk.forceSysWebView(true);
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          this.mUsedX5 = false;
          this.mWizard = new WebViewWizardBase();
          this.mWizard.setWizardMode(false, false);
          QbSdk.forceSysWebView(true);
        }
        continue;
        this.mWizard = new WebViewWizardBase();
      }
      finally {}
      label219:
      this.mWizard.setWizardMode(true, true);
      Context localContext = getPackageContext(paramContext, "com.tencent.mtt");
      if (localContext == null)
      {
        this.mUsedX5 = false;
        this.mWizard.setWizardMode(false, false);
        QbSdk.forceSysWebView(true);
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
          this.mSoPath = new File(localContext.getApplicationInfo().nativeLibraryDir);
          libwebp.loadWepLibraryIfNeed(paramContext, this.mSoPath.getAbsolutePath());
          this.mWizard.setContextHolderDevelopMode(true);
          boolean bool2 = this.mWizard.setContextHolderParams(paramContext, this.mSoPath.getAbsolutePath());
          bool1 = bool2;
          if (!bool1)
          {
            this.mUsedX5 = false;
            this.mWizard.setContextHolderDevelopMode(false);
            this.mWizard.setWizardMode(false, false);
            QbSdk.forceSysWebView(true);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
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
          QbSdk.forceSysWebView(true);
        }
        continue;
        label557:
        this.mWizard = new WebViewWizardBase();
        this.mUsedX5 = false;
        this.mWizard.setWizardMode(false, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.SDKEngine
 * JD-Core Version:    0.7.0.1
 */