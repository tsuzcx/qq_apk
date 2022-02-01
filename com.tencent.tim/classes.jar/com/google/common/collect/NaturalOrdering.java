package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;

@GwtCompatible(serializable=true)
final class NaturalOrdering
  extends Ordering<Comparable>
  implements Serializable
{
  static final NaturalOrdering INSTANCE = new NaturalOrdering();
  private static final long serialVersionUID = 0L;
  private transient Ordering<Comparable> nullsFirst;
  private transient Ordering<Comparable> nullsLast;
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(Comparable paramComparable1, Comparable paramComparable2)
  {
    Preconditions.checkNotNull(paramComparable1);
    Preconditions.checkNotNull(paramComparable2);
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public <S extends Comparable> Ordering<S> nullsFirst()
  {
    Ordering localOrdering2 = this.nullsFirst;
    Ordering localOrdering1 = localOrdering2;
    if (localOrdering2 == null)
    {
      localOrdering1 = super.nullsFirst();
      this.nullsFirst = localOrdering1;
    }
    return localOrdering1;
  }
  
  public <S extends Comparable> Ordering<S> nullsLast()
  {
    Ordering localOrdering2 = this.nullsLast;
    Ordering localOrdering1 = localOrdering2;
    if (localOrdering2 == null)
    {
      localOrdering1 = super.nullsLast();
      this.nullsLast = localOrdering1;
    }
    return localOrdering1;
  }
  
  public <S extends Comparable> Ordering<S> reverse()
  {
    return ReverseNaturalOrdering.INSTANCE;
  }
  
  public String toString()
  {
    return "Ordering.natural()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.NaturalOrdering
 * JD-Core Version:    0.7.0.1
 */