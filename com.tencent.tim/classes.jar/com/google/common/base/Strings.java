package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible
public final class Strings
{
  public static String commonPrefix(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Preconditions.checkNotNull(paramCharSequence1);
    Preconditions.checkNotNull(paramCharSequence2);
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    int i = 0;
    while ((i < j) && (paramCharSequence1.charAt(i) == paramCharSequence2.charAt(i))) {
      i += 1;
    }
    if (!validSurrogatePairAt(paramCharSequence1, i - 1))
    {
      j = i;
      if (!validSurrogatePairAt(paramCharSequence2, i - 1)) {}
    }
    else
    {
      j = i - 1;
    }
    return paramCharSequence1.subSequence(0, j).toString();
  }
  
  public static String commonSuffix(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Preconditions.checkNotNull(paramCharSequence1);
    Preconditions.checkNotNull(paramCharSequence2);
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    int i = 0;
    while ((i < j) && (paramCharSequence1.charAt(paramCharSequence1.length() - i - 1) == paramCharSequence2.charAt(paramCharSequence2.length() - i - 1))) {
      i += 1;
    }
    if (!validSurrogatePairAt(paramCharSequence1, paramCharSequence1.length() - i - 1))
    {
      j = i;
      if (!validSurrogatePairAt(paramCharSequence2, paramCharSequence2.length() - i - 1)) {}
    }
    else
    {
      j = i - 1;
    }
    return paramCharSequence1.subSequence(paramCharSequence1.length() - j, paramCharSequence1.length()).toString();
  }
  
  @Nullable
  public static String emptyToNull(@Nullable String paramString)
  {
    String str = paramString;
    if (isNullOrEmpty(paramString)) {
      str = null;
    }
    return str;
  }
  
  public static boolean isNullOrEmpty(@Nullable String paramString)
  {
    return Platform.stringIsNullOrEmpty(paramString);
  }
  
  public static String nullToEmpty(@Nullable String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String padEnd(String paramString, int paramInt, char paramChar)
  {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() >= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    localStringBuilder.append(paramString);
    int i = paramString.length();
    while (i < paramInt)
    {
      localStringBuilder.append(paramChar);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String padStart(String paramString, int paramInt, char paramChar)
  {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() >= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    int i = paramString.length();
    while (i < paramInt)
    {
      localStringBuilder.append(paramChar);
      i += 1;
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String repeat(String paramString, int paramInt)
  {
    boolean bool = true;
    Preconditions.checkNotNull(paramString);
    if (paramInt <= 1)
    {
      if (paramInt >= 0) {}
      for (;;)
      {
        Preconditions.checkArgument(bool, "invalid count: %s", paramInt);
        if (paramInt == 0) {
          paramString = "";
        }
        return paramString;
        bool = false;
      }
    }
    int i = paramString.length();
    long l = i * paramInt;
    int j = (int)l;
    if (j != l) {
      throw new ArrayIndexOutOfBoundsException("Required array size too large: " + l);
    }
    char[] arrayOfChar = new char[j];
    paramString.getChars(0, i, arrayOfChar, 0);
    paramInt = i;
    while (paramInt < j - paramInt)
    {
      System.arraycopy(arrayOfChar, 0, arrayOfChar, paramInt, paramInt);
      paramInt <<= 1;
    }
    System.arraycopy(arrayOfChar, 0, arrayOfChar, paramInt, j - paramInt);
    return new String(arrayOfChar);
  }
  
  @VisibleForTesting
  static boolean validSurrogatePairAt(CharSequence paramCharSequence, int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= paramCharSequence.length() - 2) && (Character.isHighSurrogate(paramCharSequence.charAt(paramInt))) && (Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Strings
 * JD-Core Version:    0.7.0.1
 */