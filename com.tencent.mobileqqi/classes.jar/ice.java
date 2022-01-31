import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qzone.UploadServerSetting;

public class ice
  implements DialogInterface.OnClickListener
{
  public ice(UploadServerSetting paramUploadServerSetting, EditText paramEditText1, EditText paramEditText2, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.b != null))
    {
      paramDialogInterface = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      String str = this.b.getText().toString();
      UploadServerSetting.a(this.jdField_a_of_type_CooperationQzoneUploadServerSetting, paramDialogInterface, str);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ice
 * JD-Core Version:    0.7.0.1
 */