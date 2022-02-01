package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractCollection<E>
  implements Collection<E>, KMappedMarker
{
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    if (((this instanceof Collection)) && (((Collection)this).isEmpty())) {
      return false;
    }
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      if (Intrinsics.areEqual(localIterator.next(), paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (((Collection)paramCollection).isEmpty()) {
      return true;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public abstract int getSize();
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  @NotNull
  public abstract Iterator<E> iterator();
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  @NotNull
  public Object[] toArray()
  {
    return CollectionToArray.toArray((Collection)this);
  }
  
  @NotNull
  public <T> T[] toArray(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "array");
    paramArrayOfT = CollectionToArray.toArray((Collection)this, paramArrayOfT);
    if (paramArrayOfT == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return paramArrayOfT;
  }
  
  @NotNull
  public String toString()
  {
    return CollectionsKt.joinToString$default(this, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, (Function1)new AbstractCollection.toString.1(this), 24, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.AbstractCollection
 * JD-Core Version:    0.7.0.1
 */