public class isk
  extends isd
{
  public boolean mIsBig;
  
  public void iP(boolean paramBoolean)
  {
    this.mIsBig = paramBoolean;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int k = 0;
    int j = 0;
    int i;
    float f;
    if (this.mIsBig) {
      if (paramLong <= 1400L)
      {
        i = 255;
        if (paramLong > 250L) {
          break label104;
        }
        f = -0.0016F * (float)paramLong + 1.0F;
      }
    }
    label262:
    for (;;)
    {
      setAlpha(i);
      setScale(f);
      return;
      i = j;
      if (paramLong <= 1400L) {
        break;
      }
      i = j;
      if (paramLong >= 1500L) {
        break;
      }
      i = (int)(255L * (paramLong - 1500L) / -100L);
      break;
      label104:
      if ((paramLong > 250L) && (paramLong <= 400L))
      {
        f = 0.004666667F * (float)paramLong - 0.5666665F;
      }
      else if ((paramLong > 400L) && (paramLong <= 1250L))
      {
        f = 1.3F;
      }
      else if ((paramLong > 1250L) && (paramLong <= 1500L))
      {
        f = -0.0052F * (float)paramLong + 7.8F;
      }
      else
      {
        f = 0.0F;
        continue;
        if (paramLong <= 800L) {
          i = 255;
        }
        for (;;)
        {
          if (paramLong > 250L) {
            break label262;
          }
          f = -0.0016F * (float)paramLong + 1.0F;
          break;
          i = k;
          if (paramLong > 800L)
          {
            i = k;
            if (paramLong < 900L) {
              i = (int)(255L * (paramLong - 900L) / -100L);
            }
          }
        }
        if ((paramLong > 250L) && (paramLong <= 400L)) {
          f = 0.004666667F * (float)paramLong - 0.5666665F;
        } else if ((paramLong > 400L) && (paramLong <= 650L)) {
          f = 1.3F;
        } else if ((paramLong > 650L) && (paramLong <= 900L)) {
          f = -0.0052F * (float)paramLong + 4.68F;
        } else {
          f = 0.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isk
 * JD-Core Version:    0.7.0.1
 */