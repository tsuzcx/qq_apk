import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ajvf
{
  private ajvd jdField_a_of_type_Ajvd;
  ajvi jdField_a_of_type_Ajvi = new ajvh(this);
  ajvc b;
  private AppInterface mApp;
  private Object mLock = new Object();
  private ServiceConnection mServiceConnection = new ajvg(this);
  
  public ajvf(AppInterface paramAppInterface, ajvd paramajvd)
  {
    this.mApp = paramAppInterface;
    this.jdField_a_of_type_Ajvd = paramajvd;
  }
  
  Message a(Message paramMessage)
  {
    if (this.jdField_a_of_type_Ajvd != null) {
      return this.jdField_a_of_type_Ajvd.a(paramMessage);
    }
    return null;
  }
  
  public Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (this.b == null) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.mLock)
        {
          if (this.b != null) {
            break label45;
          }
          return null;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (RemoteException paramVarArgs) {}
    }
    paramVarArgs.printStackTrace();
    return null;
    label45:
    paramVarArgs = this.b.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
    if (paramVarArgs == null) {
      return null;
    }
    paramVarArgs = paramVarArgs.s;
    return paramVarArgs;
  }
  
  public void amt()
  {
    this.mApp.getApp().unbindService(this.mServiceConnection);
  }
  
  public boolean arB()
  {
    return this.b != null;
  }
  
  public Message b(Message paramMessage)
  {
    if ((this.b == null) || (paramMessage == null)) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.mLock)
        {
          if (this.b != null) {
            break label49;
          }
          return null;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (RemoteException paramMessage) {}
    }
    paramMessage.printStackTrace();
    return null;
    label49:
    paramMessage = this.b.c(paramMessage);
    return paramMessage;
  }
  
  Object[] b(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_Ajvd != null) {
      return this.jdField_a_of_type_Ajvd.b(paramInt, paramVarArgs);
    }
    return null;
  }
  
  public void bindService()
  {
    Intent localIntent = new Intent(this.mApp.getApp(), ConnectNearbyProcService.class);
    this.mApp.getApp().bindService(localIntent, this.mServiceConnection, 1);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "bindService");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvf
 * JD-Core Version:    0.7.0.1
 */