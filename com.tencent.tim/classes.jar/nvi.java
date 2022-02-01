import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.startup.step.CheckPermission.a;
import org.json.JSONObject;

public class nvi
  implements CheckPermission.a
{
  public nvi(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString) {}
  
  public void bK()
  {
    this.this$0.saveImagePermission(this.val$json, this.val$callbackId);
  }
  
  public void reject()
  {
    this.this$0.invokeErrorCallJS(this.val$callbackId, "saveImage reject Permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvi
 * JD-Core Version:    0.7.0.1
 */