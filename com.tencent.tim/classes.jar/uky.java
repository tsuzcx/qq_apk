import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public final class uky
  implements ChatActivityUtils.b
{
  public uky(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void bD(int paramInt1, int paramInt2)
  {
    AudioHelper.rw("发起音视频_获取会议id_rsp");
    Bundle localBundle2 = this.Z;
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putInt("ConfAppID", paramInt1);
    localBundle1.putInt("MeetingConfID", paramInt2);
    ChatActivityUtils.c(this.val$app, this.val$context, this.alR, this.val$uin, localBundle1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uky
 * JD-Core Version:    0.7.0.1
 */