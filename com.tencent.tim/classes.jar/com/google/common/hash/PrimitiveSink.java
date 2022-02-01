package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

@Beta
@CanIgnoreReturnValue
public abstract interface PrimitiveSink
{
  public abstract PrimitiveSink putBoolean(boolean paramBoolean);
  
  public abstract PrimitiveSink putByte(byte paramByte);
  
  public abstract PrimitiveSink putBytes(byte[] paramArrayOfByte);
  
  public abstract PrimitiveSink putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract PrimitiveSink putChar(char paramChar);
  
  public abstract PrimitiveSink putDouble(double paramDouble);
  
  public abstract PrimitiveSink putFloat(float paramFloat);
  
  public abstract PrimitiveSink putInt(int paramInt);
  
  public abstract PrimitiveSink putLong(long paramLong);
  
  public abstract PrimitiveSink putShort(short paramShort);
  
  public abstract PrimitiveSink putString(CharSequence paramCharSequence, Charset paramCharset);
  
  public abstract PrimitiveSink putUnencodedChars(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.PrimitiveSink
 * JD-Core Version:    0.7.0.1
 */