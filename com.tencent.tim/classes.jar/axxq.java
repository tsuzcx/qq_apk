import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.QIMSlidingTabView;

public class axxq
  implements View.OnClickListener
{
  public axxq(QIMSlidingTabView paramQIMSlidingTabView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.d.TX(this.val$index);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxq
 * JD-Core Version:    0.7.0.1
 */