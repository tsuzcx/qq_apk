package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ContinuationMigration;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlin/coroutines/experimental/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContinuation", "()Lkotlin/coroutines/experimental/Continuation;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ContinuationMigration<T>
  implements kotlin.coroutines.Continuation<T>
{
  @NotNull
  private final CoroutineContext context;
  @NotNull
  private final kotlin.coroutines.experimental.Continuation<T> continuation;
  
  public ContinuationMigration(@NotNull kotlin.coroutines.experimental.Continuation<? super T> paramContinuation)
  {
    this.continuation = paramContinuation;
    this.context = CoroutinesMigrationKt.toCoroutineContext(this.continuation.getContext());
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.context;
  }
  
  @NotNull
  public final kotlin.coroutines.experimental.Continuation<T> getContinuation()
  {
    return this.continuation;
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    if (Result.isSuccess-impl(paramObject)) {
      this.continuation.resume(paramObject);
    }
    paramObject = Result.exceptionOrNull-impl(paramObject);
    if (paramObject != null) {
      this.continuation.resumeWithException(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ContinuationMigration
 * JD-Core Version:    0.7.0.1
 */