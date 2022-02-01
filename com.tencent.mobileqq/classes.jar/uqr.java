import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

public class uqr
  implements IMiniMsgUnreadCallback
{
  public void destroy()
  {
    uya.a("AIOLog", 1, "MiniMsgUser destroy");
  }
  
  public void hide()
  {
    uya.a("AIOLog", 1, "MiniMsgUser hide");
  }
  
  public void hideUnread()
  {
    uya.a("AIOLog", 1, "MiniMsgUser hideUnread");
  }
  
  public boolean show(int paramInt)
  {
    uya.a("AIOLog", 1, "MiniMsgUser show = " + paramInt);
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    uya.a("AIOLog", 1, "MiniMsgUser updateOnBackFromMiniAIO");
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    uya.a("AIOLog", 1, "MiniMsgUser updateUnreadCount i = " + paramInt + ", b = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqr
 * JD-Core Version:    0.7.0.1
 */