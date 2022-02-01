package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorSingle<T>
  implements Observable.Operator<T, T>
{
  private final T defaultValue;
  private final boolean hasDefaultValue;
  
  OperatorSingle()
  {
    this(false, null);
  }
  
  public OperatorSingle(T paramT)
  {
    this(true, paramT);
  }
  
  private OperatorSingle(boolean paramBoolean, T paramT)
  {
    this.hasDefaultValue = paramBoolean;
    this.defaultValue = paramT;
  }
  
  public static <T> OperatorSingle<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    ParentSubscriber localParentSubscriber = new ParentSubscriber(paramSubscriber, this.hasDefaultValue, this.defaultValue);
    paramSubscriber.setProducer(new OperatorSingle.1(this, localParentSubscriber));
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
  
  static class Holder
  {
    static final OperatorSingle<?> INSTANCE = new OperatorSingle();
  }
  
  static final class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private final Subscriber<? super T> child;
    private final T defaultValue;
    private final boolean hasDefaultValue;
    private boolean hasTooManyElements = false;
    private boolean isNonEmpty = false;
    private T value;
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, T paramT)
    {
      this.child = paramSubscriber;
      this.hasDefaultValue = paramBoolean;
      this.defaultValue = paramT;
    }
    
    public void onCompleted()
    {
      if (this.hasTooManyElements) {
        return;
      }
      if (this.isNonEmpty)
      {
        this.child.onNext(this.value);
        this.child.onCompleted();
        return;
      }
      if (this.hasDefaultValue)
      {
        this.child.onNext(this.defaultValue);
        this.child.onCompleted();
        return;
      }
      this.child.onError(new NoSuchElementException("Sequence contains no elements"));
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.isNonEmpty)
      {
        this.hasTooManyElements = true;
        this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
        unsubscribe();
        return;
      }
      this.value = paramT;
      this.isNonEmpty = true;
    }
    
    void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorSingle
 * JD-Core Version:    0.7.0.1
 */