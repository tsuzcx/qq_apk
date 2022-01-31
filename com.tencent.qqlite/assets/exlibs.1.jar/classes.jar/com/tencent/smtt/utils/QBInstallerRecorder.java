package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;

public class QBInstallerRecorder
{
  private static final String INSTALLER_FILE = "ins.dat";
  private static final String SYS_SETTING_TBS_QB_INSTALLER = "sys_setting_tbs_qb_installer";
  private static final String TAG = "QBInstallerRecorder";
  private static Context mContext = null;
  private static QBInstallerRecorder mIntance = null;
  
  public static QBInstallerRecorder getInstance(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
    if (mIntance == null) {
      mIntance = new QBInstallerRecorder();
    }
    return mIntance;
  }
  
  /* Error */
  private String loadQBInstallerFromSDCard()
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/smtt/utils/FileUtil:hasSDcard	()Z
    //   3: ifne +8 -> 11
    //   6: ldc 53
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore_2
    //   16: aconst_null
    //   17: astore 4
    //   19: aload_2
    //   20: astore_1
    //   21: new 55	java/io/File
    //   24: dup
    //   25: invokestatic 59	com/tencent/smtt/utils/FileUtil:getTbsSdcardShareDir	()Ljava/io/File;
    //   28: ldc 8
    //   30: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_2
    //   35: astore_1
    //   36: aload_3
    //   37: invokevirtual 65	java/io/File:exists	()Z
    //   40: ifne +27 -> 67
    //   43: ldc 53
    //   45: astore_3
    //   46: aload_3
    //   47: astore_1
    //   48: iconst_0
    //   49: ifeq -40 -> 9
    //   52: new 67	java/lang/NullPointerException
    //   55: dup
    //   56: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   59: athrow
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   65: aload_3
    //   66: areturn
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: invokestatic 75	com/tencent/smtt/utils/FileUtil:read	(Ljava/io/File;)[B
    //   73: astore 6
    //   75: aload 6
    //   77: ifnull +11 -> 88
    //   80: aload_2
    //   81: astore_1
    //   82: aload 6
    //   84: arraylength
    //   85: ifgt +24 -> 109
    //   88: ldc 53
    //   90: astore_3
    //   91: aload_3
    //   92: astore_1
    //   93: iconst_0
    //   94: ifeq -85 -> 9
    //   97: new 67	java/lang/NullPointerException
    //   100: dup
    //   101: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   104: athrow
    //   105: astore_1
    //   106: goto -45 -> 61
    //   109: aload_2
    //   110: astore_1
    //   111: new 77	java/io/DataInputStream
    //   114: dup
    //   115: aload_3
    //   116: invokestatic 81	com/tencent/smtt/utils/FileUtil:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   119: invokespecial 84	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 87	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   127: astore_3
    //   128: aload_3
    //   129: astore_1
    //   130: aload_2
    //   131: ifnull -122 -> 9
    //   134: aload_2
    //   135: invokevirtual 90	java/io/DataInputStream:close	()V
    //   138: aload_3
    //   139: areturn
    //   140: astore_1
    //   141: goto -80 -> 61
    //   144: astore_3
    //   145: aload 4
    //   147: astore_2
    //   148: aload_2
    //   149: astore_1
    //   150: aload_3
    //   151: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   154: aload_2
    //   155: ifnull +7 -> 162
    //   158: aload_2
    //   159: invokevirtual 90	java/io/DataInputStream:close	()V
    //   162: ldc 53
    //   164: areturn
    //   165: astore_3
    //   166: aload 5
    //   168: astore_2
    //   169: aload_2
    //   170: astore_1
    //   171: aload_3
    //   172: invokevirtual 92	java/lang/Error:printStackTrace	()V
    //   175: aload_2
    //   176: ifnull -14 -> 162
    //   179: aload_2
    //   180: invokevirtual 90	java/io/DataInputStream:close	()V
    //   183: goto -21 -> 162
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   191: goto -29 -> 162
    //   194: astore_2
    //   195: aload_1
    //   196: ifnull +7 -> 203
    //   199: aload_1
    //   200: invokevirtual 90	java/io/DataInputStream:close	()V
    //   203: aload_2
    //   204: athrow
    //   205: astore_1
    //   206: aload_1
    //   207: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   210: goto -7 -> 203
    //   213: astore_1
    //   214: goto -27 -> 187
    //   217: astore_3
    //   218: aload_2
    //   219: astore_1
    //   220: aload_3
    //   221: astore_2
    //   222: goto -27 -> 195
    //   225: astore_3
    //   226: goto -57 -> 169
    //   229: astore_3
    //   230: goto -82 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	QBInstallerRecorder
    //   8	40	1	localObject1	Object
    //   60	2	1	localIOException1	java.io.IOException
    //   68	25	1	localObject2	Object
    //   105	1	1	localIOException2	java.io.IOException
    //   110	20	1	localObject3	Object
    //   140	1	1	localIOException3	java.io.IOException
    //   149	22	1	localObject4	Object
    //   186	14	1	localIOException4	java.io.IOException
    //   205	2	1	localIOException5	java.io.IOException
    //   213	1	1	localIOException6	java.io.IOException
    //   219	1	1	localObject5	Object
    //   15	165	2	localObject6	Object
    //   194	25	2	localObject7	Object
    //   221	1	2	localObject8	Object
    //   33	106	3	localObject9	Object
    //   144	7	3	localException1	Exception
    //   165	7	3	localError1	java.lang.Error
    //   217	4	3	localObject10	Object
    //   225	1	3	localError2	java.lang.Error
    //   229	1	3	localException2	Exception
    //   17	129	4	localObject11	Object
    //   12	155	5	localObject12	Object
    //   73	10	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	60	60	java/io/IOException
    //   97	105	105	java/io/IOException
    //   134	138	140	java/io/IOException
    //   21	34	144	java/lang/Exception
    //   36	43	144	java/lang/Exception
    //   69	75	144	java/lang/Exception
    //   82	88	144	java/lang/Exception
    //   111	123	144	java/lang/Exception
    //   21	34	165	java/lang/Error
    //   36	43	165	java/lang/Error
    //   69	75	165	java/lang/Error
    //   82	88	165	java/lang/Error
    //   111	123	165	java/lang/Error
    //   179	183	186	java/io/IOException
    //   21	34	194	finally
    //   36	43	194	finally
    //   69	75	194	finally
    //   82	88	194	finally
    //   111	123	194	finally
    //   150	154	194	finally
    //   171	175	194	finally
    //   199	203	205	java/io/IOException
    //   158	162	213	java/io/IOException
    //   123	128	217	finally
    //   123	128	225	java/lang/Error
    //   123	128	229	java/lang/Exception
  }
  
