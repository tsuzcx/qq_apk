import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akhu
  implements View.OnClickListener
{
  akhu(akht paramakht) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(akht.a(this.b), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-topic/topicTags.html");
    akht.a(this.b).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhu
 * JD-Core Version:    0.7.0.1
 */