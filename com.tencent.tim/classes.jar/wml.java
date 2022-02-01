import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

final class wml
  extends acnd
{
  wml(SessionInfo paramSessionInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      QWalletHelper.saveLastUpdateToopMemberNumTime(this.a.aTl);
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "onOIDB0X88D_0_Ret 群uin：" + this.a.aTl + " 群成员个数：" + paramTroopInfo.wMemberNum);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wml
 * JD-Core Version:    0.7.0.1
 */