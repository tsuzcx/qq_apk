import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afln
  implements View.OnClickListener
{
  afln(aflm paramaflm, afns paramafns) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    label84:
    String str1;
    label110:
    int i;
    if (this.a.bZQ)
    {
      ((Intent)localObject).putExtra("emoji_to_dressup", true);
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.this$0.mContext, this.this$0.app.getAccount(), 8, String.valueOf(this.this$0.d.epId), false, (Intent)localObject, false);
      if (this.this$0.app != null) {
        break label257;
      }
      localObject = "";
      String str2 = this.this$0.d.epId;
      if (!this.a.bZQ) {
        break label272;
      }
      str1 = "1";
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X8007192", null, 1, 0, 0, null, str2, str1);
      if ((this.this$0.d.extraFlags & 0x1) <= 0) {
        break label279;
      }
      i = 3;
    }
    for (;;)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.this$0.d.epId, i + "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.this$0.d.extraFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((Intent)localObject).putExtra("emoji_is_original", bool);
        ((Intent)localObject).putExtra("emoji_author_id", this.a.cSF);
        break;
      }
      label257:
      localObject = this.this$0.app.getCurrentAccountUin();
      break label84;
      label272:
      str1 = "2";
      break label110;
      label279:
      if (this.this$0.d.subType == 4) {
        i = 4;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afln
 * JD-Core Version:    0.7.0.1
 */