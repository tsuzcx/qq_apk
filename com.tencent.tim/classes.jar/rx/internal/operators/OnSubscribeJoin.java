package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R>
  implements Observable.OnSubscribe<R>
{
  final Observable<TLeft> left;
  final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
  final Func2<TLeft, TRight, R> resultSelector;
  final Observable<TRight> right;
  final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;
  
  public OnSubscribeJoin(Observable<TLeft> paramObservable, Observable<TRight> paramObservable1, Func1<TLeft, Observable<TLeftDuration>> paramFunc1, Func1<TRight, Observable<TRightDuration>> paramFunc11, Func2<TLeft, TRight, R> paramFunc2)
  {
    this.left = paramObservable;
    this.right = paramObservable1;
    this.leftDurationSelector = paramFunc1;
    this.rightDurationSelector = paramFunc11;
    this.resultSelector = paramFunc2;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    new ResultSink(new SerializedSubscriber(paramSubscriber)).run();
  }
  
  final class ResultSink
  {
    final CompositeSubscription group;
    final Object guard = new Object();
    boolean leftDone;
    int leftId;
    final Map<Integer, TLeft> leftMap;
    boolean rightDone;
    int rightId;
    final Map<Integer, TRight> rightMap;
    final Subscriber<? super R> subscriber;
    
    public ResultSink()
    {
      Object localObject;
      this.subscriber = localObject;
      this.group = new CompositeSubscription();
      this.leftMap = new HashMap();
      this.rightMap = new HashMap();
    }
    
    public void run()
    {
      this.subscriber.add(this.group);
      LeftSubscriber localLeftSubscriber = new LeftSubscriber();
      RightSubscriber localRightSubscriber = new RightSubscriber();
      this.group.add(localLeftSubscriber);
      this.group.add(localRightSubscriber);
      OnSubscribeJoin.this.left.unsafeSubscribe(localLeftSubscriber);
      OnSubscribeJoin.this.right.unsafeSubscribe(localRightSubscriber);
    }
    
    final class LeftSubscriber
      extends Subscriber<TLeft>
    {
      LeftSubscriber() {}
      
      protected void expire(int paramInt, Subscription paramSubscription)
      {
        int j = 0;
        Object localObject = OnSubscribeJoin.ResultSink.this.guard;
        int i = j;
        try
        {
          if (OnSubscribeJoin.ResultSink.this.leftMap.remove(Integer.valueOf(paramInt)) != null)
          {
            i = j;
            if (OnSubscribeJoin.ResultSink.this.leftMap.isEmpty())
            {
              i = j;
              if (OnSubscribeJoin.ResultSink.this.leftDone) {
                i = 1;
              }
            }
          }
          if (i != 0)
          {
            OnSubscribeJoin.ResultSink.this.subscriber.onCompleted();
            OnSubscribeJoin.ResultSink.this.subscriber.unsubscribe();
            return;
          }
        }
        finally {}
        OnSubscribeJoin.ResultSink.this.group.remove(paramSubscription);
      }
      
      public void onCompleted()
      {
        for (int i = 0;; i = 1)
        {
          synchronized (OnSubscribeJoin.ResultSink.this.guard)
          {
            OnSubscribeJoin.ResultSink.this.leftDone = true;
            if ((OnSubscribeJoin.ResultSink.this.rightDone) || (OnSubscribeJoin.ResultSink.this.leftMap.isEmpty())) {
              continue;
            }
            if (i != 0)
            {
              OnSubscribeJoin.ResultSink.this.subscriber.onCompleted();
              OnSubscribeJoin.ResultSink.this.subscriber.unsubscribe();
              return;
            }
          }
          OnSubscribeJoin.ResultSink.this.group.remove(this);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeJoin.ResultSink.this.subscriber.onError(paramThrowable);
        OnSubscribeJoin.ResultSink.this.subscriber.unsubscribe();
      }
      
      public void onNext(TLeft paramTLeft)
      {
        Object localObject2;
        synchronized (OnSubscribeJoin.ResultSink.this.guard)
        {
          localObject2 = OnSubscribeJoin.ResultSink.this;
          int i = ((OnSubscribeJoin.ResultSink)localObject2).leftId;
          ((OnSubscribeJoin.ResultSink)localObject2).leftId = (i + 1);
          OnSubscribeJoin.ResultSink.this.leftMap.put(Integer.valueOf(i), paramTLeft);
          int j = OnSubscribeJoin.ResultSink.this.rightId;
          try
          {
            ??? = (Observable)OnSubscribeJoin.this.leftDurationSelector.call(paramTLeft);
            localObject2 = new LeftDurationSubscriber(i);
            OnSubscribeJoin.ResultSink.this.group.add((Subscription)localObject2);
            ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
            localObject2 = new ArrayList();
            synchronized (OnSubscribeJoin.ResultSink.this.guard)
            {
              Iterator localIterator = OnSubscribeJoin.ResultSink.this.rightMap.entrySet().iterator();
              Map.Entry localEntry;
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localEntry = (Map.Entry)localIterator.next();
              } while (((Integer)localEntry.getKey()).intValue() >= j);
              ((List)localObject2).add(localEntry.getValue());
            }
            return;
          }
          catch (Throwable paramTLeft)
          {
            Exceptions.throwOrReport(paramTLeft, this);
          }
        }
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = ((Iterator)???).next();
          localObject2 = OnSubscribeJoin.this.resultSelector.call(paramTLeft, localObject2);
          OnSubscribeJoin.ResultSink.this.subscriber.onNext(localObject2);
        }
      }
      
      final class LeftDurationSubscriber
        extends Subscriber<TLeftDuration>
      {
        final int id;
        boolean once = true;
        
        public LeftDurationSubscriber(int paramInt)
        {
          this.id = paramInt;
        }
        
        public void onCompleted()
        {
          if (this.once)
          {
            this.once = false;
            OnSubscribeJoin.ResultSink.LeftSubscriber.this.expire(this.id, this);
          }
        }
        
        public void onError(Throwable paramThrowable)
        {
          OnSubscribeJoin.ResultSink.LeftSubscriber.this.onError(paramThrowable);
        }
        
        public void onNext(TLeftDuration paramTLeftDuration)
        {
          onCompleted();
        }
      }
    }
    
    final class RightSubscriber
      extends Subscriber<TRight>
    {
      RightSubscriber() {}
      
      void expire(int paramInt, Subscription paramSubscription)
      {
        int j = 0;
        Object localObject = OnSubscribeJoin.ResultSink.this.guard;
        int i = j;
        try
        {
          if (OnSubscribeJoin.ResultSink.this.rightMap.remove(Integer.valueOf(paramInt)) != null)
          {
            i = j;
            if (OnSubscribeJoin.ResultSink.this.rightMap.isEmpty())
            {
              i = j;
              if (OnSubscribeJoin.ResultSink.this.rightDone) {
                i = 1;
              }
            }
          }
          if (i != 0)
          {
            OnSubscribeJoin.ResultSink.this.subscriber.onCompleted();
            OnSubscribeJoin.ResultSink.this.subscriber.unsubscribe();
            return;
          }
        }
        finally {}
        OnSubscribeJoin.ResultSink.this.group.remove(paramSubscription);
      }
      
      public void onCompleted()
      {
        for (int i = 0;; i = 1)
        {
          synchronized (OnSubscribeJoin.ResultSink.this.guard)
          {
            OnSubscribeJoin.ResultSink.this.rightDone = true;
            if ((OnSubscribeJoin.ResultSink.this.leftDone) || (OnSubscribeJoin.ResultSink.this.rightMap.isEmpty())) {
              continue;
            }
            if (i != 0)
            {
              OnSubscribeJoin.ResultSink.this.subscriber.onCompleted();
              OnSubscribeJoin.ResultSink.this.subscriber.unsubscribe();
              return;
            }
          }
          OnSubscribeJoin.ResultSink.this.group.remove(this);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeJoin.ResultSink.this.subscriber.onError(paramThrowable);
        OnSubscribeJoin.ResultSink.this.subscriber.unsubscribe();
      }
      
      public void onNext(TRight paramTRight)
      {
        Object localObject2;
        synchronized (OnSubscribeJoin.ResultSink.this.guard)
        {
          localObject2 = OnSubscribeJoin.ResultSink.this;
          int i = ((OnSubscribeJoin.ResultSink)localObject2).rightId;
          ((OnSubscribeJoin.ResultSink)localObject2).rightId = (i + 1);
          OnSubscribeJoin.ResultSink.this.rightMap.put(Integer.valueOf(i), paramTRight);
          int j = OnSubscribeJoin.ResultSink.this.leftId;
          ??? = new SerialSubscription();
          OnSubscribeJoin.ResultSink.this.group.add((Subscription)???);
          try
          {
            ??? = (Observable)OnSubscribeJoin.this.rightDurationSelector.call(paramTRight);
            localObject2 = new RightDurationSubscriber(i);
            OnSubscribeJoin.ResultSink.this.group.add((Subscription)localObject2);
            ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
            localObject2 = new ArrayList();
            synchronized (OnSubscribeJoin.ResultSink.this.guard)
            {
              Iterator localIterator = OnSubscribeJoin.ResultSink.this.leftMap.entrySet().iterator();
              Map.Entry localEntry;
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localEntry = (Map.Entry)localIterator.next();
              } while (((Integer)localEntry.getKey()).intValue() >= j);
              ((List)localObject2).add(localEntry.getValue());
            }
            return;
          }
          catch (Throwable paramTRight)
          {
            Exceptions.throwOrReport(paramTRight, this);
          }
        }
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = ((Iterator)???).next();
          localObject2 = OnSubscribeJoin.this.resultSelector.call(localObject2, paramTRight);
          OnSubscribeJoin.ResultSink.this.subscriber.onNext(localObject2);
        }
      }
      
      final class RightDurationSubscriber
        extends Subscriber<TRightDuration>
      {
        final int id;
        boolean once = true;
        
        public RightDurationSubscriber(int paramInt)
        {
          this.id = paramInt;
        }
        
        public void onCompleted()
        {
          if (this.once)
          {
            this.once = false;
            OnSubscribeJoin.ResultSink.RightSubscriber.this.expire(this.id, this);
          }
        }
        
        public void onError(Throwable paramThrowable)
        {
          OnSubscribeJoin.ResultSink.RightSubscriber.this.onError(paramThrowable);
        }
        
        public void onNext(TRightDuration paramTRightDuration)
        {
          onCompleted();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin
 * JD-Core Version:    0.7.0.1
 */