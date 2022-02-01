package androidx.core.provider;

import android.os.Handler;
import java.util.concurrent.Callable;

class SelfDestructiveThread$2
  implements Runnable
{
  SelfDestructiveThread$2(SelfDestructiveThread paramSelfDestructiveThread, Callable paramCallable, Handler paramHandler, SelfDestructiveThread.ReplyCallback paramReplyCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.val$callable.call();
      this.val$callingHandler.post(new SelfDestructiveThread.2.1(this, localObject1));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.provider.SelfDestructiveThread.2
 * JD-Core Version:    0.7.0.1
 */