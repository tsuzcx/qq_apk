import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class upu
  implements ausj.a
{
  public upu(ChatSettingForTroop paramChatSettingForTroop, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.this$0.jdField_a_of_type_Arib == null) {
      this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
    }
    if (aqiw.isNetSupport(this.this$0))
    {
      paramView = (acms)this.this$0.app.getBusinessHandler(20);
      if (paramView != null)
      {
        if ((this.this$0.bFO & 0x1) == 0)
        {
          ChatSettingForTroop localChatSettingForTroop = this.this$0;
          localChatSettingForTroop.bFO |= 0x1;
          paramView.Fc(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        this.this$0.jdField_a_of_type_Arib.aq(0, 2131693298, 1000);
      }
    }
    for (;;)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.val$actionSheet.cancel();
      return;
      this.this$0.jdField_a_of_type_Arib.aq(2, 2131693293, 1500);
      continue;
      this.this$0.jdField_a_of_type_Arib.aq(2, 2131696348, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upu
 * JD-Core Version:    0.7.0.1
 */