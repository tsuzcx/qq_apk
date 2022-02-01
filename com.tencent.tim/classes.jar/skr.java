import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;

public class skr
  extends acob
{
  public skr(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBoolean) {
      this.d.j(147, paramBundle);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopMemberApiService", 2, new Object[] { "onWebPushResp isSuc:", Boolean.valueOf(paramBoolean), " type:", Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skr
 * JD-Core Version:    0.7.0.1
 */