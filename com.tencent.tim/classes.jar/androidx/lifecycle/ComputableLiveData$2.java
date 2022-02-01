package androidx.lifecycle;

import androidx.annotation.WorkerThread;
import java.util.concurrent.atomic.AtomicBoolean;

class ComputableLiveData$2
  implements Runnable
{
  ComputableLiveData$2(ComputableLiveData paramComputableLiveData) {}
  
  @WorkerThread
  public void run()
  {
    Object localObject1;
    if (this.this$0.mComputing.compareAndSet(false, true)) {
      localObject1 = null;
    }
    for (int i = 0;; i = 0) {
      try
      {
        while (this.this$0.mInvalid.compareAndSet(true, false))
        {
          localObject1 = this.this$0.compute();
          i = 1;
        }
        if (i != 0) {
          this.this$0.mLiveData.postValue(localObject1);
        }
        this.this$0.mComputing.set(false);
        if ((i != 0) && (this.this$0.mInvalid.get())) {
          break;
        }
        return;
      }
      finally
      {
        this.this$0.mComputing.set(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.ComputableLiveData.2
 * JD-Core Version:    0.7.0.1
 */