import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.biz.huanjiplugin.TranslucentActivty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;

class jrx
  implements OnPluginInstallListener
{
  jrx(jrw paramjrw) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (this.b.a != null)
    {
      float f = paramInt1 / paramInt2;
      this.b.a.K(0, 1, (int)(f * 100.0F));
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (this.b.a != null) {
      this.b.a.onError(paramInt, "Install Error");
    }
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (this.b.a != null) {
      this.b.a.K(3, 4, 100);
    }
    if (this.b.mAction == 2)
    {
      paramString = new Intent(BaseApplicationImpl.getApplication().getApplicationContext(), TranslucentActivty.class);
      paramString.addFlags(268435456);
      paramString.putExtras(paramString);
      paramString.putExtra("startParam", this.b.Uh);
      BaseApplicationImpl.getApplication().getApplicationContext().startActivity(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrx
 * JD-Core Version:    0.7.0.1
 */