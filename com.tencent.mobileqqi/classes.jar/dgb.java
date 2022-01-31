import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dgb
  implements Runnable
{
  public dgb(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, 230, null, null, 2131561746, 2131561875, null, null);
    localQQCustomDialog.setMessage(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setDividerGone();
    dgc localdgc = new dgc(this);
    dgd localdgd = new dgd(this);
    localQQCustomDialog.setPositiveButton(2131561875, localdgc);
    localQQCustomDialog.setNegativeButton(2131561746, localdgd);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dgb
 * JD-Core Version:    0.7.0.1
 */