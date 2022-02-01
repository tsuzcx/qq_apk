package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"coroutineContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "coroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "processBareContinuationResume", "", "completion", "Lkotlin/coroutines/experimental/Continuation;", "block", "Lkotlin/Function0;", "", "suspendCoroutine", "T", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "createCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "kotlin-stdlib-coroutines"}, k=2, mv={1, 1, 16})
@JvmName(name="CoroutinesKt")
public final class CoroutinesKt
{
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T> Continuation<Unit> createCoroutine(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$createCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return (Continuation)new SafeContinuation(IntrinsicsKt.createCoroutineUnchecked(paramFunction1, paramContinuation), IntrinsicsKt.getCOROUTINE_SUSPENDED());
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <R, T> Continuation<Unit> createCoroutine(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$createCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return (Continuation)new SafeContinuation(IntrinsicsKt.createCoroutineUnchecked(paramFunction2, paramR, paramContinuation), IntrinsicsKt.getCOROUTINE_SUSPENDED());
  }
  
  private static final CoroutineContext getCoroutineContext()
  {
    throw ((Throwable)new NotImplementedError("Implemented as intrinsic"));
  }
  
  @InlineOnly
  private static final void processBareContinuationResume(Continuation<?> paramContinuation, Function0<? extends Object> paramFunction0)
  {
    try
    {
      paramFunction0 = paramFunction0.invoke();
      if (paramFunction0 != IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        if (paramContinuation != null) {
          break label37;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
      }
    }
    catch (Throwable paramFunction0)
    {
      paramContinuation.resumeWithException(paramFunction0);
    }
    return;
    label37:
    paramContinuation.resume(paramFunction0);
  }
  
  @SinceKotlin(version="1.1")
  public static final <T> void startCoroutine(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$startCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    IntrinsicsKt.createCoroutineUnchecked(paramFunction1, paramContinuation).resume(Unit.INSTANCE);
  }
  
  @SinceKotlin(version="1.1")
  public static final <R, T> void startCoroutine(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$startCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    IntrinsicsKt.createCoroutineUnchecked(paramFunction2, paramR, paramContinuation).resume(Unit.INSTANCE);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final <T> Object suspendCoroutine(@NotNull Function1<? super Continuation<? super T>, Unit> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    paramContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(paramContinuation));
    paramFunction1.invoke(paramContinuation);
    return paramContinuation.getResult();
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  private static final Object suspendCoroutine$$forInline(@NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    paramContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(paramContinuation));
    paramFunction1.invoke(paramContinuation);
    paramFunction1 = paramContinuation.getResult();
    InlineMarker.mark(1);
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.experimental.CoroutinesKt
 * JD-Core Version:    0.7.0.1
 */