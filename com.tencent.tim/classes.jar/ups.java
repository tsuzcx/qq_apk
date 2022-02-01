import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ups
  implements View.OnClickListener
{
  public ups(ChatSettingForTroop paramChatSettingForTroop, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$dialog != null) && (this.val$dialog.isShowing()) && (this.val$dialog.getWindow() != null)) {
      this.val$dialog.dismiss();
    }
    ChatSettingForTroop.h(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ups
 * JD-Core Version:    0.7.0.1
 */