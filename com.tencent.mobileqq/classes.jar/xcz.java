import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCConnector;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

public class xcz
  implements EIPClientConnectListener
{
  public xcz(QWalletIPCConnector paramQWalletIPCConnector, long paramLong) {}
  
  public void connectFailed()
  {
    QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector, false);
    QWalletIPCConnector.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector, false);
    synchronized (QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector))
    {
      QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector, ???.procName);
    }
    QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector, true);
    QWalletIPCConnector.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector, false);
    synchronized (QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector))
    {
      QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcz
 * JD-Core Version:    0.7.0.1
 */