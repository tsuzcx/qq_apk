package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import etq;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FileUtils
{
  public static final long a = 1024L;
  public static Runnable a;
  public static final String a = "FileUtils";
  public static boolean a = false;
  public static final long b = 1048576L;
  public static String b = "unknown_";
  public static final long c = 1073741824L;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangRunnable = new etq();
  }
  
  public static float a()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int k = 0;
    paramString1 = new File(paramString1);
    int i;
    if (!paramString1.exists()) {
      i = -1;
    }
    File localFile1;
    int j;
    do
    {
      return i;
      paramString1 = paramString1.listFiles();
      localFile1 = new File(paramString2);
      if (!localFile1.exists()) {
        localFile1.mkdirs();
      }
      j = 0;
      i = k;
    } while (j >= paramString1.length);
    if (paramString1[j].isDirectory()) {
      a(paramString1[j].getPath() + "/", paramString2 + paramString1[j].getName() + "/", paramBoolean);
    }
    for (;;)
    {
      j += 1;
      break;
      localFile1 = new File(paramString1[j].getPath());
      File localFile2 = new File(paramString2 + paramString1[j].getName());
      if ((localFile1 == null) || (localFile2 == null) || (!localFile1.exists())) {
        continue;
      }
      if (!localFile2.exists()) {}
      try
      {
        localFile2.createNewFile();
        a(localFile1, localFile2);
        label231:
        if (!paramBoolean) {
          continue;
        }
        localFile1.delete();
      }
      catch (IOException localIOException)
      {
        break label231;
      }
    }
  }
  
  /* Error */
  public static long a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: new 48	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 73	java/io/File:exists	()Z
    //   18: ifeq +37 -> 55
    //   21: new 112	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 118	java/io/FileInputStream:available	()I
    //   34: istore_1
    //   35: iload_1
    //   36: i2l
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: invokevirtual 121	java/io/FileInputStream:close	()V
    //   50: lload 4
    //   52: lstore_2
    //   53: lload_2
    //   54: lreturn
    //   55: iconst_0
    //   56: ifeq -3 -> 53
    //   59: new 123	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull -21 -> 53
    //   77: aload_0
    //   78: invokevirtual 121	java/io/FileInputStream:close	()V
    //   81: lconst_0
    //   82: lreturn
    //   83: astore_0
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: aload 6
    //   89: ifnull +8 -> 97
    //   92: aload 6
    //   94: invokevirtual 121	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: lload 4
    //   102: lreturn
    //   103: astore 6
    //   105: goto -8 -> 97
    //   108: astore 7
    //   110: aload_0
    //   111: astore 6
    //   113: aload 7
    //   115: astore_0
    //   116: goto -29 -> 87
    //   119: astore 6
    //   121: goto -48 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   34	2	1	i	int
    //   1	53	2	l1	long
    //   37	64	4	l2	long
    //   3	90	6	localObject1	Object
    //   103	1	6	localIOException	IOException
    //   111	1	6	str	String
    //   119	1	6	localException	Exception
    //   108	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   5	30	70	java/lang/Exception
    //   77	81	83	java/io/IOException
    //   5	30	86	finally
    //   46	50	99	java/io/IOException
    //   92	97	103	java/io/IOException
    //   30	35	108	finally
    //   30	35	119	java/lang/Exception
  }
  
  public static File a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  public static String a(int paramInt, long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      if (paramInt == 0) {
        str = "0.0B";
      }
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "0.0K";
      }
      str = null;
      DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
      float f;
      if (paramLong / 1073741824L > 0L)
      {
        f = (float)paramLong / 1.073742E+009F;
        str = localDecimalFormat.format(f);
        if (str.endsWith(".0")) {
          return (int)f + "G";
        }
        return str + "G";
      }
      if (paramLong / 1048576L > 0L)
      {
        f = (float)paramLong / 1048576.0F;
        str = localDecimalFormat.format(f);
        if (str.endsWith(".0")) {
          return (int)f + "M";
        }
        return str + "M";
      }
      if (paramLong / 1024L > 0L)
      {
        paramInt = (int)(paramLong / 1024L);
        return paramInt + "K";
      }
      if (paramInt == 0) {
        return localDecimalFormat.format(paramLong) + "B";
      }
    } while (paramInt != 1);
    paramInt = (int)(paramLong / 1024L);
    return paramInt + "K";
  }
  
  public static String a(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.00");
    double d1 = 1024.0D * 1024.0D;
    double d2 = 1024.0D * d1;
    if (paramLong < 1024.0D) {
      return localDecimalFormat.format(paramLong) + "B";
    }
    if (paramLong < d1) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "KB";
    }
    if (paramLong < d2) {
      return localDecimalFormat.format(paramLong / d1) + "MB";
    }
    return localDecimalFormat.format(paramLong / d2) + "GB";
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 179	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 180	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 5
    //   11: new 112	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 9
    //   21: aload 5
    //   23: astore 7
    //   25: aload 9
    //   27: astore 6
    //   29: aload_0
    //   30: invokevirtual 184	java/io/File:length	()J
    //   33: lstore_3
    //   34: aload 5
    //   36: astore 7
    //   38: aload 9
    //   40: astore 6
    //   42: sipush 2048
    //   45: newarray byte
    //   47: astore_0
    //   48: iload_1
    //   49: i2l
    //   50: lload_3
    //   51: lcmp
    //   52: ifge +41 -> 93
    //   55: aload 5
    //   57: astore 7
    //   59: aload 9
    //   61: astore 6
    //   63: aload 9
    //   65: aload_0
    //   66: invokevirtual 188	java/io/FileInputStream:read	([B)I
    //   69: istore_2
    //   70: aload 5
    //   72: astore 7
    //   74: aload 9
    //   76: astore 6
    //   78: aload 5
    //   80: aload_0
    //   81: iconst_0
    //   82: iload_2
    //   83: invokevirtual 192	java/io/ByteArrayOutputStream:write	([BII)V
    //   86: iload_1
    //   87: iload_2
    //   88: iadd
    //   89: istore_1
    //   90: goto -42 -> 48
    //   93: aload 5
    //   95: astore 7
    //   97: aload 9
    //   99: astore 6
    //   101: new 147	java/lang/String
    //   104: dup
    //   105: aload 5
    //   107: invokevirtual 196	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   110: ldc 198
    //   112: invokespecial 201	java/lang/String:<init>	([BLjava/lang/String;)V
    //   115: astore_0
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 202	java/io/ByteArrayOutputStream:close	()V
    //   126: aload 9
    //   128: ifnull +8 -> 136
    //   131: aload 9
    //   133: invokevirtual 121	java/io/FileInputStream:close	()V
    //   136: aload_0
    //   137: areturn
    //   138: astore 5
    //   140: aload 5
    //   142: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   145: aload_0
    //   146: areturn
    //   147: astore 8
    //   149: aconst_null
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 5
    //   156: astore 7
    //   158: aload_0
    //   159: astore 6
    //   161: aload 8
    //   163: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   166: aload 5
    //   168: ifnull +8 -> 176
    //   171: aload 5
    //   173: invokevirtual 202	java/io/ByteArrayOutputStream:close	()V
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 121	java/io/FileInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_0
    //   194: aconst_null
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 6
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 202	java/io/ByteArrayOutputStream:close	()V
    //   210: aload 6
    //   212: ifnull +8 -> 220
    //   215: aload 6
    //   217: invokevirtual 121	java/io/FileInputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: astore 5
    //   224: aload 5
    //   226: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   229: goto -9 -> 220
    //   232: astore_0
    //   233: aconst_null
    //   234: astore 6
    //   236: goto -36 -> 200
    //   239: astore_0
    //   240: aload 7
    //   242: astore 5
    //   244: goto -44 -> 200
    //   247: astore 8
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -97 -> 154
    //   254: astore 8
    //   256: aload 9
    //   258: astore_0
    //   259: goto -105 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramFile	File
    //   1	89	1	i	int
    //   69	20	2	j	int
    //   33	18	3	l	long
    //   9	113	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   138	3	5	localIOException1	IOException
    //   150	56	5	localObject1	Object
    //   222	3	5	localIOException2	IOException
    //   242	1	5	localObject2	Object
    //   27	208	6	localObject3	Object
    //   23	218	7	localObject4	Object
    //   147	15	8	localIOException3	IOException
    //   247	1	8	localIOException4	IOException
    //   254	1	8	localIOException5	IOException
    //   19	238	9	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   121	126	138	java/io/IOException
    //   131	136	138	java/io/IOException
    //   2	11	147	java/io/IOException
    //   171	176	186	java/io/IOException
    //   180	184	186	java/io/IOException
    //   2	11	193	finally
    //   205	210	222	java/io/IOException
    //   215	220	222	java/io/IOException
    //   11	21	232	finally
    //   29	34	239	finally
    //   42	48	239	finally
    //   63	70	239	finally
    //   78	86	239	finally
    //   101	116	239	finally
    //   161	166	239	finally
    //   11	21	247	java/io/IOException
    //   29	34	254	java/io/IOException
    //   42	48	254	java/io/IOException
    //   63	70	254	java/io/IOException
    //   78	86	254	java/io/IOException
    //   101	116	254	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 112	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 209	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: iconst_2
    //   12: newarray byte
    //   14: astore_0
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 188	java/io/FileInputStream:read	([B)I
    //   22: iconst_m1
    //   23: if_icmpeq +130 -> 153
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: invokestatic 212	com/tencent/mobileqq/utils/FileUtils:a	([B)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 121	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokevirtual 121	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: ldc 214
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: invokevirtual 215	java/io/FileNotFoundException:printStackTrace	()V
    //   65: aload_0
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull -17 -> 51
    //   71: aload_2
    //   72: invokevirtual 121	java/io/FileInputStream:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: ldc 214
    //   85: astore_0
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: astore_1
    //   94: aload_2
    //   95: ifnull -44 -> 51
    //   98: aload_2
    //   99: invokevirtual 121	java/io/FileInputStream:close	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: aload_0
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 121	java/io/FileInputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: areturn
    //   123: astore_1
    //   124: goto -6 -> 118
    //   127: astore_0
    //   128: goto -18 -> 110
    //   131: astore_3
    //   132: ldc 214
    //   134: astore_0
    //   135: goto -49 -> 86
    //   138: astore_3
    //   139: goto -53 -> 86
    //   142: astore_3
    //   143: ldc 214
    //   145: astore_0
    //   146: goto -87 -> 59
    //   149: astore_3
    //   150: goto -91 -> 59
    //   153: ldc 214
    //   155: astore_0
    //   156: goto -123 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   10	57	1	localObject1	Object
    //   77	1	1	localIOException1	IOException
    //   87	7	1	localObject2	Object
    //   104	1	1	localIOException2	IOException
    //   109	6	1	localObject3	Object
    //   120	1	1	localIOException3	IOException
    //   123	1	1	localIOException4	IOException
    //   8	91	2	localFileInputStream	java.io.FileInputStream
    //   53	9	3	localFileNotFoundException1	FileNotFoundException
    //   80	9	3	localIOException5	IOException
    //   131	1	3	localIOException6	IOException
    //   138	1	3	localIOException7	IOException
    //   142	1	3	localFileNotFoundException2	FileNotFoundException
    //   149	1	3	localFileNotFoundException3	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/io/FileNotFoundException
    //   71	75	77	java/io/IOException
    //   0	9	80	java/io/IOException
    //   98	102	104	java/io/IOException
    //   0	9	107	finally
    //   45	49	120	java/io/IOException
    //   114	118	123	java/io/IOException
    //   11	15	127	finally
    //   17	26	127	finally
    //   28	33	127	finally
    //   35	39	127	finally
    //   61	65	127	finally
    //   88	92	127	finally
    //   11	15	131	java/io/IOException
    //   17	26	131	java/io/IOException
    //   28	33	131	java/io/IOException
    //   35	39	138	java/io/IOException
    //   11	15	142	java/io/FileNotFoundException
    //   17	26	142	java/io/FileNotFoundException
    //   28	33	142	java/io/FileNotFoundException
    //   35	39	149	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 48	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +17 -> 29
    //   15: aload_0
    //   16: invokevirtual 73	java/io/File:exists	()Z
    //   19: ifeq +10 -> 29
    //   22: aload_0
    //   23: invokevirtual 221	java/io/File:isFile	()Z
    //   26: ifne +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokestatic 227	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore 4
    //   37: new 112	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: sipush 1024
    //   49: newarray byte
    //   51: astore 5
    //   53: bipush 16
    //   55: newarray char
    //   57: astore_0
    //   58: aload_0
    //   59: dup
    //   60: iconst_0
    //   61: ldc 228
    //   63: castore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 229
    //   68: castore
    //   69: dup
    //   70: iconst_2
    //   71: ldc 230
    //   73: castore
    //   74: dup
    //   75: iconst_3
    //   76: ldc 231
    //   78: castore
    //   79: dup
    //   80: iconst_4
    //   81: ldc 232
    //   83: castore
    //   84: dup
    //   85: iconst_5
    //   86: ldc 233
    //   88: castore
    //   89: dup
    //   90: bipush 6
    //   92: ldc 234
    //   94: castore
    //   95: dup
    //   96: bipush 7
    //   98: ldc 235
    //   100: castore
    //   101: dup
    //   102: bipush 8
    //   104: ldc 236
    //   106: castore
    //   107: dup
    //   108: bipush 9
    //   110: ldc 237
    //   112: castore
    //   113: dup
    //   114: bipush 10
    //   116: ldc 238
    //   118: castore
    //   119: dup
    //   120: bipush 11
    //   122: ldc 239
    //   124: castore
    //   125: dup
    //   126: bipush 12
    //   128: ldc 240
    //   130: castore
    //   131: dup
    //   132: bipush 13
    //   134: ldc 241
    //   136: castore
    //   137: dup
    //   138: bipush 14
    //   140: ldc 242
    //   142: castore
    //   143: dup
    //   144: bipush 15
    //   146: ldc 243
    //   148: castore
    //   149: pop
    //   150: aload_1
    //   151: aload 5
    //   153: invokevirtual 188	java/io/FileInputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: ifle +28 -> 186
    //   161: aload 4
    //   163: aload 5
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 246	java/security/MessageDigest:update	([BII)V
    //   170: goto -20 -> 150
    //   173: astore_0
    //   174: aload_1
    //   175: ifnull +195 -> 370
    //   178: aload_1
    //   179: invokevirtual 121	java/io/FileInputStream:close	()V
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: areturn
    //   186: aload 4
    //   188: invokevirtual 249	java/security/MessageDigest:digest	()[B
    //   191: astore 4
    //   193: aload 4
    //   195: ifnull +11 -> 206
    //   198: aload 4
    //   200: arraylength
    //   201: istore_3
    //   202: iload_3
    //   203: ifne +16 -> 219
    //   206: aload_1
    //   207: ifnull -178 -> 29
    //   210: aload_1
    //   211: invokevirtual 121	java/io/FileInputStream:close	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_0
    //   217: aconst_null
    //   218: areturn
    //   219: aload 4
    //   221: arraylength
    //   222: iconst_2
    //   223: imul
    //   224: newarray char
    //   226: astore 5
    //   228: iload_2
    //   229: aload 4
    //   231: arraylength
    //   232: if_icmpge +44 -> 276
    //   235: aload 4
    //   237: iload_2
    //   238: baload
    //   239: istore_3
    //   240: aload 5
    //   242: iload_2
    //   243: iconst_2
    //   244: imul
    //   245: iconst_1
    //   246: iadd
    //   247: aload_0
    //   248: iload_3
    //   249: bipush 15
    //   251: iand
    //   252: caload
    //   253: castore
    //   254: aload 5
    //   256: iload_2
    //   257: iconst_2
    //   258: imul
    //   259: aload_0
    //   260: iload_3
    //   261: iconst_4
    //   262: iushr
    //   263: i2b
    //   264: bipush 15
    //   266: iand
    //   267: caload
    //   268: castore
    //   269: iload_2
    //   270: iconst_1
    //   271: iadd
    //   272: istore_2
    //   273: goto -45 -> 228
    //   276: new 147	java/lang/String
    //   279: dup
    //   280: aload 5
    //   282: invokespecial 252	java/lang/String:<init>	([C)V
    //   285: astore 4
    //   287: aload 4
    //   289: astore_0
    //   290: aload_1
    //   291: ifnull -107 -> 184
    //   294: aload_1
    //   295: invokevirtual 121	java/io/FileInputStream:close	()V
    //   298: aload 4
    //   300: astore_0
    //   301: goto -117 -> 184
    //   304: astore_0
    //   305: aload 4
    //   307: astore_0
    //   308: goto -124 -> 184
    //   311: astore_0
    //   312: aconst_null
    //   313: astore_0
    //   314: goto -130 -> 184
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_1
    //   320: aload_1
    //   321: ifnull +49 -> 370
    //   324: aload_1
    //   325: invokevirtual 121	java/io/FileInputStream:close	()V
    //   328: aconst_null
    //   329: astore_0
    //   330: goto -146 -> 184
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -152 -> 184
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_1
    //   342: aload_1
    //   343: ifnull +7 -> 350
    //   346: aload_1
    //   347: invokevirtual 121	java/io/FileInputStream:close	()V
    //   350: aload_0
    //   351: athrow
    //   352: astore_1
    //   353: goto -3 -> 350
    //   356: astore_0
    //   357: goto -15 -> 342
    //   360: astore_0
    //   361: goto -41 -> 320
    //   364: astore_0
    //   365: aconst_null
    //   366: astore_1
    //   367: goto -193 -> 174
    //   370: aconst_null
    //   371: astore_0
    //   372: goto -188 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString1	String
    //   0	375	1	paramString2	String
    //   1	272	2	i	int
    //   156	107	3	j	int
    //   35	271	4	localObject1	Object
    //   51	230	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	150	173	java/io/IOException
    //   150	157	173	java/io/IOException
    //   161	170	173	java/io/IOException
    //   186	193	173	java/io/IOException
    //   198	202	173	java/io/IOException
    //   219	228	173	java/io/IOException
    //   228	235	173	java/io/IOException
    //   276	287	173	java/io/IOException
    //   210	214	216	java/io/IOException
    //   294	298	304	java/io/IOException
    //   178	182	311	java/io/IOException
    //   31	46	317	java/security/NoSuchAlgorithmException
    //   324	328	333	java/io/IOException
    //   31	46	339	finally
    //   346	350	352	java/io/IOException
    //   46	150	356	finally
    //   150	157	356	finally
    //   161	170	356	finally
    //   186	193	356	finally
    //   198	202	356	finally
    //   219	228	356	finally
    //   228	235	356	finally
    //   276	287	356	finally
    //   46	150	360	java/security/NoSuchAlgorithmException
    //   150	157	360	java/security/NoSuchAlgorithmException
    //   161	170	360	java/security/NoSuchAlgorithmException
    //   186	193	360	java/security/NoSuchAlgorithmException
    //   198	202	360	java/security/NoSuchAlgorithmException
    //   219	228	360	java/security/NoSuchAlgorithmException
    //   228	235	360	java/security/NoSuchAlgorithmException
    //   276	287	360	java/security/NoSuchAlgorithmException
    //   31	46	364	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        str = str + Integer.toString(paramArrayOfByte[i] & 0xFF);
        i += 1;
      }
      switch (Integer.parseInt(str))
      {
      default: 
        return b + str;
      case 7790: 
        return "exe";
      case 7784: 
        return "midi";
      case 8297: 
        return "rar";
      case 8075: 
        return "zip";
      case 255216: 
        return "jpg";
      case 7173: 
        return "gif";
      case 6677: 
        return "bmp";
      case 13780: 
        return "png";
      }
      return "webp";
    }
    return b + "";
  }
  
  public static ArrayList a(String paramString)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int i = 0;
    for (;;)
    {
      try
      {
        int j = localObject.length;
        if (i < j) {
          if (localObject[i].isDirectory()) {
            paramString.addAll(a(localObject[i].getCanonicalPath()));
          } else {
            paramString.add(localObject[i].getCanonicalPath());
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramString;
      i += 1;
    }
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_1
    //   6: invokevirtual 73	java/io/File:exists	()Z
    //   9: ifeq +8 -> 17
    //   12: aload_1
    //   13: invokevirtual 109	java/io/File:delete	()Z
    //   16: pop
    //   17: new 301	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 302	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore_1
    //   26: new 112	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_0
    //   35: sipush 4096
    //   38: newarray byte
    //   40: astore_3
    //   41: aload_0
    //   42: aload_3
    //   43: invokevirtual 188	java/io/FileInputStream:read	([B)I
    //   46: istore_2
    //   47: iload_2
    //   48: iconst_m1
    //   49: if_icmpeq +41 -> 90
    //   52: aload_1
    //   53: aload_3
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 303	java/io/FileOutputStream:write	([BII)V
    //   59: aload_1
    //   60: invokevirtual 306	java/io/FileOutputStream:flush	()V
    //   63: goto -22 -> 41
    //   66: astore_3
    //   67: aload_0
    //   68: astore_3
    //   69: aload_1
    //   70: astore_0
    //   71: aload_3
    //   72: astore_1
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 121	java/io/FileInputStream:close	()V
    //   89: return
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   98: aload_0
    //   99: ifnull -10 -> 89
    //   102: aload_0
    //   103: invokevirtual 121	java/io/FileInputStream:close	()V
    //   106: return
    //   107: astore_0
    //   108: return
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload 4
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   123: aload_0
    //   124: ifnull -35 -> 89
    //   127: aload_0
    //   128: invokevirtual 121	java/io/FileInputStream:close	()V
    //   131: return
    //   132: astore_0
    //   133: return
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 121	java/io/FileInputStream:close	()V
    //   155: aload_3
    //   156: athrow
    //   157: astore_1
    //   158: goto -60 -> 98
    //   161: astore_0
    //   162: goto -81 -> 81
    //   165: astore_0
    //   166: return
    //   167: astore_1
    //   168: goto -45 -> 123
    //   171: astore_1
    //   172: goto -25 -> 147
    //   175: astore_0
    //   176: goto -21 -> 155
    //   179: astore_3
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -43 -> 139
    //   185: astore_3
    //   186: goto -47 -> 139
    //   189: astore_0
    //   190: aload 4
    //   192: astore_0
    //   193: goto -78 -> 115
    //   196: astore_3
    //   197: goto -82 -> 115
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_3
    //   204: astore_1
    //   205: goto -132 -> 73
    //   208: astore_0
    //   209: aload_1
    //   210: astore_0
    //   211: aload_3
    //   212: astore_1
    //   213: goto -140 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramFile1	File
    //   0	216	1	paramFile2	File
    //   46	10	2	i	int
    //   4	50	3	arrayOfByte	byte[]
    //   66	1	3	localIOException	IOException
    //   68	4	3	localFile	File
    //   134	22	3	localObject1	Object
    //   179	1	3	localObject2	Object
    //   185	1	3	localObject3	Object
    //   196	16	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1	190	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   35	41	66	java/io/IOException
    //   41	47	66	java/io/IOException
    //   52	63	66	java/io/IOException
    //   102	106	107	java/io/IOException
    //   5	17	109	java/lang/OutOfMemoryError
    //   17	26	109	java/lang/OutOfMemoryError
    //   127	131	132	java/io/IOException
    //   5	17	134	finally
    //   17	26	134	finally
    //   94	98	157	java/io/IOException
    //   77	81	161	java/io/IOException
    //   85	89	165	java/io/IOException
    //   119	123	167	java/io/IOException
    //   143	147	171	java/io/IOException
    //   151	155	175	java/io/IOException
    //   26	35	179	finally
    //   35	41	185	finally
    //   41	47	185	finally
    //   52	63	185	finally
    //   26	35	189	java/lang/OutOfMemoryError
    //   35	41	196	java/lang/OutOfMemoryError
    //   41	47	196	java/lang/OutOfMemoryError
    //   52	63	196	java/lang/OutOfMemoryError
    //   5	17	200	java/io/IOException
    //   17	26	200	java/io/IOException
    //   26	35	208	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    paramString = new File(paramString);
    File[] arrayOfFile = paramString.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i = 0;
      if (i < arrayOfFile.length)
      {
        if (arrayOfFile[i].isDirectory()) {
          a(arrayOfFile[i].getAbsolutePath());
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFile[i].delete();
        }
      }
    }
    paramString.delete();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +39 -> 48
    //   12: ldc 12
    //   14: iconst_2
    //   15: new 85	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 325
    //   25: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 327
    //   35: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 112	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 209	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_0
    //   57: new 333	java/io/BufferedInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 336	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore 4
    //   67: new 338	java/util/zip/ZipInputStream
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 339	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore 5
    //   78: new 48	java/io/File
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 80	java/io/File:mkdirs	()Z
    //   89: pop
    //   90: aconst_null
    //   91: astore 8
    //   93: aload 6
    //   95: astore 7
    //   97: aload 5
    //   99: invokevirtual 343	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   102: astore 6
    //   104: aload 6
    //   106: ifnonnull +52 -> 158
    //   109: aload 5
    //   111: ifnull +8 -> 119
    //   114: aload 5
    //   116: invokevirtual 344	java/util/zip/ZipInputStream:close	()V
    //   119: aload 4
    //   121: ifnull +8 -> 129
    //   124: aload 4
    //   126: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 121	java/io/FileInputStream:close	()V
    //   137: aload 8
    //   139: ifnull +8 -> 147
    //   142: aload 8
    //   144: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   147: aload 7
    //   149: ifnull +8 -> 157
    //   152: aload 7
    //   154: invokevirtual 348	java/io/BufferedOutputStream:close	()V
    //   157: return
    //   158: aload 6
    //   160: invokevirtual 351	java/util/zip/ZipEntry:isDirectory	()Z
    //   163: ifne -66 -> 97
    //   166: aload 6
    //   168: invokevirtual 352	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   171: astore 6
    //   173: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +30 -> 206
    //   179: ldc 12
    //   181: iconst_2
    //   182: new 85	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 354
    //   192: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 6
    //   197: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload 6
    //   208: getstatic 358	java/io/File:separatorChar	C
    //   211: invokevirtual 362	java/lang/String:lastIndexOf	(I)I
    //   214: istore_3
    //   215: iload_3
    //   216: aload 6
    //   218: invokevirtual 312	java/lang/String:length	()I
    //   221: iconst_1
    //   222: isub
    //   223: if_icmpne +103 -> 326
    //   226: new 364	java/lang/IllegalArgumentException
    //   229: dup
    //   230: new 85	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 366
    //   240: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 6
    //   245: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokespecial 367	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   254: athrow
    //   255: astore 9
    //   257: aload 5
    //   259: astore_1
    //   260: aload_0
    //   261: astore 6
    //   263: aload 4
    //   265: astore 5
    //   267: aload_1
    //   268: astore 4
    //   270: aload 8
    //   272: astore_1
    //   273: aload 9
    //   275: astore_0
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 344	java/util/zip/ZipInputStream:close	()V
    //   286: aload 5
    //   288: ifnull +8 -> 296
    //   291: aload 5
    //   293: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   296: aload 6
    //   298: ifnull +8 -> 306
    //   301: aload 6
    //   303: invokevirtual 121	java/io/FileInputStream:close	()V
    //   306: aload_1
    //   307: ifnull +7 -> 314
    //   310: aload_1
    //   311: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   314: aload 7
    //   316: ifnull +8 -> 324
    //   319: aload 7
    //   321: invokevirtual 348	java/io/BufferedOutputStream:close	()V
    //   324: aload_0
    //   325: athrow
    //   326: iload_3
    //   327: ifgt +206 -> 533
    //   330: iload_3
    //   331: ifge +188 -> 519
    //   334: aload_1
    //   335: astore 9
    //   337: aload 6
    //   339: astore 10
    //   341: iload_2
    //   342: ifeq +29 -> 371
    //   345: aload 6
    //   347: ldc_w 369
    //   350: invokevirtual 371	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   353: istore_3
    //   354: aload 6
    //   356: astore 10
    //   358: iload_3
    //   359: ifle +12 -> 371
    //   362: aload 6
    //   364: iconst_0
    //   365: iload_3
    //   366: invokevirtual 375	java/lang/String:substring	(II)Ljava/lang/String;
    //   369: astore 10
    //   371: new 48	java/io/File
    //   374: dup
    //   375: aload 9
    //   377: aload 10
    //   379: invokespecial 378	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: astore 6
    //   384: aload 6
    //   386: invokevirtual 128	java/io/File:getParentFile	()Ljava/io/File;
    //   389: invokevirtual 73	java/io/File:exists	()Z
    //   392: ifne +12 -> 404
    //   395: aload 6
    //   397: invokevirtual 128	java/io/File:getParentFile	()Ljava/io/File;
    //   400: invokevirtual 80	java/io/File:mkdirs	()Z
    //   403: pop
    //   404: aload 6
    //   406: invokevirtual 73	java/io/File:exists	()Z
    //   409: ifeq +9 -> 418
    //   412: aload 6
    //   414: invokevirtual 109	java/io/File:delete	()Z
    //   417: pop
    //   418: aload 6
    //   420: invokevirtual 103	java/io/File:createNewFile	()Z
    //   423: pop
    //   424: sipush 2048
    //   427: newarray byte
    //   429: astore 9
    //   431: new 301	java/io/FileOutputStream
    //   434: dup
    //   435: aload 6
    //   437: invokespecial 302	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   440: astore 6
    //   442: new 347	java/io/BufferedOutputStream
    //   445: dup
    //   446: aload 6
    //   448: aload 9
    //   450: arraylength
    //   451: invokespecial 381	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   454: astore 8
    //   456: aload 5
    //   458: aload 9
    //   460: iconst_0
    //   461: aload 9
    //   463: arraylength
    //   464: invokevirtual 384	java/util/zip/ZipInputStream:read	([BII)I
    //   467: istore_3
    //   468: iload_3
    //   469: iconst_m1
    //   470: if_icmpeq +148 -> 618
    //   473: aload 8
    //   475: aload 9
    //   477: iconst_0
    //   478: iload_3
    //   479: invokevirtual 385	java/io/BufferedOutputStream:write	([BII)V
    //   482: goto -26 -> 456
    //   485: astore 9
    //   487: aload 8
    //   489: astore 7
    //   491: aload 6
    //   493: astore_1
    //   494: aload 4
    //   496: astore 6
    //   498: aload_0
    //   499: astore 8
    //   501: aload 9
    //   503: astore_0
    //   504: aload 5
    //   506: astore 4
    //   508: aload 6
    //   510: astore 5
    //   512: aload 8
    //   514: astore 6
    //   516: goto -240 -> 276
    //   519: aload 6
    //   521: iconst_1
    //   522: invokevirtual 387	java/lang/String:substring	(I)Ljava/lang/String;
    //   525: astore 6
    //   527: aload_1
    //   528: astore 9
    //   530: goto -193 -> 337
    //   533: aload 6
    //   535: iconst_0
    //   536: iload_3
    //   537: invokevirtual 375	java/lang/String:substring	(II)Ljava/lang/String;
    //   540: astore 9
    //   542: aload 9
    //   544: iconst_0
    //   545: invokevirtual 391	java/lang/String:charAt	(I)C
    //   548: getstatic 358	java/io/File:separatorChar	C
    //   551: if_icmpne +37 -> 588
    //   554: new 85	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   561: aload_1
    //   562: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 9
    //   567: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: astore 9
    //   575: aload 6
    //   577: iload_3
    //   578: iconst_1
    //   579: iadd
    //   580: invokevirtual 387	java/lang/String:substring	(I)Ljava/lang/String;
    //   583: astore 6
    //   585: goto -248 -> 337
    //   588: new 85	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   595: aload_1
    //   596: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: getstatic 358	java/io/File:separatorChar	C
    //   602: invokevirtual 394	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   605: aload 9
    //   607: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: astore 9
    //   615: goto -40 -> 575
    //   618: aload 8
    //   620: invokevirtual 395	java/io/BufferedOutputStream:flush	()V
    //   623: aload 8
    //   625: invokevirtual 348	java/io/BufferedOutputStream:close	()V
    //   628: aload 6
    //   630: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   633: aload 8
    //   635: astore 7
    //   637: aload 6
    //   639: astore 8
    //   641: goto -544 -> 97
    //   644: astore_1
    //   645: goto -526 -> 119
    //   648: astore_1
    //   649: goto -520 -> 129
    //   652: astore_0
    //   653: goto -516 -> 137
    //   656: astore_0
    //   657: goto -510 -> 147
    //   660: astore_0
    //   661: return
    //   662: astore 4
    //   664: goto -378 -> 286
    //   667: astore 4
    //   669: goto -373 -> 296
    //   672: astore 4
    //   674: goto -368 -> 306
    //   677: astore_1
    //   678: goto -364 -> 314
    //   681: astore_1
    //   682: goto -358 -> 324
    //   685: astore_0
    //   686: aconst_null
    //   687: astore_1
    //   688: aconst_null
    //   689: astore 4
    //   691: aconst_null
    //   692: astore 5
    //   694: aconst_null
    //   695: astore 6
    //   697: goto -421 -> 276
    //   700: astore 8
    //   702: aconst_null
    //   703: astore_1
    //   704: aconst_null
    //   705: astore 4
    //   707: aconst_null
    //   708: astore 5
    //   710: aload_0
    //   711: astore 6
    //   713: aload 8
    //   715: astore_0
    //   716: goto -440 -> 276
    //   719: astore 9
    //   721: aconst_null
    //   722: astore_1
    //   723: aconst_null
    //   724: astore 8
    //   726: aload 4
    //   728: astore 5
    //   730: aload_0
    //   731: astore 6
    //   733: aload 9
    //   735: astore_0
    //   736: aload 8
    //   738: astore 4
    //   740: goto -464 -> 276
    //   743: astore 9
    //   745: aconst_null
    //   746: astore_1
    //   747: aload 4
    //   749: astore 6
    //   751: aload_0
    //   752: astore 8
    //   754: aload 9
    //   756: astore_0
    //   757: aload 5
    //   759: astore 4
    //   761: aload 6
    //   763: astore 5
    //   765: aload 8
    //   767: astore 6
    //   769: goto -493 -> 276
    //   772: astore 9
    //   774: aload 6
    //   776: astore_1
    //   777: aload 4
    //   779: astore 6
    //   781: aload_0
    //   782: astore 8
    //   784: aload 9
    //   786: astore_0
    //   787: aload 5
    //   789: astore 4
    //   791: aload 6
    //   793: astore 5
    //   795: aload 8
    //   797: astore 6
    //   799: goto -523 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	802	0	paramString1	String
    //   0	802	1	paramString2	String
    //   0	802	2	paramBoolean	boolean
    //   214	366	3	i	int
    //   65	442	4	localObject1	Object
    //   662	1	4	localIOException1	IOException
    //   667	1	4	localIOException2	IOException
    //   672	1	4	localIOException3	IOException
    //   689	101	4	localObject2	Object
    //   76	718	5	localObject3	Object
    //   4	794	6	localObject4	Object
    //   1	635	7	localObject5	Object
    //   91	549	8	localObject6	Object
    //   700	14	8	localObject7	Object
    //   724	72	8	str1	String
    //   255	19	9	localObject8	Object
    //   335	141	9	localObject9	Object
    //   485	17	9	localObject10	Object
    //   528	86	9	str2	String
    //   719	15	9	localObject11	Object
    //   743	12	9	localObject12	Object
    //   772	13	9	localObject13	Object
    //   339	39	10	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   97	104	255	finally
    //   158	206	255	finally
    //   206	255	255	finally
    //   345	354	255	finally
    //   362	371	255	finally
    //   371	404	255	finally
    //   404	418	255	finally
    //   418	442	255	finally
    //   519	527	255	finally
    //   533	575	255	finally
    //   575	585	255	finally
    //   588	615	255	finally
    //   456	468	485	finally
    //   473	482	485	finally
    //   618	633	485	finally
    //   114	119	644	java/io/IOException
    //   124	129	648	java/io/IOException
    //   133	137	652	java/io/IOException
    //   142	147	656	java/io/IOException
    //   152	157	660	java/io/IOException
    //   281	286	662	java/io/IOException
    //   291	296	667	java/io/IOException
    //   301	306	672	java/io/IOException
    //   310	314	677	java/io/IOException
    //   319	324	681	java/io/IOException
    //   6	48	685	finally
    //   48	57	685	finally
    //   57	67	700	finally
    //   67	78	719	finally
    //   78	90	743	finally
    //   442	456	772	finally
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static boolean a()
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite())) {}
    for (int i = 1; (Environment.getExternalStorageState().equals("mounted")) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  /* Error */
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 409
    //   3: invokestatic 407	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 412	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +41 -> 50
    //   12: new 48	java/io/File
    //   15: dup
    //   16: getstatic 421	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   19: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: new 48	java/io/File
    //   27: dup
    //   28: aload 4
    //   30: ldc_w 423
    //   33: invokespecial 426	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 73	java/io/File:exists	()Z
    //   43: ifeq +18 -> 61
    //   46: iconst_1
    //   47: istore_3
    //   48: iload_3
    //   49: ireturn
    //   50: getstatic 431	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   53: invokevirtual 434	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   56: astore 4
    //   58: goto -34 -> 24
    //   61: aload 4
    //   63: invokevirtual 80	java/io/File:mkdirs	()Z
    //   66: istore_2
    //   67: getstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   70: ifne +7 -> 77
    //   73: iconst_1
    //   74: putstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   77: iload_2
    //   78: ifne +21 -> 99
    //   81: invokestatic 436	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   84: ifne +49 -> 133
    //   87: aload_0
    //   88: ldc_w 437
    //   91: iconst_1
    //   92: invokestatic 442	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   95: invokevirtual 445	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   98: pop
    //   99: iload_2
    //   100: istore_3
    //   101: iload_1
    //   102: ifeq -54 -> 48
    //   105: iload_2
    //   106: ifne +11 -> 117
    //   109: iload_2
    //   110: istore_3
    //   111: getstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   114: ifeq -66 -> 48
    //   117: iload_2
    //   118: invokestatic 450	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   121: iload_2
    //   122: istore_3
    //   123: iload_2
    //   124: ifne -76 -> 48
    //   127: iconst_0
    //   128: putstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   131: iload_2
    //   132: ireturn
    //   133: invokestatic 452	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   136: ifeq +9 -> 145
    //   139: invokestatic 454	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   142: ifne -43 -> 99
    //   145: aload_0
    //   146: ldc_w 455
    //   149: iconst_1
    //   150: invokestatic 442	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   153: invokevirtual 445	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   156: pop
    //   157: goto -58 -> 99
    //   160: astore 4
    //   162: invokestatic 436	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   165: ifne +35 -> 200
    //   168: aload_0
    //   169: ldc_w 437
    //   172: iconst_1
    //   173: invokestatic 442	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   176: invokevirtual 445	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   179: pop
    //   180: iload_1
    //   181: ifeq +133 -> 314
    //   184: getstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   187: ifeq +127 -> 314
    //   190: iconst_0
    //   191: invokestatic 450	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   194: iconst_0
    //   195: putstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   198: iconst_0
    //   199: ireturn
    //   200: invokestatic 452	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   203: ifeq +9 -> 212
    //   206: invokestatic 454	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   209: ifne -29 -> 180
    //   212: aload_0
    //   213: ldc_w 455
    //   216: iconst_1
    //   217: invokestatic 442	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   220: invokevirtual 445	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   223: pop
    //   224: goto -44 -> 180
    //   227: astore 4
    //   229: iconst_0
    //   230: istore_2
    //   231: iload_2
    //   232: ifne +21 -> 253
    //   235: invokestatic 436	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   238: ifne +44 -> 282
    //   241: aload_0
    //   242: ldc_w 437
    //   245: iconst_1
    //   246: invokestatic 442	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   249: invokevirtual 445	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   252: pop
    //   253: iload_1
    //   254: ifeq +25 -> 279
    //   257: iload_2
    //   258: ifne +9 -> 267
    //   261: getstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   264: ifeq +15 -> 279
    //   267: iload_2
    //   268: invokestatic 450	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   271: iload_2
    //   272: ifne +7 -> 279
    //   275: iconst_0
    //   276: putstatic 24	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   279: aload 4
    //   281: athrow
    //   282: invokestatic 452	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   285: ifeq +9 -> 294
    //   288: invokestatic 454	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   291: ifne -38 -> 253
    //   294: aload_0
    //   295: ldc_w 455
    //   298: iconst_1
    //   299: invokestatic 442	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   302: invokevirtual 445	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   305: pop
    //   306: goto -53 -> 253
    //   309: astore 4
    //   311: goto -80 -> 231
    //   314: iconst_0
    //   315: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramContext	Context
    //   0	316	1	paramBoolean	boolean
    //   66	206	2	bool1	boolean
    //   47	76	3	bool2	boolean
    //   22	40	4	localFile	File
    //   160	1	4	localException	Exception
    //   227	53	4	localObject1	Object
    //   309	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   61	67	160	java/lang/Exception
    //   67	77	160	java/lang/Exception
    //   61	67	227	finally
    //   67	77	309	finally
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      a(paramString1, a(paramString2));
      paramString1.delete();
      bool = true;
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean a(String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    File localFile = new File(paramString1);
    String str = paramStringBuffer.toString();
    if (paramStringBuffer != null) {
      str = paramStringBuffer.toString().replaceAll("[\\\\/*?<>:\"|]", "");
    }
    paramString1 = new File(paramString1 + str);
    bool1 = true;
    if (!localFile.exists()) {
      bool1 = localFile.mkdirs();
    }
    boolean bool3 = bool1;
    if (localFile.exists())
    {
      bool2 = bool1;
      if (paramString1.exists()) {}
    }
    try
    {
      paramString1.createNewFile();
      bool2 = bool1;
      return false;
    }
    catch (IOException paramStringBuffer)
    {
      try
      {
        for (;;)
        {
          paramString1 = new FileOutputStream(paramString1, false);
          try
          {
            paramStringBuffer = paramString2 + "\r\n";
            bool1 = bool2;
            if (paramString1 != null)
            {
              paramString1.write(paramStringBuffer.getBytes());
              bool1 = bool2;
            }
          }
          catch (IOException paramStringBuffer)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool2 = bool1;
          }
          catch (IOException paramStringBuffer)
          {
            for (;;)
            {
              bool2 = false;
            }
          }
          bool3 = bool2;
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            bool3 = bool2;
            return bool3;
          }
          catch (IOException paramString1) {}
          paramStringBuffer = paramStringBuffer;
          bool2 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool2 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_0
    //   7: ifnull +28 -> 35
    //   10: iload 4
    //   12: istore_3
    //   13: aload_0
    //   14: invokevirtual 312	java/lang/String:length	()I
    //   17: ifeq +18 -> 35
    //   20: iload 4
    //   22: istore_3
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_1
    //   28: arraylength
    //   29: ifne +8 -> 37
    //   32: iload 4
    //   34: istore_3
    //   35: iload_3
    //   36: ireturn
    //   37: aload_0
    //   38: astore 5
    //   40: iload_2
    //   41: ifeq +58 -> 99
    //   44: new 486	java/text/SimpleDateFormat
    //   47: dup
    //   48: ldc_w 488
    //   51: getstatic 494	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: invokespecial 497	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   57: new 499	java/util/Date
    //   60: dup
    //   61: invokestatic 504	java/lang/System:currentTimeMillis	()J
    //   64: invokespecial 507	java/util/Date:<init>	(J)V
    //   67: invokevirtual 510	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   70: astore 5
    //   72: new 85	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   79: aload_0
    //   80: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 369
    //   86: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 5
    //   99: new 48	java/io/File
    //   102: dup
    //   103: aload 5
    //   105: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore 8
    //   110: aconst_null
    //   111: astore 7
    //   113: aconst_null
    //   114: astore 5
    //   116: aconst_null
    //   117: astore 6
    //   119: aload 5
    //   121: astore_0
    //   122: aload 8
    //   124: invokevirtual 128	java/io/File:getParentFile	()Ljava/io/File;
    //   127: astore 9
    //   129: aload 5
    //   131: astore_0
    //   132: aload 9
    //   134: invokevirtual 73	java/io/File:exists	()Z
    //   137: ifne +12 -> 149
    //   140: aload 5
    //   142: astore_0
    //   143: aload 9
    //   145: invokevirtual 80	java/io/File:mkdirs	()Z
    //   148: pop
    //   149: aload 5
    //   151: astore_0
    //   152: aload 8
    //   154: invokevirtual 73	java/io/File:exists	()Z
    //   157: ifeq +12 -> 169
    //   160: aload 5
    //   162: astore_0
    //   163: aload 8
    //   165: invokevirtual 109	java/io/File:delete	()Z
    //   168: pop
    //   169: aload 5
    //   171: astore_0
    //   172: aload 8
    //   174: invokevirtual 103	java/io/File:createNewFile	()Z
    //   177: pop
    //   178: aload 5
    //   180: astore_0
    //   181: new 301	java/io/FileOutputStream
    //   184: dup
    //   185: aload 8
    //   187: invokespecial 302	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: astore 5
    //   192: aload 5
    //   194: aload_1
    //   195: invokevirtual 483	java/io/FileOutputStream:write	([B)V
    //   198: aload 5
    //   200: invokevirtual 306	java/io/FileOutputStream:flush	()V
    //   203: iconst_1
    //   204: istore_3
    //   205: aload 5
    //   207: ifnull -172 -> 35
    //   210: aload 5
    //   212: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore 5
    //   226: aload 6
    //   228: astore_1
    //   229: aload_1
    //   230: astore_0
    //   231: aload 5
    //   233: invokevirtual 215	java/io/FileNotFoundException:printStackTrace	()V
    //   236: iload 4
    //   238: istore_3
    //   239: aload_1
    //   240: ifnull -205 -> 35
    //   243: aload_1
    //   244: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: aload_0
    //   251: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore 5
    //   258: aload 7
    //   260: astore_1
    //   261: aload_1
    //   262: astore_0
    //   263: aload 5
    //   265: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   268: iload 4
    //   270: istore_3
    //   271: aload_1
    //   272: ifnull -237 -> 35
    //   275: aload_1
    //   276: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aload_0
    //   283: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   286: iconst_0
    //   287: ireturn
    //   288: astore 5
    //   290: aload_0
    //   291: astore_1
    //   292: aload 5
    //   294: astore_0
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   310: goto -7 -> 303
    //   313: astore_0
    //   314: aload 5
    //   316: astore_1
    //   317: goto -22 -> 295
    //   320: astore_0
    //   321: aload 5
    //   323: astore_1
    //   324: aload_0
    //   325: astore 5
    //   327: goto -66 -> 261
    //   330: astore_0
    //   331: aload 5
    //   333: astore_1
    //   334: aload_0
    //   335: astore 5
    //   337: goto -108 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramString	String
    //   0	340	1	paramArrayOfByte	byte[]
    //   0	340	2	paramBoolean	boolean
    //   5	266	3	bool1	boolean
    //   1	268	4	bool2	boolean
    //   38	173	5	localObject1	Object
    //   224	8	5	localFileNotFoundException	FileNotFoundException
    //   256	8	5	localIOException	IOException
    //   288	34	5	localObject2	Object
    //   325	11	5	str	String
    //   117	110	6	localObject3	Object
    //   111	148	7	localObject4	Object
    //   108	78	8	localFile1	File
    //   127	17	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   210	215	217	java/lang/Exception
    //   122	129	224	java/io/FileNotFoundException
    //   132	140	224	java/io/FileNotFoundException
    //   143	149	224	java/io/FileNotFoundException
    //   152	160	224	java/io/FileNotFoundException
    //   163	169	224	java/io/FileNotFoundException
    //   172	178	224	java/io/FileNotFoundException
    //   181	192	224	java/io/FileNotFoundException
    //   243	247	249	java/lang/Exception
    //   122	129	256	java/io/IOException
    //   132	140	256	java/io/IOException
    //   143	149	256	java/io/IOException
    //   152	160	256	java/io/IOException
    //   163	169	256	java/io/IOException
    //   172	178	256	java/io/IOException
    //   181	192	256	java/io/IOException
    //   275	279	281	java/lang/Exception
    //   122	129	288	finally
    //   132	140	288	finally
    //   143	149	288	finally
    //   152	160	288	finally
    //   163	169	288	finally
    //   172	178	288	finally
    //   181	192	288	finally
    //   231	236	288	finally
    //   263	268	288	finally
    //   299	303	305	java/lang/Exception
    //   192	203	313	finally
    //   192	203	320	java/io/IOException
    //   192	203	330	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 73	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 112	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 5
    //   19: aload_0
    //   20: invokevirtual 184	java/io/File:length	()J
    //   23: lstore_3
    //   24: lload_3
    //   25: ldc2_w 512
    //   28: lcmp
    //   29: ifle +37 -> 66
    //   32: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +12 -> 47
    //   38: ldc 12
    //   40: iconst_2
    //   41: ldc_w 515
    //   44: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload 5
    //   49: ifnull -42 -> 7
    //   52: aload 5
    //   54: invokevirtual 518	java/io/InputStream:close	()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   64: aconst_null
    //   65: areturn
    //   66: lload_3
    //   67: l2i
    //   68: istore_1
    //   69: iload_1
    //   70: newarray byte
    //   72: astore 6
    //   74: iconst_0
    //   75: istore_1
    //   76: iload_1
    //   77: aload 6
    //   79: arraylength
    //   80: if_icmpge +28 -> 108
    //   83: aload 5
    //   85: aload 6
    //   87: iload_1
    //   88: aload 6
    //   90: arraylength
    //   91: iload_1
    //   92: isub
    //   93: invokevirtual 519	java/io/InputStream:read	([BII)I
    //   96: istore_2
    //   97: iload_2
    //   98: iflt +10 -> 108
    //   101: iload_1
    //   102: iload_2
    //   103: iadd
    //   104: istore_1
    //   105: goto -29 -> 76
    //   108: iload_1
    //   109: aload 6
    //   111: arraylength
    //   112: if_icmpge +35 -> 147
    //   115: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +29 -> 147
    //   121: ldc 12
    //   123: iconst_2
    //   124: new 85	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 521
    //   134: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: invokevirtual 524	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload 5
    //   149: ifnull +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 518	java/io/InputStream:close	()V
    //   157: aload 6
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   165: goto -8 -> 157
    //   168: astore 5
    //   170: aconst_null
    //   171: astore 5
    //   173: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +29 -> 205
    //   179: ldc 12
    //   181: iconst_2
    //   182: new 85	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 526
    //   192: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_0
    //   196: invokevirtual 524	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 5
    //   207: ifnull -200 -> 7
    //   210: aload 5
    //   212: invokevirtual 518	java/io/InputStream:close	()V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore 5
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 518	java/io/InputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore 5
    //   242: aload 5
    //   244: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   247: goto -9 -> 238
    //   250: astore_0
    //   251: goto -23 -> 228
    //   254: astore_0
    //   255: goto -27 -> 228
    //   258: astore 6
    //   260: goto -87 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFile	File
    //   68	45	1	i	int
    //   96	8	2	j	int
    //   23	44	3	l	long
    //   17	136	5	localFileInputStream	java.io.FileInputStream
    //   168	1	5	localIOException1	IOException
    //   171	63	5	localObject	Object
    //   240	3	5	localException	Exception
    //   72	86	6	arrayOfByte	byte[]
    //   258	1	6	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   52	57	59	java/lang/Exception
    //   152	157	160	java/lang/Exception
    //   9	19	168	java/io/IOException
    //   210	215	217	java/lang/Exception
    //   9	19	224	finally
    //   233	238	240	java/lang/Exception
    //   19	24	250	finally
    //   32	47	250	finally
    //   69	74	250	finally
    //   76	97	250	finally
    //   108	147	250	finally
    //   173	205	254	finally
    //   19	24	258	java/io/IOException
    //   32	47	258	java/io/IOException
    //   69	74	258	java/io/IOException
    //   76	97	258	java/io/IOException
    //   108	147	258	java/io/IOException
  }
  
  public static void b(String paramString)
  {
    if (!a(paramString)) {}
    try
    {
      a(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  public static boolean b()
  {
    return a(AppConstants.aq + "/Tencent/");
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean b(String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    File localFile2 = new File(paramString1);
    File localFile1 = new File(paramString1 + paramStringBuffer.toString());
    boolean bool = true;
    if (!localFile2.exists()) {
      bool = localFile2.mkdirs();
    }
    if ((localFile2.exists()) && (localFile1.exists()))
    {
      paramStringBuffer.insert(paramStringBuffer.indexOf(paramString2), "(0)");
      for (paramString2 = localFile1; paramString2.exists(); paramString2 = new File(paramString1 + paramStringBuffer))
      {
        int i = paramStringBuffer.lastIndexOf("(") + 1;
        int j = paramStringBuffer.lastIndexOf(")");
        paramStringBuffer.replace(i, j, String.valueOf(Integer.parseInt(paramStringBuffer.substring(i, j)) + 1));
      }
    }
    return bool;
  }
  
  public static boolean c()
  {
    return a(AppConstants.as);
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.startsWith(AppConstants.aq)) && (!paramString.startsWith("/data/media/")))
      {
        bool1 = bool2;
        if (!new File(paramString).exists()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      a(paramString1, a(paramString2));
      bool = true;
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean d()
  {
    return a(AppConstants.as + "/" + "diskcache");
  }
  
  public static boolean d(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  public static boolean e(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("jpg")) && (!paramString.equals("gif")) && (!paramString.equals("bmp")) && (!paramString.equals("png"))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */