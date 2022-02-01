import com.tencent.mobileqq.app.FriendsManager.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class acfg
  extends AccountObserver
{
  acfg(acff paramacff) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.executeOnSubThread(new FriendsManager.1.1(this, paramString2, paramString1));
  }
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "onOnlineStatusChanged isSuccess = " + paramBoolean1 + " ,curStatus =  , isUserSet = " + paramStatus + " ,isFriendListChang = " + paramBoolean3 + " ,timeStamp = " + paramLong + " ,isGatherListChange = " + paramBoolean4);
    }
    acff.a(this.this$0).a.d(paramBoolean3, paramLong, paramBoolean4);
    if (!paramBoolean3)
    {
      ackd localackd = new ackd(acff.a(this.this$0));
      acff.a(this.this$0).a.a(101, localackd);
    }
    ((aktp)acff.a(this.this$0).getManager(369)).a(paramBoolean1, paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfg
 * JD-Core Version:    0.7.0.1
 */