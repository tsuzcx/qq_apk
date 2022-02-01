import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class aqjk
  extends acnd
{
  aqjk(String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.equals(this.ctW, paramString)) {
      return;
    }
    this.val$app.removeObserver(this);
    QLog.w("QAVGroupConfig", 1, "onGetTroopInfoResult[" + this.ctV + "], troopuin[" + this.ctW + "], isSuc[" + paramBoolean + "]");
    if (paramBoolean) {
      aqji.b.d(this.ctV + ".onGetTroopInfoResult", this.val$app, this.ctW);
    }
    this.val$app.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjk
 * JD-Core Version:    0.7.0.1
 */