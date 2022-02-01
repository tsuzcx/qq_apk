import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class adfu
  extends adgo.a
{
  adfu(adfp paramadfp) {}
  
  public void Ky(int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadProcess process=" + paramInt);
    }
    Message localMessage = adfp.a(this.c).obtainMessage();
    localMessage.what = 102;
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void cPS()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadSuccess");
    }
    Message localMessage = adfp.a(this.c).obtainMessage();
    localMessage.what = 100;
    localMessage.sendToTarget();
  }
  
  public void cPT()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadFail");
    }
    Message localMessage = adfp.a(this.c).obtainMessage();
    localMessage.what = 101;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfu
 * JD-Core Version:    0.7.0.1
 */