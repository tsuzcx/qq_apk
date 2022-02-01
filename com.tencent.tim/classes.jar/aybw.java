import dov.com.qq.im.ae.SessionWrap;

public class aybw
{
  private SessionWrap a;
  private String cSm;
  public String cWC;
  private boolean dxW = true;
  private boolean dxX;
  private boolean dxY;
  public boolean dxZ = true;
  private int dyL;
  public boolean dya;
  public boolean dyb;
  private int eJt = 11;
  private int eJu = 1;
  public int eJv;
  private int eJw;
  public int mode = 0;
  
  private aybw(aybw.a parama)
  {
    this.a = aybw.a.a(parama);
    this.cSm = aybw.a.a(parama);
    this.dyL = aybw.a.a(parama);
    this.eJt = aybw.a.b(parama);
    this.eJu = aybw.a.c(parama);
    this.dxW = aybw.a.a(parama);
    this.cWC = aybw.a.b(parama);
    this.eJw = aybw.a.d(parama);
    this.dxX = aybw.a.b(parama);
    this.dxZ = parama.dxZ;
    this.dxY = parama.dxY;
    this.dya = parama.dya;
    this.dyb = parama.dyb;
    this.mode = parama.mode;
  }
  
  public String Ik()
  {
    return this.cSm;
  }
  
  public String Il()
  {
    return this.cWC;
  }
  
  public int Is()
  {
    return this.dyL;
  }
  
  public int RJ()
  {
    return this.eJt;
  }
  
  public int RK()
  {
    return this.eJu;
  }
  
  public int RL()
  {
    return this.eJw;
  }
  
  public SessionWrap a()
  {
    return this.a;
  }
  
  public boolean aQf()
  {
    return this.dxW;
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
  
  public static class a
  {
    private SessionWrap a;
    private int blx = 11;
    private String cSm;
    private String cWC;
    private boolean dxW = true;
    private boolean dxX;
    public boolean dxY;
    public boolean dxZ;
    private int dyL;
    public boolean dya;
    public boolean dyb = true;
    private int eJu = 1;
    private int eJw;
    public int mode = 0;
    
    public a(int paramInt)
    {
      if (paramInt == 2) {}
      for (paramInt = i;; paramInt = 1)
      {
        this.dyL = paramInt;
        return;
      }
    }
    
    public a a(int paramInt)
    {
      this.eJu = paramInt;
      return this;
    }
    
    public a a(SessionWrap paramSessionWrap)
    {
      this.a = paramSessionWrap;
      if (paramSessionWrap != null) {
        this.blx = anfe.hS(paramSessionWrap.cZ);
      }
      return this;
    }
    
    public a a(String paramString)
    {
      this.cSm = paramString;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.dxW = paramBoolean;
      return this;
    }
    
    public a b(int paramInt)
    {
      this.eJw = paramInt;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.dxZ = paramBoolean;
      return this;
    }
    
    public aybw b()
    {
      return new aybw(this, null);
    }
    
    public a c(int paramInt)
    {
      this.mode = paramInt;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.dxY = paramBoolean;
      return this;
    }
    
    public a d(boolean paramBoolean)
    {
      this.dya = paramBoolean;
      return this;
    }
    
    public a e(boolean paramBoolean)
    {
      this.dyb = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybw
 * JD-Core Version:    0.7.0.1
 */