import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uvd
  implements View.OnClickListener
{
  public uvd(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.ay.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvd
 * JD-Core Version:    0.7.0.1
 */