package com.tencent.base.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils
{
  public static final int CPY_BUFFER_SIZE = 4096;
  public static final int ZIP_BUFFER_SIZE = 4096;
  public static final String ZIP_FILE_EXT = ".zip";
  
  public static void doZip(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = 0;
    if ((paramZipOutputStream == null) || (paramFile == null)) {
      throw new IOException("I/O Object got NullPointerException");
    }
    if (!paramFile.exists()) {
      throw new FileNotFoundException("Target File is missing");
    }
    localObject = null;
    if (StrUtils.isTextEmpty(paramString))
    {
      paramString = paramFile.getName();
      if (!paramFile.isFile()) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          paramFile = new BufferedInputStream(new FileInputStream(paramFile));
          try
          {
            paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
            for (;;)
            {
              i = paramFile.read(paramArrayOfByte, 0, paramArrayOfByte.length);
              if (-1 == i)
              {
                DataUtils.closeDataObject(paramFile);
                return;
                paramString = paramString + File.separator + paramFile.getName();
                break;
              }
              paramZipOutputStream.write(paramArrayOfByte, 0, i);
            }
            DataUtils.closeDataObject(paramZipOutputStream);
          }
          catch (IOException paramString)
          {
            paramZipOutputStream = paramFile;
            paramFile = paramString;
          }
        }
      }
      catch (IOException paramFile)
      {
        label164:
        int j;
        paramZipOutputStream = localObject;
        continue;
      }
      throw paramFile;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        j = paramFile.length;
        if (i < j)
        {
          doZip(paramZipOutputStream, paramFile[i], paramString, paramArrayOfByte);
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static boolean unzip(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +19 -> 20
    //   4: aload_0
    //   5: invokevirtual 118	java/io/File:length	()J
    //   8: lconst_1
    //   9: lcmp
    //   10: iflt +10 -> 20
    //   13: aload_0
    //   14: invokevirtual 121	java/io/File:canRead	()Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_1
    //   23: invokevirtual 32	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 124	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: aconst_null
    //   35: astore 5
    //   37: aconst_null
    //   38: astore_3
    //   39: aconst_null
    //   40: astore 4
    //   42: aconst_null
    //   43: astore 6
    //   45: sipush 8192
    //   48: newarray byte
    //   50: astore 7
    //   52: new 126	java/util/zip/ZipInputStream
    //   55: dup
    //   56: new 54	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 127	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_3
    //   70: aload_0
    //   71: invokevirtual 131	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   74: astore 4
    //   76: aload 4
    //   78: ifnonnull +23 -> 101
    //   81: aload_0
    //   82: invokevirtual 134	java/util/zip/ZipInputStream:closeEntry	()V
    //   85: aload_0
    //   86: invokevirtual 137	java/util/zip/ZipInputStream:close	()V
    //   89: aload_3
    //   90: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_0
    //   95: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   98: pop
    //   99: iconst_1
    //   100: ireturn
    //   101: getstatic 143	java/lang/System:out	Ljava/io/PrintStream;
    //   104: aload 4
    //   106: invokevirtual 144	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   109: invokevirtual 149	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   112: aload 4
    //   114: invokevirtual 150	java/util/zip/ZipEntry:isDirectory	()Z
    //   117: ifeq +40 -> 157
    //   120: new 28	java/io/File
    //   123: dup
    //   124: aload_1
    //   125: aload 4
    //   127: invokevirtual 144	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   130: invokespecial 153	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   133: invokevirtual 124	java/io/File:mkdirs	()Z
    //   136: pop
    //   137: goto -67 -> 70
    //   140: astore_1
    //   141: aload_3
    //   142: astore 4
    //   144: aload 4
    //   146: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload_0
    //   151: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: iconst_0
    //   156: ireturn
    //   157: new 28	java/io/File
    //   160: dup
    //   161: aload_1
    //   162: aload 4
    //   164: invokevirtual 144	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   167: invokespecial 153	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   170: astore 4
    //   172: aload 4
    //   174: invokevirtual 157	java/io/File:getParentFile	()Ljava/io/File;
    //   177: invokevirtual 124	java/io/File:mkdirs	()Z
    //   180: pop
    //   181: new 159	java/io/BufferedOutputStream
    //   184: dup
    //   185: new 161	java/io/FileOutputStream
    //   188: dup
    //   189: aload 4
    //   191: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   194: invokespecial 165	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   197: astore 4
    //   199: aload_0
    //   200: aload 7
    //   202: iconst_0
    //   203: aload 7
    //   205: arraylength
    //   206: invokevirtual 166	java/util/zip/ZipInputStream:read	([BII)I
    //   209: istore_2
    //   210: iconst_m1
    //   211: iload_2
    //   212: if_icmpne +19 -> 231
    //   215: aload 4
    //   217: invokevirtual 169	java/io/BufferedOutputStream:flush	()V
    //   220: aload 4
    //   222: invokevirtual 170	java/io/BufferedOutputStream:close	()V
    //   225: aload 4
    //   227: astore_3
    //   228: goto -158 -> 70
    //   231: aload 4
    //   233: aload 7
    //   235: iconst_0
    //   236: iload_2
    //   237: invokevirtual 171	java/io/BufferedOutputStream:write	([BII)V
    //   240: goto -41 -> 199
    //   243: astore_1
    //   244: goto -100 -> 144
    //   247: astore_1
    //   248: aload 5
    //   250: astore_0
    //   251: aload 4
    //   253: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   256: pop
    //   257: aload_0
    //   258: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: aload_1
    //   263: athrow
    //   264: astore_1
    //   265: aload_3
    //   266: astore 4
    //   268: goto -17 -> 251
    //   271: astore_1
    //   272: goto -21 -> 251
    //   275: astore_0
    //   276: aload 6
    //   278: astore 4
    //   280: aload_3
    //   281: astore_0
    //   282: goto -138 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramFile1	File
    //   0	285	1	paramFile2	File
    //   209	28	2	i	int
    //   38	243	3	localObject1	Object
    //   40	239	4	localObject2	Object
    //   35	214	5	localObject3	Object
    //   43	234	6	localObject4	Object
    //   50	184	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   70	76	140	java/io/IOException
    //   81	89	140	java/io/IOException
    //   101	137	140	java/io/IOException
    //   157	199	140	java/io/IOException
    //   199	210	243	java/io/IOException
    //   215	225	243	java/io/IOException
    //   231	240	243	java/io/IOException
    //   52	68	247	finally
    //   70	76	264	finally
    //   81	89	264	finally
    //   101	137	264	finally
    //   157	199	264	finally
    //   199	210	271	finally
    //   215	225	271	finally
    //   231	240	271	finally
    //   52	68	275	java/io/IOException
  }
  
  /* Error */
  public static boolean zip(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +13 -> 16
    //   6: aload_0
    //   7: arraylength
    //   8: iconst_1
    //   9: if_icmplt +7 -> 16
    //   12: aload_1
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore 5
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore 6
    //   31: new 65	java/util/zip/ZipOutputStream
    //   34: dup
    //   35: new 159	java/io/BufferedOutputStream
    //   38: dup
    //   39: new 161	java/io/FileOutputStream
    //   42: dup
    //   43: aload_1
    //   44: iconst_0
    //   45: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   48: invokespecial 165	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: invokespecial 177	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_1
    //   55: aload_0
    //   56: arraylength
    //   57: istore_3
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmplt +18 -> 78
    //   63: aload_1
    //   64: invokevirtual 178	java/util/zip/ZipOutputStream:flush	()V
    //   67: aload_1
    //   68: invokevirtual 179	java/util/zip/ZipOutputStream:closeEntry	()V
    //   71: aload_1
    //   72: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   75: pop
    //   76: iconst_1
    //   77: ireturn
    //   78: aload_1
    //   79: aload_0
    //   80: iload_2
    //   81: aaload
    //   82: aconst_null
    //   83: aload 6
    //   85: invokestatic 111	com/tencent/base/util/FileUtils:doZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   88: iload_2
    //   89: iconst_1
    //   90: iadd
    //   91: istore_2
    //   92: goto -34 -> 58
    //   95: astore_0
    //   96: aload 5
    //   98: astore_0
    //   99: aload_0
    //   100: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   103: pop
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: aload 4
    //   109: astore_0
    //   110: aload_0
    //   111: invokestatic 79	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_1
    //   116: athrow
    //   117: astore 4
    //   119: aload_1
    //   120: astore_0
    //   121: aload 4
    //   123: astore_1
    //   124: goto -14 -> 110
    //   127: astore_0
    //   128: aload_1
    //   129: astore_0
    //   130: goto -31 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramArrayOfFile	File[]
    //   0	133	1	paramFile	File
    //   1	91	2	i	int
    //   57	4	3	j	int
    //   19	89	4	localObject1	Object
    //   117	5	4	localObject2	Object
    //   22	75	5	localObject3	Object
    //   29	55	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	55	95	java/io/IOException
    //   24	55	106	finally
    //   55	58	117	finally
    //   63	71	117	finally
    //   78	88	117	finally
    //   55	58	127	java/io/IOException
    //   63	71	127	java/io/IOException
    //   78	88	127	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.base.util.FileUtils
 * JD-Core Version:    0.7.0.1
 */