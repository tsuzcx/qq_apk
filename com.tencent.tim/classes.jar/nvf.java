import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class nvf
  implements View.OnClickListener
{
  public nvf(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("timestamp", System.currentTimeMillis());
      this.this$0.invokeCallJS(this.val$callbackId, localJSONObject);
      label30:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvf
 * JD-Core Version:    0.7.0.1
 */