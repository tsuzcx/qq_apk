import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.activity.ContactBindedActivity;

public class urr
  extends ScaleAnimation
{
  public urr(ContactBindedActivity paramContactBindedActivity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, float paramFloat5, int paramInt2, float paramFloat6)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramFloat5, paramInt2, paramFloat6);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramTransformation == null) {
      return;
    }
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation.setAlpha(0.0F + 1.0F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urr
 * JD-Core Version:    0.7.0.1
 */