package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing>
  implements Observable.Operator<List<T>, T>
{
  final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
  final int initialCapacity;
  
  public OperatorBufferWithSingleObservable(Observable<? extends TClosing> paramObservable, int paramInt)
  {
    this.bufferClosingSelector = new OperatorBufferWithSingleObservable.1(this, paramObservable);
    this.initialCapacity = paramInt;
  }
  
  public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> paramFunc0, int paramInt)
  {
    this.bufferClosingSelector = paramFunc0;
    this.initialCapacity = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    try
    {
      Observable localObservable = (Observable)this.bufferClosingSelector.call();
      BufferingSubscriber localBufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(paramSubscriber));
      OperatorBufferWithSingleObservable.2 local2 = new OperatorBufferWithSingleObservable.2(this, localBufferingSubscriber);
      paramSubscriber.add(local2);
      paramSubscriber.add(localBufferingSubscriber);
      localObservable.unsafeSubscribe(local2);
      return localBufferingSubscriber;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, paramSubscriber);
    }
    return Subscribers.empty();
  }
  
  final class BufferingSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> child;
    List<T> chunk;
    boolean done;
    
    public BufferingSubscriber()
    {
      Object localObject;
      this.child = localObject;
      this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
    }
    
    void emit()
    {
      try
      {
        if (this.done) {
          return;
        }
        List localList = this.chunk;
        this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        try
        {
          this.child.onNext(localList);
          return;
        }
        catch (Throwable localThrowable1)
        {
          unsubscribe();
          try
          {
            if (this.done) {
              return;
            }
          }
          finally {}
        }
        this.done = true;
      }
      finally {}
      Exceptions.throwOrReport(localThrowable2, this.child);
    }
    
    public void onCompleted()
    {
      try
      {
        try
        {
          if (this.done) {
            return;
          }
          this.done = true;
          List localList = this.chunk;
          this.chunk = null;
          this.child.onNext(localList);
          this.child.onCompleted();
          unsubscribe();
          return;
        }
        finally {}
        return;
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwOrReport(localThrowable, this.child);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        if (this.done) {
          return;
        }
        this.done = true;
        this.chunk = null;
        this.child.onError(paramThrowable);
        unsubscribe();
        return;
      }
      finally {}
    }
    
    public void onNext(T paramT)
    {
      try
      {
        if (this.done) {
          return;
        }
        this.chunk.add(paramT);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable
 * JD-Core Version:    0.7.0.1
 */