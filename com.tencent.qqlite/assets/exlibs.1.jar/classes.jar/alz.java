import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class alz
  implements View.OnClickListener
{
  public alz(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onClick(View paramView)
  {
    EmosmDetailActivity.a(this.a.app, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Ep_pkg_detail", 0);
    EmojiHomeUiPlugin.openEmojiDetailPage(this.a, this.a.app.getAccount(), 8, this.a.a.a.epId, this.a.app.getSid(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alz
 * JD-Core Version:    0.7.0.1
 */