import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

public class oki
  implements IMiniMsgUnreadCallback
{
  public void destroy()
  {
    ooz.i("AIOLog", 1, "MiniMsgUser destroy");
  }
  
  public void hide()
  {
    ooz.i("AIOLog", 1, "MiniMsgUser hide");
  }
  
  public void hideUnread()
  {
    ooz.i("AIOLog", 1, "MiniMsgUser hideUnread");
  }
  
  public boolean show(int paramInt)
  {
    ooz.i("AIOLog", 1, "MiniMsgUser show = " + paramInt);
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    ooz.i("AIOLog", 1, "MiniMsgUser updateOnBackFromMiniAIO");
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    ooz.i("AIOLog", 1, "MiniMsgUser updateUnreadCount i = " + paramInt + ", b = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oki
 * JD-Core Version:    0.7.0.1
 */