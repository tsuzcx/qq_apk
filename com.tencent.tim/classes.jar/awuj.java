import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout.a;

public class awuj
  implements ValueAnimator.AnimatorUpdateListener
{
  public awuj(AEAlbumLinearLayout paramAEAlbumLinearLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getAnimatedValue() instanceof Integer))
    {
      if (AEAlbumLinearLayout.a(this.a) != null) {
        AEAlbumLinearLayout.a(this.a).bq(AEAlbumLinearLayout.a(this.a));
      }
      this.a.scrollTo(0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awuj
 * JD-Core Version:    0.7.0.1
 */