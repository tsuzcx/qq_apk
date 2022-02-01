import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

final class axwe
  implements aqnc.a<Float>
{
  axwe(View paramView) {}
  
  @TargetApi(11)
  public void a(aqnc<Float> paramaqnc, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QIMAnimationUtils", 2, "alphaAnimation value = " + paramFloat1);
    }
    paramFloat = paramFloat1.floatValue();
    if (this.val$v != null)
    {
      this.val$v.setAlpha(paramFloat);
      this.val$v.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwe
 * JD-Core Version:    0.7.0.1
 */