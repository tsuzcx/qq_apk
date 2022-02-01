import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class iga
  extends QIPCModule
{
  private iga.a a;
  
  private iga()
  {
    super("AioShareMusicIPCWebClient");
  }
  
  public static iga a()
  {
    return iga.b.b();
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("AioShareMusicIPCMainClient", paramString, localBundle, paramEIPCResultCallback);
  }
  
  public void a(iga.a parama)
  {
    if (this.a != null) {}
    for (;;)
    {
      return;
      try
      {
        iga localiga = a();
        this.a = parama;
        QIPCClientHelper.getInstance().register(localiga);
        if (QLog.isColorLevel())
        {
          QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "register real");
          return;
        }
      }
      catch (Exception parama)
      {
        QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "register ipc module error.", parama);
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    try
    {
      paramBundle = new JSONObject(paramBundle.getString("data"));
      if (this.a != null) {
        this.a.f(paramString, paramBundle);
      }
      return null;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void unregister()
  {
    try
    {
      this.a = null;
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        if (QLog.isColorLevel()) {
          QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "unregister real");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "unregister ipc module error.", localException);
    }
  }
  
  public static abstract interface a
  {
    public abstract void f(String paramString, JSONObject paramJSONObject);
  }
  
  static class b
  {
    private static iga a = new iga(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iga
 * JD-Core Version:    0.7.0.1
 */