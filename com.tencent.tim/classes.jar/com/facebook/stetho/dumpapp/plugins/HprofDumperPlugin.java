package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Debug;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class HprofDumperPlugin
  implements DumperPlugin
{
  private static final String NAME = "hprof";
  private final Context mContext;
  
  public HprofDumperPlugin(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  /* Error */
  private void handlePipeOutput(java.io.OutputStream paramOutputStream)
    throws DumpException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/facebook/stetho/dumpapp/plugins/HprofDumperPlugin:mContext	Landroid/content/Context;
    //   4: ldc 28
    //   6: invokevirtual 34	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   9: astore_2
    //   10: aload_0
    //   11: aload_2
    //   12: invokespecial 38	com/facebook/stetho/dumpapp/plugins/HprofDumperPlugin:writeHprof	(Ljava/io/File;)V
    //   15: new 40	java/io/FileInputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_3
    //   24: aload_3
    //   25: aload_1
    //   26: sipush 2048
    //   29: newarray byte
    //   31: invokestatic 48	com/facebook/stetho/common/Util:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
    //   34: aload_3
    //   35: invokevirtual 53	java/io/InputStream:close	()V
    //   38: aload_2
    //   39: invokevirtual 59	java/io/File:exists	()Z
    //   42: ifeq +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 62	java/io/File:delete	()Z
    //   49: pop
    //   50: return
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 53	java/io/InputStream:close	()V
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: new 24	com/facebook/stetho/dumpapp/DumpException
    //   62: dup
    //   63: new 64	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   70: ldc 67
    //   72: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_2
    //   76: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: ldc 76
    //   81: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 83	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   90: athrow
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 59	java/io/File:exists	()Z
    //   96: ifeq +8 -> 104
    //   99: aload_2
    //   100: invokevirtual 62	java/io/File:delete	()Z
    //   103: pop
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	HprofDumperPlugin
    //   0	106	1	paramOutputStream	java.io.OutputStream
    //   9	91	2	localFile	File
    //   23	30	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   24	34	51	finally
    //   15	24	58	java/io/IOException
    //   34	38	58	java/io/IOException
    //   52	58	58	java/io/IOException
    //   10	15	91	finally
    //   15	24	91	finally
    //   34	38	91	finally
    //   52	58	91	finally
    //   59	91	91	finally
  }
  
  private static void truncateAndDeleteFile(File paramFile)
    throws IOException
  {
    new FileOutputStream(paramFile).close();
    if (!paramFile.delete()) {
      throw new IOException("Failed to delete " + paramFile);
    }
  }
  
  private void usage(PrintStream paramPrintStream)
    throws DumpUsageException
  {
    paramPrintStream.println("Usage: dumpapp hprof [ path ]");
    paramPrintStream.println("Dump HPROF memory usage data from the running application.");
    paramPrintStream.println();
    paramPrintStream.println("Where path can be any of:");
    paramPrintStream.println("  -           Output directly to stdout");
    paramPrintStream.println("  <path>      Full path to a writable file on the device");
    paramPrintStream.println("  <filename>  Relative filename that will be stored in the app internal storage");
    throw new DumpUsageException("Missing path");
  }
  
  private void writeHprof(File paramFile)
    throws DumpException
  {
    try
    {
      truncateAndDeleteFile(paramFile);
      Debug.dumpHprofData(paramFile.getAbsolutePath());
      return;
    }
    catch (IOException localIOException)
    {
      throw new DumpException("Failure writing to " + paramFile + ": " + localIOException.getMessage());
    }
  }
  
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    PrintStream localPrintStream = paramDumperContext.getStdout();
    paramDumperContext = paramDumperContext.getArgsAsList().iterator();
    if (paramDumperContext.hasNext()) {}
    for (paramDumperContext = (String)paramDumperContext.next(); paramDumperContext == null; paramDumperContext = null)
    {
      usage(localPrintStream);
      return;
    }
    if ("-".equals(paramDumperContext))
    {
      handlePipeOutput(localPrintStream);
      return;
    }
    File localFile2 = new File(paramDumperContext);
    File localFile1 = localFile2;
    if (!localFile2.isAbsolute()) {
      localFile1 = this.mContext.getFileStreamPath(paramDumperContext);
    }
    writeHprof(localFile1);
    localPrintStream.println("Wrote to " + localFile1);
  }
  
  public String getName()
  {
    return "hprof";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin
 * JD-Core Version:    0.7.0.1
 */