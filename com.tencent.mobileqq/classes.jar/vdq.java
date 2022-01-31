import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class vdq
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private vdr jdField_a_of_type_Vdr;
  private vds jdField_a_of_type_Vds;
  private vdt jdField_a_of_type_Vdt;
  
  public vdq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Vds = new vds(this);
    this.jdField_a_of_type_Vdt = new vdt(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vds);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vdt);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Vdr);
    }
    if (this.jdField_a_of_type_Vdr != null) {
      this.jdField_a_of_type_Vdr.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vds);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vdt);
    this.jdField_a_of_type_Vdr = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(vdr paramvdr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramvdr);
    }
    this.jdField_a_of_type_Vdr = paramvdr;
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
 * Qualified Name:     vdq
 * JD-Core Version:    0.7.0.1
 */