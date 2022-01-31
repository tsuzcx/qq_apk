import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class ulw
  extends VasQuickUpdateManager.CallBacker
{
  public ulw(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")))
    {
      if ((paramInt1 == 0) && (!TextUtils.isEmpty(this.a.f))) {
        this.a.c(this.a.f);
      }
    }
    else {
      return;
    }
    QLog.e("VipProfileCardDiyActivity", 1, "download card background failed. errorCode=" + paramInt1 + ", url=" + this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulw
 * JD-Core Version:    0.7.0.1
 */