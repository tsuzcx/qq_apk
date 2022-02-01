import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class cuu
  implements Runnable
{
  public cuu(LoginPhoneNumActivity paramLoginPhoneNumActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityLoginPhoneNumActivity, 230, null, null, 2131561746, 2131561875, null, null);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setDividerGone();
    cuv localcuv = new cuv(this);
    cuw localcuw = new cuw(this);
    localQQCustomDialog.setPositiveButton(2131561875, localcuv);
    localQQCustomDialog.setNegativeButton(2131561746, localcuw);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cuu
 * JD-Core Version:    0.7.0.1
 */