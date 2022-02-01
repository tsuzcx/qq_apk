public class ayby
{
  private int bnM;
  public String cWC;
  public String cWD = "";
  public String cWE = "";
  private boolean dxY;
  public boolean dxZ = true;
  public boolean dya;
  public boolean dyb;
  private boolean dyc = true;
  private boolean dyd = true;
  private boolean dye = true;
  private boolean dyf;
  public boolean dyg;
  public boolean dyh;
  public boolean dyi;
  public boolean dyj = true;
  public boolean dyk;
  public boolean dyl;
  public int eJA = aaqh.ciA;
  private int eJw;
  private int eJx;
  private int eJy = 1;
  public int eJz = 1;
  public int mode = 0;
  
  private ayby(ayby.a parama)
  {
    this.dyc = ayby.a.a(parama);
    this.dyd = ayby.a.b(parama);
    this.dye = ayby.a.c(parama);
    this.dyf = ayby.a.d(parama);
    this.dxZ = parama.dxZ;
    this.dxY = parama.dxY;
    this.dya = parama.dya;
    this.bnM = ayby.a.a(parama);
    this.eJx = ayby.a.b(parama);
    this.dyl = ayby.a.e(parama);
    this.eJw = ayby.a.c(parama);
    this.eJy = ayby.a.d(parama);
    this.dyg = ayby.a.f(parama);
    this.dyb = parama.dyb;
    this.mode = parama.mode;
    this.dyi = ayby.a.g(parama);
    this.dyh = ayby.a.h(parama);
    this.dyj = parama.dyj;
    this.dyk = ayby.a.i(parama);
  }
  
  public int RL()
  {
    return this.eJw;
  }
  
  public int RM()
  {
    return this.eJx;
  }
  
  public int RN()
  {
    return this.eJy;
  }
  
  public boolean aQg()
  {
    return this.dxZ;
  }
  
  public boolean aQh()
  {
    return this.dxY;
  }
  
  public boolean aQi()
  {
    return this.dya;
  }
  
  public boolean aQj()
  {
    return this.dyc;
  }
  
  public boolean aQk()
  {
    return this.dyk;
  }
  
  public boolean aQl()
  {
    return this.dyh;
  }
  
  public boolean aQm()
  {
    return this.dyj;
  }
  
  public boolean aQn()
  {
    return this.dye;
  }
  
  public boolean aQo()
  {
    return this.dyl;
  }
  
  public static class a
  {
    private int bnM = -1;
    public boolean dxY;
    public boolean dxZ;
    public boolean dya;
    public boolean dyb = true;
    private boolean dyc = true;
    private boolean dyd = true;
    private boolean dye = true;
    private boolean dyf;
    private boolean dyg;
    private boolean dyh;
    private boolean dyi;
    public boolean dyj = true;
    private boolean dyk;
    private boolean dyl;
    private int eJw;
    private int eJx;
    private int eJy = 1;
    public int mode = 0;
    
    public a a(int paramInt)
    {
      this.eJw = paramInt;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.dyc = paramBoolean;
      return this;
    }
    
    public a b(int paramInt)
    {
      this.eJy = paramInt;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.dye = paramBoolean;
      return this;
    }
    
    public ayby b()
    {
      return new ayby(this, null);
    }
    
    public a c(int paramInt)
    {
      this.mode = paramInt;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.dyf = paramBoolean;
      return this;
    }
    
    public a d(boolean paramBoolean)
    {
      this.dyj = paramBoolean;
      return this;
    }
    
    public a e(boolean paramBoolean)
    {
      this.dxZ = paramBoolean;
      return this;
    }
    
    public a f(boolean paramBoolean)
    {
      this.dxY = paramBoolean;
      return this;
    }
    
    public a g(boolean paramBoolean)
    {
      this.dya = paramBoolean;
      return this;
    }
    
    public a h(boolean paramBoolean)
    {
      this.dyg = paramBoolean;
      return this;
    }
    
    public a i(boolean paramBoolean)
    {
      this.dyb = paramBoolean;
      return this;
    }
    
    public a j(boolean paramBoolean)
    {
      this.dyi = paramBoolean;
      return this;
    }
    
    public a k(boolean paramBoolean)
    {
      this.dyh = paramBoolean;
      return this;
    }
    
    public a l(boolean paramBoolean)
    {
      this.dyk = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayby
 * JD-Core Version:    0.7.0.1
 */