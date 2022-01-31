import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class aff
  implements Runnable
{
  aff(afe paramafe, boolean paramBoolean) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_Afe.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ArrayOfAndroidViewView[2];
    if ((localView != null) && (this.jdField_a_of_type_Afe.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
    {
      ((TextView)localView.findViewById(2131296932)).setText(this.jdField_a_of_type_Afe.jdField_a_of_type_JavaLangString);
      TextView localTextView = (TextView)localView.findViewById(2131296953);
      localTextView.setText(this.jdField_a_of_type_Afe.b);
      localTextView.setMaxLines(3);
      this.jdField_a_of_type_Afe.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(true);
      this.jdField_a_of_type_Afe.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(true);
      this.jdField_a_of_type_Afe.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, 0, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Afe.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, this.jdField_a_of_type_Afe.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aff
 * JD-Core Version:    0.7.0.1
 */