package com.tencent.kingkong;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Utils
{
  private static final String LOG_TAG = "KingKongUtils";
  
  /* Error */
  public static String ReadFileToString(String paramString)
  {
    // Byte code:
    //   0: new 22	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 29	java/io/File:exists	()Z
    //   11: ifne +32 -> 43
    //   14: ldc 11
    //   16: new 31	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 33
    //   22: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 40
    //   31: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 52
    //   42: areturn
    //   43: new 31	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_2
    //   55: new 55	java/io/BufferedReader
    //   58: dup
    //   59: new 57	java/io/InputStreamReader
    //   62: dup
    //   63: new 59	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   71: invokespecial 63	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   74: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +16 -> 100
    //   87: aload_0
    //   88: ifnull +78 -> 166
    //   91: aload_0
    //   92: invokevirtual 72	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: areturn
    //   100: aload_3
    //   101: aload_1
    //   102: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: goto -28 -> 78
    //   109: astore_2
    //   110: aload_0
    //   111: astore_1
    //   112: aload_2
    //   113: invokevirtual 75	java/io/IOException:printStackTrace	()V
    //   116: aload_0
    //   117: ifnull -22 -> 95
    //   120: aload_0
    //   121: invokevirtual 72	java/io/BufferedReader:close	()V
    //   124: goto -29 -> 95
    //   127: astore_0
    //   128: goto -33 -> 95
    //   131: astore_0
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 72	java/io/BufferedReader:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: astore_0
    //   143: goto -48 -> 95
    //   146: astore_1
    //   147: goto -7 -> 140
    //   150: astore_2
    //   151: aload_0
    //   152: astore_1
    //   153: aload_2
    //   154: astore_0
    //   155: goto -23 -> 132
    //   158: astore_1
    //   159: aload_2
    //   160: astore_0
    //   161: aload_1
    //   162: astore_2
    //   163: goto -53 -> 110
    //   166: goto -71 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   52	85	1	str1	String
    //   146	1	1	localIOException1	IOException
    //   152	1	1	str2	String
    //   158	4	1	localIOException2	IOException
    //   54	1	2	localObject1	Object
    //   109	4	2	localIOException3	IOException
    //   150	10	2	localObject2	Object
    //   162	1	2	localIOException4	IOException
    //   50	51	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   78	83	109	java/io/IOException
    //   100	106	109	java/io/IOException
    //   120	124	127	java/io/IOException
    //   55	78	131	finally
    //   112	116	131	finally
    //   91	95	142	java/io/IOException
    //   136	140	146	java/io/IOException
    //   78	83	150	finally
    //   100	106	150	finally
    //   55	78	158	java/io/IOException
  }
  
  public static String ReadFileToStringEx(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      Common.Log.d("KingKongUtils", "file " + paramString + " does not exist.");
      return "";
    }
    paramString = new byte[Long.valueOf(((File)localObject).length()).intValue()];
    try
    {
      localObject = new FileInputStream((File)localObject);
      ((FileInputStream)localObject).read(paramString);
      ((FileInputStream)localObject).close();
      return new String(paramString);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public static boolean ZapFolder(File paramFile)
  {
    if (!paramFile.exists()) {}
    while (!paramFile.isDirectory()) {
      return false;
    }
    paramFile = paramFile.listFiles();
    int i = 0;
    for (;;)
    {
      if (i >= paramFile.length) {
        return true;
      }
      File localFile = paramFile[i];
      if (((localFile.isDirectory()) && (!ZapFolder(localFile))) || (!localFile.delete())) {
        break;
      }
      i += 1;
    }
  }
  
  public static boolean checkFileSHA1(String paramString1, String paramString2)
  {
    return getFileSHA1String(paramString1).equals(paramString2);
  }
  
  /* Error */
  public static boolean checkFileSignature(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 131	java/util/jar/JarFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 132	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 136	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   13: astore 4
    //   15: aload 4
    //   17: invokeinterface 141 1 0
    //   22: istore_2
    //   23: iload_2
    //   24: ifne +26 -> 50
    //   27: ldc 11
    //   29: new 31	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 143
    //   35: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: iconst_1
    //   49: ireturn
    //   50: aload 4
    //   52: invokeinterface 147 1 0
    //   57: checkcast 149	java/util/jar/JarEntry
    //   60: astore 5
    //   62: aload 5
    //   64: invokevirtual 150	java/util/jar/JarEntry:isDirectory	()Z
    //   67: ifne -52 -> 15
    //   70: aload 5
    //   72: invokevirtual 153	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   75: ldc 155
    //   77: invokevirtual 159	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   80: ifne -65 -> 15
    //   83: aload_3
    //   84: aload 5
    //   86: invokestatic 163	com/tencent/kingkong/Utils:loadCertificates	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)[Ljava/security/cert/Certificate;
    //   89: astore 5
    //   91: aload 5
    //   93: ifnonnull +5 -> 98
    //   96: iconst_0
    //   97: ireturn
    //   98: aload 5
    //   100: arraylength
    //   101: iconst_1
    //   102: if_icmpeq +5 -> 107
    //   105: iconst_0
    //   106: ireturn
    //   107: new 165	android/content/pm/Signature
    //   110: dup
    //   111: aload 5
    //   113: iconst_0
    //   114: aaload
    //   115: invokevirtual 171	java/security/cert/Certificate:getEncoded	()[B
    //   118: invokespecial 172	android/content/pm/Signature:<init>	([B)V
    //   121: new 165	android/content/pm/Signature
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 173	android/content/pm/Signature:<init>	(Ljava/lang/String;)V
    //   129: invokevirtual 174	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   132: ifne -117 -> 15
    //   135: ldc 11
    //   137: new 31	java/lang/StringBuilder
    //   140: dup
    //   141: ldc 176
    //   143: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_0
    //   159: ldc 11
    //   161: new 31	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 178
    //   167: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_0
    //   183: ldc 11
    //   185: new 31	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 178
    //   191: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: iconst_0
    //   205: ireturn
    //   206: astore_0
    //   207: goto -24 -> 183
    //   210: astore_0
    //   211: goto -52 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramString1	String
    //   0	214	1	paramString2	String
    //   22	2	2	bool	boolean
    //   8	76	3	localJarFile	JarFile
    //   13	38	4	localEnumeration	Enumeration
    //   60	52	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	158	java/io/IOException
    //   0	9	182	java/security/cert/CertificateEncodingException
    //   9	15	206	java/security/cert/CertificateEncodingException
    //   15	23	206	java/security/cert/CertificateEncodingException
    //   50	91	206	java/security/cert/CertificateEncodingException
    //   98	105	206	java/security/cert/CertificateEncodingException
    //   107	156	206	java/security/cert/CertificateEncodingException
    //   9	15	210	java/io/IOException
    //   15	23	210	java/io/IOException
    //   50	91	210	java/io/IOException
    //   98	105	210	java/io/IOException
    //   107	156	210	java/io/IOException
  }
  
  public static void clearPatchConfig(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
    localEditor.clear();
    localEditor.commit();
    ZapFolder(new File(paramContext.getFilesDir().getAbsolutePath() + Common.mPathSeparator + "kingkong" + Common.mPathSeparator + "download"));
    ZapFolder(new File(paramContext.getFilesDir().getAbsolutePath() + Common.mPathSeparator + "kingkong" + Common.mPathSeparator + "patches"));
  }
  
  /* Error */
  public static boolean copyAssetToFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 8
    //   18: new 230	java/io/FileOutputStream
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 231	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   26: astore_2
    //   27: new 233	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 237	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   35: aload_1
    //   36: invokevirtual 243	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: invokespecial 244	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_0
    //   43: sipush 8192
    //   46: newarray byte
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 245	java/io/BufferedInputStream:read	([B)I
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_m1
    //   57: if_icmpne +25 -> 82
    //   60: aload_0
    //   61: ifnull +7 -> 68
    //   64: aload_0
    //   65: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   68: aload_2
    //   69: ifnull +7 -> 76
    //   72: aload_2
    //   73: invokevirtual 249	java/io/OutputStream:close	()V
    //   76: iconst_1
    //   77: istore 4
    //   79: iload 4
    //   81: ireturn
    //   82: aload_2
    //   83: aload_1
    //   84: iconst_0
    //   85: iload_3
    //   86: invokevirtual 253	java/io/OutputStream:write	([BII)V
    //   89: goto -40 -> 49
    //   92: astore 5
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: astore_0
    //   98: aload_1
    //   99: astore_2
    //   100: aload 5
    //   102: astore_1
    //   103: aload_2
    //   104: astore 5
    //   106: aload_0
    //   107: astore 6
    //   109: ldc 11
    //   111: aload_1
    //   112: invokevirtual 256	java/io/IOException:getMessage	()Ljava/lang/String;
    //   115: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   126: aload_0
    //   127: ifnull -48 -> 79
    //   130: aload_0
    //   131: invokevirtual 249	java/io/OutputStream:close	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_0
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   150: aload 6
    //   152: ifnull +8 -> 160
    //   155: aload 6
    //   157: invokevirtual 249	java/io/OutputStream:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -95 -> 68
    //   166: astore_0
    //   167: goto -91 -> 76
    //   170: astore_1
    //   171: goto -45 -> 126
    //   174: astore_1
    //   175: goto -25 -> 150
    //   178: astore_1
    //   179: goto -19 -> 160
    //   182: astore_0
    //   183: aload 9
    //   185: astore 5
    //   187: aload_2
    //   188: astore 6
    //   190: goto -50 -> 140
    //   193: astore_1
    //   194: aload_0
    //   195: astore 5
    //   197: aload_2
    //   198: astore 6
    //   200: aload_1
    //   201: astore_0
    //   202: goto -62 -> 140
    //   205: astore_1
    //   206: aload 7
    //   208: astore_2
    //   209: aload 8
    //   211: astore_0
    //   212: goto -109 -> 103
    //   215: astore_1
    //   216: aload_2
    //   217: astore_0
    //   218: aload 7
    //   220: astore_2
    //   221: goto -118 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramContext	Context
    //   0	224	1	paramString1	String
    //   0	224	2	paramString2	String
    //   54	32	3	i	int
    //   1	79	4	bool	boolean
    //   4	1	5	localObject1	Object
    //   92	9	5	localIOException	IOException
    //   104	92	5	localObject2	Object
    //   13	186	6	localObject3	Object
    //   10	209	7	localObject4	Object
    //   16	194	8	localObject5	Object
    //   7	177	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   43	49	92	java/io/IOException
    //   49	55	92	java/io/IOException
    //   82	89	92	java/io/IOException
    //   130	134	136	java/io/IOException
    //   18	27	139	finally
    //   109	118	139	finally
    //   64	68	162	java/io/IOException
    //   72	76	166	java/io/IOException
    //   122	126	170	java/io/IOException
    //   145	150	174	java/io/IOException
    //   155	160	178	java/io/IOException
    //   27	43	182	finally
    //   43	49	193	finally
    //   49	55	193	finally
    //   82	89	193	finally
    //   18	27	205	java/io/IOException
    //   27	43	215	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      localObject = new FileOutputStream(paramString1, false);
      FileInputStream localFileInputStream = new FileInputStream(paramString2);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0)
        {
          ((FileOutputStream)localObject).close();
          localFileInputStream.close();
          Common.Log.d("KingKongUtils", "Copy file " + paramString2 + " to " + paramString1 + " OK");
          return true;
        }
        ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (IOException localIOException)
    {
      Common.Log.d("KingKongUtils", "Copy file " + paramString2 + " to " + paramString1 + " failed:" + localIOException);
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean download(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 4
    //   18: aload 10
    //   20: astore 7
    //   22: aload 6
    //   24: astore 5
    //   26: aload 12
    //   28: astore 8
    //   30: new 274	java/net/URL
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 275	java/net/URL:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 279	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   41: checkcast 281	java/net/HttpURLConnection
    //   44: astore_3
    //   45: aload_3
    //   46: astore 4
    //   48: aload 10
    //   50: astore 7
    //   52: aload 6
    //   54: astore 5
    //   56: aload_3
    //   57: astore 9
    //   59: aload 12
    //   61: astore 8
    //   63: aload_3
    //   64: invokevirtual 285	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   67: astore 6
    //   69: aload_3
    //   70: astore 4
    //   72: aload 10
    //   74: astore 7
    //   76: aload 6
    //   78: astore 5
    //   80: aload_3
    //   81: astore 9
    //   83: aload 6
    //   85: astore 8
    //   87: new 230	java/io/FileOutputStream
    //   90: dup
    //   91: aload_1
    //   92: iconst_0
    //   93: invokespecial 260	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   96: astore 10
    //   98: aload_3
    //   99: sipush 300
    //   102: invokevirtual 289	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   105: aload_3
    //   106: sipush 300
    //   109: invokevirtual 292	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   112: aload_3
    //   113: invokevirtual 295	java/net/HttpURLConnection:connect	()V
    //   116: sipush 1024
    //   119: newarray byte
    //   121: astore 4
    //   123: aload 6
    //   125: aload 4
    //   127: invokevirtual 298	java/io/InputStream:read	([B)I
    //   130: istore_2
    //   131: iload_2
    //   132: ifgt +65 -> 197
    //   135: ldc 11
    //   137: new 31	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 300
    //   144: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_0
    //   148: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 302
    //   154: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 6
    //   169: ifnull +8 -> 177
    //   172: aload 6
    //   174: invokevirtual 303	java/io/InputStream:close	()V
    //   177: aload 10
    //   179: ifnull +8 -> 187
    //   182: aload 10
    //   184: invokevirtual 261	java/io/FileOutputStream:close	()V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   195: iconst_1
    //   196: ireturn
    //   197: aload 10
    //   199: aload 4
    //   201: iconst_0
    //   202: iload_2
    //   203: invokevirtual 268	java/io/FileOutputStream:write	([BII)V
    //   206: goto -83 -> 123
    //   209: astore 9
    //   211: aload 6
    //   213: astore 8
    //   215: aload 10
    //   217: astore 6
    //   219: aload_3
    //   220: astore 4
    //   222: aload 6
    //   224: astore 7
    //   226: aload 8
    //   228: astore 5
    //   230: ldc 11
    //   232: new 31	java/lang/StringBuilder
    //   235: dup
    //   236: ldc_w 308
    //   239: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_0
    //   243: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 302
    //   249: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 310
    //   259: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 9
    //   264: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 50	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload 8
    //   275: ifnull +8 -> 283
    //   278: aload 8
    //   280: invokevirtual 303	java/io/InputStream:close	()V
    //   283: aload 6
    //   285: ifnull +8 -> 293
    //   288: aload 6
    //   290: invokevirtual 261	java/io/FileOutputStream:close	()V
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   301: iconst_0
    //   302: ireturn
    //   303: astore_0
    //   304: aload 4
    //   306: astore_3
    //   307: aload 5
    //   309: ifnull +8 -> 317
    //   312: aload 5
    //   314: invokevirtual 303	java/io/InputStream:close	()V
    //   317: aload 7
    //   319: ifnull +8 -> 327
    //   322: aload 7
    //   324: invokevirtual 261	java/io/FileOutputStream:close	()V
    //   327: aload_3
    //   328: ifnull +7 -> 335
    //   331: aload_3
    //   332: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   335: aload_0
    //   336: athrow
    //   337: astore_0
    //   338: goto -161 -> 177
    //   341: astore_0
    //   342: goto -155 -> 187
    //   345: astore_0
    //   346: goto -63 -> 283
    //   349: astore_0
    //   350: goto -57 -> 293
    //   353: astore_1
    //   354: goto -37 -> 317
    //   357: astore_1
    //   358: goto -31 -> 327
    //   361: astore_0
    //   362: aload 10
    //   364: astore 7
    //   366: aload 6
    //   368: astore 5
    //   370: goto -63 -> 307
    //   373: astore 4
    //   375: aload 9
    //   377: astore_3
    //   378: aload 4
    //   380: astore 9
    //   382: aload 11
    //   384: astore 6
    //   386: goto -167 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString1	String
    //   0	389	1	paramString2	String
    //   130	73	2	i	int
    //   44	334	3	localObject1	Object
    //   16	289	4	localObject2	Object
    //   373	6	4	localThrowable1	Throwable
    //   24	345	5	localObject3	Object
    //   4	381	6	localObject4	Object
    //   20	345	7	localObject5	Object
    //   28	251	8	localObject6	Object
    //   13	69	9	localObject7	Object
    //   209	167	9	localThrowable2	Throwable
    //   380	1	9	localObject8	Object
    //   7	356	10	localFileOutputStream	FileOutputStream
    //   10	373	11	localObject9	Object
    //   1	59	12	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   98	123	209	java/lang/Throwable
    //   123	131	209	java/lang/Throwable
    //   135	167	209	java/lang/Throwable
    //   197	206	209	java/lang/Throwable
    //   30	45	303	finally
    //   63	69	303	finally
    //   87	98	303	finally
    //   230	273	303	finally
    //   172	177	337	java/io/IOException
    //   182	187	341	java/io/IOException
    //   278	283	345	java/io/IOException
    //   288	293	349	java/io/IOException
    //   312	317	353	java/io/IOException
    //   322	327	357	java/io/IOException
    //   98	123	361	finally
    //   123	131	361	finally
    //   135	167	361	finally
    //   197	206	361	finally
    //   30	45	373	java/lang/Throwable
    //   63	69	373	java/lang/Throwable
    //   87	98	373	java/lang/Throwable
  }
  
  public static boolean extractFile(String paramString1, String paramString2, String paramString3)
  {
    return extractFile(paramString1, paramString2, paramString3, false, "");
  }
  
  public static boolean extractFile(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    JarFile localJarFile;
    JarEntry localJarEntry;
    try
    {
      localJarFile = new JarFile(paramString1);
      Enumeration localEnumeration = localJarFile.entries();
      Certificate[] arrayOfCertificate;
      do
      {
        do
        {
          if (!localEnumeration.hasMoreElements())
          {
            Common.Log.d("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : No such file in Apk");
            return false;
          }
          localJarEntry = (JarEntry)localEnumeration.nextElement();
        } while ((localJarEntry.isDirectory()) || (!localJarEntry.getName().equals(paramString2)));
        if (!paramBoolean) {
          break;
        }
        arrayOfCertificate = loadCertificates(localJarFile, localJarEntry);
      } while ((arrayOfCertificate == null) || (arrayOfCertificate.length != 1));
      if (!new Signature(arrayOfCertificate[0].getEncoded()).equals(new Signature(paramString4)))
      {
        Common.Log.d("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Signature mismatch!");
        return false;
      }
    }
    catch (Exception paramString3)
    {
      Common.Log.d("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Exception " + paramString3);
      return false;
    }
    if (readJarFile(localJarFile, localJarEntry, paramString3))
    {
      Common.Log.d("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " OK");
      return true;
    }
    Common.Log.d("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Read error");
    return false;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!paramContext.hasNext())
      {
        Common.Log.d("KingKongUtils", "Unable to get current process name!");
        return "";
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (localRunningAppProcessInfo.pid != i);
    return localRunningAppProcessInfo.processName;
  }
  
  public static String getFileSHA1String(String paramString)
  {
    try
    {
      paramString = getSHA1String(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString) {}
    return "";
  }
  
  public static String getFileSHA1StringInApk(String paramString1, String paramString2)
    throws IOException
  {
    JarFile localJarFile = new JarFile(paramString1);
    Enumeration localEnumeration = localJarFile.entries();
    paramString1 = "";
    if (!localEnumeration.hasMoreElements()) {}
    for (;;)
    {
      localJarFile.close();
      return paramString1;
      JarEntry localJarEntry = (JarEntry)localEnumeration.nextElement();
      if ((localJarEntry.isDirectory()) || (!localJarEntry.getName().equals(paramString2))) {
        break;
      }
      paramString1 = getSHA1String(localJarFile.getInputStream(localJarEntry));
    }
  }
  
  public static String getPackageName(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageName();
        boolean bool = TextUtils.isEmpty(paramContext);
        if (bool) {
          return "";
        }
      }
      catch (Exception paramContext) {}
    }
    return "";
  }
  
  public static String getRandomString(int paramInt)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[paramInt];
    localSecureRandom.nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 0);
  }
  
  public static String getSHA1String(InputStream paramInputStream)
  {
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0)
        {
          localBufferedInputStream.close();
          paramInputStream.close();
          return Base64.encodeToString(localMessageDigest.digest(), 2).trim();
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      return "";
    }
    catch (Throwable paramInputStream) {}
  }
  
  public static String getSHA1String(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = Base64.encodeToString(localMessageDigest.digest(), 2);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      Common.Log.d("Lynn", "Unable to calculate SHA1");
    }
    return "";
  }
  
  public static boolean isSupportDriver(String paramString)
  {
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return false;
      }
      if ("2.0".equals(paramString[i].trim())) {
        return true;
      }
      i += 1;
    }
  }
  
  public static boolean isSupportSystem(String paramString)
  {
    paramString = paramString.split(",");
    int j = Build.VERSION.SDK_INT;
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        return false;
      }
      if (String.valueOf(j).equals(paramString[i].trim())) {
        return true;
      }
      i += 1;
    }
  }
  
  private static Certificate[] loadCertificates(JarFile paramJarFile, JarEntry paramJarEntry)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = new byte[8192];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      while (paramJarFile.read(arrayOfByte, 0, arrayOfByte.length) != -1) {}
      paramJarFile.close();
      paramJarFile = localObject;
      if (paramJarEntry != null) {
        paramJarFile = paramJarEntry.getCertificates();
      }
      return paramJarFile;
    }
    catch (RuntimeException paramJarFile)
    {
      return null;
    }
    catch (IOException paramJarFile) {}
    return null;
  }
  
  public static StringBuilder obtainStringBuild()
  {
    return new StringBuilder();
  }
  
  private static boolean readJarFile(JarFile paramJarFile, JarEntry paramJarEntry, String paramString)
  {
    try
    {
      byte[] arrayOfByte = new byte[8192];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      paramJarEntry = new FileOutputStream(paramString, false);
      for (;;)
      {
        int i = paramJarFile.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        paramJarEntry.write(arrayOfByte, 0, i);
      }
      paramJarFile.close();
      paramJarEntry.close();
      return true;
    }
    catch (RuntimeException paramJarFile)
    {
      return false;
    }
    catch (IOException paramJarFile) {}
    return false;
  }
  
  public static boolean reloadFile(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramString3.startsWith("META-INF/"))
    {
      Common.Log.d("KingKongUtils", "Reload file with unexpected name : " + paramString3);
      return false;
    }
    if (!paramBoolean) {
      try
      {
        if (extractFile(paramString2, paramString3, paramString1))
        {
          Common.Log.d("KingKongUtils", "Current file changed, reload OK : " + paramString1 + ", " + paramString2);
          return true;
        }
        Common.Log.d("KingKongUtils", "Current file changed and unable to be reloaded : " + paramString1 + ", " + paramString2);
        return false;
      }
      catch (Exception paramString2)
      {
        Common.Log.d("KingKongUtils", "Error occurred while reload file " + paramString1 + " : " + paramString2);
        return false;
      }
    }
    if (copyFile(paramString1, paramString2))
    {
      Common.Log.d("KingKongUtils", "Current file changed, copy OK : " + paramString1);
      return true;
    }
    Common.Log.d("KingKongUtils", "Current file changed and unable to be repaired : " + paramString1);
    return false;
  }
  
  public static boolean verifyAndExtractFile(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return extractFile(paramString1, paramString2, paramString3, true, paramString4);
  }
  
  public static class InterProcessLock
  {
    private FileChannel mFileChannel = null;
    private FileLock mFileLock = null;
    private boolean mInitialized = false;
    private String mLockFileName = "";
    private boolean mLocked = false;
    
    InterProcessLock(String paramString)
    {
      this.mLockFileName = paramString;
      try
      {
        this.mInitialized = true;
        return;
      }
      catch (Exception paramString)
      {
        Common.Log.d("KingKongUtils", "Initial FileChannel exception : " + paramString);
        this.mInitialized = false;
      }
    }
    
    public boolean lock()
    {
      if ((!this.mInitialized) || (this.mLocked)) {
        return false;
      }
      Common.Log.d("KingKongUtils", "Do Inter-Process Lock " + this.mLockFileName);
      try
      {
        this.mFileChannel = new RandomAccessFile(new File(this.mLockFileName), "rw").getChannel();
        this.mFileLock = this.mFileChannel.lock();
        this.mLocked = true;
        Common.Log.d("KingKongUtils", "Do Inter-Process Lock OK " + this.mLockFileName);
        return true;
      }
      catch (Exception localException)
      {
        Common.Log.d("KingKongUtils", "Do Inter-Process Lock " + this.mLockFileName + " exception : " + localException);
        if (this.mFileLock == null) {}
      }
      try
      {
        this.mFileLock.release();
        label157:
        if (this.mFileChannel != null) {}
        try
        {
          this.mFileChannel.close();
          label171:
          Common.Log.d("KingKongUtils", "Do Inter-Process Lock failed " + this.mLockFileName);
          return false;
        }
        catch (IOException localIOException1)
        {
          break label171;
        }
      }
      catch (IOException localIOException2)
      {
        break label157;
      }
    }
    
    public void unlock()
    {
      if (!this.mLocked) {
        return;
      }
      Common.Log.d("KingKongUtils", "Release Inter-Process Lock " + this.mLockFileName);
      if (this.mFileLock != null) {}
      try
      {
        this.mFileLock.release();
        if (this.mFileChannel == null) {}
      }
      catch (IOException localIOException1)
      {
        try
        {
          this.mFileChannel.close();
          this.mLocked = false;
          return;
          localIOException1 = localIOException1;
          Common.Log.d("KingKongUtils", "Release Inter-Process Lock " + this.mLockFileName + " exception : " + localIOException1);
          localIOException1.printStackTrace();
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            Common.Log.d("KingKongUtils", "Release Inter-Process Lock " + this.mLockFileName + " exception : " + localIOException2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.Utils
 * JD-Core Version:    0.7.0.1
 */