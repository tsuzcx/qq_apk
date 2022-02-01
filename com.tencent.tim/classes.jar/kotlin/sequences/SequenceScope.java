package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/SequenceScope;", "T", "", "()V", "yield", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "elements", "", "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterator", "", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@RestrictsSuspension
public abstract class SequenceScope<T>
{
  @Nullable
  public abstract Object yield(T paramT, @NotNull Continuation<? super Unit> paramContinuation);
  
  @Nullable
  public final Object yieldAll(@NotNull Iterable<? extends T> paramIterable, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).isEmpty())) {
      paramIterable = Unit.INSTANCE;
    }
    do
    {
      return paramIterable;
      paramContinuation = yieldAll(paramIterable.iterator(), paramContinuation);
      paramIterable = paramContinuation;
    } while (paramContinuation == IntrinsicsKt.getCOROUTINE_SUSPENDED());
    return Unit.INSTANCE;
  }
  
  @Nullable
  public abstract Object yieldAll(@NotNull Iterator<? extends T> paramIterator, @NotNull Continuation<? super Unit> paramContinuation);
  
  @Nullable
  public final Object yieldAll(@NotNull Sequence<? extends T> paramSequence, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramSequence = yieldAll(paramSequence.iterator(), paramContinuation);
    if (paramSequence == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramSequence;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.sequences.SequenceScope
 * JD-Core Version:    0.7.0.1
 */