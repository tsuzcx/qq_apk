import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.model.AccountManage.2.1;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

public class asax
  extends SSOAccountObserver
{
  asax(asaw paramasaw, SSOAccountObserver paramSSOAccountObserver) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.e.onFailed(paramString, paramInt1, paramInt2, paramBundle);
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    this.e.onGetA1WithA1(paramString, paramInt1, paramArrayOfByte, paramInt2, paramBundle);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new AccountManage.2.1(this, paramString, paramArrayOfByte, paramInt, paramBundle));
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    this.e.onLoginSuccess(paramString, paramArrayOfByte, paramInt, paramBundle);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.e.onUserCancel(paramString, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asax
 * JD-Core Version:    0.7.0.1
 */