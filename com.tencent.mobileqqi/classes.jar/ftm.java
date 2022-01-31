import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ftm
  implements DialogInterface.OnClickListener
{
  ftm(ftl paramftl, SharedPreferences paramSharedPreferences, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("FileViewFirstTips5.0", true).commit();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ftm
 * JD-Core Version:    0.7.0.1
 */