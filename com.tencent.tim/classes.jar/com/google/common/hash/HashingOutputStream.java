package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
public final class HashingOutputStream
  extends FilterOutputStream
{
  private final Hasher hasher;
  
  public HashingOutputStream(HashFunction paramHashFunction, OutputStream paramOutputStream)
  {
    super((OutputStream)Preconditions.checkNotNull(paramOutputStream));
    this.hasher = ((Hasher)Preconditions.checkNotNull(paramHashFunction.newHasher()));
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public HashCode hash()
  {
    return this.hasher.hash();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.hasher.putByte((byte)paramInt);
    this.out.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.hasher.putBytes(paramArrayOfByte, paramInt1, paramInt2);
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.HashingOutputStream
 * JD-Core Version:    0.7.0.1
 */