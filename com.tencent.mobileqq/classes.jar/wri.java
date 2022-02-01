import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class wri
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private wrj jdField_a_of_type_Wrj;
  private wrk jdField_a_of_type_Wrk;
  private wrl jdField_a_of_type_Wrl;
  
  public wri(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Wrk = new wrk(this);
    this.jdField_a_of_type_Wrl = new wrl(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Wrk);
    wad.a().registerSubscriber(this.jdField_a_of_type_Wrl);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Wrj);
    }
    if (this.jdField_a_of_type_Wrj != null) {
      this.jdField_a_of_type_Wrj.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Wrk);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Wrl);
    this.jdField_a_of_type_Wrj = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(wrj paramwrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramwrj);
    }
    this.jdField_a_of_type_Wrj = paramwrj;
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
 * Qualified Name:     wri
 * JD-Core Version:    0.7.0.1
 */