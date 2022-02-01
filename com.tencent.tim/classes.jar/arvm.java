import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.applist.QZoneAppListActivity.1.1;

public class arvm
  extends OnPluginInstallListener.Stub
{
  public arvm(QZoneAppListActivity paramQZoneAppListActivity) {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    this.this$0.updateProgress(paramInt1 / paramInt2 * 100);
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    this.this$0.runOnUiThread(new QZoneAppListActivity.1.1(this));
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    QZoneAppListActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvm
 * JD-Core Version:    0.7.0.1
 */