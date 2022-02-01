public class isl
  extends isd
{
  public int JO;
  public int atc;
  public int atd;
  public int mHeight;
  public int mLeft;
  public int mPadding;
  public int mWidth;
  
  public isl()
  {
    setAlpha(255);
  }
  
  public void aql()
  {
    if (this.atc == 0) {}
    for (int i = this.mPadding;; i = this.JO - this.mPadding - this.mWidth)
    {
      this.mLeft = i;
      return;
    }
  }
  
  public void lG(int paramInt)
  {
    if (this.atc != paramInt)
    {
      this.atc = paramInt;
      aql();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = (paramInt1 * 70 / 160);
    this.mHeight = (paramInt1 * 70 / 160);
    this.mPadding = (paramInt1 * 5 / 160);
    this.JO = paramInt1;
    this.atd = (this.mHeight + paramInt2);
    aql();
  }
  
  public void update(long paramLong)
  {
    int i = (int)((paramLong - this.mStartTime) % 4000L * this.atd / 2000L - this.mHeight);
    setBounds(this.mLeft, i, this.mLeft + this.mWidth, this.mHeight + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isl
 * JD-Core Version:    0.7.0.1
 */