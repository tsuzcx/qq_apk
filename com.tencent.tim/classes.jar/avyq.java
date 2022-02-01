import android.os.Binder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import java.lang.ref.WeakReference;

public class avyq
  extends avyr.a
{
  private static String TAG = "QZoneRemotePluginHandler";
  private static avyq a;
  private avxl c;
  private WeakReference<QQAppInterface> jg;
  
  public static avyq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avyq();
      }
      return a;
    }
    finally {}
  }
  
  private void eCy()
  {
    Object localObject = null;
    if (this.jg != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jg.get();
      localObject = localQQAppInterface;
      if (localQQAppInterface != null)
      {
        this.c = ((avxl)localQQAppInterface.getManager(175));
        localObject = localQQAppInterface;
      }
    }
    QLog.i(TAG, 1, "appInterface:" + localObject + ",pluginManger=" + this.c);
  }
  
  public Binder a()
  {
    return this;
  }
  
  public PluginRecord a(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "queryPlugin:" + paramString);
    }
    eCy();
    if (this.c == null) {
      return null;
    }
    return this.c.a(paramString);
  }
  
  public void a(avxq paramavxq, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "installPituSo");
    }
    eCy();
    if (this.c == null) {
      return;
    }
    this.c.a(paramavxq, paramInt);
  }
  
  public boolean a(String paramString, avxr paramavxr, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "installPlugin:" + paramString);
    }
    eCy();
    if (this.c == null) {
      return false;
    }
    return this.c.a(paramString, paramavxr, paramInt);
  }
  
  public void eCv()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "triggerQQDownloadPtuFilter");
    }
    eCy();
    if (this.c == null) {
      return;
    }
    this.c.eCv();
  }
  
  @Nullable
  public QQAppInterface getAppInterface()
  {
    if (this.jg == null) {
      return null;
    }
    return (QQAppInterface)this.jg.get();
  }
  
  public boolean isPluginInstalled(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isPluginInstalled:" + paramString);
    }
    eCy();
    if (this.c != null) {
      return this.c.isPluginInstalled(paramString);
    }
    return false;
  }
  
  public boolean isReady()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isReady");
    }
    eCy();
    if (this.c == null) {
      return false;
    }
    return this.c.isReady();
  }
  
  public void setAppInterface(QQAppInterface paramQQAppInterface)
  {
    this.jg = new WeakReference(paramQQAppInterface);
  }
  
  public boolean tB(String paramString)
    throws RemoteException
  {
    eCy();
    if (this.c == null) {
      return false;
    }
    return this.c.tB(paramString);
  }
  
  public boolean tr(String paramString)
    throws RemoteException
  {
    eCy();
    if (this.c == null) {
      return false;
    }
    return this.c.tr(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyq
 * JD-Core Version:    0.7.0.1
 */