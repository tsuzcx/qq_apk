import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class vwc
  extends acmf
{
  public vwc(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, anxs paramanxs)
  {
    if ((paramBoolean) && (paramanxs != null) && (this.this$0.subUin != null) && (this.this$0.subUin.length() >= 5))
    {
      paramanxs = paramanxs.dO();
      if ((paramanxs != null) && (!paramanxs.contains(this.this$0.subUin))) {}
    }
    else
    {
      return;
    }
    paramanxs = (anxk)this.this$0.app.getManager(62);
    SubAccountUgActivity.a(this.this$0, paramanxs, this.this$0.subUin);
  }
  
  protected void c(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.this$0.subUin);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    if ((paramanxs == null) || (this.this$0.subUin == null) || ((this.this$0.subUin != null) && (!this.this$0.subUin.equals(paramanxs.aQf)))) {}
    do
    {
      return;
      this.this$0.ath();
      if (this.this$0.baz)
      {
        this.this$0.baz = false;
        if (paramBoolean)
        {
          this.this$0.bVH();
          this.this$0.wA(this.this$0.getString(2131720615));
          return;
        }
        this.this$0.wz(this.this$0.getString(2131720611));
        return;
      }
    } while (!paramBoolean);
    paramanxs = (anxk)this.this$0.app.getManager(62);
    Pair localPair = paramanxs.a(this.this$0.subUin, 1);
    paramanxs.a(this.this$0.app, this.this$0, localPair, new vwd(this, paramanxs, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwc
 * JD-Core Version:    0.7.0.1
 */