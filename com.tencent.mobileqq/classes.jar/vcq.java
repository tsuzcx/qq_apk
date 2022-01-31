import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class vcq
  extends vai
{
  public vcq(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    urk.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcq
 * JD-Core Version:    0.7.0.1
 */