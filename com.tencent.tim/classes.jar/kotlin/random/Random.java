package kotlin.random;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract class Random
{
  @JvmField
  @NotNull
  public static final Companion Companion = Companion.INSTANCE;
  public static final Default Default = new Default(null);
  private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
  
  public abstract int nextBits(int paramInt);
  
  public boolean nextBoolean()
  {
    return nextBits(1) != 0;
  }
  
  @NotNull
  public byte[] nextBytes(int paramInt)
  {
    return nextBytes(new byte[paramInt]);
  }
  
  @NotNull
  public byte[] nextBytes(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return nextBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @NotNull
  public byte[] nextBytes(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    int i = paramArrayOfByte.length;
    if (paramInt1 < 0) {}
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label111;
      }
      throw ((Throwable)new IllegalArgumentException(("fromIndex (" + paramInt1 + ") or toIndex (" + paramInt2 + ") are out of range: 0.." + paramArrayOfByte.length + '.').toString()));
      if (i < paramInt1) {
        break;
      }
      i = paramArrayOfByte.length;
      if ((paramInt2 < 0) || (i < paramInt2)) {
        break;
      }
    }
    label111:
    if (paramInt1 <= paramInt2) {}
    for (i = k; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("fromIndex (" + paramInt1 + ") must be not greater than toIndex (" + paramInt2 + ").").toString()));
    }
    k = (paramInt2 - paramInt1) / 4;
    i = 0;
    while (i < k)
    {
      int m = nextInt();
      paramArrayOfByte[paramInt1] = ((byte)m);
      paramArrayOfByte[(paramInt1 + 1)] = ((byte)(m >>> 8));
      paramArrayOfByte[(paramInt1 + 2)] = ((byte)(m >>> 16));
      paramArrayOfByte[(paramInt1 + 3)] = ((byte)(m >>> 24));
      paramInt1 += 4;
      i += 1;
    }
    i = paramInt2 - paramInt1;
    k = nextBits(i * 8);
    paramInt2 = j;
    while (paramInt2 < i)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(k >>> paramInt2 * 8));
      paramInt2 += 1;
    }
    return paramArrayOfByte;
  }
  
  public double nextDouble()
  {
    return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
  }
  
  public double nextDouble(double paramDouble)
  {
    return nextDouble(0.0D, paramDouble);
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    int j = 1;
    RandomKt.checkRangeBounds(paramDouble1, paramDouble2);
    double d = paramDouble2 - paramDouble1;
    int i;
    if (Double.isInfinite(d)) {
      if ((!Double.isInfinite(paramDouble1)) && (!Double.isNaN(paramDouble1)))
      {
        i = 1;
        if (i == 0) {
          break label126;
        }
        if ((Double.isInfinite(paramDouble2)) || (Double.isNaN(paramDouble2))) {
          break label120;
        }
        i = j;
        label61:
        if (i == 0) {
          break label126;
        }
        d = nextDouble() * (paramDouble2 / 2 - paramDouble1 / 2);
      }
    }
    label120:
    label126:
    for (paramDouble1 = d + (paramDouble1 + d);; paramDouble1 = nextDouble() * d + paramDouble1)
    {
      d = paramDouble1;
      if (paramDouble1 >= paramDouble2) {
        d = Math.nextAfter(paramDouble2, DoubleCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
      }
      return d;
      i = 0;
      break;
      i = 0;
      break label61;
    }
  }
  
  public float nextFloat()
  {
    return nextBits(24) / 16777216;
  }
  
  public int nextInt()
  {
    return nextBits(32);
  }
  
  public int nextInt(int paramInt)
  {
    return nextInt(0, paramInt);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    RandomKt.checkRangeBounds(paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if ((i > 0) || (i == -2147483648))
    {
      if ((-i & i) == i) {
        paramInt2 = nextBits(RandomKt.fastLog2(i));
      }
      for (;;)
      {
        return paramInt2 + paramInt1;
        int j;
        do
        {
          j = nextInt() >>> 1;
          paramInt2 = j % i;
        } while (j - paramInt2 + (i - 1) < 0);
      }
    }
    do
    {
      i = nextInt();
    } while ((paramInt1 > i) || (paramInt2 <= i));
    return i;
  }
  
  public long nextLong()
  {
    return (nextInt() << 32) + nextInt();
  }
  
  public long nextLong(long paramLong)
  {
    return nextLong(0L, paramLong);
  }
  
  public long nextLong(long paramLong1, long paramLong2)
  {
    RandomKt.checkRangeBounds(paramLong1, paramLong2);
    long l1 = paramLong2 - paramLong1;
    if (l1 > 0L)
    {
      int j;
      if ((-l1 & l1) == l1)
      {
        int i = (int)l1;
        j = (int)(l1 >>> 32);
        if (i != 0) {
          paramLong2 = nextBits(RandomKt.fastLog2(i)) & 0xFFFFFFFF;
        }
      }
      for (;;)
      {
        return paramLong2 + paramLong1;
        if (j == 1)
        {
          paramLong2 = nextInt() & 0xFFFFFFFF;
        }
        else
        {
          paramLong2 = (nextBits(RandomKt.fastLog2(j)) << 32) + nextInt();
          continue;
          long l2;
          do
          {
            l2 = nextLong() >>> 1;
            paramLong2 = l2 % l1;
          } while (l2 - paramLong2 + (l1 - 1L) < 0L);
        }
      }
    }
    do
    {
      l1 = nextLong();
    } while ((paramLong1 > l1) || (paramLong2 <= l1));
    return l1;
  }
  
  @Deprecated(level=DeprecationLevel.HIDDEN, message="Use Default companion object instead")
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
    extends Random
  {
    public static final Companion INSTANCE = new Companion();
    
    public int nextBits(int paramInt)
    {
      return Random.Default.nextBits(paramInt);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Default
    extends Random
  {
    public int nextBits(int paramInt)
    {
      return Random.access$getDefaultRandom$cp().nextBits(paramInt);
    }
    
    public boolean nextBoolean()
    {
      return Random.access$getDefaultRandom$cp().nextBoolean();
    }
    
    @NotNull
    public byte[] nextBytes(int paramInt)
    {
      return Random.access$getDefaultRandom$cp().nextBytes(paramInt);
    }
    
    @NotNull
    public byte[] nextBytes(@NotNull byte[] paramArrayOfByte)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
      return Random.access$getDefaultRandom$cp().nextBytes(paramArrayOfByte);
    }
    
    @NotNull
    public byte[] nextBytes(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
      return Random.access$getDefaultRandom$cp().nextBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public double nextDouble()
    {
      return Random.access$getDefaultRandom$cp().nextDouble();
    }
    
    public double nextDouble(double paramDouble)
    {
      return Random.access$getDefaultRandom$cp().nextDouble(paramDouble);
    }
    
    public double nextDouble(double paramDouble1, double paramDouble2)
    {
      return Random.access$getDefaultRandom$cp().nextDouble(paramDouble1, paramDouble2);
    }
    
    public float nextFloat()
    {
      return Random.access$getDefaultRandom$cp().nextFloat();
    }
    
    public int nextInt()
    {
      return Random.access$getDefaultRandom$cp().nextInt();
    }
    
    public int nextInt(int paramInt)
    {
      return Random.access$getDefaultRandom$cp().nextInt(paramInt);
    }
    
    public int nextInt(int paramInt1, int paramInt2)
    {
      return Random.access$getDefaultRandom$cp().nextInt(paramInt1, paramInt2);
    }
    
    public long nextLong()
    {
      return Random.access$getDefaultRandom$cp().nextLong();
    }
    
    public long nextLong(long paramLong)
    {
      return Random.access$getDefaultRandom$cp().nextLong(paramLong);
    }
    
    public long nextLong(long paramLong1, long paramLong2)
    {
      return Random.access$getDefaultRandom$cp().nextLong(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.random.Random
 * JD-Core Version:    0.7.0.1
 */