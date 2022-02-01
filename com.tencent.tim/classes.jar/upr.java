import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;

public class upr
  implements ausj.a
{
  public upr(ChatSettingForTroop paramChatSettingForTroop, ausj paramausj) {}
  
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
    paramView = (acms)this.this$0.app.getBusinessHandler(20);
    if ((aqiw.isNetSupport(this.this$0.app.getApp().getApplicationContext())) && (paramView != null))
    {
      this.this$0.jdField_a_of_type_Arib.aq(0, 2131693294, 0);
      paramView.Fb(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    for (;;)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.val$actionSheet.cancel();
      return;
      if (paramView != null) {
        this.this$0.jdField_a_of_type_Arib.aq(2, 2131696348, 1500);
      } else {
        this.this$0.jdField_a_of_type_Arib.aq(2, 2131693293, 1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upr
 * JD-Core Version:    0.7.0.1
 */