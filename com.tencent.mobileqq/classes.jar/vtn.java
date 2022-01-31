import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.observer.VipGifObserver;

public class vtn
  extends VipGifObserver
{
  public vtn(FriendChatPie paramFriendChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true))
    {
      paramBundle.getInt("gif_ui_show_bid");
      long l = paramBundle.getLong("gif_ui_show_seq");
      this.a.b(65536);
      FriendChatPie.a(this.a, Long.valueOf(l).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtn
 * JD-Core Version:    0.7.0.1
 */