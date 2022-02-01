import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.b;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.c;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ymu
  implements View.OnClickListener
{
  public ymu(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)localObject).intValue();
      if ((i >= 0) && (this.this$0.a != null))
      {
        localObject = this.this$0.getActivity();
        if (localObject != null)
        {
          anot.a(this.this$0.mApp, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_clk", 0, 0, this.this$0.mTroopUin, "", "", "");
          MessageRecord localMessageRecord = ((TroopMemberHistoryFragment.b)this.this$0.a.getItem(i)).messageRecord;
          ChatHistoryBubbleListForTroopFragment.a((Activity)localObject, this.this$0.mTroopUin, localMessageRecord, 100, 1);
          if (QLog.isColorLevel()) {
            QLog.i(TroopMemberHistoryFragment.TAG, 2, "onItemClick, message = " + localMessageRecord);
          }
          anot.a(this.this$0.mApp, "CliOper", "", "", "0X800A597", "0X800A597", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymu
 * JD-Core Version:    0.7.0.1
 */