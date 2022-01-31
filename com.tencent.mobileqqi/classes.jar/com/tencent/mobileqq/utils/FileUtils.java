package com.tencent.mobileqq.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import hgc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FileUtils
{
  public static final long a = 1024L;
  public static Runnable a = new hgc();
  public static final String a = "FileUtils";
  public static final long b = 1048576L;
  public static String b = "unknown_";
  public static final long c = 1073741824L;
  
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
    //   5: new 44	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 69	java/io/File:exists	()Z
    //   18: ifeq +37 -> 55
    //   21: new 108	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 114	java/io/FileInputStream:available	()I
    //   34: istore_1
    //   35: iload_1
    //   36: i2l
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: invokevirtual 117	java/io/FileInputStream:close	()V
    //   50: lload 4
    //   52: lstore_2
    //   53: lload_2
    //   54: lreturn
    //   55: iconst_0
    //   56: ifeq -3 -> 53
    //   59: new 119	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 120	java/lang/NullPointerException:<init>	()V
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
    //   78: invokevirtual 117	java/io/FileInputStream:close	()V
    //   81: lconst_0
    //   82: lreturn
    //   83: astore_0
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: aload 6
    //   89: ifnull +8 -> 97
    //   92: aload 6
    //   94: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   2: new 175	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 176	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 5
    //   11: new 108	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 9
    //   21: aload 5
    //   23: astore 7
    //   25: aload 9
    //   27: astore 6
    //   29: aload_0
    //   30: invokevirtual 180	java/io/File:length	()J
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
    //   66: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   69: istore_2
    //   70: aload 5
    //   72: astore 7
    //   74: aload 9
    //   76: astore 6
    //   78: aload 5
    //   80: aload_0
    //   81: iconst_0
    //   82: iload_2
    //   83: invokevirtual 188	java/io/ByteArrayOutputStream:write	([BII)V
    //   86: iload_1
    //   87: iload_2
    //   88: iadd
    //   89: istore_1
    //   90: goto -42 -> 48
    //   93: aload 5
    //   95: astore 7
    //   97: aload 9
    //   99: astore 6
    //   101: new 143	java/lang/String
    //   104: dup
    //   105: aload 5
    //   107: invokevirtual 192	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   110: ldc 194
    //   112: invokespecial 197	java/lang/String:<init>	([BLjava/lang/String;)V
    //   115: astore_0
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 198	java/io/ByteArrayOutputStream:close	()V
    //   126: aload 9
    //   128: ifnull +8 -> 136
    //   131: aload 9
    //   133: invokevirtual 117	java/io/FileInputStream:close	()V
    //   136: aload_0
    //   137: areturn
    //   138: astore 5
    //   140: aload 5
    //   142: invokevirtual 201	java/io/IOException:printStackTrace	()V
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
    //   163: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   166: aload 5
    //   168: ifnull +8 -> 176
    //   171: aload 5
    //   173: invokevirtual 198	java/io/ByteArrayOutputStream:close	()V
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 117	java/io/FileInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 201	java/io/IOException:printStackTrace	()V
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
    //   207: invokevirtual 198	java/io/ByteArrayOutputStream:close	()V
    //   210: aload 6
    //   212: ifnull +8 -> 220
    //   215: aload 6
    //   217: invokevirtual 117	java/io/FileInputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: astore 5
    //   224: aload 5
    //   226: invokevirtual 201	java/io/IOException:printStackTrace	()V
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
    //   0: new 108	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
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
    //   19: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   22: iconst_m1
    //   23: if_icmpeq +130 -> 153
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: invokestatic 208	com/tencent/mobileqq/utils/FileUtils:a	([B)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 117	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokevirtual 117	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: ldc 210
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: invokevirtual 211	java/io/FileNotFoundException:printStackTrace	()V
    //   65: aload_0
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull -17 -> 51
    //   71: aload_2
    //   72: invokevirtual 117	java/io/FileInputStream:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: ldc 210
    //   85: astore_0
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: astore_1
    //   94: aload_2
    //   95: ifnull -44 -> 51
    //   98: aload_2
    //   99: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   115: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   132: ldc 210
    //   134: astore_0
    //   135: goto -49 -> 86
    //   138: astore_3
    //   139: goto -53 -> 86
    //   142: astore_3
    //   143: ldc 210
    //   145: astore_0
    //   146: goto -87 -> 59
    //   149: astore_3
    //   150: goto -91 -> 59
    //   153: ldc 210
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
    //   2: new 44	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +17 -> 29
    //   15: aload_0
    //   16: invokevirtual 69	java/io/File:exists	()Z
    //   19: ifeq +10 -> 29
    //   22: aload_0
    //   23: invokevirtual 217	java/io/File:isFile	()Z
    //   26: ifne +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokestatic 223	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore 4
    //   37: new 108	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   61: ldc 224
    //   63: castore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 225
    //   68: castore
    //   69: dup
    //   70: iconst_2
    //   71: ldc 226
    //   73: castore
    //   74: dup
    //   75: iconst_3
    //   76: ldc 227
    //   78: castore
    //   79: dup
    //   80: iconst_4
    //   81: ldc 228
    //   83: castore
    //   84: dup
    //   85: iconst_5
    //   86: ldc 229
    //   88: castore
    //   89: dup
    //   90: bipush 6
    //   92: ldc 230
    //   94: castore
    //   95: dup
    //   96: bipush 7
    //   98: ldc 231
    //   100: castore
    //   101: dup
    //   102: bipush 8
    //   104: ldc 232
    //   106: castore
    //   107: dup
    //   108: bipush 9
    //   110: ldc 233
    //   112: castore
    //   113: dup
    //   114: bipush 10
    //   116: ldc 234
    //   118: castore
    //   119: dup
    //   120: bipush 11
    //   122: ldc 235
    //   124: castore
    //   125: dup
    //   126: bipush 12
    //   128: ldc 236
    //   130: castore
    //   131: dup
    //   132: bipush 13
    //   134: ldc 237
    //   136: castore
    //   137: dup
    //   138: bipush 14
    //   140: ldc 238
    //   142: castore
    //   143: dup
    //   144: bipush 15
    //   146: ldc 239
    //   148: castore
    //   149: pop
    //   150: aload_1
    //   151: aload 5
    //   153: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: ifle +28 -> 186
    //   161: aload 4
    //   163: aload 5
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 242	java/security/MessageDigest:update	([BII)V
    //   170: goto -20 -> 150
    //   173: astore_0
    //   174: aload_1
    //   175: ifnull +195 -> 370
    //   178: aload_1
    //   179: invokevirtual 117	java/io/FileInputStream:close	()V
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: areturn
    //   186: aload 4
    //   188: invokevirtual 245	java/security/MessageDigest:digest	()[B
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
    //   211: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   276: new 143	java/lang/String
    //   279: dup
    //   280: aload 5
    //   282: invokespecial 248	java/lang/String:<init>	([C)V
    //   285: astore 4
    //   287: aload 4
    //   289: astore_0
    //   290: aload_1
    //   291: ifnull -107 -> 184
    //   294: aload_1
    //   295: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   325: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   347: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   6: invokevirtual 69	java/io/File:exists	()Z
    //   9: ifeq +8 -> 17
    //   12: aload_1
    //   13: invokevirtual 105	java/io/File:delete	()Z
    //   16: pop
    //   17: new 297	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore_1
    //   26: new 108	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_0
    //   35: ldc_w 299
    //   38: newarray byte
    //   40: astore_3
    //   41: aload_0
    //   42: aload_3
    //   43: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   46: istore_2
    //   47: iload_2
    //   48: iconst_m1
    //   49: if_icmpeq +41 -> 90
    //   52: aload_1
    //   53: aload_3
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 300	java/io/FileOutputStream:write	([BII)V
    //   59: aload_1
    //   60: invokevirtual 303	java/io/FileOutputStream:flush	()V
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
    //   78: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 117	java/io/FileInputStream:close	()V
    //   89: return
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   98: aload_0
    //   99: ifnull -10 -> 89
    //   102: aload_0
    //   103: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   120: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   123: aload_0
    //   124: ifnull -35 -> 89
    //   127: aload_0
    //   128: invokevirtual 117	java/io/FileInputStream:close	()V
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
    //   144: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 117	java/io/FileInputStream:close	()V
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
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +39 -> 48
    //   12: ldc 12
    //   14: iconst_2
    //   15: new 81	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 322
    //   25: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 324
    //   35: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 108	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_0
    //   57: new 330	java/io/BufferedInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 333	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore_3
    //   66: new 335	java/util/zip/ZipInputStream
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 336	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   74: astore 4
    //   76: new 44	java/io/File
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 76	java/io/File:mkdirs	()Z
    //   87: pop
    //   88: aconst_null
    //   89: astore 7
    //   91: aload 5
    //   93: astore 6
    //   95: aload 4
    //   97: invokevirtual 340	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   100: astore 5
    //   102: aload 5
    //   104: ifnonnull +50 -> 154
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 341	java/util/zip/ZipInputStream:close	()V
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 117	java/io/FileInputStream:close	()V
    //   133: aload 7
    //   135: ifnull +8 -> 143
    //   138: aload 7
    //   140: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   143: aload 6
    //   145: ifnull +8 -> 153
    //   148: aload 6
    //   150: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   153: return
    //   154: aload 5
    //   156: invokevirtual 348	java/util/zip/ZipEntry:isDirectory	()Z
    //   159: ifne -64 -> 95
    //   162: aload 5
    //   164: invokevirtual 349	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   167: astore 5
    //   169: aload 5
    //   171: ifnull -76 -> 95
    //   174: aload 5
    //   176: ldc_w 351
    //   179: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   182: ifne -87 -> 95
    //   185: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +30 -> 218
    //   191: ldc 12
    //   193: iconst_2
    //   194: new 81	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 357
    //   204: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 5
    //   209: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload 5
    //   220: getstatic 361	java/io/File:separatorChar	C
    //   223: invokevirtual 365	java/lang/String:lastIndexOf	(I)I
    //   226: istore_2
    //   227: iload_2
    //   228: aload 5
    //   230: invokevirtual 309	java/lang/String:length	()I
    //   233: iconst_1
    //   234: isub
    //   235: if_icmpne +99 -> 334
    //   238: new 367	java/lang/IllegalArgumentException
    //   241: dup
    //   242: new 81	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 369
    //   252: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 5
    //   257: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokespecial 370	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   266: athrow
    //   267: astore 8
    //   269: aload 4
    //   271: astore_1
    //   272: aload_0
    //   273: astore 5
    //   275: aload_3
    //   276: astore 4
    //   278: aload_1
    //   279: astore_3
    //   280: aload 7
    //   282: astore_1
    //   283: aload 8
    //   285: astore_0
    //   286: aload_3
    //   287: ifnull +7 -> 294
    //   290: aload_3
    //   291: invokevirtual 341	java/util/zip/ZipInputStream:close	()V
    //   294: aload 4
    //   296: ifnull +8 -> 304
    //   299: aload 4
    //   301: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   304: aload 5
    //   306: ifnull +8 -> 314
    //   309: aload 5
    //   311: invokevirtual 117	java/io/FileInputStream:close	()V
    //   314: aload_1
    //   315: ifnull +7 -> 322
    //   318: aload_1
    //   319: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   322: aload 6
    //   324: ifnull +8 -> 332
    //   327: aload 6
    //   329: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   332: aload_0
    //   333: athrow
    //   334: iload_2
    //   335: ifgt +156 -> 491
    //   338: iload_2
    //   339: ifge +138 -> 477
    //   342: aload_1
    //   343: astore 8
    //   345: new 44	java/io/File
    //   348: dup
    //   349: aload 8
    //   351: aload 5
    //   353: invokespecial 372	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: astore 5
    //   358: aload 5
    //   360: invokevirtual 124	java/io/File:getParentFile	()Ljava/io/File;
    //   363: invokevirtual 69	java/io/File:exists	()Z
    //   366: ifne +12 -> 378
    //   369: aload 5
    //   371: invokevirtual 124	java/io/File:getParentFile	()Ljava/io/File;
    //   374: invokevirtual 76	java/io/File:mkdirs	()Z
    //   377: pop
    //   378: aload 5
    //   380: invokevirtual 99	java/io/File:createNewFile	()Z
    //   383: pop
    //   384: sipush 2048
    //   387: newarray byte
    //   389: astore 8
    //   391: new 297	java/io/FileOutputStream
    //   394: dup
    //   395: aload 5
    //   397: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   400: astore 5
    //   402: new 344	java/io/BufferedOutputStream
    //   405: dup
    //   406: aload 5
    //   408: aload 8
    //   410: arraylength
    //   411: invokespecial 375	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   414: astore 7
    //   416: aload 4
    //   418: aload 8
    //   420: iconst_0
    //   421: aload 8
    //   423: arraylength
    //   424: invokevirtual 378	java/util/zip/ZipInputStream:read	([BII)I
    //   427: istore_2
    //   428: iload_2
    //   429: iconst_m1
    //   430: if_icmpeq +146 -> 576
    //   433: aload 7
    //   435: aload 8
    //   437: iconst_0
    //   438: iload_2
    //   439: invokevirtual 379	java/io/BufferedOutputStream:write	([BII)V
    //   442: goto -26 -> 416
    //   445: astore 8
    //   447: aload 7
    //   449: astore 6
    //   451: aload 5
    //   453: astore_1
    //   454: aload_3
    //   455: astore 5
    //   457: aload_0
    //   458: astore 7
    //   460: aload 8
    //   462: astore_0
    //   463: aload 4
    //   465: astore_3
    //   466: aload 5
    //   468: astore 4
    //   470: aload 7
    //   472: astore 5
    //   474: goto -188 -> 286
    //   477: aload 5
    //   479: iconst_1
    //   480: invokevirtual 382	java/lang/String:substring	(I)Ljava/lang/String;
    //   483: astore 5
    //   485: aload_1
    //   486: astore 8
    //   488: goto -143 -> 345
    //   491: aload 5
    //   493: iconst_0
    //   494: iload_2
    //   495: invokevirtual 385	java/lang/String:substring	(II)Ljava/lang/String;
    //   498: astore 8
    //   500: aload 8
    //   502: iconst_0
    //   503: invokevirtual 389	java/lang/String:charAt	(I)C
    //   506: getstatic 361	java/io/File:separatorChar	C
    //   509: if_icmpne +37 -> 546
    //   512: new 81	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   519: aload_1
    //   520: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload 8
    //   525: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: astore 8
    //   533: aload 5
    //   535: iload_2
    //   536: iconst_1
    //   537: iadd
    //   538: invokevirtual 382	java/lang/String:substring	(I)Ljava/lang/String;
    //   541: astore 5
    //   543: goto -198 -> 345
    //   546: new 81	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   553: aload_1
    //   554: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: getstatic 361	java/io/File:separatorChar	C
    //   560: invokevirtual 392	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   563: aload 8
    //   565: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: astore 8
    //   573: goto -40 -> 533
    //   576: aload 7
    //   578: invokevirtual 393	java/io/BufferedOutputStream:flush	()V
    //   581: aload 7
    //   583: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   586: aload 5
    //   588: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   591: aload 7
    //   593: astore 6
    //   595: aload 5
    //   597: astore 7
    //   599: goto -504 -> 95
    //   602: astore_1
    //   603: goto -486 -> 117
    //   606: astore_1
    //   607: goto -482 -> 125
    //   610: astore_0
    //   611: goto -478 -> 133
    //   614: astore_0
    //   615: goto -472 -> 143
    //   618: astore_0
    //   619: return
    //   620: astore_3
    //   621: goto -327 -> 294
    //   624: astore_3
    //   625: goto -321 -> 304
    //   628: astore_3
    //   629: goto -315 -> 314
    //   632: astore_1
    //   633: goto -311 -> 322
    //   636: astore_1
    //   637: goto -305 -> 332
    //   640: astore_0
    //   641: aconst_null
    //   642: astore_1
    //   643: aconst_null
    //   644: astore_3
    //   645: aconst_null
    //   646: astore 4
    //   648: aconst_null
    //   649: astore 5
    //   651: goto -365 -> 286
    //   654: astore 7
    //   656: aconst_null
    //   657: astore_1
    //   658: aconst_null
    //   659: astore_3
    //   660: aconst_null
    //   661: astore 4
    //   663: aload_0
    //   664: astore 5
    //   666: aload 7
    //   668: astore_0
    //   669: goto -383 -> 286
    //   672: astore 8
    //   674: aconst_null
    //   675: astore_1
    //   676: aconst_null
    //   677: astore 7
    //   679: aload_3
    //   680: astore 4
    //   682: aload_0
    //   683: astore 5
    //   685: aload 8
    //   687: astore_0
    //   688: aload 7
    //   690: astore_3
    //   691: goto -405 -> 286
    //   694: astore 8
    //   696: aconst_null
    //   697: astore_1
    //   698: aload_3
    //   699: astore 5
    //   701: aload_0
    //   702: astore 7
    //   704: aload 8
    //   706: astore_0
    //   707: aload 4
    //   709: astore_3
    //   710: aload 5
    //   712: astore 4
    //   714: aload 7
    //   716: astore 5
    //   718: goto -432 -> 286
    //   721: astore 8
    //   723: aload 5
    //   725: astore_1
    //   726: aload_3
    //   727: astore 5
    //   729: aload_0
    //   730: astore 7
    //   732: aload 8
    //   734: astore_0
    //   735: aload 4
    //   737: astore_3
    //   738: aload 5
    //   740: astore 4
    //   742: aload 7
    //   744: astore 5
    //   746: goto -460 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	paramString1	String
    //   0	749	1	paramString2	String
    //   226	312	2	i	int
    //   65	401	3	localObject1	Object
    //   620	1	3	localIOException1	IOException
    //   624	1	3	localIOException2	IOException
    //   628	1	3	localIOException3	IOException
    //   644	94	3	localObject2	Object
    //   74	667	4	localObject3	Object
    //   4	741	5	localObject4	Object
    //   1	593	6	localObject5	Object
    //   89	509	7	localObject6	Object
    //   654	13	7	localObject7	Object
    //   677	66	7	str1	String
    //   267	17	8	localObject8	Object
    //   343	93	8	localObject9	Object
    //   445	16	8	localObject10	Object
    //   486	86	8	str2	String
    //   672	14	8	localObject11	Object
    //   694	11	8	localObject12	Object
    //   721	12	8	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   95	102	267	finally
    //   154	169	267	finally
    //   174	218	267	finally
    //   218	267	267	finally
    //   345	378	267	finally
    //   378	402	267	finally
    //   477	485	267	finally
    //   491	533	267	finally
    //   533	543	267	finally
    //   546	573	267	finally
    //   416	428	445	finally
    //   433	442	445	finally
    //   576	591	445	finally
    //   112	117	602	java/io/IOException
    //   121	125	606	java/io/IOException
    //   129	133	610	java/io/IOException
    //   138	143	614	java/io/IOException
    //   148	153	618	java/io/IOException
    //   290	294	620	java/io/IOException
    //   299	304	624	java/io/IOException
    //   309	314	628	java/io/IOException
    //   318	322	632	java/io/IOException
    //   327	332	636	java/io/IOException
    //   6	48	640	finally
    //   48	57	640	finally
    //   57	66	654	finally
    //   66	76	672	finally
    //   76	88	694	finally
    //   402	416	721	finally
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
    return a(AppConstants.al + "/Tencent/");
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 408
    //   3: invokestatic 411	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +35 -> 44
    //   12: new 44	java/io/File
    //   15: dup
    //   16: getstatic 417	com/tencent/mobileqq/app/AppConstants:an	Ljava/lang/String;
    //   19: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: new 44	java/io/File
    //   26: dup
    //   27: aload_2
    //   28: ldc_w 419
    //   31: invokespecial 422	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 69	java/io/File:exists	()Z
    //   39: ifeq +15 -> 54
    //   42: iconst_1
    //   43: ireturn
    //   44: getstatic 427	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokevirtual 430	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   50: astore_2
    //   51: goto -28 -> 23
    //   54: aload_2
    //   55: invokevirtual 76	java/io/File:mkdirs	()Z
    //   58: istore_1
    //   59: iload_1
    //   60: ifeq +5 -> 65
    //   63: iconst_1
    //   64: ireturn
    //   65: invokestatic 432	com/tencent/mobileqq/utils/FileUtils:a	()Z
    //   68: ifne +16 -> 84
    //   71: aload_0
    //   72: ldc_w 433
    //   75: iconst_1
    //   76: invokestatic 438	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   79: invokevirtual 440	com/tencent/mobileqq/widget/QQToast:a	()V
    //   82: iconst_0
    //   83: ireturn
    //   84: invokestatic 442	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   87: ifeq +9 -> 96
    //   90: invokestatic 444	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   93: ifne -11 -> 82
    //   96: aload_0
    //   97: ldc_w 445
    //   100: iconst_1
    //   101: invokestatic 438	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   104: invokevirtual 440	com/tencent/mobileqq/widget/QQToast:a	()V
    //   107: goto -25 -> 82
    //   110: astore_2
    //   111: invokestatic 432	com/tencent/mobileqq/utils/FileUtils:a	()Z
    //   114: ifne +17 -> 131
    //   117: aload_0
    //   118: ldc_w 433
    //   121: iconst_1
    //   122: invokestatic 438	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   125: invokevirtual 440	com/tencent/mobileqq/widget/QQToast:a	()V
    //   128: goto -46 -> 82
    //   131: invokestatic 442	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   134: ifeq +9 -> 143
    //   137: invokestatic 444	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   140: ifne -58 -> 82
    //   143: aload_0
    //   144: ldc_w 445
    //   147: iconst_1
    //   148: invokestatic 438	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   151: invokevirtual 440	com/tencent/mobileqq/widget/QQToast:a	()V
    //   154: goto -72 -> 82
    //   157: astore_2
    //   158: invokestatic 432	com/tencent/mobileqq/utils/FileUtils:a	()Z
    //   161: ifne +16 -> 177
    //   164: aload_0
    //   165: ldc_w 433
    //   168: iconst_1
    //   169: invokestatic 438	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   172: invokevirtual 440	com/tencent/mobileqq/widget/QQToast:a	()V
    //   175: aload_2
    //   176: athrow
    //   177: invokestatic 442	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   180: ifeq +9 -> 189
    //   183: invokestatic 444	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   186: ifne -11 -> 175
    //   189: aload_0
    //   190: ldc_w 445
    //   193: iconst_1
    //   194: invokestatic 438	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   197: invokevirtual 440	com/tencent/mobileqq/widget/QQToast:a	()V
    //   200: goto -25 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramContext	android.content.Context
    //   58	2	1	bool	boolean
    //   22	33	2	localFile	File
    //   110	1	2	localException	Exception
    //   157	19	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	110	java/lang/Exception
    //   54	59	157	finally
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
    //   14: invokevirtual 309	java/lang/String:length	()I
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
    //   44: new 476	java/text/SimpleDateFormat
    //   47: dup
    //   48: ldc_w 478
    //   51: getstatic 484	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: invokespecial 487	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   57: new 489	java/util/Date
    //   60: dup
    //   61: invokestatic 494	java/lang/System:currentTimeMillis	()J
    //   64: invokespecial 497	java/util/Date:<init>	(J)V
    //   67: invokevirtual 500	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   70: astore 5
    //   72: new 81	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   79: aload_0
    //   80: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 502
    //   86: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 5
    //   99: new 44	java/io/File
    //   102: dup
    //   103: aload 5
    //   105: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
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
    //   124: invokevirtual 124	java/io/File:getParentFile	()Ljava/io/File;
    //   127: astore 9
    //   129: aload 5
    //   131: astore_0
    //   132: aload 9
    //   134: invokevirtual 69	java/io/File:exists	()Z
    //   137: ifne +12 -> 149
    //   140: aload 5
    //   142: astore_0
    //   143: aload 9
    //   145: invokevirtual 76	java/io/File:mkdirs	()Z
    //   148: pop
    //   149: aload 5
    //   151: astore_0
    //   152: aload 8
    //   154: invokevirtual 69	java/io/File:exists	()Z
    //   157: ifeq +12 -> 169
    //   160: aload 5
    //   162: astore_0
    //   163: aload 8
    //   165: invokevirtual 105	java/io/File:delete	()Z
    //   168: pop
    //   169: aload 5
    //   171: astore_0
    //   172: aload 8
    //   174: invokevirtual 99	java/io/File:createNewFile	()Z
    //   177: pop
    //   178: aload 5
    //   180: astore_0
    //   181: new 297	java/io/FileOutputStream
    //   184: dup
    //   185: aload 8
    //   187: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: astore 5
    //   192: aload 5
    //   194: aload_1
    //   195: invokevirtual 473	java/io/FileOutputStream:write	([B)V
    //   198: aload 5
    //   200: invokevirtual 303	java/io/FileOutputStream:flush	()V
    //   203: iconst_1
    //   204: istore_3
    //   205: aload 5
    //   207: ifnull -172 -> 35
    //   210: aload 5
    //   212: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore 5
    //   226: aload 6
    //   228: astore_1
    //   229: aload_1
    //   230: astore_0
    //   231: aload 5
    //   233: invokevirtual 211	java/io/FileNotFoundException:printStackTrace	()V
    //   236: iload 4
    //   238: istore_3
    //   239: aload_1
    //   240: ifnull -205 -> 35
    //   243: aload_1
    //   244: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: aload_0
    //   251: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore 5
    //   258: aload 7
    //   260: astore_1
    //   261: aload_1
    //   262: astore_0
    //   263: aload 5
    //   265: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   268: iload 4
    //   270: istore_3
    //   271: aload_1
    //   272: ifnull -237 -> 35
    //   275: aload_1
    //   276: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aload_0
    //   283: invokevirtual 293	java/lang/Exception:printStackTrace	()V
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
    //   300: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 293	java/lang/Exception:printStackTrace	()V
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
    //   1: invokevirtual 69	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 108	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 5
    //   19: aload_0
    //   20: invokevirtual 180	java/io/File:length	()J
    //   23: lstore_3
    //   24: lload_3
    //   25: ldc2_w 504
    //   28: lcmp
    //   29: ifle +37 -> 66
    //   32: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +12 -> 47
    //   38: ldc 12
    //   40: iconst_2
    //   41: ldc_w 507
    //   44: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload 5
    //   49: ifnull -42 -> 7
    //   52: aload 5
    //   54: invokevirtual 510	java/io/InputStream:close	()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 293	java/lang/Exception:printStackTrace	()V
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
    //   93: invokevirtual 511	java/io/InputStream:read	([BII)I
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
    //   115: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +29 -> 147
    //   121: ldc 12
    //   123: iconst_2
    //   124: new 81	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 513
    //   134: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload 5
    //   149: ifnull +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 510	java/io/InputStream:close	()V
    //   157: aload 6
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   165: goto -8 -> 157
    //   168: astore 5
    //   170: aconst_null
    //   171: astore 5
    //   173: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +29 -> 205
    //   179: ldc 12
    //   181: iconst_2
    //   182: new 81	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 518
    //   192: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_0
    //   196: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 5
    //   207: ifnull -200 -> 7
    //   210: aload 5
    //   212: invokevirtual 510	java/io/InputStream:close	()V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore 5
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 510	java/io/InputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore 5
    //   242: aload 5
    //   244: invokevirtual 293	java/lang/Exception:printStackTrace	()V
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
    return a(AppConstants.an);
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()) || (paramString.length() <= 0L));
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
    return a(AppConstants.an + "/" + "diskcache");
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.startsWith(AppConstants.al)) && (!paramString.startsWith("/data/media/")))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */