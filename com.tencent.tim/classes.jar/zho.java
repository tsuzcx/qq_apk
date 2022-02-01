import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class zho
  implements View.OnClickListener
{
  public zho(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    rom.checkNotNull(this.this$0.a);
    rom.checkNotNull(this.this$0.pr);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.this$0.pr.size())
    {
      localArrayList.add(((ChatHistoryTroopMemberFragment.a)this.this$0.pr.get(i)).uin);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.this$0.getActivity().setResult(-1, localIntent);
    this.this$0.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zho
 * JD-Core Version:    0.7.0.1
 */