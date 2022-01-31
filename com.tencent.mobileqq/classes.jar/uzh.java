import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class uzh
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private uzi jdField_a_of_type_Uzi;
  private uzj jdField_a_of_type_Uzj;
  private uzk jdField_a_of_type_Uzk;
  
  public uzh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Uzj = new uzj(this);
    this.jdField_a_of_type_Uzk = new uzk(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Uzj);
    uht.a().registerSubscriber(this.jdField_a_of_type_Uzk);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Uzi);
    }
    if (this.jdField_a_of_type_Uzi != null) {
      this.jdField_a_of_type_Uzi.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Uzj);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Uzk);
    this.jdField_a_of_type_Uzi = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(uzi paramuzi)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramuzi);
    }
    this.jdField_a_of_type_Uzi = paramuzi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzh
 * JD-Core Version:    0.7.0.1
 */