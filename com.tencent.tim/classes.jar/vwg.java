import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vwg
  extends achq
{
  public vwg(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramanxs != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramanxs.errorType + "  errorMsg=" + paramanxs.errorMsg + " mainAccount=" + paramanxs.aLa + "  subAccount=" + paramanxs.aQf + " isNeedStartGetMsg=" + paramanxs.cKA);
      }
    }
    if ((paramanxs == null) || (paramString == null) || (paramString.length() < 5)) {}
    anxk localanxk;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.this$0.isFinishing());
        localanxk = (anxk)this.this$0.app.getManager(62);
        if (paramanxs.errorType != 1) {
          break;
        }
      } while ((this.this$0.subUin == null) || (!this.this$0.subUin.equals(paramString)));
      SubAccountUgActivity.a(this.this$0, localanxk, paramString);
      return;
    } while ((this.this$0.subUin == null) || (!this.this$0.subUin.equals(paramString)));
    localanxk.v(this.this$0.subUin, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwg
 * JD-Core Version:    0.7.0.1
 */