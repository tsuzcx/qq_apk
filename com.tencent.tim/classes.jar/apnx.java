import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apnx
  implements View.OnClickListener
{
  apnx(apnw paramapnw) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(apnw.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    apnw.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnx
 * JD-Core Version:    0.7.0.1
 */