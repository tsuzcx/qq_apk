import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akem
  implements View.OnClickListener
{
  akem(akef paramakef) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://buluo.qq.com/mobile/xxq_setting.html?_wv=1027&uin=" + this.this$0.a.app.getCurrentUin());
    localIntent.putExtra("reqType", 1);
    this.this$0.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akem
 * JD-Core Version:    0.7.0.1
 */