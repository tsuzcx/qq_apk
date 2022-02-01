package rx.observables;

import java.util.concurrent.CountDownLatch;
import rx.Subscriber;

class BlockingObservable$4
  extends Subscriber<T>
{
  BlockingObservable$4(BlockingObservable paramBlockingObservable, Throwable[] paramArrayOfThrowable, CountDownLatch paramCountDownLatch) {}
  
  public void onCompleted()
  {
    this.val$cdl.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$error[0] = paramThrowable;
    this.val$cdl.countDown();
  }
  
  public void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.observables.BlockingObservable.4
 * JD-Core Version:    0.7.0.1
 */