import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.SparseBooleanArray;
import android.view.View;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import java.util.HashMap;

public class shx
  extends AnimatorListenerAdapter
{
  public shx(VideoPlayerView paramVideoPlayerView, int paramInt1, View paramView, boolean paramBoolean, int paramInt2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.aLG) {
      VideoPlayerView.a(this.this$0, this.val$view, this.val$end, this.val$start, false);
    }
    while ((this.val$end != 0) || (VideoPlayerView.a() == null) || (VideoPlayerView.a().get(this.val$view.getId()))) {
      return;
    }
    this.val$view.setVisibility(8);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.val$end == 1) && (VideoPlayerView.a() != null) && (!VideoPlayerView.a().get(this.val$view.getId()))) {
      this.val$view.setVisibility(0);
    }
    if ((this.val$end == 0) && (VideoPlayerView.a() != null) && (!VideoPlayerView.a().get(this.val$view.getId()))) {
      VideoPlayerView.x().put(this.val$view, Integer.valueOf(this.val$view.getVisibility()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shx
 * JD-Core Version:    0.7.0.1
 */