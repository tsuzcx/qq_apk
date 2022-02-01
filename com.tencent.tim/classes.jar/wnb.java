import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

public class wnb
  extends TranslateAnimation
{
  public static volatile boolean isReset;
  public int count = 0;
  
  public wnb()
  {
    this(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
  }
  
  public wnb(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    super(paramInt1, paramFloat1, paramInt2, paramFloat2, paramInt3, paramFloat3, paramInt4, paramFloat4);
    isReset = false;
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    this.count += 1;
    if ((!isReset) && (this.count <= 2))
    {
      setStartTime(paramLong);
      if (this.count == 2) {
        isReset = true;
      }
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void reset()
  {
    this.count = 0;
    isReset = false;
    super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnb
 * JD-Core Version:    0.7.0.1
 */