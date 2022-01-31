import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class wzl
  implements Runnable
{
  public wzl(QWalletConfigManager paramQWalletConfigManager, WeakReference paramWeakReference) {}
  
  public void run()
  {
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQWalletConfigManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "getAllConfigAgain");
      }
      localQWalletConfigManager.a(QWalletConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzl
 * JD-Core Version:    0.7.0.1
 */