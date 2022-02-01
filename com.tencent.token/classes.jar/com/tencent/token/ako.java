package com.tencent.token;

import java.io.Closeable;

public abstract class ako
  implements Closeable
{
  public static ako a(byte[] paramArrayOfByte)
  {
    amv localamv = new amv().b(paramArrayOfByte);
    long l = paramArrayOfByte.length;
    if (localamv != null) {
      new ako()
      {
        public final long a()
        {
          return this.b;
        }
        
        public final amx b()
        {
          return this.c;
        }
      };
    }
    throw new NullPointerException("source == null");
  }
  
  public abstract long a();
  
  public abstract amx b();
  
  public void close()
  {
    akt.a(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ako
 * JD-Core Version:    0.7.0.1
 */