import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.a;
import com.tencent.mobileqq.activity.TroopMemberListActivity.c;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class wbh
  implements View.OnClickListener
{
  public wbh(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.this$0.mTroopUin);
    List localList = (List)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.D.get(TroopMemberListActivity.a(this.this$0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      localArrayList.add(((TroopMemberListActivity.a)localList.get(i)).uin);
      i += 1;
    }
    ((Intent)localObject).putExtra("members_uin", localArrayList);
    PublicFragmentActivity.start(paramView.getContext(), (Intent)localObject, TroopMemberHistoryFragment.class);
    localObject = ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.app.getCurrentAccountUin());
    aqfr.b("Grp_edu", "teachermsg", "showall", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.c((TroopMemberInfo)localObject) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbh
 * JD-Core Version:    0.7.0.1
 */