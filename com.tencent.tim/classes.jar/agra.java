import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agra
  implements View.OnClickListener
{
  agra(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$activity instanceof BasePluginActivity)) {
      ahav.F(((BasePluginActivity)this.val$activity).getOutActivity(), this.bIW);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ahav.F(this.val$activity, this.bIW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agra
 * JD-Core Version:    0.7.0.1
 */