import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public final class xjo
  implements DialogInterface.OnClickListener
{
  public xjo(Emoticon paramEmoticon, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool;
    if (this.a.jobType == 4)
    {
      bool = true;
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.val$context, this.val$app.getAccount(), 8, this.a.epId, false, bool);
      if (MarketFaceItemBuilder.o != null)
      {
        if (7 != this.aLU) {
          break label80;
        }
        MarketFaceItemBuilder.a(this.val$app, MarketFaceItemBuilder.o.frienduin, "ep_mall", "Clk_pkg_forward", 0);
      }
    }
    label80:
    while (6 != this.aLU)
    {
      return;
      bool = false;
      break;
    }
    MarketFaceItemBuilder.a(this.val$app, MarketFaceItemBuilder.o.frienduin, "ep_mall", "Clk_collect_more", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjo
 * JD-Core Version:    0.7.0.1
 */