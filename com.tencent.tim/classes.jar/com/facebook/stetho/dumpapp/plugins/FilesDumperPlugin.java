package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Environment;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FilesDumperPlugin
  implements DumperPlugin
{
  private static final String NAME = "files";
  private final Context mContext;
  
  public FilesDumperPlugin(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void addFiles(ZipOutputStream paramZipOutputStream, byte[] paramArrayOfByte, File[] paramArrayOfFile)
    throws IOException
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfFile[i];
      if (((File)localObject).isDirectory()) {
        addFiles(paramZipOutputStream, paramArrayOfByte, ((File)localObject).listFiles());
      }
      for (;;)
      {
        i += 1;
        break;
        paramZipOutputStream.putNextEntry(new ZipEntry(relativizePath(getBaseDir(this.mContext).getParentFile(), (File)localObject)));
        localObject = new FileInputStream((File)localObject);
        try
        {
          copy((InputStream)localObject, paramZipOutputStream, paramArrayOfByte);
          ((FileInputStream)localObject).close();
        }
        finally
        {
          ((FileInputStream)localObject).close();
        }
      }
    }
  }
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i < 0) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
  
  /* Error */
  private void doDownload(PrintStream paramPrintStream, Iterator<String> paramIterator)
    throws DumpUsageException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 90
    //   3: invokestatic 96	com/facebook/stetho/dumpapp/ArgsHelper:nextArg	(Ljava/util/Iterator;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 4
    //   8: new 98	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 99	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_2
    //   17: invokeinterface 104 1 0
    //   22: ifeq +27 -> 49
    //   25: aload_3
    //   26: aload_0
    //   27: getfield 19	com/facebook/stetho/dumpapp/plugins/FilesDumperPlugin:mContext	Landroid/content/Context;
    //   30: aload_2
    //   31: invokeinterface 108 1 0
    //   36: checkcast 110	java/lang/String
    //   39: invokestatic 114	com/facebook/stetho/dumpapp/plugins/FilesDumperPlugin:resolvePossibleAppStoragePath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   42: invokevirtual 118	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   45: pop
    //   46: goto -30 -> 16
    //   49: ldc 120
    //   51: aload 4
    //   53: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +59 -> 115
    //   59: new 55	java/util/zip/ZipOutputStream
    //   62: dup
    //   63: new 125	java/io/BufferedOutputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 128	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: invokespecial 129	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_2
    //   75: sipush 2048
    //   78: newarray byte
    //   80: astore 4
    //   82: aload_3
    //   83: invokevirtual 133	java/util/ArrayList:size	()I
    //   86: ifle +55 -> 141
    //   89: aload_0
    //   90: aload_2
    //   91: aload 4
    //   93: aload_3
    //   94: aload_3
    //   95: invokevirtual 133	java/util/ArrayList:size	()I
    //   98: anewarray 26	java/io/File
    //   101: invokevirtual 137	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   104: checkcast 139	[Ljava/io/File;
    //   107: invokespecial 36	com/facebook/stetho/dumpapp/plugins/FilesDumperPlugin:addFiles	(Ljava/util/zip/ZipOutputStream;[B[Ljava/io/File;)V
    //   110: aload_2
    //   111: invokevirtual 140	java/util/zip/ZipOutputStream:close	()V
    //   114: return
    //   115: new 142	java/io/FileOutputStream
    //   118: dup
    //   119: aload 4
    //   121: invokestatic 146	com/facebook/stetho/dumpapp/plugins/FilesDumperPlugin:resolvePossibleSdcardPath	(Ljava/lang/String;)Ljava/io/File;
    //   124: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: astore_1
    //   128: goto -69 -> 59
    //   131: astore_1
    //   132: new 149	java/lang/RuntimeException
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 152	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   140: athrow
    //   141: aload_0
    //   142: aload_2
    //   143: aload 4
    //   145: aload_0
    //   146: getfield 19	com/facebook/stetho/dumpapp/plugins/FilesDumperPlugin:mContext	Landroid/content/Context;
    //   149: invokestatic 42	com/facebook/stetho/dumpapp/plugins/FilesDumperPlugin:getBaseDir	(Landroid/content/Context;)Ljava/io/File;
    //   152: invokevirtual 34	java/io/File:listFiles	()[Ljava/io/File;
    //   155: invokespecial 36	com/facebook/stetho/dumpapp/plugins/FilesDumperPlugin:addFiles	(Ljava/util/zip/ZipOutputStream;[B[Ljava/io/File;)V
    //   158: goto -48 -> 110
    //   161: astore_3
    //   162: aload_2
    //   163: invokevirtual 140	java/util/zip/ZipOutputStream:close	()V
    //   166: aload_3
    //   167: athrow
    //   168: astore_2
    //   169: aload_1
    //   170: iconst_0
    //   171: invokestatic 157	com/facebook/stetho/common/Util:close	(Ljava/io/Closeable;Z)V
    //   174: aload_2
    //   175: athrow
    //   176: astore_2
    //   177: aload_1
    //   178: iconst_1
    //   179: invokestatic 157	com/facebook/stetho/common/Util:close	(Ljava/io/Closeable;Z)V
    //   182: goto -16 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	FilesDumperPlugin
    //   0	185	1	paramPrintStream	PrintStream
    //   0	185	2	paramIterator	Iterator<String>
    //   15	80	3	localArrayList	java.util.ArrayList
    //   161	6	3	localObject1	Object
    //   6	138	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	59	131	java/io/IOException
    //   59	75	131	java/io/IOException
    //   115	128	131	java/io/IOException
    //   166	168	131	java/io/IOException
    //   169	176	131	java/io/IOException
    //   177	182	131	java/io/IOException
    //   75	110	161	finally
    //   141	158	161	finally
    //   110	114	168	java/io/IOException
    //   162	166	176	java/io/IOException
  }
  
  private void doLs(PrintStream paramPrintStream)
    throws DumpUsageException
  {
    File localFile = getBaseDir(this.mContext);
    if (localFile.isDirectory()) {
      printDirectoryText(localFile, "", paramPrintStream);
    }
  }
  
  private void doTree(PrintStream paramPrintStream)
    throws DumpUsageException
  {
    printDirectoryVisual(getBaseDir(this.mContext), 0, paramPrintStream);
  }
  
  private void doUsage(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Usage: dumpapp files " + "<command> [command-options]");
    paramPrintStream.println("       dumpapp files " + "ls");
    paramPrintStream.println("       dumpapp files " + "tree");
    paramPrintStream.println("       dumpapp files " + "download <output.zip> [<path>...]");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files ls: List files similar to the ls command");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files tree: List files similar to the tree command");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files download: Fetch internal application storage");
    paramPrintStream.println("    <output.zip>: Output location or '-' for stdout");
    paramPrintStream.println("    <path>: Fetch only those paths named (directories fetch recursively)");
  }
  
  private static File getBaseDir(Context paramContext)
  {
    return paramContext.getFilesDir().getParentFile();
  }
  
  private static void printDirectoryText(File paramFile, String paramString, PrintStream paramPrintStream)
  {
    paramFile = paramFile.listFiles();
    int i = 0;
    if (i < paramFile.length)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory()) {
        printDirectoryText(localFile, paramString + localFile.getName() + "/", paramPrintStream);
      }
      for (;;)
      {
        i += 1;
        break;
        paramPrintStream.println(paramString + localFile.getName());
      }
    }
  }
  
  private static void printDirectoryVisual(File paramFile, int paramInt, PrintStream paramPrintStream)
  {
    paramFile = paramFile.listFiles();
    int i = 0;
    while (i < paramFile.length)
    {
      printHeaderVisual(paramInt, paramPrintStream);
      File localFile = paramFile[i];
      paramPrintStream.print("+---");
      paramPrintStream.print(localFile.getName());
      paramPrintStream.println();
      if (localFile.isDirectory()) {
        printDirectoryVisual(localFile, paramInt + 1, paramPrintStream);
      }
      i += 1;
    }
  }
  
  private static void printHeaderVisual(int paramInt, PrintStream paramPrintStream)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramPrintStream.print("|   ");
      i += 1;
    }
  }
  
  private static String relativizePath(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getAbsolutePath();
    paramFile2 = paramFile2.getAbsolutePath();
    paramFile1 = paramFile2;
    if (paramFile2.startsWith(str)) {
      paramFile1 = paramFile2.substring(str.length() + 1);
    }
    return paramFile1;
  }
  
  private static File resolvePossibleAppStoragePath(Context paramContext, String paramString)
  {
    if (paramString.startsWith("/")) {
      return new File(paramString);
    }
    return new File(getBaseDir(paramContext), paramString);
  }
  
  private static File resolvePossibleSdcardPath(String paramString)
  {
    if (paramString.startsWith("/")) {
      return new File(paramString);
    }
    return new File(Environment.getExternalStorageDirectory(), paramString);
  }
  
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    Iterator localIterator = paramDumperContext.getArgsAsList().iterator();
    String str = ArgsHelper.nextOptionalArg(localIterator, "");
    if ("ls".equals(str)) {
      doLs(paramDumperContext.getStdout());
    }
    do
    {
      return;
      if ("tree".equals(str))
      {
        doTree(paramDumperContext.getStdout());
        return;
      }
      if ("download".equals(str))
      {
        doDownload(paramDumperContext.getStdout(), localIterator);
        return;
      }
      doUsage(paramDumperContext.getStdout());
    } while ("".equals(str));
    throw new DumpUsageException("Unknown command: " + str);
  }
  
  public String getName()
  {
    return "files";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin
 * JD-Core Version:    0.7.0.1
 */