package com.tencent.qq.effect.utils;

import android.view.View;
import com.tencent.qq.effect.sensor.SensorParams;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class QEffectUtils
{
  public static boolean fileIsExists(String paramString)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = new File(paramString).exists();
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static String getAssetsFiles(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 31	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: invokevirtual 38	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17: ldc 44
    //   19: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload 4
    //   33: invokestatic 53	com/tencent/qq/effect/utils/QEffectUtils:fileIsExists	(Ljava/lang/String;)Z
    //   36: ifne +70 -> 106
    //   39: aload_0
    //   40: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   43: astore_2
    //   44: aload_2
    //   45: aload_1
    //   46: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 69	java/io/InputStream:available	()I
    //   54: newarray byte
    //   56: astore 6
    //   58: aload_2
    //   59: aload 6
    //   61: invokevirtual 73	java/io/InputStream:read	([B)I
    //   64: pop
    //   65: aload_0
    //   66: aload_1
    //   67: iconst_0
    //   68: invokevirtual 77	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   71: astore_0
    //   72: aload_0
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: aload 6
    //   79: invokevirtual 83	java/io/FileOutputStream:write	([B)V
    //   82: aload_0
    //   83: astore_3
    //   84: aload_2
    //   85: astore_1
    //   86: aload_0
    //   87: invokevirtual 86	java/io/FileOutputStream:flush	()V
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 89	java/io/InputStream:close	()V
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   106: aload 4
    //   108: astore_1
    //   109: aload_1
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   116: goto -10 -> 106
    //   119: astore 4
    //   121: aconst_null
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_0
    //   126: astore_3
    //   127: aload_2
    //   128: astore_1
    //   129: aload 4
    //   131: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 89	java/io/InputStream:close	()V
    //   142: aload 5
    //   144: astore_1
    //   145: aload_0
    //   146: ifnull -37 -> 109
    //   149: aload_0
    //   150: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_0
    //   163: aconst_null
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 89	java/io/InputStream:close	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   190: goto -7 -> 183
    //   193: astore_0
    //   194: aconst_null
    //   195: astore_3
    //   196: aload_2
    //   197: astore_1
    //   198: goto -31 -> 167
    //   201: astore_0
    //   202: goto -35 -> 167
    //   205: astore 4
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -84 -> 125
    //   212: astore 4
    //   214: goto -89 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramContext	android.content.Context
    //   0	217	1	paramString	String
    //   43	154	2	localObject1	Object
    //   73	123	3	localContext	android.content.Context
    //   29	78	4	str	String
    //   119	11	4	localIOException1	IOException
    //   205	1	4	localIOException2	IOException
    //   212	1	4	localIOException3	IOException
    //   1	142	5	localObject2	Object
    //   56	22	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   94	98	111	java/io/IOException
    //   102	106	111	java/io/IOException
    //   44	50	119	java/io/IOException
    //   138	142	155	java/io/IOException
    //   149	153	155	java/io/IOException
    //   44	50	162	finally
    //   171	175	185	java/io/IOException
    //   179	183	185	java/io/IOException
    //   50	72	193	finally
    //   76	82	201	finally
    //   86	90	201	finally
    //   129	134	201	finally
    //   50	72	205	java/io/IOException
    //   76	82	212	java/io/IOException
    //   86	90	212	java/io/IOException
  }
  
  public static int getFileLoadType(String paramString)
  {
    if (isEmpty(paramString)) {
      return 0;
    }
    if ((paramString.contains("http://")) || (paramString.contains("https://"))) {
      return 2;
    }
    return 1;
  }
  
  public static String getFileType(String paramString)
  {
    if (paramString.contains("a.png")) {
      return "a.png";
    }
    if (paramString.contains("alpha.mp4")) {
      return "alpha.mp4";
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1) {
      return null;
    }
    return paramString.substring(i + 1);
  }
  
  public static float getMaxValue(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramArrayOfInt[0] = (paramInt2 - paramInt1);
    }
    for (;;)
    {
      return paramInt1;
      if (Math.abs(paramInt2 - paramArrayOfInt[0]) > paramInt3)
      {
        if (paramInt2 - paramArrayOfInt[0] < 0)
        {
          paramArrayOfInt[0] = (paramInt2 + paramInt3);
          paramInt1 = -paramInt3;
        }
        else
        {
          paramArrayOfInt[0] = (paramInt2 - paramInt3);
          paramInt1 = paramInt3;
        }
      }
      else {
        paramInt1 = paramInt2 - paramArrayOfInt[0];
      }
    }
  }
  
  public static File getRealFileName(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString2.split("/");
    paramString1 = new File(paramString1);
    if (arrayOfString.length > 1)
    {
      int i = 0;
      for (;;)
      {
        if (i >= arrayOfString.length - 1) {
          break label83;
        }
        paramString2 = arrayOfString[i];
        try
        {
          String str1 = new String(paramString2.getBytes("8859_1"), "GB2312");
          paramString2 = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          for (;;)
          {
            localUnsupportedEncodingException1.printStackTrace();
          }
        }
        paramString1 = new File(paramString1, paramString2);
        i += 1;
      }
      label83:
      if (!paramString1.exists()) {
        paramString1.mkdirs();
      }
      paramString2 = arrayOfString[(arrayOfString.length - 1)];
      try
      {
        String str2 = new String(paramString2.getBytes("8859_1"), "GB2312");
        paramString2 = str2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          localUnsupportedEncodingException2.printStackTrace();
        }
      }
      return new File(paramString1, paramString2);
    }
    return new File(paramString1, paramString2);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  /* Error */
  public static String loadShaderFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 165	java/lang/String:isEmpty	()Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 15	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 168	java/io/File:isDirectory	()Z
    //   26: ifne +10 -> 36
    //   29: aload_0
    //   30: invokevirtual 22	java/io/File:exists	()Z
    //   33: ifne +76 -> 109
    //   36: ldc 169
    //   38: new 31	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   45: ldc 171
    //   47: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: invokevirtual 168	java/io/File:isDirectory	()Z
    //   54: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: ldc 176
    //   59: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: invokevirtual 22	java/io/File:exists	()Z
    //   66: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: ldc 169
    //   81: new 31	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   88: ldc 184
    //   90: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: invokevirtual 185	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   97: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: aconst_null
    //   108: areturn
    //   109: new 187	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   117: astore_0
    //   118: new 31	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   125: astore_1
    //   126: aload_0
    //   127: ifnull +143 -> 270
    //   130: new 192	java/io/BufferedReader
    //   133: dup
    //   134: new 194	java/io/InputStreamReader
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 197	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   142: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   145: astore_2
    //   146: aload_2
    //   147: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   150: astore_3
    //   151: aload_3
    //   152: ifnull +114 -> 266
    //   155: aload_1
    //   156: aload_3
    //   157: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 205
    //   162: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: goto -20 -> 146
    //   169: astore_1
    //   170: ldc 169
    //   172: new 31	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   179: ldc 207
    //   181: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   188: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   197: pop
    //   198: aload_0
    //   199: invokevirtual 89	java/io/InputStream:close	()V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_0
    //   205: ldc 169
    //   207: new 31	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   214: ldc 210
    //   216: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   223: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   232: pop
    //   233: aconst_null
    //   234: areturn
    //   235: astore_0
    //   236: ldc 169
    //   238: new 31	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   245: ldc 212
    //   247: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: invokevirtual 213	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   254: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: aconst_null
    //   265: areturn
    //   266: aload_0
    //   267: invokevirtual 89	java/io/InputStream:close	()V
    //   270: aload_1
    //   271: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: areturn
    //   275: astore_0
    //   276: ldc 169
    //   278: new 31	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   285: ldc 210
    //   287: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_0
    //   291: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   294: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   303: pop
    //   304: goto -34 -> 270
    //   307: astore_1
    //   308: aload_0
    //   309: invokevirtual 89	java/io/InputStream:close	()V
    //   312: aload_1
    //   313: athrow
    //   314: astore_0
    //   315: ldc 169
    //   317: new 31	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   324: ldc 210
    //   326: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   333: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   342: pop
    //   343: goto -31 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramString	String
    //   125	31	1	localStringBuilder	java.lang.StringBuilder
    //   169	102	1	localIOException	IOException
    //   307	6	1	localObject	Object
    //   145	2	2	localBufferedReader	java.io.BufferedReader
    //   150	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   13	22	78	java/lang/NullPointerException
    //   130	146	169	java/io/IOException
    //   146	151	169	java/io/IOException
    //   155	166	169	java/io/IOException
    //   198	202	204	java/io/IOException
    //   109	118	235	java/io/FileNotFoundException
    //   266	270	275	java/io/IOException
    //   130	146	307	finally
    //   146	151	307	finally
    //   155	166	307	finally
    //   170	198	307	finally
    //   308	312	314	java/io/IOException
  }
  
  /* Error */
  public static String readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 216	java/lang/StringBuffer
    //   5: dup
    //   6: invokespecial 217	java/lang/StringBuffer:<init>	()V
    //   9: astore_3
    //   10: new 192	java/io/BufferedReader
    //   13: dup
    //   14: new 194	java/io/InputStreamReader
    //   17: dup
    //   18: new 187	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: ldc 220
    //   28: invokespecial 223	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   31: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +34 -> 77
    //   46: aload_1
    //   47: astore_0
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual 226	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   53: pop
    //   54: goto -19 -> 35
    //   57: astore_2
    //   58: aload_1
    //   59: astore_0
    //   60: aload_2
    //   61: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 227	java/io/BufferedReader:close	()V
    //   72: aload_3
    //   73: invokevirtual 228	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   76: areturn
    //   77: aload_1
    //   78: astore_0
    //   79: aload_1
    //   80: invokevirtual 227	java/io/BufferedReader:close	()V
    //   83: iconst_0
    //   84: ifeq -12 -> 72
    //   87: new 161	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 229	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   100: goto -28 -> 72
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   108: goto -36 -> 72
    //   111: astore_0
    //   112: aload_2
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 227	java/io/BufferedReader:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   129: goto -7 -> 122
    //   132: astore_2
    //   133: aload_0
    //   134: astore_1
    //   135: aload_2
    //   136: astore_0
    //   137: goto -23 -> 114
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: goto -85 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   34	85	1	localObject1	Object
    //   124	2	1	localIOException1	IOException
    //   134	9	1	str1	String
    //   1	49	2	str2	String
    //   57	56	2	localIOException2	IOException
    //   132	4	2	localObject2	Object
    //   140	1	2	localIOException3	IOException
    //   9	64	3	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   37	42	57	java/io/IOException
    //   48	54	57	java/io/IOException
    //   79	83	57	java/io/IOException
    //   87	95	95	java/io/IOException
    //   68	72	103	java/io/IOException
    //   10	35	111	finally
    //   118	122	124	java/io/IOException
    //   37	42	132	finally
    //   48	54	132	finally
    //   60	64	132	finally
    //   79	83	132	finally
    //   10	35	140	java/io/IOException
  }
  
  public static void upZipFile(File paramFile, String paramString)
    throws IOException
  {
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    paramFile = new ZipFile(paramFile);
    localObject1 = paramFile.entries();
    byte[] arrayOfByte = new byte[1024];
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject2 = (ZipEntry)((Enumeration)localObject1).nextElement();
      if ((((ZipEntry)localObject2).getName() != null) && (!((ZipEntry)localObject2).getName().contains("../"))) {
        if (((ZipEntry)localObject2).isDirectory())
        {
          new File(new String((paramString + ((ZipEntry)localObject2).getName()).getBytes("8859_1"), "GB2312")).mkdir();
        }
        else if (!getRealFileName(paramString, ((ZipEntry)localObject2).getName()).exists())
        {
          BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getRealFileName(paramString, ((ZipEntry)localObject2).getName())));
          localObject2 = new BufferedInputStream(paramFile.getInputStream((ZipEntry)localObject2));
          for (;;)
          {
            int i = ((InputStream)localObject2).read(arrayOfByte, 0, 1024);
            if (i == -1) {
              break;
            }
            localBufferedOutputStream.write(arrayOfByte, 0, i);
          }
          ((InputStream)localObject2).close();
          localBufferedOutputStream.close();
        }
      }
    }
    paramFile.close();
  }
  
  public static void updateGravityData(View paramView, float[] paramArrayOfFloat, SensorParams paramSensorParams, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramSensorParams != null)
    {
      i = (int)(paramArrayOfFloat[0] * paramSensorParams.layerOffsetX * paramSensorParams.speed);
      j = (int)(paramArrayOfFloat[1] * paramSensorParams.layerOffsetY * paramSensorParams.speed);
      if (!paramSensorParams.isInit)
      {
        paramSensorParams.isInit = true;
        paramSensorParams.offsetX[0] = i;
        paramSensorParams.offsetY[0] = j;
      }
    }
    else
    {
      return;
    }
    paramView.setTranslationX(getMaxValue((int)paramView.getTranslationX(), i, Math.abs(paramSensorParams.layerOffsetX), paramSensorParams.offsetX, paramBoolean));
    paramView.setTranslationY(getMaxValue((int)paramView.getTranslationY(), j, Math.abs(paramSensorParams.layerOffsetY), paramSensorParams.offsetY, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.utils.QEffectUtils
 * JD-Core Version:    0.7.0.1
 */