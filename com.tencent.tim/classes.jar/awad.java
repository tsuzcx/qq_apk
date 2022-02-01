import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QZoneShareActivity.4.1;
import cooperation.qzone.share.QZoneShareActivity.4.2;
import eipc.EIPCClient;
import java.util.Map;
import org.json.JSONObject;

public class awad
  implements MiniAppCmdInterface
{
  public awad(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      QZoneShareActivity.a(this.this$0, paramJSONObject.optBoolean("needShareCallBack"));
      if ((QZoneShareActivity.a(this.this$0) != null) && (QZoneShareActivity.a(this.this$0).xcxMapEx != null)) {
        QZoneShareActivity.a(this.this$0).xcxMapEx.put("xcxFakeLink", str);
      }
      if (!QZoneShareActivity.a(this.this$0)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      QZoneShareActivity.c(this.this$0);
      this.this$0.runOnUiThread(new QZoneShareActivity.4.1(this));
      return;
    }
    long l = -1L;
    if (paramJSONObject != null)
    {
      QZoneShareActivity.a(this.this$0, paramJSONObject.optBoolean("needShareCallBack"));
      l = paramJSONObject.optLong("retCode");
    }
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = null)
    {
      if (!QZoneShareActivity.a(this.this$0)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      this.this$0.runOnUiThread(new QZoneShareActivity.4.2(this, l, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awad
 * JD-Core Version:    0.7.0.1
 */