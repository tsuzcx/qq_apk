import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aktf
  implements View.OnClickListener
{
  public aktf(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    AutoReplyEditActivity.b(this.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktf
 * JD-Core Version:    0.7.0.1
 */