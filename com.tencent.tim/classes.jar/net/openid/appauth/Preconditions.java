package net.openid.appauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collection;

public final class Preconditions
{
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
  
  public static void checkArgument(boolean paramBoolean, @NonNull String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  @NonNull
  public static <T extends Collection<?>> T checkCollectionNotEmpty(T paramT, @Nullable Object paramObject)
  {
    checkNotNull(paramT, paramObject);
    if (!paramT.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      checkArgument(bool, paramObject);
      return paramT;
    }
  }
  
  @NonNull
  public static String checkNotEmpty(String paramString, @Nullable Object paramObject)
  {
    checkNotNull(paramString, paramObject);
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      checkArgument(bool, paramObject);
      return paramString;
    }
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, @Nullable Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  @NonNull
  public static String checkNullOrNotEmpty(String paramString, @Nullable Object paramObject)
  {
    if (paramString != null) {
      checkNotEmpty(paramString, paramObject);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.Preconditions
 * JD-Core Version:    0.7.0.1
 */