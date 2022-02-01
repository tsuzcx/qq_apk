import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import cooperation.comic.utils.QQComicRedTouchManager.PluginRedTouchObserver.1;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aved
  extends Observable
  implements Manager
{
  AppInterface mApp;
  BroadcastReceiver mReceiver;
  
  public aved(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.mReceiver = new avee(this);
    this.mApp.getApplication().registerReceiver(this.mReceiver, new IntentFilter("com.tencent.redpoint.broadcast.push.av"));
  }
  
  public void ZK(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "reportRedTouchClick", localBundle);
  }
  
  public Map<String, RedAppInfo> b(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {}
    do
    {
      do
      {
        return null;
        localObject = new Bundle();
        ((Bundle)localObject).putStringArrayList("pathList", paramArrayList);
        paramArrayList = QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "getRedTouchInfo", (Bundle)localObject);
      } while ((paramArrayList == null) || (paramArrayList.code != 0) || (paramArrayList.data == null));
      paramArrayList = paramArrayList.data;
      paramArrayList.setClassLoader(RedAppInfo.class.getClassLoader());
      localObject = paramArrayList.getParcelableArrayList("redTouchInfoList");
    } while (localObject == null);
    paramArrayList = new HashMap();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RedAppInfo localRedAppInfo = (RedAppInfo)((Iterator)localObject).next();
      paramArrayList.put(localRedAppInfo.getPath(), localRedAppInfo);
    }
    return paramArrayList;
  }
  
  public boolean nr(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("appId", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "isLebaItemOpen", (Bundle)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EIPCResult)localObject).code == 0)
      {
        bool1 = bool2;
        if (((EIPCResult)localObject).data != null) {
          bool1 = ((EIPCResult)localObject).data.getBoolean("isLebaItemOpen", false);
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    super.deleteObservers();
    try
    {
      this.mApp.getApplication().unregisterReceiver(this.mReceiver);
      this.mApp = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static abstract class a
    implements Observer
  {
    public abstract void ezF();
    
    public final void update(Observable paramObservable, Object paramObject)
    {
      ThreadManager.getUIHandler().post(new QQComicRedTouchManager.PluginRedTouchObserver.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aved
 * JD-Core Version:    0.7.0.1
 */