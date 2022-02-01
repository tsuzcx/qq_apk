package android.arch.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class FastSafeIterableMap<K, V>
  extends SafeIterableMap<K, V>
{
  private HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap();
  
  public Map.Entry<K, V> ceil(K paramK)
  {
    if (contains(paramK)) {
      return ((SafeIterableMap.Entry)this.mHashMap.get(paramK)).mPrevious;
    }
    return null;
  }
  
  public boolean contains(K paramK)
  {
    return this.mHashMap.containsKey(paramK);
  }
  
  protected SafeIterableMap.Entry<K, V> get(K paramK)
  {
    return (SafeIterableMap.Entry)this.mHashMap.get(paramK);
  }
  
  public V putIfAbsent(@NonNull K paramK, @NonNull V paramV)
  {
    SafeIterableMap.Entry localEntry = get(paramK);
    if (localEntry != null) {
      return localEntry.mValue;
    }
    this.mHashMap.put(paramK, put(paramK, paramV));
    return null;
  }
  
  public V remove(@NonNull K paramK)
  {
    Object localObject = super.remove(paramK);
    this.mHashMap.remove(paramK);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.arch.core.internal.FastSafeIterableMap
 * JD-Core Version:    0.7.0.1
 */