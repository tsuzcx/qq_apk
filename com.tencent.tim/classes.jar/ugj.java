import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ugj
  extends acmf
{
  public ugj(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, anxs paramanxs)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((paramanxs == null) || (!TextUtils.equals(paramanxs.aLa, this.this$0.app.getCurrentUin()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      paramanxs = paramanxs.dO();
    } while ((paramanxs == null) || (this.this$0.oM == null));
    Iterator localIterator = this.this$0.oM.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramanxs.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (paramanxs.size() != this.this$0.oM.size()) {
        i = j;
      }
      while (i != 0)
      {
        AssociatedAccountActivity.b(this.this$0, false);
        return;
      }
      break;
    }
  }
  
  protected void b(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (paramanxs != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    if ((paramanxs == null) || (!TextUtils.equals(paramanxs.aLa, this.this$0.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.this$0, false);
  }
  
  protected void c(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (paramanxs != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    if ((paramanxs == null) || (!TextUtils.equals(paramanxs.aLa, this.this$0.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugj
 * JD-Core Version:    0.7.0.1
 */