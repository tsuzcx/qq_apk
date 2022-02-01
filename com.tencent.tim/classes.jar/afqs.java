import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afqs
  implements View.OnClickListener
{
  public afqs(SystemAndEmojiEmoticonPanelWithActionBar paramSystemAndEmojiEmoticonPanelWithActionBar) {}
  
  public void onClick(View paramView)
  {
    if (this.b.g != null) {
      this.b.g.send();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqs
 * JD-Core Version:    0.7.0.1
 */