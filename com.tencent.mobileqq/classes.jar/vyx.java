import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.album.view.AlbumImageView;

class vyx
  implements Animation.AnimationListener
{
  vyx(vyw paramvyw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (vys.a(this.a.a) == 1)
    {
      this.a.a.b.setVisibility(8);
      vys.a(this.a.a).sendEmptyMessage(1);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyx
 * JD-Core Version:    0.7.0.1
 */