public class isy
  extends isd
{
  public int atd;
  public int atr;
  public int mHeight;
  public int mLeft;
  public int mTop;
  public int mWidth;
  public long mX;
  public long mY;
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeft = (paramInt1 * 44 / 750);
    this.mTop = (paramInt2 - paramInt1 * 624 / 750);
    paramInt3 = paramInt1 * 154 / 750;
    paramInt4 = paramInt1 * 537 / 750;
    this.mWidth = (paramInt1 * 221 / 750);
    this.mHeight = (paramInt1 * 175 / 750);
    this.atr = (paramInt1 * -110 / 750);
    this.atd = (paramInt1 * -87 / 750);
    this.mX = (paramInt3 * 2666L - this.mLeft * 2333L);
    this.mY = ((paramInt2 - paramInt4) * 2666L - this.mTop * 2333L);
  }
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int i1 = 0;
    float f2 = 1.0F;
    int m = this.mLeft;
    int n = this.mTop;
    int i;
    float f1;
    int j;
    int k;
    if ((paramLong > 2333L) && (paramLong < 2666L))
    {
      i = (int)(255L * (paramLong - 2333L) / 333L);
      f1 = (0.5F * (float)(2666L + paramLong) - 2333.0F) / 333.0F;
      j = (int)((this.atr * paramLong + this.mX) / 333L);
      k = (int)((paramLong * this.atd + this.mY) / 333L);
    }
    for (;;)
    {
      setAlpha(i);
      setScale(f1);
      setBounds(j, k, this.mWidth + j, this.mHeight + k);
      return;
      if ((paramLong >= 2666L) && (paramLong <= 4631L))
      {
        i = 255;
        k = n;
        j = m;
        f1 = f2;
      }
      else
      {
        k = n;
        j = m;
        f1 = f2;
        i = i1;
        if (paramLong > 4631L)
        {
          k = n;
          j = m;
          f1 = f2;
          i = i1;
          if (paramLong < 4798L)
          {
            i = (int)((paramLong - 4798L) * 255L / -167L);
            k = n;
            j = m;
            f1 = f2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isy
 * JD-Core Version:    0.7.0.1
 */