import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class zpg
  extends VasQuickUpdateManager.CallBacker
{
  public zpg(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 1000L) && (paramString1.equals("pendant_market_json.android.v2"))) {
      if (paramInt1 == 0) {
        this.this$0.cqO();
      }
    }
    while ((paramLong != 23L) || (!paramString1.equals("avatarInPendant_json")) || (paramInt1 != 0)) {
      return;
    }
    this.this$0.cqP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpg
 * JD-Core Version:    0.7.0.1
 */