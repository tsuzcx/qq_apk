import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;

public class zeo
  extends ahct
{
  public zeo(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void fk(View paramView)
  {
    if (paramView.getId() == 2131366542) {
      ChatHistoryBaseTenDocFragment.a(this.this$0);
    }
    while ((paramView.getTag() instanceof String)) {
      return;
    }
    TencentDocItem localTencentDocItem = ((zem.a)paramView.getTag()).a;
    if (this.this$0.aTT)
    {
      this.this$0.a.aL(localTencentDocItem);
      ChatHistoryBaseTenDocFragment.a(this.this$0).notifyDataSetChanged();
      return;
    }
    paramView = "unknown";
    if (agmy.mu(localTencentDocItem.mUrl)) {
      paramView = "doc";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", localTencentDocItem.mUrl);
      localBundle.putString("tdsourcetag", "s_qq_history_tab");
      localBundle.putString("tdsourcetype", paramView + ChatHistoryBaseTenDocFragment.a(this.this$0));
      TeamWorkDocEditBrowserActivity.a(ChatHistoryBaseTenDocFragment.a(this.this$0), localBundle, false);
      anot.a(this.this$0.mApp, "dc00898", "", "", "0X800A16B", "0X800A16B", ChatHistoryBaseTenDocFragment.a(this.this$0), 0, "", "", "s_qq_history_tab", paramView);
      return;
      if (agmy.mx(localTencentDocItem.mUrl)) {
        paramView = "form";
      } else if (agmy.mw(localTencentDocItem.mUrl)) {
        paramView = "ppt";
      } else if (agmy.mv(localTencentDocItem.mUrl)) {
        paramView = "sheet";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zeo
 * JD-Core Version:    0.7.0.1
 */