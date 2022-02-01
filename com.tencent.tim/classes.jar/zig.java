import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zig
  implements View.OnClickListener
{
  public zig(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)localObject).intValue();
    } while (i < 0);
    localObject = paramView.findViewById(2131380801);
    if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof Boolean))) {}
    for (boolean bool = ((Boolean)((View)localObject).getTag()).booleanValue();; bool = false)
    {
      if (bool)
      {
        localObject = (ChatHistoryTroopMemberFragment.a)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$e.getItem(i);
        this.this$0.a((ChatHistoryTroopMemberFragment.a)localObject);
        if ((this.this$0.W != null) && (this.this$0.W.isShowing())) {
          this.this$0.W.dismiss();
        }
        if (this.this$0.mFrom != 11) {
          break;
        }
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
        break;
      }
      localObject = (ChatHistoryTroopMemberFragment.a)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.getItem(i);
      this.this$0.a((ChatHistoryTroopMemberFragment.a)localObject);
      if (this.this$0.mFrom == 11) {
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
      }
      if (this.this$0.mFrom != 18) {
        break;
      }
      anot.a(this.this$0.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.this$0.mTroopUin, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zig
 * JD-Core Version:    0.7.0.1
 */