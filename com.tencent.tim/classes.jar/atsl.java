public class atsl
  extends atsk
{
  protected long ayC = 0L;
  protected long ayD = 0L;
  protected int eqL = -1;
  protected int eqM = -1;
  protected int eqN = -1;
  protected int eqO = -1;
  
  private boolean isTimeOut(long paramLong)
  {
    return System.currentTimeMillis() - paramLong >= 1800000L;
  }
  
  public int OA()
  {
    if (isTimeOut(this.ayD)) {
      return -1;
    }
    return this.eqN;
  }
  
  public int OB()
  {
    if (isTimeOut(this.ayD)) {
      return -1;
    }
    return this.eqO;
  }
  
  public int Oy()
  {
    if (isTimeOut(this.ayC)) {
      return -1;
    }
    return this.eqL;
  }
  
  public int Oz()
  {
    if (isTimeOut(this.ayC)) {
      return -1;
    }
    return this.eqM;
  }
  
  public void a(atsk paramatsk)
  {
    if (paramatsk == null) {}
    do
    {
      do
      {
        return;
      } while (!(paramatsk instanceof atsl));
      paramatsk = (atsl)paramatsk;
      if (paramatsk.eqK != -1) {
        this.eqK = paramatsk.eqK;
      }
      if (paramatsk.eqL != -1) {
        this.eqL = paramatsk.eqL;
      }
      if (paramatsk.eqM != -1) {
        this.eqM = paramatsk.eqM;
      }
      if (paramatsk.ayC > this.ayC) {
        this.ayC = paramatsk.ayC;
      }
      if (paramatsk.eqN != -1) {
        this.eqN = paramatsk.eqN;
      }
      if (paramatsk.eqO != -1) {
        this.eqO = paramatsk.eqO;
      }
    } while (paramatsk.ayD <= this.ayD);
    this.ayD = paramatsk.ayD;
  }
  
  public void kR(int paramInt1, int paramInt2)
  {
    this.eqL = paramInt1;
    this.eqM = paramInt2;
    this.ayC = System.currentTimeMillis();
  }
  
  public void kS(int paramInt1, int paramInt2)
  {
    this.eqN = paramInt1;
    this.eqO = paramInt2;
    this.ayD = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsl
 * JD-Core Version:    0.7.0.1
 */