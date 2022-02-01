import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xpl
  implements View.OnClickListener
{
  xpl(xpk paramxpk, AppGuideTipsConfig paramAppGuideTipsConfig) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.b.tipsUrl);
    this.a.mContext.startActivity(localIntent);
    anot.a(null, "dc00898", "", "", this.b.opkey, this.b.opkey, 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpl
 * JD-Core Version:    0.7.0.1
 */