import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;

public class ymu
  extends ambg
{
  public ymu(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBoolean) {
      this.a.a(147, paramBundle);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopMemberApiService", 2, new Object[] { "onWebPushResp isSuc:", Boolean.valueOf(paramBoolean), " type:", Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ymu
 * JD-Core Version:    0.7.0.1
 */