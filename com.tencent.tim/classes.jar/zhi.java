import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zhi
  implements View.OnClickListener
{
  zhi(zhh paramzhh) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.bbo = false;
    this.a.this$0.Gk.setText(2131721064);
    this.a.this$0.Gk.setVisibility(0);
    this.a.this$0.Gk.setOnClickListener(this.a.this$0.dw);
    this.a.this$0.Gk.setEnabled(true);
    this.a.this$0.Bi.setVisibility(8);
    this.a.this$0.Bi = ((TextView)ChatHistoryTroopMemberFragment.a(this.a.this$0, 2131369579));
    this.a.this$0.Bi.setVisibility(0);
    this.a.this$0.Bi.setOnClickListener(this.a.this$0.dx);
    if (this.a.this$0.a != null) {
      this.a.this$0.a.bSJ();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhi
 * JD-Core Version:    0.7.0.1
 */