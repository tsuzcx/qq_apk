import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qphone.base.util.QLog;

public class wbo
  extends apsy
{
  public wbo(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetGiftMemberList");
    }
    TroopMemberListActivity.a(this.this$0, paramArrayOfLong1);
    TroopMemberListActivity.b(this.this$0, paramArrayOfLong2);
    TroopMemberListActivity.c(this.this$0, paramArrayOfLong3);
    TroopMemberListActivity.a(this.this$0, true);
    if (TroopMemberListActivity.b(this.this$0))
    {
      paramArrayOfLong1 = this.this$0.mHandler.obtainMessage(12, null);
      this.this$0.mHandler.sendMessage(paramArrayOfLong1);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetGiftMemberList error");
    }
    TroopMemberListActivity.a(this.this$0, true);
    if (TroopMemberListActivity.b(this.this$0))
    {
      paramString = this.this$0.mHandler.obtainMessage(12, null);
      this.this$0.mHandler.sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbo
 * JD-Core Version:    0.7.0.1
 */