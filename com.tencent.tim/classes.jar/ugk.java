import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.qphone.base.util.QLog;

public class ugk
  extends achq
{
  public ugk(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void a(boolean paramBoolean, String paramString, anxs paramanxs)
  {
    if (AssociatedAccountActivity.a(this.this$0, paramString, paramanxs)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onPushSubAccountMsg subUin" + paramString);
      }
    } while (!paramBoolean);
    AssociatedAccountActivity.b(this.this$0, false);
  }
  
  public void a(boolean paramBoolean, String paramString, anxt paramanxt)
  {
    if (AssociatedAccountActivity.a(this.this$0, paramString, paramanxt)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onSubAccountThirdQQUnreadMsgNum mIsFromPull=" + this.this$0.aRt + "  mPullReqNeedBackNum=" + this.this$0.bDV + " isSuccess=" + paramBoolean + "  mainAccount=" + paramString + "  data=" + paramanxt);
      }
      if (this.this$0.aRt)
      {
        AssociatedAccountActivity.a(this.this$0, paramBoolean, false);
        return;
      }
      this.this$0.bDV = 0;
      this.this$0.aRu = false;
    } while (!paramBoolean);
    AssociatedAccountActivity.a(this.this$0, paramanxt);
  }
  
  public void b(boolean paramBoolean, String paramString, anxs paramanxs)
  {
    if (AssociatedAccountActivity.a(this.this$0, paramString, paramanxs)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onGetSubAccountMsg subAccount=" + paramString + " mIsFromPull=" + this.this$0.aRt + " isSuccess=" + paramBoolean + "  mPullReqNeedBackNum=" + this.this$0.bDV);
      }
      if (this.this$0.aRt)
      {
        AssociatedAccountActivity.a(this.this$0, paramBoolean, true);
        return;
      }
      this.this$0.bDV = 0;
      this.this$0.aRu = false;
      if ((paramBoolean) && (paramanxs.cKB))
      {
        this.this$0.bFZ();
        return;
      }
    } while (!paramBoolean);
    this.this$0.OG();
  }
  
  public void h(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onSubAccountMsgNumConfirm isSuccess=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (paramBoolean) {
        break label157;
      }
    }
    label157:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("AssociatedAccountActivity", 2, paramBoolean + " nextAction=" + paramString2 + " mNeed2ConfirmMsgNum=" + this.this$0.bDW);
      if (!"sub.account.switchAccount".equals(paramString2)) {
        break;
      }
      paramString1 = this.this$0;
      paramString1.bDW -= 1;
      if (this.this$0.bDW <= 0) {
        AssociatedAccountActivity.b(this.this$0, false, this.this$0.aKS);
      }
      if (this.this$0.bDW >= 0) {
        break;
      }
      this.this$0.bDW = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugk
 * JD-Core Version:    0.7.0.1
 */