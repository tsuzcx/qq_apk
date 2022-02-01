import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.c;

public class afit
  implements EmojiStickerManager.c
{
  public afit(MessengerService paramMessengerService) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (this.a.mClient != null) {
      EmojiStickerManager.a().b(this.a.mClient, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afit
 * JD-Core Version:    0.7.0.1
 */