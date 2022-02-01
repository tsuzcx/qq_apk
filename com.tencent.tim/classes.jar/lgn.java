import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.a;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

class lgn
  implements BridgeModule.a
{
  lgn(lgm paramlgm, int paramInt, kqd paramkqd) {}
  
  public void j(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("arg_callback", paramString);
      paramString = new Bundle();
      paramString.putString("action_update_biu_and_comment_request_string", paramJSONObject.toString());
      paramString = EIPCResult.createResult(0, paramString);
      this.jdField_b_of_type_Lgm.callbackResult(this.val$callbackId, paramString);
      this.jdField_b_of_type_Kqd.clear();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgn
 * JD-Core Version:    0.7.0.1
 */