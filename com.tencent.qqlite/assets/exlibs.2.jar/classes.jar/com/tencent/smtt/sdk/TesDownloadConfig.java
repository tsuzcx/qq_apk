package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class TesDownloadConfig
{
  private static final String LOGTAG = "TesDownloadConfig";
  private static final String TES_CFG_FILE = "tes_download_config.prop";
  private static final String TES_CFG_PATH = "tes_private";
  public static final long TES_CONFIG_CHECK_PERIOD = 86400000L;
  private static TesDownloadConfig mInstance;
  public String mAppMetadata;
  public int mAppVersionCode;
  public String mAppVersionName;
  private File mConfigFile;
  public String mDownloadUrl = null;
  public long mLastCheckTime;
  public int mLastError = 0;
  public boolean mLastSecuritySwitch = false;
  public String mLastUrl;
  public boolean mNeedDownload = false;
  private int mResponseCode = 0;
  public Map<String, Object> mSyncMap = new HashMap();
  public int mTesVersion;
  private boolean mX5Disabled = false;
  
  public static TesDownloadConfig getInstance()
  {
    try
    {
      TesDownloadConfig localTesDownloadConfig = mInstance;
      return localTesDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TesDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
      {
        Log.e("TesDownloadConfig", "TesDownloadConfig getInstance");
        mInstance = new TesDownloadConfig();
        mInstance.loadConfig(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void loadConfig(Context paramContext)
  {
    // Byte code:
    //   0: ldc 11
    //   2: ldc 87
    //   4: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aload_0
    //   9: new 89	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 95	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: ldc 17
    //   19: iconst_0
    //   20: invokevirtual 99	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   23: ldc 14
    //   25: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: putfield 104	com/tencent/smtt/sdk/TesDownloadConfig:mConfigFile	Ljava/io/File;
    //   31: aconst_null
    //   32: astore_3
    //   33: aconst_null
    //   34: astore_2
    //   35: aconst_null
    //   36: astore 4
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 104	com/tencent/smtt/sdk/TesDownloadConfig:mConfigFile	Ljava/io/File;
    //   44: invokevirtual 108	java/io/File:exists	()Z
    //   47: ifne +35 -> 82
    //   50: aload_2
    //   51: astore_1
    //   52: ldc 11
    //   54: ldc 110
    //   56: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   59: pop
    //   60: aload_2
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 104	com/tencent/smtt/sdk/TesDownloadConfig:mConfigFile	Ljava/io/File;
    //   66: invokevirtual 113	java/io/File:createNewFile	()Z
    //   69: pop
    //   70: aload 4
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 118	java/io/FileInputStream:close	()V
    //   81: return
    //   82: aload_2
    //   83: astore_1
    //   84: new 120	java/util/Properties
    //   87: dup
    //   88: invokespecial 121	java/util/Properties:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: astore_1
    //   95: new 115	java/io/FileInputStream
    //   98: dup
    //   99: aload_0
    //   100: getfield 104	com/tencent/smtt/sdk/TesDownloadConfig:mConfigFile	Ljava/io/File;
    //   103: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: astore_2
    //   107: aload 4
    //   109: aload_2
    //   110: invokevirtual 128	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   113: aload_0
    //   114: aload 4
    //   116: ldc 130
    //   118: ldc 132
    //   120: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 142	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   126: putfield 144	com/tencent/smtt/sdk/TesDownloadConfig:mLastCheckTime	J
    //   129: aload_0
    //   130: aload 4
    //   132: ldc 146
    //   134: invokevirtual 149	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokestatic 155	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   140: putfield 50	com/tencent/smtt/sdk/TesDownloadConfig:mX5Disabled	Z
    //   143: aload_0
    //   144: aload 4
    //   146: ldc 157
    //   148: ldc 132
    //   150: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   153: invokestatic 163	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: putfield 165	com/tencent/smtt/sdk/TesDownloadConfig:mTesVersion	I
    //   159: aload_0
    //   160: aload 4
    //   162: ldc 167
    //   164: invokevirtual 149	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokestatic 155	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   170: putfield 52	com/tencent/smtt/sdk/TesDownloadConfig:mNeedDownload	Z
    //   173: aload_0
    //   174: aload 4
    //   176: ldc 169
    //   178: ldc 171
    //   180: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   183: putfield 54	com/tencent/smtt/sdk/TesDownloadConfig:mDownloadUrl	Ljava/lang/String;
    //   186: aload_0
    //   187: aload 4
    //   189: ldc 173
    //   191: ldc 132
    //   193: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 163	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   199: putfield 58	com/tencent/smtt/sdk/TesDownloadConfig:mResponseCode	I
    //   202: aload_0
    //   203: aload 4
    //   205: ldc 175
    //   207: ldc 171
    //   209: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 177	com/tencent/smtt/sdk/TesDownloadConfig:mLastUrl	Ljava/lang/String;
    //   215: aload_0
    //   216: aload 4
    //   218: ldc 179
    //   220: ldc 132
    //   222: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   225: invokestatic 163	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   228: putfield 56	com/tencent/smtt/sdk/TesDownloadConfig:mLastError	I
    //   231: aload_0
    //   232: aload 4
    //   234: ldc 181
    //   236: ldc 171
    //   238: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 183	com/tencent/smtt/sdk/TesDownloadConfig:mAppVersionName	Ljava/lang/String;
    //   244: aload_0
    //   245: aload 4
    //   247: ldc 185
    //   249: ldc 132
    //   251: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: invokestatic 163	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   257: putfield 187	com/tencent/smtt/sdk/TesDownloadConfig:mAppVersionCode	I
    //   260: aload_0
    //   261: aload 4
    //   263: ldc 189
    //   265: ldc 171
    //   267: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: putfield 191	com/tencent/smtt/sdk/TesDownloadConfig:mAppMetadata	Ljava/lang/String;
    //   273: aload_0
    //   274: aload 4
    //   276: ldc 193
    //   278: ldc 195
    //   280: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   283: invokestatic 155	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   286: putfield 48	com/tencent/smtt/sdk/TesDownloadConfig:mLastSecuritySwitch	Z
    //   289: ldc 11
    //   291: new 197	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   298: ldc 200
    //   300: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 4
    //   305: ldc 130
    //   307: invokevirtual 149	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 206
    //   315: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 4
    //   320: ldc 193
    //   322: invokevirtual 149	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   325: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   334: pop
    //   335: aload_2
    //   336: astore_1
    //   337: goto -264 -> 73
    //   340: astore_1
    //   341: ldc 11
    //   343: new 197	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   350: ldc 212
    //   352: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   368: pop
    //   369: return
    //   370: astore_1
    //   371: aload_3
    //   372: astore_2
    //   373: aload_1
    //   374: astore_3
    //   375: aload_2
    //   376: astore_1
    //   377: ldc 11
    //   379: new 197	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   386: ldc 217
    //   388: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_3
    //   392: invokevirtual 218	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   395: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   404: pop
    //   405: aload_2
    //   406: ifnull -325 -> 81
    //   409: aload_2
    //   410: invokevirtual 118	java/io/FileInputStream:close	()V
    //   413: return
    //   414: astore_1
    //   415: ldc 11
    //   417: new 197	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   424: ldc 212
    //   426: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   433: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   442: pop
    //   443: return
    //   444: astore_2
    //   445: aload_1
    //   446: ifnull +7 -> 453
    //   449: aload_1
    //   450: invokevirtual 118	java/io/FileInputStream:close	()V
    //   453: aload_2
    //   454: athrow
    //   455: astore_1
    //   456: ldc 11
    //   458: new 197	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   465: ldc 212
    //   467: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_1
    //   471: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   483: pop
    //   484: goto -31 -> 453
    //   487: astore_3
    //   488: aload_2
    //   489: astore_1
    //   490: aload_3
    //   491: astore_2
    //   492: goto -47 -> 445
    //   495: astore_3
    //   496: goto -121 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	TesDownloadConfig
    //   0	499	1	paramContext	Context
    //   34	376	2	localObject1	Object
    //   444	45	2	localObject2	Object
    //   491	1	2	localObject3	Object
    //   32	360	3	localContext	Context
    //   487	4	3	localObject4	Object
    //   495	1	3	localException	java.lang.Exception
    //   36	283	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   77	81	340	java/io/IOException
    //   40	50	370	java/lang/Exception
    //   52	60	370	java/lang/Exception
    //   62	70	370	java/lang/Exception
    //   84	93	370	java/lang/Exception
    //   95	107	370	java/lang/Exception
    //   409	413	414	java/io/IOException
    //   40	50	444	finally
    //   52	60	444	finally
    //   62	70	444	finally
    //   84	93	444	finally
    //   95	107	444	finally
    //   377	405	444	finally
    //   449	453	455	java/io/IOException
    //   107	335	487	finally
    //   107	335	495	java/lang/Exception
  }
  
  private void syncMemory(String paramString, Object paramObject)
  {
    if ("last_check".equals(paramString)) {
      this.mLastCheckTime = ((Long)paramObject).longValue();
    }
    do
    {
      return;
      if ("x5_disabled".equals(paramString))
      {
        this.mX5Disabled = ((Boolean)paramObject).booleanValue();
        return;
      }
      if ("tes_version".equals(paramString))
      {
        this.mTesVersion = ((Integer)paramObject).intValue();
        return;
      }
      if ("tes_needdownload".equals(paramString))
      {
        this.mNeedDownload = ((Boolean)paramObject).booleanValue();
        return;
      }
      if ("tes_downloadurl".equals(paramString))
      {
        this.mDownloadUrl = ((String)paramObject);
        return;
      }
      if ("tes_responsecode".equals(paramString))
      {
        this.mResponseCode = ((Integer)paramObject).intValue();
        return;
      }
      if ("tes_lasturl".equals(paramString))
      {
        this.mLastUrl = ((String)paramObject);
        return;
      }
      if ("tes_lasterror".equals(paramString))
      {
        this.mLastError = ((Integer)paramObject).intValue();
        return;
      }
      if ("app_versionname".equals(paramString))
      {
        this.mAppVersionName = ((String)paramObject);
        return;
      }
      if ("app_versioncode".equals(paramString))
      {
        this.mAppVersionCode = ((Integer)paramObject).intValue();
        return;
      }
      if ("app_metadata".equals(paramString))
      {
        this.mAppMetadata = ((String)paramObject);
        return;
      }
    } while (!"security_switch".equals(paramString));
    this.mLastSecuritySwitch = ((Boolean)paramObject).booleanValue();
  }
  
  /* Error */
  public void commit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore_2
    //   12: new 120	java/util/Properties
    //   15: dup
    //   16: invokespecial 121	java/util/Properties:<init>	()V
    //   19: astore 6
    //   21: new 115	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: getfield 104	com/tencent/smtt/sdk/TesDownloadConfig:mConfigFile	Ljava/io/File;
    //   29: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: aload 6
    //   35: aload_1
    //   36: invokevirtual 128	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   39: new 240	java/io/FileOutputStream
    //   42: dup
    //   43: aload_0
    //   44: getfield 104	com/tencent/smtt/sdk/TesDownloadConfig:mConfigFile	Ljava/io/File;
    //   47: invokespecial 241	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_2
    //   51: aload_0
    //   52: getfield 63	com/tencent/smtt/sdk/TesDownloadConfig:mSyncMap	Ljava/util/Map;
    //   55: invokeinterface 247 1 0
    //   60: invokeinterface 253 1 0
    //   65: astore_3
    //   66: aload_3
    //   67: invokeinterface 258 1 0
    //   72: ifeq +71 -> 143
    //   75: aload_3
    //   76: invokeinterface 262 1 0
    //   81: checkcast 222	java/lang/String
    //   84: astore 4
    //   86: aload_0
    //   87: getfield 63	com/tencent/smtt/sdk/TesDownloadConfig:mSyncMap	Ljava/util/Map;
    //   90: aload 4
    //   92: invokeinterface 266 2 0
    //   97: astore 5
    //   99: aload_0
    //   100: aload 4
    //   102: aload 5
    //   104: invokespecial 268	com/tencent/smtt/sdk/TesDownloadConfig:syncMemory	(Ljava/lang/String;Ljava/lang/Object;)V
    //   107: aload 6
    //   109: aload 4
    //   111: aload 5
    //   113: invokestatic 272	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 276	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   119: pop
    //   120: goto -54 -> 66
    //   123: astore_3
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 118	java/io/FileInputStream:close	()V
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: aload_0
    //   144: getfield 63	com/tencent/smtt/sdk/TesDownloadConfig:mSyncMap	Ljava/util/Map;
    //   147: invokeinterface 280 1 0
    //   152: aload 6
    //   154: aload_2
    //   155: aconst_null
    //   156: invokevirtual 284	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 118	java/io/FileInputStream:close	()V
    //   167: aload_2
    //   168: ifnull +95 -> 263
    //   171: aload_2
    //   172: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   175: goto -35 -> 140
    //   178: astore_1
    //   179: goto -39 -> 140
    //   182: astore_2
    //   183: aload 5
    //   185: astore_1
    //   186: aload_1
    //   187: ifnull +7 -> 194
    //   190: aload_1
    //   191: invokevirtual 118	java/io/FileInputStream:close	()V
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   202: aload_2
    //   203: athrow
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    //   209: astore_1
    //   210: goto -43 -> 167
    //   213: astore_1
    //   214: goto -82 -> 132
    //   217: astore_1
    //   218: goto -78 -> 140
    //   221: astore_1
    //   222: goto -28 -> 194
    //   225: astore_1
    //   226: goto -24 -> 202
    //   229: astore_2
    //   230: goto -44 -> 186
    //   233: astore 4
    //   235: aload_2
    //   236: astore_3
    //   237: aload 4
    //   239: astore_2
    //   240: goto -54 -> 186
    //   243: astore_1
    //   244: aload_2
    //   245: astore_1
    //   246: aload 4
    //   248: astore_2
    //   249: goto -125 -> 124
    //   252: astore_2
    //   253: aload 4
    //   255: astore_2
    //   256: goto -132 -> 124
    //   259: astore_1
    //   260: goto -55 -> 205
    //   263: goto -123 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	TesDownloadConfig
    //   32	132	1	localFileInputStream	java.io.FileInputStream
    //   178	1	1	localIOException1	java.io.IOException
    //   185	6	1	localObject1	Object
    //   204	4	1	localObject2	Object
    //   209	1	1	localIOException2	java.io.IOException
    //   213	1	1	localIOException3	java.io.IOException
    //   217	1	1	localIOException4	java.io.IOException
    //   221	1	1	localIOException5	java.io.IOException
    //   225	1	1	localIOException6	java.io.IOException
    //   243	1	1	localException1	java.lang.Exception
    //   245	1	1	localObject3	Object
    //   259	1	1	localObject4	Object
    //   11	161	2	localFileOutputStream	java.io.FileOutputStream
    //   182	21	2	localObject5	Object
    //   229	7	2	localObject6	Object
    //   239	10	2	localObject7	Object
    //   252	1	2	localException2	java.lang.Exception
    //   255	1	2	localObject8	Object
    //   3	73	3	localIterator	java.util.Iterator
    //   123	76	3	localException3	java.lang.Exception
    //   236	1	3	localObject9	Object
    //   5	105	4	str	String
    //   233	21	4	localObject10	Object
    //   8	176	5	localObject11	Object
    //   19	134	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   51	66	123	java/lang/Exception
    //   66	120	123	java/lang/Exception
    //   143	159	123	java/lang/Exception
    //   171	175	178	java/io/IOException
    //   12	33	182	finally
    //   128	132	204	finally
    //   136	140	204	finally
    //   190	194	204	finally
    //   198	202	204	finally
    //   202	204	204	finally
    //   163	167	209	java/io/IOException
    //   128	132	213	java/io/IOException
    //   136	140	217	java/io/IOException
    //   190	194	221	java/io/IOException
    //   198	202	225	java/io/IOException
    //   33	51	229	finally
    //   51	66	233	finally
    //   66	120	233	finally
    //   143	159	233	finally
    //   12	33	243	java/lang/Exception
    //   33	51	252	java/lang/Exception
    //   163	167	259	finally
    //   171	175	259	finally
  }
  
  public static abstract interface TesConfigKey
  {
    public static final String KEY_APP_METADATA = "app_metadata";
    public static final String KEY_APP_VERSIONCODE = "app_versioncode";
    public static final String KEY_APP_VERSIONNAME = "app_versionname";
    public static final String KEY_LASTERR = "tes_lasterror";
    public static final String KEY_LASTURL = "tes_lasturl";
    public static final String KEY_LAST_CHECK = "last_check";
    public static final String KEY_NEEDDOWNLOAD = "tes_needdownload";
    public static final String KEY_RESPONSECODE = "tes_responsecode";
    public static final String KEY_SECURITY_SWITCH = "security_switch";
    public static final String KEY_TESDOWNLOADURL = "tes_downloadurl";
    public static final String KEY_TESV = "tes_version";
    public static final String KEY_X5_DISABLED = "x5_disabled";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TesDownloadConfig
 * JD-Core Version:    0.7.0.1
 */