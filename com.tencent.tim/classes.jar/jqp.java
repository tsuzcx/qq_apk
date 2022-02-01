import android.text.TextUtils;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public class jqp
{
  public static String a(ZipEntry paramZipEntry)
    throws UnsupportedEncodingException
  {
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
  
  public static ArrayList<String> a(File paramFile)
    throws ZipException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    while (paramFile.hasMoreElements()) {
      localArrayList.add(new String(a((ZipEntry)paramFile.nextElement()).getBytes("GB2312"), "8859_1"));
    }
    return localArrayList;
  }
  
  public static Enumeration<?> a(File paramFile)
    throws ZipException, IOException
  {
    return new QZipFile(paramFile).entries();
  }
  
  private static void a(QZipInputStream paramQZipInputStream, File paramFile)
  {
    localObject = null;
    File localFile = null;
    byte[] arrayOfByte = new byte[8192];
    try
    {
      paramFile = awdj.a(new FileOutputStream(paramFile));
      for (;;)
      {
        localFile = paramFile;
        localObject = paramFile;
        int i = paramQZipInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        localFile = paramFile;
        localObject = paramFile;
        paramFile.write(arrayOfByte, 0, i);
      }
      try
      {
        ((OutputStream)localObject).close();
        throw paramQZipInputStream;
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramFile);
          }
        }
      }
    }
    catch (Exception paramQZipInputStream)
    {
      localObject = localFile;
      if (QLog.isColorLevel())
      {
        localObject = localFile;
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
      }
      if (localFile != null) {}
      try
      {
        localFile.close();
        do
        {
          do
          {
            return;
          } while (paramFile == null);
          try
          {
            paramFile.close();
            return;
          }
          catch (IOException paramQZipInputStream) {}
        } while (!QLog.isColorLevel());
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
        return;
      }
      catch (IOException paramQZipInputStream)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
        return;
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  /* Error */
  public static void b(File paramFile, String paramString)
    throws ZipException, IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 63	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 66	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 70	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 6
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 7
    //   26: aload 6
    //   28: invokeinterface 49 1 0
    //   33: ifeq +302 -> 335
    //   36: aload 6
    //   38: invokeinterface 53 1 0
    //   43: checkcast 12	java/util/zip/ZipEntry
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 16	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 114
    //   55: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifne -32 -> 26
    //   61: aload 4
    //   63: invokevirtual 121	java/util/zip/ZipEntry:isDirectory	()Z
    //   66: ifeq +121 -> 187
    //   69: invokestatic 124	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   72: ifeq +32 -> 104
    //   75: ldc 126
    //   77: iconst_4
    //   78: new 128	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   85: ldc 131
    //   87: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 4
    //   92: invokevirtual 16	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: new 10	java/lang/String
    //   107: dup
    //   108: new 128	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: invokevirtual 16	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   124: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: ldc 24
    //   132: invokevirtual 22	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   135: ldc 18
    //   137: invokespecial 28	java/lang/String:<init>	([BLjava/lang/String;)V
    //   140: astore_0
    //   141: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +28 -> 172
    //   147: ldc 126
    //   149: iconst_2
    //   150: new 128	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   157: ldc 144
    //   159: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: new 146	java/io/File
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: invokevirtual 152	java/io/File:mkdir	()Z
    //   183: pop
    //   184: goto -158 -> 26
    //   187: new 146	java/io/File
    //   190: dup
    //   191: new 128	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   198: aload_1
    //   199: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 16	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   207: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 156	java/io/File:getParentFile	()Ljava/io/File;
    //   221: invokevirtual 159	java/io/File:mkdirs	()Z
    //   224: pop
    //   225: new 76	java/io/FileOutputStream
    //   228: dup
    //   229: aload_0
    //   230: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   233: invokestatic 82	awdj:a	(Ljava/io/OutputStream;)Lawdj;
    //   236: astore_0
    //   237: aload 5
    //   239: aload 4
    //   241: invokevirtual 163	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   244: astore 4
    //   246: aload 4
    //   248: aload 7
    //   250: iconst_0
    //   251: sipush 8192
    //   254: invokevirtual 166	java/io/InputStream:read	([BII)I
    //   257: istore_2
    //   258: iload_2
    //   259: iconst_m1
    //   260: if_icmpeq +46 -> 306
    //   263: aload_0
    //   264: aload 7
    //   266: iconst_0
    //   267: iload_2
    //   268: invokevirtual 94	java/io/OutputStream:write	([BII)V
    //   271: goto -25 -> 246
    //   274: astore 5
    //   276: aload_0
    //   277: astore_3
    //   278: aload 4
    //   280: astore_1
    //   281: aload 5
    //   283: astore_0
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 167	java/io/InputStream:close	()V
    //   292: aload_3
    //   293: ifnull +11 -> 304
    //   296: aload_3
    //   297: invokevirtual 170	java/io/OutputStream:flush	()V
    //   300: aload_3
    //   301: invokevirtual 110	java/io/OutputStream:close	()V
    //   304: aload_0
    //   305: athrow
    //   306: aload 4
    //   308: ifnull +8 -> 316
    //   311: aload 4
    //   313: invokevirtual 167	java/io/InputStream:close	()V
    //   316: aload_0
    //   317: ifnull -291 -> 26
    //   320: aload_0
    //   321: invokevirtual 170	java/io/OutputStream:flush	()V
    //   324: aload_0
    //   325: invokevirtual 110	java/io/OutputStream:close	()V
    //   328: goto -302 -> 26
    //   331: astore_0
    //   332: goto -306 -> 26
    //   335: aload 5
    //   337: invokevirtual 171	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   340: return
    //   341: astore 4
    //   343: goto -27 -> 316
    //   346: astore_1
    //   347: goto -55 -> 292
    //   350: astore_1
    //   351: goto -47 -> 304
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_1
    //   357: goto -73 -> 284
    //   360: astore 4
    //   362: aconst_null
    //   363: astore_1
    //   364: aload_0
    //   365: astore_3
    //   366: aload 4
    //   368: astore_0
    //   369: goto -85 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramFile	File
    //   0	372	1	paramString	String
    //   257	11	2	i	int
    //   1	365	3	localFile	File
    //   46	266	4	localObject1	Object
    //   341	1	4	localIOException	IOException
    //   360	7	4	localObject2	Object
    //   10	228	5	localQZipFile	QZipFile
    //   274	62	5	localObject3	Object
    //   17	20	6	localEnumeration	Enumeration
    //   24	241	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   246	258	274	finally
    //   263	271	274	finally
    //   320	328	331	java/io/IOException
    //   311	316	341	java/io/IOException
    //   288	292	346	java/io/IOException
    //   296	304	350	java/io/IOException
    //   225	237	354	finally
    //   237	246	360	finally
  }
  
  public static long getUncompressedFileSize(String paramString)
  {
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = -1L;
    }
    for (;;)
    {
      return l2;
      try
      {
        paramString = new QZipFile(paramString).entries();
        long l1 = 0L;
        l2 = l1;
        if (!paramString.hasMoreElements()) {
          continue;
        }
        ZipEntry localZipEntry = (ZipEntry)paramString.nextElement();
        if (!localZipEntry.isDirectory())
        {
          l2 = localZipEntry.getSize();
          l1 = l2 + l1;
        }
        for (;;)
        {
          break;
        }
      }
      catch (Exception paramString)
      {
        return -1L;
      }
    }
  }
  
  public static int k(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ZipUtils", 2, "unZipFile2 参数错误：zipFilePath:" + paramString1 + ",folderPath:" + paramString2);
      }
      return -1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ZipUtils", 4, "unZipFile2 new file:" + paramString1 + ", folderPath:" + paramString2);
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZipUtils", 4, "unZipFile2  zipFilePath doesn't exist");
      }
      return -2;
    }
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    int i;
    try
    {
      paramString1 = new QZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
    }
    catch (Throwable paramString1)
    {
      try
      {
        localObject1 = new StringBuilder(512);
        for (;;)
        {
          localObject2 = paramString1.getNextEntry();
          if (localObject2 == null) {
            break label440;
          }
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          localObject3 = ((ZipEntry)localObject2).getName();
          if (QLog.isDevelopLevel()) {
            QLog.d("ZipUtils", 4, "unZipFile2 folderPath:" + paramString2 + ",ZipEntry name: " + (String)localObject3);
          }
          ((StringBuilder)localObject1).append(paramString2).append(File.separator).append((String)localObject3);
          if (!((ZipEntry)localObject2).isDirectory()) {
            break;
          }
          localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
        }
      }
      catch (FileNotFoundException paramString2)
      {
        for (;;)
        {
          Object localObject3;
          i = -3;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
          }
          if (paramString1 == null) {
            break label530;
          }
          try
          {
            paramString1.close();
            return -3;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -3;
          }
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, " unZipFile2  解压错误：", paramString1);
          }
          paramString1 = null;
          continue;
          Object localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists())
          {
            localObject3 = ((File)localObject2).getParentFile();
            if (!((File)localObject3).exists()) {
              ((File)localObject3).mkdirs();
            }
          }
          a(paramString1, (File)localObject2);
        }
      }
      catch (IOException paramString2)
      {
        i = -4;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null)
        {
          try
          {
            paramString1.close();
            return -4;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -4;
          }
          if (paramString1 == null) {
            break label532;
          }
          try
          {
            paramString1.close();
            return 0;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return 0;
          }
        }
      }
      catch (Exception paramString2)
      {
        label440:
        i = -5;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return -5;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -5;
          }
        }
      }
      finally
      {
        if (paramString1 != null) {}
        try
        {
          paramString1.close();
          throw paramString2;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    label530:
    return i;
    label532:
    return 0;
  }
  
  /* Error */
  public static int unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +39 -> 43
    //   7: ldc 126
    //   9: iconst_4
    //   10: new 128	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   17: ldc 249
    //   19: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 250	java/lang/String:toString	()Ljava/lang/String;
    //   26: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 252
    //   31: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: bipush 9
    //   42: ireturn
    //   43: invokestatic 124	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   46: ifeq +40 -> 86
    //   49: ldc 126
    //   51: iconst_4
    //   52: new 128	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   59: ldc 249
    //   61: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 250	java/lang/String:toString	()Ljava/lang/String;
    //   68: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 254
    //   73: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: new 146	java/io/File
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 6
    //   96: aload 6
    //   98: invokevirtual 204	java/io/File:exists	()Z
    //   101: ifne +9 -> 110
    //   104: aload 6
    //   106: invokevirtual 159	java/io/File:mkdirs	()Z
    //   109: pop
    //   110: new 146	java/io/File
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_0
    //   119: new 63	com/tencent/commonsdk/zip/QZipFile
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 66	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   127: astore 9
    //   129: iconst_0
    //   130: istore_3
    //   131: sipush 8192
    //   134: newarray byte
    //   136: astore 8
    //   138: new 128	java/lang/StringBuilder
    //   141: dup
    //   142: sipush 512
    //   145: invokespecial 218	java/lang/StringBuilder:<init>	(I)V
    //   148: astore 10
    //   150: aload 9
    //   152: invokevirtual 70	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   155: astore 11
    //   157: iload_3
    //   158: istore_2
    //   159: aload 11
    //   161: invokeinterface 49 1 0
    //   166: ifeq +611 -> 777
    //   169: aload 11
    //   171: invokeinterface 53 1 0
    //   176: checkcast 12	java/util/zip/ZipEntry
    //   179: astore 12
    //   181: aload 12
    //   183: invokevirtual 16	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   186: astore_0
    //   187: aload_0
    //   188: ldc 114
    //   190: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   193: ifne -36 -> 157
    //   196: aload 10
    //   198: iconst_0
    //   199: aload 10
    //   201: invokevirtual 226	java/lang/StringBuilder:length	()I
    //   204: invokevirtual 230	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 10
    //   210: aload_1
    //   211: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: getstatic 238	java/io/File:separator	Ljava/lang/String;
    //   217: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 12
    //   227: invokevirtual 121	java/util/zip/ZipEntry:isDirectory	()Z
    //   230: ifeq +119 -> 349
    //   233: new 146	java/io/File
    //   236: dup
    //   237: aload 10
    //   239: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 204	java/io/File:exists	()Z
    //   250: ifne -93 -> 157
    //   253: aload_0
    //   254: invokevirtual 159	java/io/File:mkdirs	()Z
    //   257: pop
    //   258: goto -101 -> 157
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 255	java/io/FileNotFoundException:printStackTrace	()V
    //   266: iconst_5
    //   267: istore_2
    //   268: aload 9
    //   270: invokevirtual 171	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   273: iload_2
    //   274: ireturn
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   280: bipush 8
    //   282: ireturn
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 256	java/util/zip/ZipException:printStackTrace	()V
    //   288: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +12 -> 303
    //   294: ldc 126
    //   296: iconst_2
    //   297: ldc_w 258
    //   300: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: iconst_1
    //   304: ireturn
    //   305: astore_0
    //   306: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +12 -> 321
    //   312: ldc 126
    //   314: iconst_2
    //   315: ldc_w 260
    //   318: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload_0
    //   322: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   325: iconst_2
    //   326: ireturn
    //   327: astore_0
    //   328: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +12 -> 343
    //   334: ldc 126
    //   336: iconst_2
    //   337: ldc_w 262
    //   340: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_0
    //   344: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   347: iconst_3
    //   348: ireturn
    //   349: aconst_null
    //   350: astore 7
    //   352: aload 9
    //   354: aload 12
    //   356: invokevirtual 163	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   359: astore_0
    //   360: new 265	java/util/zip/CheckedInputStream
    //   363: dup
    //   364: aload_0
    //   365: new 267	java/util/zip/CRC32
    //   368: dup
    //   369: invokespecial 268	java/util/zip/CRC32:<init>	()V
    //   372: invokespecial 271	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   375: astore 6
    //   377: new 146	java/io/File
    //   380: dup
    //   381: new 10	java/lang/String
    //   384: dup
    //   385: aload 10
    //   387: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: ldc 24
    //   392: invokevirtual 22	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   395: ldc 18
    //   397: invokespecial 28	java/lang/String:<init>	([BLjava/lang/String;)V
    //   400: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   403: astore 7
    //   405: aload 7
    //   407: invokevirtual 204	java/io/File:exists	()Z
    //   410: ifne +24 -> 434
    //   413: aload 7
    //   415: invokevirtual 156	java/io/File:getParentFile	()Ljava/io/File;
    //   418: astore 13
    //   420: aload 13
    //   422: invokevirtual 204	java/io/File:exists	()Z
    //   425: ifne +9 -> 434
    //   428: aload 13
    //   430: invokevirtual 159	java/io/File:mkdirs	()Z
    //   433: pop
    //   434: new 273	java/io/BufferedOutputStream
    //   437: dup
    //   438: new 76	java/io/FileOutputStream
    //   441: dup
    //   442: aload 7
    //   444: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   447: invokespecial 276	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   450: invokestatic 82	awdj:a	(Ljava/io/OutputStream;)Lawdj;
    //   453: astore 7
    //   455: aload 12
    //   457: invokevirtual 185	java/util/zip/ZipEntry:getSize	()J
    //   460: lstore 4
    //   462: lload 4
    //   464: lconst_0
    //   465: lcmp
    //   466: ifle +34 -> 500
    //   469: aload 6
    //   471: aload 8
    //   473: iconst_0
    //   474: sipush 8192
    //   477: invokevirtual 277	java/util/zip/CheckedInputStream:read	([BII)I
    //   480: istore_2
    //   481: aload 7
    //   483: aload 8
    //   485: iconst_0
    //   486: iload_2
    //   487: invokevirtual 94	java/io/OutputStream:write	([BII)V
    //   490: lload 4
    //   492: iload_2
    //   493: i2l
    //   494: lsub
    //   495: lstore 4
    //   497: goto -35 -> 462
    //   500: aload 12
    //   502: invokevirtual 280	java/util/zip/ZipEntry:getCrc	()J
    //   505: aload 6
    //   507: invokevirtual 284	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   510: invokeinterface 289 1 0
    //   515: lcmp
    //   516: ifeq +85 -> 601
    //   519: iconst_4
    //   520: istore_2
    //   521: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +33 -> 557
    //   527: ldc 126
    //   529: iconst_2
    //   530: new 128	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 291
    //   540: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 12
    //   545: invokevirtual 280	java/util/zip/ZipEntry:getCrc	()J
    //   548: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   551: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: aload 6
    //   559: ifnull +8 -> 567
    //   562: aload 6
    //   564: invokevirtual 295	java/util/zip/CheckedInputStream:close	()V
    //   567: aload_0
    //   568: ifnull +7 -> 575
    //   571: aload_0
    //   572: invokevirtual 167	java/io/InputStream:close	()V
    //   575: aload 7
    //   577: ifnull +200 -> 777
    //   580: aload 7
    //   582: invokevirtual 170	java/io/OutputStream:flush	()V
    //   585: aload 7
    //   587: invokevirtual 110	java/io/OutputStream:close	()V
    //   590: iconst_4
    //   591: istore_2
    //   592: goto -324 -> 268
    //   595: astore_0
    //   596: iconst_4
    //   597: istore_2
    //   598: goto -330 -> 268
    //   601: aload 6
    //   603: ifnull +8 -> 611
    //   606: aload 6
    //   608: invokevirtual 295	java/util/zip/CheckedInputStream:close	()V
    //   611: aload_0
    //   612: ifnull +7 -> 619
    //   615: aload_0
    //   616: invokevirtual 167	java/io/InputStream:close	()V
    //   619: aload 7
    //   621: ifnull -464 -> 157
    //   624: aload 7
    //   626: invokevirtual 170	java/io/OutputStream:flush	()V
    //   629: aload 7
    //   631: invokevirtual 110	java/io/OutputStream:close	()V
    //   634: goto -477 -> 157
    //   637: astore_0
    //   638: goto -481 -> 157
    //   641: astore_0
    //   642: aconst_null
    //   643: astore_1
    //   644: aconst_null
    //   645: astore 6
    //   647: aload 6
    //   649: ifnull +8 -> 657
    //   652: aload 6
    //   654: invokevirtual 295	java/util/zip/CheckedInputStream:close	()V
    //   657: aload 7
    //   659: ifnull +8 -> 667
    //   662: aload 7
    //   664: invokevirtual 167	java/io/InputStream:close	()V
    //   667: aload_1
    //   668: ifnull +11 -> 679
    //   671: aload_1
    //   672: invokevirtual 170	java/io/OutputStream:flush	()V
    //   675: aload_1
    //   676: invokevirtual 110	java/io/OutputStream:close	()V
    //   679: aload_0
    //   680: athrow
    //   681: astore_0
    //   682: aload_0
    //   683: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   686: bipush 6
    //   688: istore_2
    //   689: goto -421 -> 268
    //   692: astore_0
    //   693: aload_0
    //   694: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   697: bipush 7
    //   699: istore_2
    //   700: goto -432 -> 268
    //   703: astore_1
    //   704: goto -137 -> 567
    //   707: astore_0
    //   708: goto -133 -> 575
    //   711: astore 6
    //   713: goto -102 -> 611
    //   716: astore_0
    //   717: goto -98 -> 619
    //   720: astore 6
    //   722: goto -65 -> 657
    //   725: astore 6
    //   727: goto -60 -> 667
    //   730: astore_1
    //   731: goto -52 -> 679
    //   734: astore 8
    //   736: aconst_null
    //   737: astore_1
    //   738: aload_0
    //   739: astore 7
    //   741: aconst_null
    //   742: astore 6
    //   744: aload 8
    //   746: astore_0
    //   747: goto -100 -> 647
    //   750: astore 8
    //   752: aconst_null
    //   753: astore_1
    //   754: aload_0
    //   755: astore 7
    //   757: aload 8
    //   759: astore_0
    //   760: goto -113 -> 647
    //   763: astore 8
    //   765: aload 7
    //   767: astore_1
    //   768: aload_0
    //   769: astore 7
    //   771: aload 8
    //   773: astore_0
    //   774: goto -127 -> 647
    //   777: goto -509 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	paramString1	String
    //   0	780	1	paramString2	String
    //   158	542	2	i	int
    //   130	28	3	j	int
    //   460	36	4	l	long
    //   94	559	6	localObject1	Object
    //   711	1	6	localIOException1	IOException
    //   720	1	6	localIOException2	IOException
    //   725	1	6	localIOException3	IOException
    //   742	1	6	localObject2	Object
    //   350	420	7	localObject3	Object
    //   136	348	8	arrayOfByte	byte[]
    //   734	11	8	localObject4	Object
    //   750	8	8	localObject5	Object
    //   763	9	8	localObject6	Object
    //   127	226	9	localQZipFile	QZipFile
    //   148	238	10	localStringBuilder	StringBuilder
    //   155	15	11	localEnumeration	Enumeration
    //   179	365	12	localZipEntry	ZipEntry
    //   418	11	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   131	157	261	java/io/FileNotFoundException
    //   159	258	261	java/io/FileNotFoundException
    //   562	567	261	java/io/FileNotFoundException
    //   571	575	261	java/io/FileNotFoundException
    //   580	590	261	java/io/FileNotFoundException
    //   606	611	261	java/io/FileNotFoundException
    //   615	619	261	java/io/FileNotFoundException
    //   624	634	261	java/io/FileNotFoundException
    //   652	657	261	java/io/FileNotFoundException
    //   662	667	261	java/io/FileNotFoundException
    //   671	679	261	java/io/FileNotFoundException
    //   679	681	261	java/io/FileNotFoundException
    //   268	273	275	java/io/IOException
    //   119	129	283	java/util/zip/ZipException
    //   119	129	305	java/io/IOException
    //   119	129	327	java/lang/Exception
    //   580	590	595	java/io/IOException
    //   624	634	637	java/io/IOException
    //   352	360	641	finally
    //   131	157	681	java/io/IOException
    //   159	258	681	java/io/IOException
    //   679	681	681	java/io/IOException
    //   131	157	692	java/lang/Exception
    //   159	258	692	java/lang/Exception
    //   562	567	692	java/lang/Exception
    //   571	575	692	java/lang/Exception
    //   580	590	692	java/lang/Exception
    //   606	611	692	java/lang/Exception
    //   615	619	692	java/lang/Exception
    //   624	634	692	java/lang/Exception
    //   652	657	692	java/lang/Exception
    //   662	667	692	java/lang/Exception
    //   671	679	692	java/lang/Exception
    //   679	681	692	java/lang/Exception
    //   562	567	703	java/io/IOException
    //   571	575	707	java/io/IOException
    //   606	611	711	java/io/IOException
    //   615	619	716	java/io/IOException
    //   652	657	720	java/io/IOException
    //   662	667	725	java/io/IOException
    //   671	679	730	java/io/IOException
    //   360	377	734	finally
    //   377	434	750	finally
    //   434	455	750	finally
    //   455	462	763	finally
    //   469	490	763	finally
    //   500	519	763	finally
    //   521	557	763	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jqp
 * JD-Core Version:    0.7.0.1
 */