package okhttp3.internal.http2;

import java.util.Arrays;

public final class k
{
  private int a;
  private final int[] b = new int[10];
  
  k a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int[] arrayOfInt = this.b;
      if (paramInt1 >= arrayOfInt.length) {
        return this;
      }
      this.a = (1 << paramInt1 | this.a);
      arrayOfInt[paramInt1] = paramInt2;
      return this;
    }
    return this;
  }
  
  void a()
  {
    this.a = 0;
    Arrays.fill(this.b, 0);
  }
  
  void a(k paramk)
  {
    int i = 0;
    while (i < 10)
    {
      if (paramk.a(i)) {
        a(i, paramk.b(i));
      }
      i += 1;
    }
  }
  
  boolean a(int paramInt)
  {
    return (1 << paramInt & this.a) != 0;
  }
  
  int b()
  {
    return Integer.bitCount(this.a);
  }
  
  int b(int paramInt)
  {
    return this.b[paramInt];
  }
  
  int c()
  {
    if ((this.a & 0x2) != 0) {
      return this.b[1];
    }
    return -1;
  }
  
  int c(int paramInt)
  {
    if ((this.a & 0x10) != 0) {
      paramInt = this.b[4];
    }
    return paramInt;
  }
  
  int d()
  {
    if ((this.a & 0x80) != 0) {
      return this.b[7];
    }
    return 65535;
  }
  
  int d(int paramInt)
  {
    if ((this.a & 0x20) != 0) {
      paramInt = this.b[5];
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.k
 * JD-Core Version:    0.7.0.1
 */