import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yix
  implements View.OnClickListener
{
  yix(yiw paramyiw) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(yiw.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", yiw.a(this.a));
    yiw.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yix
 * JD-Core Version:    0.7.0.1
 */