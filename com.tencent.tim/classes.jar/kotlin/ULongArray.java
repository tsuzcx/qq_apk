package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "storage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([JI)J", "hashCode", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "Lkotlin/collections/ULongIterator;", "iterator-impl", "([J)Lkotlin/collections/ULongIterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class ULongArray
  implements Collection<ULong>, KMappedMarker
{
  @NotNull
  private final long[] storage;
  
  @NotNull
  public static long[] constructor-impl(int paramInt)
  {
    return constructor-impl(new long[paramInt]);
  }
  
  @PublishedApi
  @NotNull
  public static long[] constructor-impl(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "storage");
    return paramArrayOfLong;
  }
  
  public static boolean contains-VKZWuLQ(long[] paramArrayOfLong, long paramLong)
  {
    return ArraysKt.contains(paramArrayOfLong, paramLong);
  }
  
  public static boolean containsAll-impl(long[] paramArrayOfLong, @NotNull Collection<ULong> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (((Collection)paramCollection).isEmpty()) {
      return true;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (((localObject instanceof ULong)) && (ArraysKt.contains(paramArrayOfLong, ((ULong)localObject).unbox-impl()))) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean equals-impl(long[] paramArrayOfLong, @Nullable Object paramObject)
  {
    return ((paramObject instanceof ULongArray)) && (Intrinsics.areEqual(paramArrayOfLong, ((ULongArray)paramObject).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2)
  {
    return Intrinsics.areEqual(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  public static final long get-impl(long[] paramArrayOfLong, int paramInt)
  {
    return ULong.constructor-impl(paramArrayOfLong[paramInt]);
  }
  
  public static int getSize-impl(long[] paramArrayOfLong)
  {
    return paramArrayOfLong.length;
  }
  
  public static int hashCode-impl(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null) {
      return Arrays.hashCode(paramArrayOfLong);
    }
    return 0;
  }
  
  public static boolean isEmpty-impl(long[] paramArrayOfLong)
  {
    return paramArrayOfLong.length == 0;
  }
  
  @NotNull
  public static ULongIterator iterator-impl(long[] paramArrayOfLong)
  {
    return (ULongIterator)new Iterator(paramArrayOfLong);
  }
  
  public static final void set-k8EXiF4(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    paramArrayOfLong[paramInt] = paramLong;
  }
  
  @NotNull
  public static String toString-impl(long[] paramArrayOfLong)
  {
    return "ULongArray(storage=" + Arrays.toString(paramArrayOfLong) + ")";
  }
  
  public boolean add-VKZWuLQ(long paramLong)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends ULong> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof ULong)) {
      return contains-VKZWuLQ(((ULong)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-VKZWuLQ(long paramLong)
  {
    return contains-VKZWuLQ(this.storage, paramLong);
  }
  
  public boolean containsAll(@NotNull Collection<? extends Object> paramCollection)
  {
    return containsAll-impl(this.storage, paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.storage, paramObject);
  }
  
  public int getSize()
  {
    return getSize-impl(this.storage);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.storage);
  }
  
  public boolean isEmpty()
  {
    return isEmpty-impl(this.storage);
  }
  
  @NotNull
  public ULongIterator iterator()
  {
    return iterator-impl(this.storage);
  }
  
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
  
  public Object[] toArray()
  {
    return CollectionToArray.toArray(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return CollectionToArray.toArray(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return toString-impl(this.storage);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "()J", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static final class Iterator
    extends ULongIterator
  {
    private final long[] array;
    private int index;
    
    public Iterator(@NotNull long[] paramArrayOfLong)
    {
      this.array = paramArrayOfLong;
    }
    
    public boolean hasNext()
    {
      return this.index < this.array.length;
    }
    
    public long nextULong()
    {
      if (this.index < this.array.length)
      {
        long[] arrayOfLong = this.array;
        int i = this.index;
        this.index = (i + 1);
        return ULong.constructor-impl(arrayOfLong[i]);
      }
      throw ((Throwable)new NoSuchElementException(String.valueOf(this.index)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ULongArray
 * JD-Core Version:    0.7.0.1
 */