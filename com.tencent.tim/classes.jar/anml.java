import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anml
  implements View.OnClickListener
{
  public anml(SplashADView paramSplashADView) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mVideoView != null)
    {
      if (!this.this$0.mVideoView.isMute()) {
        break label54;
      }
      this.this$0.mVideoView.setMute(false);
      this.this$0.DJ.setImageResource(2130851439);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label54:
      this.this$0.mVideoView.setMute(true);
      this.this$0.DJ.setImageResource(2130851440);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anml
 * JD-Core Version:    0.7.0.1
 */