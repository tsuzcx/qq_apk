package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;
import rx.functions.Functions;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

public final class OperatorZip<R>
  implements Observable.Operator<R, Observable<?>[]>
{
  final FuncN<? extends R> zipFunction;
  
  public OperatorZip(Func2 paramFunc2)
  {
    this.zipFunction = Functions.fromFunc(paramFunc2);
  }
  
  public OperatorZip(Func3 paramFunc3)
  {
    this.zipFunction = Functions.fromFunc(paramFunc3);
  }
  
  public OperatorZip(Func4 paramFunc4)
  {
    this.zipFunction = Functions.fromFunc(paramFunc4);
  }
  
  public OperatorZip(Func5 paramFunc5)
  {
    this.zipFunction = Functions.fromFunc(paramFunc5);
  }
  
  public OperatorZip(Func6 paramFunc6)
  {
    this.zipFunction = Functions.fromFunc(paramFunc6);
  }
  
  public OperatorZip(Func7 paramFunc7)
  {
    this.zipFunction = Functions.fromFunc(paramFunc7);
  }
  
  public OperatorZip(Func8 paramFunc8)
  {
    this.zipFunction = Functions.fromFunc(paramFunc8);
  }
  
  public OperatorZip(Func9 paramFunc9)
  {
    this.zipFunction = Functions.fromFunc(paramFunc9);
  }
  
  public OperatorZip(FuncN<? extends R> paramFuncN)
  {
    this.zipFunction = paramFuncN;
  }
  
  public Subscriber<? super Observable[]> call(Subscriber<? super R> paramSubscriber)
  {
    Object localObject = new Zip(paramSubscriber, this.zipFunction);
    ZipProducer localZipProducer = new ZipProducer((Zip)localObject);
    localObject = new ZipSubscriber(paramSubscriber, (Zip)localObject, localZipProducer);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.setProducer(localZipProducer);
    return localObject;
  }
  
  static final class Zip<R>
    extends AtomicLong
  {
    static final int THRESHOLD = (int)(RxRingBuffer.SIZE * 0.7D);
    private static final long serialVersionUID = 5995274816189928317L;
    final Observer<? super R> child;
    private final CompositeSubscription childSubscription = new CompositeSubscription();
    int emitted = 0;
    private AtomicLong requested;
    private volatile Object[] subscribers;
    private final FuncN<? extends R> zipFunction;
    
    public Zip(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN)
    {
      this.child = paramSubscriber;
      this.zipFunction = paramFuncN;
      paramSubscriber.add(this.childSubscription);
    }
    
    public void start(Observable[] paramArrayOfObservable, AtomicLong paramAtomicLong)
    {
      int j = 0;
      Object[] arrayOfObject = new Object[paramArrayOfObservable.length];
      int i = 0;
      while (i < paramArrayOfObservable.length)
      {
        InnerSubscriber localInnerSubscriber = new InnerSubscriber();
        arrayOfObject[i] = localInnerSubscriber;
        this.childSubscription.add(localInnerSubscriber);
        i += 1;
      }
      this.requested = paramAtomicLong;
      this.subscribers = arrayOfObject;
      i = j;
      while (i < paramArrayOfObservable.length)
      {
        paramArrayOfObservable[i].unsafeSubscribe((InnerSubscriber)arrayOfObject[i]);
        i += 1;
      }
    }
    
    void tick()
    {
      Object[] arrayOfObject = this.subscribers;
      if (arrayOfObject == null) {}
      while (getAndIncrement() != 0L) {
        return;
      }
      int k = arrayOfObject.length;
      Observer localObserver = this.child;
      AtomicLong localAtomicLong = this.requested;
      do
      {
        for (;;)
        {
          Object localObject1 = new Object[k];
          int i = 1;
          int j = 0;
          if (j < k)
          {
            RxRingBuffer localRxRingBuffer = ((InnerSubscriber)arrayOfObject[j]).items;
            Object localObject2 = localRxRingBuffer.peek();
            if (localObject2 == null) {
              i = 0;
            }
            for (;;)
            {
              j += 1;
              break;
              if (localRxRingBuffer.isCompleted(localObject2))
              {
                localObserver.onCompleted();
                this.childSubscription.unsubscribe();
                return;
              }
              localObject1[j] = localRxRingBuffer.getValue(localObject2);
            }
          }
          if ((localAtomicLong.get() <= 0L) || (i == 0)) {
            break;
          }
          for (;;)
          {
            try
            {
              localObserver.onNext(this.zipFunction.call((Object[])localObject1));
              localAtomicLong.decrementAndGet();
              this.emitted += 1;
              j = arrayOfObject.length;
              i = 0;
              if (i >= j) {
                break;
              }
              localObject1 = ((InnerSubscriber)arrayOfObject[i]).items;
              ((RxRingBuffer)localObject1).poll();
              if (((RxRingBuffer)localObject1).isCompleted(((RxRingBuffer)localObject1).peek()))
              {
                localObserver.onCompleted();
                this.childSubscription.unsubscribe();
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              Exceptions.throwOrReport(localThrowable, localObserver, localObject1);
              return;
            }
            i += 1;
          }
          if (this.emitted > THRESHOLD)
          {
            j = localThrowable.length;
            i = 0;
            while (i < j)
            {
              ((InnerSubscriber)localThrowable[i]).requestMore(this.emitted);
              i += 1;
            }
            this.emitted = 0;
          }
        }
      } while (decrementAndGet() > 0L);
    }
    
    final class InnerSubscriber
      extends Subscriber
    {
      final RxRingBuffer items = RxRingBuffer.getSpmcInstance();
      
      InnerSubscriber() {}
      
      public void onCompleted()
      {
        this.items.onCompleted();
        OperatorZip.Zip.this.tick();
      }
      
      public void onError(Throwable paramThrowable)
      {
        OperatorZip.Zip.this.child.onError(paramThrowable);
      }
      
      public void onNext(Object paramObject)
      {
        try
        {
          this.items.onNext(paramObject);
          OperatorZip.Zip.this.tick();
          return;
        }
        catch (MissingBackpressureException paramObject)
        {
          for (;;)
          {
            onError(paramObject);
          }
        }
      }
      
      public void onStart()
      {
        request(RxRingBuffer.SIZE);
      }
      
      public void requestMore(long paramLong)
      {
        request(paramLong);
      }
    }
  }
  
  static final class ZipProducer<R>
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = -1216676403723546796L;
    private OperatorZip.Zip<R> zipper;
    
    public ZipProducer(OperatorZip.Zip<R> paramZip)
    {
      this.zipper = paramZip;
    }
    
    public void request(long paramLong)
    {
      BackpressureUtils.getAndAddRequest(this, paramLong);
      this.zipper.tick();
    }
  }
  
  final class ZipSubscriber
    extends Subscriber<Observable[]>
  {
    final Subscriber<? super R> child;
    final OperatorZip.ZipProducer<R> producer;
    boolean started = false;
    final OperatorZip.Zip<R> zipper;
    
    public ZipSubscriber(OperatorZip.Zip<R> paramZip, OperatorZip.ZipProducer<R> paramZipProducer)
    {
      this.child = paramZip;
      this.zipper = paramZipProducer;
      Object localObject;
      this.producer = localObject;
    }
    
    public void onCompleted()
    {
      if (!this.started) {
        this.child.onCompleted();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    public void onNext(Observable[] paramArrayOfObservable)
    {
      if ((paramArrayOfObservable == null) || (paramArrayOfObservable.length == 0))
      {
        this.child.onCompleted();
        return;
      }
      this.started = true;
      this.zipper.start(paramArrayOfObservable, this.producer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorZip
 * JD-Core Version:    0.7.0.1
 */