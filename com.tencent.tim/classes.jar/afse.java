import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class afse
  extends WtloginObserver
{
  afse(afsc paramafsc) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      afsc.c(this.b, true);
      if (afsc.a(this.b) != null)
      {
        paramWUserSigInfo = (QQAppInterface)afsc.a(this.b).get();
        if ((paramWUserSigInfo != null) && (afsf.a().ar(paramWUserSigInfo))) {}
      }
      else
      {
        afsc.a(this.b, false);
        afsc.b(this.b, false);
      }
      return;
    }
    afsc.a(this.b, false);
    afsc.c(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afse
 * JD-Core Version:    0.7.0.1
 */