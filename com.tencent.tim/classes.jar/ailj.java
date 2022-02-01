import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ailj
  implements IMiniMsgUnreadCallback
{
  public ailj(UiApiPlugin paramUiApiPlugin) {}
  
  public void destroy() {}
  
  public void hide() {}
  
  public void hideUnread()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("unReadHide", true);
      this.this$0.o("UnRead", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public boolean show(int paramInt)
  {
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    try
    {
      paramBundle = new JSONObject();
      this.this$0.o("backFromMiniAIO", paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.d("UiApiPlugin", 1, paramBundle, new Object[0]);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("unReadC", paramInt);
      localJSONObject.put("unReadHide", paramBoolean);
      this.this$0.o("updateUnreadCount", localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "mini_msg uiApiPlugin undateUnreadCount = " + paramInt);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailj
 * JD-Core Version:    0.7.0.1
 */