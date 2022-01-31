import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.ContactUtils;

public class wqk
  implements Runnable
{
  public wqk(ShowExternalTroopListActivity paramShowExternalTroopListActivity, TextView paramTextView1, TextView paramTextView2) {}
  
  public void run()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.a);
    Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.runOnUiThread(new wql(this, str, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqk
 * JD-Core Version:    0.7.0.1
 */