import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ziu
  implements View.OnClickListener
{
  public ziu(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.getActivity().setResult(0, this.this$0.getActivity().getIntent());
    this.this$0.getActivity().finish();
    if (this.this$0.mFrom == 11) {
      anot.a(this.this$0.getActivity().app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ziu
 * JD-Core Version:    0.7.0.1
 */