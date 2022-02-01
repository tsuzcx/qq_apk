import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class riu
  extends rhj.b
{
  public riu(ElasticImageView paramElasticImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.d.nv = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.d, this.d.nv);
    ram.d("ElasticImageView", "updateAnimator:" + this.d.nv);
    ElasticImageView.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     riu
 * JD-Core Version:    0.7.0.1
 */