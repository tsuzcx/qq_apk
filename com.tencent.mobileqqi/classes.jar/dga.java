import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dga
  implements Runnable
{
  public dga(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, 230, null, null, 2131561746, 2131561875, null, null);
    localQQCustomDialog.setMessage(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setDividerGone();
    dgb localdgb = new dgb(this);
    dgc localdgc = new dgc(this);
    localQQCustomDialog.setPositiveButton(2131561875, localdgb);
    localQQCustomDialog.setNegativeButton(2131561746, localdgc);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dga
 * JD-Core Version:    0.7.0.1
 */