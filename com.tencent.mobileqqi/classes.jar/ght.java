import MyCarrier.Carrier;
import com.tencent.mobileqq.activity.QQSettingMe.UpdateMyBusinessReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.mybusiness.MyBusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class ght
  extends MyBusinessObserver
{
  public ght(MyBusinessManager paramMyBusinessManager) {}
  
  public void a(boolean paramBoolean, Carrier paramCarrier, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessManager", 4, "onCarrierQuery refreshTimeSpan = " + paramInt);
    }
    this.a.jdField_a_of_type_Int = paramInt;
    if (this.a.jdField_a_of_type_Int > 86400) {
      this.a.jdField_a_of_type_Int = 86400;
    }
    this.a.a(paramCarrier);
    QQSettingMe.UpdateMyBusinessReceiver.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ght
 * JD-Core Version:    0.7.0.1
 */