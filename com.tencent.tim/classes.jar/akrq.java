import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class akrq
  extends accn
{
  public akrq(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  protected void onGetAutoReplyList(boolean paramBoolean, List<AutoReplyText> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, String.format("onGetAutoReplyList, isSuccess: %s, selectId: %s, replyList: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramList }));
    }
    if (AccountOnlineStateActivity.a(this.this$0) != null) {
      AccountOnlineStateActivity.a(this.this$0).runOnUiThread(new AccountOnlineStateActivity.4.1(this, paramBoolean, paramList));
    }
  }
  
  protected void onSetAutoReplyList(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      akto localakto = AccountOnlineStateActivity.a(this.this$0).a();
      AppRuntime.Status localStatus = akti.a().a(localakto);
      if ((localStatus != null) && (!AccountOnlineStateActivity.a(this.this$0, localakto, localStatus)))
      {
        AccountOnlineStateActivity.a(this.this$0, true);
        AccountOnlineStateActivity.a(this.this$0).a(localStatus, localakto.id);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onSetAutoReplyList, isSuccess: " + paramBoolean);
      }
      return;
      AccountOnlineStateActivity.a(this.this$0, true, 0);
      continue;
      AccountOnlineStateActivity.a(this.this$0, false, -2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrq
 * JD-Core Version:    0.7.0.1
 */