import android.os.Bundle;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatObserver;

public class urz
  extends FlashChatObserver
{
  public urz(ArkFlashChatContainerWrapper paramArkFlashChatContainerWrapper) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if (paramBundle != null)
      {
        int i = paramBundle.getInt("resourceId");
        if ((i != -1) && (this.a.c == i))
        {
          paramBundle = (FlashChatManager)ArkAppContainer.a().getManager(216);
          ArkFlashChatContainerWrapper.a(this.a).path = paramBundle.a(this.a.c, ArkFlashChatContainerWrapper.b(this.a).name, ArkFlashChatContainerWrapper.c(this.a).appMinVersion);
          this.a.a(ArkFlashChatContainerWrapper.d(this.a).path, 0, null);
        }
      }
      return;
    }
    this.a.a(ArkFlashChatContainerWrapper.e(this.a).path, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urz
 * JD-Core Version:    0.7.0.1
 */