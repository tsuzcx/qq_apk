import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class aiow
  extends QIPCModule
{
  private volatile boolean hk;
  private ArrayList<aiow.b> xr = new ArrayList();
  
  private aiow()
  {
    super("ListenTogetherIPCModuleWebClient");
  }
  
  public static aiow a()
  {
    return aiow.a.b();
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", paramString, localBundle, paramEIPCResultCallback);
  }
  
  public static void br(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", "action_status_changed", localBundle, null);
  }
  
  private EIPCResult f(String arg1, Bundle paramBundle, int paramInt)
  {
    if ((!"action_status_changed".equals(???)) || (paramBundle == null)) {}
    for (;;)
    {
      return null;
      paramBundle = paramBundle.getString("data");
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "statusChanged action:" + ??? + " data=" + paramBundle);
        }
        if (paramBundle != null) {
          synchronized (this.xr)
          {
            Iterator localIterator = this.xr.iterator();
            while (localIterator.hasNext())
            {
              aiow.b localb = (aiow.b)localIterator.next();
              if (localb != null) {
                localb.bp(paramBundle);
              }
            }
          }
        }
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          QLog.i("ListenTogetherIPCModuleWebClient", 1, "statusChanged error:" + paramBundle.getMessage());
          paramBundle = null;
        }
        ??? = new EIPCResult();
        ???.code = 0;
      }
    }
    return ???;
  }
  
  public void a(aiow.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "register callback:" + paramb);
    }
    if (this.xr.contains(paramb)) {}
    for (;;)
    {
      return;
      if (this.xr.isEmpty()) {
        ??? = a();
      }
      try
      {
        QIPCClientHelper.getInstance().register((QIPCModule)???);
        this.hk = true;
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "register real");
        }
      }
      catch (Exception localException)
      {
        synchronized (this.xr)
        {
          this.xr.add(paramb);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "register mListenTogetherClient2WebCallbacks.size:" + this.xr.size());
          return;
          localException = localException;
          QLog.e("ListenTogetherIPCModuleWebClient", 1, "register ipc module error.", localException);
        }
      }
    }
  }
  
  public void b(aiow.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister callback:" + paramb + " mHasRegistered:" + this.hk);
    }
    if (this.xr.contains(paramb)) {}
    synchronized (this.xr)
    {
      this.xr.remove(paramb);
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister mListenTogetherClient2WebCallbacks.size:" + this.xr.size());
      }
      if ((!this.xr.isEmpty()) || (!this.hk)) {}
    }
    try
    {
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        this.hk = false;
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister real");
        }
      }
      return;
    }
    catch (Exception paramb)
    {
      QLog.e("ListenTogetherIPCModuleWebClient", 1, "unregister ipc module error.", paramb);
    }
    paramb = finally;
    throw paramb;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if (paramBundle == null) {
      QLog.i("ListenTogetherIPCModuleWebClient", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
    }
    while (!"action_status_changed".equals(paramString)) {
      return null;
    }
    return f(paramString, paramBundle, paramInt);
  }
  
  static class a
  {
    private static aiow a = new aiow(null);
  }
  
  public static abstract interface b
  {
    public abstract void bp(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiow
 * JD-Core Version:    0.7.0.1
 */