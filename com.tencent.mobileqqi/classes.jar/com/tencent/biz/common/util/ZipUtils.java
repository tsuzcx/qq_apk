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
    while (paramFile.hasMoreElements()) {
      localArrayList.add(new String(b((ZipEntry)paramFile.nextElement()).getBytes("GB2312"), "8859_1"));
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
      if (((ZipEntry)localObject2).getName().contains(paramString2))
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
    paramFile.close();
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 140	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc 142
    //   10: iconst_4
    //   11: new 90	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   18: ldc 178
    //   20: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 179	java/lang/String:toString	()Ljava/lang/String;
    //   27: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 181
    //   32: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: new 59	java/io/File
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 4
    //   55: aload 4
    //   57: invokevirtual 65	java/io/File:exists	()Z
    //   60: ifne +9 -> 69
    //   63: aload 4
    //   65: invokevirtual 109	java/io/File:mkdirs	()Z
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
    //   100: ifeq +311 -> 411
    //   103: aload 4
    //   105: invokeinterface 49 1 0
    //   110: checkcast 17	java/util/zip/ZipEntry
    //   113: astore 6
    //   115: aload 6
    //   117: invokevirtual 135	java/util/zip/ZipEntry:isDirectory	()Z
    //   120: ifeq +122 -> 242
    //   123: aload 6
    //   125: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   128: astore 5
    //   130: new 59	java/io/File
    //   133: dup
    //   134: new 90	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   141: aload_1
    //   142: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: getstatic 99	java/io/File:separator	Ljava/lang/String;
    //   148: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 5
    //   153: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 5
    //   164: aload 5
    //   166: invokevirtual 65	java/io/File:exists	()Z
    //   169: ifne -76 -> 93
    //   172: aload 5
    //   174: invokevirtual 109	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: goto -85 -> 93
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 184	java/io/FileNotFoundException:printStackTrace	()V
    //   186: iconst_1
    //   187: istore_2
    //   188: aload_0
    //   189: invokevirtual 167	java/util/zip/ZipFile:close	()V
    //   192: iload_2
    //   193: ifne +233 -> 426
    //   196: iconst_1
    //   197: istore_3
    //   198: iload_3
    //   199: ireturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 185	java/util/zip/ZipException:printStackTrace	()V
    //   205: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -10 -> 198
    //   211: ldc 142
    //   213: iconst_2
    //   214: ldc 187
    //   216: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_0
    //   222: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +11 -> 236
    //   228: ldc 142
    //   230: iconst_2
    //   231: ldc 189
    //   233: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_0
    //   237: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: aload_0
    //   243: aload 6
    //   245: invokevirtual 88	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   248: astore 5
    //   250: new 59	java/io/File
    //   253: dup
    //   254: new 15	java/lang/String
    //   257: dup
    //   258: new 90	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   265: aload_1
    //   266: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: getstatic 99	java/io/File:separator	Ljava/lang/String;
    //   272: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 6
    //   277: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   280: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: ldc 29
    //   288: invokevirtual 27	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   291: ldc 23
    //   293: invokespecial 32	java/lang/String:<init>	([BLjava/lang/String;)V
    //   296: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   299: astore 6
    //   301: aload 6
    //   303: invokevirtual 65	java/io/File:exists	()Z
    //   306: ifne +30 -> 336
    //   309: aload 6
    //   311: invokevirtual 106	java/io/File:getParentFile	()Ljava/io/File;
    //   314: astore 7
    //   316: aload 7
    //   318: invokevirtual 65	java/io/File:exists	()Z
    //   321: ifne +9 -> 330
    //   324: aload 7
    //   326: invokevirtual 109	java/io/File:mkdirs	()Z
    //   329: pop
    //   330: aload 6
    //   332: invokevirtual 112	java/io/File:createNewFile	()Z
    //   335: pop
    //   336: new 114	java/io/FileOutputStream
    //   339: dup
    //   340: aload 6
    //   342: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   345: astore 6
    //   347: sipush 4096
    //   350: newarray byte
    //   352: astore 7
    //   354: aload 5
    //   356: aload 7
    //   358: invokevirtual 121	java/io/InputStream:read	([B)I
    //   361: istore_2
    //   362: iload_2
    //   363: ifle +25 -> 388
    //   366: aload 6
    //   368: aload 7
    //   370: iconst_0
    //   371: iload_2
    //   372: invokevirtual 127	java/io/OutputStream:write	([BII)V
    //   375: goto -21 -> 354
    //   378: astore_1
    //   379: aload_1
    //   380: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   383: iconst_1
    //   384: istore_2
    //   385: goto -197 -> 188
    //   388: aload 5
    //   390: invokevirtual 130	java/io/InputStream:close	()V
    //   393: aload 6
    //   395: invokevirtual 131	java/io/OutputStream:close	()V
    //   398: goto -305 -> 93
    //   401: astore_1
    //   402: aload_1
    //   403: invokevirtual 191	java/lang/Exception:printStackTrace	()V
    //   406: iconst_1
    //   407: istore_2
    //   408: goto -220 -> 188
    //   411: iconst_0
    //   412: istore_2
    //   413: goto -225 -> 188
    //   416: astore_0
    //   417: aload_0
    //   418: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   421: iconst_1
    //   422: istore_2
    //   423: goto -231 -> 192
    //   426: iconst_0
    //   427: istore_3
    //   428: goto -230 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramString1	String
    //   0	431	1	paramString2	String
    //   187	236	2	i	int
    //   1	427	3	bool	boolean
    //   53	51	4	localObject1	Object
    //   128	261	5	localObject2	Object
    //   113	281	6	localObject3	Object
    //   314	55	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   87	93	181	java/io/FileNotFoundException
    //   93	178	181	java/io/FileNotFoundException
    //   242	330	181	java/io/FileNotFoundException
    //   330	336	181	java/io/FileNotFoundException
    //   336	354	181	java/io/FileNotFoundException
    //   354	362	181	java/io/FileNotFoundException
    //   366	375	181	java/io/FileNotFoundException
    //   388	398	181	java/io/FileNotFoundException
    //   78	87	200	java/util/zip/ZipException
    //   78	87	221	java/io/IOException
    //   87	93	378	java/io/IOException
    //   93	178	378	java/io/IOException
    //   242	330	378	java/io/IOException
    //   330	336	378	java/io/IOException
    //   336	354	378	java/io/IOException
    //   354	362	378	java/io/IOException
    //   366	375	378	java/io/IOException
    //   388	398	378	java/io/IOException
    //   87	93	401	java/lang/Exception
    //   93	178	401	java/lang/Exception
    //   242	330	401	java/lang/Exception
    //   330	336	401	java/lang/Exception
    //   336	354	401	java/lang/Exception
    //   354	362	401	java/lang/Exception
    //   366	375	401	java/lang/Exception
    //   388	398	401	java/lang/Exception
    //   188	192	416	java/io/IOException
  }
  
  public static String b(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.ZipUtils
 * JD-Core Version:    0.7.0.1
 */