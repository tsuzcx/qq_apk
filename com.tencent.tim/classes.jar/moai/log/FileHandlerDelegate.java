package moai.log;

import java.util.GregorianCalendar;
import java.util.List;

public abstract class FileHandlerDelegate
  extends FileHandler
{
  protected final FileHandler mDelegate;
  
  public FileHandlerDelegate(FileHandler paramFileHandler)
  {
    if (paramFileHandler == null) {
      throw new IllegalArgumentException("no null");
    }
    this.mDelegate = paramFileHandler;
    this.mDelegate.setWriteToFileDelegrate(this);
  }
  
  protected final void appendDebugLog(String paramString)
  {
    this.mDelegate.appendDebugLog(paramString);
  }
  
  protected final void close()
  {
    this.mDelegate.close();
  }
  
  protected boolean filterContent(FileOperation.Config paramConfig, String paramString)
  {
    return this.mDelegate.filterContent(paramConfig, paramString);
  }
  
  public final void flush()
  {
    this.mDelegate.flush();
  }
  
  public final String getAndClearDebugLog()
  {
    return this.mDelegate.getAndClearDebugLog();
  }
  
  public final int getAndClearFailedForceOrCloseFileCount()
  {
    return this.mDelegate.getAndClearFailedForceOrCloseFileCount();
  }
  
  public final int getAndClearFailedOpenFileCount()
  {
    return this.mDelegate.getAndClearFailedOpenFileCount();
  }
  
  public final int getAndClearFailedWriteFileCount()
  {
    return this.mDelegate.getAndClearFailedWriteFileCount();
  }
  
  public final String getDirname()
  {
    return this.mDelegate.getDirname();
  }
  
  public final String getFilename()
  {
    return this.mDelegate.getFilename();
  }
  
  public int getLevel()
  {
    return this.mDelegate.getLevel();
  }
  
  public List<String> list(GregorianCalendar paramGregorianCalendar1, GregorianCalendar paramGregorianCalendar2)
  {
    return this.mDelegate.list(paramGregorianCalendar1, paramGregorianCalendar2);
  }
  
  protected int onPrepareToWrite(FileHandler.LogData paramLogData)
  {
    if (this.writeToFileDelegrate != null)
    {
      int i = this.writeToFileDelegrate.onPrepareToWrite(paramLogData);
      if (i > 0) {
        return i;
      }
    }
    return 0;
  }
  
  protected boolean onWriteToBuf(FileHandler.LogData paramLogData, ByteBufferWrapper paramByteBufferWrapper)
  {
    return (this.writeToFileDelegrate != null) && (this.writeToFileDelegrate.onWriteToBuf(paramLogData, paramByteBufferWrapper));
  }
  
  public final int publish(int paramInt, String paramString1, String paramString2)
  {
    return this.mDelegate.publish(paramInt, paramString1, paramString2);
  }
  
  public final int publish(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    return this.mDelegate.publish(paramInt, paramString1, paramString2, paramThrowable);
  }
  
  public void setLevel(int paramInt)
  {
    this.mDelegate.setLevel(paramInt);
  }
  
  protected final int writeToFile(FileHandler.LogData paramLogData)
  {
    return this.mDelegate.writeToFile(paramLogData);
  }
  
  public void zip(FileOperation.Config paramConfig, String paramString)
  {
    this.mDelegate.zip(paramConfig, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.FileHandlerDelegate
 * JD-Core Version:    0.7.0.1
 */