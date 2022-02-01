import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class zhj
  implements View.OnClickListener
{
  public zhj(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mFrom == 15) && (ChatHistoryTroopMemberFragment.a(this.this$0).size() > 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("param_deleted_uins", ChatHistoryTroopMemberFragment.a(this.this$0));
      this.this$0.getActivity().setResult(-1, localIntent);
      if ((this.this$0.aPW == null) || (!this.this$0.aPW.equals(this.this$0.getActivity().app.getCurrentAccountUin()))) {
        break label178;
      }
    }
    label178:
    for (int i = 0;; i = 1)
    {
      anot.a(this.this$0.getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, this.this$0.mTroopUin, "" + i, "1", ChatHistoryTroopMemberFragment.a(this.this$0).toString());
      this.this$0.getActivity().finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhj
 * JD-Core Version:    0.7.0.1
 */