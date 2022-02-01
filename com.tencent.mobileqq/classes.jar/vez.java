import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

public class vez
  implements IMiniMsgUnreadCallback
{
  public void destroy()
  {
    vmp.a("AIOLog", 1, "MiniMsgUser destroy");
  }
  
  public void hide()
  {
    vmp.a("AIOLog", 1, "MiniMsgUser hide");
  }
  
  public void hideUnread()
  {
    vmp.a("AIOLog", 1, "MiniMsgUser hideUnread");
  }
  
  public boolean show(int paramInt)
  {
    vmp.a("AIOLog", 1, "MiniMsgUser show = " + paramInt);
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    vmp.a("AIOLog", 1, "MiniMsgUser updateOnBackFromMiniAIO");
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    vmp.a("AIOLog", 1, "MiniMsgUser updateUnreadCount i = " + paramInt + ", b = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vez
 * JD-Core Version:    0.7.0.1
 */