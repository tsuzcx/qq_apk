package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeFromIterable<T>
  implements Observable.OnSubscribe<T>
{
  final Iterable<? extends T> is;
  
  public OnSubscribeFromIterable(Iterable<? extends T> paramIterable)
  {
    if (paramIterable == null) {
      throw new NullPointerException("iterable must not be null");
    }
    this.is = paramIterable;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Iterator localIterator = this.is.iterator();
    if ((!localIterator.hasNext()) && (!paramSubscriber.isUnsubscribed()))
    {
      paramSubscriber.onCompleted();
      return;
    }
    paramSubscriber.setProducer(new IterableProducer(paramSubscriber, localIterator));
  }
  
  static final class IterableProducer<T>
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = -8730475647105475802L;
    private final Iterator<? extends T> it;
    private final Subscriber<? super T> o;
    
    IterableProducer(Subscriber<? super T> paramSubscriber, Iterator<? extends T> paramIterator)
    {
      this.o = paramSubscriber;
      this.it = paramIterator;
    }
    
    void fastpath()
    {
      Subscriber localSubscriber = this.o;
      Iterator localIterator = this.it;
      if (localSubscriber.isUnsubscribed()) {}
      do
      {
        return;
        if (localIterator.hasNext())
        {
          localSubscriber.onNext(localIterator.next());
          break;
        }
      } while (localSubscriber.isUnsubscribed());
      localSubscriber.onCompleted();
    }
    
    public void request(long paramLong)
    {
      if (get() == 9223372036854775807L) {}
      do
      {
        return;
        if ((paramLong == 9223372036854775807L) && (compareAndSet(0L, 9223372036854775807L)))
        {
          fastpath();
          return;
        }
      } while ((paramLong <= 0L) || (BackpressureUtils.getAndAddRequest(this, paramLong) != 0L));
      slowpath(paramLong);
    }
    
    void slowpath(long paramLong)
    {
      Subscriber localSubscriber = this.o;
      Iterator localIterator = this.it;
      long l;
      label72:
      do
      {
        l = paramLong;
        if (localSubscriber.isUnsubscribed()) {}
        do
        {
          return;
          if (localIterator.hasNext())
          {
            l -= 1L;
            if (l < 0L) {
              break label72;
            }
            localSubscriber.onNext(localIterator.next());
            break;
          }
        } while (localSubscriber.isUnsubscribed());
        localSubscriber.onCompleted();
        return;
        l = addAndGet(-paramLong);
        paramLong = l;
      } while (l != 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeFromIterable
 * JD-Core Version:    0.7.0.1
 */