import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zej
  implements View.OnClickListener
{
  zej(zei paramzei) {}
  
  public void onClick(View paramView)
  {
    if ((!zvo.a("SUB_ENTER_FLOAT_MODE")) && (zei.a(this.a) != null)) {
      zei.a(this.a).d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zej
 * JD-Core Version:    0.7.0.1
 */