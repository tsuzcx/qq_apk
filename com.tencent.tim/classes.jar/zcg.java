import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zcg
  implements View.OnClickListener
{
  zcg(zce paramzce) {}
  
  public void onClick(View paramView)
  {
    achg localachg = (achg)this.a.mApp.getManager(159);
    Intent localIntent = new Intent(zce.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", localachg.box);
    zce.b(this.a).startActivity(localIntent);
    anot.a(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcg
 * JD-Core Version:    0.7.0.1
 */