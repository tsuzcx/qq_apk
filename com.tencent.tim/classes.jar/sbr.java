import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sbr
  implements View.OnClickListener
{
  sbr(sbq paramsbq) {}
  
  public void onClick(View paramView)
  {
    if ((!sox.fY("SUB_ENTER_FLOAT_MODE")) && (sbq.a(this.a) != null)) {
      sbq.a(this.a).MJ();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbr
 * JD-Core Version:    0.7.0.1
 */