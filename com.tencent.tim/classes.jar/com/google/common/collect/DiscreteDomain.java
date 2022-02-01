package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable>
{
  public static DiscreteDomain<BigInteger> bigIntegers()
  {
    return BigIntegerDomain.INSTANCE;
  }
  
  public static DiscreteDomain<Integer> integers()
  {
    return IntegerDomain.INSTANCE;
  }
  
  public static DiscreteDomain<Long> longs()
  {
    return LongDomain.INSTANCE;
  }
  
  public abstract long distance(C paramC1, C paramC2);
  
  @CanIgnoreReturnValue
  public C maxValue()
  {
    throw new NoSuchElementException();
  }
  
  @CanIgnoreReturnValue
  public C minValue()
  {
    throw new NoSuchElementException();
  }
  
  public abstract C next(C paramC);
  
  public abstract C previous(C paramC);
  
  static final class BigIntegerDomain
    extends DiscreteDomain<BigInteger>
    implements Serializable
  {
    private static final BigIntegerDomain INSTANCE = new BigIntegerDomain();
    private static final BigInteger MAX_LONG = BigInteger.valueOf(9223372036854775807L);
    private static final BigInteger MIN_LONG = BigInteger.valueOf(-9223372036854775808L);
    private static final long serialVersionUID = 0L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public long distance(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      return paramBigInteger2.subtract(paramBigInteger1).max(MIN_LONG).min(MAX_LONG).longValue();
    }
    
    public BigInteger next(BigInteger paramBigInteger)
    {
      return paramBigInteger.add(BigInteger.ONE);
    }
    
    public BigInteger previous(BigInteger paramBigInteger)
    {
      return paramBigInteger.subtract(BigInteger.ONE);
    }
    
    public String toString()
    {
      return "DiscreteDomain.bigIntegers()";
    }
  }
  
  static final class IntegerDomain
    extends DiscreteDomain<Integer>
    implements Serializable
  {
    private static final IntegerDomain INSTANCE = new IntegerDomain();
    private static final long serialVersionUID = 0L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public long distance(Integer paramInteger1, Integer paramInteger2)
    {
      return paramInteger2.intValue() - paramInteger1.intValue();
    }
    
    public Integer maxValue()
    {
      return Integer.valueOf(2147483647);
    }
    
    public Integer minValue()
    {
      return Integer.valueOf(-2147483648);
    }
    
    public Integer next(Integer paramInteger)
    {
      int i = paramInteger.intValue();
      if (i == 2147483647) {
        return null;
      }
      return Integer.valueOf(i + 1);
    }
    
    public Integer previous(Integer paramInteger)
    {
      int i = paramInteger.intValue();
      if (i == -2147483648) {
        return null;
      }
      return Integer.valueOf(i - 1);
    }
    
    public String toString()
    {
      return "DiscreteDomain.integers()";
    }
  }
  
  static final class LongDomain
    extends DiscreteDomain<Long>
    implements Serializable
  {
    private static final LongDomain INSTANCE = new LongDomain();
    private static final long serialVersionUID = 0L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public long distance(Long paramLong1, Long paramLong2)
    {
      long l2 = paramLong2.longValue() - paramLong1.longValue();
      long l1;
      if ((paramLong2.longValue() > paramLong1.longValue()) && (l2 < 0L)) {
        l1 = 9223372036854775807L;
      }
      do
      {
        do
        {
          return l1;
          l1 = l2;
        } while (paramLong2.longValue() >= paramLong1.longValue());
        l1 = l2;
      } while (l2 <= 0L);
      return -9223372036854775808L;
    }
    
    public Long maxValue()
    {
      return Long.valueOf(9223372036854775807L);
    }
    
    public Long minValue()
    {
      return Long.valueOf(-9223372036854775808L);
    }
    
    public Long next(Long paramLong)
    {
      long l = paramLong.longValue();
      if (l == 9223372036854775807L) {
        return null;
      }
      return Long.valueOf(l + 1L);
    }
    
    public Long previous(Long paramLong)
    {
      long l = paramLong.longValue();
      if (l == -9223372036854775808L) {
        return null;
      }
      return Long.valueOf(l - 1L);
    }
    
    public String toString()
    {
      return "DiscreteDomain.longs()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.DiscreteDomain
 * JD-Core Version:    0.7.0.1
 */