import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import java.util.Iterator;
import java.util.List;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;

public class afcr
  extends afcu.c
{
  public afcr(MsgBoxListActivity paramMsgBoxListActivity, List paramList) {}
  
  public void b(boolean paramBoolean, List<nearby_now_anchor.AnchorStatus> paramList, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = this.zm.iterator();
      while (paramBundle.hasNext())
      {
        RecentItemNearbyLiveTipData localRecentItemNearbyLiveTipData = (RecentItemNearbyLiveTipData)paramBundle.next();
        this.this$0.a(localRecentItemNearbyLiveTipData, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcr
 * JD-Core Version:    0.7.0.1
 */