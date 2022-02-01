public class isi
  extends isd
{
  public boolean mIsReady;
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBounds(paramInt1 * 5 / 1500, paramInt2 - paramInt1 * 752 / 750, paramInt1 * 1495 / 1500, paramInt2);
  }
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int j = 0;
    float f2 = 1.0F;
    int i;
    float f1;
    if (paramLong <= 500L)
    {
      i = 0;
      f1 = f2;
    }
    for (;;)
    {
      setAlpha(i);
      setScale(f1);
      return;
      if ((paramLong > 500L) && (paramLong < 1167L))
      {
        i = (int)(255L * (paramLong - 500L) / 667L);
        f1 = (0.5F * (float)(paramLong + 1167L) - 500.0F) / 667.0F;
      }
      else if (((paramLong >= 1167L) && (paramLong <= 2167L)) || (!this.mIsReady))
      {
        i = 255;
        f1 = f2;
      }
      else
      {
        f1 = f2;
        i = j;
        if (paramLong > 2167L)
        {
          f1 = f2;
          i = j;
          if (paramLong < 2500L)
          {
            i = (int)((paramLong - 2500L) * 255L / -333L);
            f1 = f2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isi
 * JD-Core Version:    0.7.0.1
 */