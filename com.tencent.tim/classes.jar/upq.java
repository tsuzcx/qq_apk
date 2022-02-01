import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class upq
  implements ausj.a
{
  public upq(ChatSettingForTroop paramChatSettingForTroop, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.val$actionSheet.a(paramInt);
    if (paramView != null)
    {
      paramInt = paramView.action;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      paramInt = -1;
      break;
      ChatSettingForTroop.e(this.this$0);
      aqfr.b("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      continue;
      apuh.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.this$0.app);
      continue;
      if (this.this$0.jdField_a_of_type_Apzg != null) {
        this.this$0.jdField_a_of_type_Apzg.onDestroy();
      }
      this.this$0.jdField_a_of_type_Apzg = apuh.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.this$0.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upq
 * JD-Core Version:    0.7.0.1
 */