import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

final class arof
  implements EIPClientConnectListener
{
  public void connectFailed()
  {
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "connectSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arof
 * JD-Core Version:    0.7.0.1
 */