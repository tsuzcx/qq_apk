import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ntj
  implements View.OnClickListener
{
  public ntj(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    CommonSuspensionGestureLayout.a(this.this$0).h(true, 0, 5);
    CommonSuspensionGestureLayout.a(this.this$0, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntj
 * JD-Core Version:    0.7.0.1
 */