package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
public final class BloomFilter<T>
  implements Predicate<T>, Serializable
{
  private final BloomFilterStrategies.BitArray bits;
  private final Funnel<? super T> funnel;
  private final int numHashFunctions;
  private final Strategy strategy;
  
  private BloomFilter(BloomFilterStrategies.BitArray paramBitArray, int paramInt, Funnel<? super T> paramFunnel, Strategy paramStrategy)
  {
    if (paramInt > 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "numHashFunctions (%s) must be > 0", paramInt);
      if (paramInt > 255) {
        break label87;
      }
    }
    label87:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "numHashFunctions (%s) must be <= 255", paramInt);
      this.bits = ((BloomFilterStrategies.BitArray)Preconditions.checkNotNull(paramBitArray));
      this.numHashFunctions = paramInt;
      this.funnel = ((Funnel)Preconditions.checkNotNull(paramFunnel));
      this.strategy = ((Strategy)Preconditions.checkNotNull(paramStrategy));
      return;
      bool1 = false;
      break;
    }
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt)
  {
    return create(paramFunnel, paramInt);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt, double paramDouble)
  {
    return create(paramFunnel, paramInt, paramDouble);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong)
  {
    return create(paramFunnel, paramLong, 0.03D);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble)
  {
    return create(paramFunnel, paramLong, paramDouble, BloomFilterStrategies.MURMUR128_MITZ_64);
  }
  
  @VisibleForTesting
  static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble, Strategy paramStrategy)
  {
    boolean bool2 = true;
    Preconditions.checkNotNull(paramFunnel);
    if (paramLong >= 0L)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Expected insertions (%s) must be >= 0", paramLong);
      if (paramDouble <= 0.0D) {
        break label128;
      }
      bool1 = true;
      label34:
      Preconditions.checkArgument(bool1, "False positive probability (%s) must be > 0.0", Double.valueOf(paramDouble));
      if (paramDouble >= 1.0D) {
        break label134;
      }
    }
    label128:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "False positive probability (%s) must be < 1.0", Double.valueOf(paramDouble));
      Preconditions.checkNotNull(paramStrategy);
      long l = paramLong;
      if (paramLong == 0L) {
        l = 1L;
      }
      paramLong = optimalNumOfBits(l, paramDouble);
      int i = optimalNumOfHashFunctions(l, paramLong);
      try
      {
        paramFunnel = new BloomFilter(new BloomFilterStrategies.BitArray(paramLong), i, paramFunnel, paramStrategy);
        return paramFunnel;
      }
      catch (IllegalArgumentException paramFunnel)
      {
        throw new IllegalArgumentException("Could not create BloomFilter of " + paramLong + " bits", paramFunnel);
      }
      bool1 = false;
      break;
      bool1 = false;
      break label34;
    }
  }
  
  @VisibleForTesting
  static long optimalNumOfBits(long paramLong, double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble == 0.0D) {
      d = 4.9E-324D;
    }
    return (-paramLong * Math.log(d) / (Math.log(2.0D) * Math.log(2.0D)));
  }
  
  @VisibleForTesting
  static int optimalNumOfHashFunctions(long paramLong1, long paramLong2)
  {
    return Math.max(1, (int)Math.round(paramLong2 / paramLong1 * Math.log(2.0D)));
  }
  
  /* Error */
  public static <T> BloomFilter<T> readFrom(java.io.InputStream paramInputStream, Funnel<T> paramFunnel)
    throws IOException
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: aload_0
    //   4: ldc 177
    //   6: invokestatic 180	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_1
    //   11: ldc 182
    //   13: invokestatic 180	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: new 184	java/io/DataInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 187	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 191	java/io/DataInputStream:readByte	()B
    //   30: istore_3
    //   31: aload_0
    //   32: invokevirtual 191	java/io/DataInputStream:readByte	()B
    //   35: invokestatic 197	com/google/common/primitives/UnsignedBytes:toInt	(B)I
    //   38: istore 5
    //   40: iload 4
    //   42: istore_2
    //   43: aload_0
    //   44: invokevirtual 201	java/io/DataInputStream:readInt	()I
    //   47: istore 6
    //   49: iload 6
    //   51: istore_2
    //   52: invokestatic 205	com/google/common/hash/BloomFilterStrategies:values	()[Lcom/google/common/hash/BloomFilterStrategies;
    //   55: iload_3
    //   56: aaload
    //   57: astore 7
    //   59: iload 6
    //   61: istore_2
    //   62: iload 6
    //   64: newarray long
    //   66: astore 8
    //   68: iconst_0
    //   69: istore 4
    //   71: iload 6
    //   73: istore_2
    //   74: iload 4
    //   76: aload 8
    //   78: arraylength
    //   79: if_icmpge +24 -> 103
    //   82: iload 6
    //   84: istore_2
    //   85: aload 8
    //   87: iload 4
    //   89: aload_0
    //   90: invokevirtual 209	java/io/DataInputStream:readLong	()J
    //   93: lastore
    //   94: iload 4
    //   96: iconst_1
    //   97: iadd
    //   98: istore 4
    //   100: goto -29 -> 71
    //   103: iload 6
    //   105: istore_2
    //   106: new 2	com/google/common/hash/BloomFilter
    //   109: dup
    //   110: new 48	com/google/common/hash/BloomFilterStrategies$BitArray
    //   113: dup
    //   114: aload 8
    //   116: invokespecial 212	com/google/common/hash/BloomFilterStrategies$BitArray:<init>	([J)V
    //   119: iload 5
    //   121: aload_1
    //   122: aload 7
    //   124: invokespecial 64	com/google/common/hash/BloomFilter:<init>	(Lcom/google/common/hash/BloomFilterStrategies$BitArray;ILcom/google/common/hash/Funnel;Lcom/google/common/hash/BloomFilter$Strategy;)V
    //   127: astore_0
    //   128: aload_0
    //   129: areturn
    //   130: astore_0
    //   131: iconst_m1
    //   132: istore_2
    //   133: iconst_m1
    //   134: istore_3
    //   135: new 173	java/io/IOException
    //   138: dup
    //   139: new 130	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   146: ldc 214
    //   148: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: iload_3
    //   152: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc 219
    //   157: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload_2
    //   161: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: ldc 221
    //   166: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload 4
    //   171: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload_0
    //   178: invokespecial 222	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: athrow
    //   182: astore_0
    //   183: iconst_m1
    //   184: istore_2
    //   185: goto -50 -> 135
    //   188: astore_0
    //   189: iload_2
    //   190: istore 4
    //   192: iload 5
    //   194: istore_2
    //   195: goto -60 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramInputStream	java.io.InputStream
    //   0	198	1	paramFunnel	Funnel<T>
    //   42	153	2	i	int
    //   30	122	3	j	int
    //   1	190	4	k	int
    //   38	155	5	m	int
    //   47	57	6	n	int
    //   57	66	7	localBloomFilterStrategies	BloomFilterStrategies
    //   66	49	8	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   17	31	130	java/lang/RuntimeException
    //   31	40	182	java/lang/RuntimeException
    //   43	49	188	java/lang/RuntimeException
    //   52	59	188	java/lang/RuntimeException
    //   62	68	188	java/lang/RuntimeException
    //   74	82	188	java/lang/RuntimeException
    //   85	94	188	java/lang/RuntimeException
    //   106	128	188	java/lang/RuntimeException
  }
  
  private Object writeReplace()
  {
    return new SerialForm(this);
  }
  
  @Deprecated
  public boolean apply(T paramT)
  {
    return mightContain(paramT);
  }
  
  @VisibleForTesting
  long bitSize()
  {
    return this.bits.bitSize();
  }
  
  public BloomFilter<T> copy()
  {
    return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BloomFilter)) {
        break;
      }
      paramObject = (BloomFilter)paramObject;
    } while ((this.numHashFunctions == paramObject.numHashFunctions) && (this.funnel.equals(paramObject.funnel)) && (this.bits.equals(paramObject.bits)) && (this.strategy.equals(paramObject.strategy)));
    return false;
    return false;
  }
  
  public double expectedFpp()
  {
    return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits });
  }
  
  public boolean isCompatible(BloomFilter<T> paramBloomFilter)
  {
    Preconditions.checkNotNull(paramBloomFilter);
    return (this != paramBloomFilter) && (this.numHashFunctions == paramBloomFilter.numHashFunctions) && (bitSize() == paramBloomFilter.bitSize()) && (this.strategy.equals(paramBloomFilter.strategy)) && (this.funnel.equals(paramBloomFilter.funnel));
  }
  
  public boolean mightContain(T paramT)
  {
    return this.strategy.mightContain(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  @CanIgnoreReturnValue
  public boolean put(T paramT)
  {
    return this.strategy.put(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  public void putAll(BloomFilter<T> paramBloomFilter)
  {
    Preconditions.checkNotNull(paramBloomFilter);
    if (this != paramBloomFilter)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Cannot combine a BloomFilter with itself.");
      if (this.numHashFunctions != paramBloomFilter.numHashFunctions) {
        break label143;
      }
      bool = true;
      label32:
      Preconditions.checkArgument(bool, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, paramBloomFilter.numHashFunctions);
      if (bitSize() != paramBloomFilter.bitSize()) {
        break label148;
      }
    }
    label143:
    label148:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), paramBloomFilter.bitSize());
      Preconditions.checkArgument(this.strategy.equals(paramBloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, paramBloomFilter.strategy);
      Preconditions.checkArgument(this.funnel.equals(paramBloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, paramBloomFilter.funnel);
      this.bits.putAll(paramBloomFilter.bits);
      return;
      bool = false;
      break;
      bool = false;
      break label32;
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
    paramOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
    paramOutputStream.writeInt(this.bits.data.length);
    long[] arrayOfLong = this.bits.data;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramOutputStream.writeLong(arrayOfLong[i]);
      i += 1;
    }
  }
  
  static class SerialForm<T>
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    final long[] data;
    final Funnel<? super T> funnel;
    final int numHashFunctions;
    final BloomFilter.Strategy strategy;
    
    SerialForm(BloomFilter<T> paramBloomFilter)
    {
      this.data = paramBloomFilter.bits.data;
      this.numHashFunctions = paramBloomFilter.numHashFunctions;
      this.funnel = paramBloomFilter.funnel;
      this.strategy = paramBloomFilter.strategy;
    }
    
    Object readResolve()
    {
      return new BloomFilter(new BloomFilterStrategies.BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
    }
  }
  
  static abstract interface Strategy
    extends Serializable
  {
    public abstract <T> boolean mightContain(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
    
    public abstract int ordinal();
    
    public abstract <T> boolean put(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.BloomFilter
 * JD-Core Version:    0.7.0.1
 */