package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction2Migration;", "T1", "T2", "R", "Lkotlin/Function3;", "Lkotlin/coroutines/experimental/Continuation;", "", "function", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function3;)V", "getFunction", "()Lkotlin/jvm/functions/Function3;", "invoke", "t1", "t2", "continuation", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ExperimentalSuspendFunction2Migration<T1, T2, R>
  implements Function3<T1, T2, kotlin.coroutines.experimental.Continuation<? super R>, Object>
{
  @NotNull
  private final Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, Object> function;
  
  public ExperimentalSuspendFunction2Migration(@NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction3)
  {
    this.function = paramFunction3;
  }
  
  @NotNull
  public final Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, Object> getFunction()
  {
    return this.function;
  }
  
  @Nullable
  public Object invoke(T1 paramT1, T2 paramT2, @NotNull kotlin.coroutines.experimental.Continuation<? super R> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    return this.function.invoke(paramT1, paramT2, CoroutinesMigrationKt.toContinuation(paramContinuation));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ExperimentalSuspendFunction2Migration
 * JD-Core Version:    0.7.0.1
 */