package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Verify
{
  public static void verify(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new VerifyException();
    }
  }
  
  public static void verify(boolean paramBoolean, @Nullable String paramString, @Nullable Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new VerifyException(Preconditions.format(paramString, paramVarArgs));
    }
  }
  
  @CanIgnoreReturnValue
  public static <T> T verifyNotNull(@Nullable T paramT)
  {
    return verifyNotNull(paramT, "expected a non-null reference", new Object[0]);
  }
  
  @CanIgnoreReturnValue
  public static <T> T verifyNotNull(@Nullable T paramT, @Nullable String paramString, @Nullable Object... paramVarArgs)
  {
    if (paramT != null) {}
    for (boolean bool = true;; bool = false)
    {
      verify(bool, paramString, paramVarArgs);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Verify
 * JD-Core Version:    0.7.0.1
 */