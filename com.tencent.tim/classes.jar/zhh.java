import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zhh
  implements View.OnClickListener
{
  public zhh(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bbo = true;
    this.this$0.Bi.setVisibility(8);
    this.this$0.Bi = ((TextView)ChatHistoryTroopMemberFragment.a(this.this$0, 2131369581));
    this.this$0.Bi.setVisibility(0);
    this.this$0.Bi.setText(acfp.m(2131703678));
    this.this$0.Bi.setOnClickListener(new zhi(this));
    ChatHistoryTroopMemberFragment.a(this.this$0);
    if (this.this$0.a != null) {
      this.this$0.a.bSJ();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhh
 * JD-Core Version:    0.7.0.1
 */