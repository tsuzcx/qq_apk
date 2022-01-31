package com.tencent.commonsdk.classload;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.tencent.commonsdk.util.MD5Coding;
import java.io.Closeable;
import java.io.File;

public class DexClassLoaderUtil
{
  private static final String INFO_FILE_SUFFIX = ".dat";
  private static Handler sHandler = null;
  public static Looper sLooper = null;
  
  private static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  /* Error */
  public static dalvik.system.DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, java.lang.ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: getstatic 24	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   3: ifnonnull +22 -> 25
    //   6: getstatic 22	com/tencent/commonsdk/classload/DexClassLoaderUtil:sLooper	Landroid/os/Looper;
    //   9: ifnull +16 -> 25
    //   12: new 48	android/os/Handler
    //   15: dup
    //   16: getstatic 22	com/tencent/commonsdk/classload/DexClassLoaderUtil:sLooper	Landroid/os/Looper;
    //   19: invokespecial 51	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   22: putstatic 24	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   25: getstatic 24	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   28: astore 12
    //   30: aload_0
    //   31: ldc 53
    //   33: invokevirtual 59	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   36: istore 4
    //   38: aload_0
    //   39: ldc 61
    //   41: invokevirtual 59	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   44: istore 5
    //   46: iload 4
    //   48: iload 5
    //   50: if_icmple +293 -> 343
    //   53: iload 4
    //   55: iflt +295 -> 350
    //   58: iload 4
    //   60: iconst_1
    //   61: iadd
    //   62: istore 4
    //   64: aload_0
    //   65: ldc 63
    //   67: invokevirtual 59	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   70: istore 5
    //   72: iload 5
    //   74: iflt +282 -> 356
    //   77: aload_0
    //   78: iload 4
    //   80: iload 5
    //   82: invokevirtual 67	java/lang/String:substring	(II)Ljava/lang/String;
    //   85: astore 13
    //   87: new 69	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   94: aload_1
    //   95: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   101: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 13
    //   106: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore 16
    //   114: new 76	java/io/File
    //   117: dup
    //   118: aload 16
    //   120: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 15
    //   125: aload 15
    //   127: invokevirtual 90	java/io/File:isFile	()Z
    //   130: ifeq +9 -> 139
    //   133: aload 15
    //   135: invokevirtual 93	java/io/File:delete	()Z
    //   138: pop
    //   139: aload 15
    //   141: invokevirtual 96	java/io/File:exists	()Z
    //   144: ifne +9 -> 153
    //   147: aload 15
    //   149: invokevirtual 99	java/io/File:mkdirs	()Z
    //   152: pop
    //   153: new 76	java/io/File
    //   156: dup
    //   157: aload 15
    //   159: new 69	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   166: aload 13
    //   168: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 14
    //   173: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   182: astore 14
    //   184: aload 14
    //   186: invokevirtual 105	java/io/File:isDirectory	()Z
    //   189: ifeq +9 -> 198
    //   192: aload 14
    //   194: invokevirtual 93	java/io/File:delete	()Z
    //   197: pop
    //   198: aconst_null
    //   199: astore 11
    //   201: aconst_null
    //   202: astore 10
    //   204: aconst_null
    //   205: astore 9
    //   207: aconst_null
    //   208: astore 8
    //   210: aconst_null
    //   211: astore_1
    //   212: aconst_null
    //   213: astore 7
    //   215: new 107	java/io/BufferedReader
    //   218: dup
    //   219: new 109	java/io/FileReader
    //   222: dup
    //   223: aload 14
    //   225: invokespecial 112	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   228: invokespecial 115	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   231: astore 6
    //   233: aload 11
    //   235: astore_1
    //   236: aload 6
    //   238: invokevirtual 118	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   241: astore 7
    //   243: aload 8
    //   245: astore_1
    //   246: aload 7
    //   248: ifnull +16 -> 264
    //   251: aload 7
    //   253: astore_1
    //   254: aload 6
    //   256: invokevirtual 118	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   259: astore 8
    //   261: aload 8
    //   263: astore_1
    //   264: aload 6
    //   266: invokestatic 120	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   269: aload 7
    //   271: astore 6
    //   273: aload 15
    //   275: invokevirtual 124	java/io/File:listFiles	()[Ljava/io/File;
    //   278: astore 10
    //   280: aload_1
    //   281: astore 8
    //   283: aload 6
    //   285: astore 7
    //   287: aload 10
    //   289: ifnull +206 -> 495
    //   292: aload 10
    //   294: arraylength
    //   295: istore 5
    //   297: iconst_0
    //   298: istore 4
    //   300: aload_1
    //   301: astore 8
    //   303: aload 6
    //   305: astore 7
    //   307: iload 4
    //   309: iload 5
    //   311: if_icmpge +184 -> 495
    //   314: aload 10
    //   316: iload 4
    //   318: aaload
    //   319: astore 9
    //   321: aload 9
    //   323: invokevirtual 127	java/io/File:getName	()Ljava/lang/String;
    //   326: ldc 14
    //   328: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   331: ifeq +66 -> 397
    //   334: iload 4
    //   336: iconst_1
    //   337: iadd
    //   338: istore 4
    //   340: goto -40 -> 300
    //   343: iload 5
    //   345: istore 4
    //   347: goto -294 -> 53
    //   350: iconst_0
    //   351: istore 4
    //   353: goto -289 -> 64
    //   356: aload_0
    //   357: invokevirtual 135	java/lang/String:length	()I
    //   360: istore 5
    //   362: goto -285 -> 77
    //   365: astore 8
    //   367: aload 10
    //   369: astore 6
    //   371: aload 7
    //   373: astore_1
    //   374: aload 8
    //   376: invokevirtual 44	java/lang/Exception:printStackTrace	()V
    //   379: aload 7
    //   381: invokestatic 120	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   384: aload 9
    //   386: astore_1
    //   387: goto -114 -> 273
    //   390: astore_0
    //   391: aload_1
    //   392: invokestatic 120	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   395: aload_0
    //   396: athrow
    //   397: new 69	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   404: aload 9
    //   406: invokevirtual 127	java/io/File:getName	()Ljava/lang/String;
    //   409: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 9
    //   414: invokevirtual 138	java/io/File:length	()J
    //   417: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   420: aload 9
    //   422: invokevirtual 144	java/io/File:lastModified	()J
    //   425: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 148	com/tencent/commonsdk/classload/DexClassLoaderUtil:getBase64String	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokestatic 153	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   437: astore 7
    //   439: aload 6
    //   441: ifnull +36 -> 477
    //   444: aload 6
    //   446: aload 7
    //   448: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   451: ifeq +26 -> 477
    //   454: aload_1
    //   455: astore 8
    //   457: aload 6
    //   459: astore 7
    //   461: aload_1
    //   462: ifnonnull +33 -> 495
    //   465: aload_1
    //   466: astore 8
    //   468: aload 6
    //   470: astore 7
    //   472: aload 12
    //   474: ifnull +21 -> 495
    //   477: aload 9
    //   479: invokevirtual 93	java/io/File:delete	()Z
    //   482: pop
    //   483: aload 14
    //   485: invokevirtual 93	java/io/File:delete	()Z
    //   488: pop
    //   489: aconst_null
    //   490: astore 7
    //   492: aconst_null
    //   493: astore 8
    //   495: new 158	dalvik/system/DexClassLoader
    //   498: dup
    //   499: aload_0
    //   500: aload 16
    //   502: aload_2
    //   503: aload_3
    //   504: invokespecial 161	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   507: astore_0
    //   508: aload 15
    //   510: invokevirtual 124	java/io/File:listFiles	()[Ljava/io/File;
    //   513: astore_2
    //   514: aload_2
    //   515: ifnull +164 -> 679
    //   518: aload_2
    //   519: arraylength
    //   520: istore 5
    //   522: iconst_0
    //   523: istore 4
    //   525: iload 4
    //   527: iload 5
    //   529: if_icmpge +150 -> 679
    //   532: aload_2
    //   533: iload 4
    //   535: aaload
    //   536: astore_1
    //   537: aload_1
    //   538: invokevirtual 127	java/io/File:getName	()Ljava/lang/String;
    //   541: ldc 14
    //   543: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   546: ifeq +12 -> 558
    //   549: iload 4
    //   551: iconst_1
    //   552: iadd
    //   553: istore 4
    //   555: goto -30 -> 525
    //   558: new 69	java/lang/StringBuilder
    //   561: dup
    //   562: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   565: aload_1
    //   566: invokevirtual 127	java/io/File:getName	()Ljava/lang/String;
    //   569: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_1
    //   573: invokevirtual 138	java/io/File:length	()J
    //   576: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   579: aload_1
    //   580: invokevirtual 144	java/io/File:lastModified	()J
    //   583: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   586: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 148	com/tencent/commonsdk/classload/DexClassLoaderUtil:getBase64String	(Ljava/lang/String;)Ljava/lang/String;
    //   592: invokestatic 153	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   595: astore_2
    //   596: new 76	java/io/File
    //   599: dup
    //   600: aload 15
    //   602: new 69	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   609: ldc 163
    //   611: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload 13
    //   616: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: ldc 14
    //   621: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   630: astore_3
    //   631: aload 7
    //   633: ifnull +12 -> 645
    //   636: aload 7
    //   638: aload_2
    //   639: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   642: ifne +12 -> 654
    //   645: aload 14
    //   647: aload_3
    //   648: aload_2
    //   649: aload 8
    //   651: invokestatic 33	com/tencent/commonsdk/classload/DexClassLoaderUtil:saveInfo	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload 12
    //   656: ifnull +23 -> 679
    //   659: aload 12
    //   661: new 6	com/tencent/commonsdk/classload/DexClassLoaderUtil$CheckMD5Task
    //   664: dup
    //   665: aload_1
    //   666: aload_2
    //   667: aload 8
    //   669: aload 14
    //   671: aload_3
    //   672: invokespecial 170	com/tencent/commonsdk/classload/DexClassLoaderUtil$CheckMD5Task:<init>	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V
    //   675: invokevirtual 174	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   678: pop
    //   679: aload_0
    //   680: areturn
    //   681: astore_0
    //   682: aload 6
    //   684: astore_1
    //   685: goto -294 -> 391
    //   688: astore 8
    //   690: aload 6
    //   692: astore 7
    //   694: aload_1
    //   695: astore 6
    //   697: goto -326 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	700	0	paramString1	String
    //   0	700	1	paramString2	String
    //   0	700	2	paramString3	String
    //   0	700	3	paramClassLoader	java.lang.ClassLoader
    //   36	518	4	i	int
    //   44	486	5	j	int
    //   231	465	6	localObject1	Object
    //   213	480	7	localObject2	Object
    //   208	94	8	str1	String
    //   365	10	8	localException1	Exception
    //   455	213	8	str2	String
    //   688	1	8	localException2	Exception
    //   205	273	9	localFile1	File
    //   202	166	10	arrayOfFile	File[]
    //   199	35	11	localObject3	Object
    //   28	632	12	localHandler	Handler
    //   85	530	13	str3	String
    //   182	488	14	localFile2	File
    //   123	478	15	localFile3	File
    //   112	389	16	str4	String
    // Exception table:
    //   from	to	target	type
    //   215	233	365	java/lang/Exception
    //   215	233	390	finally
    //   374	379	390	finally
    //   236	243	681	finally
    //   254	261	681	finally
    //   236	243	688	java/lang/Exception
    //   254	261	688	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  private static String getBase64String(String paramString)
  {
    String str = paramString;
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramString = str;
      if (Build.VERSION.SDK_INT >= 8) {
        paramString = Base64.encodeToString(arrayOfByte, 0);
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return str;
  }
  
  /* Error */
  private static void saveInfo(File paramFile1, File paramFile2, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: new 198	java/io/BufferedWriter
    //   9: dup
    //   10: new 200	java/io/FileWriter
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 201	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   18: invokespecial 204	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   21: astore 5
    //   23: aload 5
    //   25: aload_2
    //   26: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   29: aload 5
    //   31: invokevirtual 210	java/io/BufferedWriter:newLine	()V
    //   34: aload_3
    //   35: ifnull +9 -> 44
    //   38: aload 5
    //   40: aload_3
    //   41: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   44: aload 5
    //   46: invokestatic 120	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   49: aload_0
    //   50: invokevirtual 96	java/io/File:exists	()Z
    //   53: ifeq +8 -> 61
    //   56: aload_0
    //   57: invokevirtual 93	java/io/File:delete	()Z
    //   60: pop
    //   61: aload_1
    //   62: aload_0
    //   63: invokevirtual 214	java/io/File:renameTo	(Ljava/io/File;)Z
    //   66: pop
    //   67: return
    //   68: astore_3
    //   69: aload 6
    //   71: astore_2
    //   72: aload_2
    //   73: astore 4
    //   75: aload_3
    //   76: invokevirtual 44	java/lang/Exception:printStackTrace	()V
    //   79: aload_2
    //   80: invokestatic 120	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   83: goto -34 -> 49
    //   86: astore_0
    //   87: aload 4
    //   89: invokestatic 120	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   92: aload_0
    //   93: athrow
    //   94: astore_0
    //   95: aload 5
    //   97: astore 4
    //   99: goto -12 -> 87
    //   102: astore_3
    //   103: aload 5
    //   105: astore_2
    //   106: goto -34 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramFile1	File
    //   0	109	1	paramFile2	File
    //   0	109	2	paramString1	String
    //   0	109	3	paramString2	String
    //   1	97	4	localObject1	Object
    //   21	83	5	localBufferedWriter	java.io.BufferedWriter
    //   4	66	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	23	68	java/lang/Exception
    //   6	23	86	finally
    //   75	79	86	finally
    //   23	34	94	finally
    //   38	44	94	finally
    //   23	34	102	java/lang/Exception
    //   38	44	102	java/lang/Exception
  }
  
  private static class CheckMD5Task
    implements Runnable
  {
    private File file;
    private String info;
    private File infoFile;
    private String oldMD5;
    private File tempInfoFile;
    
    CheckMD5Task(File paramFile1, String paramString1, String paramString2, File paramFile2, File paramFile3)
    {
      this.file = paramFile1;
      this.info = paramString1;
      this.oldMD5 = paramString2;
      this.infoFile = paramFile2;
      this.tempInfoFile = paramFile3;
    }
    
    public void run()
    {
      String str = MD5Coding.encodeFile2HexStr(this.file.getAbsolutePath());
      if (this.oldMD5 == null) {
        DexClassLoaderUtil.saveInfo(this.infoFile, this.tempInfoFile, this.info, str);
      }
      while (this.oldMD5.equalsIgnoreCase(str)) {
        return;
      }
      this.file.delete();
      this.infoFile.delete();
      Process.killProcess(Process.myPid());
    }
  }
  
  public static abstract interface IHandlerCreator
  {
    public abstract Handler createHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.commonsdk.classload.DexClassLoaderUtil
 * JD-Core Version:    0.7.0.1
 */