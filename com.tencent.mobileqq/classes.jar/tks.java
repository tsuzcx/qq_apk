import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class tks
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private tkt jdField_a_of_type_Tkt;
  private tku jdField_a_of_type_Tku;
  private tkv jdField_a_of_type_Tkv;
  
  public tks(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Tku = new tku(this);
    this.jdField_a_of_type_Tkv = new tkv(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Tku);
    ste.a().registerSubscriber(this.jdField_a_of_type_Tkv);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Tkt);
    }
    if (this.jdField_a_of_type_Tkt != null) {
      this.jdField_a_of_type_Tkt.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Tku);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Tkv);
    this.jdField_a_of_type_Tkt = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(tkt paramtkt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramtkt);
    }
    this.jdField_a_of_type_Tkt = paramtkt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tks
 * JD-Core Version:    0.7.0.1
 */