package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.collections.SlidingWindowKt$windowedIterator$1", f="SlidingWindow.kt", i={0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l={34, 40, 49, 55, 58}, m="invokeSuspend", n={"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, s={"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
final class SlidingWindowKt$windowedIterator$1
  extends RestrictedSuspendLambda
  implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object>
{
  int I$0;
  int I$1;
  int I$2;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  private SequenceScope p$;
  
  SlidingWindowKt$windowedIterator$1(int paramInt1, int paramInt2, Iterator paramIterator, boolean paramBoolean1, boolean paramBoolean2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, paramContinuation);
    SequenceScope localSequenceScope = (SequenceScope)paramObject;
    paramContinuation.p$ = ((SequenceScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    int n = 1;
    int m = 0;
    Object localObject5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int j;
    int i;
    Object localObject1;
    Object localObject2;
    int k;
    Object localObject3;
    switch (this.label)
    {
    default: 
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      j = RangesKt.coerceAtMost(this.$size, 1024);
      i = this.$step - this.$size;
      if (i >= 0)
      {
        localObject1 = new ArrayList(j);
        localObject2 = this.$iterator;
        k = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (k > 0)
          {
            m = k - 1;
            k = j;
            j = i;
            i = m;
          }
        }
      }
      break;
    }
    for (;;)
    {
      m = i;
      i = j;
      j = k;
      k = m;
      break;
      ((ArrayList)localObject1).add(localObject3);
      if (((ArrayList)localObject1).size() == this.$size)
      {
        this.L$0 = paramObject;
        this.I$0 = j;
        this.I$1 = i;
        this.L$1 = localObject1;
        this.I$2 = k;
        this.L$2 = localObject3;
        this.L$3 = localObject2;
        this.label = 1;
        localObject3 = localObject2;
        Object localObject4 = localObject1;
        localObject2 = paramObject;
        if (paramObject.yield(localObject1, this) == localObject5)
        {
          return localObject5;
          localObject3 = (Iterator)this.L$3;
          localObject1 = this.L$2;
          i = this.I$2;
          localObject4 = (ArrayList)this.L$1;
          i = this.I$1;
          j = this.I$0;
          localObject2 = (SequenceScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
        }
        if (this.$reuseBuffer) {
          ((ArrayList)localObject4).clear();
        }
        for (;;)
        {
          paramObject = localObject2;
          k = j;
          j = i;
          localObject2 = localObject3;
          localObject1 = localObject4;
          break;
          localObject4 = new ArrayList(this.$size);
        }
        if (!((Collection)localObject1).isEmpty()) {
          m = n;
        }
        while ((m != 0) && ((this.$partialWindows) || (((ArrayList)localObject1).size() == this.$size)))
        {
          this.L$0 = paramObject;
          this.I$0 = j;
          this.I$1 = i;
          this.L$1 = localObject1;
          this.I$2 = k;
          this.label = 2;
          if (paramObject.yield(localObject1, this) == localObject5)
          {
            return localObject5;
            m = 0;
            continue;
            i = this.I$2;
            localObject1 = (ArrayList)this.L$1;
            i = this.I$1;
            i = this.I$0;
            localObject1 = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
          }
        }
        return Unit.INSTANCE;
        localObject3 = new RingBuffer(j);
        localObject2 = this.$iterator;
        k = i;
        localObject1 = paramObject;
        i = j;
        j = k;
        paramObject = localObject3;
        label522:
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = ((Iterator)localObject2).next();
          paramObject.add(localObject4);
          if (paramObject.isFull()) {
            if (paramObject.size() < this.$size)
            {
              paramObject = paramObject.expanded(this.$size);
            }
            else
            {
              if (this.$reuseBuffer) {}
              for (localObject3 = (List)paramObject;; localObject3 = (List)new ArrayList((Collection)paramObject))
              {
                this.L$0 = localObject1;
                this.I$0 = i;
                this.I$1 = j;
                this.L$1 = paramObject;
                this.L$2 = localObject4;
                this.L$3 = localObject2;
                this.label = 3;
                if (((SequenceScope)localObject1).yield(localObject3, this) != localObject5) {
                  break;
                }
                return localObject5;
              }
              localObject1 = (Iterator)this.L$3;
              localObject2 = this.L$2;
              localObject2 = (RingBuffer)this.L$1;
              i = this.I$1;
              j = this.I$0;
              localObject3 = (SequenceScope)this.L$0;
              ResultKt.throwOnFailure(paramObject);
            }
          }
        }
        for (paramObject = localObject3;; paramObject = localObject3)
        {
          ((RingBuffer)localObject2).removeFirst(this.$step);
          k = j;
          localObject3 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject1;
          j = i;
          i = k;
          localObject1 = localObject3;
          break label522;
          if (!this.$partialWindows) {
            break;
          }
          k = j;
          j = i;
          i = k;
          label762:
          if (paramObject.size() > this.$step)
          {
            if (this.$reuseBuffer) {}
            for (localObject2 = (List)paramObject;; localObject2 = (List)new ArrayList((Collection)paramObject))
            {
              this.L$0 = localObject1;
              this.I$0 = j;
              this.I$1 = i;
              this.L$1 = paramObject;
              this.label = 4;
              if (((SequenceScope)localObject1).yield(localObject2, this) != localObject5) {
                break;
              }
              return localObject5;
            }
            localObject2 = (RingBuffer)this.L$1;
            i = this.I$1;
            j = this.I$0;
            localObject1 = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            paramObject = localObject2;
          }
          for (;;)
          {
            paramObject.removeFirst(this.$step);
            break label762;
            k = m;
            if (!((Collection)paramObject).isEmpty()) {
              k = 1;
            }
            if (k == 0) {
              break;
            }
            this.L$0 = localObject1;
            this.I$0 = j;
            this.I$1 = i;
            this.L$1 = paramObject;
            this.label = 5;
            if (((SequenceScope)localObject1).yield(paramObject, this) != localObject5) {
              break;
            }
            return localObject5;
            localObject1 = (RingBuffer)this.L$1;
            i = this.I$1;
            i = this.I$0;
            localObject1 = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            break;
          }
          k = i;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramObject;
          i = j;
          j = k;
        }
      }
      m = j;
      j = i;
      i = k;
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.SlidingWindowKt.windowedIterator.1
 * JD-Core Version:    0.7.0.1
 */