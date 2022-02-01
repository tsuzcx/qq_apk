import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class avxv
  extends avxl
{
  avyr a;
  
  avxv(avyr paramavyr)
  {
    this.a = paramavyr;
  }
  
  public PluginRecord a(String paramString)
  {
    try
    {
      paramString = this.a.a(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (NullPointerException paramString)
    {
      for (;;)
      {
        QLog.w("QZonePluginClient", 1, "", paramString);
      }
    }
  }
  
  public void a(Context paramContext, avxl.b paramb, avxl.a parama)
  {
    try
    {
      a(paramb.mPluginID, new avxw(this, parama, paramContext, paramb), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(avxq paramavxq, int paramInt)
    throws RemoteException
  {
    try
    {
      this.a.a(paramavxq, paramInt);
      return;
    }
    catch (NullPointerException paramavxq)
    {
      QLog.e("QZonePluginClient", 1, paramavxq, new Object[0]);
    }
  }
  
  public boolean a(String paramString, avxr paramavxr, int paramInt)
    throws RemoteException
  {
    try
    {
      boolean bool = this.a.a(paramString, paramavxr, paramInt);
      return bool;
    }
    catch (NullPointerException paramString)
    {
      QLog.e("QZonePluginClient", 1, paramString, new Object[0]);
    }
    return false;
  }
  
  public void destroy()
  {
    this.a = null;
  }
  
  public void eCv()
    throws RemoteException
  {
    try
    {
      this.a.eCv();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("QZonePluginClient", 1, localNullPointerException, new Object[0]);
    }
  }
  
  boolean isAlive()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.a != null)
      {
        IBinder localIBinder = this.a.asBinder();
        bool1 = bool2;
        if (localIBinder != null)
        {
          bool1 = bool2;
          if (localIBinder.isBinderAlive())
          {
            boolean bool3 = localIBinder.pingBinder();
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    try
    {
      boolean bool = this.a.isPluginInstalled(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean isReady()
  {
    try
    {
      boolean bool = this.a.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  public boolean tB(String paramString)
  {
    try
    {
      boolean bool = this.a.tB(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean tr(String paramString)
  {
    try
    {
      boolean bool = this.a.tr(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxv
 * JD-Core Version:    0.7.0.1
 */