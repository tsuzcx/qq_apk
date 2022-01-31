import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class tpm
  implements Runnable
{
  public tpm(RegisterNewBaseActivity paramRegisterNewBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setPositiveButton(2131436320, new tpn(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpm
 * JD-Core Version:    0.7.0.1
 */