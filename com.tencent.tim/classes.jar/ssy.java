import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ssy
  implements View.OnClickListener
{
  ssy(ssx paramssx, String paramString, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.callJs(this.val$callback, new String[] { "" });
    if ((this.val$activity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.val$activity).getAppInterface();
      if ((localAppInterface instanceof NearbyAppInterface)) {
        ((NearbyAppInterface)localAppInterface).reportClickEvent("dc00899", "grp_lbs", "", "hot_create", "clk_create", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssy
 * JD-Core Version:    0.7.0.1
 */