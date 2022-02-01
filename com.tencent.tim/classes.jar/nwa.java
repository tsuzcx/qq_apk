import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.a;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

public class nwa
  implements ViolaFragment.a
{
  public nwa(BridgeModule paramBridgeModule, String paramString) {}
  
  public void mT(int paramInt)
  {
    if ((BridgeModule.access$000(this.this$0) != paramInt) && (this.this$0.getViolaInstance() != null)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((paramInt == CommonSuspensionGestureLayout.bct) || (paramInt == CommonSuspensionGestureLayout.bcv)) {
          localJSONObject.put("state", 1);
        }
        for (;;)
        {
          BridgeModule.access$002(this.this$0, paramInt);
          ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), this.this$0.getModuleName(), "callback", this.val$callbackid, localJSONObject, true);
          return;
          localJSONObject.put("state", 0);
        }
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwa
 * JD-Core Version:    0.7.0.1
 */