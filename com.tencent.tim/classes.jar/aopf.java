import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class aopf
  implements EIPCOnGetConnectionListener
{
  aopf(aopd paramaopd) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      aopd.a(this.this$0, paramEIPCConnection.procName);
    }
    aopd.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      aopd.a(this.this$0, paramEIPCConnection.procName);
    }
    aopd.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopf
 * JD-Core Version:    0.7.0.1
 */