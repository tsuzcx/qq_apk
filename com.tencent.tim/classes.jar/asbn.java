import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

class asbn
  extends SSOAccountObserver
{
  asbn(asbh paramasbh, OpenSDKAppInterface paramOpenSDKAppInterface, asbh.a parama) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramBundle.getInt("code")))
    {
      QLog.d("SSOAccountObserver", 1, new Object[] { "-->getTicketNoPasswd onFailed", ", action", Integer.valueOf(paramInt1), ", code=", localObject });
      this.a.J(paramString, paramBundle);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "-->getTicketNoPasswd onGetTicketNoPasswd");
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      aryn.bz(paramString, System.currentTimeMillis());
    }
    WtloginManager localWtloginManager = (WtloginManager)this.b.getManager(1);
    asav localasav = new asav();
    localasav.key = new String(paramArrayOfByte);
    localasav.uin = Long.toString(this.b.a(localWtloginManager, paramString));
    localasav.hr = paramBundle.getByteArray("st_temp");
    localasav.hs = paramBundle.getByteArray("st_temp_key");
    this.a.a(localasav);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     asbn
 * JD-Core Version:    0.7.0.1
 */