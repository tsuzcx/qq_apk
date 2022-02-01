import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

final class aqjj
  extends acnd
{
  aqjj(long paramLong, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    if (this.asX != paramLong) {
      return;
    }
    paramTroopInfo = new StringBuilder().append("onOIDB0X88D_0_Ret[").append(this.ctV).append("], troopuin[").append(paramLong).append("], nFlag[").append(paramInt1).append("], isMyFlag[");
    if ((paramInt1 & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("QAVGroupConfig", 1, bool + "], isSuccess[" + paramBoolean + "], result[" + paramInt2 + "], strErrorMsg[" + paramString + "]");
      if (paramInt1 != 480) {
        break;
      }
      if (paramBoolean) {
        aqji.b.d(this.ctV + ".onOIDB0X88D_0_Ret", this.val$app, this.ctW);
      }
      this.val$app.removeObserver(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjj
 * JD-Core Version:    0.7.0.1
 */