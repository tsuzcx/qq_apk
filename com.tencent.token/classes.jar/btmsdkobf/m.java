package btmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class m
{
  private static String TAG = "OpenDeviceId library";
  private static boolean aj = false;
  private l ai;
  private ServiceConnection ak;
  private a al = null;
  private Context mContext = null;
  
  private void h(String paramString)
  {
    if (aj) {
      Log.i(TAG, paramString);
    }
  }
  
  private void i(String paramString)
  {
    if (aj) {
      Log.e(TAG, paramString);
    }
  }
  
  public int a(Context paramContext, a<String> parama)
  {
    if (paramContext != null)
    {
      this.mContext = paramContext;
      this.al = parama;
      this.ak = new ServiceConnection()
      {
        public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          try
          {
            m.a(m.this, l.a.b(paramAnonymousIBinder));
            if (m.a(m.this) != null) {
              m.a(m.this).a("Deviceid Service Connected", m.this);
            }
            m.a(m.this, "Service onServiceConnected");
            return;
          }
          finally {}
        }
        
        public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          m.a(m.this, null);
          m.a(m.this, "Service onServiceDisconnected");
        }
      };
      paramContext = new Intent();
      paramContext.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
      if (this.mContext.bindService(paramContext, this.ak, 1))
      {
        h("bindService Successful!");
        return 1;
      }
      h("bindService Failed!");
      return -1;
    }
    throw new NullPointerException("Context can not be null.");
  }
  
  public String g()
  {
    if (this.mContext != null)
    {
      try
      {
        if (this.ai != null)
        {
          String str = this.ai.g();
          return str;
        }
      }
      catch (RemoteException localRemoteException)
      {
        i("getOAID error, RemoteException!");
        localRemoteException.printStackTrace();
      }
      return null;
    }
    i("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(T paramT, m paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.m
 * JD-Core Version:    0.7.0.1
 */