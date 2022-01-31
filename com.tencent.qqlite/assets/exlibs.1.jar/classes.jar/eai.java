import android.view.animation.Transformation;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class eai
  implements ValueAnimation.AnimationUpdateListener
{
  public eai(VipTagView paramVipTagView) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    VipTagView.a(this.a, paramFloat1.floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eai
 * JD-Core Version:    0.7.0.1
 */