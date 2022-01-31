import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

class dlg
  implements DialogInterface.OnClickListener
{
  dlg(dle paramdle, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Dle.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c);
      this.jdField_a_of_type_Dle.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dlg
 * JD-Core Version:    0.7.0.1
 */