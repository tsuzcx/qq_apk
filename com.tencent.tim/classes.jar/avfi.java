import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoProxyService;

public class avfi
{
  avfi.a jdField_a_of_type_Avfi$a = null;
  avfi.b jdField_a_of_type_Avfi$b = new avfi.b();
  iob jdField_a_of_type_Iob = null;
  AppInterface mApp;
  
  public avfi(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  public void D(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Iob == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Iob.D(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void a(avfi.a parama)
  {
    this.jdField_a_of_type_Avfi$a = parama;
    if (this.jdField_a_of_type_Iob == null) {
      avfh.a(this.mApp, GVideoProxyService.class, this.jdField_a_of_type_Avfi$b, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
    }
  }
  
  public void aoF()
  {
    if (this.jdField_a_of_type_Iob != null) {}
    try
    {
      this.jdField_a_of_type_Iob.aoF();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public int d(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Iob == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_Iob.d(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public void dT()
  {
    avfh.b(this.mApp, this.jdField_a_of_type_Avfi$b);
    this.jdField_a_of_type_Iob = null;
    this.jdField_a_of_type_Avfi$a = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(avfi paramavfi);
  }
  
  class b
    implements ServiceConnection
  {
    b() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "Qav Service connected!");
      }
      avfi.this.jdField_a_of_type_Iob = iob.a.a(paramIBinder);
      if ((avfi.this.jdField_a_of_type_Iob != null) && (avfi.this.jdField_a_of_type_Avfi$a != null)) {
        avfi.this.jdField_a_of_type_Avfi$a.a(avfi.this);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null or mOnReadyListener == null");
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "Qav Service disconnected!");
      }
      avfi.this.jdField_a_of_type_Iob = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfi
 * JD-Core Version:    0.7.0.1
 */