package android.arch.lifecycle;

import android.support.annotation.MainThread;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class ComputableLiveData$3
  implements Runnable
{
  ComputableLiveData$3(ComputableLiveData paramComputableLiveData) {}
  
  @MainThread
  public void run()
  {
    boolean bool = ComputableLiveData.access$300(this.this$0).hasActiveObservers();
    if ((ComputableLiveData.access$200(this.this$0).compareAndSet(false, true)) && (bool)) {
      ComputableLiveData.access$000(this.this$0).execute(this.this$0.mRefreshRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.arch.lifecycle.ComputableLiveData.3
 * JD-Core Version:    0.7.0.1
 */