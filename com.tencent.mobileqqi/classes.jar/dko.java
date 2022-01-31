import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterActivity;

public class dko
  implements DialogInterface.OnClickListener
{
  public dko(RegisterActivity paramRegisterActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity.getString(2131559099, new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity);
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dko
 * JD-Core Version:    0.7.0.1
 */