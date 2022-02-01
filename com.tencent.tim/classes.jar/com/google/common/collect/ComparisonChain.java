package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ComparisonChain
{
  private static final ComparisonChain ACTIVE = new ComparisonChain.1();
  private static final ComparisonChain GREATER = new InactiveComparisonChain(1);
  private static final ComparisonChain LESS = new InactiveComparisonChain(-1);
  
  public static ComparisonChain start()
  {
    return ACTIVE;
  }
  
  public abstract ComparisonChain compare(double paramDouble1, double paramDouble2);
  
  public abstract ComparisonChain compare(float paramFloat1, float paramFloat2);
  
  public abstract ComparisonChain compare(int paramInt1, int paramInt2);
  
  public abstract ComparisonChain compare(long paramLong1, long paramLong2);
  
  @Deprecated
  public final ComparisonChain compare(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    return compareFalseFirst(paramBoolean1.booleanValue(), paramBoolean2.booleanValue());
  }
  
  public abstract ComparisonChain compare(Comparable<?> paramComparable1, Comparable<?> paramComparable2);
  
  public abstract <T> ComparisonChain compare(@Nullable T paramT1, @Nullable T paramT2, Comparator<T> paramComparator);
  
  public abstract ComparisonChain compareFalseFirst(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract ComparisonChain compareTrueFirst(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract int result();
  
  static final class InactiveComparisonChain
    extends ComparisonChain
  {
    final int result;
    
    InactiveComparisonChain(int paramInt)
    {
      super();
      this.result = paramInt;
    }
    
    public ComparisonChain compare(double paramDouble1, double paramDouble2)
    {
      return this;
    }
    
    public ComparisonChain compare(float paramFloat1, float paramFloat2)
    {
      return this;
    }
    
    public ComparisonChain compare(int paramInt1, int paramInt2)
    {
      return this;
    }
    
    public ComparisonChain compare(long paramLong1, long paramLong2)
    {
      return this;
    }
    
    public ComparisonChain compare(@Nullable Comparable paramComparable1, @Nullable Comparable paramComparable2)
    {
      return this;
    }
    
    public <T> ComparisonChain compare(@Nullable T paramT1, @Nullable T paramT2, @Nullable Comparator<T> paramComparator)
    {
      return this;
    }
    
    public ComparisonChain compareFalseFirst(boolean paramBoolean1, boolean paramBoolean2)
    {
      return this;
    }
    
    public ComparisonChain compareTrueFirst(boolean paramBoolean1, boolean paramBoolean2)
    {
      return this;
    }
    
    public int result()
    {
      return this.result;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ComparisonChain
 * JD-Core Version:    0.7.0.1
 */