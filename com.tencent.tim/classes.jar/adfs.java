import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class adfs
  extends adgk.a
{
  adfs(adfp paramadfp) {}
  
  public void KT(int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "download success " + paramInt);
    }
    if (adfp.a(this.c) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadSuccess error mHandler is null ");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    localMessage.arg1 = paramInt;
    adfp.a(this.c).sendMessage(localMessage);
  }
  
  public void hm(int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "download process " + paramInt1 + " : " + paramInt2);
    }
    if (adfp.a(this.c) == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    adfp.a(this.c).sendMessage(localMessage);
  }
  
  public void hn(int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "download error " + paramInt1 + " : " + paramInt2);
    }
    if (adfp.a(this.c) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadError error mHandler is null ");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    adfp.a(this.c).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfs
 * JD-Core Version:    0.7.0.1
 */