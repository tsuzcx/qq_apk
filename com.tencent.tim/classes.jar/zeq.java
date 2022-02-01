import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zeq
  implements View.OnClickListener
{
  public zeq(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.mApp, "dc00898", "", "", "0X800A16A", "0X800A16A", ChatHistoryBaseTenDocFragment.a(this.this$0), 0, "", "", "s_qq_history_tab", "");
    aobw.q(this.this$0.getActivity(), "s_qq_history_tab", 1121);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zeq
 * JD-Core Version:    0.7.0.1
 */