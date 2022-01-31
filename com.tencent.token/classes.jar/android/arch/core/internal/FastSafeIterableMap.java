package android.arch.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class FastSafeIterableMap
  extends SafeIterableMap
{
  private HashMap mHashMap = new HashMap();
  
  public Map.Entry ceil(Object paramObject)
  {
    if (contains(paramObject)) {
      return ((SafeIterableMap.Entry)this.mHashMap.get(paramObject)).mPrevious;
    }
    return null;
  }
  
  public boolean contains(Object paramObject)
  {
    return this.mHashMap.containsKey(paramObject);
  }
  
  protected SafeIterableMap.Entry get(Object paramObject)
  {
    return (SafeIterableMap.Entry)this.mHashMap.get(paramObject);
  }
  
  public Object putIfAbsent(@NonNull Object paramObject1, @NonNull Object paramObject2)
  {
    SafeIterableMap.Entry localEntry = get(paramObject1);
    if (localEntry != null) {
      return localEntry.mValue;
    }
    this.mHashMap.put(paramObject1, put(paramObject1, paramObject2));
    return null;
  }
  
  public Object remove(@NonNull Object paramObject)
  {
    Object localObject = super.remove(paramObject);
    this.mHashMap.remove(paramObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.core.internal.FastSafeIterableMap
 * JD-Core Version:    0.7.0.1
 */