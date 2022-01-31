import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterActivity;

public class tot
  implements DialogInterface.OnClickListener
{
  public tot(RegisterActivity paramRegisterActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, "请稍候，请保证发送短信" + this.jdField_a_of_type_JavaLangString + "至" + this.b + "成功");
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity);
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tot
 * JD-Core Version:    0.7.0.1
 */