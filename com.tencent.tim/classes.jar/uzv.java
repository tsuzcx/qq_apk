import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class uzv
  extends aclh
{
  public uzv(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void bPd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onVipStatusChanged: ");
    }
    if ((this.this$0.app != null) && (VipUtils.ce(this.this$0.app)))
    {
      this.this$0.a(0L, null, null, false);
      if (FriendProfileCardActivity.b(this.this$0).compareAndSet(true, false))
      {
        if (FriendProfileCardActivity.a(this.this$0).get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "onVipStatusChanged: showDialog");
          }
          aqha.a(this.this$0, 232, null, acfp.m(2131706593), null, acfp.m(2131706601), new uzw(this), null).show();
        }
        this.this$0.removeObserver(FriendProfileCardActivity.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzv
 * JD-Core Version:    0.7.0.1
 */