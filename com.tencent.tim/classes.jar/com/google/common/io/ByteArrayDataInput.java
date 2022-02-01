package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInput;

@GwtIncompatible
public abstract interface ByteArrayDataInput
  extends DataInput
{
  @CanIgnoreReturnValue
  public abstract boolean readBoolean();
  
  @CanIgnoreReturnValue
  public abstract byte readByte();
  
  @CanIgnoreReturnValue
  public abstract char readChar();
  
  @CanIgnoreReturnValue
  public abstract double readDouble();
  
  @CanIgnoreReturnValue
  public abstract float readFloat();
  
  public abstract void readFully(byte[] paramArrayOfByte);
  
  public abstract void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @CanIgnoreReturnValue
  public abstract int readInt();
  
  @CanIgnoreReturnValue
  public abstract String readLine();
  
  @CanIgnoreReturnValue
  public abstract long readLong();
  
  @CanIgnoreReturnValue
  public abstract short readShort();
  
  @CanIgnoreReturnValue
  public abstract String readUTF();
  
  @CanIgnoreReturnValue
  public abstract int readUnsignedByte();
  
  @CanIgnoreReturnValue
  public abstract int readUnsignedShort();
  
  public abstract int skipBytes(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.ByteArrayDataInput
 * JD-Core Version:    0.7.0.1
 */