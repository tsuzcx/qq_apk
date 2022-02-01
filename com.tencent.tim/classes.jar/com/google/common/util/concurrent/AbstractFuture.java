package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import sun.misc.Unsafe;

@GwtCompatible(emulated=true)
public abstract class AbstractFuture<V>
  implements ListenableFuture<V>
{
  private static final AtomicHelper ATOMIC_HELPER;
  private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
  private static final Object NULL;
  private static final long SPIN_THRESHOLD_NANOS = 1000L;
  private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
  private volatile Listener listeners;
  private volatile Object value;
  private volatile Waiter waiters;
  
  static
  {
    try
    {
      localObject = new UnsafeAtomicHelper(null);
      ATOMIC_HELPER = (AtomicHelper)localObject;
      NULL = new Object();
      return;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          Object localObject = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
        }
        catch (Throwable localThrowable1)
        {
          log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", localThrowable2);
          log.log(Level.SEVERE, "SafeAtomicHelper is broken!", localThrowable1);
          SynchronizedHelper localSynchronizedHelper = new SynchronizedHelper(null);
        }
      }
    }
  }
  
  private static CancellationException cancellationExceptionWithCause(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
  
  private Listener clearListeners(Listener paramListener)
  {
    Listener localListener2;
    do
    {
      localListener2 = this.listeners;
    } while (!ATOMIC_HELPER.casListeners(this, localListener2, Listener.TOMBSTONE));
    Listener localListener1 = paramListener;
    for (paramListener = localListener2; paramListener != null; paramListener = localListener2)
    {
      localListener2 = paramListener.next;
      paramListener.next = localListener1;
      localListener1 = paramListener;
    }
    return localListener1;
  }
  
  private static void complete(AbstractFuture<?> paramAbstractFuture)
  {
    Object localObject2 = null;
    Object localObject1 = paramAbstractFuture;
    paramAbstractFuture = (AbstractFuture<?>)localObject2;
    ((AbstractFuture)localObject1).releaseWaiters();
    ((AbstractFuture)localObject1).afterDone();
    for (localObject1 = ((AbstractFuture)localObject1).clearListeners(paramAbstractFuture);; localObject1 = paramAbstractFuture)
    {
      if (localObject1 == null) {
        return;
      }
      paramAbstractFuture = ((Listener)localObject1).next;
      localObject2 = ((Listener)localObject1).task;
      if ((localObject2 instanceof SetFuture))
      {
        localObject2 = (SetFuture)localObject2;
        localObject1 = ((SetFuture)localObject2).owner;
        if (((AbstractFuture)localObject1).value != localObject2) {
          continue;
        }
        Object localObject3 = getFutureValue(((SetFuture)localObject2).future);
        if (!ATOMIC_HELPER.casValue((AbstractFuture)localObject1, localObject2, localObject3)) {
          continue;
        }
        break;
      }
      executeListener((Runnable)localObject2, ((Listener)localObject1).executor);
    }
  }
  
  private static void executeListener(Runnable paramRunnable, Executor paramExecutor)
  {
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.log(Level.SEVERE, "RuntimeException while executing runnable " + paramRunnable + " with executor " + paramExecutor, localRuntimeException);
    }
  }
  
  private V getDoneValue(Object paramObject)
    throws ExecutionException
  {
    if ((paramObject instanceof Cancellation)) {
      throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)paramObject).cause);
    }
    if ((paramObject instanceof Failure)) {
      throw new ExecutionException(((Failure)paramObject).exception);
    }
    Object localObject = paramObject;
    if (paramObject == NULL) {
      localObject = null;
    }
    return localObject;
  }
  
  private static Object getFutureValue(ListenableFuture<?> paramListenableFuture)
  {
    if ((paramListenableFuture instanceof TrustedFuture)) {
      paramListenableFuture = ((AbstractFuture)paramListenableFuture).value;
    }
    for (;;)
    {
      return paramListenableFuture;
      try
      {
        Object localObject = Futures.getDone(paramListenableFuture);
        paramListenableFuture = localObject;
        if (localObject == null)
        {
          paramListenableFuture = NULL;
          return paramListenableFuture;
        }
      }
      catch (ExecutionException paramListenableFuture)
      {
        return new Failure(paramListenableFuture.getCause());
      }
      catch (CancellationException paramListenableFuture)
      {
        return new Cancellation(false, paramListenableFuture);
      }
      catch (Throwable paramListenableFuture) {}
    }
    return new Failure(paramListenableFuture);
  }
  
  private void releaseWaiters()
  {
    Waiter localWaiter;
    do
    {
      localWaiter = this.waiters;
    } while (!ATOMIC_HELPER.casWaiters(this, localWaiter, Waiter.TOMBSTONE));
    while (localWaiter != null)
    {
      localWaiter.unpark();
      localWaiter = localWaiter.next;
    }
  }
  
  private void removeWaiter(Waiter paramWaiter)
  {
    paramWaiter.thread = null;
    paramWaiter = this.waiters;
    if (paramWaiter == Waiter.TOMBSTONE) {}
    label80:
    for (;;)
    {
      return;
      for (;;)
      {
        if (paramWaiter == null) {
          break label80;
        }
        Waiter localWaiter2 = paramWaiter.next;
        Waiter localWaiter1;
        if (paramWaiter.thread != null)
        {
          localWaiter1 = paramWaiter;
          paramWaiter = localWaiter2;
        }
        else
        {
          if (localWaiter1 != null)
          {
            localWaiter1.next = localWaiter2;
            if (localWaiter1.thread == null) {
              break;
            }
          }
          while (ATOMIC_HELPER.casWaiters(this, paramWaiter, localWaiter2))
          {
            paramWaiter = localWaiter1;
            break;
          }
          break;
          localWaiter1 = null;
        }
      }
    }
  }
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
    Preconditions.checkNotNull(paramExecutor, "Executor was null.");
    Object localObject = this.listeners;
    if (localObject != Listener.TOMBSTONE)
    {
      Listener localListener2 = new Listener(paramRunnable, paramExecutor);
      Listener localListener1;
      do
      {
        localListener2.next = ((Listener)localObject);
        if (ATOMIC_HELPER.casListeners(this, (Listener)localObject, localListener2)) {
          return;
        }
        localListener1 = this.listeners;
        localObject = localListener1;
      } while (localListener1 != Listener.TOMBSTONE);
    }
    executeListener(paramRunnable, paramExecutor);
  }
  
  @Beta
  protected void afterDone() {}
  
  @CanIgnoreReturnValue
  public boolean cancel(boolean paramBoolean)
  {
    Object localObject2 = this.value;
    int i;
    Object localObject1;
    label41:
    Cancellation localCancellation;
    boolean bool;
    if (localObject2 == null)
    {
      i = 1;
      if ((i | localObject2 instanceof SetFuture) == 0) {
        break label201;
      }
      if (!GENERATE_CANCELLATION_CAUSES) {
        break label158;
      }
      localObject1 = new CancellationException("Future.cancel() was called.");
      localCancellation = new Cancellation(paramBoolean, (Throwable)localObject1);
      localObject1 = localObject2;
      bool = false;
      localObject2 = this;
    }
    label62:
    Object localObject3;
    label158:
    label178:
    do
    {
      if (ATOMIC_HELPER.casValue((AbstractFuture)localObject2, localObject1, localCancellation))
      {
        if (paramBoolean) {
          ((AbstractFuture)localObject2).interruptTask();
        }
        complete((AbstractFuture)localObject2);
        if ((localObject1 instanceof SetFuture))
        {
          localObject1 = ((SetFuture)localObject1).future;
          if ((localObject1 instanceof TrustedFuture))
          {
            localObject2 = (AbstractFuture)localObject1;
            localObject1 = ((AbstractFuture)localObject2).value;
            if (localObject1 == null) {}
            for (i = 1;; i = 0)
            {
              if ((i | localObject1 instanceof SetFuture) == 0) {
                break label178;
              }
              bool = true;
              break label62;
              i = 0;
              break;
              localObject1 = null;
              break label41;
            }
          }
          ((ListenableFuture)localObject1).cancel(paramBoolean);
        }
        return true;
      }
      localObject3 = ((AbstractFuture)localObject2).value;
      localObject1 = localObject3;
    } while ((localObject3 instanceof SetFuture));
    return bool;
    label201:
    return false;
  }
  
  @CanIgnoreReturnValue
  public V get()
    throws InterruptedException, ExecutionException
  {
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    Object localObject = this.value;
    int i;
    if (localObject != null)
    {
      i = 1;
      if ((localObject instanceof SetFuture)) {
        break label51;
      }
    }
    label51:
    for (int j = 1;; j = 0)
    {
      if ((i & j) == 0) {
        break label56;
      }
      return getDoneValue(localObject);
      i = 0;
      break;
    }
    label56:
    localObject = this.waiters;
    if (localObject != Waiter.TOMBSTONE)
    {
      Waiter localWaiter2 = new Waiter();
      label157:
      label160:
      Waiter localWaiter1;
      do
      {
        localWaiter2.setNext((Waiter)localObject);
        if (ATOMIC_HELPER.casWaiters(this, (Waiter)localObject, localWaiter2)) {
          for (;;)
          {
            LockSupport.park(this);
            if (Thread.interrupted())
            {
              removeWaiter(localWaiter2);
              throw new InterruptedException();
            }
            localObject = this.value;
            if (localObject != null)
            {
              i = 1;
              if ((localObject instanceof SetFuture)) {
                break label157;
              }
            }
            for (j = 1;; j = 0)
            {
              if ((i & j) == 0) {
                break label160;
              }
              return getDoneValue(localObject);
              i = 0;
              break;
            }
          }
        }
        localWaiter1 = this.waiters;
        localObject = localWaiter1;
      } while (localWaiter1 != Waiter.TOMBSTONE);
    }
    return getDoneValue(this.value);
  }
  
  @CanIgnoreReturnValue
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException, ExecutionException
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    paramTimeUnit = this.value;
    int i;
    if (paramTimeUnit != null)
    {
      i = 1;
      if ((paramTimeUnit instanceof SetFuture)) {
        break label62;
      }
    }
    label62:
    for (int j = 1;; j = 0)
    {
      if ((i & j) == 0) {
        break label68;
      }
      return getDoneValue(paramTimeUnit);
      i = 0;
      break;
    }
    label68:
    long l1;
    Waiter localWaiter2;
    if (paramLong > 0L)
    {
      l1 = System.nanoTime() + paramLong;
      if (paramLong < 1000L) {
        break label349;
      }
      paramTimeUnit = this.waiters;
      if (paramTimeUnit == Waiter.TOMBSTONE) {
        break label296;
      }
      localWaiter2 = new Waiter();
      localWaiter2.setNext(paramTimeUnit);
      if (!ATOMIC_HELPER.casWaiters(this, paramTimeUnit, localWaiter2)) {}
    }
    else
    {
      label202:
      label208:
      long l2;
      do
      {
        LockSupport.parkNanos(this, paramLong);
        if (Thread.interrupted())
        {
          removeWaiter(localWaiter2);
          throw new InterruptedException();
          l1 = 0L;
          break;
        }
        paramTimeUnit = this.value;
        if (paramTimeUnit != null)
        {
          i = 1;
          if ((paramTimeUnit instanceof SetFuture)) {
            break label202;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i & j) == 0) {
            break label208;
          }
          return getDoneValue(paramTimeUnit);
          i = 0;
          break;
        }
        l2 = l1 - System.nanoTime();
        paramLong = l2;
      } while (l2 >= 1000L);
      removeWaiter(localWaiter2);
      paramLong = l2;
    }
    label296:
    label311:
    label317:
    label349:
    for (;;)
    {
      if (paramLong > 0L)
      {
        paramTimeUnit = this.value;
        if (paramTimeUnit != null)
        {
          i = 1;
          label255:
          if ((paramTimeUnit instanceof SetFuture)) {
            break label311;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i & j) == 0) {
            break label317;
          }
          return getDoneValue(paramTimeUnit);
          Waiter localWaiter1 = this.waiters;
          paramTimeUnit = localWaiter1;
          if (localWaiter1 != Waiter.TOMBSTONE) {
            break;
          }
          return getDoneValue(this.value);
          i = 0;
          break label255;
        }
        if (Thread.interrupted()) {
          throw new InterruptedException();
        }
        paramLong = l1 - System.nanoTime();
      }
      else
      {
        throw new TimeoutException();
      }
    }
  }
  
  protected void interruptTask() {}
  
  public boolean isCancelled()
  {
    return this.value instanceof Cancellation;
  }
  
  public boolean isDone()
  {
    int j = 1;
    Object localObject = this.value;
    int i;
    if (localObject != null)
    {
      i = 1;
      if ((localObject instanceof SetFuture)) {
        break label29;
      }
    }
    for (;;)
    {
      return i & j;
      i = 0;
      break;
      label29:
      j = 0;
    }
  }
  
  final void maybePropagateCancellation(@Nullable Future<?> paramFuture)
  {
    if (paramFuture != null) {}
    for (int i = 1;; i = 0)
    {
      if ((i & isCancelled()) != 0) {
        paramFuture.cancel(wasInterrupted());
      }
      return;
    }
  }
  
  @CanIgnoreReturnValue
  protected boolean set(@Nullable V paramV)
  {
    Object localObject = paramV;
    if (paramV == null) {
      localObject = NULL;
    }
    if (ATOMIC_HELPER.casValue(this, null, localObject))
    {
      complete(this);
      return true;
    }
    return false;
  }
  
  @CanIgnoreReturnValue
  protected boolean setException(Throwable paramThrowable)
  {
    paramThrowable = new Failure((Throwable)Preconditions.checkNotNull(paramThrowable));
    if (ATOMIC_HELPER.casValue(this, null, paramThrowable))
    {
      complete(this);
      return true;
    }
    return false;
  }
  
  @Beta
  @CanIgnoreReturnValue
  protected boolean setFuture(ListenableFuture<? extends V> paramListenableFuture)
  {
    Preconditions.checkNotNull(paramListenableFuture);
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramListenableFuture.isDone())
      {
        paramListenableFuture = getFutureValue(paramListenableFuture);
        if (ATOMIC_HELPER.casValue(this, null, paramListenableFuture))
        {
          complete(this);
          return true;
        }
        return false;
      }
      localObject1 = new SetFuture(this, paramListenableFuture);
      if (ATOMIC_HELPER.casValue(this, null, localObject1)) {
        for (;;)
        {
          try
          {
            paramListenableFuture.addListener((Runnable)localObject1, MoreExecutors.directExecutor());
            return true;
          }
          catch (Throwable paramListenableFuture) {}
          try
          {
            paramListenableFuture = new Failure(paramListenableFuture);
            ATOMIC_HELPER.casValue(this, localObject1, paramListenableFuture);
          }
          catch (Throwable paramListenableFuture)
          {
            for (;;)
            {
              paramListenableFuture = Failure.FALLBACK_INSTANCE;
            }
          }
        }
      }
      localObject1 = this.value;
    }
    if ((localObject1 instanceof Cancellation)) {
      paramListenableFuture.cancel(((Cancellation)localObject1).wasInterrupted);
    }
    return false;
  }
  
  final Throwable trustedGetException()
  {
    return ((Failure)this.value).exception;
  }
  
  protected final boolean wasInterrupted()
  {
    Object localObject = this.value;
    return ((localObject instanceof Cancellation)) && (((Cancellation)localObject).wasInterrupted);
  }
  
  static abstract class AtomicHelper
  {
    abstract boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2);
    
    abstract boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2);
    
    abstract boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
    
    abstract void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
    
    abstract void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread);
  }
  
  static final class Cancellation
  {
    @Nullable
    final Throwable cause;
    final boolean wasInterrupted;
    
    Cancellation(boolean paramBoolean, @Nullable Throwable paramThrowable)
    {
      this.wasInterrupted = paramBoolean;
      this.cause = paramThrowable;
    }
  }
  
  static final class Failure
  {
    static final Failure FALLBACK_INSTANCE = new Failure(new AbstractFuture.Failure.1("Failure occurred while trying to finish a future."));
    final Throwable exception;
    
    Failure(Throwable paramThrowable)
    {
      this.exception = ((Throwable)Preconditions.checkNotNull(paramThrowable));
    }
  }
  
  static final class Listener
  {
    static final Listener TOMBSTONE = new Listener(null, null);
    final Executor executor;
    @Nullable
    Listener next;
    final Runnable task;
    
    Listener(Runnable paramRunnable, Executor paramExecutor)
    {
      this.task = paramRunnable;
      this.executor = paramExecutor;
    }
  }
  
  static final class SafeAtomicHelper
    extends AbstractFuture.AtomicHelper
  {
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> listenersUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> waiterNextUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> waiterThreadUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> waitersUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> paramAtomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> paramAtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> paramAtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> paramAtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Object> paramAtomicReferenceFieldUpdater4)
    {
      super();
      this.waiterThreadUpdater = paramAtomicReferenceFieldUpdater;
      this.waiterNextUpdater = paramAtomicReferenceFieldUpdater1;
      this.waitersUpdater = paramAtomicReferenceFieldUpdater2;
      this.listenersUpdater = paramAtomicReferenceFieldUpdater3;
      this.valueUpdater = paramAtomicReferenceFieldUpdater4;
    }
    
    boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      return this.listenersUpdater.compareAndSet(paramAbstractFuture, paramListener1, paramListener2);
    }
    
    boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      return this.valueUpdater.compareAndSet(paramAbstractFuture, paramObject1, paramObject2);
    }
    
    boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      return this.waitersUpdater.compareAndSet(paramAbstractFuture, paramWaiter1, paramWaiter2);
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      this.waiterNextUpdater.lazySet(paramWaiter1, paramWaiter2);
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      this.waiterThreadUpdater.lazySet(paramWaiter, paramThread);
    }
  }
  
  static final class SetFuture<V>
    implements Runnable
  {
    final ListenableFuture<? extends V> future;
    final AbstractFuture<V> owner;
    
    SetFuture(AbstractFuture<V> paramAbstractFuture, ListenableFuture<? extends V> paramListenableFuture)
    {
      this.owner = paramAbstractFuture;
      this.future = paramListenableFuture;
    }
    
    public void run()
    {
      if (this.owner.value != this) {}
      Object localObject;
      do
      {
        return;
        localObject = AbstractFuture.getFutureValue(this.future);
      } while (!AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, localObject));
      AbstractFuture.complete(this.owner);
    }
  }
  
  static final class SynchronizedHelper
    extends AbstractFuture.AtomicHelper
  {
    private SynchronizedHelper()
    {
      super();
    }
    
    boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      try
      {
        if (paramAbstractFuture.listeners == paramListener1)
        {
          AbstractFuture.access$802(paramAbstractFuture, paramListener2);
          return true;
        }
        return false;
      }
      finally {}
    }
    
    boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      try
      {
        if (paramAbstractFuture.value == paramObject1)
        {
          AbstractFuture.access$302(paramAbstractFuture, paramObject2);
          return true;
        }
        return false;
      }
      finally {}
    }
    
    boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      try
      {
        if (paramAbstractFuture.waiters == paramWaiter1)
        {
          AbstractFuture.access$702(paramAbstractFuture, paramWaiter2);
          return true;
        }
        return false;
      }
      finally {}
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      paramWaiter1.next = paramWaiter2;
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      paramWaiter.thread = paramThread;
    }
  }
  
  static abstract class TrustedFuture<V>
    extends AbstractFuture<V>
  {
    public final void addListener(Runnable paramRunnable, Executor paramExecutor)
    {
      super.addListener(paramRunnable, paramExecutor);
    }
    
    @CanIgnoreReturnValue
    public final boolean cancel(boolean paramBoolean)
    {
      return super.cancel(paramBoolean);
    }
    
    @CanIgnoreReturnValue
    public final V get()
      throws InterruptedException, ExecutionException
    {
      return super.get();
    }
    
    @CanIgnoreReturnValue
    public final V get(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException, ExecutionException, TimeoutException
    {
      return super.get(paramLong, paramTimeUnit);
    }
    
    public final boolean isCancelled()
    {
      return super.isCancelled();
    }
    
    public final boolean isDone()
    {
      return super.isDone();
    }
  }
  
  static final class UnsafeAtomicHelper
    extends AbstractFuture.AtomicHelper
  {
    static final long LISTENERS_OFFSET;
    static final Unsafe UNSAFE;
    static final long VALUE_OFFSET;
    static final long WAITERS_OFFSET;
    static final long WAITER_NEXT_OFFSET;
    static final long WAITER_THREAD_OFFSET;
    
    static
    {
      try
      {
        localUnsafe1 = Unsafe.getUnsafe();
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          try
          {
            Unsafe localUnsafe1;
            WAITERS_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
            LISTENERS_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
            VALUE_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
            WAITER_THREAD_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("thread"));
            WAITER_NEXT_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("next"));
            UNSAFE = localUnsafe1;
            return;
          }
          catch (Exception localException)
          {
            Throwables.throwIfUnchecked(localException);
            throw new RuntimeException(localException);
          }
          localSecurityException = localSecurityException;
          try
          {
            Unsafe localUnsafe2 = (Unsafe)AccessController.doPrivileged(new AbstractFuture.UnsafeAtomicHelper.1());
          }
          catch (PrivilegedActionException localPrivilegedActionException)
          {
            throw new RuntimeException("Could not initialize intrinsics", localPrivilegedActionException.getCause());
          }
        }
      }
    }
    
    private UnsafeAtomicHelper()
    {
      super();
    }
    
    boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      return UNSAFE.compareAndSwapObject(paramAbstractFuture, LISTENERS_OFFSET, paramListener1, paramListener2);
    }
    
    boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      return UNSAFE.compareAndSwapObject(paramAbstractFuture, VALUE_OFFSET, paramObject1, paramObject2);
    }
    
    boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      return UNSAFE.compareAndSwapObject(paramAbstractFuture, WAITERS_OFFSET, paramWaiter1, paramWaiter2);
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      UNSAFE.putObject(paramWaiter1, WAITER_NEXT_OFFSET, paramWaiter2);
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      UNSAFE.putObject(paramWaiter, WAITER_THREAD_OFFSET, paramThread);
    }
  }
  
  static final class Waiter
  {
    static final Waiter TOMBSTONE = new Waiter(false);
    @Nullable
    volatile Waiter next;
    @Nullable
    volatile Thread thread;
    
    Waiter()
    {
      AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
    
    Waiter(boolean paramBoolean) {}
    
    void setNext(Waiter paramWaiter)
    {
      AbstractFuture.ATOMIC_HELPER.putNext(this, paramWaiter);
    }
    
    void unpark()
    {
      Thread localThread = this.thread;
      if (localThread != null)
      {
        this.thread = null;
        LockSupport.unpark(localThread);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractFuture
 * JD-Core Version:    0.7.0.1
 */