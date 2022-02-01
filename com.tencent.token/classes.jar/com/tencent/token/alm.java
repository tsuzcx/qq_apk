package com.tencent.token;

import java.io.Closeable;

public abstract class alm
  implements Closeable
{
  public static alm a(byte[] paramArrayOfByte)
  {
    ant localant = new ant().b(paramArrayOfByte);
    long l = paramArrayOfByte.length;
    if (localant != null) {
      new alm()
      {
        public final long a()
        {
          return this.b;
        }
        
        public final anv b()
        {
          return this.c;
        }
      };
    }
    throw new NullPointerException("source == null");
  }
  
  public abstract long a();
  
  public abstract anv b();
  
  public void close()
  {
    alr.a(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alm
 * JD-Core Version:    0.7.0.1
 */