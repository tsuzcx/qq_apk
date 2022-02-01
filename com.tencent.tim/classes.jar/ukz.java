import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ukz
  implements aqjl.a
{
  public ukz(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
  {
    this.Z.putInt("MeetingStasks", paramInt);
    ChatActivityUtils.c(this.val$app, this.val$context, this.alR, this.val$uin, this.Z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ukz
 * JD-Core Version:    0.7.0.1
 */