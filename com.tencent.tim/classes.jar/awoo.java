import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class awoo
  implements EIPClientConnectListener
{
  awoo(awom paramawom, long paramLong) {}
  
  public void connectFailed()
  {
    awom.a(this.b, false);
    awom.b(this.b, false);
    synchronized (awom.a(this.b))
    {
      awom.a(this.b).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + awom.a(this.b));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      awom.a(this.b, ???.procName);
    }
    awom.a(this.b, true);
    awom.b(this.b, false);
    synchronized (awom.a(this.b))
    {
      awom.a(this.b).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + awom.a(this.b) + "|" + (l - this.LM));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awoo
 * JD-Core Version:    0.7.0.1
 */