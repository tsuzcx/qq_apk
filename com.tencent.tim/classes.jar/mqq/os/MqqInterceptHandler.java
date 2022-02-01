package mqq.os;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;

public class MqqInterceptHandler
  extends Handler
  implements IMqqMessageCallback
{
  Handler mParentHandler = null;
  MqqMessageQueue mSubUIQueue;
  
  private MqqInterceptHandler(Handler paramHandler)
  {
    super(Looper.getMainLooper());
    this.mParentHandler = paramHandler;
    this.mSubUIQueue = MqqMessageQueue.getSubMainThreadQueue();
  }
  
  public static Handler createMqqHandler(Handler paramHandler)
  {
    if ((paramHandler.getLooper() != Looper.getMainLooper()) || ((paramHandler instanceof MqqInterceptHandler))) {}
    for (;;)
    {
      return null;
      try
      {
        MessageQueue localMessageQueue = Looper.getMainLooper().getQueue();
        if (localMessageQueue != null) {
          return new MqqInterceptHandler(paramHandler);
        }
      }
      catch (Throwable paramHandler) {}
    }
    return null;
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    this.mParentHandler.dispatchMessage(paramMessage);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    MqqMessage localMqqMessage = MqqMessage.obtain(paramMessage);
    localMqqMessage.target = this;
    boolean bool2 = this.mSubUIQueue.enqueueMessage(localMqqMessage, paramLong);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = this.mParentHandler.sendMessageAtTime(paramMessage, paramLong);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.os.MqqInterceptHandler
 * JD-Core Version:    0.7.0.1
 */