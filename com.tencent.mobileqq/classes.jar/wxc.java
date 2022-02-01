import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class wxc
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private wxd jdField_a_of_type_Wxd;
  private wxe jdField_a_of_type_Wxe;
  private wxf jdField_a_of_type_Wxf;
  
  public wxc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Wxe = new wxe(this);
    this.jdField_a_of_type_Wxf = new wxf(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Wxe);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Wxf);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Wxd);
    }
    if (this.jdField_a_of_type_Wxd != null) {
      this.jdField_a_of_type_Wxd.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Wxe);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Wxf);
    this.jdField_a_of_type_Wxd = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(wxd paramwxd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramwxd);
    }
    this.jdField_a_of_type_Wxd = paramwxd;
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
 * Qualified Name:     wxc
 * JD-Core Version:    0.7.0.1
 */