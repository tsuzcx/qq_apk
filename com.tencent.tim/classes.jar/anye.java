public class anye
  extends anyb
{
  private float pA;
  private float pB;
  private float zW;
  private float zX;
  
  public anye(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramInt, 1, 0);
    this.pA = paramFloat1;
    this.zW = paramFloat2;
    this.pB = paramFloat3;
    this.zX = paramFloat4;
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    this.x = (this.pA + (this.pB - this.pA) * paramFloat);
    this.y = (this.zW + (this.zX - this.zW) * paramFloat);
    if (this.pB - this.pA > 0.0F)
    {
      if (this.x >= this.pB) {
        this.x = this.pB;
      }
      if (this.zX - this.zW <= 0.0F) {
        break label162;
      }
      if (this.y >= this.zX) {
        this.y = this.zX;
      }
    }
    for (;;)
    {
      if (paramInt >= this.duration)
      {
        this.x = this.pB;
        this.y = this.zX;
      }
      super.s(paramInt, paramFloat);
      return;
      if (this.x > this.pB) {
        break;
      }
      this.x = this.pB;
      break;
      label162:
      if (this.y <= this.zX) {
        this.y = this.zX;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anye
 * JD-Core Version:    0.7.0.1
 */