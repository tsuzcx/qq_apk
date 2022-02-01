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
    if ((paramInt > 0) && (paramInt <= this.c - this.b))
    {
      n localn;
      if (paramInt >= 1024)
      {
        localn = a();
      }
      else
      {
        localn = o.a();
        System.arraycopy(this.a, this.b, localn.a, 0, paramInt);
      }
      localn.c = (localn.b + paramInt);
      this.b += paramInt;
      this.g.a(localn);
      return localn;
    }
    throw new IllegalArgumentException();
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
    if (paramn.e)
    {
      int i = paramn.c;
      if (i + paramInt > 8192) {
        if (!paramn.d)
        {
          int j = paramn.b;
          if (i + paramInt - j <= 8192)
          {
            byte[] arrayOfByte = paramn.a;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramn.c -= paramn.b;
            paramn.b = 0;
          }
          else
          {
            throw new IllegalArgumentException();
          }
        }
        else
        {
          throw new IllegalArgumentException();
        }
      }
      System.arraycopy(this.a, this.b, paramn.a, paramn.c, paramInt);
      paramn.c += paramInt;
      this.b += paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Nullable
  public n b()
  {
    n localn1 = this.f;
    if (localn1 == this) {
      localn1 = null;
    }
    n localn2 = this.g;
    localn2.f = this.f;
    this.f.g = localn2;
    this.f = null;
    this.g = null;
    return localn1;
  }
  
  public void c()
  {
    n localn = this.g;
    if (localn != this)
    {
      if (!localn.e) {
        return;
      }
      int j = this.c - this.b;
      int k = localn.c;
      int i;
      if (localn.d) {
        i = 0;
      } else {
        i = localn.b;
      }
      if (j > 8192 - k + i) {
        return;
      }
      a(this.g, j);
      b();
      o.a(this);
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.n
 * JD-Core Version:    0.7.0.1
 */