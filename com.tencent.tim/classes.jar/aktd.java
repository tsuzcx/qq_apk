import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aktd
  implements View.OnClickListener
{
  public aktd(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    if (AutoReplyEditActivity.c(this.this$0)) {
      AutoReplyEditActivity.a(this.this$0, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AutoReplyEditActivity.d(this.this$0)) {
        AutoReplyEditActivity.b(this.this$0, false);
      } else {
        AutoReplyEditActivity.a(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktd
 * JD-Core Version:    0.7.0.1
 */