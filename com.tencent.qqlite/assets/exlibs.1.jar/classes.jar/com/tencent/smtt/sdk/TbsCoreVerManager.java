package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class TbsCoreVerManager
{
  private static final String TAG = "TbsCoreVerManager";
  private static final String TBS_APK_PATH = "install_apk_path";
  private static final String TBS_CORE_COPY_RETRY_NUM = "copy_retry_num";
  private static final String TBS_CORE_COPY_STATUS = "copy_status";
  private static final String TBS_CORE_COPY_VER = "copy_core_ver";
  private static final String TBS_CORE_DEXOPT_RETRY_NUM = "dexopt_retry_num";
  private static final String TBS_CORE_INSTALL_FILE = "tbscoreinstall.txt";
  private static final String TBS_CORE_INSTALL_STATUS = "install_status";
  private static final String TBS_CORE_INSTALL_VER = "install_core_ver";
  private static final String TBS_CORE_UNZIP_RETRY_NUM = "unzip_retry_num";
  private static final String TBS_INCRUPDATE_STATUS = "incrupdate_status";
  private static Context mContext = null;
  private static TbsCoreVerManager mInstance = null;
  
  static TbsCoreVerManager getInstance(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
    if (mInstance == null) {
      mInstance = new TbsCoreVerManager();
    }
    return mInstance;
  }
  
  /* Error */
  private Properties getTbsCoreInstallProp()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 6
    //   13: aload_2
    //   14: astore_1
    //   15: aload_0
    //   16: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   19: astore 7
    //   21: aload_2
    //   22: astore_1
    //   23: new 73	java/util/Properties
    //   26: dup
    //   27: invokespecial 74	java/util/Properties:<init>	()V
    //   30: astore_2
    //   31: aload 5
    //   33: astore_1
    //   34: aload 7
    //   36: ifnull +25 -> 61
    //   39: aload 5
    //   41: astore_1
    //   42: aload_2
    //   43: ifnull +18 -> 61
    //   46: new 76	java/io/FileInputStream
    //   49: dup
    //   50: aload 7
    //   52: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: aload_2
    //   57: aload_1
    //   58: invokevirtual 83	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 86	java/io/FileInputStream:close	()V
    //   69: aload_2
    //   70: areturn
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   76: goto -7 -> 69
    //   79: astore_2
    //   80: aload 6
    //   82: astore 4
    //   84: aload_3
    //   85: astore_1
    //   86: aload_2
    //   87: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   90: aload_3
    //   91: ifnull +7 -> 98
    //   94: aload_3
    //   95: invokevirtual 86	java/io/FileInputStream:close	()V
    //   98: aload 4
    //   100: areturn
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   106: goto -8 -> 98
    //   109: astore_2
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 86	java/io/FileInputStream:close	()V
    //   118: aload_2
    //   119: athrow
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   125: goto -7 -> 118
    //   128: astore_2
    //   129: aload 4
    //   131: astore_1
    //   132: goto -22 -> 110
    //   135: astore_2
    //   136: goto -26 -> 110
    //   139: astore_1
    //   140: aload_2
    //   141: astore 4
    //   143: aload_1
    //   144: astore_2
    //   145: goto -61 -> 84
    //   148: astore_3
    //   149: aload_2
    //   150: astore 4
    //   152: aload_3
    //   153: astore_2
    //   154: aload_1
    //   155: astore_3
    //   156: goto -72 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	TbsCoreVerManager
    //   14	52	1	localObject1	Object
    //   71	2	1	localIOException1	IOException
    //   85	1	1	localObject2	Object
    //   101	14	1	localIOException2	IOException
    //   120	2	1	localIOException3	IOException
    //   131	1	1	localObject3	Object
    //   139	16	1	localException1	java.lang.Exception
    //   3	67	2	localProperties	Properties
    //   79	8	2	localException2	java.lang.Exception
    //   109	10	2	localObject4	Object
    //   128	1	2	localObject5	Object
    //   135	6	2	localObject6	Object
    //   144	10	2	localObject7	Object
    //   1	94	3	localObject8	Object
    //   148	5	3	localException3	java.lang.Exception
    //   155	1	3	localObject9	Object
    //   5	146	4	localObject10	Object
    //   8	32	5	localObject11	Object
    //   11	70	6	localObject12	Object
    //   19	32	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   15	21	79	java/lang/Exception
    //   23	31	79	java/lang/Exception
    //   94	98	101	java/io/IOException
    //   15	21	109	finally
    //   23	31	109	finally
    //   86	90	109	finally
    //   114	118	120	java/io/IOException
    //   46	56	128	finally
    //   56	61	135	finally
    //   46	56	139	java/lang/Exception
    //   56	61	148	java/lang/Exception
  }
  
  String getTbsApkPath()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("install_apk_path") != null)) {
      return localProperties.getProperty("install_apk_path");
    }
    return null;
  }
  
  int getTbsCoreCopyRetryNum()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("copy_retry_num") != null)) {
      return Integer.parseInt(localProperties.getProperty("copy_retry_num"));
    }
    return 0;
  }
  
  int getTbsCoreCopyStatus()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("copy_status") != null)) {
      return Integer.parseInt(localProperties.getProperty("copy_status"));
    }
    return -1;
  }
  
  int getTbsCoreCopyVer()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("copy_core_ver") != null)) {
      return Integer.parseInt(localProperties.getProperty("copy_core_ver"));
    }
    return 0;
  }
  
  int getTbsCoreDexoptRetryNum()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("dexopt_retry_num") != null)) {
      return Integer.parseInt(localProperties.getProperty("dexopt_retry_num"));
    }
    return 0;
  }
  
  int getTbsCoreIncrUpdateStatus()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("incrupdate_status") != null)) {
      return Integer.parseInt(localProperties.getProperty("incrupdate_status"));
    }
    return -1;
  }
  
  File getTbsCoreInstallFile()
  {
    TbsInstaller.getInstance();
    File localFile = new File(TbsInstaller.getTbsCorePrivateDir(mContext), "tbscoreinstall.txt");
    if ((localFile != null) && (!localFile.exists())) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  int getTbsCoreInstallStatus()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("install_status") != null)) {
      return Integer.parseInt(localProperties.getProperty("install_status"));
    }
    return -1;
  }
  
  int getTbsCoreInstallVer()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("install_core_ver") != null)) {
      return Integer.parseInt(localProperties.getProperty("install_core_ver"));
    }
    return 0;
  }
  
  int getTbsCoreUnzipRetryNum()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("unzip_retry_num") != null)) {
      return Integer.parseInt(localProperties.getProperty("unzip_retry_num"));
    }
    return 0;
  }
  
  /* Error */
  void setTbsApkPath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 5
    //   10: astore_2
    //   11: aload_0
    //   12: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   15: astore 6
    //   17: aload 4
    //   19: astore_2
    //   20: aload 6
    //   22: ifnull +52 -> 74
    //   25: aload 5
    //   27: astore_2
    //   28: aload 6
    //   30: ldc 11
    //   32: aload_1
    //   33: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   36: pop
    //   37: aload 5
    //   39: astore_2
    //   40: aload_0
    //   41: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   44: astore_1
    //   45: aload 4
    //   47: astore_2
    //   48: aload_1
    //   49: ifnull +25 -> 74
    //   52: aload 5
    //   54: astore_2
    //   55: new 142	java/io/FileOutputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: astore_1
    //   64: aload 6
    //   66: aload_1
    //   67: ldc 145
    //   69: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   72: aload_1
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   82: return
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   88: return
    //   89: astore_2
    //   90: aload_3
    //   91: astore_1
    //   92: aload_2
    //   93: astore_3
    //   94: aload_1
    //   95: astore_2
    //   96: aload_3
    //   97: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   100: aload_1
    //   101: ifnull -19 -> 82
    //   104: aload_1
    //   105: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: astore_1
    //   116: aload_2
    //   117: ifnull +7 -> 124
    //   120: aload_2
    //   121: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   124: aload_1
    //   125: athrow
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   131: goto -7 -> 124
    //   134: astore_3
    //   135: aload_1
    //   136: astore_2
    //   137: aload_3
    //   138: astore_1
    //   139: goto -23 -> 116
    //   142: astore_3
    //   143: goto -49 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	TbsCoreVerManager
    //   0	146	1	paramString	String
    //   10	69	2	localObject1	Object
    //   89	4	2	localException1	java.lang.Exception
    //   95	26	2	str1	String
    //   126	2	2	localIOException	IOException
    //   136	1	2	str2	String
    //   1	96	3	localObject2	Object
    //   134	4	3	localObject3	Object
    //   142	1	3	localException2	java.lang.Exception
    //   6	40	4	localObject4	Object
    //   3	50	5	localObject5	Object
    //   15	50	6	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   78	82	83	java/io/IOException
    //   11	17	89	java/lang/Exception
    //   28	37	89	java/lang/Exception
    //   40	45	89	java/lang/Exception
    //   55	64	89	java/lang/Exception
    //   104	108	109	java/io/IOException
    //   11	17	115	finally
    //   28	37	115	finally
    //   40	45	115	finally
    //   55	64	115	finally
    //   96	100	115	finally
    //   120	124	126	java/io/IOException
    //   64	72	134	finally
    //   64	72	142	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreCopyRetryNum(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: aload_0
    //   12: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   15: astore 6
    //   17: aload_3
    //   18: astore_2
    //   19: aload 6
    //   21: ifnull +57 -> 78
    //   24: aload 5
    //   26: astore_2
    //   27: aload 6
    //   29: ldc 14
    //   31: iload_1
    //   32: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   35: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   38: pop
    //   39: aload 5
    //   41: astore_2
    //   42: aload_0
    //   43: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   46: astore 7
    //   48: aload_3
    //   49: astore_2
    //   50: aload 7
    //   52: ifnull +26 -> 78
    //   55: aload 5
    //   57: astore_2
    //   58: new 142	java/io/FileOutputStream
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload 6
    //   70: aload_3
    //   71: ldc 160
    //   73: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   76: aload_3
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore_2
    //   94: aload 4
    //   96: astore_3
    //   97: aload_2
    //   98: astore 4
    //   100: aload_3
    //   101: astore_2
    //   102: aload 4
    //   104: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   107: aload_3
    //   108: ifnull -22 -> 86
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: return
    //   116: astore_2
    //   117: aload_2
    //   118: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore_3
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   131: aload_3
    //   132: athrow
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   138: goto -7 -> 131
    //   141: astore 4
    //   143: aload_3
    //   144: astore_2
    //   145: aload 4
    //   147: astore_3
    //   148: goto -25 -> 123
    //   151: astore 4
    //   153: goto -53 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	TbsCoreVerManager
    //   0	156	1	paramInt	int
    //   10	73	2	localObject1	Object
    //   87	2	2	localIOException1	IOException
    //   93	5	2	localException1	java.lang.Exception
    //   101	1	2	localObject2	Object
    //   116	12	2	localIOException2	IOException
    //   133	2	2	localIOException3	IOException
    //   144	1	2	localObject3	Object
    //   7	105	3	localObject4	Object
    //   122	22	3	localObject5	Object
    //   147	1	3	localObject6	Object
    //   1	102	4	localObject7	Object
    //   141	5	4	localObject8	Object
    //   151	1	4	localException2	java.lang.Exception
    //   4	52	5	localObject9	Object
    //   15	54	6	localProperties	Properties
    //   46	17	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   82	86	87	java/io/IOException
    //   11	17	93	java/lang/Exception
    //   27	39	93	java/lang/Exception
    //   42	48	93	java/lang/Exception
    //   58	68	93	java/lang/Exception
    //   111	115	116	java/io/IOException
    //   11	17	122	finally
    //   27	39	122	finally
    //   42	48	122	finally
    //   58	68	122	finally
    //   102	107	122	finally
    //   127	131	133	java/io/IOException
    //   68	76	141	finally
    //   68	76	151	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreCopyStatus(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 6
    //   11: astore_3
    //   12: aload_0
    //   13: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   16: astore 7
    //   18: aload 4
    //   20: astore_3
    //   21: aload 7
    //   23: ifnull +76 -> 99
    //   26: aload 6
    //   28: astore_3
    //   29: aload 7
    //   31: ldc 20
    //   33: iload_1
    //   34: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   37: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 6
    //   43: astore_3
    //   44: aload 7
    //   46: ldc 17
    //   48: iload_2
    //   49: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 6
    //   58: astore_3
    //   59: aload_0
    //   60: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   63: astore 8
    //   65: aload 4
    //   67: astore_3
    //   68: aload 8
    //   70: ifnull +29 -> 99
    //   73: aload 6
    //   75: astore_3
    //   76: new 142	java/io/FileOutputStream
    //   79: dup
    //   80: aload 8
    //   82: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore 4
    //   87: aload 7
    //   89: aload 4
    //   91: ldc 164
    //   93: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   96: aload 4
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   107: return
    //   108: astore_3
    //   109: aload_3
    //   110: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   113: return
    //   114: astore_3
    //   115: aload 5
    //   117: astore 4
    //   119: aload_3
    //   120: astore 5
    //   122: aload 4
    //   124: astore_3
    //   125: aload 5
    //   127: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   130: aload 4
    //   132: ifnull -25 -> 107
    //   135: aload 4
    //   137: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   140: return
    //   141: astore_3
    //   142: aload_3
    //   143: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   146: return
    //   147: astore 4
    //   149: aload_3
    //   150: ifnull +7 -> 157
    //   153: aload_3
    //   154: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   157: aload 4
    //   159: athrow
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   165: goto -8 -> 157
    //   168: astore 5
    //   170: aload 4
    //   172: astore_3
    //   173: aload 5
    //   175: astore 4
    //   177: goto -28 -> 149
    //   180: astore 5
    //   182: goto -60 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	TbsCoreVerManager
    //   0	185	1	paramInt1	int
    //   0	185	2	paramInt2	int
    //   11	93	3	localObject1	Object
    //   108	2	3	localIOException1	IOException
    //   114	6	3	localException1	java.lang.Exception
    //   124	1	3	localObject2	Object
    //   141	13	3	localIOException2	IOException
    //   160	2	3	localIOException3	IOException
    //   172	1	3	localObject3	Object
    //   7	129	4	localObject4	Object
    //   147	24	4	localObject5	Object
    //   175	1	4	localObject6	Object
    //   1	125	5	localObject7	Object
    //   168	6	5	localObject8	Object
    //   180	1	5	localException2	java.lang.Exception
    //   4	70	6	localObject9	Object
    //   16	72	7	localProperties	Properties
    //   63	18	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	107	108	java/io/IOException
    //   12	18	114	java/lang/Exception
    //   29	41	114	java/lang/Exception
    //   44	56	114	java/lang/Exception
    //   59	65	114	java/lang/Exception
    //   76	87	114	java/lang/Exception
    //   135	140	141	java/io/IOException
    //   12	18	147	finally
    //   29	41	147	finally
    //   44	56	147	finally
    //   59	65	147	finally
    //   76	87	147	finally
    //   125	130	147	finally
    //   153	157	160	java/io/IOException
    //   87	96	168	finally
    //   87	96	180	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreDexoptRetryNum(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: aload_0
    //   12: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   15: astore 6
    //   17: aload_3
    //   18: astore_2
    //   19: aload 6
    //   21: ifnull +57 -> 78
    //   24: aload 5
    //   26: astore_2
    //   27: aload 6
    //   29: ldc 23
    //   31: iload_1
    //   32: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   35: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   38: pop
    //   39: aload 5
    //   41: astore_2
    //   42: aload_0
    //   43: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   46: astore 7
    //   48: aload_3
    //   49: astore_2
    //   50: aload 7
    //   52: ifnull +26 -> 78
    //   55: aload 5
    //   57: astore_2
    //   58: new 142	java/io/FileOutputStream
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload 6
    //   70: aload_3
    //   71: ldc 167
    //   73: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   76: aload_3
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore_2
    //   94: aload 4
    //   96: astore_3
    //   97: aload_2
    //   98: astore 4
    //   100: aload_3
    //   101: astore_2
    //   102: aload 4
    //   104: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   107: aload_3
    //   108: ifnull -22 -> 86
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: return
    //   116: astore_2
    //   117: aload_2
    //   118: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore_3
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   131: aload_3
    //   132: athrow
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   138: goto -7 -> 131
    //   141: astore 4
    //   143: aload_3
    //   144: astore_2
    //   145: aload 4
    //   147: astore_3
    //   148: goto -25 -> 123
    //   151: astore 4
    //   153: goto -53 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	TbsCoreVerManager
    //   0	156	1	paramInt	int
    //   10	73	2	localObject1	Object
    //   87	2	2	localIOException1	IOException
    //   93	5	2	localException1	java.lang.Exception
    //   101	1	2	localObject2	Object
    //   116	12	2	localIOException2	IOException
    //   133	2	2	localIOException3	IOException
    //   144	1	2	localObject3	Object
    //   7	105	3	localObject4	Object
    //   122	22	3	localObject5	Object
    //   147	1	3	localObject6	Object
    //   1	102	4	localObject7	Object
    //   141	5	4	localObject8	Object
    //   151	1	4	localException2	java.lang.Exception
    //   4	52	5	localObject9	Object
    //   15	54	6	localProperties	Properties
    //   46	17	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   82	86	87	java/io/IOException
    //   11	17	93	java/lang/Exception
    //   27	39	93	java/lang/Exception
    //   42	48	93	java/lang/Exception
    //   58	68	93	java/lang/Exception
    //   111	115	116	java/io/IOException
    //   11	17	122	finally
    //   27	39	122	finally
    //   42	48	122	finally
    //   58	68	122	finally
    //   102	107	122	finally
    //   127	131	133	java/io/IOException
    //   68	76	141	finally
    //   68	76	151	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreIncrUpdateStatus(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: aload_0
    //   12: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   15: astore 6
    //   17: aload_3
    //   18: astore_2
    //   19: aload 6
    //   21: ifnull +57 -> 78
    //   24: aload 5
    //   26: astore_2
    //   27: aload 6
    //   29: ldc 38
    //   31: iload_1
    //   32: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   35: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   38: pop
    //   39: aload 5
    //   41: astore_2
    //   42: aload_0
    //   43: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   46: astore 7
    //   48: aload_3
    //   49: astore_2
    //   50: aload 7
    //   52: ifnull +26 -> 78
    //   55: aload 5
    //   57: astore_2
    //   58: new 142	java/io/FileOutputStream
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload 6
    //   70: aload_3
    //   71: ldc 170
    //   73: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   76: aload_3
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore_2
    //   94: aload 4
    //   96: astore_3
    //   97: aload_2
    //   98: astore 4
    //   100: aload_3
    //   101: astore_2
    //   102: aload 4
    //   104: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   107: aload_3
    //   108: ifnull -22 -> 86
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: return
    //   116: astore_2
    //   117: aload_2
    //   118: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore_3
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   131: aload_3
    //   132: athrow
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   138: goto -7 -> 131
    //   141: astore 4
    //   143: aload_3
    //   144: astore_2
    //   145: aload 4
    //   147: astore_3
    //   148: goto -25 -> 123
    //   151: astore 4
    //   153: goto -53 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	TbsCoreVerManager
    //   0	156	1	paramInt	int
    //   10	73	2	localObject1	Object
    //   87	2	2	localIOException1	IOException
    //   93	5	2	localException1	java.lang.Exception
    //   101	1	2	localObject2	Object
    //   116	12	2	localIOException2	IOException
    //   133	2	2	localIOException3	IOException
    //   144	1	2	localObject3	Object
    //   7	105	3	localObject4	Object
    //   122	22	3	localObject5	Object
    //   147	1	3	localObject6	Object
    //   1	102	4	localObject7	Object
    //   141	5	4	localObject8	Object
    //   151	1	4	localException2	java.lang.Exception
    //   4	52	5	localObject9	Object
    //   15	54	6	localProperties	Properties
    //   46	17	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   82	86	87	java/io/IOException
    //   11	17	93	java/lang/Exception
    //   27	39	93	java/lang/Exception
    //   42	48	93	java/lang/Exception
    //   58	68	93	java/lang/Exception
    //   111	115	116	java/io/IOException
    //   11	17	122	finally
    //   27	39	122	finally
    //   42	48	122	finally
    //   58	68	122	finally
    //   102	107	122	finally
    //   127	131	133	java/io/IOException
    //   68	76	141	finally
    //   68	76	151	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreInstallStatus(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 6
    //   11: astore_3
    //   12: aload_0
    //   13: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   16: astore 7
    //   18: aload 4
    //   20: astore_3
    //   21: aload 7
    //   23: ifnull +76 -> 99
    //   26: aload 6
    //   28: astore_3
    //   29: aload 7
    //   31: ldc 32
    //   33: iload_1
    //   34: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   37: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 6
    //   43: astore_3
    //   44: aload 7
    //   46: ldc 29
    //   48: iload_2
    //   49: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 6
    //   58: astore_3
    //   59: aload_0
    //   60: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   63: astore 8
    //   65: aload 4
    //   67: astore_3
    //   68: aload 8
    //   70: ifnull +29 -> 99
    //   73: aload 6
    //   75: astore_3
    //   76: new 142	java/io/FileOutputStream
    //   79: dup
    //   80: aload 8
    //   82: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore 4
    //   87: aload 7
    //   89: aload 4
    //   91: ldc 170
    //   93: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   96: aload 4
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   107: return
    //   108: astore_3
    //   109: aload_3
    //   110: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   113: return
    //   114: astore_3
    //   115: aload 5
    //   117: astore 4
    //   119: aload_3
    //   120: astore 5
    //   122: aload 4
    //   124: astore_3
    //   125: aload 5
    //   127: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   130: aload 4
    //   132: ifnull -25 -> 107
    //   135: aload 4
    //   137: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   140: return
    //   141: astore_3
    //   142: aload_3
    //   143: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   146: return
    //   147: astore 4
    //   149: aload_3
    //   150: ifnull +7 -> 157
    //   153: aload_3
    //   154: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   157: aload 4
    //   159: athrow
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   165: goto -8 -> 157
    //   168: astore 5
    //   170: aload 4
    //   172: astore_3
    //   173: aload 5
    //   175: astore 4
    //   177: goto -28 -> 149
    //   180: astore 5
    //   182: goto -60 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	TbsCoreVerManager
    //   0	185	1	paramInt1	int
    //   0	185	2	paramInt2	int
    //   11	93	3	localObject1	Object
    //   108	2	3	localIOException1	IOException
    //   114	6	3	localException1	java.lang.Exception
    //   124	1	3	localObject2	Object
    //   141	13	3	localIOException2	IOException
    //   160	2	3	localIOException3	IOException
    //   172	1	3	localObject3	Object
    //   7	129	4	localObject4	Object
    //   147	24	4	localObject5	Object
    //   175	1	4	localObject6	Object
    //   1	125	5	localObject7	Object
    //   168	6	5	localObject8	Object
    //   180	1	5	localException2	java.lang.Exception
    //   4	70	6	localObject9	Object
    //   16	72	7	localProperties	Properties
    //   63	18	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	107	108	java/io/IOException
    //   12	18	114	java/lang/Exception
    //   29	41	114	java/lang/Exception
    //   44	56	114	java/lang/Exception
    //   59	65	114	java/lang/Exception
    //   76	87	114	java/lang/Exception
    //   135	140	141	java/io/IOException
    //   12	18	147	finally
    //   29	41	147	finally
    //   44	56	147	finally
    //   59	65	147	finally
    //   76	87	147	finally
    //   125	130	147	finally
    //   153	157	160	java/io/IOException
    //   87	96	168	finally
    //   87	96	180	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreUnzipRetryNum(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: aload_0
    //   12: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   15: astore 6
    //   17: aload_3
    //   18: astore_2
    //   19: aload 6
    //   21: ifnull +57 -> 78
    //   24: aload 5
    //   26: astore_2
    //   27: aload 6
    //   29: ldc 35
    //   31: iload_1
    //   32: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   35: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   38: pop
    //   39: aload 5
    //   41: astore_2
    //   42: aload_0
    //   43: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   46: astore 7
    //   48: aload_3
    //   49: astore_2
    //   50: aload 7
    //   52: ifnull +26 -> 78
    //   55: aload 5
    //   57: astore_2
    //   58: new 142	java/io/FileOutputStream
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload 6
    //   70: aload_3
    //   71: ldc 174
    //   73: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   76: aload_3
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore_2
    //   94: aload 4
    //   96: astore_3
    //   97: aload_2
    //   98: astore 4
    //   100: aload_3
    //   101: astore_2
    //   102: aload 4
    //   104: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   107: aload_3
    //   108: ifnull -22 -> 86
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: return
    //   116: astore_2
    //   117: aload_2
    //   118: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore_3
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   131: aload_3
    //   132: athrow
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   138: goto -7 -> 131
    //   141: astore 4
    //   143: aload_3
    //   144: astore_2
    //   145: aload 4
    //   147: astore_3
    //   148: goto -25 -> 123
    //   151: astore 4
    //   153: goto -53 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	TbsCoreVerManager
    //   0	156	1	paramInt	int
    //   10	73	2	localObject1	Object
    //   87	2	2	localIOException1	IOException
    //   93	5	2	localException1	java.lang.Exception
    //   101	1	2	localObject2	Object
    //   116	12	2	localIOException2	IOException
    //   133	2	2	localIOException3	IOException
    //   144	1	2	localObject3	Object
    //   7	105	3	localObject4	Object
    //   122	22	3	localObject5	Object
    //   147	1	3	localObject6	Object
    //   1	102	4	localObject7	Object
    //   141	5	4	localObject8	Object
    //   151	1	4	localException2	java.lang.Exception
    //   4	52	5	localObject9	Object
    //   15	54	6	localProperties	Properties
    //   46	17	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   82	86	87	java/io/IOException
    //   11	17	93	java/lang/Exception
    //   27	39	93	java/lang/Exception
    //   42	48	93	java/lang/Exception
    //   58	68	93	java/lang/Exception
    //   111	115	116	java/io/IOException
    //   11	17	122	finally
    //   27	39	122	finally
    //   42	48	122	finally
    //   58	68	122	finally
    //   102	107	122	finally
    //   127	131	133	java/io/IOException
    //   68	76	141	finally
    //   68	76	151	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreVerManager
 * JD-Core Version:    0.7.0.1
 */