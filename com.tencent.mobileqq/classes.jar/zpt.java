import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.kingkong.UpdateManager;
import org.json.JSONObject;

public class zpt
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    try
    {
      String str = paramMessage.getString("PATCH_JSON_STRING");
      boolean bool = paramMessage.getBoolean("PATCH_FORCE_UPDATE");
      paramMessage = zps.a(new JSONObject(str));
      if (paramMessage != null) {
        UpdateManager.a(paramMessage, bool);
      }
      return;
    }
    catch (Exception paramMessage)
    {
      zph.a("KingKongUpdateManager", "Update patch exception : " + paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zpt
 * JD-Core Version:    0.7.0.1
 */