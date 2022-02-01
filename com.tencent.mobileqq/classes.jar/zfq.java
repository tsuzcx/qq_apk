import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class zfq
  extends zdi
{
  public zfq(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    yuk.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfq
 * JD-Core Version:    0.7.0.1
 */