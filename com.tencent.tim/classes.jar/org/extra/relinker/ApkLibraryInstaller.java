package org.extra.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ApkLibraryInstaller
  implements ReLinker.LibraryInstaller
{
  private static final int COPY_BUFFER_SIZE = 4096;
  private static final int MAX_TRIES = 5;
  
  private void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    long l = 0L;
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
      {
        paramOutputStream.flush();
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
  }
  
  private ZipFileInZipEntry findAPKWithLibrary(Context paramContext, String[] paramArrayOfString, String paramString, ReLinkerInstance paramReLinkerInstance)
  {
    String[] arrayOfString = sourceDirectories(paramContext);
    int m = arrayOfString.length;
    int i = 0;
    paramContext = null;
    String str;
    int j;
    if (i < m)
    {
      str = arrayOfString[i];
      j = 0;
      label34:
      if (j >= 5) {
        break label230;
      }
    }
    label86:
    label230:
    for (;;)
    {
      try
      {
        ZipFile localZipFile = new ZipFile(new File(str), 1);
        paramContext = localZipFile;
        if (paramContext != null) {
          break label86;
        }
        i += 1;
      }
      catch (IOException localIOException1)
      {
        j += 1;
      }
      break label34;
      j = 0;
      while (j < 5)
      {
        int n = paramArrayOfString.length;
        int k = 0;
        while (k < n)
        {
          Object localObject = paramArrayOfString[k];
          localObject = "lib" + File.separatorChar + (String)localObject + File.separatorChar + paramString;
          paramReLinkerInstance.log("Looking for %s in APK %s...", new Object[] { localObject, str });
          localObject = paramContext.getEntry((String)localObject);
          if (localObject != null) {
            return new ZipFileInZipEntry(paramContext, (ZipEntry)localObject);
          }
          k += 1;
        }
        j += 1;
      }
      try
      {
        paramContext.close();
      }
      catch (IOException localIOException2) {}
      continue;
      return null;
    }
  }
  
  private String[] sourceDirectories(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.splitSourceDirs != null) && (paramContext.splitSourceDirs.length != 0))
    {
      String[] arrayOfString = new String[paramContext.splitSourceDirs.length + 1];
      arrayOfString[0] = paramContext.sourceDir;
      System.arraycopy(paramContext.splitSourceDirs, 0, arrayOfString, 1, paramContext.splitSourceDirs.length);
      return arrayOfString;
    }
    return new String[] { paramContext.sourceDir };
  }
  
  /* Error */
  public void installLibrary(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile, ReLinkerInstance paramReLinkerInstance)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: aload 5
    //   9: invokespecial 133	org/extra/relinker/ApkLibraryInstaller:findAPKWithLibrary	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Lorg/extra/relinker/ReLinkerInstance;)Lorg/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry;
    //   12: astore 13
    //   14: aload 13
    //   16: ifnonnull +36 -> 52
    //   19: new 135	org/extra/relinker/MissingLibraryException
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 136	org/extra/relinker/MissingLibraryException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: astore_1
    //   29: aload 13
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +17 -> 50
    //   36: aload_2
    //   37: getfield 140	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   40: ifnull +10 -> 50
    //   43: aload_2
    //   44: getfield 140	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   47: invokevirtual 98	java/util/zip/ZipFile:close	()V
    //   50: aload_1
    //   51: athrow
    //   52: iconst_0
    //   53: istore 6
    //   55: iload 6
    //   57: iconst_1
    //   58: iadd
    //   59: istore 7
    //   61: iload 6
    //   63: iconst_5
    //   64: if_icmpge +236 -> 300
    //   67: aload 5
    //   69: ldc 142
    //   71: iconst_1
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_3
    //   78: aastore
    //   79: invokevirtual 90	org/extra/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload 4
    //   84: invokevirtual 146	java/io/File:exists	()Z
    //   87: ifne +30 -> 117
    //   90: aload 4
    //   92: invokevirtual 149	java/io/File:createNewFile	()Z
    //   95: istore 8
    //   97: iload 8
    //   99: ifne +18 -> 117
    //   102: iload 7
    //   104: istore 6
    //   106: goto -51 -> 55
    //   109: astore_1
    //   110: iload 7
    //   112: istore 6
    //   114: goto -59 -> 55
    //   117: aconst_null
    //   118: astore 14
    //   120: aconst_null
    //   121: astore 15
    //   123: aload 13
    //   125: getfield 140	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   128: aload 13
    //   130: getfield 153	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipEntry	Ljava/util/zip/ZipEntry;
    //   133: invokevirtual 157	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   136: astore_1
    //   137: new 159	java/io/FileOutputStream
    //   140: dup
    //   141: aload 4
    //   143: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   146: astore_2
    //   147: aload_0
    //   148: aload_1
    //   149: aload_2
    //   150: invokespecial 164	org/extra/relinker/ApkLibraryInstaller:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   153: lstore 9
    //   155: aload_2
    //   156: invokevirtual 168	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   159: invokevirtual 173	java/io/FileDescriptor:sync	()V
    //   162: aload 4
    //   164: invokevirtual 177	java/io/File:length	()J
    //   167: lstore 11
    //   169: lload 9
    //   171: lload 11
    //   173: lcmp
    //   174: ifeq +20 -> 194
    //   177: aload_0
    //   178: aload_1
    //   179: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   182: aload_0
    //   183: aload_2
    //   184: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   187: iload 7
    //   189: istore 6
    //   191: goto -136 -> 55
    //   194: aload_0
    //   195: aload_1
    //   196: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload_2
    //   201: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   204: aload 4
    //   206: iconst_1
    //   207: iconst_0
    //   208: invokevirtual 183	java/io/File:setReadable	(ZZ)Z
    //   211: pop
    //   212: aload 4
    //   214: iconst_1
    //   215: iconst_0
    //   216: invokevirtual 186	java/io/File:setExecutable	(ZZ)Z
    //   219: pop
    //   220: aload 4
    //   222: iconst_1
    //   223: invokevirtual 190	java/io/File:setWritable	(Z)Z
    //   226: pop
    //   227: aload 13
    //   229: ifnull +19 -> 248
    //   232: aload 13
    //   234: getfield 140	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   237: ifnull +11 -> 248
    //   240: aload 13
    //   242: getfield 140	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   245: invokevirtual 98	java/util/zip/ZipFile:close	()V
    //   248: return
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_2
    //   254: aload_0
    //   255: aload_1
    //   256: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   259: aload_0
    //   260: aload_2
    //   261: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   264: iload 7
    //   266: istore 6
    //   268: goto -213 -> 55
    //   271: aload_0
    //   272: aload_1
    //   273: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   276: aload_0
    //   277: aload_2
    //   278: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   281: iload 7
    //   283: istore 6
    //   285: goto -230 -> 55
    //   288: aload_0
    //   289: aload_1
    //   290: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   293: aload_0
    //   294: aload_3
    //   295: invokespecial 179	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   298: aload_2
    //   299: athrow
    //   300: aload 5
    //   302: ldc 192
    //   304: invokevirtual 194	org/extra/relinker/ReLinkerInstance:log	(Ljava/lang/String;)V
    //   307: aload 13
    //   309: ifnull -61 -> 248
    //   312: aload 13
    //   314: getfield 140	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   317: ifnull -69 -> 248
    //   320: aload 13
    //   322: getfield 140	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   325: invokevirtual 98	java/util/zip/ZipFile:close	()V
    //   328: return
    //   329: astore_1
    //   330: return
    //   331: astore_2
    //   332: goto -282 -> 50
    //   335: astore_1
    //   336: aload 14
    //   338: astore_2
    //   339: goto -307 -> 32
    //   342: astore_1
    //   343: return
    //   344: astore_2
    //   345: aload 14
    //   347: astore_3
    //   348: goto -60 -> 288
    //   351: astore 4
    //   353: aload_2
    //   354: astore_3
    //   355: aload 4
    //   357: astore_2
    //   358: goto -70 -> 288
    //   361: astore_2
    //   362: aload 15
    //   364: astore_2
    //   365: goto -94 -> 271
    //   368: astore 14
    //   370: goto -99 -> 271
    //   373: astore_2
    //   374: aconst_null
    //   375: astore_2
    //   376: goto -122 -> 254
    //   379: astore 14
    //   381: goto -127 -> 254
    //   384: astore_1
    //   385: aconst_null
    //   386: astore_1
    //   387: aload 15
    //   389: astore_2
    //   390: goto -119 -> 271
    //   393: astore_2
    //   394: aconst_null
    //   395: astore_1
    //   396: aload 14
    //   398: astore_3
    //   399: goto -111 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	ApkLibraryInstaller
    //   0	402	1	paramContext	Context
    //   0	402	2	paramArrayOfString	String[]
    //   0	402	3	paramString	String
    //   0	402	4	paramFile	File
    //   0	402	5	paramReLinkerInstance	ReLinkerInstance
    //   53	231	6	i	int
    //   59	223	7	j	int
    //   95	3	8	bool	boolean
    //   153	17	9	l1	long
    //   167	5	11	l2	long
    //   12	309	13	localZipFileInZipEntry	ZipFileInZipEntry
    //   1	345	14	localObject1	Object
    //   368	1	14	localIOException	IOException
    //   379	18	14	localFileNotFoundException	java.io.FileNotFoundException
    //   121	267	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	28	28	finally
    //   67	82	28	finally
    //   82	97	28	finally
    //   177	187	28	finally
    //   194	227	28	finally
    //   254	264	28	finally
    //   271	281	28	finally
    //   288	300	28	finally
    //   300	307	28	finally
    //   82	97	109	java/io/IOException
    //   123	137	249	java/io/FileNotFoundException
    //   312	328	329	java/io/IOException
    //   36	50	331	java/io/IOException
    //   3	14	335	finally
    //   232	248	342	java/io/IOException
    //   137	147	344	finally
    //   147	169	351	finally
    //   137	147	361	java/io/IOException
    //   147	169	368	java/io/IOException
    //   137	147	373	java/io/FileNotFoundException
    //   147	169	379	java/io/FileNotFoundException
    //   123	137	384	java/io/IOException
    //   123	137	393	finally
  }
  
  static class ZipFileInZipEntry
  {
    public ZipEntry zipEntry;
    public ZipFile zipFile;
    
    public ZipFileInZipEntry(ZipFile paramZipFile, ZipEntry paramZipEntry)
    {
      this.zipFile = paramZipFile;
      this.zipEntry = paramZipEntry;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.extra.relinker.ApkLibraryInstaller
 * JD-Core Version:    0.7.0.1
 */