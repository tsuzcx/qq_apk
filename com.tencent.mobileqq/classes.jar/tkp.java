import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class tkp
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private tkq jdField_a_of_type_Tkq;
  private tkr jdField_a_of_type_Tkr;
  private tks jdField_a_of_type_Tks;
  
  public tkp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Tkr = new tkr(this);
    this.jdField_a_of_type_Tks = new tks(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Tkr);
    stb.a().registerSubscriber(this.jdField_a_of_type_Tks);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Tkq);
    }
    if (this.jdField_a_of_type_Tkq != null) {
      this.jdField_a_of_type_Tkq.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Tkr);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Tks);
    this.jdField_a_of_type_Tkq = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(tkq paramtkq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramtkq);
    }
    this.jdField_a_of_type_Tkq = paramtkq;
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
 * Qualified Name:     tkp
 * JD-Core Version:    0.7.0.1
 */