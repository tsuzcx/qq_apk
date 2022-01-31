import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

class tre
  implements DialogInterface.OnClickListener
{
  tre(trd paramtrd, SubAccountControll paramSubAccountControll, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_Trd.a.app))
    {
      this.jdField_a_of_type_Trd.a.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_Trd.a.app, this.jdField_a_of_type_Trd.a, null);
    }
    this.jdField_a_of_type_Trd.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tre
 * JD-Core Version:    0.7.0.1
 */