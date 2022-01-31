import android.support.v4.view.ViewCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.ptt.SoundLevelSource;
import com.tencent.mobileqq.widget.RoundWaveView;
import com.tencent.qphone.base.util.QLog;

public final class ezf
  implements Runnable
{
  private final float jdField_a_of_type_Float;
  private final long jdField_a_of_type_Long;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  private boolean jdField_a_of_type_Boolean = true;
  private final float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long = -1L;
  private final float c;
  private final float d;
  
  public ezf(RoundWaveView paramRoundWaveView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a()
  {
    QLog.i("RoundWaveView", 2, "stop wave animation");
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    int i = RoundWaveView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView).a();
    if ((!this.jdField_a_of_type_Boolean) || (i <= RoundWaveView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView)))
    {
      RoundWaveView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView, 0.95F * RoundWaveView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView));
      if (this.jdField_b_of_type_Long != -1L) {
        break label142;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView.invalidate();
      if ((!this.jdField_a_of_type_Boolean) && (RoundWaveView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView) <= 0.1F) && (RoundWaveView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView) == this.jdField_b_of_type_Float)) {
        break label259;
      }
      ViewCompat.postOnAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView, this);
      return;
      RoundWaveView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView, (i - RoundWaveView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView)) / 4.0F);
      break;
      label142:
      if (RoundWaveView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView) != this.jdField_b_of_type_Float)
      {
        long l = Math.max(Math.min((System.currentTimeMillis() - this.jdField_b_of_type_Long) * 1000L / this.jdField_a_of_type_Long, 1000L), 0L);
        float f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation((float)l / 1000.0F);
        RoundWaveView.c(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView, this.jdField_a_of_type_Float + (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float) * f1);
        RoundWaveView localRoundWaveView = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundWaveView;
        float f2 = this.c;
        RoundWaveView.d(localRoundWaveView, f1 * (this.d - this.c) + f2);
      }
    }
    label259:
    QLog.d("RoundWaveView", 2, "wave is stopped.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ezf
 * JD-Core Version:    0.7.0.1
 */