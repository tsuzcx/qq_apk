import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

public class wcd
  extends MessageObserver
{
  public wcd(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onBlessDirtyTextCheck " + paramBoolean + " ,code=" + paramInt);
    }
    if (paramBoolean) {}
    while ((i != 0) && (!BlessSelectMemberActivity.b()))
    {
      BlessSelectMemberActivity.a(this.a, BlessSelectMemberActivity.a(this.a));
      return;
      if (paramInt != 0) {
        if (paramInt == 1)
        {
          BlessSelectMemberActivity.a(this.a, 2131438264, true);
          i = 0;
        }
        else
        {
          if (paramInt == 8) {
            BlessSelectMemberActivity.a(this.a, 2131438265, true);
          }
          i = 0;
        }
      }
    }
    this.a.e();
  }
  
  public void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onSendBlessMsgResp " + paramBoolean1 + " ,replyCode=" + paramInt + " waitTime=" + paramLong + " ,entrance=" + BlessSelectMemberActivity.a(this.a));
    }
    if (!this.a.a) {
      return;
    }
    this.a.a = false;
    if (paramInt == 67L)
    {
      BlessSelectMemberActivity.a(System.currentTimeMillis());
      this.a.a(paramLong);
      this.a.e();
      BlessSelectMemberActivity.a(this.a, 2131438267, true);
      return;
    }
    this.a.a(paramBoolean1, paramBoolean2);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessSelectMemberActivity", 2, "onUpdateMsgContent, isSuc:" + paramBoolean + " ,type:" + BlessSelectMemberActivity.b(this.a));
    }
    if (BlessSelectMemberActivity.b(this.a) == 3) {
      if (paramBoolean) {
        BlessSelectMemberActivity.a(this.a);
      }
    }
    do
    {
      do
      {
        return;
        this.a.e();
        BlessSelectMemberActivity.a(this.a, 2131438268, false);
        return;
      } while (BlessSelectMemberActivity.b(this.a) != 2);
      if ((BlessSelectMemberActivity.a(this.a).a() == null) || (!paramBoolean))
      {
        this.a.e();
        BlessSelectMemberActivity.a(this.a, 2131438269, false);
        return;
      }
    } while (BlessSelectMemberActivity.b());
    BlessSelectMemberActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcd
 * JD-Core Version:    0.7.0.1
 */