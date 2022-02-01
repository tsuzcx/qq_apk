import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.qphone.base.util.QLog;

public class ylt
  extends achq
{
  public ylt(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  protected void U(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessSelectMemberActivity", 2, "onUpdateMsgContent, isSuc:" + paramBoolean + " ,type:" + BlessSelectMemberActivity.c(this.this$0));
    }
    if (BlessSelectMemberActivity.c(this.this$0) == 3) {
      if (paramBoolean) {
        BlessSelectMemberActivity.a(this.this$0);
      }
    }
    do
    {
      do
      {
        return;
        this.this$0.go();
        BlessSelectMemberActivity.d(this.this$0, 2131690920, false);
        return;
      } while (BlessSelectMemberActivity.c(this.this$0) != 2);
      if ((BlessSelectMemberActivity.a(this.this$0).a() == null) || (!paramBoolean))
      {
        this.this$0.go();
        BlessSelectMemberActivity.d(this.this$0, 2131690937, false);
        return;
      }
    } while (BlessSelectMemberActivity.access$000());
    BlessSelectMemberActivity.b(this.this$0);
  }
  
  public void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onSendBlessMsgResp " + paramBoolean1 + " ,replyCode=" + paramInt + " waitTime=" + paramLong + " ,entrance=" + BlessSelectMemberActivity.a(this.this$0));
    }
    if (!this.this$0.bns) {
      return;
    }
    this.this$0.bns = false;
    if (paramInt == 67L)
    {
      BlessSelectMemberActivity.access$402(System.currentTimeMillis());
      this.this$0.gp(paramLong);
      this.this$0.go();
      BlessSelectMemberActivity.d(this.this$0, 2131690921, true);
      return;
    }
    if (BlessSelectMemberActivity.b(this.this$0) == 15)
    {
      this.this$0.Ak(paramBoolean1);
      return;
    }
    this.this$0.be(paramBoolean1, paramBoolean2);
  }
  
  public void aD(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onBlessDirtyTextCheck " + paramBoolean + " ,code=" + paramInt);
    }
    if (paramBoolean) {}
    while ((i != 0) && (!BlessSelectMemberActivity.access$000()))
    {
      BlessSelectMemberActivity.a(this.this$0, BlessSelectMemberActivity.a(this.this$0));
      return;
      if (paramInt != 0) {
        if (paramInt == 1)
        {
          BlessSelectMemberActivity.d(this.this$0, 2131690901, true);
          i = 0;
        }
        else
        {
          if (paramInt == 8) {
            BlessSelectMemberActivity.d(this.this$0, 2131690936, true);
          }
          i = 0;
        }
      }
    }
    this.this$0.go();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylt
 * JD-Core Version:    0.7.0.1
 */