import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.8;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akte
  implements View.OnClickListener
{
  public akte(AutoReplyEditActivity.8 param8) {}
  
  public void onClick(View paramView)
  {
    AutoReplyEditActivity.a(this.a.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akte
 * JD-Core Version:    0.7.0.1
 */