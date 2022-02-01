import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class nvc
  implements ntp.c
{
  public nvc(BridgeModule paramBridgeModule, String paramString) {}
  
  public void aSu()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", false);
      this.this$0.invokeCallJS(this.val$callbackId, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(BridgeModule.TAG, 2, "canOpenPage error" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvc
 * JD-Core Version:    0.7.0.1
 */