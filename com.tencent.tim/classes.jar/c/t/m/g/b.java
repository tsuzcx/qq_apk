package c.t.m.g;

import java.io.Closeable;
import java.io.IOException;

public final class b
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final long e;
  public final int f;
  
  public b(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.e = paramLong;
    this.d = paramInt4;
    this.f = paramInt5;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (b)paramObject;
    } while ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.e == paramObject.e));
    return false;
  }
  
  public final String toString()
  {
    return "CellCoreInfo{MCC=" + this.a + ", MNC=" + this.b + ", LAC=" + this.c + ", RSSI=" + this.d + ", CID=" + this.e + ", PhoneType=" + this.f + '}';
  }
  
  public static enum a
  {
    public static final int a = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.b
 * JD-Core Version:    0.7.0.1
 */