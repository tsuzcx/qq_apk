import com.tencent.mobileqq.activity.RegisterBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bha
  implements Runnable
{
  public bha(RegisterBaseActivity paramRegisterBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setPositiveButton(2131364110, new bhb(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bha
 * JD-Core Version:    0.7.0.1
 */