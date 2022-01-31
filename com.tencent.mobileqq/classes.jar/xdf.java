import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.troopgift.TroopGiftPanel;

class xdf
  implements DialogInterface.OnShowListener
{
  xdf(xdb paramxdb) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ((InputMethodManager)this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getContext().getSystemService("input_method")).showSoftInput(this.a.jdField_a_of_type_AndroidWidgetEditText, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xdf
 * JD-Core Version:    0.7.0.1
 */