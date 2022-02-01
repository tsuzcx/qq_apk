import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class akpc
{
  private long aea;
  private long duration = 250L;
  private boolean finished = true;
  private final Interpolator interpolator = new AccelerateDecelerateInterpolator();
  private float xP;
  private float xQ;
  private float xR;
  
  private static float interpolate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public void T(float paramFloat1, float paramFloat2)
  {
    this.finished = false;
    this.aea = SystemClock.elapsedRealtime();
    this.xP = paramFloat1;
    this.xQ = paramFloat2;
    this.xR = paramFloat1;
  }
  
  public void apC()
  {
    this.finished = true;
  }
  
  public boolean ast()
  {
    if (this.finished) {
      return false;
    }
    long l = SystemClock.elapsedRealtime() - this.aea;
    if (l >= this.duration)
    {
      this.finished = true;
      this.xR = this.xQ;
      return false;
    }
    float f = this.interpolator.getInterpolation((float)l / (float)this.duration);
    this.xR = interpolate(this.xP, this.xQ, f);
    return true;
  }
  
  public float bm()
  {
    return this.xR;
  }
  
  public boolean isFinished()
  {
    return this.finished;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpc
 * JD-Core Version:    0.7.0.1
 */