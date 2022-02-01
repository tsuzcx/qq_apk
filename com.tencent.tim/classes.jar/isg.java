public class isg
  extends isd
{
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBounds(paramInt1 * 548 / 1500, paramInt2 - paramInt1 * 1032 / 1500, paramInt1 * 952 / 1500, paramInt2 - paramInt1 * 472 / 1500);
  }
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int j = 0;
    float f2 = 1.0F;
    int i;
    float f1;
    if ((paramLong > 2333L) && (paramLong < 2666L))
    {
      i = (int)(255L * (paramLong - 2333L) / 333L);
      f1 = (0.5F * (float)(paramLong + 2666L) - 2333.0F) / 333.0F;
    }
    for (;;)
    {
      setAlpha(i);
      setScale(f1);
      return;
      if ((paramLong >= 2666L) && (paramLong <= 3099L))
      {
        i = 255;
        f1 = f2;
      }
      else
      {
        f1 = f2;
        i = j;
        if (paramLong > 3099L)
        {
          f1 = f2;
          i = j;
          if (paramLong < 3266L)
          {
            i = (int)(255L * (3266L - paramLong) / 167L);
            f1 = (167.0F - (float)(3099L - paramLong) * 0.5F) / 167.0F;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isg
 * JD-Core Version:    0.7.0.1
 */