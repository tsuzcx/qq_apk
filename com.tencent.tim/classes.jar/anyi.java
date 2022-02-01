public class anyi
  extends anyb
{
  private float zY;
  private float zZ;
  
  public anyi(int paramInt, float paramFloat1, float paramFloat2)
  {
    super(paramInt, 2, 0);
    this.zY = paramFloat1;
    this.zZ = paramFloat2;
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    this.scale = (this.zY + (this.zZ - this.zY) * paramFloat);
    if (this.zZ - this.zY > 0.0F) {
      if (this.scale >= this.zZ) {
        this.scale = this.zZ;
      }
    }
    for (;;)
    {
      if (paramInt >= this.duration) {
        this.scale = this.zZ;
      }
      super.s(paramInt, paramFloat);
      return;
      if (this.scale <= this.zZ) {
        this.scale = this.zZ;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyi
 * JD-Core Version:    0.7.0.1
 */