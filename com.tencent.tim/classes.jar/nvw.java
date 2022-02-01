import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class nvw
  implements View.OnClickListener
{
  public nvw(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.this$0.invokeCallJS(this.val$callBackId, new JSONObject());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvw
 * JD-Core Version:    0.7.0.1
 */