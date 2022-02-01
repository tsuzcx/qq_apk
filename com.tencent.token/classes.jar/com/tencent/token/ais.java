package com.tencent.token;

import java.io.Closeable;

public abstract class ais
  implements Closeable
{
  public static ais a(byte[] paramArrayOfByte)
  {
    akz localakz = new akz().b(paramArrayOfByte);
    long l = paramArrayOfByte.length;
    if (localakz != null) {
      new ais()
      {
        public final long a()
        {
          return this.b;
        }
        
        public final alb b()
        {
          return this.c;
        }
      };
    }
    throw new NullPointerException("source == null");
  }
  
  public abstract long a();
  
  public abstract alb b();
  
  public void close()
  {
    aix.a(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ais
 * JD-Core Version:    0.7.0.1
 */