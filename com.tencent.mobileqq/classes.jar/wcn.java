import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class wcn
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private wco jdField_a_of_type_Wco;
  private wcp jdField_a_of_type_Wcp;
  private wcq jdField_a_of_type_Wcq;
  
  public wcn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Wcp = new wcp(this);
    this.jdField_a_of_type_Wcq = new wcq(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wcp);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wcq);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Wco);
    }
    if (this.jdField_a_of_type_Wco != null) {
      this.jdField_a_of_type_Wco.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wcp);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wcq);
    this.jdField_a_of_type_Wco = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(wco paramwco)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramwco);
    }
    this.jdField_a_of_type_Wco = paramwco;
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
 * Qualified Name:     wcn
 * JD-Core Version:    0.7.0.1
 */