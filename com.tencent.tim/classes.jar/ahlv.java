import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahlv
  implements View.OnClickListener
{
  public ahlv(ForwardShortVideoOption paramForwardShortVideoOption) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mActivity != null) {
      ForwardShortVideoOption.a(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlv
 * JD-Core Version:    0.7.0.1
 */