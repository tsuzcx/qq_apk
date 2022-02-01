import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;

public class rfc
  implements Animation.AnimationListener
{
  public rfc(ArtFilterItemView paramArtFilterItemView, EditVideoArtFilter paramEditVideoArtFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.aHx = false;
    if (this.this$0 != null) {
      this.this$0.setVisibility(8);
    }
    if (this.c != null) {
      this.c.tx(true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfc
 * JD-Core Version:    0.7.0.1
 */