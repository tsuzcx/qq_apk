public class anyd
  extends anyb
{
  private int dNm;
  private int dNn;
  private int dNo;
  private int dNp;
  private float zV;
  
  public anyd(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    super(paramInt1, 11, 0);
    this.dNm = paramInt2;
    this.dNn = paramInt3;
    this.dNo = paramInt4;
    this.dNp = paramInt5;
    this.zV = paramFloat;
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    this.scale = (paramInt * 0.8F / this.duration);
    if (this.scale > 0.8F) {
      this.scale = 0.8F;
    }
    this.rotate = ((int)(360.0F * paramInt * paramInt / (this.duration * this.duration)));
    this.x = (this.dNm + (this.dNo - this.dNm) * paramInt / this.duration);
    this.y = ((int)(this.dNn + this.dNp * Math.sin(this.zV * this.x)));
    super.s(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyd
 * JD-Core Version:    0.7.0.1
 */