import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class axzs<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private axzs.c<K, V> a;
  private axzs.c<K, V> b;
  private WeakHashMap<axzs.f<K, V>, Boolean> mIterators = new WeakHashMap();
  private int mSize;
  
  protected axzs.c<K, V> a(K paramK)
  {
    for (axzs.c localc = this.a;; localc = localc.c) {
      if ((localc == null) || (localc.mKey.equals(paramK))) {
        return localc;
      }
    }
  }
  
  protected axzs.c<K, V> a(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new axzs.c(paramK, paramV);
    this.mSize += 1;
    if (this.b == null)
    {
      this.a = paramK;
      this.b = this.a;
      return paramK;
    }
    this.b.c = paramK;
    paramK.d = this.b;
    this.b = paramK;
    return paramK;
  }
  
  public axzs<K, V>.d a()
  {
    axzs.d locald = new axzs.d();
    this.mIterators.put(locald, Boolean.valueOf(false));
    return locald;
  }
  
  public Iterator<Map.Entry<K, V>> descendingIterator()
  {
    axzs.b localb = new axzs.b(this.b, this.a);
    this.mIterators.put(localb, Boolean.valueOf(false));
    return localb;
  }
  
  public Map.Entry<K, V> eldest()
  {
    return this.a;
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
      } while (!(paramObject instanceof axzs));
      localObject1 = (axzs)paramObject;
      bool1 = bool2;
    } while (size() != ((axzs)localObject1).size());
    paramObject = iterator();
    Object localObject1 = ((axzs)localObject1).iterator();
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
  
  @NonNull
  public Iterator<Map.Entry<K, V>> iterator()
  {
    axzs.a locala = new axzs.a(this.a, this.b);
    this.mIterators.put(locala, Boolean.valueOf(false));
    return locala;
  }
  
  public Map.Entry<K, V> newest()
  {
    return this.b;
  }
  
  public V putIfAbsent(@NonNull K paramK, @NonNull V paramV)
  {
    axzs.c localc = a(paramK);
    if (localc != null) {
      return localc.mValue;
    }
    a(paramK, paramV);
    return null;
  }
  
  public V remove(@NonNull K paramK)
  {
    paramK = a(paramK);
    if (paramK == null) {
      return null;
    }
    this.mSize -= 1;
    if (!this.mIterators.isEmpty())
    {
      Iterator localIterator = this.mIterators.keySet().iterator();
      while (localIterator.hasNext()) {
        ((axzs.f)localIterator.next()).a(paramK);
      }
    }
    if (paramK.d != null)
    {
      paramK.d.c = paramK.c;
      if (paramK.c == null) {
        break label134;
      }
      paramK.c.d = paramK.d;
    }
    for (;;)
    {
      paramK.c = null;
      paramK.d = null;
      return paramK.mValue;
      this.a = paramK.c;
      break;
      label134:
      this.b = paramK.d;
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
  
  static class a<K, V>
    extends axzs.e<K, V>
  {
    a(axzs.c<K, V> paramc1, axzs.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    axzs.c<K, V> a(axzs.c<K, V> paramc)
    {
      return paramc.c;
    }
    
    axzs.c<K, V> b(axzs.c<K, V> paramc)
    {
      return paramc.d;
    }
  }
  
  static class b<K, V>
    extends axzs.e<K, V>
  {
    b(axzs.c<K, V> paramc1, axzs.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    axzs.c<K, V> a(axzs.c<K, V> paramc)
    {
      return paramc.d;
    }
    
    axzs.c<K, V> b(axzs.c<K, V> paramc)
    {
      return paramc.c;
    }
  }
  
  static class c<K, V>
    implements Map.Entry<K, V>
  {
    c<K, V> c;
    c<K, V> d;
    @NonNull
    final K mKey;
    @NonNull
    final V mValue;
    
    c(@NonNull K paramK, @NonNull V paramV)
    {
      this.mKey = paramK;
      this.mValue = paramV;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
      } while ((this.mKey.equals(paramObject.mKey)) && (this.mValue.equals(paramObject.mValue)));
      return false;
    }
    
    @NonNull
    public K getKey()
    {
      return this.mKey;
    }
    
    @NonNull
    public V getValue()
    {
      return this.mValue;
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public String toString()
    {
      return this.mKey + "=" + this.mValue;
    }
  }
  
  public class d
    implements axzs.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private axzs.c<K, V> e;
    private boolean mBeforeStart = true;
    
    public d() {}
    
    public void a(@NonNull axzs.c<K, V> paramc)
    {
      if (paramc == this.e)
      {
        this.e = this.e.d;
        if (this.e != null) {
          break label34;
        }
      }
      label34:
      for (boolean bool = true;; bool = false)
      {
        this.mBeforeStart = bool;
        return;
      }
    }
    
    public boolean hasNext()
    {
      if (this.mBeforeStart) {
        if (axzs.a(axzs.this) == null) {}
      }
      while ((this.e != null) && (this.e.c != null))
      {
        return true;
        return false;
      }
      return false;
    }
    
    public Map.Entry<K, V> next()
    {
      if (this.mBeforeStart)
      {
        this.mBeforeStart = false;
        this.e = axzs.a(axzs.this);
        return this.e;
      }
      if (this.e != null) {}
      for (axzs.c localc = this.e.c;; localc = null)
      {
        this.e = localc;
        break;
      }
    }
  }
  
  static abstract class e<K, V>
    implements axzs.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    axzs.c<K, V> c;
    axzs.c<K, V> f;
    
    e(axzs.c<K, V> paramc1, axzs.c<K, V> paramc2)
    {
      this.f = paramc2;
      this.c = paramc1;
    }
    
    private axzs.c<K, V> a()
    {
      if ((this.c == this.f) || (this.f == null)) {
        return null;
      }
      return a(this.c);
    }
    
    abstract axzs.c<K, V> a(axzs.c<K, V> paramc);
    
    public void a(@NonNull axzs.c<K, V> paramc)
    {
      if ((this.f == paramc) && (paramc == this.c))
      {
        this.c = null;
        this.f = null;
      }
      if (this.f == paramc) {
        this.f = b(this.f);
      }
      if (this.c == paramc) {
        this.c = a();
      }
    }
    
    abstract axzs.c<K, V> b(axzs.c<K, V> paramc);
    
    public boolean hasNext()
    {
      return this.c != null;
    }
    
    public Map.Entry<K, V> next()
    {
      axzs.c localc = this.c;
      this.c = a();
      return localc;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void a(@NonNull axzs.c<K, V> paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzs
 * JD-Core Version:    0.7.0.1
 */