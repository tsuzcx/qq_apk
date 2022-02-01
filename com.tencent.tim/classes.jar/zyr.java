import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.4.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class zyr
  implements PreloadManager.d
{
  public zyr(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    ThreadManager.getUIHandler().post(new RedPacketEmojiFragment.4.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyr
 * JD-Core Version:    0.7.0.1
 */