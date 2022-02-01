import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uuk
  implements View.OnClickListener
{
  public uuk(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(View paramView)
  {
    DiscussionInfoCardActivity.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uuk
 * JD-Core Version:    0.7.0.1
 */