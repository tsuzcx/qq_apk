import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import mqq.os.MqqHandler;

class xkn
  implements ajdq<EmoticonPackage>
{
  xkn(xkl paramxkl, String paramString) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (this.this$0.sessionInfo.cZ != 1008) && (this.this$0.sessionInfo.cZ != 1000) && (this.this$0.sessionInfo.cZ != 10004) && (this.this$0.sessionInfo.cZ != 1001) && (this.this$0.sessionInfo.cZ != 1002) && (this.this$0.sessionInfo.cZ != 1003) && (this.this$0.sessionInfo.cZ != 1004) && (this.this$0.sessionInfo.cZ != 1005) && (this.this$0.sessionInfo.cZ != 1006))
    {
      paramEmoticonPackage = this.this$0.app.getHandler(ChatActivity.class);
      if (paramEmoticonPackage != null) {
        paramEmoticonPackage.obtainMessage(22, this.aMY).sendToTarget();
      }
      return;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.this$0.mContext, this.this$0.app.getAccount(), 8, this.aMY, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkn
 * JD-Core Version:    0.7.0.1
 */