package mqq.os;

import android.util.Log;

class MqqMessageQueue$2
  extends Thread
{
  MqqMessageQueue$2(MqqMessageQueue paramMqqMessageQueue, Throwable paramThrowable) {}
  
  public void run()
  {
    throw new RuntimeException("queueIdle encounter business crash. " + Log.getStackTraceString(this.val$e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.os.MqqMessageQueue.2
 * JD-Core Version:    0.7.0.1
 */