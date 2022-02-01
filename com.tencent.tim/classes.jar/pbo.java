import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;

public class pbo
  implements View.OnClickListener
{
  public pbo(QCircleContentVideo paramQCircleContentVideo) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.a().isPlaying()) {
        this.this$0.pause();
      } else if (QCircleContentVideo.a(this.this$0)) {
        this.this$0.replay();
      } else {
        this.this$0.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbo
 * JD-Core Version:    0.7.0.1
 */