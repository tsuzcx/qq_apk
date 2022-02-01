import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import mqq.os.MqqHandler;

final class afnv
  implements ajdq<EmoticonPackage>
{
  afnv(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, int paramInt, Activity paramActivity) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (this.a.cZ != 1008) && (this.a.cZ != 1000) && (this.a.cZ != 1001) && (this.a.cZ != 10002) && (this.a.cZ != 10004) && (this.a.cZ != 1002) && (this.a.cZ != 1003) && (this.a.cZ != 1004) && (this.a.cZ != 1005) && (this.a.cZ != 1006))
    {
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
      if (paramEmoticonPackage != null) {
        paramEmoticonPackage.obtainMessage(22, String.valueOf(this.cSG)).sendToTarget();
      }
      anot.a(this.val$app, "CliOper", "", "", "ep_mall", "0X8006FFE", 0, 0, String.valueOf(this.cSG), String.valueOf(this.cSG), "", "");
      return;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage(this.val$context, this.val$app.getAccount(), 8, String.valueOf(this.cSG), false, true);
    anot.a(this.val$app, "CliOper", "", "", "ep_mall", "0X8006FFF", 0, 0, String.valueOf(this.cSG), String.valueOf(this.cSG), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnv
 * JD-Core Version:    0.7.0.1
 */