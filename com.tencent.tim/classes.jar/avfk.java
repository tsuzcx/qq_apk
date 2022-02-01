import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;

public class avfk
  implements OnPluginInstallListener
{
  public avfk(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallBegin, pluginId:" + paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallDownloadProgress, pluginId:" + paramString + " offset:" + paramInt1 + " total: " + paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    QQToast.a(this.this$0.getApplicationContext(), 2131697008, 0).show();
    HcePluginInstallActivity.a(this.this$0, false);
    this.this$0.finish();
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallFinish, pluginId:" + paramString);
    }
    if (HcePluginInstallActivity.a(this.this$0).isPlugininstalled("vfc_plugin.apk"))
    {
      HcePluginInstallActivity.a(this.this$0);
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 2131697008, 0).show();
    HcePluginInstallActivity.a(this.this$0, false);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfk
 * JD-Core Version:    0.7.0.1
 */