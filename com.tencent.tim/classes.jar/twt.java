import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;

public class twt
  extends ValueAnimator
{
  private long EQ;
  private boolean aQt;
  private boolean isReversed;
  private float oL;
  private float oM = 1.0F;
  private float progress;
  
  public twt()
  {
    setFloatValues(new float[] { 0.0F, 1.0F });
    addListener(new twu(this));
    addUpdateListener(new twv(this));
  }
  
  private void al(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    float f;
    if (paramFloat < this.oL) {
      f = this.oL;
    }
    for (;;)
    {
      this.progress = f;
      if (getDuration() > 0L) {
        setCurrentPlayTime(((f - this.oL) / (this.oM - this.oL) * (float)getDuration()));
      }
      return;
      f = paramFloat;
      if (paramFloat > this.oM) {
        f = this.oM;
      }
    }
  }
  
  public void G(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    if (this.isReversed)
    {
      paramFloat2 = paramFloat1;
      if (!this.isReversed) {
        break label76;
      }
    }
    label76:
    for (float f2 = f1;; f2 = paramFloat1)
    {
      setFloatValues(new float[] { paramFloat2, f2 });
      super.setDuration(((float)this.EQ * (paramFloat1 - f1)));
      setProgress(getProgress());
      return;
      paramFloat2 = f1;
      break;
    }
  }
  
  public float aG()
  {
    return this.oL;
  }
  
  public void bEN()
  {
    this.aQt = true;
  }
  
  public void bEO()
  {
    al(getProgress());
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public void resume()
  {
    float f = this.progress;
    start();
    setProgress(f);
  }
  
  public ValueAnimator setDuration(long paramLong)
  {
    this.EQ = paramLong;
    G(this.oL, this.oM);
    return this;
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.oM = paramFloat;
    G(this.oL, paramFloat);
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.oL = paramFloat;
    G(paramFloat, this.oM);
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.progress == paramFloat) {
      return;
    }
    float f;
    if (paramFloat < this.oL) {
      f = this.oL;
    }
    for (;;)
    {
      this.progress = f;
      if ((getDuration() <= 0L) || (this.aQt)) {
        break;
      }
      setCurrentPlayTime(((f - this.oL) / (this.oM - this.oL) * (float)getDuration()));
      return;
      f = paramFloat;
      if (paramFloat > this.oM) {
        f = this.oM;
      }
    }
  }
  
  public void vB(boolean paramBoolean)
  {
    this.isReversed = paramBoolean;
    G(this.oL, this.oM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twt
 * JD-Core Version:    0.7.0.1
 */