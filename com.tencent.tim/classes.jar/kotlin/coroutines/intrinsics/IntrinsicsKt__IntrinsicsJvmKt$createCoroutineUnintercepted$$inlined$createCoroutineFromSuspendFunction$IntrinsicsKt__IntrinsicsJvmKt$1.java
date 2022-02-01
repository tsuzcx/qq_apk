package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
  extends RestrictedContinuationImpl
{
  private int label;
  
  public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(Continuation paramContinuation1, Continuation paramContinuation2, Function1 paramFunction1)
  {
    super(paramContinuation2);
  }
  
  @Nullable
  public Object invokeSuspend(@NotNull Object paramObject)
  {
    switch (this.label)
    {
    default: 
      throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
    case 0: 
      this.label = 1;
      ResultKt.throwOnFailure(paramObject);
      paramObject = (Continuation)this;
      Function1 localFunction1 = this.$this_createCoroutineUnintercepted$inlined;
      if (localFunction1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
      }
      return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localFunction1, 1)).invoke(paramObject);
    }
    this.label = 2;
    ResultKt.throwOnFailure(paramObject);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted..inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.1
 * JD-Core Version:    0.7.0.1
 */