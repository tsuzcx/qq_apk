package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;

final class v
{
  static class a
  {
    public final int a;
    public final int b;
    public final int c;
    public q.b d = q.b.a;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c));
      return false;
    }
    
    public int hashCode()
    {
      return this.a * 7 + this.b * 11 + this.c * 13;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("-");
      localStringBuilder.append(this.b);
      localStringBuilder.append("-");
      localStringBuilder.append(this.c);
      return localStringBuilder.toString();
    }
  }
  
  static class b
    extends v.a
  {
    public float e = 0.0F;
    public float f = 0.0F;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
  }
  
  static final class c
    extends v.b
  {
    Bitmap g = null;
    float h = 1.0F;
    boolean i = true;
    
    public c(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.v
 * JD-Core Version:    0.7.0.1
 */