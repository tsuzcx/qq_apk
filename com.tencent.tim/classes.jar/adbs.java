import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class adbs
  extends adgo.a
{
  adbs(adbr paramadbr) {}
  
  public void Ky(int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(adca.TAG, 2, "onArSoDownloadProcess process=" + paramInt);
    }
  }
  
  public void cPS()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(adca.TAG, 2, "onArSoDownloadSuccess");
    }
    this.a.clean();
  }
  
  public void cPT()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(adca.TAG, 2, "onArSoDownloadFail");
    }
    this.a.clean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbs
 * JD-Core Version:    0.7.0.1
 */