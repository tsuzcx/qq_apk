import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCConnector;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

public class xcy
  implements EIPCOnGetConnectionListener
{
  public xcy(QWalletIPCConnector paramQWalletIPCConnector) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      QWalletIPCConnector.a(this.a, paramEIPCConnection.procName);
    }
    QWalletIPCConnector.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      QWalletIPCConnector.a(this.a, paramEIPCConnection.procName);
    }
    QWalletIPCConnector.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcy
 * JD-Core Version:    0.7.0.1
 */