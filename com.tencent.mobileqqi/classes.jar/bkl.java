import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class bkl
  extends LBSObserver
{
  public bkl(PublicAccountManager paramPublicAccountManager) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3)
  {
    paramArrayOfByte = (QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBoolean)
    {
      double d1 = Double.valueOf(paramString1).doubleValue();
      double d2 = Double.valueOf(paramString2).doubleValue();
      this.a.a(this.a.jdField_a_of_type_AndroidContentContext, paramArrayOfByte, this.a.p, this.a.q, true, d1, d2, (BusinessObserver)PublicAccountManager.a(this.a).get());
    }
    for (;;)
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte.c(this.a.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      }
      return;
      this.a.a(this.a.jdField_a_of_type_AndroidContentContext, paramArrayOfByte, this.a.p, this.a.q, false, 0.0D, 0.0D, (BusinessObserver)PublicAccountManager.a(this.a).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkl
 * JD-Core Version:    0.7.0.1
 */