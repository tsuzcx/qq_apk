package com.google.common.hash;

import java.nio.charset.Charset;

class AbstractCompositeHashFunction$1
  implements Hasher
{
  AbstractCompositeHashFunction$1(AbstractCompositeHashFunction paramAbstractCompositeHashFunction, Hasher[] paramArrayOfHasher) {}
  
  public HashCode hash()
  {
    return this.this$0.makeHash(this.val$hashers);
  }
  
  public Hasher putBoolean(boolean paramBoolean)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putBoolean(paramBoolean);
      i += 1;
    }
    return this;
  }
  
  public Hasher putByte(byte paramByte)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putByte(paramByte);
      i += 1;
    }
    return this;
  }
  
  public Hasher putBytes(byte[] paramArrayOfByte)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putBytes(paramArrayOfByte);
      i += 1;
    }
    return this;
  }
  
  public Hasher putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putBytes(paramArrayOfByte, paramInt1, paramInt2);
      i += 1;
    }
    return this;
  }
  
  public Hasher putChar(char paramChar)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putChar(paramChar);
      i += 1;
    }
    return this;
  }
  
  public Hasher putDouble(double paramDouble)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putDouble(paramDouble);
      i += 1;
    }
    return this;
  }
  
  public Hasher putFloat(float paramFloat)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putFloat(paramFloat);
      i += 1;
    }
    return this;
  }
  
  public Hasher putInt(int paramInt)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putInt(paramInt);
      i += 1;
    }
    return this;
  }
  
  public Hasher putLong(long paramLong)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putLong(paramLong);
      i += 1;
    }
    return this;
  }
  
  public <T> Hasher putObject(T paramT, Funnel<? super T> paramFunnel)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putObject(paramT, paramFunnel);
      i += 1;
    }
    return this;
  }
  
  public Hasher putShort(short paramShort)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putShort(paramShort);
      i += 1;
    }
    return this;
  }
  
  public Hasher putString(CharSequence paramCharSequence, Charset paramCharset)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putString(paramCharSequence, paramCharset);
      i += 1;
    }
    return this;
  }
  
  public Hasher putUnencodedChars(CharSequence paramCharSequence)
  {
    Hasher[] arrayOfHasher = this.val$hashers;
    int j = arrayOfHasher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHasher[i].putUnencodedChars(paramCharSequence);
      i += 1;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.AbstractCompositeHashFunction.1
 * JD-Core Version:    0.7.0.1
 */