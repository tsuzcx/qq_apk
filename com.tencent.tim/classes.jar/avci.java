import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;

public class avci
  implements OnPluginInstallListener
{
  public avci(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {}
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    QQToast.a(this.this$0.getApplicationContext(), 2131697008, 0);
    BuscardPluginInstallActivity.a(this.this$0, false);
    this.this$0.finish();
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    long l = System.currentTimeMillis();
    BuscardPluginInstallActivity.a(this.this$0).append(" ==step8: onInstallFinish, cost=" + (l - this.this$0.azs));
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "onInstallFinish, pluginId:" + paramString);
    }
    boolean bool = BuscardPluginInstallActivity.a(this.this$0).isPlugininstalled("BuscardPlugin.apk");
    BuscardPluginInstallActivity.a(this.this$0).append(" ==step9: onInstallFinish, isPlugininstalled cost=" + (System.currentTimeMillis() - l));
    if (bool)
    {
      BuscardPluginInstallActivity.a(this.this$0);
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 2131697008, 0);
    BuscardPluginInstallActivity.a(this.this$0, false);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avci
 * JD-Core Version:    0.7.0.1
 */