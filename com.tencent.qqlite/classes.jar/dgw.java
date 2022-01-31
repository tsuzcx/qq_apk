import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class dgw
  extends WtloginObserver
{
  public dgw(EquipLockWebImpl paramEquipLockWebImpl) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      EquipLockWebImpl.c(this.a, true);
      if (!EquipmentLockImpl.a().a(EquipLockWebImpl.a(this.a)))
      {
        EquipLockWebImpl.a(this.a, false);
        EquipLockWebImpl.b(this.a, false);
      }
      return;
    }
    EquipLockWebImpl.a(this.a, false);
    EquipLockWebImpl.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dgw
 * JD-Core Version:    0.7.0.1
 */