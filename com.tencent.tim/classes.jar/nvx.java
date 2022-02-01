import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.a;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nvx
  implements RIJRedPacketManager.a
{
  public nvx(BridgeModule paramBridgeModule, String paramString) {}
  
  public void e(boolean paramBoolean, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("wording", paramString);
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        localJSONObject.put("shouldShow", i);
        localJSONObject.put("status", paramInt);
      }
      catch (JSONException paramString)
      {
        int i;
        QLog.e(BridgeModule.TAG, 1, "requestBubbleTipsWording error: " + paramString.toString());
        continue;
      }
      this.this$0.invokeCallJS(this.val$callbackId, localJSONObject);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvx
 * JD-Core Version:    0.7.0.1
 */