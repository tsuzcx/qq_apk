import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class aikx
  implements View.OnClickListener
{
  public aikx(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bj(this.val$params);
    String str = this.val$params.optString("callback");
    if (!TextUtils.isEmpty(str)) {
      this.this$0.callJs(str, new String[] { String.valueOf(0) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikx
 * JD-Core Version:    0.7.0.1
 */