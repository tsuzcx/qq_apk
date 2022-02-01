import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.call.activity.CallActivity;

public class atcr
  implements View.OnClickListener
{
  public atcr(CallActivity paramCallActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcr
 * JD-Core Version:    0.7.0.1
 */