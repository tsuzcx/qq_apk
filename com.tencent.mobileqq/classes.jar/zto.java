import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zto
  implements View.OnClickListener
{
  zto(ztn paramztn) {}
  
  public void onClick(View paramView)
  {
    if ((!aala.a("SUB_ENTER_FLOAT_MODE")) && (ztn.a(this.a) != null)) {
      ztn.a(this.a).d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zto
 * JD-Core Version:    0.7.0.1
 */