import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView.CircleHolder;
import java.util.Iterator;
import java.util.List;

public class xnq
  implements ValueAnimator.AnimatorUpdateListener
{
  public xnq(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      RecordMicView.CircleHolder localCircleHolder = (RecordMicView.CircleHolder)paramValueAnimator.next();
      localCircleHolder.jdField_c_of_type_Float = (localCircleHolder.f + (localCircleHolder.g - localCircleHolder.f) * f);
      localCircleHolder.d = (localCircleHolder.h + (localCircleHolder.i - localCircleHolder.h) * f);
      localCircleHolder.e = (localCircleHolder.j + (localCircleHolder.k - localCircleHolder.j) * f);
      localCircleHolder.a = (localCircleHolder.b + (int)((localCircleHolder.jdField_c_of_type_Int - localCircleHolder.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnq
 * JD-Core Version:    0.7.0.1
 */