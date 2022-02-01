package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Equivalence<T>
{
  public static Equivalence<Object> equals()
  {
    return Equals.INSTANCE;
  }
  
  public static Equivalence<Object> identity()
  {
    return Identity.INSTANCE;
  }
  
  protected abstract boolean doEquivalent(T paramT1, T paramT2);
  
  protected abstract int doHash(T paramT);
  
  public final boolean equivalent(@Nullable T paramT1, @Nullable T paramT2)
  {
    if (paramT1 == paramT2) {
      return true;
    }
    if ((paramT1 == null) || (paramT2 == null)) {
      return false;
    }
    return doEquivalent(paramT1, paramT2);
  }
  
  public final Predicate<T> equivalentTo(@Nullable T paramT)
  {
    return new EquivalentToPredicate(this, paramT);
  }
  
  public final int hash(@Nullable T paramT)
  {
    if (paramT == null) {
      return 0;
    }
    return doHash(paramT);
  }
  
  public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> paramFunction)
  {
    return new FunctionalEquivalence(paramFunction, this);
  }
  
  @GwtCompatible(serializable=true)
  public final <S extends T> Equivalence<Iterable<S>> pairwise()
  {
    return new PairwiseEquivalence(this);
  }
  
  public final <S extends T> Wrapper<S> wrap(@Nullable S paramS)
  {
    return new Wrapper(this, paramS, null);
  }
  
  static final class Equals
    extends Equivalence<Object>
    implements Serializable
  {
    static final Equals INSTANCE = new Equals();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected boolean doEquivalent(Object paramObject1, Object paramObject2)
    {
      return paramObject1.equals(paramObject2);
    }
    
    protected int doHash(Object paramObject)
    {
      return paramObject.hashCode();
    }
  }
  
  static final class EquivalentToPredicate<T>
    implements Predicate<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Equivalence<T> equivalence;
    @Nullable
    private final T target;
    
    EquivalentToPredicate(Equivalence<T> paramEquivalence, @Nullable T paramT)
    {
      this.equivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
      this.target = paramT;
    }
    
    public boolean apply(@Nullable T paramT)
    {
      return this.equivalence.equivalent(paramT, this.target);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof EquivalentToPredicate)) {
          break;
        }
        paramObject = (EquivalentToPredicate)paramObject;
      } while ((this.equivalence.equals(paramObject.equivalence)) && (Objects.equal(this.target, paramObject.target)));
      return false;
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.equivalence, this.target });
    }
    
    public String toString()
    {
      return this.equivalence + ".equivalentTo(" + this.target + ")";
    }
  }
  
  static final class Identity
    extends Equivalence<Object>
    implements Serializable
  {
    static final Identity INSTANCE = new Identity();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected boolean doEquivalent(Object paramObject1, Object paramObject2)
    {
      return false;
    }
    
    protected int doHash(Object paramObject)
    {
      return System.identityHashCode(paramObject);
    }
  }
  
  public static final class Wrapper<T>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Equivalence<? super T> equivalence;
    @Nullable
    private final T reference;
    
    private Wrapper(Equivalence<? super T> paramEquivalence, @Nullable T paramT)
    {
      this.equivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
      this.reference = paramT;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if ((paramObject instanceof Wrapper))
      {
        paramObject = (Wrapper)paramObject;
        if (this.equivalence.equals(paramObject.equivalence)) {
          return this.equivalence.equivalent(this.reference, paramObject.reference);
        }
      }
      return false;
    }
    
    @Nullable
    public T get()
    {
      return this.reference;
    }
    
    public int hashCode()
    {
      return this.equivalence.hash(this.reference);
    }
    
    public String toString()
    {
      return this.equivalence + ".wrap(" + this.reference + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Equivalence
 * JD-Core Version:    0.7.0.1
 */