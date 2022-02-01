import android.content.Context;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class avma
  extends OnPluginInstallListener.Stub
{
  private int exu;
  
  avma(avlz paramavlz) {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    avoc.i("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if ((this.exu == 0) || (paramInt1 - this.exu > paramInt2 / 101))
    {
      avoc.d("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.exu = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    avoc.e("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    avlz.X((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    avoc.u("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    avlz.X((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((avlz.a(this.b) != null) && (((WeakReference)avlz.a(this.b).first).get() != null))
    {
      avlz.a(this.b, (Context)((WeakReference)avlz.a(this.b).first).get(), ((Integer)avlz.a(this.b).second).intValue());
      avlz.a(this.b, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avma
 * JD-Core Version:    0.7.0.1
 */