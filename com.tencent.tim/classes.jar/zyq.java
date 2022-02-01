import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class zyq
  implements axce.a
{
  public zyq(RedPacketEmojiFragment paramRedPacketEmojiFragment, long paramLong) {}
  
  public void a(axcd paramaxcd, long paramLong1, long paramLong2) {}
  
  public void a(axcd paramaxcd, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("[doLoading] onAEDownloadFinish downloaded=").append(paramBoolean).append(",errorType=").append(paramInt).append(",aeResInfo null?:");
      if (paramaxcd != null) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("RedPacketEmojiFragment", 2, bool + ",cost:" + (System.currentTimeMillis() - this.val$startTime));
      ThreadManager.getUIHandler().post(new RedPacketEmojiFragment.3.1(this, paramBoolean, paramaxcd));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyq
 * JD-Core Version:    0.7.0.1
 */