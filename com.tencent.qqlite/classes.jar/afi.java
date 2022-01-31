import android.view.View;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class afi
  implements ActionSheet.OnButtonClickListener
{
  public afi(ChatSettingForTroop paramChatSettingForTroop, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app != null))
      {
        ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, 301, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.c, "", this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getAccount());
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.al == 1) {
          ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afi
 * JD-Core Version:    0.7.0.1
 */