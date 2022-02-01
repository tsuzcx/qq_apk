import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SSOAccountObserver;

public class vhc
  extends SSOAccountObserver
{
  public vhc(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.this$0.gV();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOAccountObserver", 2, "onGetTicketNoPasswd wtTicket=" + paramArrayOfByte);
    }
    String str = null;
    if (paramInt == 4096) {
      str = new String(paramArrayOfByte);
    }
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("last_account", paramString);
    paramArrayOfByte.putExtra("wtTicket", str);
    paramArrayOfByte.putExtra("ssobundle", paramBundle);
    this.this$0.setResult(-1, paramArrayOfByte);
    this.this$0.finish();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.this$0.gV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhc
 * JD-Core Version:    0.7.0.1
 */