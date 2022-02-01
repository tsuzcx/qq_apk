package btmsdkobf;

import java.io.InputStream;

public abstract class dq
{
  public static byte[] a(InputStream paramInputStream, int paramInt1, int paramInt2, a parama)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int i = paramInt1;
    int j = paramInt2;
    paramInt1 = 0;
    while ((paramInt1 < paramInt2) && (j > 0))
    {
      int n = paramInputStream.read(arrayOfByte, i, j);
      if (n <= 0)
      {
        if (parama == null) {
          break;
        }
        parama.a(true, paramInt1, paramInt2);
        break;
      }
      int k = paramInt1 + n;
      int m = i + n;
      n = j - n;
      j = n;
      i = m;
      paramInt1 = k;
      if (parama != null)
      {
        parama.a(false, k, paramInt2);
        j = n;
        i = m;
        paramInt1 = k;
      }
    }
    if (paramInt1 != paramInt2) {
      return null;
    }
    return arrayOfByte;
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
      if (paramObject == null) {
        return false;
      }
      paramObject = (b)paramObject;
      return (paramObject.ni.equals(this.ni)) && (paramObject.nh == this.nh);
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
      if (this.nh >= 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.ni);
        localStringBuilder.append(":");
        localStringBuilder.append(this.nh);
        return localStringBuilder.toString();
      }
      return this.ni;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dq
 * JD-Core Version:    0.7.0.1
 */