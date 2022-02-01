package org.apache.commons.lang3.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffBuilder
  implements Builder<DiffResult>
{
  private final List<Diff<?>> diffs;
  private final Object left;
  private final boolean objectsTriviallyEqual;
  private final Object right;
  private final ToStringStyle style;
  
  public DiffBuilder(Object paramObject1, Object paramObject2, ToStringStyle paramToStringStyle)
  {
    this(paramObject1, paramObject2, paramToStringStyle, true);
  }
  
  public DiffBuilder(Object paramObject1, Object paramObject2, ToStringStyle paramToStringStyle, boolean paramBoolean)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException("lhs cannot be null");
    }
    if (paramObject2 == null) {
      throw new IllegalArgumentException("rhs cannot be null");
    }
    this.diffs = new ArrayList();
    this.left = paramObject1;
    this.right = paramObject2;
    this.style = paramToStringStyle;
    if ((paramBoolean) && ((paramObject1 == paramObject2) || (paramObject1.equals(paramObject2)))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.objectsTriviallyEqual = paramBoolean;
      return;
    }
  }
  
  public DiffBuilder append(String paramString, byte paramByte1, byte paramByte2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (paramByte1 == paramByte2) {
      return this;
    }
    this.diffs.add(new DiffBuilder.3(this, paramString, paramByte1, paramByte2));
    return this;
  }
  
  public DiffBuilder append(String paramString, char paramChar1, char paramChar2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (paramChar1 == paramChar2) {
      return this;
    }
    this.diffs.add(new DiffBuilder.5(this, paramString, paramChar1, paramChar2));
    return this;
  }
  
  public DiffBuilder append(String paramString, double paramDouble1, double paramDouble2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Double.doubleToLongBits(paramDouble1) == Double.doubleToLongBits(paramDouble2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.7(this, paramString, paramDouble1, paramDouble2));
    return this;
  }
  
  public DiffBuilder append(String paramString, float paramFloat1, float paramFloat2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Float.floatToIntBits(paramFloat1) == Float.floatToIntBits(paramFloat2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.9(this, paramString, paramFloat1, paramFloat2));
    return this;
  }
  
  public DiffBuilder append(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (paramInt1 == paramInt2) {
      return this;
    }
    this.diffs.add(new DiffBuilder.11(this, paramString, paramInt1, paramInt2));
    return this;
  }
  
  public DiffBuilder append(String paramString, long paramLong1, long paramLong2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (paramLong1 == paramLong2) {
      return this;
    }
    this.diffs.add(new DiffBuilder.13(this, paramString, paramLong1, paramLong2));
    return this;
  }
  
  public DiffBuilder append(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.objectsTriviallyEqual) {}
    do
    {
      do
      {
        return this;
      } while (paramObject1 == paramObject2);
      Object localObject;
      if (paramObject1 != null) {
        localObject = paramObject1;
      }
      while (localObject.getClass().isArray()) {
        if ((localObject instanceof boolean[]))
        {
          return append(paramString, (boolean[])paramObject1, (boolean[])paramObject2);
          localObject = paramObject2;
        }
        else
        {
          if ((localObject instanceof byte[])) {
            return append(paramString, (byte[])paramObject1, (byte[])paramObject2);
          }
          if ((localObject instanceof char[])) {
            return append(paramString, (char[])paramObject1, (char[])paramObject2);
          }
          if ((localObject instanceof double[])) {
            return append(paramString, (double[])paramObject1, (double[])paramObject2);
          }
          if ((localObject instanceof float[])) {
            return append(paramString, (float[])paramObject1, (float[])paramObject2);
          }
          if ((localObject instanceof int[])) {
            return append(paramString, (int[])paramObject1, (int[])paramObject2);
          }
          if ((localObject instanceof long[])) {
            return append(paramString, (long[])paramObject1, (long[])paramObject2);
          }
          if ((localObject instanceof short[])) {
            return append(paramString, (short[])paramObject1, (short[])paramObject2);
          }
          return append(paramString, (Object[])paramObject1, (Object[])paramObject2);
        }
      }
    } while ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
    this.diffs.add(new DiffBuilder.17(this, paramString, paramObject1, paramObject2));
    return this;
  }
  
  public DiffBuilder append(String paramString, short paramShort1, short paramShort2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (paramShort1 == paramShort2) {
      return this;
    }
    this.diffs.add(new DiffBuilder.15(this, paramString, paramShort1, paramShort2));
    return this;
  }
  
  public DiffBuilder append(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (paramBoolean1 == paramBoolean2) {
      return this;
    }
    this.diffs.add(new DiffBuilder.1(this, paramString, paramBoolean1, paramBoolean2));
    return this;
  }
  
  public DiffBuilder append(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfByte1, paramArrayOfByte2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.4(this, paramString, paramArrayOfByte1, paramArrayOfByte2));
    return this;
  }
  
  public DiffBuilder append(String paramString, char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfChar1, paramArrayOfChar2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.6(this, paramString, paramArrayOfChar1, paramArrayOfChar2));
    return this;
  }
  
  public DiffBuilder append(String paramString, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfDouble1, paramArrayOfDouble2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.8(this, paramString, paramArrayOfDouble1, paramArrayOfDouble2));
    return this;
  }
  
  public DiffBuilder append(String paramString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.10(this, paramString, paramArrayOfFloat1, paramArrayOfFloat2));
    return this;
  }
  
  public DiffBuilder append(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfInt1, paramArrayOfInt2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.12(this, paramString, paramArrayOfInt1, paramArrayOfInt2));
    return this;
  }
  
  public DiffBuilder append(String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfLong1, paramArrayOfLong2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.14(this, paramString, paramArrayOfLong1, paramArrayOfLong2));
    return this;
  }
  
  public DiffBuilder append(String paramString, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfObject1, paramArrayOfObject2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.18(this, paramString, paramArrayOfObject1, paramArrayOfObject2));
    return this;
  }
  
  public DiffBuilder append(String paramString, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfShort1, paramArrayOfShort2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.16(this, paramString, paramArrayOfShort1, paramArrayOfShort2));
    return this;
  }
  
  public DiffBuilder append(String paramString, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Field name cannot be null");
    }
    if (this.objectsTriviallyEqual) {}
    while (Arrays.equals(paramArrayOfBoolean1, paramArrayOfBoolean2)) {
      return this;
    }
    this.diffs.add(new DiffBuilder.2(this, paramString, paramArrayOfBoolean1, paramArrayOfBoolean2));
    return this;
  }
  
  public DiffResult build()
  {
    return new DiffResult(this.left, this.right, this.diffs, this.style);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder
 * JD-Core Version:    0.7.0.1
 */