import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class afqp
  implements DialogInterface.OnClickListener
{
  afqp(afqm paramafqm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$0.mContext.getString(2131720669);
    aqrf.a(null, this.this$0.mContext, "mvip.g.a.bq_tz", 3, "1450000515", "CJCLUBT", paramDialogInterface, "", false, true);
    if (this.this$0.mBaseChatPie != null)
    {
      if (EmojiStickerManager.a().mCurType != 0) {
        break label103;
      }
      paramInt = 1;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.this$0.mBaseChatPie.app.getCurrentUin(), "Stick", "ClickSVIPTip", String.valueOf(paramInt), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
      label103:
      if (EmojiStickerManager.a().mCurType == 1) {
        paramInt = 2;
      } else if (EmojiStickerManager.a().mCurType == 3000) {
        paramInt = 3;
      } else {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqp
 * JD-Core Version:    0.7.0.1
 */