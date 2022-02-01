package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableInt;

public class ArrayUtils
{
  public static final boolean[] EMPTY_BOOLEAN_ARRAY;
  public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY;
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY;
  public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
  public static final char[] EMPTY_CHAR_ARRAY;
  public static final Class<?>[] EMPTY_CLASS_ARRAY;
  public static final double[] EMPTY_DOUBLE_ARRAY;
  public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY;
  public static final float[] EMPTY_FLOAT_ARRAY;
  public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY;
  public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY;
  public static final int[] EMPTY_INT_ARRAY;
  public static final long[] EMPTY_LONG_ARRAY;
  public static final Long[] EMPTY_LONG_OBJECT_ARRAY;
  public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
  public static final short[] EMPTY_SHORT_ARRAY;
  public static final Short[] EMPTY_SHORT_OBJECT_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final int INDEX_NOT_FOUND = -1;
  
  static
  {
    EMPTY_CLASS_ARRAY = new Class[0];
    EMPTY_STRING_ARRAY = new String[0];
    EMPTY_LONG_ARRAY = new long[0];
    EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    EMPTY_INT_ARRAY = new int[0];
    EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    EMPTY_SHORT_ARRAY = new short[0];
    EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    EMPTY_DOUBLE_ARRAY = new double[0];
    EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    EMPTY_FLOAT_ARRAY = new float[0];
    EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    EMPTY_BOOLEAN_ARRAY = new boolean[0];
    EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    EMPTY_CHAR_ARRAY = new char[0];
  }
  
