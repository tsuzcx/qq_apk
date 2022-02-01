package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

@Beta
@GwtIncompatible
public final class Interners
{
  public static <E> Function<E, E> asFunction(Interner<E> paramInterner)
  {
    return new InternerFunction((Interner)Preconditions.checkNotNull(paramInterner));
  }
  
  public static <E> Interner<E> newStrongInterner()
  {
    return new Interners.1(new MapMaker().makeMap());
  }
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public static <E> Interner<E> newWeakInterner()
  {
    return new WeakInterner(null);
  }
  
  static class InternerFunction<E>
    implements Function<E, E>
  {
    private final Interner<E> interner;
    
    public InternerFunction(Interner<E> paramInterner)
    {
      this.interner = paramInterner;
    }
    
    public E apply(E paramE)
    {
      return this.interner.intern(paramE);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof InternerFunction))
      {
        paramObject = (InternerFunction)paramObject;
        return this.interner.equals(paramObject.interner);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.interner.hashCode();
    }
  }
  
  static class WeakInterner<E>
    implements Interner<E>
  {
    private final MapMakerInternalMap<E, Dummy, ?, ?> map = new MapMaker().weakKeys().keyEquivalence(Equivalence.equals()).makeCustomMap();
    
    public E intern(E paramE)
    {
      do
      {
        Object localObject = this.map.getEntry(paramE);
        if (localObject != null)
        {
          localObject = ((MapMakerInternalMap.InternalEntry)localObject).getKey();
          if (localObject != null) {
            return localObject;
          }
        }
      } while ((Dummy)this.map.putIfAbsent(paramE, Dummy.VALUE) != null);
      return paramE;
    }
    
    static enum Dummy
    {
      VALUE;
      
      private Dummy() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Interners
 * JD-Core Version:    0.7.0.1
 */