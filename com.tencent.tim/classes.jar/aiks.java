import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.a;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import org.json.JSONObject;

public class aiks
  implements BridgeModule.a
{
  public aiks(UiApiPlugin paramUiApiPlugin) {}
  
  public void j(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {
      this.this$0.callJs(paramString, new String[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiks
 * JD-Core Version:    0.7.0.1
 */