import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

class tyw
  implements DialogInterface.OnClickListener
{
  tyw(tyv paramtyv, SubAccountControll paramSubAccountControll, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_Tyv.a.app))
    {
      this.jdField_a_of_type_Tyv.a.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_Tyv.a.app, this.jdField_a_of_type_Tyv.a, null);
    }
    this.jdField_a_of_type_Tyv.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tyw
 * JD-Core Version:    0.7.0.1
 */