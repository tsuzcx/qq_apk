public class isr
  extends isd
{
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBounds(paramInt1 * 361 / 1500, paramInt2 - paramInt1 * 968 / 1500, paramInt1 * 1139 / 1500, paramInt2 - paramInt1 * 536 / 1500);
  }
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int j = 0;
    float f2 = 1.0F;
    int i;
    float f1;
    if ((paramLong > 4631L) && (paramLong < 4964L))
    {
      i = (int)(255L * (paramLong - 4631L) / 333L);
      f1 = (0.5F * (float)(paramLong + 4964L) - 4631.0F) / 333.0F;
    }
    for (;;)
    {
      setAlpha(i);
      setScale(f1);
      return;
      if ((paramLong >= 4964L) && (paramLong <= 5397L))
      {
        i = 255;
        f1 = f2;
      }
      else
      {
        f1 = f2;
        i = j;
        if (paramLong > 5397L)
        {
          f1 = f2;
          i = j;
          if (paramLong < 5564L)
          {
            i = (int)(255L * (5564L - paramLong) / 167L);
            f1 = (167.0F - (float)(5397L - paramLong) * 0.5F) / 167.0F;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isr
 * JD-Core Version:    0.7.0.1
 */