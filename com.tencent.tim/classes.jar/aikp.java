import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.a;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import org.json.JSONObject;

public class aikp
  implements BridgeModule.a
{
  public aikp(UiApiPlugin paramUiApiPlugin) {}
  
  public void j(String paramString, JSONObject paramJSONObject)
  {
    this.this$0.callJs(paramString, new String[] { paramJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikp
 * JD-Core Version:    0.7.0.1
 */