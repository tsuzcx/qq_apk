import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abaa
  implements View.OnClickListener
{
  public abaa(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, QQBrowserActivity.class).putExtra("url", ShortVideoPlayActivity.a(this.this$0));
    this.this$0.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abaa
 * JD-Core Version:    0.7.0.1
 */