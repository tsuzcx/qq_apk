package com.tencent.biz.common.util;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtils
{
  protected static final int a = 1048576;
  
  public static String a(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getComment().getBytes("GB2312"), "8859_1");
  }
  
  public static ArrayList a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    while (paramFile.hasMoreElements())
    {
      String str = b((ZipEntry)paramFile.nextElement());
      if (str != null) {
        localArrayList.add(new String(str.getBytes("GB2312"), "8859_1"));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList a(File paramFile, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramString1);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    paramFile = new ZipFile(paramFile);
    localObject1 = paramFile.entries();
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject2 = (ZipEntry)((Enumeration)localObject1).nextElement();
      if ((((ZipEntry)localObject2).getName() != null) && (!((ZipEntry)localObject2).getName().contains("../")) && (((ZipEntry)localObject2).getName().contains(paramString2)))
      {
        InputStream localInputStream = paramFile.getInputStream((ZipEntry)localObject2);
        localObject2 = new File(new String((paramString1 + File.separator + ((ZipEntry)localObject2).getName()).getBytes("8859_1"), "GB2312"));
        if (!((File)localObject2).exists())
        {
          localObject3 = ((File)localObject2).getParentFile();
          if (!((File)localObject3).exists()) {
            ((File)localObject3).mkdirs();
          }
          ((File)localObject2).createNewFile();
        }
        Object localObject3 = new FileOutputStream((File)localObject2);
        byte[] arrayOfByte = new byte[1048576];
        for (;;)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          ((OutputStream)localObject3).write(arrayOfByte, 0, i);
        }
        localInputStream.close();
        ((OutputStream)localObject3).close();
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
  
  public static Enumeration a(File paramFile)
  {
    return new ZipFile(paramFile).entries();
  }
  
  public static void a(File paramFile, String paramString)
  {
    paramFile = new ZipFile(paramFile);
    Enumeration localEnumeration = paramFile.entries();
    byte[] arrayOfByte = new byte[1024];
    while (localEnumeration.hasMoreElements())
    {
      Object localObject2 = (ZipEntry)localEnumeration.nextElement();
      if ((((ZipEntry)localObject2).getName() != null) && (!((ZipEntry)localObject2).getName().contains("../")))
      {
        Object localObject1;
        if (((ZipEntry)localObject2).isDirectory())
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("upZipFile", 4, "ze.getName() = " + ((ZipEntry)localObject2).getName());
          }
          localObject1 = new String((paramString + ((ZipEntry)localObject2).getName()).getBytes("8859_1"), "GB2312");
          if (QLog.isColorLevel()) {
            QLog.d("upZipFile", 2, "str = " + (String)localObject1);
          }
          new File((String)localObject1).mkdir();
        }
        else
        {
          localObject1 = new BufferedOutputStream(new FileOutputStream(new File(paramString + ((ZipEntry)localObject2).getName())));
          localObject2 = new BufferedInputStream(paramFile.getInputStream((ZipEntry)localObject2));
          for (;;)
          {
            int i = ((InputStream)localObject2).read(arrayOfByte, 0, 1024);
            if (i == -1) {
              break;
            }
            ((OutputStream)localObject1).write(arrayOfByte, 0, i);
          }
          ((InputStream)localObject2).close();
          ((OutputStream)localObject1).close();
        }
      }
    }
    paramFile.close();
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 142	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc 144
    //   10: iconst_4
    //   11: new 92	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   18: ldc 180
    //   20: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 181	java/lang/String:toString	()Ljava/lang/String;
    //   27: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 183
    //   32: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: new 59	java/io/File
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 4
    //   55: aload 4
    //   57: invokevirtual 65	java/io/File:exists	()Z
    //   60: ifne +9 -> 69
    //   63: aload 4
    //   65: invokevirtual 111	java/io/File:mkdirs	()Z
    //   68: pop
    //   69: new 59	java/io/File
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore_0
    //   78: new 70	java/util/zip/ZipFile
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 73	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 77	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   91: astore 4
    //   93: aload 4
    //   95: invokeinterface 45 1 0
    //   100: ifeq +332 -> 432
    //   103: aload 4
    //   105: invokeinterface 49 1 0
    //   110: checkcast 17	java/util/zip/ZipEntry
    //   113: astore 6
    //   115: aload 6
    //   117: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   120: ifnull -27 -> 93
    //   123: aload 6
    //   125: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   128: ldc 82
    //   130: invokevirtual 86	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   133: ifne -40 -> 93
    //   136: aload 6
    //   138: invokevirtual 137	java/util/zip/ZipEntry:isDirectory	()Z
    //   141: ifeq +122 -> 263
    //   144: aload 6
    //   146: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   149: astore 5
    //   151: new 59	java/io/File
    //   154: dup
    //   155: new 92	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   162: aload_1
    //   163: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: getstatic 101	java/io/File:separator	Ljava/lang/String;
    //   169: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 5
    //   174: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: astore 5
    //   185: aload 5
    //   187: invokevirtual 65	java/io/File:exists	()Z
    //   190: ifne -97 -> 93
    //   193: aload 5
    //   195: invokevirtual 111	java/io/File:mkdirs	()Z
    //   198: pop
    //   199: goto -106 -> 93
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 186	java/io/FileNotFoundException:printStackTrace	()V
    //   207: iconst_1
    //   208: istore_2
    //   209: aload_0
    //   210: invokevirtual 169	java/util/zip/ZipFile:close	()V
    //   213: iload_2
    //   214: ifne +233 -> 447
    //   217: iconst_1
    //   218: istore_3
    //   219: iload_3
    //   220: ireturn
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 187	java/util/zip/ZipException:printStackTrace	()V
    //   226: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq -10 -> 219
    //   232: ldc 144
    //   234: iconst_2
    //   235: ldc 189
    //   237: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_0
    //   243: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +11 -> 257
    //   249: ldc 144
    //   251: iconst_2
    //   252: ldc 191
    //   254: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_0
    //   258: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   261: iconst_0
    //   262: ireturn
    //   263: aload_0
    //   264: aload 6
    //   266: invokevirtual 90	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   269: astore 5
    //   271: new 59	java/io/File
    //   274: dup
    //   275: new 15	java/lang/String
    //   278: dup
    //   279: new 92	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   286: aload_1
    //   287: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: getstatic 101	java/io/File:separator	Ljava/lang/String;
    //   293: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 6
    //   298: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   301: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: ldc 29
    //   309: invokevirtual 27	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   312: ldc 23
    //   314: invokespecial 32	java/lang/String:<init>	([BLjava/lang/String;)V
    //   317: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: astore 6
    //   322: aload 6
    //   324: invokevirtual 65	java/io/File:exists	()Z
    //   327: ifne +30 -> 357
    //   330: aload 6
    //   332: invokevirtual 108	java/io/File:getParentFile	()Ljava/io/File;
    //   335: astore 7
    //   337: aload 7
    //   339: invokevirtual 65	java/io/File:exists	()Z
    //   342: ifne +9 -> 351
    //   345: aload 7
    //   347: invokevirtual 111	java/io/File:mkdirs	()Z
    //   350: pop
    //   351: aload 6
    //   353: invokevirtual 114	java/io/File:createNewFile	()Z
    //   356: pop
    //   357: new 116	java/io/FileOutputStream
    //   360: dup
    //   361: aload 6
    //   363: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   366: astore 6
    //   368: sipush 4096
    //   371: newarray byte
    //   373: astore 7
    //   375: aload 5
    //   377: aload 7
    //   379: invokevirtual 123	java/io/InputStream:read	([B)I
    //   382: istore_2
    //   383: iload_2
    //   384: ifle +25 -> 409
    //   387: aload 6
    //   389: aload 7
    //   391: iconst_0
    //   392: iload_2
    //   393: invokevirtual 129	java/io/OutputStream:write	([BII)V
    //   396: goto -21 -> 375
    //   399: astore_1
    //   400: aload_1
    //   401: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   404: iconst_1
    //   405: istore_2
    //   406: goto -197 -> 209
    //   409: aload 5
    //   411: invokevirtual 132	java/io/InputStream:close	()V
    //   414: aload 6
    //   416: invokevirtual 133	java/io/OutputStream:close	()V
    //   419: goto -326 -> 93
    //   422: astore_1
    //   423: aload_1
    //   424: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   427: iconst_1
    //   428: istore_2
    //   429: goto -220 -> 209
    //   432: iconst_0
    //   433: istore_2
    //   434: goto -225 -> 209
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   442: iconst_1
    //   443: istore_2
    //   444: goto -231 -> 213
    //   447: iconst_0
    //   448: istore_3
    //   449: goto -230 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	paramString1	String
    //   0	452	1	paramString2	String
    //   208	236	2	i	int
    //   1	448	3	bool	boolean
    //   53	51	4	localObject1	Object
    //   149	261	5	localObject2	Object
    //   113	302	6	localObject3	Object
    //   335	55	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   87	93	202	java/io/FileNotFoundException
    //   93	199	202	java/io/FileNotFoundException
    //   263	351	202	java/io/FileNotFoundException
    //   351	357	202	java/io/FileNotFoundException
    //   357	375	202	java/io/FileNotFoundException
    //   375	383	202	java/io/FileNotFoundException
    //   387	396	202	java/io/FileNotFoundException
    //   409	419	202	java/io/FileNotFoundException
    //   78	87	221	java/util/zip/ZipException
    //   78	87	242	java/io/IOException
    //   87	93	399	java/io/IOException
    //   93	199	399	java/io/IOException
    //   263	351	399	java/io/IOException
    //   351	357	399	java/io/IOException
    //   357	375	399	java/io/IOException
    //   375	383	399	java/io/IOException
    //   387	396	399	java/io/IOException
    //   409	419	399	java/io/IOException
    //   87	93	422	java/lang/Exception
    //   93	199	422	java/lang/Exception
    //   263	351	422	java/lang/Exception
    //   351	357	422	java/lang/Exception
    //   357	375	422	java/lang/Exception
    //   375	383	422	java/lang/Exception
    //   387	396	422	java/lang/Exception
    //   409	419	422	java/lang/Exception
    //   209	213	437	java/io/IOException
  }
  
  public static String b(ZipEntry paramZipEntry)
  {
    if ((paramZipEntry.getName() == null) || (paramZipEntry.getName().contains("../"))) {
      return null;
    }
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.ZipUtils
 * JD-Core Version:    0.7.0.1
 */