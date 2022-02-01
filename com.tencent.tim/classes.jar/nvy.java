import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.g;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nvy
  implements RIJRedPacketManager.g
{
  public nvy(BridgeModule paramBridgeModule, String paramString) {}
  
  public void showToast(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", paramString);
      this.this$0.invokeCallJS(this.val$callbackId, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e(BridgeModule.TAG, 1, "onClickBubbleTips error: " + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvy
 * JD-Core Version:    0.7.0.1
 */