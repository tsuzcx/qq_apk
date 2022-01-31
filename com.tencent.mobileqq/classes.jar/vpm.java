import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class vpm
  extends vne
{
  public vpm(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    veg.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpm
 * JD-Core Version:    0.7.0.1
 */