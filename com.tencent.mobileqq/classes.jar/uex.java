import android.view.animation.Transformation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class uex
  implements ValueAnimation.AnimationUpdateListener
{
  public uex(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.a.c.setText(paramInteger + "");
    if (paramInteger.intValue() > 9999)
    {
      this.a.c.setTextSize(36.0F);
      return;
    }
    this.a.c.setTextSize(44.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uex
 * JD-Core Version:    0.7.0.1
 */