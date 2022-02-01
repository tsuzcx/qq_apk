import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.widget.QQToast;

public class akrs
  extends aktx
{
  public akrs(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void U(boolean paramBoolean, Bundle paramBundle)
  {
    super.U(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      AccountOnlineStateActivity.a(this.this$0, true, 0);
      return;
    }
    QQToast.a(AccountOnlineStateActivity.a(this.this$0), 1, "可见范围设置失败，请重试。", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrs
 * JD-Core Version:    0.7.0.1
 */