package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class TbsConfigFile
{
  private static final String COMMON_CONFIG_FILE = "debug.conf";
  private static final String KEY_TBS_FORCE_USE_QQ_PROXY = "setting_froceUseQProxy";
  private static final String KEY_TBS_FORCE_USE_QQ_PROXY_RESULT = "result_QProxy";
  private static final String KEY_TBS_FORCE_USE_SYSTEMWEBVIEW = "setting_forceUseSystemWebview";
  private static final String KEY_TBS_FORCE_USE_SYSTEMWEBVIEW_RESULT = "result_systemWebviewForceUsed";
  static final String TBS_FOLDER_NAME = "tbs";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  private static TbsConfigFile mInstance = null;
  private Context mContext = null;
  public boolean mForceUseQqProxy = true;
  public boolean mForceUseQqProxy_result = false;
  public boolean mForceUseSystemWebview = false;
  private boolean mForceUseSystemWebview_result = false;
  private File mTbsConfigDir = null;
  private File mpropFile = null;
  
  private TbsConfigFile(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    loadProperties();
  }
  
  private File getConfigFile()
  {
    Object localObject2 = null;
    try
    {
      Object localObject1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "debug.conf");
      if (localObject1 != null) {}
      return null;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          if (((File)localObject1).exists()) {
            return localObject1;
          }
          if (this.mTbsConfigDir == null)
          {
            this.mTbsConfigDir = new File(this.mContext.getDir("tbs", 0), "core_private");
            if ((this.mTbsConfigDir == null) || (!this.mTbsConfigDir.isDirectory())) {
              break label153;
            }
          }
          localObject2 = new File(this.mTbsConfigDir, "debug.conf");
          if ((localObject2 != null) && (!((File)localObject2).exists())) {
            ((File)localObject2).createNewFile();
          }
          localObject1 = localObject2;
          return localObject1;
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        localThrowable2 = localThrowable2;
        localObject1 = localObject2;
        localObject2 = localThrowable2;
        ((Throwable)localObject2).printStackTrace();
      }
    }
  }
  
  public static TbsConfigFile getInstance()
  {
    try
    {
      TbsConfigFile localTbsConfigFile = mInstance;
      return localTbsConfigFile;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsConfigFile getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsConfigFile(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public void loadProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aload_2
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 61	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   12: ifnonnull +13 -> 25
    //   15: aload_2
    //   16: astore_1
    //   17: aload_0
    //   18: aload_0
    //   19: invokespecial 130	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   22: putfield 61	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 61	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +27 -> 62
    //   38: new 132	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 133	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   54: goto -8 -> 46
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_2
    //   63: astore_1
    //   64: new 136	java/io/FileInputStream
    //   67: dup
    //   68: aload_0
    //   69: getfield 61	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   72: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: astore_2
    //   76: new 141	java/util/Properties
    //   79: dup
    //   80: invokespecial 142	java/util/Properties:<init>	()V
    //   83: astore_1
    //   84: aload_1
    //   85: aload_2
    //   86: invokevirtual 146	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   89: aload_1
    //   90: ldc 17
    //   92: ldc 148
    //   94: invokevirtual 152	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_3
    //   98: ldc 148
    //   100: aload_3
    //   101: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifne +11 -> 115
    //   107: aload_0
    //   108: aload_3
    //   109: invokestatic 164	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   112: putfield 53	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   115: aload_1
    //   116: ldc 11
    //   118: ldc 148
    //   120: invokevirtual 152	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: astore_1
    //   124: ldc 148
    //   126: aload_1
    //   127: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifne +11 -> 141
    //   133: aload_0
    //   134: aload_1
    //   135: invokestatic 164	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   138: putfield 55	com/tencent/smtt/utils/TbsConfigFile:mForceUseQqProxy	Z
    //   141: aload_2
    //   142: invokevirtual 167	java/io/FileInputStream:close	()V
    //   145: goto -99 -> 46
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   153: goto -107 -> 46
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: aload_1
    //   160: astore_3
    //   161: aload_2
    //   162: astore_1
    //   163: aload_3
    //   164: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   167: aload_2
    //   168: invokevirtual 167	java/io/FileInputStream:close	()V
    //   171: goto -125 -> 46
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   179: goto -133 -> 46
    //   182: astore_2
    //   183: aload_1
    //   184: invokevirtual 167	java/io/FileInputStream:close	()V
    //   187: aload_2
    //   188: athrow
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore_3
    //   198: aload_2
    //   199: astore_1
    //   200: aload_3
    //   201: astore_2
    //   202: goto -19 -> 183
    //   205: astore_3
    //   206: goto -45 -> 161
    //   209: astore_1
    //   210: goto -152 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	TbsConfigFile
    //   7	20	1	localObject1	Object
    //   49	2	1	localException1	java.lang.Exception
    //   57	4	1	localObject2	Object
    //   63	72	1	localObject3	Object
    //   148	2	1	localException2	java.lang.Exception
    //   156	4	1	localThrowable1	Throwable
    //   162	1	1	localObject4	Object
    //   174	10	1	localException3	java.lang.Exception
    //   189	2	1	localException4	java.lang.Exception
    //   199	1	1	localObject5	Object
    //   209	1	1	localObject6	Object
    //   3	165	2	localObject7	Object
    //   182	17	2	localObject8	Object
    //   201	1	2	localObject9	Object
    //   5	159	3	localObject10	Object
    //   197	4	3	localObject11	Object
    //   205	1	3	localThrowable2	Throwable
    //   31	3	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	46	49	java/lang/Exception
    //   38	46	57	finally
    //   50	54	57	finally
    //   167	171	57	finally
    //   175	179	57	finally
    //   183	187	57	finally
    //   187	189	57	finally
    //   190	194	57	finally
    //   141	145	148	java/lang/Exception
    //   8	15	156	java/lang/Throwable
    //   17	25	156	java/lang/Throwable
    //   27	33	156	java/lang/Throwable
    //   64	76	156	java/lang/Throwable
    //   167	171	174	java/lang/Exception
    //   8	15	182	finally
    //   17	25	182	finally
    //   27	33	182	finally
    //   64	76	182	finally
    //   163	167	182	finally
    //   183	187	189	java/lang/Exception
    //   76	115	197	finally
    //   115	141	197	finally
    //   76	115	205	java/lang/Throwable
    //   115	141	205	java/lang/Throwable
    //   141	145	209	finally
    //   149	153	209	finally
  }
  
  /* Error */
  public boolean resetProperties()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: astore_2
    //   6: aload_0
    //   7: invokespecial 130	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +34 -> 48
    //   17: new 132	java/lang/NullPointerException
    //   20: dup
    //   21: invokespecial 133	java/lang/NullPointerException:<init>	()V
    //   24: athrow
    //   25: new 132	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 133	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   38: goto -13 -> 25
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: astore_2
    //   50: new 136	java/io/FileInputStream
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_1
    //   60: new 141	java/util/Properties
    //   63: dup
    //   64: invokespecial 142	java/util/Properties:<init>	()V
    //   67: astore_2
    //   68: aload_2
    //   69: aload_1
    //   70: invokevirtual 146	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_0
    //   74: iconst_1
    //   75: putfield 55	com/tencent/smtt/utils/TbsConfigFile:mForceUseQqProxy	Z
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 53	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   83: aload_2
    //   84: ldc 17
    //   86: aload_0
    //   87: getfield 53	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   90: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   93: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   96: pop
    //   97: aload_2
    //   98: ldc 11
    //   100: aload_0
    //   101: getfield 55	com/tencent/smtt/utils/TbsConfigFile:mForceUseQqProxy	Z
    //   104: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   107: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   110: pop
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 57	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 59	com/tencent/smtt/utils/TbsConfigFile:mForceUseQqProxy_result	Z
    //   121: aload_2
    //   122: ldc 20
    //   124: aload_0
    //   125: getfield 57	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   128: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   131: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   134: pop
    //   135: aload_2
    //   136: ldc 14
    //   138: aload_0
    //   139: getfield 59	com/tencent/smtt/utils/TbsConfigFile:mForceUseQqProxy_result	Z
    //   142: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   145: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   148: pop
    //   149: new 177	java/io/FileOutputStream
    //   152: dup
    //   153: aload 4
    //   155: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   158: astore_3
    //   159: aload_2
    //   160: aload_3
    //   161: aconst_null
    //   162: invokevirtual 182	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   165: aload_1
    //   166: invokevirtual 167	java/io/FileInputStream:close	()V
    //   169: aload_1
    //   170: invokevirtual 167	java/io/FileInputStream:close	()V
    //   173: iconst_1
    //   174: ireturn
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   180: goto -11 -> 169
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   188: goto -15 -> 173
    //   191: astore_2
    //   192: aload_3
    //   193: astore_1
    //   194: aload_2
    //   195: astore_3
    //   196: aload_1
    //   197: astore_2
    //   198: aload_3
    //   199: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   202: aload_1
    //   203: invokevirtual 167	java/io/FileInputStream:close	()V
    //   206: aload_1
    //   207: invokevirtual 167	java/io/FileInputStream:close	()V
    //   210: iconst_0
    //   211: ireturn
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_2
    //   220: aload_2
    //   221: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   224: goto -18 -> 206
    //   227: astore_1
    //   228: aload_2
    //   229: invokevirtual 167	java/io/FileInputStream:close	()V
    //   232: aload_2
    //   233: invokevirtual 167	java/io/FileInputStream:close	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_3
    //   239: aload_3
    //   240: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   243: goto -11 -> 232
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   251: goto -15 -> 236
    //   254: astore_3
    //   255: aload_1
    //   256: astore_2
    //   257: aload_3
    //   258: astore_1
    //   259: goto -31 -> 228
    //   262: astore_3
    //   263: aload_1
    //   264: astore_2
    //   265: aload_3
    //   266: astore_1
    //   267: goto -39 -> 228
    //   270: astore_3
    //   271: goto -75 -> 196
    //   274: astore_3
    //   275: goto -79 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	TbsConfigFile
    //   1	4	1	localObject1	Object
    //   33	2	1	localException1	java.lang.Exception
    //   41	8	1	localException2	java.lang.Exception
    //   59	111	1	localFileInputStream	java.io.FileInputStream
    //   183	2	1	localException3	java.lang.Exception
    //   193	14	1	localObject2	Object
    //   212	2	1	localException4	java.lang.Exception
    //   227	29	1	localObject3	Object
    //   258	9	1	localObject4	Object
    //   5	155	2	localObject5	Object
    //   175	2	2	localException5	java.lang.Exception
    //   191	4	2	localThrowable1	Throwable
    //   197	1	2	localObject6	Object
    //   219	14	2	localException6	java.lang.Exception
    //   246	2	2	localException7	java.lang.Exception
    //   256	9	2	localObject7	Object
    //   3	196	3	localObject8	Object
    //   238	2	3	localException8	java.lang.Exception
    //   254	4	3	localObject9	Object
    //   262	4	3	localObject10	Object
    //   270	1	3	localThrowable2	Throwable
    //   274	1	3	localThrowable3	Throwable
    //   10	144	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   17	25	33	java/lang/Exception
    //   25	33	41	java/lang/Exception
    //   165	169	175	java/lang/Exception
    //   169	173	183	java/lang/Exception
    //   6	12	191	java/lang/Throwable
    //   50	60	191	java/lang/Throwable
    //   206	210	212	java/lang/Exception
    //   202	206	219	java/lang/Exception
    //   6	12	227	finally
    //   50	60	227	finally
    //   198	202	227	finally
    //   228	232	238	java/lang/Exception
    //   232	236	246	java/lang/Exception
    //   60	159	254	finally
    //   159	165	262	finally
    //   60	159	270	java/lang/Throwable
    //   159	165	274	java/lang/Throwable
  }
  
  /* Error */
  public void saveProperties()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore 6
    //   14: aload 7
    //   16: astore_2
    //   17: aload_1
    //   18: astore_3
    //   19: aload_0
    //   20: invokespecial 130	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   23: astore 8
    //   25: aload 8
    //   27: ifnonnull +33 -> 60
    //   30: new 132	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 133	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: new 132	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 133	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   51: goto -13 -> 38
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   59: return
    //   60: aload 7
    //   62: astore_2
    //   63: aload_1
    //   64: astore_3
    //   65: new 136	java/io/FileInputStream
    //   68: dup
    //   69: aload 8
    //   71: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: new 141	java/util/Properties
    //   78: dup
    //   79: invokespecial 142	java/util/Properties:<init>	()V
    //   82: astore_3
    //   83: aload_3
    //   84: aload_1
    //   85: invokevirtual 146	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_3
    //   89: ldc 17
    //   91: aload_0
    //   92: getfield 53	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   95: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   98: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_3
    //   103: ldc 11
    //   105: aload_0
    //   106: getfield 55	com/tencent/smtt/utils/TbsConfigFile:mForceUseQqProxy	Z
    //   109: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   112: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   115: pop
    //   116: aload_3
    //   117: ldc 20
    //   119: aload_0
    //   120: getfield 57	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   123: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   126: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   129: pop
    //   130: aload_0
    //   131: getfield 57	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   134: ifeq +14 -> 148
    //   137: aload_3
    //   138: ldc 14
    //   140: iconst_0
    //   141: invokestatic 171	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   144: invokevirtual 175	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   147: pop
    //   148: new 177	java/io/FileOutputStream
    //   151: dup
    //   152: aload 8
    //   154: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   157: astore_2
    //   158: aload_3
    //   159: aload_2
    //   160: aconst_null
    //   161: invokevirtual 182	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   164: aload_1
    //   165: invokevirtual 167	java/io/FileInputStream:close	()V
    //   168: aload_2
    //   169: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   172: return
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   178: goto -10 -> 168
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   186: return
    //   187: astore 5
    //   189: aload 6
    //   191: astore_1
    //   192: aload 4
    //   194: astore_2
    //   195: aload_1
    //   196: astore_3
    //   197: aload 5
    //   199: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   202: aload_1
    //   203: invokevirtual 167	java/io/FileInputStream:close	()V
    //   206: aload 4
    //   208: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   211: return
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   217: return
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   223: goto -17 -> 206
    //   226: astore_1
    //   227: aload_3
    //   228: invokevirtual 167	java/io/FileInputStream:close	()V
    //   231: aload_2
    //   232: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   235: aload_1
    //   236: athrow
    //   237: astore_3
    //   238: aload_3
    //   239: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   242: goto -11 -> 231
    //   245: astore_2
    //   246: aload_2
    //   247: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   250: goto -15 -> 235
    //   253: astore 4
    //   255: aload 5
    //   257: astore_2
    //   258: aload_1
    //   259: astore_3
    //   260: aload 4
    //   262: astore_1
    //   263: goto -36 -> 227
    //   266: astore 4
    //   268: aload_1
    //   269: astore_3
    //   270: aload 4
    //   272: astore_1
    //   273: goto -46 -> 227
    //   276: astore 5
    //   278: goto -86 -> 192
    //   281: astore 5
    //   283: aload_2
    //   284: astore 4
    //   286: goto -94 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	TbsConfigFile
    //   10	8	1	localObject1	Object
    //   46	2	1	localException1	java.lang.Exception
    //   54	10	1	localException2	java.lang.Exception
    //   74	91	1	localFileInputStream	java.io.FileInputStream
    //   173	2	1	localException3	java.lang.Exception
    //   181	2	1	localException4	java.lang.Exception
    //   191	12	1	localObject2	Object
    //   212	2	1	localException5	java.lang.Exception
    //   218	2	1	localException6	java.lang.Exception
    //   226	33	1	localObject3	Object
    //   262	11	1	localObject4	Object
    //   16	216	2	localObject5	Object
    //   245	2	2	localException7	java.lang.Exception
    //   257	27	2	localThrowable1	Throwable
    //   18	210	3	localObject6	Object
    //   237	2	3	localException8	java.lang.Exception
    //   259	11	3	localObject7	Object
    //   7	200	4	localObject8	Object
    //   253	8	4	localObject9	Object
    //   266	5	4	localObject10	Object
    //   284	1	4	localObject11	Object
    //   4	1	5	localObject12	Object
    //   187	69	5	localThrowable2	Throwable
    //   276	1	5	localThrowable3	Throwable
    //   281	1	5	localThrowable4	Throwable
    //   12	178	6	localObject13	Object
    //   1	60	7	localObject14	Object
    //   23	130	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	38	46	java/lang/Exception
    //   38	46	54	java/lang/Exception
    //   164	168	173	java/lang/Exception
    //   168	172	181	java/lang/Exception
    //   19	25	187	java/lang/Throwable
    //   65	75	187	java/lang/Throwable
    //   206	211	212	java/lang/Exception
    //   202	206	218	java/lang/Exception
    //   19	25	226	finally
    //   65	75	226	finally
    //   197	202	226	finally
    //   227	231	237	java/lang/Exception
    //   231	235	245	java/lang/Exception
    //   75	148	253	finally
    //   148	158	253	finally
    //   158	164	266	finally
    //   75	148	276	java/lang/Throwable
    //   148	158	276	java/lang/Throwable
    //   158	164	281	java/lang/Throwable
  }
  
  public void setForceUseSystemWebview(boolean paramBoolean)
  {
    this.mForceUseSystemWebview_result = paramBoolean;
    saveProperties();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsConfigFile
 * JD-Core Version:    0.7.0.1
 */