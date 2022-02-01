package com.tencent.token;

import java.io.Closeable;

public abstract class air
  implements Closeable
{
  public static air a(byte[] paramArrayOfByte)
  {
    aky localaky = new aky().b(paramArrayOfByte);
    long l = paramArrayOfByte.length;
    if (localaky != null) {
      new air()
      {
        public final long a()
        {
          return this.b;
        }
        
        public final ala b()
        {
          return this.c;
        }
      };
    }
    throw new NullPointerException("source == null");
  }
  
  public abstract long a();
  
  public abstract ala b();
  
  public void close()
  {
    aiw.a(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.air
 * JD-Core Version:    0.7.0.1
 */