import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class aope
  implements EIPClientConnectListener
{
  aope(aopd paramaopd) {}
  
  public void connectFailed()
  {
    aopd.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      aopd.a(this.this$0, paramEIPCConnection.procName);
    }
    aopd.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    aopd.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aope
 * JD-Core Version:    0.7.0.1
 */