import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.utils.FileUtils.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;
import java.io.IOException;
import mqq.os.MqqHandler;

public class rox
{
  public static boolean LN()
  {
    long l = dY();
    ram.d("Q.qqstory:Utils", "free spac:" + l / 1024L / 1024L + "MB--" + l);
    return l < 52428800L;
  }
  
  public static long O(String paramString)
  {
    paramString = aqhq.readFile(paramString + "/" + "dont_delete.txt");
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = Long.valueOf(new String(paramString).trim().replaceAll("[\n\r]", "")).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      ram.w("Q.qqstory:Utils", "exception", paramString);
    }
    return 0L;
  }
  
  public static ContentValues a(Context paramContext, File paramFile)
  {
    paramContext = new ContentValues();
    paramContext.put("title", paramFile.getName());
    paramContext.put("_display_name", paramFile.getName());
    paramContext.put("mime_type", "video/mp4");
    paramContext.put("datetaken", Long.valueOf(paramFile.lastModified()));
    paramContext.put("date_modified", Long.valueOf(paramFile.lastModified()));
    paramContext.put("date_added", Long.valueOf(paramFile.lastModified()));
    paramContext.put("_data", paramFile.getAbsolutePath());
    paramContext.put("_size", Long.valueOf(paramFile.length()));
    return paramContext;
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = a(paramContext, paramFile);
    try
    {
      localContentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
      broadcastCarmera(paramContext, paramFile);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ram.w("Q.qqstory:Utils", "exception", localException);
      }
    }
  }
  
  public static boolean aD(Context paramContext)
  {
    if (!LN()) {
      return false;
    }
    ram.w("Q.qqstory:Utils", "low capacity!");
    if ((paramContext instanceof QQStoryBaseActivity)) {}
    for (boolean bool = ((QQStoryBaseActivity)paramContext).isValidate();; bool = true)
    {
      if (bool) {
        ThreadManager.getUIHandler().post(new FileUtils.1(paramContext));
      }
      return true;
    }
  }
  
  /* Error */
  public static byte[] b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 196	java/io/File:exists	()Z
    //   4: ifne +30 -> 34
    //   7: new 198	java/lang/RuntimeException
    //   10: dup
    //   11: new 14	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: ldc 203
    //   24: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   33: athrow
    //   34: aload_0
    //   35: invokevirtual 209	java/io/File:isFile	()Z
    //   38: ifne +30 -> 68
    //   41: new 198	java/lang/RuntimeException
    //   44: dup
    //   45: new 14	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   52: aload_0
    //   53: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: ldc 211
    //   58: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: aload_0
    //   69: invokevirtual 214	java/io/File:canRead	()Z
    //   72: ifne +30 -> 102
    //   75: new 198	java/lang/RuntimeException
    //   78: dup
    //   79: new 14	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   86: aload_0
    //   87: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: ldc 216
    //   92: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: aload_0
    //   103: invokevirtual 135	java/io/File:length	()J
    //   106: lstore 4
    //   108: lload 4
    //   110: l2i
    //   111: istore_1
    //   112: iload_1
    //   113: i2l
    //   114: lload 4
    //   116: lcmp
    //   117: ifeq +30 -> 147
    //   120: new 198	java/lang/RuntimeException
    //   123: dup
    //   124: new 14	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   131: aload_0
    //   132: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: ldc 218
    //   137: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    //   147: iload_1
    //   148: newarray byte
    //   150: astore 8
    //   152: new 220	java/io/FileInputStream
    //   155: dup
    //   156: aload_0
    //   157: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   160: astore 7
    //   162: iconst_0
    //   163: istore_2
    //   164: iload_1
    //   165: ifle +116 -> 281
    //   168: aload 7
    //   170: astore 6
    //   172: aload 7
    //   174: aload 8
    //   176: iload_2
    //   177: iload_1
    //   178: invokevirtual 227	java/io/FileInputStream:read	([BII)I
    //   181: istore_3
    //   182: iload_3
    //   183: iconst_m1
    //   184: if_icmpne +86 -> 270
    //   187: aload 7
    //   189: astore 6
    //   191: new 198	java/lang/RuntimeException
    //   194: dup
    //   195: new 14	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   202: aload_0
    //   203: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: ldc 229
    //   208: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   217: athrow
    //   218: astore 8
    //   220: aload 7
    //   222: astore 6
    //   224: aload 8
    //   226: astore 7
    //   228: new 198	java/lang/RuntimeException
    //   231: dup
    //   232: new 14	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   239: aload_0
    //   240: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   243: ldc 231
    //   245: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: aload 7
    //   253: invokespecial 234	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: athrow
    //   257: astore_0
    //   258: aload 6
    //   260: ifnull +8 -> 268
    //   263: aload 6
    //   265: invokevirtual 237	java/io/FileInputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: iload_2
    //   271: iload_3
    //   272: iadd
    //   273: istore_2
    //   274: iload_1
    //   275: iload_3
    //   276: isub
    //   277: istore_1
    //   278: goto -114 -> 164
    //   281: aload 7
    //   283: ifnull +8 -> 291
    //   286: aload 7
    //   288: invokevirtual 237	java/io/FileInputStream:close	()V
    //   291: aload 8
    //   293: areturn
    //   294: astore_0
    //   295: aload_0
    //   296: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   299: aload 8
    //   301: areturn
    //   302: astore 6
    //   304: aload 6
    //   306: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   309: goto -41 -> 268
    //   312: astore_0
    //   313: aconst_null
    //   314: astore 6
    //   316: goto -58 -> 258
    //   319: astore 7
    //   321: aconst_null
    //   322: astore 6
    //   324: goto -96 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramFile	File
    //   111	167	1	i	int
    //   163	111	2	j	int
    //   181	96	3	k	int
    //   106	9	4	l	long
    //   170	94	6	localObject1	Object
    //   302	3	6	localIOException1	IOException
    //   314	9	6	localObject2	Object
    //   160	127	7	localObject3	Object
    //   319	1	7	localIOException2	IOException
    //   150	25	8	arrayOfByte	byte[]
    //   218	82	8	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   172	182	218	java/io/IOException
    //   191	218	218	java/io/IOException
    //   172	182	257	finally
    //   191	218	257	finally
    //   228	257	257	finally
    //   286	291	294	java/io/IOException
    //   263	268	302	java/io/IOException
    //   152	162	312	finally
    //   152	162	319	java/io/IOException
  }
  
  public static boolean bc(long paramLong)
  {
    long l = dY();
    ram.d("Q.qqstory:Utils", "free spac:" + l / 1024L / 1024L + "MB--" + l);
    return l < paramLong * 1024L * 1024L;
  }
  
  public static void broadcastCarmera(Context paramContext, File paramFile)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramFile);
  }
  
  public static boolean checkDirAndCreate(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      ram.w("Q.qqstory:Utils", "mkdirs failed, path:%s", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public static boolean checkFileExist(String paramString)
  {
    return aqhq.fileExists(paramString);
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 220	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_0
    //   14: new 267	java/io/BufferedOutputStream
    //   17: dup
    //   18: new 269	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 270	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: invokespecial 273	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore_3
    //   30: sipush 4096
    //   33: newarray byte
    //   35: astore_1
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 276	java/io/FileInputStream:read	([B)I
    //   41: istore_2
    //   42: iconst_m1
    //   43: iload_2
    //   44: if_icmpeq +30 -> 74
    //   47: aload_3
    //   48: aload_1
    //   49: iconst_0
    //   50: iload_2
    //   51: invokevirtual 280	java/io/BufferedOutputStream:write	([BII)V
    //   54: goto -18 -> 36
    //   57: astore_1
    //   58: aload_0
    //   59: astore_1
    //   60: aload_3
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic 286	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_1
    //   68: invokestatic 286	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: iconst_0
    //   73: ireturn
    //   74: aload_3
    //   75: invokevirtual 289	java/io/BufferedOutputStream:flush	()V
    //   78: aload_3
    //   79: invokestatic 286	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_0
    //   84: invokestatic 286	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: iconst_1
    //   89: ireturn
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_0
    //   93: aload 4
    //   95: astore_3
    //   96: aload_3
    //   97: invokestatic 286	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload_0
    //   102: invokestatic 286	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload 4
    //   111: astore_3
    //   112: goto -16 -> 96
    //   115: astore_1
    //   116: goto -20 -> 96
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_3
    //   123: astore_1
    //   124: goto -62 -> 62
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_3
    //   130: aload_0
    //   131: astore_1
    //   132: aload_3
    //   133: astore_0
    //   134: goto -72 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramFile1	File
    //   0	137	1	paramFile2	File
    //   41	10	2	i	int
    //   4	129	3	localObject1	Object
    //   1	109	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	36	57	java/io/IOException
    //   36	42	57	java/io/IOException
    //   47	54	57	java/io/IOException
    //   74	78	57	java/io/IOException
    //   5	14	90	finally
    //   14	30	108	finally
    //   30	36	115	finally
    //   36	42	115	finally
    //   47	54	115	finally
    //   74	78	115	finally
    //   5	14	119	java/io/IOException
    //   14	30	127	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    return aqhq.copyFile(paramString1, paramString2);
  }
  
  public static File createFile(String paramString)
    throws IOException
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
  
  /* Error */
  @android.annotation.TargetApi(9)
  public static byte[] d(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 135	java/io/File:length	()J
    //   4: lstore 4
    //   6: lload 4
    //   8: l2i
    //   9: istore_1
    //   10: iload_1
    //   11: i2l
    //   12: lload 4
    //   14: lcmp
    //   15: ifeq +36 -> 51
    //   18: new 193	java/io/IOException
    //   21: dup
    //   22: new 14	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   29: aload_0
    //   30: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: ldc_w 307
    //   36: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: lload 4
    //   41: invokevirtual 29	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 308	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: iload_1
    //   52: newarray byte
    //   54: astore 8
    //   56: new 220	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore 7
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_1
    //   69: ifle +117 -> 186
    //   72: aload 7
    //   74: astore 6
    //   76: aload 7
    //   78: aload 8
    //   80: iload_2
    //   81: iload_1
    //   82: invokevirtual 227	java/io/FileInputStream:read	([BII)I
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_m1
    //   88: if_icmpne +87 -> 175
    //   91: aload 7
    //   93: astore 6
    //   95: new 193	java/io/IOException
    //   98: dup
    //   99: new 14	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   106: aload_0
    //   107: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: ldc_w 310
    //   113: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 308	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore 8
    //   125: aload 7
    //   127: astore 6
    //   129: aload 8
    //   131: astore 7
    //   133: new 193	java/io/IOException
    //   136: dup
    //   137: new 14	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   144: aload_0
    //   145: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: ldc 231
    //   150: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aload 7
    //   158: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: athrow
    //   162: astore_0
    //   163: aload 6
    //   165: ifnull +8 -> 173
    //   168: aload 6
    //   170: invokevirtual 237	java/io/FileInputStream:close	()V
    //   173: aload_0
    //   174: athrow
    //   175: iload_2
    //   176: iload_3
    //   177: iadd
    //   178: istore_2
    //   179: iload_1
    //   180: iload_3
    //   181: isub
    //   182: istore_1
    //   183: goto -115 -> 68
    //   186: aload 7
    //   188: ifnull +8 -> 196
    //   191: aload 7
    //   193: invokevirtual 237	java/io/FileInputStream:close	()V
    //   196: aload 8
    //   198: areturn
    //   199: astore_0
    //   200: aconst_null
    //   201: astore 6
    //   203: goto -40 -> 163
    //   206: astore 7
    //   208: aconst_null
    //   209: astore 6
    //   211: goto -78 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramFile	File
    //   9	174	1	i	int
    //   67	112	2	j	int
    //   85	97	3	k	int
    //   4	36	4	l	long
    //   74	136	6	localObject1	Object
    //   64	128	7	localObject2	Object
    //   206	1	7	localIOException1	IOException
    //   54	25	8	arrayOfByte	byte[]
    //   123	74	8	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   76	86	123	java/io/IOException
    //   95	123	123	java/io/IOException
    //   76	86	162	finally
    //   95	123	162	finally
    //   133	162	162	finally
    //   56	66	199	finally
    //   56	66	206	java/io/IOException
  }
  
  public static long dY()
  {
    return aqhq.bB();
  }
  
  public static void delete(File paramFile)
  {
    ram.w("Q.qqstory:Utils", "delete " + paramFile);
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      delete(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    ram.w("Q.qqstory:Utils", "delete %s", new Object[] { paramString });
    aqhq.delete(paramString, paramBoolean);
  }
  
  public static boolean deleteFile(String paramString)
  {
    if (aqmr.isEmpty(paramString))
    {
      ram.w("Q.qqstory:Utils", "save from: delete path null");
      return false;
    }
    aqhq.deleteFile(paramString);
    ram.w("Q.qqstory:Utils", "deleteFile %s", new Object[] { paramString });
    return true;
  }
  
  public static boolean exists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.indexOf("assets") < 0) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static boolean fA(String paramString)
  {
    aqhq.cn(paramString);
    ram.w("Q.qqstory:Utils", "removeAllFiles " + paramString);
    return true;
  }
  
  public static boolean fB(String paramString)
  {
    if (aqmr.isEmpty(paramString))
    {
      ram.w("Q.qqstory:Utils", "save from: delete path null");
      return false;
    }
    aqhq.deleteFile(paramString);
    ram.w("Q.qqstory:Utils", "tryDeleteFile %s", new Object[] { paramString });
    return true;
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf("?");
    } while ((i == -1) || (i == paramString.length() - 1));
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFileNameFromUrl(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
      j = paramString.lastIndexOf("?");
    } while ((i == -1) || (i == paramString.length() - 1));
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static long getFileSize(String paramString)
  {
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString)
    {
      ram.c("Q.qqstory:Utils", paramString, "", new Object[0]);
    }
    return -1L;
  }
  
  public static long getFileSizes(String paramString)
  {
    return aqhq.getFileSizes(paramString);
  }
  
  public static String gl(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    if ((i > 0) && (j > i)) {
      return paramString.substring(i + 1, j);
    }
    return "";
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    return aqhq.moveFile(paramString1, paramString2);
  }
  
  /* Error */
  public static String q(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: invokevirtual 408	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_1
    //   8: invokevirtual 414	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_1
    //   14: iconst_0
    //   15: invokevirtual 418	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   18: astore 5
    //   20: aload 5
    //   22: astore 6
    //   24: aload_3
    //   25: astore 4
    //   27: ldc_w 419
    //   30: newarray byte
    //   32: astore 8
    //   34: aload 5
    //   36: astore 6
    //   38: aload_3
    //   39: astore 4
    //   41: aload_3
    //   42: aload 8
    //   44: invokevirtual 422	java/io/InputStream:read	([B)I
    //   47: istore_2
    //   48: iload_2
    //   49: ifle +60 -> 109
    //   52: aload 5
    //   54: astore 6
    //   56: aload_3
    //   57: astore 4
    //   59: aload 5
    //   61: aload 8
    //   63: iconst_0
    //   64: iload_2
    //   65: invokevirtual 423	java/io/FileOutputStream:write	([BII)V
    //   68: goto -34 -> 34
    //   71: astore_1
    //   72: aload 5
    //   74: astore_0
    //   75: aload_0
    //   76: astore 6
    //   78: aload_3
    //   79: astore 4
    //   81: aload_1
    //   82: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 424	java/io/InputStream:close	()V
    //   93: aload 7
    //   95: astore_1
    //   96: aload_0
    //   97: ifnull +10 -> 107
    //   100: aload_0
    //   101: invokevirtual 425	java/io/FileOutputStream:close	()V
    //   104: aload 7
    //   106: astore_1
    //   107: aload_1
    //   108: areturn
    //   109: aload 5
    //   111: astore 6
    //   113: aload_3
    //   114: astore 4
    //   116: aload 5
    //   118: invokevirtual 426	java/io/FileOutputStream:flush	()V
    //   121: aload 5
    //   123: astore 6
    //   125: aload_3
    //   126: astore 4
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 429	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   133: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   136: astore_0
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 424	java/io/InputStream:close	()V
    //   145: aload_0
    //   146: astore_1
    //   147: aload 5
    //   149: ifnull -42 -> 107
    //   152: aload 5
    //   154: invokevirtual 425	java/io/FileOutputStream:close	()V
    //   157: aload_0
    //   158: areturn
    //   159: astore_1
    //   160: aload_0
    //   161: areturn
    //   162: astore_0
    //   163: aconst_null
    //   164: astore 6
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 424	java/io/InputStream:close	()V
    //   176: aload 6
    //   178: ifnull +8 -> 186
    //   181: aload 6
    //   183: invokevirtual 425	java/io/FileOutputStream:close	()V
    //   186: aload_0
    //   187: athrow
    //   188: astore_1
    //   189: goto -44 -> 145
    //   192: astore_1
    //   193: goto -100 -> 93
    //   196: astore_0
    //   197: aconst_null
    //   198: areturn
    //   199: astore_1
    //   200: goto -24 -> 176
    //   203: astore_1
    //   204: goto -18 -> 186
    //   207: astore_0
    //   208: aconst_null
    //   209: astore 6
    //   211: goto -43 -> 168
    //   214: astore_0
    //   215: aload 4
    //   217: astore_3
    //   218: goto -50 -> 168
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_0
    //   224: aconst_null
    //   225: astore_3
    //   226: goto -151 -> 75
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_0
    //   232: goto -157 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramContext	Context
    //   0	235	1	paramString	String
    //   47	18	2	i	int
    //   11	215	3	localObject1	Object
    //   25	191	4	localObject2	Object
    //   18	135	5	localFileOutputStream	java.io.FileOutputStream
    //   22	188	6	localObject3	Object
    //   1	104	7	localObject4	Object
    //   32	30	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	34	71	java/io/IOException
    //   41	48	71	java/io/IOException
    //   59	68	71	java/io/IOException
    //   116	121	71	java/io/IOException
    //   128	137	71	java/io/IOException
    //   152	157	159	java/io/IOException
    //   3	12	162	finally
    //   141	145	188	java/io/IOException
    //   89	93	192	java/io/IOException
    //   100	104	196	java/io/IOException
    //   172	176	199	java/io/IOException
    //   181	186	203	java/io/IOException
    //   12	20	207	finally
    //   27	34	214	finally
    //   41	48	214	finally
    //   59	68	214	finally
    //   81	85	214	finally
    //   116	121	214	finally
    //   128	137	214	finally
    //   3	12	221	java/io/IOException
    //   12	20	229	java/io/IOException
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    return aqhq.rename(paramString1, paramString2);
  }
  
  public static void sG(String paramString)
  {
    String str = paramString + "/" + "dont_delete.txt";
    if (!fileExistsAndNotEmpty(str))
    {
      checkDirAndCreate(paramString);
      ram.w("Q.qqstory:Utils", "make flag file %b", new Object[] { Boolean.valueOf(aqhq.writeFile(str, String.valueOf(System.currentTimeMillis()))) });
      return;
    }
    ram.w("Q.qqstory:Utils", "flag file exist");
  }
  
  public static boolean saveVideoToAlbum(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return false;
    }
    paramString2 = new File(paramString2);
    String str = paramString2.getParent();
    if (str != null) {
      checkDirAndCreate(str);
    }
    boolean bool = copyFile(paramString1, paramString2);
    ram.i("Q.qqstory:Utils", "saveVideoToAlbum: " + bool);
    broadcastCarmera(paramContext, paramString2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rox
 * JD-Core Version:    0.7.0.1
 */