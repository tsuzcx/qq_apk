public class awrz
  extends axon
{
  private int bto;
  private boolean drD;
  private int eCx = 1;
  public int eCy = 2;
  private String[] jg = new String[2];
  private String[] jh = new String[2];
  
  public void Gf(int paramInt)
  {
    this.eCy = paramInt;
  }
  
  public int QB()
  {
    return this.eCx;
  }
  
  public void Xx(boolean paramBoolean)
  {
    this.drD = paramBoolean;
  }
  
  public boolean aNw()
  {
    return this.drD;
  }
  
  public boolean aNx()
  {
    return this.eCy == 14;
  }
  
  public void acY(int paramInt)
  {
    this.eCx = paramInt;
  }
  
  public void acZ(int paramInt)
  {
    this.jg[paramInt] = null;
    this.jh[paramInt] = null;
  }
  
  public void aca(String paramString)
  {
    this.jg[this.bto] = paramString;
  }
  
  public void acb(String paramString)
  {
    this.jh[this.bto] = paramString;
  }
  
  public String[] af()
  {
    return this.jg;
  }
  
  public String[] ag()
  {
    return this.jh;
  }
  
  public boolean nW(int paramInt)
  {
    return (paramInt == 1) || ((this.eCx & paramInt) != 0);
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public void xL(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < 2)) {
      this.bto = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrz
 * JD-Core Version:    0.7.0.1
 */