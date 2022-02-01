import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ajry
{
  private static ajry jdField_a_of_type_Ajry;
  private ajry.b jdField_a_of_type_Ajry$b;
  private ajrz jdField_a_of_type_Ajrz = new ajrz();
  public boolean bdN;
  private ity c;
  public boolean cpW;
  public boolean cpX;
  public boolean cpY;
  private int dkQ = -1;
  private int dkR;
  private long mGroupId;
  
  private void Mo(boolean paramBoolean)
  {
    if (this.c == null) {}
    do
    {
      return;
      try
      {
        this.c.setSoundEnable(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "setSoundEnable: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public static ajry a()
  {
    if (jdField_a_of_type_Ajry == null) {}
    try
    {
      if (jdField_a_of_type_Ajry == null) {
        jdField_a_of_type_Ajry = new ajry();
      }
      return jdField_a_of_type_Ajry;
    }
    finally {}
  }
  
  private void dza()
  {
    if (this.dkQ != -1) {
      if (this.dkQ != 0) {
        break label23;
      }
    }
    label23:
    for (boolean bool = true;; bool = false)
    {
      Mo(bool);
      return;
    }
  }
  
  private boolean kF(int paramInt)
  {
    return paramInt == 2;
  }
  
  public int GB()
  {
    return this.jdField_a_of_type_Ajrz.getState();
  }
  
  public boolean JN()
  {
    return this.c != null;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    if ((!this.cpX) && (!this.cpY)) {
      this.jdField_a_of_type_Ajrz.b(paramInt1, paramString1, paramInt2, paramLong, paramString2);
    }
  }
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    if ((!this.cpX) && (!this.cpY)) {
      this.jdField_a_of_type_Ajrz.b(paramInt, paramString1, 10, paramLong, paramString2);
    }
  }
  
  public void a(ajry.a parama)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (this.c == null)
    {
      localIntent = new Intent(localBaseApplicationImpl, AVServiceForQQ.class);
      this.jdField_a_of_type_Ajry$b = new ajry.b(parama);
      localBaseApplicationImpl.bindService(localIntent, this.jdField_a_of_type_Ajry$b, 1);
    }
    while (parama == null)
    {
      Intent localIntent;
      return;
    }
    parama.cgn();
  }
  
  public void aqG()
  {
    if (this.c == null) {}
    do
    {
      return;
      try
      {
        this.c.aqG();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "startSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void aqH()
  {
    if (this.c == null) {}
    do
    {
      return;
      try
      {
        this.c.aqH();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "stopSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void cB(long paramLong)
  {
    if (this.c == null) {
      return;
    }
    try
    {
      this.c.cB(paramLong);
      this.cpW = false;
      this.jdField_a_of_type_Ajrz.dismiss();
      this.c = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameRoomAVController", 2, "exitRoom: " + QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void dyZ()
  {
    this.jdField_a_of_type_Ajrz.dismiss();
  }
  
  public void onActivityResume()
  {
    dza();
  }
  
  public void r(long paramLong, String paramString)
  {
    this.mGroupId = paramLong;
    if (this.c == null) {}
    do
    {
      return;
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).a().um())) {
          this.c.aqI();
        }
        this.c.r(paramLong, paramString);
        this.cpW = true;
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "enterRoom: " + QLog.getStackTraceString(paramString));
  }
  
  public void reset(Context paramContext)
  {
    this.c = null;
    paramContext.stopService(new Intent(paramContext, AVServiceForQQ.class));
  }
  
  public void setSoundEnable(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      this.dkQ = i;
      if ((!paramBoolean) || (!kF(this.dkR))) {
        break;
      }
      return;
    }
    Mo(paramBoolean);
  }
  
  public void unbindService()
  {
    if (this.jdField_a_of_type_Ajry$b != null)
    {
      BaseApplicationImpl.getApplication().unbindService(this.jdField_a_of_type_Ajry$b);
      this.jdField_a_of_type_Ajry$b = null;
    }
    this.c = null;
  }
  
  public void zQ(int paramInt)
  {
    this.dkR = paramInt;
    if (kF(paramInt))
    {
      Mo(false);
      return;
    }
    dza();
  }
  
  public static abstract interface a
  {
    public abstract void cgn();
    
    public abstract void cgo();
  }
  
  public class b
    implements ServiceConnection
  {
    private WeakReference<ajry.a> hs;
    
    public b(ajry.a parama)
    {
      this.hs = new WeakReference(parama);
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      ajry.a(ajry.this, ity.a.a(paramIBinder));
      paramComponentName = (ajry.a)this.hs.get();
      if (paramComponentName != null) {
        paramComponentName.cgn();
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      ajry.a(ajry.this, null);
      paramComponentName = (ajry.a)this.hs.get();
      if (paramComponentName != null) {
        paramComponentName.cgo();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajry
 * JD-Core Version:    0.7.0.1
 */