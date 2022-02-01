package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract interface CoroutineContext
{
  public abstract <R> R fold(R paramR, @NotNull Function2<? super R, ? super Element, ? extends R> paramFunction2);
  
  @Nullable
  public abstract <E extends Element> E get(@NotNull Key<E> paramKey);
  
  @NotNull
  public abstract CoroutineContext minusKey(@NotNull Key<?> paramKey);
  
  @NotNull
  public abstract CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext);
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
  public static final class DefaultImpls
  {
    @NotNull
    public static CoroutineContext plus(CoroutineContext paramCoroutineContext1, @NotNull CoroutineContext paramCoroutineContext2)
    {
      Intrinsics.checkParameterIsNotNull(paramCoroutineContext2, "context");
      if (paramCoroutineContext2 == EmptyCoroutineContext.INSTANCE) {
        return paramCoroutineContext1;
      }
      return (CoroutineContext)paramCoroutineContext2.fold(paramCoroutineContext1, (Function2)CoroutineContext.plus.1.INSTANCE);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static abstract interface Element
    extends CoroutineContext
  {
    public abstract <R> R fold(R paramR, @NotNull Function2<? super R, ? super Element, ? extends R> paramFunction2);
    
    @Nullable
    public abstract <E extends Element> E get(@NotNull CoroutineContext.Key<E> paramKey);
    
    @NotNull
    public abstract CoroutineContext.Key<?> getKey();
    
    @NotNull
    public abstract CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey);
    
    @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
    public static final class DefaultImpls
    {
      public static <R> R fold(CoroutineContext.Element paramElement, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
      {
        Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
        return paramFunction2.invoke(paramR, paramElement);
      }
      
      @Nullable
      public static <E extends CoroutineContext.Element> E get(CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<E> paramKey)
      {
        Intrinsics.checkParameterIsNotNull(paramKey, "key");
        if (Intrinsics.areEqual(paramElement.getKey(), paramKey))
        {
          paramKey = paramElement;
          if (paramElement == null) {
            throw new TypeCastException("null cannot be cast to non-null type E");
          }
        }
        else
        {
          paramKey = null;
        }
        return paramKey;
      }
      
      @NotNull
      public static CoroutineContext minusKey(CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<?> paramKey)
      {
        Intrinsics.checkParameterIsNotNull(paramKey, "key");
        if (Intrinsics.areEqual(paramElement.getKey(), paramKey)) {
          return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        return (CoroutineContext)paramElement;
      }
      
      @NotNull
      public static CoroutineContext plus(CoroutineContext.Element paramElement, @NotNull CoroutineContext paramCoroutineContext)
      {
        Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
        return CoroutineContext.DefaultImpls.plus((CoroutineContext)paramElement, paramCoroutineContext);
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static abstract interface Key<E extends CoroutineContext.Element> {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.CoroutineContext
 * JD-Core Version:    0.7.0.1
 */