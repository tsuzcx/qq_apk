package okio;

import javax.annotation.Nullable;

final class n
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  n f;
  n g;
  
  n()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }
  
  n(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  n a()
  {
    this.d = true;
    return new n(this.a, this.b, this.c, true, false);
  }
  
  public n a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.c - this.b)) {
      throw new IllegalArgumentException();
    }
    n localn;
    if (paramInt >= 1024) {
      localn = a();
    }
    for (;;)
    {
      localn.c = (localn.b + paramInt);
      this.b += paramInt;
      this.g.a(localn);
      return localn;
      localn = o.a();
      System.arraycopy(this.a, this.b, localn.a, 0, paramInt);
    }
  }
  
  public n a(n paramn)
  {
    paramn.g = this;
    paramn.f = this.f;
    this.f.g = paramn;
    this.f = paramn;
    return paramn;
  }
  
  public void a(n paramn, int paramInt)
  {
    if (!paramn.e) {
      throw new IllegalArgumentException();
    }
    if (paramn.c + paramInt > 8192)
    {
      if (paramn.d) {
        throw new IllegalArgumentException();
      }
      if (paramn.c + paramInt - paramn.b > 8192) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramn.a, paramn.b, paramn.a, 0, paramn.c - paramn.b);
      paramn.c -= paramn.b;
      paramn.b = 0;
    }
    System.arraycopy(this.a, this.b, paramn.a, paramn.c, paramInt);
    paramn.c += paramInt;
    this.b += paramInt;
  }
  
  @Nullable
  public n b()
  {
    if (this.f != this) {}
    for (n localn = this.f;; localn = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localn;
    }
  }
  
  public void c()
  {
    if (this.g == this) {
      throw new IllegalStateException();
    }
    if (!this.g.e) {}
    for (;;)
    {
      return;
      int j = this.c - this.b;
      int k = this.g.c;
      if (this.g.d) {}
      for (int i = 0; j <= i + (8192 - k); i = this.g.b)
      {
        a(this.g, j);
        b();
        o.a(this);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.n
 * JD-Core Version:    0.7.0.1
 */