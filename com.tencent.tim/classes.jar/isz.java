import com.tencent.qphone.base.util.QLog;

public class isz
  extends isd
{
  public boolean mIsBig;
  
  public void iP(boolean paramBoolean)
  {
    this.mIsBig = paramBoolean;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramInt1 * 39 / 750;
    paramInt3 = paramInt1 * 59 / 750;
    setBounds(paramInt2, paramInt3, paramInt1 - paramInt2, paramInt1 * 268 / 750 + paramInt3);
  }
  
  public void update(long paramLong)
  {
    long l = paramLong - this.mStartTime;
    int k = 0;
    int j = 0;
    int i;
    float f;
    if (this.mIsBig) {
      if ((l > 0L) && (l < 100L))
      {
        i = (int)(255L * l / 100L);
        if ((l <= 0L) || (l > 200L)) {
          break label226;
        }
        f = -0.0035F * (float)l + 1.5F;
      }
    }
    label539:
    for (;;)
    {
      QLog.d("RedPacketGameParticleTopWordTip", 2, "WL_DEBUG update duration = " + l + ", alpha = " + i + ", scale = " + f + ", curTime = " + paramLong + ", mStartTime = " + this.mStartTime);
      setAlpha(i);
      setScale(f);
      return;
      if ((l >= 100L) && (l <= 1200L))
      {
        i = 255;
        break;
      }
      i = j;
      if (l <= 1200L) {
        break;
      }
      i = j;
      if (l >= 1250L) {
        break;
      }
      i = (int)(255L * (l - 1250L) / -50L);
      break;
      label226:
      if ((l > 200L) && (l <= 350L))
      {
        f = 0.001333333F * (float)l + 0.5333334F;
      }
      else if ((l > 350L) && (l <= 450L))
      {
        f = -0.001F * (float)l + 1.35F;
      }
      else if ((l > 450L) && (l <= 550L))
      {
        f = 0.001F * (float)l + 0.45F;
      }
      else if ((l > 550L) && (l <= 1100L))
      {
        f = 1.0F;
      }
      else if ((l > 1100L) && (l <= 1150L))
      {
        f = 0.0016F * (float)l - 0.76F;
      }
      else if ((l > 1150L) && (l <= 1250L))
      {
        f = -0.0108F * (float)l + 13.5F;
      }
      else
      {
        f = 0.0F;
        continue;
        if ((l > 0L) && (l < 100L)) {
          i = (int)(255L * l / 100L);
        }
        for (;;)
        {
          if ((l <= 0L) || (l > 200L)) {
            break label539;
          }
          f = -0.0035F * (float)l + 1.5F;
          break;
          if ((l >= 100L) && (l <= 700L))
          {
            i = 255;
          }
          else
          {
            i = k;
            if (l > 700L)
            {
              i = k;
              if (l < 750L) {
                i = (int)(255L * (l - 750L) / -50L);
              }
            }
          }
        }
        if ((l > 200L) && (l <= 350L)) {
          f = 0.001333333F * (float)l + 0.5333334F;
        } else if ((l > 350L) && (l <= 450L)) {
          f = -0.001F * (float)l + 1.35F;
        } else if ((l > 450L) && (l <= 550L)) {
          f = 0.001F * (float)l + 0.45F;
        } else if ((l > 550L) && (l <= 600L)) {
          f = 1.0F;
        } else if ((l > 600L) && (l <= 650L)) {
          f = 0.0016F * (float)l + 0.04F;
        } else if ((l > 650L) && (l <= 750L)) {
          f = -0.0108F * (float)l + 8.1F;
        } else {
          f = 0.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isz
 * JD-Core Version:    0.7.0.1
 */