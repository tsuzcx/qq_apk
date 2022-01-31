import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import mqq.observer.BusinessObserver;

public class xap
  implements Runnable
{
  public xap(QWalletCommonServlet paramQWalletCommonServlet, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xap
 * JD-Core Version:    0.7.0.1
 */