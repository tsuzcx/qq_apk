import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class xik
  extends xgc
{
  public xik(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    wxe.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xik
 * JD-Core Version:    0.7.0.1
 */