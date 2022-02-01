import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vah
  implements View.OnClickListener
{
  vah(vab paramvab) {}
  
  public void onClick(View paramView)
  {
    vab.a(this.a).d();
    zwp.a().a(new QCircleDanmakuEvent(8, false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vah
 * JD-Core Version:    0.7.0.1
 */