import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;

public class wye
  extends akjr
{
  public wye(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBoolean) {
      this.a.a(145, paramBundle);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopMemberApiService", 2, new Object[] { "onWebPushResp isSuc:", Boolean.valueOf(paramBoolean), " type:", Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wye
 * JD-Core Version:    0.7.0.1
 */