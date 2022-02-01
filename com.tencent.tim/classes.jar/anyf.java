public class anyf
  extends anyb
{
  private int dNn;
  private int dNq;
  
  public anyf(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 16, 0);
    this.dNn = paramInt2;
    this.dNq = paramInt3;
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    this.y = ((int)(this.dNn + (this.dNq - this.dNn) * paramFloat));
    if (this.dNq - this.dNn > 0) {
      if (this.y >= this.dNq) {
        this.y = this.dNq;
      }
    }
    for (;;)
    {
      super.s(paramInt, paramFloat);
      return;
      if (this.y <= this.dNq) {
        this.y = this.dNq;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyf
 * JD-Core Version:    0.7.0.1
 */