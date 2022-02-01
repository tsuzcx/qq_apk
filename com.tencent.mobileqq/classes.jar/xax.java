import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class xax
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private xay jdField_a_of_type_Xay;
  private xaz jdField_a_of_type_Xaz;
  private xba jdField_a_of_type_Xba;
  
  public xax(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Xaz = new xaz(this);
    this.jdField_a_of_type_Xba = new xba(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xaz);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xba);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Xay);
    }
    if (this.jdField_a_of_type_Xay != null) {
      this.jdField_a_of_type_Xay.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xaz);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xba);
    this.jdField_a_of_type_Xay = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(xay paramxay)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramxay);
    }
    this.jdField_a_of_type_Xay = paramxay;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xax
 * JD-Core Version:    0.7.0.1
 */