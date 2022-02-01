package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class SequenceBuilderIterator<T>
  extends SequenceScope<T>
  implements Iterator<T>, Continuation<Unit>, KMappedMarker
{
  private Iterator<? extends T> nextIterator;
  @Nullable
  private Continuation<? super Unit> nextStep;
  private T nextValue;
  private int state;
  
  private final Throwable exceptionalState()
  {
    switch (this.state)
    {
    default: 
      return (Throwable)new IllegalStateException("Unexpected state of the iterator: " + this.state);
    case 4: 
      return (Throwable)new NoSuchElementException();
    }
    return (Throwable)new IllegalStateException("Iterator has failed.");
  }
  
  private final T nextNotReady()
  {
    if (!hasNext()) {
      throw ((Throwable)new NoSuchElementException());
    }
    return next();
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
  }
  
  @Nullable
  public final Continuation<Unit> getNextStep()
  {
    return this.nextStep;
  }
  
  public boolean hasNext()
  {
    for (;;)
    {
      Object localObject;
      switch (this.state)
      {
      default: 
        throw exceptionalState();
      case 1: 
        localObject = this.nextIterator;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (((Iterator)localObject).hasNext())
        {
          this.state = 2;
          return true;
        }
        this.nextIterator = ((Iterator)null);
      case 0: 
        this.state = 5;
        localObject = this.nextStep;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        this.nextStep = ((Continuation)null);
        Unit localUnit = Unit.INSTANCE;
        Result.Companion localCompanion = Result.Companion;
        ((Continuation)localObject).resumeWith(Result.constructor-impl(localUnit));
      }
    }
    return false;
    return true;
  }
  
  public T next()
  {
    switch (this.state)
    {
    default: 
      throw exceptionalState();
    case 0: 
    case 1: 
      return nextNotReady();
    case 2: 
      this.state = 1;
      localObject = this.nextIterator;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return ((Iterator)localObject).next();
    }
    this.state = 0;
    Object localObject = this.nextValue;
    this.nextValue = null;
    return localObject;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    ResultKt.throwOnFailure(paramObject);
    this.state = 4;
  }
  
  public final void setNextStep(@Nullable Continuation<? super Unit> paramContinuation)
  {
    this.nextStep = paramContinuation;
  }
  
  @Nullable
  public Object yield(T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    this.nextValue = paramT;
    this.state = 3;
    this.nextStep = paramContinuation;
    paramT = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (paramT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    if (paramT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramT;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public Object yieldAll(@NotNull Iterator<? extends T> paramIterator, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (!paramIterator.hasNext()) {
      paramIterator = Unit.INSTANCE;
    }
    Object localObject;
    do
    {
      return paramIterator;
      this.nextIterator = paramIterator;
      this.state = 2;
      this.nextStep = paramContinuation;
      localObject = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      if (localObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(paramContinuation);
      }
      paramIterator = localObject;
    } while (localObject == IntrinsicsKt.getCOROUTINE_SUSPENDED());
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.sequences.SequenceBuilderIterator
 * JD-Core Version:    0.7.0.1
 */