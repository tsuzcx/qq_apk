import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class eyn
  implements DialogInterface.OnClickListener
{
  eyn(eym parameym, boolean paramBoolean, TroopInfo paramTroopInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 0;
    paramDialogInterface.dismiss();
    if ((NetworkUtil.a(this.jdField_a_of_type_Eym.a.jdField_a_of_type_AndroidContentContext) == 0) && ((this.jdField_a_of_type_Eym.a.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
    {
      paramDialogInterface = (BaseActivity)this.jdField_a_of_type_Eym.a.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramDialogInterface, 2131560394, 0).b(paramDialogInterface.d());
      return;
    }
    paramDialogInterface = (BizTroopHandler)this.jdField_a_of_type_Eym.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (this.jdField_a_of_type_Boolean) {
      paramInt = 1;
    }
    paramDialogInterface.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eyn
 * JD-Core Version:    0.7.0.1
 */