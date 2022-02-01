import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class aact
  implements EIPCOnGetConnectionListener
{
  aact(aacs paramaacs) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      aacs.a(this.b, paramEIPCConnection.procName);
    }
    aacs.a(this.b, true);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      aacs.a(this.b, paramEIPCConnection.procName);
    }
    aacs.a(this.b, false);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aact
 * JD-Core Version:    0.7.0.1
 */