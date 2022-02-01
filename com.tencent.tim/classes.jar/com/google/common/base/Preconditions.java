package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class Preconditions
{
  private static String badElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("negative size: " + paramInt2);
    }
    return format("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private static String badPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("negative size: " + paramInt2);
    }
    return format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private static String badPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt3)) {
      return badPositionIndex(paramInt1, paramInt3, "start index");
    }
    if ((paramInt2 < 0) || (paramInt2 > paramInt3)) {
      return badPositionIndex(paramInt2, paramInt3, "end index");
    }
    return format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar1, char paramChar2)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { paramObject }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, paramVarArgs));
    }
  }
  
  @CanIgnoreReturnValue
  public static int checkElementIndex(int paramInt1, int paramInt2)
  {
    return checkElementIndex(paramInt1, paramInt2, "index");
  }
  
  @CanIgnoreReturnValue
  public static int checkElementIndex(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException(badElementIndex(paramInt1, paramInt2, paramString));
    }
    return paramInt1;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar1, char paramChar2)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar, int paramInt)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar, long paramLong)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar, @Nullable Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt, char paramChar)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt, long paramLong)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt, @Nullable Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong, char paramChar)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong, int paramInt)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong1, long paramLong2)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong, @Nullable Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { paramObject }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject, char paramChar)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject, int paramInt)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject, long paramLong)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { paramObject1, paramObject2 }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static int checkPositionIndex(int paramInt1, int paramInt2)
  {
    return checkPositionIndex(paramInt1, paramInt2, "index");
  }
  
  @CanIgnoreReturnValue
  public static int checkPositionIndex(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2)) {
      throw new IndexOutOfBoundsException(badPositionIndex(paramInt1, paramInt2, paramString));
    }
    return paramInt1;
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > paramInt3)) {
      throw new IndexOutOfBoundsException(badPositionIndexes(paramInt1, paramInt2, paramInt3));
    }
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar1, char paramChar2)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { paramObject }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, paramVarArgs));
    }
  }
  
  static String format(String paramString, @Nullable Object... paramVarArgs)
  {
    int i = 0;
    paramString = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramVarArgs.length * 16);
    int j = 0;
    for (;;)
    {
      int k;
      if (i < paramVarArgs.length)
      {
        k = paramString.indexOf("%s", j);
        if (k != -1) {}
      }
      else
      {
        localStringBuilder.append(paramString, j, paramString.length());
        if (i >= paramVarArgs.length) {
          break label157;
        }
        localStringBuilder.append(" [");
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
        while (i < paramVarArgs.length)
        {
          localStringBuilder.append(", ");
          localStringBuilder.append(paramVarArgs[i]);
          i += 1;
        }
      }
      localStringBuilder.append(paramString, j, k);
      localStringBuilder.append(paramVarArgs[i]);
      j = k + 2;
      i += 1;
    }
    localStringBuilder.append(']');
    label157:
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Preconditions
 * JD-Core Version:    0.7.0.1
 */