package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class CoroutineContextImplKt
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <E extends CoroutineContext.Element> E getPolymorphicElement(@NotNull CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramElement, "$this$getPolymorphicElement");
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if ((paramKey instanceof AbstractCoroutineContextKey))
    {
      if (((AbstractCoroutineContextKey)paramKey).isSubKey$kotlin_stdlib(paramElement.getKey()))
      {
        paramKey = ((AbstractCoroutineContextKey)paramKey).tryCast$kotlin_stdlib(paramElement);
        paramElement = paramKey;
        if (!(paramKey instanceof CoroutineContext.Element)) {
          paramElement = null;
        }
        return paramElement;
      }
      return null;
    }
    if (paramElement.getKey() == paramKey) {}
    for (;;)
    {
      return paramElement;
      paramElement = null;
    }
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final CoroutineContext minusPolymorphicKey(@NotNull CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramElement, "$this$minusPolymorphicKey");
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if ((paramKey instanceof AbstractCoroutineContextKey))
    {
      if ((((AbstractCoroutineContextKey)paramKey).isSubKey$kotlin_stdlib(paramElement.getKey())) && (((AbstractCoroutineContextKey)paramKey).tryCast$kotlin_stdlib(paramElement) != null)) {
        return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
      }
      return (CoroutineContext)paramElement;
    }
    if (paramElement.getKey() == paramKey) {
      return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
    }
    return (CoroutineContext)paramElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.CoroutineContextImplKt
 * JD-Core Version:    0.7.0.1
 */