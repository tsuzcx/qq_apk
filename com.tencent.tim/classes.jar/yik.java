import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yik
  implements View.OnClickListener
{
  yik(yij paramyij) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(yij.a(this.this$0), QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { yij.a(this.this$0).getAccount(), yij.a(this.this$0), Integer.valueOf(ahvn.hT(yij.a(this.this$0).cZ)), yij.a(this.this$0).aTl }));
    yij.a(this.this$0).startActivity(localIntent);
    arts.a().a(yij.a(this.this$0).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yik
 * JD-Core Version:    0.7.0.1
 */