import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoNotifyCenter;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.qphone.base.util.QLog;

public class bhc
  implements ServiceConnection
{
  public bhc(VideoAppInterface paramVideoAppInterface) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = IQQServiceForAV.Stub.a(paramIBinder);
    try
    {
      this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
      this.a.a(new Object[] { Integer.valueOf(10) });
      return;
    }
    catch (RemoteException paramComponentName)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "onServiceConnected", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
      }
      this.a.a(new Object[] { Integer.valueOf(11) });
      this.a.a().deleteObservers();
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "onServiceDisconnected", paramComponentName);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhc
 * JD-Core Version:    0.7.0.1
 */