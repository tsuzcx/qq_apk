package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

public final class OperatorBufferWithSize<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final int skip;
  
  public OperatorBufferWithSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("count must be greater than 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("skip must be greater than 0");
    }
    this.count = paramInt1;
    this.skip = paramInt2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    if (this.skip == this.count)
    {
      localObject = new BufferExact(paramSubscriber, this.count);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.setProducer(((BufferExact)localObject).createProducer());
      return localObject;
    }
    if (this.skip > this.count)
    {
      localObject = new BufferSkip(paramSubscriber, this.count, this.skip);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.setProducer(((BufferSkip)localObject).createProducer());
      return localObject;
    }
    Object localObject = new BufferOverlap(paramSubscriber, this.count, this.skip);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.setProducer(((BufferOverlap)localObject).createProducer());
    return localObject;
  }
  
  static final class BufferExact<T>
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> actual;
    List<T> buffer;
    final int count;
    
    public BufferExact(Subscriber<? super List<T>> paramSubscriber, int paramInt)
    {
      this.actual = paramSubscriber;
      this.count = paramInt;
      request(0L);
    }
    
    Producer createProducer()
    {
      return new OperatorBufferWithSize.BufferExact.1(this);
    }
    
    public void onCompleted()
    {
      List localList = this.buffer;
      if (localList != null) {
        this.actual.onNext(localList);
      }
      this.actual.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.buffer = null;
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      List localList = this.buffer;
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(this.count);
        this.buffer = ((List)localObject);
      }
      ((List)localObject).add(paramT);
      if (((List)localObject).size() == this.count)
      {
        this.buffer = null;
        this.actual.onNext(localObject);
      }
    }
  }
  
  static final class BufferOverlap<T>
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> actual;
    final int count;
    long index;
    long produced;
    final ArrayDeque<List<T>> queue;
    final AtomicLong requested;
    final int skip;
    
    public BufferOverlap(Subscriber<? super List<T>> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.count = paramInt1;
      this.skip = paramInt2;
      this.queue = new ArrayDeque();
      this.requested = new AtomicLong();
      request(0L);
    }
    
    Producer createProducer()
    {
      return new BufferOverlapProducer();
    }
    
    public void onCompleted()
    {
      long l = this.produced;
      if (l != 0L)
      {
        if (l > this.requested.get())
        {
          this.actual.onError(new MissingBackpressureException("More produced than requested? " + l));
          return;
        }
        this.requested.addAndGet(-l);
      }
      BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.queue.clear();
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l = this.index;
      Object localObject;
      if (l == 0L)
      {
        localObject = new ArrayList(this.count);
        this.queue.offer(localObject);
      }
      l += 1L;
      if (l == this.skip) {}
      for (this.index = 0L;; this.index = l)
      {
        localObject = this.queue.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((List)((Iterator)localObject).next()).add(paramT);
        }
      }
      paramT = (List)this.queue.peek();
      if ((paramT != null) && (paramT.size() == this.count))
      {
        this.queue.poll();
        this.produced += 1L;
        this.actual.onNext(paramT);
      }
    }
    
    final class BufferOverlapProducer
      extends AtomicBoolean
      implements Producer
    {
      private static final long serialVersionUID = -4015894850868853147L;
      
      BufferOverlapProducer() {}
      
      public void request(long paramLong)
      {
        OperatorBufferWithSize.BufferOverlap localBufferOverlap = OperatorBufferWithSize.BufferOverlap.this;
        if ((BackpressureUtils.postCompleteRequest(localBufferOverlap.requested, paramLong, localBufferOverlap.queue, localBufferOverlap.actual)) && (paramLong != 0L))
        {
          if ((!get()) && (compareAndSet(false, true))) {
            localBufferOverlap.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(localBufferOverlap.skip, paramLong - 1L), localBufferOverlap.count));
          }
        }
        else {
          return;
        }
        localBufferOverlap.request(BackpressureUtils.multiplyCap(localBufferOverlap.skip, paramLong));
      }
    }
  }
  
  static final class BufferSkip<T>
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> actual;
    List<T> buffer;
    final int count;
    long index;
    final int skip;
    
    public BufferSkip(Subscriber<? super List<T>> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.count = paramInt1;
      this.skip = paramInt2;
      request(0L);
    }
    
    Producer createProducer()
    {
      return new BufferSkipProducer();
    }
    
    public void onCompleted()
    {
      List localList = this.buffer;
      if (localList != null)
      {
        this.buffer = null;
        this.actual.onNext(localList);
      }
      this.actual.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.buffer = null;
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l = this.index;
      Object localObject = this.buffer;
      if (l == 0L)
      {
        localObject = new ArrayList(this.count);
        this.buffer = ((List)localObject);
      }
      l += 1L;
      if (l == this.skip) {}
      for (this.index = 0L;; this.index = l)
      {
        if (localObject != null)
        {
          ((List)localObject).add(paramT);
          if (((List)localObject).size() == this.count)
          {
            this.buffer = null;
            this.actual.onNext(localObject);
          }
        }
        return;
      }
    }
    
    final class BufferSkipProducer
      extends AtomicBoolean
      implements Producer
    {
      private static final long serialVersionUID = 3428177408082367154L;
      
      BufferSkipProducer() {}
      
      public void request(long paramLong)
      {
        if (paramLong < 0L) {
          throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
        }
        OperatorBufferWithSize.BufferSkip localBufferSkip;
        if (paramLong != 0L)
        {
          localBufferSkip = OperatorBufferWithSize.BufferSkip.this;
          if ((!get()) && (compareAndSet(false, true))) {
            localBufferSkip.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(paramLong, localBufferSkip.count), BackpressureUtils.multiplyCap(localBufferSkip.skip - localBufferSkip.count, paramLong - 1L)));
          }
        }
        else
        {
          return;
        }
        localBufferSkip.request(BackpressureUtils.multiplyCap(paramLong, localBufferSkip.skip));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize
 * JD-Core Version:    0.7.0.1
 */