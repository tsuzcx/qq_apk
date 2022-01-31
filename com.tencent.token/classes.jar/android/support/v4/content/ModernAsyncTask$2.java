package android.support.v4.content;

import android.os.Binder;
import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class ModernAsyncTask$2
  extends ModernAsyncTask.WorkerRunnable
{
  ModernAsyncTask$2(ModernAsyncTask paramModernAsyncTask) {}
  
  public Object call()
  {
    ModernAsyncTask.access$000(this.this$0).set(true);
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject1 = localObject5;
    try
    {
      Process.setThreadPriority(10);
      localObject2 = localObject4;
      localObject1 = localObject5;
      localObject4 = this.this$0.doInBackground(this.mParams);
      localObject2 = localObject4;
      localObject1 = localObject4;
      Binder.flushPendingCommands();
      return localObject4;
    }
    catch (Throwable localThrowable)
    {
      localObject1 = localObject2;
      ModernAsyncTask.access$100(this.this$0).set(true);
      localObject1 = localObject2;
      throw localThrowable;
    }
    finally
    {
      this.this$0.postResult(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.2
 * JD-Core Version:    0.7.0.1
 */