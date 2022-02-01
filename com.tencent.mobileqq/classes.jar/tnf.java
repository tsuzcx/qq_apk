import android.animation.ValueAnimator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageController$AnimatorState;", "", "animator", "Landroid/animation/ValueAnimator;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageController;Landroid/animation/ValueAnimator;)V", "getAnimator", "()Landroid/animation/ValueAnimator;", "currentPlayTime", "", "getCurrentPlayTime", "()J", "setCurrentPlayTime", "(J)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tnf
{
  private long jdField_a_of_type_Long;
  @NotNull
  private final ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  
  public tnf(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = localObject;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final ValueAnimator a()
  {
    return this.jdField_a_of_type_AndroidAnimationValueAnimator;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnf
 * JD-Core Version:    0.7.0.1
 */