  private String loadQBInstallerFromSysSetting()
  {
    Object localObject1 = "";
    Object localObject2;
    try
    {
      String str = Settings.System.getString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer");
      localObject1 = str;
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        return "";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  /* Error */
  private void recordInstallerToSDCard(String paramString)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/smtt/utils/FileUtil:hasSDcard	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_3
    //   13: astore_2
    //   14: new 55	java/io/File
    //   17: dup
    //   18: invokestatic 59	com/tencent/smtt/utils/FileUtil:getTbsSdcardShareDir	()Ljava/io/File;
    //   21: ldc 8
    //   23: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 5
    //   28: aload_3
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 65	java/io/File:exists	()Z
    //   35: ifne +11 -> 46
    //   38: aload_3
    //   39: astore_2
    //   40: aload 5
    //   42: invokevirtual 114	java/io/File:createNewFile	()Z
    //   45: pop
    //   46: aload_3
    //   47: astore_2
    //   48: new 116	java/io/DataOutputStream
    //   51: dup
    //   52: aload 5
    //   54: invokestatic 120	com/tencent/smtt/utils/FileUtil:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   57: invokespecial 123	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: aload_1
    //   63: invokevirtual 126	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   66: aload_3
    //   67: invokevirtual 129	java/io/DataOutputStream:flush	()V
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   78: return
    //   79: astore_3
    //   80: aload 4
    //   82: astore_1
    //   83: aload_1
    //   84: astore_2
    //   85: aload_3
    //   86: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   89: aload_1
    //   90: ifnull -84 -> 6
    //   93: aload_1
    //   94: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   103: return
    //   104: astore_1
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   113: aload_1
    //   114: athrow
    //   115: astore_2
    //   116: aload_2
    //   117: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   120: goto -7 -> 113
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   128: goto -50 -> 78
    //   131: astore_1
    //   132: aload_3
    //   133: astore_2
    //   134: goto -29 -> 105
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: aload_2
    //   141: astore_3
    //   142: goto -59 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	QBInstallerRecorder
    //   0	145	1	paramString	String
    //   13	97	2	localObject1	Object
    //   115	2	2	localIOException	java.io.IOException
    //   133	1	2	localException1	Exception
    //   137	4	2	localException2	Exception
    //   8	67	3	localDataOutputStream	java.io.DataOutputStream
    //   79	60	3	localException3	Exception
    //   141	1	3	localObject2	Object
    //   10	71	4	localObject3	Object
    //   26	27	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   14	28	79	java/lang/Exception
    //   30	38	79	java/lang/Exception
    //   40	46	79	java/lang/Exception
    //   48	61	79	java/lang/Exception
    //   93	97	98	java/io/IOException
    //   14	28	104	finally
    //   30	38	104	finally
    //   40	46	104	finally
    //   48	61	104	finally
    //   85	89	104	finally
    //   109	113	115	java/io/IOException
    //   74	78	123	java/io/IOException
    //   61	70	131	finally
    //   61	70	137	java/lang/Exception
  }
  
  private void recordInstallerToSysSetting(String paramString)
  {
    try
    {
      Settings.System.putString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer", paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getQBInstaller()
  {
    if (!TextUtils.isEmpty(loadQBInstallerFromSDCard())) {
      return "";
    }
    return loadQBInstallerFromSysSetting();
  }
  
  public void recordQBInstaller(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    recordInstallerToSDCard(paramString);
    recordInstallerToSysSetting(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.QBInstallerRecorder
 * JD-Core Version:    0.7.0.1
 */