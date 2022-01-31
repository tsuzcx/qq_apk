import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class zec
  extends AccountObserver
{
  public zec(FriendsManager paramFriendsManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.executeOnSubThread(new zed(this, paramString2, paramString1));
  }
  
  public void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, long paramLong, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "onlineStatusChanged isSuccess=" + paramBoolean1 + ",curStatus=" + paramStatus.toString() + ",isFriendListChang=" + paramBoolean2 + ",timeStamp=" + paramLong + ",isGatherListChange=" + paramBoolean3);
    }
    if (paramStatus == AppRuntime.Status.online) {
      FriendsManager.a(this.a).a(11L, false);
    }
    for (;;)
    {
      FriendsManager.a(this.a).a.a(paramBoolean2, paramLong, paramBoolean3);
      if (!paramBoolean2)
      {
        paramStatus = new QQProfileItem(FriendsManager.a(this.a));
        FriendsManager.a(this.a).a.a(101, paramStatus);
      }
      return;
      if (paramStatus == AppRuntime.Status.away) {
        FriendsManager.a(this.a).a(31L, false);
      } else if (paramStatus == AppRuntime.Status.invisiable) {
        FriendsManager.a(this.a).a(41L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zec
 * JD-Core Version:    0.7.0.1
 */