package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

@GwtIncompatible
public abstract interface ByteArrayDataOutput
  extends DataOutput
{
  public abstract byte[] toByteArray();
  
  public abstract void write(int paramInt);
  
  public abstract void write(byte[] paramArrayOfByte);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeBoolean(boolean paramBoolean);
  
  public abstract void writeByte(int paramInt);
  
  @Deprecated
  public abstract void writeBytes(String paramString);
  
  public abstract void writeChar(int paramInt);
  
  public abstract void writeChars(String paramString);
  
  public abstract void writeDouble(double paramDouble);
  
  public abstract void writeFloat(float paramFloat);
  
  public abstract void writeInt(int paramInt);
  
  public abstract void writeLong(long paramLong);
  
  public abstract void writeShort(int paramInt);
  
  public abstract void writeUTF(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.ByteArrayDataOutput
 * JD-Core Version:    0.7.0.1
 */