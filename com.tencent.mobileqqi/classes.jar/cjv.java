import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class cjv
  implements Runnable
{
  cjv(cju paramcju, boolean paramBoolean) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_Cju.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ArrayOfAndroidViewView[4];
    if ((localView != null) && (this.jdField_a_of_type_Cju.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
    {
      ((TextView)localView.findViewById(2131230941)).setText(this.jdField_a_of_type_Cju.jdField_a_of_type_JavaLangString);
      TextView localTextView = (TextView)localView.findViewById(2131231506);
      localTextView.setText(this.jdField_a_of_type_Cju.b);
      localTextView.setMaxLines(3);
      this.jdField_a_of_type_Cju.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(true);
      this.jdField_a_of_type_Cju.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(true);
      this.jdField_a_of_type_Cju.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, 0, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Cju.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, this.jdField_a_of_type_Cju.b);
      localView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjv
 * JD-Core Version:    0.7.0.1
 */