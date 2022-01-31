package okio;

import java.io.InputStream;

class g
  extends InputStream
{
  g(f paramf) {}
  
  public int available()
  {
    return (int)Math.min(this.a.b, 2147483647L);
  }
  
  public void close() {}
  
  public int read()
  {
    if (this.a.b > 0L) {
      return this.a.h() & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.a + ".inputStream()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.g
 * JD-Core Version:    0.7.0.1
 */