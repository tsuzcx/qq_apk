import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout.a;

public class awuk
  implements Animator.AnimatorListener
{
  public awuk(AEAlbumLinearLayout paramAEAlbumLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEAlbumLinearLayout.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null) {
      AEAlbumLinearLayout.a(this.a).cw(AEAlbumLinearLayout.a(this.a), AEAlbumLinearLayout.a(this.a, AEAlbumLinearLayout.a(this.a)));
    }
    AEAlbumLinearLayout.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null) {
      AEAlbumLinearLayout.a(this.a).onScrollStart(AEAlbumLinearLayout.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awuk
 * JD-Core Version:    0.7.0.1
 */