package com.google.common.collect;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;
import javax.annotation.Nullable;

final class ComparisonChain$1
  extends ComparisonChain
{
  ComparisonChain$1()
  {
    super(null);
  }
  
  ComparisonChain classify(int paramInt)
  {
    if (paramInt < 0) {
      return ComparisonChain.access$100();
    }
    if (paramInt > 0) {
      return ComparisonChain.access$200();
    }
    return ComparisonChain.access$300();
  }
  
  public ComparisonChain compare(double paramDouble1, double paramDouble2)
  {
    return classify(Double.compare(paramDouble1, paramDouble2));
  }
  
  public ComparisonChain compare(float paramFloat1, float paramFloat2)
  {
    return classify(Float.compare(paramFloat1, paramFloat2));
  }
  
  public ComparisonChain compare(int paramInt1, int paramInt2)
  {
    return classify(Ints.compare(paramInt1, paramInt2));
  }
  
  public ComparisonChain compare(long paramLong1, long paramLong2)
  {
    return classify(Longs.compare(paramLong1, paramLong2));
  }
  
  public ComparisonChain compare(Comparable paramComparable1, Comparable paramComparable2)
  {
    return classify(paramComparable1.compareTo(paramComparable2));
  }
  
  public <T> ComparisonChain compare(@Nullable T paramT1, @Nullable T paramT2, Comparator<T> paramComparator)
  {
    return classify(paramComparator.compare(paramT1, paramT2));
  }
  
  public ComparisonChain compareFalseFirst(boolean paramBoolean1, boolean paramBoolean2)
  {
    return classify(Booleans.compare(paramBoolean1, paramBoolean2));
  }
  
  public ComparisonChain compareTrueFirst(boolean paramBoolean1, boolean paramBoolean2)
  {
    return classify(Booleans.compare(paramBoolean2, paramBoolean1));
  }
  
  public int result()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ComparisonChain.1
 * JD-Core Version:    0.7.0.1
 */