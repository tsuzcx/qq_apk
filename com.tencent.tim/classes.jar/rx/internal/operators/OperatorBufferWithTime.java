package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.observers.SerializedSubscriber;

public final class OperatorBufferWithTime<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final Scheduler scheduler;
  final long timeshift;
  final long timespan;
  final TimeUnit unit;
  
  public OperatorBufferWithTime(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    this.timespan = paramLong1;
    this.timeshift = paramLong2;
    this.unit = paramTimeUnit;
    this.count = paramInt;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    Object localObject = new SerializedSubscriber(paramSubscriber);
    if (this.timespan == this.timeshift)
    {
      localObject = new ExactSubscriber((Subscriber)localObject, localWorker);
      ((ExactSubscriber)localObject).add(localWorker);
      paramSubscriber.add((Subscription)localObject);
      ((ExactSubscriber)localObject).scheduleExact();
      return localObject;
    }
    localObject = new InexactSubscriber((Subscriber)localObject, localWorker);
    ((InexactSubscriber)localObject).add(localWorker);
    paramSubscriber.add((Subscription)localObject);
    ((InexactSubscriber)localObject).startNewChunk();
    ((InexactSubscriber)localObject).scheduleChunk();
    return localObject;
  }
  
  final class ExactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> child;
    List<T> chunk;
    boolean done;
    final Scheduler.Worker inner;
    
    public ExactSubscriber(Scheduler.Worker paramWorker)
    {
      this.child = paramWorker;
      Object localObject;
      this.inner = localObject;
      this.chunk = new ArrayList();
    }
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:done	Z
      //   6: ifeq +6 -> 12
      //   9: aload_0
      //   10: monitorexit
      //   11: return
      //   12: aload_0
      //   13: getfield 36	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:chunk	Ljava/util/List;
      //   16: astore_1
      //   17: aload_0
      //   18: new 33	java/util/ArrayList
      //   21: dup
      //   22: invokespecial 34	java/util/ArrayList:<init>	()V
      //   25: putfield 36	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:chunk	Ljava/util/List;
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_0
      //   31: getfield 29	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:child	Lrx/Subscriber;
      //   34: aload_1
      //   35: invokevirtual 48	rx/Subscriber:onNext	(Ljava/lang/Object;)V
      //   38: return
      //   39: astore_1
      //   40: aload_1
      //   41: aload_0
      //   42: invokestatic 54	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
      //   45: return
      //   46: astore_1
      //   47: aload_0
      //   48: monitorexit
      //   49: aload_1
      //   50: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	51	0	this	ExactSubscriber
      //   16	19	1	localList	List
      //   39	2	1	localThrowable	Throwable
      //   46	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   30	38	39	java/lang/Throwable
      //   2	11	46	finally
      //   12	30	46	finally
      //   47	49	46	finally
    }
    
    public void onCompleted()
    {
      try
      {
        this.inner.unsubscribe();
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
      Object localObject = null;
      try
      {
        if (this.done) {
          return;
        }
        this.chunk.add(paramT);
        paramT = localObject;
        if (this.chunk.size() == OperatorBufferWithTime.this.count)
        {
          paramT = this.chunk;
          this.chunk = new ArrayList();
        }
        if (paramT != null)
        {
          this.child.onNext(paramT);
          return;
        }
      }
      finally {}
    }
    
    void scheduleExact()
    {
      this.inner.schedulePeriodically(new OperatorBufferWithTime.ExactSubscriber.1(this), OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
    }
  }
  
  final class InexactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> child;
    final List<List<T>> chunks;
    boolean done;
    final Scheduler.Worker inner;
    
    public InexactSubscriber(Scheduler.Worker paramWorker)
    {
      this.child = paramWorker;
      Object localObject;
      this.inner = localObject;
      this.chunks = new LinkedList();
    }
    
    void emitChunk(List<T> paramList)
    {
      for (;;)
      {
        try
        {
          if (this.done) {
            return;
          }
          Iterator localIterator = this.chunks.iterator();
          if (localIterator.hasNext())
          {
            if ((List)localIterator.next() != paramList) {
              continue;
            }
            localIterator.remove();
            i = 1;
            if (i == 0) {
              break;
            }
            try
            {
              this.child.onNext(paramList);
              return;
            }
            catch (Throwable paramList)
            {
              Exceptions.throwOrReport(paramList, this);
              return;
            }
          }
          int i = 0;
        }
        finally {}
      }
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 45	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:done	Z
      //   6: ifeq +6 -> 12
      //   9: aload_0
      //   10: monitorexit
      //   11: return
      //   12: aload_0
      //   13: iconst_1
      //   14: putfield 45	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:done	Z
      //   17: new 33	java/util/LinkedList
      //   20: dup
      //   21: aload_0
      //   22: getfield 36	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:chunks	Ljava/util/List;
      //   25: invokespecial 79	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
      //   28: astore_1
      //   29: aload_0
      //   30: getfield 36	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:chunks	Ljava/util/List;
      //   33: invokeinterface 82 1 0
      //   38: aload_0
      //   39: monitorexit
      //   40: aload_1
      //   41: invokeinterface 51 1 0
      //   46: astore_1
      //   47: aload_1
      //   48: invokeinterface 57 1 0
      //   53: ifeq +39 -> 92
      //   56: aload_1
      //   57: invokeinterface 61 1 0
      //   62: checkcast 47	java/util/List
      //   65: astore_2
      //   66: aload_0
      //   67: getfield 29	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:child	Lrx/Subscriber;
      //   70: aload_2
      //   71: invokevirtual 68	rx/Subscriber:onNext	(Ljava/lang/Object;)V
      //   74: goto -27 -> 47
      //   77: astore_1
      //   78: aload_1
      //   79: aload_0
      //   80: getfield 29	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:child	Lrx/Subscriber;
      //   83: invokestatic 74	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
      //   86: return
      //   87: astore_1
      //   88: aload_0
      //   89: monitorexit
      //   90: aload_1
      //   91: athrow
      //   92: aload_0
      //   93: getfield 29	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:child	Lrx/Subscriber;
      //   96: invokevirtual 84	rx/Subscriber:onCompleted	()V
      //   99: aload_0
      //   100: invokevirtual 87	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:unsubscribe	()V
      //   103: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	104	0	this	InexactSubscriber
      //   28	29	1	localObject1	Object
      //   77	2	1	localThrowable	Throwable
      //   87	4	1	localObject2	Object
      //   65	6	2	localList	List
      // Exception table:
      //   from	to	target	type
      //   0	2	77	java/lang/Throwable
      //   40	47	77	java/lang/Throwable
      //   47	74	77	java/lang/Throwable
      //   90	92	77	java/lang/Throwable
      //   2	11	87	finally
      //   12	40	87	finally
      //   88	90	87	finally
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        if (this.done) {
          return;
        }
        this.done = true;
        this.chunks.clear();
        this.child.onError(paramThrowable);
        unsubscribe();
        return;
      }
      finally {}
    }
    
    public void onNext(T paramT)
    {
      Object localObject1 = null;
      for (;;)
      {
        Object localObject2;
        try
        {
          if (this.done) {
            return;
          }
          Iterator localIterator = this.chunks.iterator();
          if (localIterator.hasNext())
          {
            List localList = (List)localIterator.next();
            localList.add(paramT);
            localObject2 = localObject1;
            if (localList.size() == OperatorBufferWithTime.this.count)
            {
              localIterator.remove();
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new LinkedList();
              }
              ((List)localObject2).add(localList);
            }
          }
          else
          {
            if (localObject1 != null)
            {
              paramT = ((List)localObject1).iterator();
              if (paramT.hasNext())
              {
                localObject1 = (List)paramT.next();
                this.child.onNext(localObject1);
                continue;
              }
            }
            return;
          }
        }
        finally {}
        localObject1 = localObject2;
      }
    }
    
    void scheduleChunk()
    {
      this.inner.schedulePeriodically(new OperatorBufferWithTime.InexactSubscriber.1(this), OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.unit);
    }
    
    void startNewChunk()
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        if (this.done) {
          return;
        }
        this.chunks.add(localArrayList);
        this.inner.schedule(new OperatorBufferWithTime.InexactSubscriber.2(this, localArrayList), OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime
 * JD-Core Version:    0.7.0.1
 */