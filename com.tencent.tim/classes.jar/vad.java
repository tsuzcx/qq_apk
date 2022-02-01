import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class vad
  extends VasQuickUpdateManager.CallBacker
{
  public vad(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (this.this$0.f != null))
    {
      paramString1 = this.this$0.f.obtainMessage();
      paramString1.what = 7;
      if (paramInt1 != 0) {
        break label82;
      }
      paramString1.arg1 = 1;
    }
    for (paramString1.arg2 = 1;; paramString1.arg2 = 0)
    {
      if (this.this$0.f != null) {
        this.this$0.f.sendMessage(paramString1);
      }
      return;
      label82:
      paramString1.arg1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vad
 * JD-Core Version:    0.7.0.1
 */