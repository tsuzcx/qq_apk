import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

class adfr
  extends adgn.a
{
  adfr(adfp paramadfp) {}
  
  public void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig, ARCommonConfigInfo paramARCommonConfigInfo)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onConfigChanged!");
    }
    if (adfp.a(this.c) == null) {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onConfigChanged error mHandler is null ");
    }
    do
    {
      return;
      if (paramArConfigInfo != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = paramArConfigInfo;
        adfp.a(this.c).sendMessage(localMessage);
      }
      if (paramArEffectConfig != null)
      {
        paramArConfigInfo = Message.obtain();
        paramArConfigInfo.what = 2;
        paramArConfigInfo.obj = paramArEffectConfig;
        adfp.a(this.c).sendMessage(paramArConfigInfo);
      }
    } while (paramARCommonConfigInfo == null);
    paramArConfigInfo = Message.obtain();
    paramArConfigInfo.what = 9;
    paramArConfigInfo.obj = paramARCommonConfigInfo;
    adfp.a(this.c).sendMessage(paramArConfigInfo);
  }
  
  public void ez(int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadError|error= " + paramInt);
    }
    if (adfp.a(this.c) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadError error mHandler is null ");
      return;
    }
    adfp.a(this.c).sendMessage(adfp.a(this.c).obtainMessage(5, Integer.valueOf(paramInt)));
  }
  
  public void m(long paramLong1, long paramLong2)
    throws RemoteException
  {
    if (paramLong2 != 0L)
    {
      long l = 100L * paramLong1 / paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadProcess percent= " + l);
      }
      if (adfp.a(this.c) == null) {
        QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadProcess error mHandler is null ");
      }
    }
    else
    {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.arg1 = ((int)paramLong1);
    localMessage.arg2 = ((int)paramLong2);
    adfp.a(this.c).sendMessage(localMessage);
  }
  
  public void onDownloadSuccess()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadSuccess ");
    }
    if (adfp.a(this.c) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadSuccess error mHandler is null ");
      return;
    }
    adfp.a(this.c).sendMessage(adfp.a(this.c).obtainMessage(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfr
 * JD-Core Version:    0.7.0.1
 */