import android.view.animation.Transformation;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class eqi
  implements ValueAnimation.AnimationUpdateListener
{
  public eqi(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = this.a.getLayoutParams();
    if (paramValueAnimation != null)
    {
      paramValueAnimation.height = paramInteger.intValue();
      this.a.setLayoutParams(paramValueAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eqi
 * JD-Core Version:    0.7.0.1
 */