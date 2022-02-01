import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class zij
  implements View.OnClickListener
{
  public zij(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (acms)this.this$0.app.getBusinessHandler(20);
    String str;
    if (localObject != null)
    {
      ((acms)localObject).a(Long.parseLong(this.this$0.mTroopUin), this.val$list, this.val$checkBox.isChecked(), this.bbz);
      str = this.this$0.aQS;
      if (!this.val$checkBox.isChecked()) {
        break label152;
      }
    }
    label152:
    for (localObject = "0";; localObject = "1")
    {
      anot.a(this.this$0.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.this$0.mTroopUin, str, (String)localObject, "");
      if ((this.val$dialog != null) && (this.val$dialog.isShowing())) {
        this.val$dialog.dismiss();
      }
      this.this$0.bXk();
      this.this$0.G.show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zij
 * JD-Core Version:    0.7.0.1
 */