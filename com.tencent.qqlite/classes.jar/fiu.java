import android.os.Bundle;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.qqconnect.wtlogin.LoginHelper.Callback;
import mqq.observer.SSOAccountObserver;

public class fiu
  extends SSOAccountObserver
{
  public fiu(LoginHelper paramLoginHelper) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.a.a();
    this.a.a = null;
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {}
    for (paramArrayOfByte = new String(paramArrayOfByte);; paramArrayOfByte = null)
    {
      this.a.a.a(paramString, paramArrayOfByte);
      this.a.a = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fiu
 * JD-Core Version:    0.7.0.1
 */