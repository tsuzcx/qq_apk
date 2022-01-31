import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bhq
  implements Runnable
{
  public bhq(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    bhr localbhr = new bhr(this);
    bhs localbhs = new bhs(this);
    localQQCustomDialog.setPositiveButton(2131363356, localbhr);
    localQQCustomDialog.setNegativeButton(2131362801, localbhs);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bhq
 * JD-Core Version:    0.7.0.1
 */