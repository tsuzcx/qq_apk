package btmsdkobf;

public class cu
{
  private static ci iu;
  private static ci iv;
  private static b iw;
  
  public static ci bu()
  {
    if (iu == null) {
      try
      {
        if (iu == null) {
          iu = new a();
        }
      }
      finally {}
    }
    return iu;
  }
  
  public static ci bv()
  {
    if (iv == null) {
      try
      {
        if (iv == null) {
          iv = new a();
        }
      }
      finally {}
    }
    return iv;
  }
  
  public static b bw()
  {
    if (iw == null) {
      try
      {
        if (iw == null) {
          iw = new b();
        }
      }
      finally {}
    }
    return iw;
  }
  
  public static class a
    implements ci
  {
    private Object V = new Object();
    private int ix = 1;
    
    public int bm()
    {
      synchronized (this.V)
      {
        int i = this.ix;
        this.ix += 1;
        return i;
      }
    }
  }
  
  public static class b
  {
    private final Object V = new Object();
    private byte iy = 0;
    
    public byte bx()
    {
      synchronized (this.V)
      {
        if (this.iy + 1 == 127) {
          this.iy = 0;
        }
        byte b = (byte)(this.iy + 1);
        this.iy = b;
        return b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cu
 * JD-Core Version:    0.7.0.1
 */