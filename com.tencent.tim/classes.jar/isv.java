public class isv
  extends isd
{
  public boolean mIsReady;
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBounds(paramInt1 * 5 / 1500, paramInt2 - paramInt1 * 752 / 750, paramInt1 * 1495 / 1500, paramInt2);
  }
  
  public void update(long paramLong)
  {
    long l = paramLong - this.mStartTime;
    setRotation((float)(paramLong - this.mStartTime) / 50.0F);
    int j = 0;
    int i;
    if (l < 500L) {
      i = (int)(l * 255L / 500L);
    }
    for (;;)
    {
      setAlpha(i);
      return;
      if (((l >= 500L) && (l <= 5397L)) || (!this.mIsReady))
      {
        i = 255;
      }
      else
      {
        i = j;
        if (l > 5397L)
        {
          i = j;
          if (l < 5564L)
          {
            i = j;
            if (this.mIsReady) {
              i = (int)((l - 5564L) * 255L / -167L);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isv
 * JD-Core Version:    0.7.0.1
 */