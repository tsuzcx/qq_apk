package android.arch.lifecycle;

import android.support.annotation.WorkerThread;
import java.util.concurrent.atomic.AtomicBoolean;

class ComputableLiveData$2
  implements Runnable
{
  ComputableLiveData$2(ComputableLiveData paramComputableLiveData) {}
  
  @WorkerThread
  public void run()
  {
    Object localObject1;
    if (ComputableLiveData.access$100(this.this$0).compareAndSet(false, true)) {
      localObject1 = null;
    }
    for (int i = 0;; i = 0) {
      try
      {
        while (ComputableLiveData.access$200(this.this$0).compareAndSet(true, false))
        {
          localObject1 = this.this$0.compute();
          i = 1;
        }
        if (i != 0) {
          ComputableLiveData.access$300(this.this$0).postValue(localObject1);
        }
        ComputableLiveData.access$100(this.this$0).set(false);
        if ((i != 0) && (ComputableLiveData.access$200(this.this$0).get())) {
          break;
        }
        return;
      }
      finally
      {
        ComputableLiveData.access$100(this.this$0).set(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.arch.lifecycle.ComputableLiveData.2
 * JD-Core Version:    0.7.0.1
 */