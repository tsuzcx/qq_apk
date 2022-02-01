import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.activity.TimLebaListMgrActivity;

public class ugf
  implements View.OnClickListener
{
  public ugf(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.getActivity(), TimLebaListMgrActivity.class);
    this.this$0.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugf
 * JD-Core Version:    0.7.0.1
 */