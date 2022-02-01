import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vbx
  implements View.OnClickListener
{
  vbx(vbr paramvbr) {}
  
  public void onClick(View paramView)
  {
    vbr.a(this.a).d();
    aaak.a().a(new QCircleDanmakuEvent(8, false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbx
 * JD-Core Version:    0.7.0.1
 */