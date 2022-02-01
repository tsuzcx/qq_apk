import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.share.QZoneShareActivity;

public class awag
  implements View.OnClickListener
{
  public awag(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    QZoneShareActivity.f(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awag
 * JD-Core Version:    0.7.0.1
 */