import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dgd
  implements Runnable
{
  public dgd(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, 230, null, null, 2131561746, 2131561875, null, null);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setDividerGone();
    dge localdge = new dge(this);
    dgf localdgf = new dgf(this);
    localQQCustomDialog.setPositiveButton(2131561875, localdge);
    localQQCustomDialog.setNegativeButton(2131561746, localdgf);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dgd
 * JD-Core Version:    0.7.0.1
 */