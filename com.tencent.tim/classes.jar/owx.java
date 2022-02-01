import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class owx
  implements View.OnClickListener
{
  owx(oww paramoww) {}
  
  public void onClick(View paramView)
  {
    oww.a(this.a).bki();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owx
 * JD-Core Version:    0.7.0.1
 */