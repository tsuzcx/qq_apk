package okio;

import java.io.IOException;
import java.io.InputStream;

class u
  extends InputStream
{
  u(t paramt) {}
  
  public int available()
  {
    if (this.a.c) {
      throw new IOException("closed");
    }
    return (int)Math.min(this.a.a.b, 2147483647L);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public int read()
  {
    if (this.a.c) {
      throw new IOException("closed");
    }
    if ((this.a.a.b == 0L) && (this.a.b.a(this.a.a, 8192L) == -1L)) {
      return -1;
    }
    return this.a.a.h() & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a.c) {
      throw new IOException("closed");
    }
    ab.a(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.a.a.b == 0L) && (this.a.b.a(this.a.a, 8192L) == -1L)) {
      return -1;
    }
    return this.a.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.a + ".inputStream()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.u
 * JD-Core Version:    0.7.0.1
 */