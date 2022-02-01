import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import org.json.JSONException;
import org.json.JSONObject;

public class nvl
  implements RIJRedPacketManager.f
{
  public nvl(BridgeModule paramBridgeModule, String paramString) {}
  
  public void lJ(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    int i;
    if (paramBoolean) {
      i = 1;
    }
    try
    {
      for (;;)
      {
        localJSONObject.put("result", i);
        this.this$0.invokeCallJS(this.val$callbackId, localJSONObject);
        return;
        i = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvl
 * JD-Core Version:    0.7.0.1
 */