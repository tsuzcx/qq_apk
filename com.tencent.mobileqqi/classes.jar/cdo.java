import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class cdo
  implements Runnable
{
  cdo(cdn paramcdn, boolean paramBoolean) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_Cdn.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ArrayOfAndroidViewView[4];
    if ((localView != null) && (this.jdField_a_of_type_Cdn.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
    {
      ((TextView)localView.findViewById(2131230941)).setText(this.jdField_a_of_type_Cdn.jdField_a_of_type_JavaLangString);
      TextView localTextView = (TextView)localView.findViewById(2131231507);
      localTextView.setText(this.jdField_a_of_type_Cdn.b);
      localTextView.setMaxLines(3);
      this.jdField_a_of_type_Cdn.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(true);
      this.jdField_a_of_type_Cdn.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(true);
      this.jdField_a_of_type_Cdn.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, 0, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Cdn.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, this.jdField_a_of_type_Cdn.b);
      localView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cdo
 * JD-Core Version:    0.7.0.1
 */