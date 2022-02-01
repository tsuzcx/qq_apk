import android.animation.ValueAnimator;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class aynw
  extends aylh.b
{
  public aynw(ElasticImageView paramElasticImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.nv = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.b, this.b.nv);
    ram.d("ElasticImageView", "updateAnimator:" + this.b.nv);
    ElasticImageView.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynw
 * JD-Core Version:    0.7.0.1
 */