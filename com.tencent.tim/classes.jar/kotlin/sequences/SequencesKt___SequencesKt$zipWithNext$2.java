package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f="_Sequences.kt", i={0, 0, 0, 0}, l={1863}, m="invokeSuspend", n={"$this$result", "iterator", "current", "next"}, s={"L$0", "L$1", "L$2", "L$3"})
final class SequencesKt___SequencesKt$zipWithNext$2
  extends RestrictedSuspendLambda
  implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  private SequenceScope p$;
  
  SequencesKt___SequencesKt$zipWithNext$2(Sequence paramSequence, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 2(this.$this_zipWithNext, this.$transform, paramContinuation);
    SequenceScope localSequenceScope = (SequenceScope)paramObject;
    paramContinuation.p$ = ((SequenceScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((2)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    SequenceScope localSequenceScope;
    Object localObject1;
    switch (this.label)
    {
    default: 
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localSequenceScope = this.p$;
      localObject1 = this.$this_zipWithNext.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        return Unit.INSTANCE;
      }
      paramObject = ((Iterator)localObject1).next();
    }
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        Object localObject4 = this.$transform.invoke(paramObject, localObject2);
        this.L$0 = localSequenceScope;
        this.L$1 = localObject1;
        this.L$2 = paramObject;
        this.L$3 = localObject2;
        this.label = 1;
        if (localSequenceScope.yield(localObject4, this) == localObject3)
        {
          return localObject3;
          localObject2 = this.L$3;
          localObject1 = this.L$2;
          localObject1 = (Iterator)this.L$1;
          localSequenceScope = (SequenceScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject2;
        }
      }
      else
      {
        return Unit.INSTANCE;
      }
      paramObject = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.zipWithNext.2
 * JD-Core Version:    0.7.0.1
 */