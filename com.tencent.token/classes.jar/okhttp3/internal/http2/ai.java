package okhttp3.internal.http2;

import java.util.Arrays;

public final class ai
{
  private int a;
  private final int[] b = new int[10];
  
  ai a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.b.length)) {
      return this;
    }
    this.a = (1 << paramInt1 | this.a);
    this.b[paramInt1] = paramInt2;
    return this;
  }
  
  void a()
  {
    this.a = 0;
    Arrays.fill(this.b, 0);
  }
  
  void a(ai paramai)
  {
    int i = 0;
    if (i < 10)
    {
      if (!paramai.a(i)) {}
      for (;;)
      {
        i += 1;
        break;
        a(i, paramai.b(i));
      }
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
    if ((0x2 & this.a) != 0) {
      return this.b[1];
    }
    return -1;
  }
  
  int c(int paramInt)
  {
    if ((0x10 & this.a) != 0) {
      paramInt = this.b[4];
    }
    return paramInt;
  }
  
  int d()
  {
    if ((0x80 & this.a) != 0) {
      return this.b[7];
    }
    return 65535;
  }
  
  int d(int paramInt)
  {
    if ((0x20 & this.a) != 0) {
      paramInt = this.b[5];
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.ai
 * JD-Core Version:    0.7.0.1
 */