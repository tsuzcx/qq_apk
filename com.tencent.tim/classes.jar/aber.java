import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aber
  implements View.OnClickListener
{
  aber(abep paramabep, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.b.mContext, QQBrowserActivity.class).putExtra("url", String.format("https://buluo.qq.com/mobile/detail.html?bid=%s&pid=%s&_wv=1027&webview=1&from=reliao", new Object[] { this.val$bid, this.bfv }));
    this.b.mContext.startActivity(localIntent);
    anot.a(null, "dc00899", "grp_lbs", "", "hot_room", "clk_tribe_post", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aber
 * JD-Core Version:    0.7.0.1
 */