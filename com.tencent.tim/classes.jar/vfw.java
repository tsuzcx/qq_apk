import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class vfw
  extends VasQuickUpdateManager.CallBacker
{
  public vfw(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (paramInt1 == 0) && (this.this$0.b != null)) {
      this.this$0.f(this.this$0.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfw
 * JD-Core Version:    0.7.0.1
 */