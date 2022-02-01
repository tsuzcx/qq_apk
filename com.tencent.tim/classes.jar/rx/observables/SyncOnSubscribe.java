package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

@Experimental
public abstract class SyncOnSubscribe<S, T>
  implements Observable.OnSubscribe<T>
{
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action2<? super S, ? super Observer<? super T>> paramAction2)
  {
    return new SyncOnSubscribeImpl(paramFunc0, new SyncOnSubscribe.1(paramAction2));
  }
  
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action2<? super S, ? super Observer<? super T>> paramAction2, Action1<? super S> paramAction1)
  {
    return new SyncOnSubscribeImpl(paramFunc0, new SyncOnSubscribe.2(paramAction2), paramAction1);
  }
  
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2)
  {
    return new SyncOnSubscribeImpl(paramFunc0, paramFunc2);
  }
  
  @Experimental
  public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2, Action1<? super S> paramAction1)
  {
    return new SyncOnSubscribeImpl(paramFunc0, paramFunc2, paramAction1);
  }
  
  @Experimental
  public static <T> SyncOnSubscribe<Void, T> createStateless(Action1<? super Observer<? super T>> paramAction1)
  {
    return new SyncOnSubscribeImpl(new SyncOnSubscribe.3(paramAction1));
  }
  
  @Experimental
  public static <T> SyncOnSubscribe<Void, T> createStateless(Action1<? super Observer<? super T>> paramAction1, Action0 paramAction0)
  {
    return new SyncOnSubscribeImpl(new SyncOnSubscribe.4(paramAction1), new SyncOnSubscribe.5(paramAction0));
  }
  
  public final void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      Object localObject = generateState();
      localObject = new SubscriptionProducer(paramSubscriber, this, localObject);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.setProducer((Producer)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      paramSubscriber.onError(localThrowable);
    }
  }
  
  protected abstract S generateState();
  
  protected abstract S next(S paramS, Observer<? super T> paramObserver);
  
  protected void onUnsubscribe(S paramS) {}
  
  static class SubscriptionProducer<S, T>
    extends AtomicLong
    implements Observer<T>, Producer, Subscription
  {
    private static final long serialVersionUID = -3736864024352728072L;
    private final Subscriber<? super T> actualSubscriber;
    private boolean hasTerminated;
    private boolean onNextCalled;
    private final SyncOnSubscribe<S, T> parent;
    private S state;
    
    SubscriptionProducer(Subscriber<? super T> paramSubscriber, SyncOnSubscribe<S, T> paramSyncOnSubscribe, S paramS)
    {
      this.actualSubscriber = paramSubscriber;
      this.parent = paramSyncOnSubscribe;
      this.state = paramS;
    }
    
    private void doUnsubscribe()
    {
      try
      {
        this.parent.onUnsubscribe(this.state);
        return;
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwIfFatal(localThrowable);
        RxJavaPlugins.getInstance().getErrorHandler().handleError(localThrowable);
      }
    }
    
    private void fastpath()
    {
      SyncOnSubscribe localSyncOnSubscribe = this.parent;
      Subscriber localSubscriber = this.actualSubscriber;
      try
      {
        do
        {
          this.onNextCalled = false;
          nextIteration(localSyncOnSubscribe);
        } while (!tryUnsubscribe());
        return;
      }
      catch (Throwable localThrowable)
      {
        handleThrownError(localSubscriber, localThrowable);
      }
    }
    
    private void handleThrownError(Subscriber<? super T> paramSubscriber, Throwable paramThrowable)
    {
      if (this.hasTerminated)
      {
        RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
        return;
      }
      this.hasTerminated = true;
      paramSubscriber.onError(paramThrowable);
      unsubscribe();
    }
    
    private void nextIteration(SyncOnSubscribe<S, T> paramSyncOnSubscribe)
    {
      this.state = paramSyncOnSubscribe.next(this.state, this);
    }
    
    private void slowPath(long paramLong)
    {
      SyncOnSubscribe localSyncOnSubscribe = this.parent;
      Subscriber localSubscriber = this.actualSubscriber;
      long l1;
      do
      {
        l1 = paramLong;
        long l2;
        do
        {
          try
          {
            this.onNextCalled = false;
            nextIteration(localSyncOnSubscribe);
            if (tryUnsubscribe()) {
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            handleThrownError(localSubscriber, localThrowable);
            return;
          }
          l2 = l1;
          if (this.onNextCalled) {
            l2 = l1 - 1L;
          }
          l1 = l2;
        } while (l2 != 0L);
        l1 = addAndGet(-paramLong);
        paramLong = l1;
      } while (l1 > 0L);
      tryUnsubscribe();
    }
    
    private boolean tryUnsubscribe()
    {
      if ((this.hasTerminated) || (get() < -1L))
      {
        set(-1L);
        doUnsubscribe();
        return true;
      }
      return false;
    }
    
    public boolean isUnsubscribed()
    {
      return get() < 0L;
    }
    
    public void onCompleted()
    {
      if (this.hasTerminated) {
        throw new IllegalStateException("Terminal event already emitted.");
      }
      this.hasTerminated = true;
      if (!this.actualSubscriber.isUnsubscribed()) {
        this.actualSubscriber.onCompleted();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.hasTerminated) {
        throw new IllegalStateException("Terminal event already emitted.");
      }
      this.hasTerminated = true;
      if (!this.actualSubscriber.isUnsubscribed()) {
        this.actualSubscriber.onError(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (this.onNextCalled) {
        throw new IllegalStateException("onNext called multiple times!");
      }
      this.onNextCalled = true;
      this.actualSubscriber.onNext(paramT);
    }
    
    public void request(long paramLong)
    {
      if ((paramLong > 0L) && (BackpressureUtils.getAndAddRequest(this, paramLong) == 0L))
      {
        if (paramLong == 9223372036854775807L) {
          fastpath();
        }
      }
      else {
        return;
      }
      slowPath(paramLong);
    }
    
    public void unsubscribe()
    {
      long l;
      do
      {
        l = get();
        if (compareAndSet(0L, -1L))
        {
          doUnsubscribe();
          return;
        }
      } while (!compareAndSet(l, -2L));
    }
  }
  
  static final class SyncOnSubscribeImpl<S, T>
    extends SyncOnSubscribe<S, T>
  {
    private final Func0<? extends S> generator;
    private final Func2<? super S, ? super Observer<? super T>, ? extends S> next;
    private final Action1<? super S> onUnsubscribe;
    
    public SyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2)
    {
      this(paramFunc0, paramFunc2, null);
    }
    
    SyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2, Action1<? super S> paramAction1)
    {
      this.generator = paramFunc0;
      this.next = paramFunc2;
      this.onUnsubscribe = paramAction1;
    }
    
    public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> paramFunc2)
    {
      this(null, paramFunc2, null);
    }
    
    public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> paramFunc2, Action1<? super S> paramAction1)
    {
      this(null, paramFunc2, paramAction1);
    }
    
    protected S generateState()
    {
      if (this.generator == null) {
        return null;
      }
      return this.generator.call();
    }
    
    protected S next(S paramS, Observer<? super T> paramObserver)
    {
      return this.next.call(paramS, paramObserver);
    }
    
    protected void onUnsubscribe(S paramS)
    {
      if (this.onUnsubscribe != null) {
        this.onUnsubscribe.call(paramS);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe
 * JD-Core Version:    0.7.0.1
 */