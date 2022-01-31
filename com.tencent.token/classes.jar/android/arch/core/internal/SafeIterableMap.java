package android.arch.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SafeIterableMap
  implements Iterable
{
  private SafeIterableMap.Entry mEnd;
  private WeakHashMap mIterators = new WeakHashMap();
  private int mSize = 0;
  private SafeIterableMap.Entry mStart;
  
  public Iterator descendingIterator()
  {
    SafeIterableMap.DescendingIterator localDescendingIterator = new SafeIterableMap.DescendingIterator(this.mEnd, this.mStart);
    this.mIterators.put(localDescendingIterator, Boolean.valueOf(false));
    return localDescendingIterator;
  }
  
  public Map.Entry eldest()
  {
    return this.mStart;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof SafeIterableMap));
      localObject1 = (SafeIterableMap)paramObject;
      bool1 = bool2;
    } while (size() != ((SafeIterableMap)localObject1).size());
    paramObject = iterator();
    Object localObject1 = ((SafeIterableMap)localObject1).iterator();
    for (;;)
    {
      if ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)paramObject.next();
        Object localObject2 = ((Iterator)localObject1).next();
        if (localEntry == null)
        {
          bool1 = bool2;
          if (localObject2 != null) {
            break;
          }
        }
        if ((localEntry != null) && (!localEntry.equals(localObject2))) {
          return false;
        }
      }
    }
    if ((!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext())) {}
    for (boolean bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  protected SafeIterableMap.Entry get(Object paramObject)
  {
    for (SafeIterableMap.Entry localEntry = this.mStart;; localEntry = localEntry.mNext) {
      if ((localEntry == null) || (localEntry.mKey.equals(paramObject))) {
        return localEntry;
      }
    }
  }
  
  @NonNull
  public Iterator iterator()
  {
    SafeIterableMap.AscendingIterator localAscendingIterator = new SafeIterableMap.AscendingIterator(this.mStart, this.mEnd);
    this.mIterators.put(localAscendingIterator, Boolean.valueOf(false));
    return localAscendingIterator;
  }
  
  public SafeIterableMap.IteratorWithAdditions iteratorWithAdditions()
  {
    SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions(this, null);
    this.mIterators.put(localIteratorWithAdditions, Boolean.valueOf(false));
    return localIteratorWithAdditions;
  }
  
  public Map.Entry newest()
  {
    return this.mEnd;
  }
  
  protected SafeIterableMap.Entry put(@NonNull Object paramObject1, @NonNull Object paramObject2)
  {
    paramObject1 = new SafeIterableMap.Entry(paramObject1, paramObject2);
    this.mSize += 1;
    if (this.mEnd == null)
    {
      this.mStart = paramObject1;
      this.mEnd = this.mStart;
      return paramObject1;
    }
    this.mEnd.mNext = paramObject1;
    paramObject1.mPrevious = this.mEnd;
    this.mEnd = paramObject1;
    return paramObject1;
  }
  
  public Object putIfAbsent(@NonNull Object paramObject1, @NonNull Object paramObject2)
  {
    SafeIterableMap.Entry localEntry = get(paramObject1);
    if (localEntry != null) {
      return localEntry.mValue;
    }
    put(paramObject1, paramObject2);
    return null;
  }
  
  public Object remove(@NonNull Object paramObject)
  {
    paramObject = get(paramObject);
    if (paramObject == null) {
      return null;
    }
    this.mSize -= 1;
    if (!this.mIterators.isEmpty())
    {
      Iterator localIterator = this.mIterators.keySet().iterator();
      while (localIterator.hasNext()) {
        ((SafeIterableMap.SupportRemove)localIterator.next()).supportRemove(paramObject);
      }
    }
    if (paramObject.mPrevious != null)
    {
      paramObject.mPrevious.mNext = paramObject.mNext;
      if (paramObject.mNext == null) {
        break label134;
      }
      paramObject.mNext.mPrevious = paramObject.mPrevious;
    }
    for (;;)
    {
      paramObject.mNext = null;
      paramObject.mPrevious = null;
      return paramObject.mValue;
      this.mStart = paramObject.mNext;
      break;
      label134:
      this.mEnd = paramObject.mPrevious;
    }
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap
 * JD-Core Version:    0.7.0.1
 */