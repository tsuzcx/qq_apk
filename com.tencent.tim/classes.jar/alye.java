import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alye
  implements View.OnClickListener
{
  public alye(QQSlidingTabView paramQQSlidingTabView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.d.TX(this.val$index);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alye
 * JD-Core Version:    0.7.0.1
 */