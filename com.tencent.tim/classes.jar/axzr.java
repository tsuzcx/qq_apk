import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class axzr<K, V>
  extends axzs<K, V>
{
  private HashMap<K, axzs.c<K, V>> mHashMap = new HashMap();
  
  protected axzs.c<K, V> a(K paramK)
  {
    return (axzs.c)this.mHashMap.get(paramK);
  }
  
  public Map.Entry<K, V> ceil(K paramK)
  {
    if (contains(paramK)) {
      return ((axzs.c)this.mHashMap.get(paramK)).d;
    }
    return null;
  }
  
  public boolean contains(K paramK)
  {
    return this.mHashMap.containsKey(paramK);
  }
  
  public V putIfAbsent(@NonNull K paramK, @NonNull V paramV)
  {
    axzs.c localc = a(paramK);
    if (localc != null) {
      return localc.mValue;
    }
    this.mHashMap.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public V remove(@NonNull K paramK)
  {
    Object localObject = super.remove(paramK);
    this.mHashMap.remove(paramK);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzr
 * JD-Core Version:    0.7.0.1
 */