import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class zrx
  implements Runnable
{
  public zrx(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "isCallTabShow needupdate,result=" + this.jdField_a_of_type_JavaLangStringBuilder);
    }
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_calltab_show_key", this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrx
 * JD-Core Version:    0.7.0.1
 */