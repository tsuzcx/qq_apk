import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class cuv
  implements Runnable
{
  public cuv(LoginPhoneNumActivity paramLoginPhoneNumActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityLoginPhoneNumActivity, 230, null, null, 2131561746, 2131561875, null, null);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setDividerGone();
    cuw localcuw = new cuw(this);
    cux localcux = new cux(this);
    localQQCustomDialog.setPositiveButton(2131561875, localcuw);
    localQQCustomDialog.setNegativeButton(2131561746, localcux);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cuv
 * JD-Core Version:    0.7.0.1
 */