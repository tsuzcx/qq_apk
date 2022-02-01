package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

public final class CompletableOnSubscribeConcatArray
  implements Completable.CompletableOnSubscribe
{
  final Completable[] sources;
  
  public CompletableOnSubscribeConcatArray(Completable[] paramArrayOfCompletable)
  {
    this.sources = paramArrayOfCompletable;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    ConcatInnerSubscriber localConcatInnerSubscriber = new ConcatInnerSubscriber(paramCompletableSubscriber, this.sources);
    paramCompletableSubscriber.onSubscribe(localConcatInnerSubscriber.sd);
    localConcatInnerSubscriber.next();
  }
  
  static final class ConcatInnerSubscriber
    extends AtomicInteger
    implements Completable.CompletableSubscriber
  {
    private static final long serialVersionUID = -7965400327305809232L;
    final Completable.CompletableSubscriber actual;
    int index;
    final SerialSubscription sd;
    final Completable[] sources;
    
    public ConcatInnerSubscriber(Completable.CompletableSubscriber paramCompletableSubscriber, Completable[] paramArrayOfCompletable)
    {
      this.actual = paramCompletableSubscriber;
      this.sources = paramArrayOfCompletable;
      this.sd = new SerialSubscription();
    }
    
    void next()
    {
      if (this.sd.isUnsubscribed()) {}
      do
      {
        Completable[] arrayOfCompletable;
        do
        {
          return;
          while (getAndIncrement() != 0) {}
          arrayOfCompletable = this.sources;
        } while (this.sd.isUnsubscribed());
        int i = this.index;
        this.index = (i + 1);
        if (i == arrayOfCompletable.length)
        {
          this.actual.onCompleted();
          return;
        }
        arrayOfCompletable[i].subscribe(this);
      } while (decrementAndGet() != 0);
    }
    
    public void onCompleted()
    {
      next();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      this.sd.set(paramSubscription);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcatArray
 * JD-Core Version:    0.7.0.1
 */