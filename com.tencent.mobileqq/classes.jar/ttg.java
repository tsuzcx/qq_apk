import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ttg
  implements View.OnClickListener
{
  public ttg(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    CommonSuspensionGestureLayout.a(this.a).a(true, 0, 5);
    CommonSuspensionGestureLayout.a(this.a, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ttg
 * JD-Core Version:    0.7.0.1
 */