  private static Object add(Object paramObject1, int paramInt, Object paramObject2, Class<?> paramClass)
  {
    if (paramObject1 == null)
    {
      if (paramInt != 0) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: 0");
      }
      paramObject1 = Array.newInstance(paramClass, 1);
      Array.set(paramObject1, 0, paramObject2);
      paramObject2 = paramObject1;
    }
    int i;
    do
    {
      return paramObject2;
      i = Array.getLength(paramObject1);
      if ((paramInt > i) || (paramInt < 0)) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
      }
      paramClass = Array.newInstance(paramClass, i + 1);
      System.arraycopy(paramObject1, 0, paramClass, 0, paramInt);
      Array.set(paramClass, paramInt, paramObject2);
      paramObject2 = paramClass;
    } while (paramInt >= i);
    System.arraycopy(paramObject1, paramInt, paramClass, paramInt + 1, i - paramInt);
    return paramClass;
  }
  
  public static byte[] add(byte[] paramArrayOfByte, byte paramByte)
  {
    paramArrayOfByte = (byte[])copyArrayGrow1(paramArrayOfByte, Byte.TYPE);
    paramArrayOfByte[(paramArrayOfByte.length - 1)] = paramByte;
    return paramArrayOfByte;
  }
  
  public static byte[] add(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    return (byte[])add(paramArrayOfByte, paramInt, Byte.valueOf(paramByte), Byte.TYPE);
  }
  
  public static char[] add(char[] paramArrayOfChar, char paramChar)
  {
    paramArrayOfChar = (char[])copyArrayGrow1(paramArrayOfChar, Character.TYPE);
    paramArrayOfChar[(paramArrayOfChar.length - 1)] = paramChar;
    return paramArrayOfChar;
  }
  
  public static char[] add(char[] paramArrayOfChar, int paramInt, char paramChar)
  {
    return (char[])add(paramArrayOfChar, paramInt, Character.valueOf(paramChar), Character.TYPE);
  }
  
  public static double[] add(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble = (double[])copyArrayGrow1(paramArrayOfDouble, Double.TYPE);
    paramArrayOfDouble[(paramArrayOfDouble.length - 1)] = paramDouble;
    return paramArrayOfDouble;
  }
  
  public static double[] add(double[] paramArrayOfDouble, int paramInt, double paramDouble)
  {
    return (double[])add(paramArrayOfDouble, paramInt, Double.valueOf(paramDouble), Double.TYPE);
  }
  
  public static float[] add(float[] paramArrayOfFloat, float paramFloat)
  {
    paramArrayOfFloat = (float[])copyArrayGrow1(paramArrayOfFloat, Float.TYPE);
    paramArrayOfFloat[(paramArrayOfFloat.length - 1)] = paramFloat;
    return paramArrayOfFloat;
  }
  
  public static float[] add(float[] paramArrayOfFloat, int paramInt, float paramFloat)
  {
    return (float[])add(paramArrayOfFloat, paramInt, Float.valueOf(paramFloat), Float.TYPE);
  }
  
  public static int[] add(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = (int[])copyArrayGrow1(paramArrayOfInt, Integer.TYPE);
    paramArrayOfInt[(paramArrayOfInt.length - 1)] = paramInt;
    return paramArrayOfInt;
  }
  
  public static int[] add(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return (int[])add(paramArrayOfInt, paramInt1, Integer.valueOf(paramInt2), Integer.TYPE);
  }
  
  public static long[] add(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    return (long[])add(paramArrayOfLong, paramInt, Long.valueOf(paramLong), Long.TYPE);
  }
  
  public static long[] add(long[] paramArrayOfLong, long paramLong)
  {
    paramArrayOfLong = (long[])copyArrayGrow1(paramArrayOfLong, Long.TYPE);
    paramArrayOfLong[(paramArrayOfLong.length - 1)] = paramLong;
    return paramArrayOfLong;
  }
  
  public static <T> T[] add(T[] paramArrayOfT, int paramInt, T paramT)
  {
    if (paramArrayOfT != null) {}
    for (Class localClass = paramArrayOfT.getClass().getComponentType();; localClass = paramT.getClass())
    {
      return (Object[])add(paramArrayOfT, paramInt, paramT, localClass);
      if (paramT == null) {
        break;
      }
    }
    throw new IllegalArgumentException("Array and element cannot both be null");
  }
  
  public static <T> T[] add(T[] paramArrayOfT, T paramT)
  {
    if (paramArrayOfT != null) {}
    for (Class localClass = paramArrayOfT.getClass().getComponentType();; localClass = paramT.getClass())
    {
      paramArrayOfT = (Object[])copyArrayGrow1(paramArrayOfT, localClass);
      paramArrayOfT[(paramArrayOfT.length - 1)] = paramT;
      return paramArrayOfT;
      if (paramT == null) {
        break;
      }
    }
    throw new IllegalArgumentException("Arguments cannot both be null");
  }
  
  public static short[] add(short[] paramArrayOfShort, int paramInt, short paramShort)
  {
    return (short[])add(paramArrayOfShort, paramInt, Short.valueOf(paramShort), Short.TYPE);
  }
  
  public static short[] add(short[] paramArrayOfShort, short paramShort)
  {
    paramArrayOfShort = (short[])copyArrayGrow1(paramArrayOfShort, Short.TYPE);
    paramArrayOfShort[(paramArrayOfShort.length - 1)] = paramShort;
    return paramArrayOfShort;
  }
  
  public static boolean[] add(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    return (boolean[])add(paramArrayOfBoolean, paramInt, Boolean.valueOf(paramBoolean), Boolean.TYPE);
  }
  
  public static boolean[] add(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    paramArrayOfBoolean = (boolean[])copyArrayGrow1(paramArrayOfBoolean, Boolean.TYPE);
    paramArrayOfBoolean[(paramArrayOfBoolean.length - 1)] = paramBoolean;
    return paramArrayOfBoolean;
  }
  
  public static byte[] addAll(byte[] paramArrayOfByte1, byte... paramVarArgs)
  {
    if (paramArrayOfByte1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfByte1);
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfByte, paramArrayOfByte1.length, paramVarArgs.length);
    return arrayOfByte;
  }
  
  public static char[] addAll(char[] paramArrayOfChar1, char... paramVarArgs)
  {
    if (paramArrayOfChar1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfChar1);
    }
    char[] arrayOfChar = new char[paramArrayOfChar1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfChar1, 0, arrayOfChar, 0, paramArrayOfChar1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfChar, paramArrayOfChar1.length, paramVarArgs.length);
    return arrayOfChar;
  }
  
  public static double[] addAll(double[] paramArrayOfDouble1, double... paramVarArgs)
  {
    if (paramArrayOfDouble1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfDouble1);
    }
    double[] arrayOfDouble = new double[paramArrayOfDouble1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfDouble1, 0, arrayOfDouble, 0, paramArrayOfDouble1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfDouble, paramArrayOfDouble1.length, paramVarArgs.length);
    return arrayOfDouble;
  }
  
  public static float[] addAll(float[] paramArrayOfFloat1, float... paramVarArgs)
  {
    if (paramArrayOfFloat1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfFloat1);
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfFloat1, 0, arrayOfFloat, 0, paramArrayOfFloat1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfFloat, paramArrayOfFloat1.length, paramVarArgs.length);
    return arrayOfFloat;
  }
  
  public static int[] addAll(int[] paramArrayOfInt1, int... paramVarArgs)
  {
    if (paramArrayOfInt1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfInt1);
    }
    int[] arrayOfInt = new int[paramArrayOfInt1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, paramArrayOfInt1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfInt, paramArrayOfInt1.length, paramVarArgs.length);
    return arrayOfInt;
  }
  
  public static long[] addAll(long[] paramArrayOfLong1, long... paramVarArgs)
  {
    if (paramArrayOfLong1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfLong1);
    }
    long[] arrayOfLong = new long[paramArrayOfLong1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfLong1, 0, arrayOfLong, 0, paramArrayOfLong1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfLong, paramArrayOfLong1.length, paramVarArgs.length);
    return arrayOfLong;
  }
  
  public static <T> T[] addAll(T[] paramArrayOfT1, T... paramVarArgs)
  {
    if (paramArrayOfT1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfT1);
    }
    Class localClass = paramArrayOfT1.getClass().getComponentType();
    Object[] arrayOfObject = (Object[])Array.newInstance(localClass, paramArrayOfT1.length + paramVarArgs.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    try
    {
      System.arraycopy(paramVarArgs, 0, arrayOfObject, paramArrayOfT1.length, paramVarArgs.length);
      return arrayOfObject;
    }
    catch (ArrayStoreException paramArrayOfT1)
    {
      paramVarArgs = paramVarArgs.getClass().getComponentType();
      if (!localClass.isAssignableFrom(paramVarArgs)) {
        throw new IllegalArgumentException("Cannot store " + paramVarArgs.getName() + " in an array of " + localClass.getName(), paramArrayOfT1);
      }
      throw paramArrayOfT1;
    }
  }
  
  public static short[] addAll(short[] paramArrayOfShort1, short... paramVarArgs)
  {
    if (paramArrayOfShort1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfShort1);
    }
    short[] arrayOfShort = new short[paramArrayOfShort1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfShort1, 0, arrayOfShort, 0, paramArrayOfShort1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfShort, paramArrayOfShort1.length, paramVarArgs.length);
    return arrayOfShort;
  }
  
  public static boolean[] addAll(boolean[] paramArrayOfBoolean1, boolean... paramVarArgs)
  {
    if (paramArrayOfBoolean1 == null) {
      return clone(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return clone(paramArrayOfBoolean1);
    }
    boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean1.length + paramVarArgs.length];
    System.arraycopy(paramArrayOfBoolean1, 0, arrayOfBoolean, 0, paramArrayOfBoolean1.length);
    System.arraycopy(paramVarArgs, 0, arrayOfBoolean, paramArrayOfBoolean1.length, paramVarArgs.length);
    return arrayOfBoolean;
  }
  
  public static byte[] clone(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return (byte[])paramArrayOfByte.clone();
  }
  
  public static char[] clone(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    return (char[])paramArrayOfChar.clone();
  }
  
  public static double[] clone(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null) {
      return null;
    }
    return (double[])paramArrayOfDouble.clone();
  }
  
  public static float[] clone(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    return (float[])paramArrayOfFloat.clone();
  }
  
  public static int[] clone(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    return (int[])paramArrayOfInt.clone();
  }
  
  public static long[] clone(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    return (long[])paramArrayOfLong.clone();
  }
  
  public static <T> T[] clone(T[] paramArrayOfT)
  {
    if (paramArrayOfT == null) {
      return null;
    }
    return (Object[])paramArrayOfT.clone();
  }
  
  public static short[] clone(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    return (short[])paramArrayOfShort.clone();
  }
  
  public static boolean[] clone(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      return null;
    }
    return (boolean[])paramArrayOfBoolean.clone();
  }
  
  public static boolean contains(byte[] paramArrayOfByte, byte paramByte)
  {
    return indexOf(paramArrayOfByte, paramByte) != -1;
  }
  
  public static boolean contains(char[] paramArrayOfChar, char paramChar)
  {
    return indexOf(paramArrayOfChar, paramChar) != -1;
  }
  
  public static boolean contains(double[] paramArrayOfDouble, double paramDouble)
  {
    return indexOf(paramArrayOfDouble, paramDouble) != -1;
  }
  
  public static boolean contains(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    boolean bool = false;
    if (indexOf(paramArrayOfDouble, paramDouble1, 0, paramDouble2) != -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean contains(float[] paramArrayOfFloat, float paramFloat)
  {
    return indexOf(paramArrayOfFloat, paramFloat) != -1;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt) != -1;
  }
  
  public static boolean contains(long[] paramArrayOfLong, long paramLong)
  {
    return indexOf(paramArrayOfLong, paramLong) != -1;
  }
  
  public static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    return indexOf(paramArrayOfObject, paramObject) != -1;
  }
  
  public static boolean contains(short[] paramArrayOfShort, short paramShort)
  {
    return indexOf(paramArrayOfShort, paramShort) != -1;
  }
  
  public static boolean contains(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return indexOf(paramArrayOfBoolean, paramBoolean) != -1;
  }
  
  private static Object copyArrayGrow1(Object paramObject, Class<?> paramClass)
  {
    if (paramObject != null)
    {
      int i = Array.getLength(paramObject);
      paramClass = Array.newInstance(paramObject.getClass().getComponentType(), i + 1);
      System.arraycopy(paramObject, 0, paramClass, 0, i);
      return paramClass;
    }
    return Array.newInstance(paramClass, 1);
  }
  
  public static int getLength(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return Array.getLength(paramObject);
  }
  
  public static int hashCode(Object paramObject)
  {
    return new HashCodeBuilder().append(paramObject).toHashCode();
  }
  
  public static int indexOf(byte[] paramArrayOfByte, byte paramByte)
  {
    return indexOf(paramArrayOfByte, paramByte, 0);
  }
  
  public static int indexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        break label38;
      }
      paramInt = i;
      if (paramByte == paramArrayOfByte[i]) {
        break;
      }
      i += 1;
    }
    label38:
    return -1;
  }
  
  public static int indexOf(char[] paramArrayOfChar, char paramChar)
  {
    return indexOf(paramArrayOfChar, paramChar, 0);
  }
  
  public static int indexOf(char[] paramArrayOfChar, char paramChar, int paramInt)
  {
    if (paramArrayOfChar == null)
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfChar.length) {
        break label38;
      }
      paramInt = i;
      if (paramChar == paramArrayOfChar[i]) {
        break;
      }
      i += 1;
    }
    label38:
    return -1;
  }
  
  public static int indexOf(double[] paramArrayOfDouble, double paramDouble)
  {
    return indexOf(paramArrayOfDouble, paramDouble, 0);
  }
  
  public static int indexOf(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    return indexOf(paramArrayOfDouble, paramDouble1, 0, paramDouble2);
  }
  
  public static int indexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt)
  {
    if (isEmpty(paramArrayOfDouble))
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfDouble.length) {
        break label49;
      }
      paramInt = i;
      if (paramDouble == paramArrayOfDouble[i]) {
        break;
      }
      i += 1;
    }
    label49:
    return -1;
  }
  
  public static int indexOf(double[] paramArrayOfDouble, double paramDouble1, int paramInt, double paramDouble2)
  {
    if (isEmpty(paramArrayOfDouble))
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfDouble.length) {
        break label64;
      }
      if (paramArrayOfDouble[i] >= paramDouble1 - paramDouble2)
      {
        paramInt = i;
        if (paramArrayOfDouble[i] <= paramDouble1 + paramDouble2) {
          break;
        }
      }
      i += 1;
    }
    label64:
    return -1;
  }
  
  public static int indexOf(float[] paramArrayOfFloat, float paramFloat)
  {
    return indexOf(paramArrayOfFloat, paramFloat, 0);
  }
  
  public static int indexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if (isEmpty(paramArrayOfFloat))
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfFloat.length) {
        break label42;
      }
      paramInt = i;
      if (paramFloat == paramArrayOfFloat[i]) {
        break;
      }
      i += 1;
    }
    label42:
    return -1;
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt, 0);
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null)
    {
      paramInt2 = -1;
      return paramInt2;
    }
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        break label38;
      }
      paramInt2 = i;
      if (paramInt1 == paramArrayOfInt[i]) {
        break;
      }
      i += 1;
    }
    label38:
    return -1;
  }
  
  public static int indexOf(long[] paramArrayOfLong, long paramLong)
  {
    return indexOf(paramArrayOfLong, paramLong, 0);
  }
  
  public static int indexOf(long[] paramArrayOfLong, long paramLong, int paramInt)
  {
    if (paramArrayOfLong == null)
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfLong.length) {
        break label46;
      }
      paramInt = i;
      if (paramLong == paramArrayOfLong[i]) {
        break;
      }
      i += 1;
    }
    label46:
    return -1;
  }
  
  public static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    return indexOf(paramArrayOfObject, paramObject, 0);
  }
  
  public static int indexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int i;
      if (paramObject == null)
      {
        i = paramInt;
        for (;;)
        {
          if (i >= paramArrayOfObject.length) {
            break label82;
          }
          paramInt = i;
          if (paramArrayOfObject[i] == null) {
            break;
          }
          i += 1;
        }
      }
      if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject))
      {
        i = paramInt;
        for (;;)
        {
          if (i >= paramArrayOfObject.length) {
            break label82;
          }
          paramInt = i;
          if (paramObject.equals(paramArrayOfObject[i])) {
            break;
          }
          i += 1;
        }
      }
      label82:
      return -1;
    }
  }
  
  public static int indexOf(short[] paramArrayOfShort, short paramShort)
  {
    return indexOf(paramArrayOfShort, paramShort, 0);
  }
  
  public static int indexOf(short[] paramArrayOfShort, short paramShort, int paramInt)
  {
    if (paramArrayOfShort == null)
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfShort.length) {
        break label38;
      }
      paramInt = i;
      if (paramShort == paramArrayOfShort[i]) {
        break;
      }
      i += 1;
    }
    label38:
    return -1;
  }
  
  public static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return indexOf(paramArrayOfBoolean, paramBoolean, 0);
  }
  
  public static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt)
  {
    if (isEmpty(paramArrayOfBoolean))
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfBoolean.length) {
        break label41;
      }
      paramInt = i;
      if (paramBoolean == paramArrayOfBoolean[i]) {
        break;
      }
      i += 1;
    }
    label41:
    return -1;
  }
  
  public static boolean isEmpty(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }
  
  public static boolean isEmpty(char[] paramArrayOfChar)
  {
    return (paramArrayOfChar == null) || (paramArrayOfChar.length == 0);
  }
  
  public static boolean isEmpty(double[] paramArrayOfDouble)
  {
    return (paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0);
  }
  
  public static boolean isEmpty(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0);
  }
  
  public static boolean isEmpty(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static boolean isEmpty(long[] paramArrayOfLong)
  {
    return (paramArrayOfLong == null) || (paramArrayOfLong.length == 0);
  }
  
  public static boolean isEmpty(Object[] paramArrayOfObject)
  {
    return (paramArrayOfObject == null) || (paramArrayOfObject.length == 0);
  }
  
  public static boolean isEmpty(short[] paramArrayOfShort)
  {
    return (paramArrayOfShort == null) || (paramArrayOfShort.length == 0);
  }
  
  public static boolean isEmpty(boolean[] paramArrayOfBoolean)
  {
    return (paramArrayOfBoolean == null) || (paramArrayOfBoolean.length == 0);
  }
  
  @Deprecated
  public static boolean isEquals(Object paramObject1, Object paramObject2)
  {
    return new EqualsBuilder().append(paramObject1, paramObject2).isEquals();
  }
  
  public static boolean isNotEmpty(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length != 0);
  }
  
  public static boolean isNotEmpty(char[] paramArrayOfChar)
  {
    return (paramArrayOfChar != null) && (paramArrayOfChar.length != 0);
  }
  
  public static boolean isNotEmpty(double[] paramArrayOfDouble)
  {
    return (paramArrayOfDouble != null) && (paramArrayOfDouble.length != 0);
  }
  
  public static boolean isNotEmpty(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0);
  }
  
  public static boolean isNotEmpty(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length != 0);
  }
  
  public static boolean isNotEmpty(long[] paramArrayOfLong)
  {
    return (paramArrayOfLong != null) && (paramArrayOfLong.length != 0);
  }
  
  public static <T> boolean isNotEmpty(T[] paramArrayOfT)
  {
    return (paramArrayOfT != null) && (paramArrayOfT.length != 0);
  }
  
  public static boolean isNotEmpty(short[] paramArrayOfShort)
  {
    return (paramArrayOfShort != null) && (paramArrayOfShort.length != 0);
  }
  
  public static boolean isNotEmpty(boolean[] paramArrayOfBoolean)
  {
    return (paramArrayOfBoolean != null) && (paramArrayOfBoolean.length != 0);
  }
  
  public static boolean isSameLength(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return ((paramArrayOfByte1 != null) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) && ((paramArrayOfByte2 != null) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0)) && ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length == paramArrayOfByte2.length));
  }
  
  public static boolean isSameLength(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    return ((paramArrayOfChar1 != null) || (paramArrayOfChar2 == null) || (paramArrayOfChar2.length <= 0)) && ((paramArrayOfChar2 != null) || (paramArrayOfChar1 == null) || (paramArrayOfChar1.length <= 0)) && ((paramArrayOfChar1 == null) || (paramArrayOfChar2 == null) || (paramArrayOfChar1.length == paramArrayOfChar2.length));
  }
  
  public static boolean isSameLength(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    return ((paramArrayOfDouble1 != null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble2.length <= 0)) && ((paramArrayOfDouble2 != null) || (paramArrayOfDouble1 == null) || (paramArrayOfDouble1.length <= 0)) && ((paramArrayOfDouble1 == null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble1.length == paramArrayOfDouble2.length));
  }
  
  public static boolean isSameLength(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return ((paramArrayOfFloat1 != null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length <= 0)) && ((paramArrayOfFloat2 != null) || (paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length <= 0)) && ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat1.length == paramArrayOfFloat2.length));
  }
  
  public static boolean isSameLength(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return ((paramArrayOfInt1 != null) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) && ((paramArrayOfInt2 != null) || (paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) && ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null) || (paramArrayOfInt1.length == paramArrayOfInt2.length));
  }
  
  public static boolean isSameLength(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    return ((paramArrayOfLong1 != null) || (paramArrayOfLong2 == null) || (paramArrayOfLong2.length <= 0)) && ((paramArrayOfLong2 != null) || (paramArrayOfLong1 == null) || (paramArrayOfLong1.length <= 0)) && ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null) || (paramArrayOfLong1.length == paramArrayOfLong2.length));
  }
  
  public static boolean isSameLength(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return ((paramArrayOfObject1 != null) || (paramArrayOfObject2 == null) || (paramArrayOfObject2.length <= 0)) && ((paramArrayOfObject2 != null) || (paramArrayOfObject1 == null) || (paramArrayOfObject1.length <= 0)) && ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null) || (paramArrayOfObject1.length == paramArrayOfObject2.length));
  }
  
  public static boolean isSameLength(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    return ((paramArrayOfShort1 != null) || (paramArrayOfShort2 == null) || (paramArrayOfShort2.length <= 0)) && ((paramArrayOfShort2 != null) || (paramArrayOfShort1 == null) || (paramArrayOfShort1.length <= 0)) && ((paramArrayOfShort1 == null) || (paramArrayOfShort2 == null) || (paramArrayOfShort1.length == paramArrayOfShort2.length));
  }
  
  public static boolean isSameLength(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    return ((paramArrayOfBoolean1 != null) || (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean2.length <= 0)) && ((paramArrayOfBoolean2 != null) || (paramArrayOfBoolean1 == null) || (paramArrayOfBoolean1.length <= 0)) && ((paramArrayOfBoolean1 == null) || (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean1.length == paramArrayOfBoolean2.length));
  }
  
  public static boolean isSameType(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    return paramObject1.getClass().getName().equals(paramObject2.getClass().getName());
  }
  
  public static boolean isSorted(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    byte b1 = paramArrayOfByte[0];
    int j = paramArrayOfByte.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label60;
      }
      byte b2 = paramArrayOfByte[i];
      bool1 = bool2;
      if (NumberUtils.compare(b1, b2) > 0) {
        break;
      }
      i += 1;
      b1 = b2;
    }
    label60:
    return true;
  }
  
  public static boolean isSorted(char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    char c1 = paramArrayOfChar[0];
    int j = paramArrayOfChar.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label60;
      }
      char c2 = paramArrayOfChar[i];
      bool1 = bool2;
      if (CharUtils.compare(c1, c2) > 0) {
        break;
      }
      i += 1;
      c1 = c2;
    }
    label60:
    return true;
  }
  
  public static boolean isSorted(double[] paramArrayOfDouble)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    double d1 = paramArrayOfDouble[0];
    int j = paramArrayOfDouble.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label65;
      }
      double d2 = paramArrayOfDouble[i];
      bool1 = bool2;
      if (Double.compare(d1, d2) > 0) {
        break;
      }
      i += 1;
      d1 = d2;
    }
    label65:
    return true;
  }
  
  public static boolean isSorted(float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    float f1 = paramArrayOfFloat[0];
    int j = paramArrayOfFloat.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label60;
      }
      float f2 = paramArrayOfFloat[i];
      bool1 = bool2;
      if (Float.compare(f1, f2) > 0) {
        break;
      }
      i += 1;
      f1 = f2;
    }
    label60:
    return true;
  }
  
  public static boolean isSorted(int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    int j = paramArrayOfInt[0];
    int m = paramArrayOfInt.length;
    int i = 1;
    for (;;)
    {
      if (i >= m) {
        break label60;
      }
      int k = paramArrayOfInt[i];
      bool1 = bool2;
      if (NumberUtils.compare(j, k) > 0) {
        break;
      }
      i += 1;
      j = k;
    }
    label60:
    return true;
  }
  
  public static boolean isSorted(long[] paramArrayOfLong)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    long l1 = paramArrayOfLong[0];
    int j = paramArrayOfLong.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label61;
      }
      long l2 = paramArrayOfLong[i];
      bool1 = bool2;
      if (NumberUtils.compare(l1, l2) > 0) {
        break;
      }
      i += 1;
      l1 = l2;
    }
    label61:
    return true;
  }
  
  public static <T extends Comparable<? super T>> boolean isSorted(T[] paramArrayOfT)
  {
    return isSorted(paramArrayOfT, new ArrayUtils.1());
  }
  
  public static <T> boolean isSorted(T[] paramArrayOfT, Comparator<T> paramComparator)
  {
    boolean bool2 = false;
    if (paramComparator == null) {
      throw new IllegalArgumentException("Comparator should not be null.");
    }
    boolean bool1;
    if ((paramArrayOfT == null) || (paramArrayOfT.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    Object localObject = paramArrayOfT[0];
    int j = paramArrayOfT.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label82;
      }
      T ? = paramArrayOfT[i];
      bool1 = bool2;
      if (paramComparator.compare(localObject, ?) > 0) {
        break;
      }
      i += 1;
      localObject = ?;
    }
    label82:
    return true;
  }
  
  public static boolean isSorted(short[] paramArrayOfShort)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    short s1 = paramArrayOfShort[0];
    int j = paramArrayOfShort.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label60;
      }
      short s2 = paramArrayOfShort[i];
      bool1 = bool2;
      if (NumberUtils.compare(s1, s2) > 0) {
        break;
      }
      i += 1;
      s1 = s2;
    }
    label60:
    return true;
  }
  
  public static boolean isSorted(boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.length < 2))
    {
      bool1 = true;
      return bool1;
    }
    int k = paramArrayOfBoolean[0];
    int j = paramArrayOfBoolean.length;
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        break label61;
      }
      int m = paramArrayOfBoolean[i];
      bool1 = bool2;
      if (BooleanUtils.compare(k, m) > 0) {
        break;
      }
      i += 1;
      k = m;
    }
    label61:
    return true;
  }
  
  public static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte)
  {
    return lastIndexOf(paramArrayOfByte, paramByte, 2147483647);
  }
  
  public static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfByte.length) {
          i = paramArrayOfByte.length - 1;
        }
        while (i >= 0)
        {
          if (paramByte == paramArrayOfByte[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(char[] paramArrayOfChar, char paramChar)
  {
    return lastIndexOf(paramArrayOfChar, paramChar, 2147483647);
  }
  
  public static int lastIndexOf(char[] paramArrayOfChar, char paramChar, int paramInt)
  {
    if (paramArrayOfChar == null) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfChar.length) {
          i = paramArrayOfChar.length - 1;
        }
        while (i >= 0)
        {
          if (paramChar == paramArrayOfChar[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble)
  {
    return lastIndexOf(paramArrayOfDouble, paramDouble, 2147483647);
  }
  
  public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    return lastIndexOf(paramArrayOfDouble, paramDouble1, 2147483647, paramDouble2);
  }
  
  public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt)
  {
    if (isEmpty(paramArrayOfDouble)) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfDouble.length) {
          i = paramArrayOfDouble.length - 1;
        }
        while (i >= 0)
        {
          if (paramDouble == paramArrayOfDouble[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble1, int paramInt, double paramDouble2)
  {
    if (isEmpty(paramArrayOfDouble)) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfDouble.length) {
          i = paramArrayOfDouble.length - 1;
        }
        while (i >= 0)
        {
          if ((paramArrayOfDouble[i] >= paramDouble1 - paramDouble2) && (paramArrayOfDouble[i] <= paramDouble1 + paramDouble2)) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(float[] paramArrayOfFloat, float paramFloat)
  {
    return lastIndexOf(paramArrayOfFloat, paramFloat, 2147483647);
  }
  
  public static int lastIndexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if (isEmpty(paramArrayOfFloat)) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfFloat.length) {
          i = paramArrayOfFloat.length - 1;
        }
        while (i >= 0)
        {
          if (paramFloat == paramArrayOfFloat[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(int[] paramArrayOfInt, int paramInt)
  {
    return lastIndexOf(paramArrayOfInt, paramInt, 2147483647);
  }
  
  public static int lastIndexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      return -1;
      if (paramInt2 >= 0)
      {
        int i = paramInt2;
        if (paramInt2 >= paramArrayOfInt.length) {
          i = paramArrayOfInt.length - 1;
        }
        while (i >= 0)
        {
          if (paramInt1 == paramArrayOfInt[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(long[] paramArrayOfLong, long paramLong)
  {
    return lastIndexOf(paramArrayOfLong, paramLong, 2147483647);
  }
  
  public static int lastIndexOf(long[] paramArrayOfLong, long paramLong, int paramInt)
  {
    if (paramArrayOfLong == null) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfLong.length) {
          i = paramArrayOfLong.length - 1;
        }
        while (i >= 0)
        {
          if (paramLong == paramArrayOfLong[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    return lastIndexOf(paramArrayOfObject, paramObject, 2147483647);
  }
  
  public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null) {}
    while (paramInt < 0) {
      return -1;
    }
    if (paramInt >= paramArrayOfObject.length) {
      paramInt = paramArrayOfObject.length - 1;
    }
    for (;;)
    {
      if (paramObject == null)
      {
        while (paramInt >= 0)
        {
          if (paramArrayOfObject[paramInt] == null) {
            return paramInt;
          }
          paramInt -= 1;
        }
        break;
      }
      if (!paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
        break;
      }
      while (paramInt >= 0)
      {
        if (paramObject.equals(paramArrayOfObject[paramInt])) {
          return paramInt;
        }
        paramInt -= 1;
      }
      break;
    }
  }
  
  public static int lastIndexOf(short[] paramArrayOfShort, short paramShort)
  {
    return lastIndexOf(paramArrayOfShort, paramShort, 2147483647);
  }
  
  public static int lastIndexOf(short[] paramArrayOfShort, short paramShort, int paramInt)
  {
    if (paramArrayOfShort == null) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfShort.length) {
          i = paramArrayOfShort.length - 1;
        }
        while (i >= 0)
        {
          if (paramShort == paramArrayOfShort[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return lastIndexOf(paramArrayOfBoolean, paramBoolean, 2147483647);
  }
  
  public static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt)
  {
    if (isEmpty(paramArrayOfBoolean)) {}
    for (;;)
    {
      return -1;
      if (paramInt >= 0)
      {
        int i = paramInt;
        if (paramInt >= paramArrayOfBoolean.length) {
          i = paramArrayOfBoolean.length - 1;
        }
        while (i >= 0)
        {
          if (paramBoolean == paramArrayOfBoolean[i]) {
            return i;
          }
          i -= 1;
        }
      }
    }
  }
  
  public static byte[] nullToEmpty(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (isEmpty(paramArrayOfByte)) {
      arrayOfByte = EMPTY_BYTE_ARRAY;
    }
    return arrayOfByte;
  }
  
  public static char[] nullToEmpty(char[] paramArrayOfChar)
  {
    char[] arrayOfChar = paramArrayOfChar;
    if (isEmpty(paramArrayOfChar)) {
      arrayOfChar = EMPTY_CHAR_ARRAY;
    }
    return arrayOfChar;
  }
  
  public static double[] nullToEmpty(double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = paramArrayOfDouble;
    if (isEmpty(paramArrayOfDouble)) {
      arrayOfDouble = EMPTY_DOUBLE_ARRAY;
    }
    return arrayOfDouble;
  }
  
  public static float[] nullToEmpty(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = paramArrayOfFloat;
    if (isEmpty(paramArrayOfFloat)) {
      arrayOfFloat = EMPTY_FLOAT_ARRAY;
    }
    return arrayOfFloat;
  }
  
  public static int[] nullToEmpty(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (isEmpty(paramArrayOfInt)) {
      arrayOfInt = EMPTY_INT_ARRAY;
    }
    return arrayOfInt;
  }
  
  public static long[] nullToEmpty(long[] paramArrayOfLong)
  {
    long[] arrayOfLong = paramArrayOfLong;
    if (isEmpty(paramArrayOfLong)) {
      arrayOfLong = EMPTY_LONG_ARRAY;
    }
    return arrayOfLong;
  }
  
  public static Boolean[] nullToEmpty(Boolean[] paramArrayOfBoolean)
  {
    Boolean[] arrayOfBoolean = paramArrayOfBoolean;
    if (isEmpty(paramArrayOfBoolean)) {
      arrayOfBoolean = EMPTY_BOOLEAN_OBJECT_ARRAY;
    }
    return arrayOfBoolean;
  }
  
  public static Byte[] nullToEmpty(Byte[] paramArrayOfByte)
  {
    Byte[] arrayOfByte = paramArrayOfByte;
    if (isEmpty(paramArrayOfByte)) {
      arrayOfByte = EMPTY_BYTE_OBJECT_ARRAY;
    }
    return arrayOfByte;
  }
  
  public static Character[] nullToEmpty(Character[] paramArrayOfCharacter)
  {
    Character[] arrayOfCharacter = paramArrayOfCharacter;
    if (isEmpty(paramArrayOfCharacter)) {
      arrayOfCharacter = EMPTY_CHARACTER_OBJECT_ARRAY;
    }
    return arrayOfCharacter;
  }
  
  public static Class<?>[] nullToEmpty(Class<?>[] paramArrayOfClass)
  {
    Object localObject = paramArrayOfClass;
    if (isEmpty(paramArrayOfClass)) {
      localObject = EMPTY_CLASS_ARRAY;
    }
    return localObject;
  }
  
  public static Double[] nullToEmpty(Double[] paramArrayOfDouble)
  {
    Double[] arrayOfDouble = paramArrayOfDouble;
    if (isEmpty(paramArrayOfDouble)) {
      arrayOfDouble = EMPTY_DOUBLE_OBJECT_ARRAY;
    }
    return arrayOfDouble;
  }
  
  public static Float[] nullToEmpty(Float[] paramArrayOfFloat)
  {
    Float[] arrayOfFloat = paramArrayOfFloat;
    if (isEmpty(paramArrayOfFloat)) {
      arrayOfFloat = EMPTY_FLOAT_OBJECT_ARRAY;
    }
    return arrayOfFloat;
  }
  
  public static Integer[] nullToEmpty(Integer[] paramArrayOfInteger)
  {
    Integer[] arrayOfInteger = paramArrayOfInteger;
    if (isEmpty(paramArrayOfInteger)) {
      arrayOfInteger = EMPTY_INTEGER_OBJECT_ARRAY;
    }
    return arrayOfInteger;
  }
  
  public static Long[] nullToEmpty(Long[] paramArrayOfLong)
  {
    Long[] arrayOfLong = paramArrayOfLong;
    if (isEmpty(paramArrayOfLong)) {
      arrayOfLong = EMPTY_LONG_OBJECT_ARRAY;
    }
    return arrayOfLong;
  }
  
  public static Object[] nullToEmpty(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (isEmpty(paramArrayOfObject)) {
      arrayOfObject = EMPTY_OBJECT_ARRAY;
    }
    return arrayOfObject;
  }
  
  public static Short[] nullToEmpty(Short[] paramArrayOfShort)
  {
    Short[] arrayOfShort = paramArrayOfShort;
    if (isEmpty(paramArrayOfShort)) {
      arrayOfShort = EMPTY_SHORT_OBJECT_ARRAY;
    }
    return arrayOfShort;
  }
  
  public static String[] nullToEmpty(String[] paramArrayOfString)
  {
    String[] arrayOfString = paramArrayOfString;
    if (isEmpty(paramArrayOfString)) {
      arrayOfString = EMPTY_STRING_ARRAY;
    }
    return arrayOfString;
  }
  
  public static short[] nullToEmpty(short[] paramArrayOfShort)
  {
    short[] arrayOfShort = paramArrayOfShort;
    if (isEmpty(paramArrayOfShort)) {
      arrayOfShort = EMPTY_SHORT_ARRAY;
    }
    return arrayOfShort;
  }
  
  public static boolean[] nullToEmpty(boolean[] paramArrayOfBoolean)
  {
    boolean[] arrayOfBoolean = paramArrayOfBoolean;
    if (isEmpty(paramArrayOfBoolean)) {
      arrayOfBoolean = EMPTY_BOOLEAN_ARRAY;
    }
    return arrayOfBoolean;
  }
  
  private static Object remove(Object paramObject, int paramInt)
  {
    int i = getLength(paramObject);
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
    }
    Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), i - 1);
    System.arraycopy(paramObject, 0, localObject, 0, paramInt);
    if (paramInt < i - 1) {
      System.arraycopy(paramObject, paramInt + 1, localObject, paramInt, i - paramInt - 1);
    }
    return localObject;
  }
  
  public static byte[] remove(byte[] paramArrayOfByte, int paramInt)
  {
    return (byte[])remove(paramArrayOfByte, paramInt);
  }
  
  public static char[] remove(char[] paramArrayOfChar, int paramInt)
  {
    return (char[])remove(paramArrayOfChar, paramInt);
  }
  
  public static double[] remove(double[] paramArrayOfDouble, int paramInt)
  {
    return (double[])remove(paramArrayOfDouble, paramInt);
  }
  
  public static float[] remove(float[] paramArrayOfFloat, int paramInt)
  {
    return (float[])remove(paramArrayOfFloat, paramInt);
  }
  
  public static int[] remove(int[] paramArrayOfInt, int paramInt)
  {
    return (int[])remove(paramArrayOfInt, paramInt);
  }
  
  public static long[] remove(long[] paramArrayOfLong, int paramInt)
  {
    return (long[])remove(paramArrayOfLong, paramInt);
  }
  
  public static <T> T[] remove(T[] paramArrayOfT, int paramInt)
  {
    return (Object[])remove(paramArrayOfT, paramInt);
  }
  
  public static short[] remove(short[] paramArrayOfShort, int paramInt)
  {
    return (short[])remove(paramArrayOfShort, paramInt);
  }
  
  public static boolean[] remove(boolean[] paramArrayOfBoolean, int paramInt)
  {
    return (boolean[])remove(paramArrayOfBoolean, paramInt);
  }
  
  static Object removeAll(Object paramObject, BitSet paramBitSet)
  {
    int i = 0;
    int m = getLength(paramObject);
    int j = paramBitSet.cardinality();
    Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), m - j);
    j = 0;
    for (;;)
    {
      int n = paramBitSet.nextSetBit(j);
      if (n == -1) {
        break;
      }
      int i1 = n - j;
      k = i;
      if (i1 > 0)
      {
        System.arraycopy(paramObject, j, localObject, i, i1);
        k = i + i1;
      }
      j = paramBitSet.nextClearBit(n);
      i = k;
    }
    int k = m - j;
    if (k > 0) {
      System.arraycopy(paramObject, j, localObject, i, k);
    }
    return localObject;
  }
  
  static Object removeAll(Object paramObject, int... paramVarArgs)
  {
    int k = getLength(paramObject);
    int j;
    int m;
    int i;
    if (isNotEmpty(paramVarArgs))
    {
      Arrays.sort(paramVarArgs);
      j = paramVarArgs.length;
      m = k;
      i = 0;
      for (;;)
      {
        j -= 1;
        n = i;
        if (j < 0) {
          break;
        }
        n = paramVarArgs[j];
        if ((n < 0) || (n >= k)) {
          throw new IndexOutOfBoundsException("Index: " + n + ", Length: " + k);
        }
        if (n < m)
        {
          i += 1;
          m = n;
        }
      }
    }
    int n = 0;
    Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), k - n);
    if (n < k)
    {
      i = paramVarArgs.length;
      j = k - n;
      i -= 1;
      while (i >= 0)
      {
        n = paramVarArgs[i];
        m = j;
        if (k - n > 1)
        {
          k = k - n - 1;
          m = j - k;
          System.arraycopy(paramObject, n + 1, localObject, m, k);
        }
        i -= 1;
        k = n;
        j = m;
      }
      if (k > 0) {
        System.arraycopy(paramObject, 0, localObject, 0, k);
      }
    }
    return localObject;
  }
  
  public static byte[] removeAll(byte[] paramArrayOfByte, int... paramVarArgs)
  {
    return (byte[])removeAll(paramArrayOfByte, clone(paramVarArgs));
  }
  
  public static char[] removeAll(char[] paramArrayOfChar, int... paramVarArgs)
  {
    return (char[])removeAll(paramArrayOfChar, clone(paramVarArgs));
  }
  
  public static double[] removeAll(double[] paramArrayOfDouble, int... paramVarArgs)
  {
    return (double[])removeAll(paramArrayOfDouble, clone(paramVarArgs));
  }
  
  public static float[] removeAll(float[] paramArrayOfFloat, int... paramVarArgs)
  {
    return (float[])removeAll(paramArrayOfFloat, clone(paramVarArgs));
  }
  
  public static int[] removeAll(int[] paramArrayOfInt1, int... paramVarArgs)
  {
    return (int[])removeAll(paramArrayOfInt1, clone(paramVarArgs));
  }
  
  public static long[] removeAll(long[] paramArrayOfLong, int... paramVarArgs)
  {
    return (long[])removeAll(paramArrayOfLong, clone(paramVarArgs));
  }
  
  public static <T> T[] removeAll(T[] paramArrayOfT, int... paramVarArgs)
  {
    return (Object[])removeAll(paramArrayOfT, clone(paramVarArgs));
  }
  
  public static short[] removeAll(short[] paramArrayOfShort, int... paramVarArgs)
  {
    return (short[])removeAll(paramArrayOfShort, clone(paramVarArgs));
  }
  
  public static boolean[] removeAll(boolean[] paramArrayOfBoolean, int... paramVarArgs)
  {
    return (boolean[])removeAll(paramArrayOfBoolean, clone(paramVarArgs));
  }
  
  public static byte[] removeElement(byte[] paramArrayOfByte, byte paramByte)
  {
    int i = indexOf(paramArrayOfByte, paramByte);
    if (i == -1) {
      return clone(paramArrayOfByte);
    }
    return remove(paramArrayOfByte, i);
  }
  
  public static char[] removeElement(char[] paramArrayOfChar, char paramChar)
  {
    int i = indexOf(paramArrayOfChar, paramChar);
    if (i == -1) {
      return clone(paramArrayOfChar);
    }
    return remove(paramArrayOfChar, i);
  }
  
  public static double[] removeElement(double[] paramArrayOfDouble, double paramDouble)
  {
    int i = indexOf(paramArrayOfDouble, paramDouble);
    if (i == -1) {
      return clone(paramArrayOfDouble);
    }
    return remove(paramArrayOfDouble, i);
  }
  
  public static float[] removeElement(float[] paramArrayOfFloat, float paramFloat)
  {
    int i = indexOf(paramArrayOfFloat, paramFloat);
    if (i == -1) {
      return clone(paramArrayOfFloat);
    }
    return remove(paramArrayOfFloat, i);
  }
  
  public static int[] removeElement(int[] paramArrayOfInt, int paramInt)
  {
    paramInt = indexOf(paramArrayOfInt, paramInt);
    if (paramInt == -1) {
      return clone(paramArrayOfInt);
    }
    return remove(paramArrayOfInt, paramInt);
  }
  
  public static long[] removeElement(long[] paramArrayOfLong, long paramLong)
  {
    int i = indexOf(paramArrayOfLong, paramLong);
    if (i == -1) {
      return clone(paramArrayOfLong);
    }
    return remove(paramArrayOfLong, i);
  }
  
  public static <T> T[] removeElement(T[] paramArrayOfT, Object paramObject)
  {
    int i = indexOf(paramArrayOfT, paramObject);
    if (i == -1) {
      return clone(paramArrayOfT);
    }
    return remove(paramArrayOfT, i);
  }
  
  public static short[] removeElement(short[] paramArrayOfShort, short paramShort)
  {
    int i = indexOf(paramArrayOfShort, paramShort);
    if (i == -1) {
      return clone(paramArrayOfShort);
    }
    return remove(paramArrayOfShort, i);
  }
  
  public static boolean[] removeElement(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    int i = indexOf(paramArrayOfBoolean, paramBoolean);
    if (i == -1) {
      return clone(paramArrayOfBoolean);
    }
    return remove(paramArrayOfBoolean, i);
  }
  
  public static byte[] removeElements(byte[] paramArrayOfByte1, byte... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfByte1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfByte1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Byte.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((Map)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((Map)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    label214:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Byte)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      i = 0;
      j = 0;
      for (;;)
      {
        if (i >= k) {
          break label214;
        }
        int m = indexOf(paramArrayOfByte1, ((Byte)localObject3).byteValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (byte[])removeAll(paramArrayOfByte1, paramVarArgs);
  }
  
  public static char[] removeElements(char[] paramArrayOfChar1, char... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfChar1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfChar1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Character.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label208:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Character)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      i = 0;
      j = 0;
      for (;;)
      {
        if (i >= k) {
          break label208;
        }
        int m = indexOf(paramArrayOfChar1, ((Character)localObject3).charValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (char[])removeAll(paramArrayOfChar1, paramVarArgs);
  }
  
  public static double[] removeElements(double[] paramArrayOfDouble1, double... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfDouble1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfDouble1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Double.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label208:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Double)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      j = 0;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label208;
        }
        int m = indexOf(paramArrayOfDouble1, ((Double)localObject3).doubleValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (double[])removeAll(paramArrayOfDouble1, paramVarArgs);
  }
  
  public static float[] removeElements(float[] paramArrayOfFloat1, float... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfFloat1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfFloat1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Float.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label208:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Float)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      i = 0;
      j = 0;
      for (;;)
      {
        if (i >= k) {
          break label208;
        }
        int m = indexOf(paramArrayOfFloat1, ((Float)localObject3).floatValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (float[])removeAll(paramArrayOfFloat1, paramVarArgs);
  }
  
  public static int[] removeElements(int[] paramArrayOfInt1, int... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfInt1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfInt1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Integer.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label208:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Integer)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      i = 0;
      j = 0;
      for (;;)
      {
        if (i >= k) {
          break label208;
        }
        int m = indexOf(paramArrayOfInt1, ((Integer)localObject3).intValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (int[])removeAll(paramArrayOfInt1, paramVarArgs);
  }
  
  public static long[] removeElements(long[] paramArrayOfLong1, long... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfLong1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfLong1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Long.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label208:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Long)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      j = 0;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label208;
        }
        int m = indexOf(paramArrayOfLong1, ((Long)localObject3).longValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (long[])removeAll(paramArrayOfLong1, paramVarArgs);
  }
  
  public static <T> T[] removeElements(T[] paramArrayOfT1, T... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfT1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfT1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = paramVarArgs[i];
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label199:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = ((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      i = 0;
      j = 0;
      for (;;)
      {
        if (i >= k) {
          break label199;
        }
        int m = indexOf(paramArrayOfT1, localObject3, j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (Object[])removeAll(paramArrayOfT1, paramVarArgs);
  }
  
  public static short[] removeElements(short[] paramArrayOfShort1, short... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfShort1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfShort1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Short.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label208:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Short)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      i = 0;
      j = 0;
      for (;;)
      {
        if (i >= k) {
          break label208;
        }
        int m = indexOf(paramArrayOfShort1, ((Short)localObject3).shortValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (short[])removeAll(paramArrayOfShort1, paramVarArgs);
  }
  
  public static boolean[] removeElements(boolean[] paramArrayOfBoolean1, boolean... paramVarArgs)
  {
    if ((isEmpty(paramArrayOfBoolean1)) || (isEmpty(paramVarArgs))) {
      return clone(paramArrayOfBoolean1);
    }
    Object localObject1 = new HashMap(2);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = Boolean.valueOf(paramVarArgs[i]);
      localObject3 = (MutableInt)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new MutableInt(1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((MutableInt)localObject3).increment();
      }
    }
    paramVarArgs = new BitSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label207:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Boolean)((Map.Entry)localObject2).getKey();
      int k = ((MutableInt)((Map.Entry)localObject2).getValue()).intValue();
      i = 0;
      j = 0;
      for (;;)
      {
        if (i >= k) {
          break label207;
        }
        int m = indexOf(paramArrayOfBoolean1, ((Boolean)localObject3).booleanValue(), j);
        if (m < 0) {
          break;
        }
        j = m + 1;
        paramVarArgs.set(m);
        i += 1;
      }
    }
    return (boolean[])removeAll(paramArrayOfBoolean1, paramVarArgs);
  }
  
  public static void reverse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    reverse(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static void reverse(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      int j = paramInt1;
      if (paramInt1 < 0) {
        j = 0;
      }
      paramInt1 = Math.min(paramArrayOfByte.length, paramInt2) - 1;
      while (paramInt1 > j)
      {
        int i = paramArrayOfByte[paramInt1];
        paramArrayOfByte[paramInt1] = paramArrayOfByte[j];
        paramArrayOfByte[j] = i;
        paramInt1 -= 1;
        j += 1;
      }
    }
  }
  
  public static void reverse(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return;
    }
    reverse(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static void reverse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {}
    for (;;)
    {
      return;
      int j = paramInt1;
      if (paramInt1 < 0) {
        j = 0;
      }
      paramInt1 = Math.min(paramArrayOfChar.length, paramInt2) - 1;
      while (paramInt1 > j)
      {
        int i = paramArrayOfChar[paramInt1];
        paramArrayOfChar[paramInt1] = paramArrayOfChar[j];
        paramArrayOfChar[j] = i;
        paramInt1 -= 1;
        j += 1;
      }
    }
  }
  
  public static void reverse(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null) {
      return;
    }
    reverse(paramArrayOfDouble, 0, paramArrayOfDouble.length);
  }
  
  public static void reverse(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramArrayOfDouble == null) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = Math.min(paramArrayOfDouble.length, paramInt2) - 1;
      while (paramInt1 > i)
      {
        double d = paramArrayOfDouble[paramInt1];
        paramArrayOfDouble[paramInt1] = paramArrayOfDouble[i];
        paramArrayOfDouble[i] = d;
        paramInt1 -= 1;
        i += 1;
      }
    }
  }
  
  public static void reverse(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return;
    }
    reverse(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }
  
  public static void reverse(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramArrayOfFloat == null) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = Math.min(paramArrayOfFloat.length, paramInt2) - 1;
      while (paramInt1 > i)
      {
        float f = paramArrayOfFloat[paramInt1];
        paramArrayOfFloat[paramInt1] = paramArrayOfFloat[i];
        paramArrayOfFloat[i] = f;
        paramInt1 -= 1;
        i += 1;
      }
    }
  }
  
  public static void reverse(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    reverse(paramArrayOfInt, 0, paramArrayOfInt.length);
  }
  
  public static void reverse(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = Math.min(paramArrayOfInt.length, paramInt2) - 1;
      while (paramInt1 > i)
      {
        paramInt2 = paramArrayOfInt[paramInt1];
        paramArrayOfInt[paramInt1] = paramArrayOfInt[i];
        paramArrayOfInt[i] = paramInt2;
        paramInt1 -= 1;
        i += 1;
      }
    }
  }
  
  public static void reverse(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return;
    }
    reverse(paramArrayOfLong, 0, paramArrayOfLong.length);
  }
  
  public static void reverse(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramArrayOfLong == null) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = Math.min(paramArrayOfLong.length, paramInt2) - 1;
      while (paramInt1 > i)
      {
        long l = paramArrayOfLong[paramInt1];
        paramArrayOfLong[paramInt1] = paramArrayOfLong[i];
        paramArrayOfLong[i] = l;
        paramInt1 -= 1;
        i += 1;
      }
    }
  }
  
  public static void reverse(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return;
    }
    reverse(paramArrayOfObject, 0, paramArrayOfObject.length);
  }
  
  public static void reverse(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    if (paramArrayOfObject == null) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = Math.min(paramArrayOfObject.length, paramInt2) - 1;
      while (paramInt1 > i)
      {
        Object localObject = paramArrayOfObject[paramInt1];
        paramArrayOfObject[paramInt1] = paramArrayOfObject[i];
        paramArrayOfObject[i] = localObject;
        paramInt1 -= 1;
        i += 1;
      }
    }
  }
  
  public static void reverse(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return;
    }
    reverse(paramArrayOfShort, 0, paramArrayOfShort.length);
  }
  
  public static void reverse(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (paramArrayOfShort == null) {}
    for (;;)
    {
      return;
      int j = paramInt1;
      if (paramInt1 < 0) {
        j = 0;
      }
      paramInt1 = Math.min(paramArrayOfShort.length, paramInt2) - 1;
      while (paramInt1 > j)
      {
        int i = paramArrayOfShort[paramInt1];
        paramArrayOfShort[paramInt1] = paramArrayOfShort[j];
        paramArrayOfShort[j] = i;
        paramInt1 -= 1;
        j += 1;
      }
    }
  }
  
  public static void reverse(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      return;
    }
    reverse(paramArrayOfBoolean, 0, paramArrayOfBoolean.length);
  }
  
  public static void reverse(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (paramArrayOfBoolean == null) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = Math.min(paramArrayOfBoolean.length, paramInt2) - 1;
      while (paramInt1 > i)
      {
        int j = paramArrayOfBoolean[paramInt1];
        paramArrayOfBoolean[paramInt1] = paramArrayOfBoolean[i];
        paramArrayOfBoolean[i] = j;
        paramInt1 -= 1;
        i += 1;
      }
    }
  }
  
  public static byte[] subarray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfByte.length) {
      paramInt1 = paramArrayOfByte.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, paramInt1);
    return arrayOfByte;
  }
  
  public static char[] subarray(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfChar.length) {
      paramInt1 = paramArrayOfChar.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_CHAR_ARRAY;
    }
    char[] arrayOfChar = new char[paramInt1];
    System.arraycopy(paramArrayOfChar, i, arrayOfChar, 0, paramInt1);
    return arrayOfChar;
  }
  
  public static double[] subarray(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramArrayOfDouble == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfDouble.length) {
      paramInt1 = paramArrayOfDouble.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_DOUBLE_ARRAY;
    }
    double[] arrayOfDouble = new double[paramInt1];
    System.arraycopy(paramArrayOfDouble, i, arrayOfDouble, 0, paramInt1);
    return arrayOfDouble;
  }
  
  public static float[] subarray(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfFloat.length) {
      paramInt1 = paramArrayOfFloat.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_FLOAT_ARRAY;
    }
    float[] arrayOfFloat = new float[paramInt1];
    System.arraycopy(paramArrayOfFloat, i, arrayOfFloat, 0, paramInt1);
    return arrayOfFloat;
  }
  
  public static int[] subarray(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfInt.length) {
      paramInt1 = paramArrayOfInt.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_INT_ARRAY;
    }
    int[] arrayOfInt = new int[paramInt1];
    System.arraycopy(paramArrayOfInt, i, arrayOfInt, 0, paramInt1);
    return arrayOfInt;
  }
  
  public static long[] subarray(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfLong.length) {
      paramInt1 = paramArrayOfLong.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_LONG_ARRAY;
    }
    long[] arrayOfLong = new long[paramInt1];
    System.arraycopy(paramArrayOfLong, i, arrayOfLong, 0, paramInt1);
    return arrayOfLong;
  }
  
  public static <T> T[] subarray(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    if (paramArrayOfT == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfT.length) {
      paramInt1 = paramArrayOfT.length;
    }
    paramInt1 -= i;
    Object localObject = paramArrayOfT.getClass().getComponentType();
    if (paramInt1 <= 0) {
      return (Object[])Array.newInstance((Class)localObject, 0);
    }
    localObject = (Object[])Array.newInstance((Class)localObject, paramInt1);
    System.arraycopy(paramArrayOfT, i, localObject, 0, paramInt1);
    return localObject;
  }
  
  public static short[] subarray(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfShort.length) {
      paramInt1 = paramArrayOfShort.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_SHORT_ARRAY;
    }
    short[] arrayOfShort = new short[paramInt1];
    System.arraycopy(paramArrayOfShort, i, arrayOfShort, 0, paramInt1);
    return arrayOfShort;
  }
  
  public static boolean[] subarray(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (paramArrayOfBoolean == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramArrayOfBoolean.length) {
      paramInt1 = paramArrayOfBoolean.length;
    }
    paramInt1 -= i;
    if (paramInt1 <= 0) {
      return EMPTY_BOOLEAN_ARRAY;
    }
    boolean[] arrayOfBoolean = new boolean[paramInt1];
    System.arraycopy(paramArrayOfBoolean, i, arrayOfBoolean, 0, paramInt1);
    return arrayOfBoolean;
  }
  
  public static <T> T[] toArray(T... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  public static Map<Object, Object> toMap(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    HashMap localHashMap = new HashMap((int)(paramArrayOfObject.length * 1.5D));
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if ((localObject instanceof Map.Entry))
      {
        localObject = (Map.Entry)localObject;
        localHashMap.put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      }
      for (;;)
      {
        i += 1;
        break;
        if (!(localObject instanceof Object[])) {
          break label157;
        }
        Object[] arrayOfObject = (Object[])localObject;
        if (arrayOfObject.length < 2) {
          throw new IllegalArgumentException("Array element " + i + ", '" + localObject + "', has a length less than 2");
        }
        localHashMap.put(arrayOfObject[0], arrayOfObject[1]);
      }
      label157:
      throw new IllegalArgumentException("Array element " + i + ", '" + localObject + "', is neither of type Map.Entry nor an Array");
    }
    return localHashMap;
  }
  
  public static Boolean[] toObject(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      return null;
    }
    if (paramArrayOfBoolean.length == 0) {
      return EMPTY_BOOLEAN_OBJECT_ARRAY;
    }
    Boolean[] arrayOfBoolean = new Boolean[paramArrayOfBoolean.length];
    int i = 0;
    if (i < paramArrayOfBoolean.length)
    {
      if (paramArrayOfBoolean[i] != 0) {}
      for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
      {
        arrayOfBoolean[i] = localBoolean;
        i += 1;
        break;
      }
    }
    return arrayOfBoolean;
  }
  
  public static Byte[] toObject(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BYTE_OBJECT_ARRAY;
    }
    Byte[] arrayOfByte = new Byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = Byte.valueOf(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static Character[] toObject(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    if (paramArrayOfChar.length == 0) {
      return EMPTY_CHARACTER_OBJECT_ARRAY;
    }
    Character[] arrayOfCharacter = new Character[paramArrayOfChar.length];
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      arrayOfCharacter[i] = Character.valueOf(paramArrayOfChar[i]);
      i += 1;
    }
    return arrayOfCharacter;
  }
  
  public static Double[] toObject(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null) {
      return null;
    }
    if (paramArrayOfDouble.length == 0) {
      return EMPTY_DOUBLE_OBJECT_ARRAY;
    }
    Double[] arrayOfDouble = new Double[paramArrayOfDouble.length];
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      arrayOfDouble[i] = Double.valueOf(paramArrayOfDouble[i]);
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public static Float[] toObject(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    if (paramArrayOfFloat.length == 0) {
      return EMPTY_FLOAT_OBJECT_ARRAY;
    }
    Float[] arrayOfFloat = new Float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = Float.valueOf(paramArrayOfFloat[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static Integer[] toObject(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    if (paramArrayOfInt.length == 0) {
      return EMPTY_INTEGER_OBJECT_ARRAY;
    }
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static Long[] toObject(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    if (paramArrayOfLong.length == 0) {
      return EMPTY_LONG_OBJECT_ARRAY;
    }
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static Short[] toObject(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    if (paramArrayOfShort.length == 0) {
      return EMPTY_SHORT_OBJECT_ARRAY;
    }
    Short[] arrayOfShort = new Short[paramArrayOfShort.length];
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      arrayOfShort[i] = Short.valueOf(paramArrayOfShort[i]);
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static byte[] toPrimitive(Byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = paramArrayOfByte[i].byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] toPrimitive(Byte[] paramArrayOfByte, byte paramByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int j = 0;
    if (j < paramArrayOfByte.length)
    {
      Byte localByte = paramArrayOfByte[j];
      if (localByte == null) {}
      for (int i = paramByte;; i = localByte.byteValue())
      {
        arrayOfByte[j] = i;
        j += 1;
        break;
      }
    }
    return arrayOfByte;
  }
  
  public static char[] toPrimitive(Character[] paramArrayOfCharacter)
  {
    if (paramArrayOfCharacter == null) {
      return null;
    }
    if (paramArrayOfCharacter.length == 0) {
      return EMPTY_CHAR_ARRAY;
    }
    char[] arrayOfChar = new char[paramArrayOfCharacter.length];
    int i = 0;
    while (i < paramArrayOfCharacter.length)
    {
      arrayOfChar[i] = paramArrayOfCharacter[i].charValue();
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static char[] toPrimitive(Character[] paramArrayOfCharacter, char paramChar)
  {
    if (paramArrayOfCharacter == null) {
      return null;
    }
    if (paramArrayOfCharacter.length == 0) {
      return EMPTY_CHAR_ARRAY;
    }
    char[] arrayOfChar = new char[paramArrayOfCharacter.length];
    int j = 0;
    if (j < paramArrayOfCharacter.length)
    {
      Character localCharacter = paramArrayOfCharacter[j];
      if (localCharacter == null) {}
      for (int i = paramChar;; i = localCharacter.charValue())
      {
        arrayOfChar[j] = i;
        j += 1;
        break;
      }
    }
    return arrayOfChar;
  }
  
  public static double[] toPrimitive(Double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null) {
      return null;
    }
    if (paramArrayOfDouble.length == 0) {
      return EMPTY_DOUBLE_ARRAY;
    }
    double[] arrayOfDouble = new double[paramArrayOfDouble.length];
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      arrayOfDouble[i] = paramArrayOfDouble[i].doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public static double[] toPrimitive(Double[] paramArrayOfDouble, double paramDouble)
  {
    if (paramArrayOfDouble == null) {
      return null;
    }
    if (paramArrayOfDouble.length == 0) {
      return EMPTY_DOUBLE_ARRAY;
    }
    double[] arrayOfDouble = new double[paramArrayOfDouble.length];
    int i = 0;
    if (i < paramArrayOfDouble.length)
    {
      Double localDouble = paramArrayOfDouble[i];
      if (localDouble == null) {}
      for (double d = paramDouble;; d = localDouble.doubleValue())
      {
        arrayOfDouble[i] = d;
        i += 1;
        break;
      }
    }
    return arrayOfDouble;
  }
  
  public static float[] toPrimitive(Float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    if (paramArrayOfFloat.length == 0) {
      return EMPTY_FLOAT_ARRAY;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static float[] toPrimitive(Float[] paramArrayOfFloat, float paramFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    if (paramArrayOfFloat.length == 0) {
      return EMPTY_FLOAT_ARRAY;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    if (i < paramArrayOfFloat.length)
    {
      Float localFloat = paramArrayOfFloat[i];
      if (localFloat == null) {}
      for (float f = paramFloat;; f = localFloat.floatValue())
      {
        arrayOfFloat[i] = f;
        i += 1;
        break;
      }
    }
    return arrayOfFloat;
  }
  
  public static int[] toPrimitive(Integer[] paramArrayOfInteger)
  {
    if (paramArrayOfInteger == null) {
      return null;
    }
    if (paramArrayOfInteger.length == 0) {
      return EMPTY_INT_ARRAY;
    }
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    int i = 0;
    while (i < paramArrayOfInteger.length)
    {
      arrayOfInt[i] = paramArrayOfInteger[i].intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static int[] toPrimitive(Integer[] paramArrayOfInteger, int paramInt)
  {
    if (paramArrayOfInteger == null) {
      return null;
    }
    if (paramArrayOfInteger.length == 0) {
      return EMPTY_INT_ARRAY;
    }
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    int i = 0;
    if (i < paramArrayOfInteger.length)
    {
      Integer localInteger = paramArrayOfInteger[i];
      if (localInteger == null) {}
      for (int j = paramInt;; j = localInteger.intValue())
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public static long[] toPrimitive(Long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    if (paramArrayOfLong.length == 0) {
      return EMPTY_LONG_ARRAY;
    }
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = paramArrayOfLong[i].longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static long[] toPrimitive(Long[] paramArrayOfLong, long paramLong)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    if (paramArrayOfLong.length == 0) {
      return EMPTY_LONG_ARRAY;
    }
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    int i = 0;
    if (i < paramArrayOfLong.length)
    {
      Long localLong = paramArrayOfLong[i];
      if (localLong == null) {}
      for (long l = paramLong;; l = localLong.longValue())
      {
        arrayOfLong[i] = l;
        i += 1;
        break;
      }
    }
    return arrayOfLong;
  }
  
  public static short[] toPrimitive(Short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    if (paramArrayOfShort.length == 0) {
      return EMPTY_SHORT_ARRAY;
    }
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      arrayOfShort[i] = paramArrayOfShort[i].shortValue();
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static short[] toPrimitive(Short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    if (paramArrayOfShort.length == 0) {
      return EMPTY_SHORT_ARRAY;
    }
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    int j = 0;
    if (j < paramArrayOfShort.length)
    {
      Short localShort = paramArrayOfShort[j];
      if (localShort == null) {}
      for (int i = paramShort;; i = localShort.shortValue())
      {
        arrayOfShort[j] = i;
        j += 1;
        break;
      }
    }
    return arrayOfShort;
  }
  
  public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      return null;
    }
    if (paramArrayOfBoolean.length == 0) {
      return EMPTY_BOOLEAN_ARRAY;
    }
    boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      arrayOfBoolean[i] = paramArrayOfBoolean[i].booleanValue();
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean == null) {
      return null;
    }
    if (paramArrayOfBoolean.length == 0) {
      return EMPTY_BOOLEAN_ARRAY;
    }
    boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
    int i = 0;
    if (i < paramArrayOfBoolean.length)
    {
      Boolean localBoolean = paramArrayOfBoolean[i];
      if (localBoolean == null) {}
      for (boolean bool = paramBoolean;; bool = localBoolean.booleanValue())
      {
        arrayOfBoolean[i] = bool;
        i += 1;
        break;
      }
    }
    return arrayOfBoolean;
  }
  
  public static String toString(Object paramObject)
  {
    return toString(paramObject, "{}");
  }
  
  public static String toString(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return new ToStringBuilder(paramObject, ToStringStyle.SIMPLE_STYLE).append(paramObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */