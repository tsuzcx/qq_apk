import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alsw
  extends acnd
{
  public alsw(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramBoolean)
    {
      if (!this.this$0.isAdded())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "onUpdateTroopGetMemberList succ with fragment is detached");
        }
        return;
      }
      ReceiptMessageReadMemberListContainerFragment.a(this.this$0).getApp().getSharedPreferences("last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.this$0).getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.this$0), paramLong).apply();
      ReceiptMessageReadMemberListContainerFragment.a(this.this$0).sendEmptyMessage(4);
      ReceiptMessageReadMemberListContainerFragment.a(this.this$0).removeObserver(this);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.this$0).sendEmptyMessage(-1);
    QLog.d("ReceiptMessageReadMemberListContainerFragment", 1, "mTroopObserver onUpdateTroopGetMemberList fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsw
 * JD-Core Version:    0.7.0.1
 */