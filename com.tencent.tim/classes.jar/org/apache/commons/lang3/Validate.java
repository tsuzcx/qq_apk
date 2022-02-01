package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Validate
{
  private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
  private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
  private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
  private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
  private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
  private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
  private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
  private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
  private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
  private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
  private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
  private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
  private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
  private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
  private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
  private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
  private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
  private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";
  
  public static void exclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if ((paramDouble3 <= paramDouble1) || (paramDouble3 >= paramDouble2)) {
      throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { Double.valueOf(paramDouble3), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
    }
  }
  
  public static void exclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3, String paramString)
  {
    if ((paramDouble3 <= paramDouble1) || (paramDouble3 >= paramDouble2)) {
      throw new IllegalArgumentException(String.format(paramString, new Object[0]));
    }
  }
  
  public static void exclusiveBetween(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 <= paramLong1) || (paramLong3 >= paramLong2)) {
      throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { Long.valueOf(paramLong3), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
  }
  
  public static void exclusiveBetween(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if ((paramLong3 <= paramLong1) || (paramLong3 >= paramLong2)) {
      throw new IllegalArgumentException(String.format(paramString, new Object[0]));
    }
  }
  
  public static <T> void exclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable)
  {
    if ((paramComparable.compareTo(paramT1) <= 0) || (paramComparable.compareTo(paramT2) >= 0)) {
      throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { paramComparable, paramT1, paramT2 }));
    }
  }
  
  public static <T> void exclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable, String paramString, Object... paramVarArgs)
  {
    if ((paramComparable.compareTo(paramT1) <= 0) || (paramComparable.compareTo(paramT2) >= 0)) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void inclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if ((paramDouble3 < paramDouble1) || (paramDouble3 > paramDouble2)) {
      throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { Double.valueOf(paramDouble3), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
    }
  }
  
  public static void inclusiveBetween(double paramDouble1, double paramDouble2, double paramDouble3, String paramString)
  {
    if ((paramDouble3 < paramDouble1) || (paramDouble3 > paramDouble2)) {
      throw new IllegalArgumentException(String.format(paramString, new Object[0]));
    }
  }
  
  public static void inclusiveBetween(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 < paramLong1) || (paramLong3 > paramLong2)) {
      throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { Long.valueOf(paramLong3), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
  }
  
  public static void inclusiveBetween(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if ((paramLong3 < paramLong1) || (paramLong3 > paramLong2)) {
      throw new IllegalArgumentException(String.format(paramString, new Object[0]));
    }
  }
  
  public static <T> void inclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable)
  {
    if ((paramComparable.compareTo(paramT1) < 0) || (paramComparable.compareTo(paramT2) > 0)) {
      throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { paramComparable, paramT1, paramT2 }));
    }
  }
  
  public static <T> void inclusiveBetween(T paramT1, T paramT2, Comparable<T> paramComparable, String paramString, Object... paramVarArgs)
  {
    if ((paramComparable.compareTo(paramT1) < 0) || (paramComparable.compareTo(paramT2) > 0)) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void isAssignableFrom(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!paramClass1.isAssignableFrom(paramClass2))
    {
      if (paramClass2 == null) {}
      for (paramClass2 = "null";; paramClass2 = paramClass2.getName()) {
        throw new IllegalArgumentException(String.format("Cannot assign a %s to a %s", new Object[] { paramClass2, paramClass1.getName() }));
      }
    }
  }
  
  public static void isAssignableFrom(Class<?> paramClass1, Class<?> paramClass2, String paramString, Object... paramVarArgs)
  {
    if (!paramClass1.isAssignableFrom(paramClass2)) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void isInstanceOf(Class<?> paramClass, Object paramObject)
  {
    if (!paramClass.isInstance(paramObject))
    {
      String str = paramClass.getName();
      if (paramObject == null) {}
      for (paramClass = "null";; paramClass = paramObject.getClass().getName()) {
        throw new IllegalArgumentException(String.format("Expected type: %s, actual: %s", new Object[] { str, paramClass }));
      }
    }
  }
  
  public static void isInstanceOf(Class<?> paramClass, Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (!paramClass.isInstance(paramObject)) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void isTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException("The validated expression is false");
    }
  }
  
  public static void isTrue(boolean paramBoolean, String paramString, double paramDouble)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, new Object[] { Double.valueOf(paramDouble) }));
    }
  }
  
  public static void isTrue(boolean paramBoolean, String paramString, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public static void isTrue(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void matchesPattern(CharSequence paramCharSequence, String paramString)
  {
    if (!Pattern.matches(paramString, paramCharSequence)) {
      throw new IllegalArgumentException(String.format("The string %s does not match the pattern %s", new Object[] { paramCharSequence, paramString }));
    }
  }
  
  public static void matchesPattern(CharSequence paramCharSequence, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!Pattern.matches(paramString1, paramCharSequence)) {
      throw new IllegalArgumentException(String.format(paramString2, paramVarArgs));
    }
  }
  
  public static <T extends Iterable<?>> T noNullElements(T paramT)
  {
    return noNullElements(paramT, "The validated collection contains null element at index: %d", new Object[0]);
  }
  
  public static <T extends Iterable<?>> T noNullElements(T paramT, String paramString, Object... paramVarArgs)
  {
    notNull(paramT);
    Iterator localIterator = paramT.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (localIterator.next() == null) {
        throw new IllegalArgumentException(String.format(paramString, ArrayUtils.addAll(paramVarArgs, new Object[] { Integer.valueOf(i) })));
      }
      i += 1;
    }
    return paramT;
  }
  
  public static <T> T[] noNullElements(T[] paramArrayOfT)
  {
    return noNullElements(paramArrayOfT, "The validated array contains null element at index: %d", new Object[0]);
  }
  
  public static <T> T[] noNullElements(T[] paramArrayOfT, String paramString, Object... paramVarArgs)
  {
    notNull(paramArrayOfT);
    int i = 0;
    while (i < paramArrayOfT.length)
    {
      if (paramArrayOfT[i] == null) {
        throw new IllegalArgumentException(String.format(paramString, ArrayUtils.add(paramVarArgs, Integer.valueOf(i))));
      }
      i += 1;
    }
    return paramArrayOfT;
  }
  
  public static <T extends CharSequence> T notBlank(T paramT)
  {
    return notBlank(paramT, "The validated character sequence is blank", new Object[0]);
  }
  
  public static <T extends CharSequence> T notBlank(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(String.format(paramString, paramVarArgs));
    }
    if (StringUtils.isBlank(paramT)) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T extends CharSequence> T notEmpty(T paramT)
  {
    return notEmpty(paramT, "The validated character sequence is empty", new Object[0]);
  }
  
  public static <T extends CharSequence> T notEmpty(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(String.format(paramString, paramVarArgs));
    }
    if (paramT.length() == 0) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T extends Collection<?>> T notEmpty(T paramT)
  {
    return notEmpty(paramT, "The validated collection is empty", new Object[0]);
  }
  
  public static <T extends Collection<?>> T notEmpty(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(String.format(paramString, paramVarArgs));
    }
    if (paramT.isEmpty()) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T extends Map<?, ?>> T notEmpty(T paramT)
  {
    return notEmpty(paramT, "The validated map is empty", new Object[0]);
  }
  
  public static <T extends Map<?, ?>> T notEmpty(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(String.format(paramString, paramVarArgs));
    }
    if (paramT.isEmpty()) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T> T[] notEmpty(T[] paramArrayOfT)
  {
    return notEmpty(paramArrayOfT, "The validated array is empty", new Object[0]);
  }
  
  public static <T> T[] notEmpty(T[] paramArrayOfT, String paramString, Object... paramVarArgs)
  {
    if (paramArrayOfT == null) {
      throw new NullPointerException(String.format(paramString, paramVarArgs));
    }
    if (paramArrayOfT.length == 0) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
    return paramArrayOfT;
  }
  
  public static <T> T notNull(T paramT)
  {
    return notNull(paramT, "The validated object is null", new Object[0]);
  }
  
  public static <T> T notNull(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T extends CharSequence> T validIndex(T paramT, int paramInt)
  {
    return validIndex(paramT, paramInt, "The validated character sequence index is invalid: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static <T extends CharSequence> T validIndex(T paramT, int paramInt, String paramString, Object... paramVarArgs)
  {
    notNull(paramT);
    if ((paramInt < 0) || (paramInt >= paramT.length())) {
      throw new IndexOutOfBoundsException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T extends Collection<?>> T validIndex(T paramT, int paramInt)
  {
    return validIndex(paramT, paramInt, "The validated collection index is invalid: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static <T extends Collection<?>> T validIndex(T paramT, int paramInt, String paramString, Object... paramVarArgs)
  {
    notNull(paramT);
    if ((paramInt < 0) || (paramInt >= paramT.size())) {
      throw new IndexOutOfBoundsException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T> T[] validIndex(T[] paramArrayOfT, int paramInt)
  {
    return validIndex(paramArrayOfT, paramInt, "The validated array index is invalid: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static <T> T[] validIndex(T[] paramArrayOfT, int paramInt, String paramString, Object... paramVarArgs)
  {
    notNull(paramArrayOfT);
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      throw new IndexOutOfBoundsException(String.format(paramString, paramVarArgs));
    }
    return paramArrayOfT;
  }
  
  public static void validState(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException("The validated state is false");
    }
  }
  
  public static void validState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.format(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.Validate
 * JD-Core Version:    0.7.0.1
 */