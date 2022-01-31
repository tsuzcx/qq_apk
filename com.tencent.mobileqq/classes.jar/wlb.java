import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopMemberCard;

class wlb
  implements Runnable
{
  wlb(wla paramwla, String paramString, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_Wla.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Wla.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Wla.b.setText("我的群标签");
    }
    do
    {
      TroopMemberCard localTroopMemberCard;
      do
      {
        return;
        this.jdField_a_of_type_Wla.b.setText("他的群标签");
        if (this.jdField_a_of_type_Wla.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.b == null) {
          break;
        }
        localTroopMemberCard = this.jdField_a_of_type_Wla.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_Wla.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.b, this.jdField_a_of_type_Wla.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_JavaLangString);
      } while (localTroopMemberCard == null);
      if (localTroopMemberCard.sex == 1) {
        this.jdField_a_of_type_Wla.b.setText("她的群标签");
      }
      this.jdField_a_of_type_Wla.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopMemberCard.nick);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender != 1));
    this.jdField_a_of_type_Wla.b.setText("她的群标签");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wlb
 * JD-Core Version:    0.7.0.1
 */