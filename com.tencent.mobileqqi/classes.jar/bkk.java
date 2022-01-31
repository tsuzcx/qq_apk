import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class bkk
  implements Runnable
{
  public bkk(PublicAccountManager paramPublicAccountManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (localQQAppInterface != null))
    {
      localQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      arrayOfByte = localQQAppInterface.b();
      ((LBSHandler)localQQAppInterface.a(3)).a(arrayOfByte);
    }
    while (localQQAppInterface == null)
    {
      byte[] arrayOfByte;
      return;
    }
    this.a.a(this.a.jdField_a_of_type_AndroidContentContext, localQQAppInterface, this.a.p, this.a.q, false, 0.0D, 0.0D, (BusinessObserver)PublicAccountManager.a(this.a).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkk
 * JD-Core Version:    0.7.0.1
 */