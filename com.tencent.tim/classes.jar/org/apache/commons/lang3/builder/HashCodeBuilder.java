package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

public class HashCodeBuilder
  implements Builder<Integer>
{
  private static final int DEFAULT_INITIAL_VALUE = 17;
  private static final int DEFAULT_MULTIPLIER_VALUE = 37;
  private static final ThreadLocal<Set<IDKey>> REGISTRY = new ThreadLocal();
  private final int iConstant;
  private int iTotal = 0;
  
  public HashCodeBuilder()
  {
    this.iConstant = 37;
    this.iTotal = 17;
  }
  
  public HashCodeBuilder(int paramInt1, int paramInt2)
  {
    if (paramInt1 % 2 != 0)
    {
      bool1 = true;
      Validate.isTrue(bool1, "HashCodeBuilder requires an odd initial value", new Object[0]);
      if (paramInt2 % 2 == 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Validate.isTrue(bool1, "HashCodeBuilder requires an odd multiplier", new Object[0]);
      this.iConstant = paramInt2;
      this.iTotal = paramInt1;
      return;
      bool1 = false;
      break;
    }
  }
  
  static Set<IDKey> getRegistry()
  {
    return (Set)REGISTRY.get();
  }
  
  static boolean isRegistered(Object paramObject)
  {
    Set localSet = getRegistry();
    return (localSet != null) && (localSet.contains(new IDKey(paramObject)));
  }
  
  private static void reflectionAppend(Object paramObject, Class<?> paramClass, HashCodeBuilder paramHashCodeBuilder, boolean paramBoolean, String[] paramArrayOfString)
  {
    if (isRegistered(paramObject)) {
      return;
    }
    try
    {
      register(paramObject);
      paramClass = paramClass.getDeclaredFields();
      AccessibleObject.setAccessible(paramClass, true);
      int j = paramClass.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject = paramClass[i];
          if ((!ArrayUtils.contains(paramArrayOfString, localObject.getName())) && (localObject.getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(localObject.getModifiers()))))
          {
            boolean bool = Modifier.isStatic(localObject.getModifiers());
            if (bool) {}
          }
          try
          {
            paramHashCodeBuilder.append(localObject.get(paramObject));
            i += 1;
          }
          catch (IllegalAccessException paramClass)
          {
            throw new InternalError("Unexpected IllegalAccessException");
          }
        }
      }
    }
    finally
    {
      unregister(paramObject);
    }
  }
  
  public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject)
  {
    return reflectionHashCode(paramInt1, paramInt2, paramObject, false, null, new String[0]);
  }
  
  public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, null, new String[0]);
  }
  
  public static <T> int reflectionHashCode(int paramInt1, int paramInt2, T paramT, boolean paramBoolean, Class<? super T> paramClass, String... paramVarArgs)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("The object to build a hash code for must not be null");
    }
    HashCodeBuilder localHashCodeBuilder = new HashCodeBuilder(paramInt1, paramInt2);
    Class localClass = paramT.getClass();
    reflectionAppend(paramT, localClass, localHashCodeBuilder, paramBoolean, paramVarArgs);
    while ((localClass.getSuperclass() != null) && (localClass != paramClass))
    {
      localClass = localClass.getSuperclass();
      reflectionAppend(paramT, localClass, localHashCodeBuilder, paramBoolean, paramVarArgs);
    }
    return localHashCodeBuilder.toHashCode();
  }
  
  public static int reflectionHashCode(Object paramObject, Collection<String> paramCollection)
  {
    return reflectionHashCode(paramObject, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
  }
  
  public static int reflectionHashCode(Object paramObject, boolean paramBoolean)
  {
    return reflectionHashCode(17, 37, paramObject, paramBoolean, null, new String[0]);
  }
  
  public static int reflectionHashCode(Object paramObject, String... paramVarArgs)
  {
    return reflectionHashCode(17, 37, paramObject, false, null, paramVarArgs);
  }
  
  static void register(Object paramObject)
  {
    try
    {
      if (getRegistry() == null) {
        REGISTRY.set(new HashSet());
      }
      getRegistry().add(new IDKey(paramObject));
      return;
    }
    finally {}
  }
  
  static void unregister(Object paramObject)
  {
    Set localSet = getRegistry();
    if (localSet != null)
    {
      localSet.remove(new IDKey(paramObject));
      try
      {
        paramObject = getRegistry();
        if ((paramObject != null) && (paramObject.isEmpty())) {
          REGISTRY.remove();
        }
        return;
      }
      finally {}
    }
  }
  
  public HashCodeBuilder append(byte paramByte)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramByte);
    return this;
  }
  
  public HashCodeBuilder append(char paramChar)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramChar);
    return this;
  }
  
  public HashCodeBuilder append(double paramDouble)
  {
    return append(Double.doubleToLongBits(paramDouble));
  }
  
  public HashCodeBuilder append(float paramFloat)
  {
    this.iTotal = (this.iTotal * this.iConstant + Float.floatToIntBits(paramFloat));
    return this;
  }
  
  public HashCodeBuilder append(int paramInt)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramInt);
    return this;
  }
  
  public HashCodeBuilder append(long paramLong)
  {
    this.iTotal = (this.iTotal * this.iConstant + (int)(paramLong >> 32 ^ paramLong));
    return this;
  }
  
  public HashCodeBuilder append(Object paramObject)
  {
    if (paramObject == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      if ((paramObject instanceof long[]))
      {
        append((long[])paramObject);
        return this;
      }
      if ((paramObject instanceof int[]))
      {
        append((int[])paramObject);
        return this;
      }
      if ((paramObject instanceof short[]))
      {
        append((short[])paramObject);
        return this;
      }
      if ((paramObject instanceof char[]))
      {
        append((char[])paramObject);
        return this;
      }
      if ((paramObject instanceof byte[]))
      {
        append((byte[])paramObject);
        return this;
      }
      if ((paramObject instanceof double[]))
      {
        append((double[])paramObject);
        return this;
      }
      if ((paramObject instanceof float[]))
      {
        append((float[])paramObject);
        return this;
      }
      if ((paramObject instanceof boolean[]))
      {
        append((boolean[])paramObject);
        return this;
      }
      append((Object[])paramObject);
      return this;
    }
    this.iTotal = (this.iTotal * this.iConstant + paramObject.hashCode());
    return this;
  }
  
  public HashCodeBuilder append(short paramShort)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramShort);
    return this;
  }
  
  public HashCodeBuilder append(boolean paramBoolean)
  {
    int j = this.iTotal;
    int k = this.iConstant;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      this.iTotal = (i + k * j);
      return this;
    }
  }
  
  public HashCodeBuilder append(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfByte[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfChar[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfDouble.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfDouble[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfFloat[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfInt[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfLong[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfObject[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfShort.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfShort[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder append(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      this.iTotal *= this.iConstant;
    }
    for (;;)
    {
      return this;
      int j = paramArrayOfBoolean.length;
      int i = 0;
      while (i < j)
      {
        append(paramArrayOfBoolean[i]);
        i += 1;
      }
    }
  }
  
  public HashCodeBuilder appendSuper(int paramInt)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramInt);
    return this;
  }
  
  public Integer build()
  {
    return Integer.valueOf(toHashCode());
  }
  
  public int hashCode()
  {
    return toHashCode();
  }
  
  public int toHashCode()
  {
    return this.iTotal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.HashCodeBuilder
 * JD-Core Version:    0.7.0.1
 */