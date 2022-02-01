package btmsdkobf;

import java.io.InputStream;

public abstract class dq
{
  public static byte[] a(InputStream paramInputStream, int paramInt1, int paramInt2, a parama)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int j = paramInt2;
    int i = 0;
    for (;;)
    {
      if ((i < paramInt2) && (j > 0))
      {
        n = paramInputStream.read(arrayOfByte, paramInt1, j);
        if (n > 0) {
          break label65;
        }
        if (parama != null) {
          parama.a(true, i, paramInt2);
        }
      }
      paramInputStream = arrayOfByte;
      if (i != paramInt2) {
        paramInputStream = null;
      }
      return paramInputStream;
      label65:
      int k = i + n;
      int m = paramInt1 + n;
      int n = j - n;
      j = n;
      i = k;
      paramInt1 = m;
      if (parama != null)
      {
        parama.a(false, k, paramInt2);
        j = n;
        i = k;
        paramInt1 = m;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  }
  
  public static class b
  {
    private int ng;
    private int nh;
    private String ni;
    
    public b() {}
    
    public b(String paramString, int paramInt)
    {
      this.ni = paramString;
      this.nh = paramInt;
    }
    
    public b(String paramString, int paramInt1, int paramInt2)
    {
      this.ng = paramInt2;
      this.ni = paramString;
      this.nh = paramInt1;
    }
    
    protected Object clone()
    {
      return new b(this.ni, this.nh, this.ng);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        return false;
        paramObject = (b)paramObject;
      } while ((!paramObject.ni.equals(this.ni)) || (paramObject.nh != this.nh));
      return true;
    }
    
    public String getIp()
    {
      return this.ni;
    }
    
    public int getPort()
    {
      return this.nh;
    }
    
    public int hashCode()
    {
      return super.hashCode();
    }
    
    public String toString()
    {
      if (this.nh >= 0) {
        return this.ni + ":" + this.nh;
      }
      return this.ni;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dq
 * JD-Core Version:    0.7.0.1
 */