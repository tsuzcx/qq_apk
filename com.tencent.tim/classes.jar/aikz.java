import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aikz
  implements View.OnClickListener
{
  public aikz(UiApiPlugin paramUiApiPlugin, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.this$0.e(this.val$activity, this.bOO, this.bOP);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikz
 * JD-Core Version:    0.7.0.1
 */