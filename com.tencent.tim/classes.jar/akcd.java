import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import java.util.List;

public class akcd
  implements PraiseManager.a
{
  public akcd(NearbyCardVoteView paramNearbyCardVoteView, int paramInt1, int paramInt2, List paramList) {}
  
  public void a(int paramInt1, alen paramalen, int paramInt2, String paramString)
  {
    if (this.a.mHandler.hasMessages(NearbyCardVoteView.dmm))
    {
      this.a.mHandler.removeMessages(NearbyCardVoteView.dmm);
      this.a.mHandler.obtainMessage(NearbyCardVoteView.dmm, this.dmn, this.dmo, this.DL).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcd
 * JD-Core Version:    0.7.0.1
 */