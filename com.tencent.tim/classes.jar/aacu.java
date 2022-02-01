import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class aacu
  implements EIPClientConnectListener
{
  aacu(aacs paramaacs, long paramLong) {}
  
  public void connectFailed()
  {
    aacs.a(this.b, false);
    aacs.b(this.b, false);
    synchronized (aacs.a(this.b))
    {
      aacs.a(this.b).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + aacs.a(this.b));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      aacs.a(this.b, ???.procName);
    }
    aacs.a(this.b, true);
    aacs.b(this.b, false);
    synchronized (aacs.a(this.b))
    {
      aacs.a(this.b).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + aacs.a(this.b) + "|" + (l - this.LM));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacu
 * JD-Core Version:    0.7.0.1
 */