package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
abstract class AbstractHasher
  implements Hasher
{
  public final Hasher putBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b = 1;; b = 0) {
      return putByte(b);
    }
  }
  
  public final Hasher putDouble(double paramDouble)
  {
    return putLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final Hasher putFloat(float paramFloat)
  {
    return putInt(Float.floatToRawIntBits(paramFloat));
  }
  
  public Hasher putString(CharSequence paramCharSequence, Charset paramCharset)
  {
    return putBytes(paramCharSequence.toString().getBytes(paramCharset));
  }
  
  public Hasher putUnencodedChars(CharSequence paramCharSequence)
  {
    int i = 0;
    int j = paramCharSequence.length();
    while (i < j)
    {
      putChar(paramCharSequence.charAt(i));
      i += 1;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.AbstractHasher
 * JD-Core Version:    0.7.0.1
 */