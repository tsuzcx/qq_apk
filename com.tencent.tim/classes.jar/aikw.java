import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aikw
  implements View.OnClickListener
{
  public aikw(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.val$callback)) {
      this.this$0.callJs(this.val$callback, new String[] { "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikw
 * JD-Core Version:    0.7.0.1
 */