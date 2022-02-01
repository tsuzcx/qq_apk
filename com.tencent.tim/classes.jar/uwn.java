import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class uwn
  implements View.OnClickListener
{
  public uwn(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.aVT) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (afgc.bk(this.this$0))
      {
        this.this$0.aVT = true;
        EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.this$0.mActivity.get(), this.this$0.app.getAccount(), 2);
        anot.a(this.this$0.app, "CliOper", "", "", "EmosSetting", "ForwardEmojiHome", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwn
 * JD-Core Version:    0.7.0.1
 */