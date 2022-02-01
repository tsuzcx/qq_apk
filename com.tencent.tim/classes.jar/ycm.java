import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ycm
  implements View.OnClickListener
{
  ycm(ycd paramycd) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.structingMsg != null) {
      anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8004EFC", "0X8004EFC", 0, 0, "", "", "" + this.this$0.structingMsg.msgId, "");
    }
    this.this$0.bGY();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycm
 * JD-Core Version:    0.7.0.1
 */