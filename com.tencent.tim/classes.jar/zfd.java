import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

public class zfd
  implements View.OnClickListener
{
  public zfd(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.bqZ)
    {
      if (!VersionUtils.isHoneycomb()) {
        break label40;
      }
      this.this$0.startActivity(new Intent("android.settings.SETTINGS"));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label40:
      this.this$0.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfd
 * JD-Core Version:    0.7.0.1
 */