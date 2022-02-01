import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;

public class iuq
{
  iuq.a jdField_a_of_type_Iuq$a = null;
  iuq.b jdField_a_of_type_Iuq$b = new iuq.b();
  ity b = null;
  Context mContext = null;
  
  public iuq(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void D(byte[] paramArrayOfByte)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.b.D(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void G(byte[] paramArrayOfByte)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.b.G(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return null;
      try
      {
        paramArrayOfByte = this.b.a(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "processQCallPush RemoteException", paramArrayOfByte);
    return null;
  }
  
  public void a(iuq.a parama)
  {
    this.jdField_a_of_type_Iuq$a = parama;
    bu(this.mContext);
  }
  
  public void bu(Context paramContext)
  {
    if (this.b == null)
    {
      Intent localIntent = new Intent(paramContext, AVServiceForQQ.class);
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.jdField_a_of_type_Iuq$b, 1);
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "bindService result == " + bool);
      }
    }
  }
  
  public int d(long paramLong, int paramInt)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.b.d(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public void dT()
  {
    unbindService(this.mContext);
    this.jdField_a_of_type_Iuq$a = null;
  }
  
  public void h(String paramString, Bitmap paramBitmap)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.b.g(paramString, paramBitmap);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "pushStrangeFace RemoteException", paramString);
  }
  
  public void in(String paramString)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.b.jB(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "onGetQCallNickName RemoteException", paramString);
  }
  
  public void unbindService(Context paramContext)
  {
    paramContext.getApplicationContext().unbindService(this.jdField_a_of_type_Iuq$b);
    this.b = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(iuq paramiuq);
  }
  
  class b
    implements ServiceConnection
  {
    b() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "Qav Service connected!");
      }
      iuq.this.b = ity.a.a(paramIBinder);
      if ((iuq.this.b != null) && (iuq.this.a != null)) {
        iuq.this.a.a(iuq.this);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("QavWrapper", 2, "mQavProxy == null or mOnReadyListener == null");
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "Qav Service disconnected!");
      }
      iuq.this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iuq
 * JD-Core Version:    0.7.0.1
 */