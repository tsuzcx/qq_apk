import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class bgy
  extends TimerTask
{
  public bgy(RegisterActivity paramRegisterActivity, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "reQuerySms schedule");
    }
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity);
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgy
 * JD-Core Version:    0.7.0.1
 */