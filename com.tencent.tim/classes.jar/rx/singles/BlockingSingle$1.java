package rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.SingleSubscriber;

class BlockingSingle$1
  extends SingleSubscriber<T>
{
  BlockingSingle$1(BlockingSingle paramBlockingSingle, AtomicReference paramAtomicReference1, CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference2) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$returnException.set(paramThrowable);
    this.val$latch.countDown();
  }
  
  public void onSuccess(T paramT)
  {
    this.val$returnItem.set(paramT);
    this.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.singles.BlockingSingle.1
 * JD-Core Version:    0.7.0.1
 */