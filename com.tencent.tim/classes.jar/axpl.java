import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import dov.com.qq.im.capture.control.CaptureAsyncStep.BindTroopMemberClient;

public class axpl
  implements skj.a
{
  public axpl(CaptureAsyncStep.BindTroopMemberClient paramBindTroopMemberClient) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nickName");
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      AppInterface localAppInterface = axov.d();
      if ((localAppInterface instanceof PeakAppInterface)) {
        ((PeakAppInterface)localAppInterface).Ev(paramBundle);
      }
      this.a.mClient.bzk();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpl
 * JD-Core Version:    0.7.0.1
 */