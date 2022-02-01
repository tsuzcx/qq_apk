package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;
import rx.Subscriber;

public final class BlockingOperatorMostRecent
{
  private BlockingOperatorMostRecent()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> mostRecent(Observable<? extends T> paramObservable, T paramT)
  {
    return new BlockingOperatorMostRecent.1(paramT, paramObservable);
  }
  
  static final class MostRecentObserver<T>
    extends Subscriber<T>
  {
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile Object value = this.nl.next(paramT);
    
    MostRecentObserver(T paramT) {}
    
    public Iterator<T> getIterable()
    {
      return new BlockingOperatorMostRecent.MostRecentObserver.1(this);
    }
    
    public void onCompleted()
    {
      this.value = this.nl.completed();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.value = this.nl.error(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.value = this.nl.next(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent
 * JD-Core Version:    0.7.0.1
 */