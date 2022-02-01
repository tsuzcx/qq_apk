package androidx.lifecycle;

import androidx.annotation.MainThread;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class ComputableLiveData$3
  implements Runnable
{
  ComputableLiveData$3(ComputableLiveData paramComputableLiveData) {}
  
  @MainThread
  public void run()
  {
    boolean bool = this.this$0.mLiveData.hasActiveObservers();
    if ((this.this$0.mInvalid.compareAndSet(false, true)) && (bool)) {
      this.this$0.mExecutor.execute(this.this$0.mRefreshRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.ComputableLiveData.3
 * JD-Core Version:    0.7.0.1
 */