import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.servlet.ReduFriendObserver;

public class vss
  extends ReduFriendObserver
{
  public vss(FriendChatPie paramFriendChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vss
 * JD-Core Version:    0.7.0.1
 */