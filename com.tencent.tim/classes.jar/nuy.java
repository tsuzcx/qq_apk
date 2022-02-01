import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.WebSsoBody.WebSsoControlData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class nuy
  implements BusinessObserver
{
  public nuy(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = paramBundle.getByteArray("data");
      if (localObject == null) {
        return;
      }
      paramBundle = new WebSsoBody.WebSsoResponseBody();
      paramBundle.mergeFrom((byte[])localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("data", paramBundle.data.get());
      ((JSONObject)localObject).put("retcode", paramBundle.ret.get());
      ((JSONObject)localObject).put("cret", 0);
      this.this$0.invokeCallJS(this.val$callback, localObject);
      if (((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).frequency.has()) {
        BridgeModule.access$202(this.this$0, ((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).frequency.get());
      }
      if (!((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).packageSize.has()) {
        return;
      }
      BridgeModule.access$302(this.this$0, ((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).packageSize.get());
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("cret", 2);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    paramBundle = new JSONObject();
    paramBundle.put("cret", 1);
    this.this$0.invokeCallJS(this.val$callback, paramBundle);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nuy
 * JD-Core Version:    0.7.0.1
 */