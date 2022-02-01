import android.content.Intent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.b;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class ahvx
  implements EmojiStickerManager.b
{
  ahvx(ahvw paramahvw) {}
  
  public void gt(View paramView)
  {
    String str = aqqj.getUrl("aioEmojiStickerDetail");
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent != null)
    {
      localViewParent = localViewParent.getParent();
      if ((localViewParent instanceof ChatXListView)) {
        EmojiStickerManager.cRE = ((ChatXListView)localViewParent).getPositionForView(paramView);
      }
    }
    paramView = new Intent(this.this$0.app.getApp(), QQBrowserActivity.class);
    paramView.setFlags(268435456);
    paramView.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.app.getApp(), str, -1L, paramView, false, -1);
    int i;
    if (EmojiStickerManager.a().mCurType == 0) {
      i = 1;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentUin(), "Stick", "ClickDetail", String.valueOf(i), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
      if (EmojiStickerManager.a().mCurType == 1) {
        i = 2;
      } else if (EmojiStickerManager.a().mCurType == 3000) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvx
 * JD-Core Version:    0.7.0.1
 */