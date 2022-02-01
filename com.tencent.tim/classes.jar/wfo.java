import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class wfo
  extends VasQuickUpdateManager.CallBacker
{
  public wfo(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")))
    {
      if ((paramInt1 == 0) && (!TextUtils.isEmpty(this.this$0.aRT))) {
        this.this$0.xe(this.this$0.aRT);
      }
    }
    else {
      return;
    }
    QLog.e("VipProfileCardDiyActivity", 1, "download card background failed. errorCode=" + paramInt1 + ", url=" + this.this$0.aRP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfo
 * JD-Core Version:    0.7.0.1
 */