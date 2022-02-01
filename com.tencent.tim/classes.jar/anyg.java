public class anyg
  extends anyb
{
  private int dNr;
  private int dNs;
  
  public anyg(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 4, 0);
    this.dNr = paramInt2;
    this.dNs = paramInt3;
  }
  
  public anyg(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, 4, paramInt4);
    this.dNr = paramInt2;
    this.dNs = paramInt3;
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    this.opacity = ((int)(this.dNr + (this.dNs - this.dNr) * paramFloat));
    if (this.dNs - this.dNr > 0) {
      if (this.opacity >= this.dNs) {
        this.opacity = this.dNs;
      }
    }
    for (;;)
    {
      super.s(paramInt, paramFloat);
      return;
      if (this.opacity <= this.dNs) {
        this.opacity = this.dNs;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyg
 * JD-Core Version:    0.7.0.1
 */