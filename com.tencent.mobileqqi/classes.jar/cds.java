import android.view.View;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cds
  implements ActionSheet.OnButtonClickListener
{
  public cds(ChatSettingForTroop paramChatSettingForTroop, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.b != null))
      {
        ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, 301, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.c, "", this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.b.getAccount());
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.ao == 1) {
          ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cds
 * JD-Core Version:    0.7.0.1
 */