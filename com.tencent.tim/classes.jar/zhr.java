import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class zhr
  implements View.OnClickListener
{
  public zhr(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.this$0.mTroopUin);
    List localList = (List)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.D.get(ChatHistoryTroopMemberFragment.a(this.this$0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      localArrayList.add(((ChatHistoryTroopMemberFragment.a)localList.get(i)).uin);
      i += 1;
    }
    ((Intent)localObject).putExtra("members_uin", localArrayList);
    PublicFragmentActivity.start(paramView.getContext(), (Intent)localObject, TroopMemberHistoryFragment.class);
    localObject = ((TroopManager)this.this$0.getActivity().app.getManager(52)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.app.getCurrentAccountUin());
    aqfr.b("Grp_edu", "teachermsg", "showall", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.c((TroopMemberInfo)localObject) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhr
 * JD-Core Version:    0.7.0.1
 */