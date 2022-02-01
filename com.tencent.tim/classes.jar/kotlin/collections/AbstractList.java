package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractList<E>
  extends AbstractCollection<E>
  implements List<E>, KMappedMarker
{
  public static final Companion Companion = new Companion(null);
  
  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (AbstractList)this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    return Companion.orderedEquals$kotlin_stdlib((Collection)this, (Collection)paramObject);
  }
  
  public abstract E get(int paramInt);
  
  public abstract int getSize();
  
  public int hashCode()
  {
    return Companion.orderedHashCode$kotlin_stdlib((Collection)this);
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      if (Intrinsics.areEqual(localIterator.next(), paramObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @NotNull
  public Iterator<E> iterator()
  {
    return (Iterator)new IteratorImpl();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    ListIterator localListIterator = listIterator(size());
    while (localListIterator.hasPrevious()) {
      if (Intrinsics.areEqual(localListIterator.previous(), paramObject)) {
        return localListIterator.nextIndex();
      }
    }
    return -1;
  }
  
  @NotNull
  public ListIterator<E> listIterator()
  {
    return (ListIterator)new ListIteratorImpl(0);
  }
  
  @NotNull
  public ListIterator<E> listIterator(int paramInt)
  {
    return (ListIterator)new ListIteratorImpl(paramInt);
  }
  
  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  @NotNull
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return (List)new SubList(this, paramInt1, paramInt2);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final void checkBoundsIndexes$kotlin_stdlib(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt1 < 0) || (paramInt2 > paramInt3)) {
        throw ((Throwable)new IndexOutOfBoundsException("startIndex: " + paramInt1 + ", endIndex: " + paramInt2 + ", size: " + paramInt3));
      }
      if (paramInt1 > paramInt2) {
        throw ((Throwable)new IllegalArgumentException("startIndex: " + paramInt1 + " > endIndex: " + paramInt2));
      }
    }
    
    public final void checkElementIndex$kotlin_stdlib(int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
        throw ((Throwable)new IndexOutOfBoundsException("index: " + paramInt1 + ", size: " + paramInt2));
      }
    }
    
    public final void checkPositionIndex$kotlin_stdlib(int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt1 > paramInt2)) {
        throw ((Throwable)new IndexOutOfBoundsException("index: " + paramInt1 + ", size: " + paramInt2));
      }
    }
    
    public final void checkRangeIndexes$kotlin_stdlib(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt1 < 0) || (paramInt2 > paramInt3)) {
        throw ((Throwable)new IndexOutOfBoundsException("fromIndex: " + paramInt1 + ", toIndex: " + paramInt2 + ", size: " + paramInt3));
      }
      if (paramInt1 > paramInt2) {
        throw ((Throwable)new IllegalArgumentException("fromIndex: " + paramInt1 + " > toIndex: " + paramInt2));
      }
    }
    
    public final boolean orderedEquals$kotlin_stdlib(@NotNull Collection<?> paramCollection1, @NotNull Collection<?> paramCollection2)
    {
      Intrinsics.checkParameterIsNotNull(paramCollection1, "c");
      Intrinsics.checkParameterIsNotNull(paramCollection2, "other");
      if (paramCollection1.size() != paramCollection2.size()) {
        return false;
      }
      paramCollection2 = paramCollection2.iterator();
      paramCollection1 = paramCollection1.iterator();
      while (paramCollection1.hasNext()) {
        if ((Intrinsics.areEqual(paramCollection1.next(), paramCollection2.next()) ^ true)) {
          return false;
        }
      }
      return true;
    }
    
    public final int orderedHashCode$kotlin_stdlib(@NotNull Collection<?> paramCollection)
    {
      Intrinsics.checkParameterIsNotNull(paramCollection, "c");
      int i = 1;
      paramCollection = paramCollection.iterator();
      if (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (localObject != null) {}
        for (int j = localObject.hashCode();; j = 0)
        {
          i = j + i * 31;
          break;
        }
      }
      return i;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  class IteratorImpl
    implements Iterator<E>, KMappedMarker
  {
    private int index;
    
    protected final int getIndex()
    {
      return this.index;
    }
    
    public boolean hasNext()
    {
      return this.index < this.this$0.size();
    }
    
    public E next()
    {
      if (!hasNext()) {
        throw ((Throwable)new NoSuchElementException());
      }
      AbstractList localAbstractList = this.this$0;
      int i = this.index;
      this.index = (i + 1);
      return localAbstractList.get(i);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    protected final void setIndex(int paramInt)
    {
      this.index = paramInt;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  class ListIteratorImpl
    extends AbstractList<E>.IteratorImpl
    implements ListIterator<E>, KMappedMarker
  {
    public ListIteratorImpl()
    {
      super();
      int i;
      AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, AbstractList.this.size());
      setIndex(i);
    }
    
    public void add(E paramE)
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public boolean hasPrevious()
    {
      return getIndex() > 0;
    }
    
    public int nextIndex()
    {
      return getIndex();
    }
    
    public E previous()
    {
      if (!hasPrevious()) {
        throw ((Throwable)new NoSuchElementException());
      }
      AbstractList localAbstractList = AbstractList.this;
      setIndex(getIndex() - 1);
      return localAbstractList.get(getIndex());
    }
    
    public int previousIndex()
    {
      return getIndex() - 1;
    }
    
    public void set(E paramE)
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static final class SubList<E>
    extends AbstractList<E>
    implements RandomAccess
  {
    private int _size;
    private final int fromIndex;
    private final AbstractList<E> list;
    
    public SubList(@NotNull AbstractList<? extends E> paramAbstractList, int paramInt1, int paramInt2)
    {
      this.list = paramAbstractList;
      this.fromIndex = paramInt1;
      AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(this.fromIndex, paramInt2, this.list.size());
      this._size = (paramInt2 - this.fromIndex);
    }
    
    public E get(int paramInt)
    {
      AbstractList.Companion.checkElementIndex$kotlin_stdlib(paramInt, this._size);
      return this.list.get(this.fromIndex + paramInt);
    }
    
    public int getSize()
    {
      return this._size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.AbstractList
 * JD-Core Version:    0.7.0.1
 */