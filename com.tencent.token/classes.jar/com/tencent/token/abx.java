package com.tencent.token;

public abstract interface abx
{
  public abstract a a(byte[] paramArrayOfByte);
  
  public static final class a
  {
    public final int a;
    public final byte[] b;
    
    private a(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramInt;
      this.b = paramArrayOfByte;
    }
    
    public static a a(int paramInt, byte[] paramArrayOfByte)
    {
      return new a(paramInt, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abx
 * JD-Core Version:    0.7.0.1
 */