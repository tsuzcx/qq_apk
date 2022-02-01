package moai.patch.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import moai.patch.util.PatchUtil;

public abstract interface Log
{
  public abstract void log(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3);
  
  public static class FileLogPrinter
  {
    static String TAG = "FileLogPrinter";
    private File logFolder;
    private BufferedWriter mBufferedWriter;
    private final BlockingDeque<String> queue = new LinkedBlockingDeque(1024);
    private boolean writerReady = false;
    
    public FileLogPrinter(File paramFile, String paramString)
    {
      this.logFolder = paramFile;
      if (paramFile.exists())
      {
        if (!paramFile.isDirectory()) {
          throw new IllegalArgumentException("logFolder is not directory");
        }
      }
      else {
        paramFile.mkdirs();
      }
      printTo(paramString);
    }
    
    public static String formatLog(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
    {
      return PatchUtil.now() + ",logId:" + paramInt1 + ", process:" + paramString2 + ",pid:" + paramInt3 + ",cost:" + paramLong + ",log:" + paramString1;
    }
    
    private void openLogWriter(String paramString)
    {
      if (this.writerReady) {
        return;
      }
      paramString = new File(this.logFolder, paramString);
      try
      {
        if (!paramString.exists()) {
          paramString.createNewFile();
        }
        this.mBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramString, true)));
        this.writerReady = true;
        return;
      }
      catch (Exception paramString) {}
    }
    
    private void printTo(String paramString)
    {
      openLogWriter(paramString);
      new Thread(new Log.FileLogPrinter.1(this)).start();
    }
    
    void log(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
    {
      this.queue.add(formatLog(paramInt1, paramInt2, paramString1, paramLong, paramString2, paramInt3));
    }
  }
  
  public static class LogPrinter
    implements Log
  {
    private Log.FileLogPrinter localPrinter;
    
    public LogPrinter(File paramFile)
    {
      this.localPrinter = new Log.FileLogPrinter(paramFile, "moai.patch.log");
    }
    
    public void log(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
    {
      this.localPrinter.log(paramInt2, paramInt1, paramString1, paramLong, paramString2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.Log
 * JD-Core Version:    0.7.0.1
 */