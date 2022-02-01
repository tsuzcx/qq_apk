import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.SSOAccountObserver;

class aokt
  extends SSOAccountObserver
{
  aokt(aokr.c paramc) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onFailed|account=" + paramString + ",ret=" + paramInt2);
    if (this.a.this$0.azV()) {
      ahlw.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.a.this$0.dN(9401, "get sKey failed");
    this.a.dVC();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onGetTicketNoPasswd|account=" + artw.qx(paramString) + ",type=" + paramInt);
    if (this.a.this$0.azV()) {
      ahlw.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, true);
    }
    long l = System.currentTimeMillis();
    if (paramInt == 4096)
    {
      aokr.d(this.a.this$0, new String(paramArrayOfByte));
      aokr.c.a(this.a).set(true);
      aryn.bz(paramString, l);
      this.a.dVB();
      return;
    }
    this.a.this$0.dN(9401, "get sKey failed");
    this.a.dVC();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onUserCancel|action=" + paramInt);
    if (this.a.this$0.azV()) {
      ahlw.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.a.this$0.dN(9401, "onUserCancel");
    this.a.dVC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokt
 * JD-Core Version:    0.7.0.1
 */