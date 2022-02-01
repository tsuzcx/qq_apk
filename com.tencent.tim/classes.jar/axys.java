import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class axys
  implements EIPClientConnectListener
{
  axys(axyr paramaxyr) {}
  
  public void connectFailed()
  {
    axyr.a(this.b, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectFailed!");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      axyr.a(this.b, paramEIPCConnection.procName);
    }
    axyr.a(this.b, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectSuccess:" + axyr.a(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axys
 * JD-Core Version:    0.7.0.1
 */