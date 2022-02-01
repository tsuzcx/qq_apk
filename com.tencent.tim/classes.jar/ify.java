import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

public class ify
  extends QIPCModule
{
  private ify()
  {
    super("AioShareMusicIPCMainClient");
  }
  
  public static ify a()
  {
    return ify.a.b();
  }
  
  private void ae(Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localQQAppInterface != null) {}
    try
    {
      ((ListenTogetherManager)localQQAppInterface.getManager(331)).bn(new JSONObject(paramBundle.getString("data")));
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void af(Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localQQAppInterface != null) {}
    try
    {
      ((ListenTogetherManager)localQQAppInterface.getManager(331)).bm(new JSONObject(paramBundle.getString("data")));
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public static void c(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusic.AioShareMusicIPCMainClient", 2, "callWebClient data:" + paramJSONObject.toString() + "  isToolRunning:" + bool);
    }
    if (bool)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", paramJSONObject.toString());
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "AioShareMusicIPCWebClient", paramString, localBundle, null);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("checkAioShareMusic".equals(paramString)) {
      af(paramBundle);
    }
    for (;;)
    {
      return null;
      if ("startListenAioShareMusic".equals(paramString)) {
        ae(paramBundle);
      }
    }
  }
  
  static class a
  {
    private static ify a = new ify(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ify
 * JD-Core Version:    0.7.0.1
 */