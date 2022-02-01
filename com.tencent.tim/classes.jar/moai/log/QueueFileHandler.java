package moai.log;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueFileHandler
  extends FileHandlerDelegate
{
  private static final String TAG = QueueFileHandler.class.getSimpleName();
  private final LinkedBlockingQueue<FileHandler.LogData> queue = new LinkedBlockingQueue();
  
  public QueueFileHandler(FileHandler paramFileHandler)
  {
    super(paramFileHandler);
  }
  
  public void onFlush()
  {
    super.onFlush();
    while (this.queue.size() > 0)
    {
      FileHandler.LogData localLogData = (FileHandler.LogData)this.queue.poll();
      if (localLogData != null) {
        super.writeToFile(localLogData);
      }
    }
  }
  
  protected int onPrepareToWrite(FileHandler.LogData paramLogData)
  {
    this.queue.add(FileHandler.LogData.obtain(paramLogData));
    if ((BuildConfig.DEBUG) && (this.queue.size() > 1024)) {
      throw new IllegalStateException("queue overflow: " + this.queue.size());
    }
    int j = super.onPrepareToWrite(paramLogData);
    int i = j;
    if (j <= 0) {
      i = paramLogData.sizeEstimated();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.QueueFileHandler
 * JD-Core Version:    0.7.0.1
 */