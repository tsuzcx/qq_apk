import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ttf
  implements View.OnClickListener
{
  public ttf(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    this.a.a(0, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ttf
 * JD-Core Version:    0.7.0.1
 */