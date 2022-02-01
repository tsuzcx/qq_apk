package moai.log;

import java.util.ArrayList;

public class AutoFlushFileHandler
  extends FileHandlerDelegate
{
  private final Strategy strategy;
  
  public AutoFlushFileHandler(FileHandler paramFileHandler, Strategy paramStrategy)
  {
    super(paramFileHandler);
    if (paramStrategy == null) {
      throw new IllegalArgumentException("strategy null");
    }
    this.strategy = paramStrategy;
    paramStrategy.add(paramFileHandler);
  }
  
  protected int onPrepareToWrite(FileHandler.LogData paramLogData)
  {
    int i = paramLogData.sizeEstimated();
    this.strategy.flush(i);
    return super.onPrepareToWrite(paramLogData);
  }
  
  public static class DefaultStrategy
    implements AutoFlushFileHandler.Strategy
  {
    private FileHandler[] cacheFileHandler = new FileHandler[0];
    private final ArrayList<FileHandler> fileHandlerList = new ArrayList();
    private boolean hasSize = false;
    private boolean isAlive = true;
    private final Object lock = new Object();
    private final long maxTimeInterval;
    private final Runnable runnable = new AutoFlushFileHandler.DefaultStrategy.1(this);
    
    public DefaultStrategy()
    {
      this(1000);
    }
    
    public DefaultStrategy(int paramInt)
    {
      this.maxTimeInterval = paramInt;
      new Thread(this.runnable, "autoflush").start();
    }
    
    public void add(FileHandler paramFileHandler)
    {
      synchronized (this.lock)
      {
        if (!this.fileHandlerList.contains(paramFileHandler))
        {
          this.fileHandlerList.add(paramFileHandler);
          this.cacheFileHandler = ((FileHandler[])this.fileHandlerList.toArray(new FileHandler[0]));
        }
        return;
      }
    }
    
    public void flush(long paramLong)
    {
      for (;;)
      {
        synchronized (this.lock)
        {
          if (!this.hasSize)
          {
            if (paramLong <= 0L) {
              break label54;
            }
            break label49;
            this.hasSize = bool;
            this.lock.notifyAll();
            return;
          }
        }
        label49:
        boolean bool = true;
        continue;
        label54:
        bool = false;
      }
    }
  }
  
  public static abstract interface Strategy
  {
    public abstract void add(FileHandler paramFileHandler);
    
    public abstract void flush(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.AutoFlushFileHandler
 * JD-Core Version:    0.7.0.1
 */