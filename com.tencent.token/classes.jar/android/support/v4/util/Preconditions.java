package android.support.v4.util;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static float checkArgumentFinite(float paramFloat, String paramString)
  {
    if (!Float.isNaN(paramFloat))
    {
      if (!Float.isInfinite(paramFloat)) {
        return paramFloat;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" must not be infinite");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" must not be NaN");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static float checkArgumentInRange(float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    if (!Float.isNaN(paramFloat1))
    {
      if (paramFloat1 >= paramFloat2)
      {
        if (paramFloat1 <= paramFloat3) {
          return paramFloat1;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[] { paramString, Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
      }
      throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[] { paramString, Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" must not be NaN");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int checkArgumentInRange(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt1 >= paramInt2)
    {
      if (paramInt1 <= paramInt3) {
        return paramInt1;
      }
      throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  public static long checkArgumentInRange(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 >= paramLong2)
    {
      if (paramLong1 <= paramLong3) {
        return paramLong1;
      }
      throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
    }
    throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
  }
  
  @IntRange(from=0L)
  public static int checkArgumentNonnegative(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new IllegalArgumentException();
  }
  
  @IntRange(from=0L)
  public static int checkArgumentNonnegative(int paramInt, String paramString)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static long checkArgumentNonnegative(long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong;
    }
    throw new IllegalArgumentException();
  }
  
  public static long checkArgumentNonnegative(long paramLong, String paramString)
  {
    if (paramLong >= 0L) {
      return paramLong;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static int checkArgumentPositive(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static float[] checkArrayElementsInRange(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" must not be null");
    checkNotNull(paramArrayOfFloat, localStringBuilder.toString());
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      float f = paramArrayOfFloat[i];
      if (!Float.isNaN(f))
      {
        if (f >= paramFloat1)
        {
          if (f <= paramFloat2) {
            i += 1;
          } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too high)", new Object[] { paramString, Integer.valueOf(i), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
          }
        }
        else {
          throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too low)", new Object[] { paramString, Integer.valueOf(i), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
        }
      }
      else
      {
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append(paramString);
        paramArrayOfFloat.append("[");
        paramArrayOfFloat.append(i);
        paramArrayOfFloat.append("] must not be NaN");
        throw new IllegalArgumentException(paramArrayOfFloat.toString());
      }
    }
    return paramArrayOfFloat;
  }
  
  public static <T> T[] checkArrayElementsNotNull(T[] paramArrayOfT, String paramString)
  {
    if (paramArrayOfT != null)
    {
      int i = 0;
      while (i < paramArrayOfT.length) {
        if (paramArrayOfT[i] != null) {
          i += 1;
        } else {
          throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", new Object[] { paramString, Integer.valueOf(i) }));
        }
      }
      return paramArrayOfT;
    }
    paramArrayOfT = new StringBuilder();
    paramArrayOfT.append(paramString);
    paramArrayOfT.append(" must not be null");
    throw new NullPointerException(paramArrayOfT.toString());
  }
  
  @NonNull
  public static <C extends Collection<T>, T> C checkCollectionElementsNotNull(C paramC, String paramString)
  {
    if (paramC != null)
    {
      long l = 0L;
      Iterator localIterator = paramC.iterator();
      while (localIterator.hasNext()) {
        if (localIterator.next() != null) {
          l += 1L;
        } else {
          throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", new Object[] { paramString, Long.valueOf(l) }));
        }
      }
      return paramC;
    }
    paramC = new StringBuilder();
    paramC.append(paramString);
    paramC.append(" must not be null");
    throw new NullPointerException(paramC.toString());
  }
  
  public static <T> Collection<T> checkCollectionNotEmpty(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection != null)
    {
      if (!paramCollection.isEmpty()) {
        return paramCollection;
      }
      paramCollection = new StringBuilder();
      paramCollection.append(paramString);
      paramCollection.append(" is empty");
      throw new IllegalArgumentException(paramCollection.toString());
    }
    paramCollection = new StringBuilder();
    paramCollection.append(paramString);
    paramCollection.append(" must not be null");
    throw new NullPointerException(paramCollection.toString());
  }
  
  public static int checkFlagsArgument(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & paramInt2) == paramInt1) {
      return paramInt1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Requested flags 0x");
    localStringBuilder.append(Integer.toHexString(paramInt1));
    localStringBuilder.append(", but only 0x");
    localStringBuilder.append(Integer.toHexString(paramInt2));
    localStringBuilder.append(" are allowed");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @NonNull
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
  
  @NonNull
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean)
  {
    checkState(paramBoolean, null);
  }
  
  public static void checkState(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  @NonNull
  public static <T extends CharSequence> T checkStringNotEmpty(T paramT)
  {
    if (!TextUtils.isEmpty(paramT)) {
      return paramT;
    }
    throw new IllegalArgumentException();
  }
  
  @NonNull
  public static <T extends CharSequence> T checkStringNotEmpty(T paramT, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramT)) {
      return paramT;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.Preconditions
 * JD-Core Version:    0.7.0.1
 */