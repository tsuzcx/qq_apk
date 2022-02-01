package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/experimental/Continuation;", "T", "continuation", "Key", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract interface ContinuationInterceptor
  extends CoroutineContext.Element
{
  public static final Key Key = Key.$$INSTANCE;
  
  @NotNull
  public abstract <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> paramContinuation);
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
  public static final class DefaultImpls
  {
    public static <R> R fold(ContinuationInterceptor paramContinuationInterceptor, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
    {
      Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
      return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)paramContinuationInterceptor, paramR, paramFunction2);
    }
    
    @Nullable
    public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext.Key<E> paramKey)
    {
      Intrinsics.checkParameterIsNotNull(paramKey, "key");
      return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)paramContinuationInterceptor, paramKey);
    }
    
    @NotNull
    public static CoroutineContext minusKey(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext.Key<?> paramKey)
    {
      Intrinsics.checkParameterIsNotNull(paramKey, "key");
      return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)paramContinuationInterceptor, paramKey);
    }
    
    @NotNull
    public static CoroutineContext plus(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext paramCoroutineContext)
    {
      Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
      return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)paramContinuationInterceptor, paramCoroutineContext);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/ContinuationInterceptor$Key;", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "()V", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
  public static final class Key
    implements CoroutineContext.Key<ContinuationInterceptor>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.experimental.ContinuationInterceptor
 * JD-Core Version:    0.7.0.1
 */