package okio;

import javax.annotation.Nullable;

final class v
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  v f;
  v g;
  
  v()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }
  
  v(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  v a()
  {
    this.d = true;
    return new v(this.a, this.b, this.c, true, false);
  }
  
  public v a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.c - this.b)) {
      throw new IllegalArgumentException();
    }
    v localv;
    if (paramInt >= 1024) {
      localv = a();
    }
    for (;;)
    {
      localv.c = (localv.b + paramInt);
      this.b += paramInt;
      this.g.a(localv);
      return localv;
      localv = w.a();
      System.arraycopy(this.a, this.b, localv.a, 0, paramInt);
    }
  }
  
  public v a(v paramv)
  {
    paramv.g = this;
    paramv.f = this.f;
    this.f.g = paramv;
    this.f = paramv;
    return paramv;
  }
  
  public void a(v paramv, int paramInt)
  {
    if (!paramv.e) {
      throw new IllegalArgumentException();
    }
    if (paramv.c + paramInt > 8192)
    {
      if (paramv.d) {
        throw new IllegalArgumentException();
      }
      if (paramv.c + paramInt - paramv.b > 8192) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramv.a, paramv.b, paramv.a, 0, paramv.c - paramv.b);
      paramv.c -= paramv.b;
      paramv.b = 0;
    }
    System.arraycopy(this.a, this.b, paramv.a, paramv.c, paramInt);
    paramv.c += paramInt;
    this.b += paramInt;
  }
  
  @Nullable
  public v b()
  {
    if (this.f != this) {}
    for (v localv = this.f;; localv = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localv;
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
        w.a(this);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.v
 * JD-Core Version:    0.7.0.1
 */