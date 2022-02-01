import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView;
import dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment;

public class axhr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public axhr(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AEVideoShelfPreviewFragment.a(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      AEVideoShelfPreviewFragment.a(this.this$0).updateVideoSize(AEVideoShelfPreviewFragment.a(this.this$0).getVideoWidth(), AEVideoShelfPreviewFragment.a(this.this$0).getVideoHeight());
      return;
      AEVideoShelfPreviewFragment.a(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhr
 * JD-Core Version:    0.7.0.1
 */