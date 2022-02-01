package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

public final class OperatorElementAt<T>
  implements Observable.Operator<T, T>
{
  final T defaultValue;
  final boolean hasDefault;
  final int index;
  
  public OperatorElementAt(int paramInt)
  {
    this(paramInt, null, false);
  }
  
  public OperatorElementAt(int paramInt, T paramT)
  {
    this(paramInt, paramT, true);
  }
  
  private OperatorElementAt(int paramInt, T paramT, boolean paramBoolean)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException(paramInt + " is out of bounds");
    }
    this.index = paramInt;
    this.defaultValue = paramT;
    this.hasDefault = paramBoolean;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorElementAt.1 local1 = new OperatorElementAt.1(this, paramSubscriber);
    paramSubscriber.add(local1);
    return local1;
  }
  
  static class InnerProducer
    extends AtomicBoolean
    implements Producer
  {
    private static final long serialVersionUID = 1L;
    final Producer actual;
    
    public InnerProducer(Producer paramProducer)
    {
      this.actual = paramProducer;
    }
    
    public void request(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("n >= 0 required");
      }
      if ((paramLong > 0L) && (compareAndSet(false, true))) {
        this.actual.request(9223372036854775807L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorElementAt
 * JD-Core Version:    0.7.0.1
 */