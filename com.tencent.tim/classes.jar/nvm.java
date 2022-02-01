import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nvm
  implements mmr.a
{
  public nvm(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString) {}
  
  public void ay(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = this.aH;
      if (paramInt == 0) {}
      for (paramInt = 0;; paramInt = -1)
      {
        localJSONObject.put("errCode", paramInt);
        this.aH.put("errMsg", paramString);
        this.this$0.invokeJS(this.val$callback, this.aH);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      this.this$0.invokeJS(this.val$callback, this.aH);
      QLog.e(BridgeModule.TAG, 1, "oidb_0xe2a error! e = " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvm
 * JD-Core Version:    0.7.0.1
 */