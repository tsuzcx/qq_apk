import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;

public class bxv
  implements Runnable
{
  public bxv(AccountManageActivity paramAccountManageActivity, boolean paramBoolean, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b.a();
      if (localProxyManager != null)
      {
        localProxyManager.c();
        new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.runOnUiThread(new bxw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxv
 * JD-Core Version:    0.7.0.1
 */