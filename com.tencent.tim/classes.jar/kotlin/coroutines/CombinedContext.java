package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public final class CombinedContext
  implements Serializable, CoroutineContext
{
  private final CoroutineContext.Element element;
  private final CoroutineContext left;
  
  public CombinedContext(@NotNull CoroutineContext paramCoroutineContext, @NotNull CoroutineContext.Element paramElement)
  {
    this.left = paramCoroutineContext;
    this.element = paramElement;
  }
  
  private final boolean contains(CoroutineContext.Element paramElement)
  {
    return Intrinsics.areEqual(get(paramElement.getKey()), paramElement);
  }
  
  private final boolean containsAll(CombinedContext paramCombinedContext)
  {
    for (;;)
    {
      if (!contains(paramCombinedContext.element)) {
        return false;
      }
      paramCombinedContext = paramCombinedContext.left;
      if (!(paramCombinedContext instanceof CombinedContext)) {
        break;
      }
      paramCombinedContext = (CombinedContext)paramCombinedContext;
    }
    if (paramCombinedContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
    }
    return contains((CoroutineContext.Element)paramCombinedContext);
  }
  
  private final int size()
  {
    Object localObject = (CombinedContext)this;
    int i = 2;
    for (;;)
    {
      CoroutineContext localCoroutineContext = ((CombinedContext)localObject).left;
      localObject = localCoroutineContext;
      if (!(localCoroutineContext instanceof CombinedContext)) {
        localObject = null;
      }
      localObject = (CombinedContext)localObject;
      if (localObject == null) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  private final Object writeReplace()
  {
    int i = size();
    CoroutineContext[] arrayOfCoroutineContext = new CoroutineContext[i];
    Ref.IntRef localIntRef = new Ref.IntRef();
    localIntRef.element = 0;
    fold(Unit.INSTANCE, (Function2)new CombinedContext.writeReplace.1(arrayOfCoroutineContext, localIntRef));
    if (localIntRef.element == i) {}
    for (i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    return new Serialized(arrayOfCoroutineContext);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((CombinedContext)this == paramObject) || (((paramObject instanceof CombinedContext)) && (((CombinedContext)paramObject).size() == size()) && (((CombinedContext)paramObject).containsAll(this)));
  }
  
  public <R> R fold(R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return paramFunction2.invoke(this.left.fold(paramR, paramFunction2), this.element);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    for (Object localObject = (CombinedContext)this;; localObject = (CombinedContext)localObject)
    {
      CoroutineContext.Element localElement = ((CombinedContext)localObject).element.get(paramKey);
      if (localElement != null) {
        return localElement;
      }
      localObject = ((CombinedContext)localObject).left;
      if (!(localObject instanceof CombinedContext)) {
        break;
      }
    }
    return ((CoroutineContext)localObject).get(paramKey);
  }
  
  public int hashCode()
  {
    return this.left.hashCode() + this.element.hashCode();
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if (this.element.get(paramKey) != null) {
      return this.left;
    }
    paramKey = this.left.minusKey(paramKey);
    if (paramKey == this.left) {
      return (CoroutineContext)this;
    }
    if (paramKey == EmptyCoroutineContext.INSTANCE) {
      return (CoroutineContext)this.element;
    }
    return (CoroutineContext)new CombinedContext(paramKey, this.element);
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineContext.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  @NotNull
  public String toString()
  {
    return "[" + (String)fold("", (Function2)CombinedContext.toString.1.INSTANCE) + "]";
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static final class Serialized
    implements Serializable
  {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0L;
    @NotNull
    private final CoroutineContext[] elements;
    
    public Serialized(@NotNull CoroutineContext[] paramArrayOfCoroutineContext)
    {
      this.elements = paramArrayOfCoroutineContext;
    }
    
    private final Object readResolve()
    {
      CoroutineContext[] arrayOfCoroutineContext = this.elements;
      Object localObject = EmptyCoroutineContext.INSTANCE;
      int j = arrayOfCoroutineContext.length;
      int i = 0;
      while (i < j)
      {
        CoroutineContext localCoroutineContext = arrayOfCoroutineContext[i];
        localObject = ((CoroutineContext)localObject).plus(localCoroutineContext);
        i += 1;
      }
      return localObject;
    }
    
    @NotNull
    public final CoroutineContext[] getElements()
    {
      return this.elements;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
    public static final class Companion {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.CombinedContext
 * JD-Core Version:    0.7.0.1
 */