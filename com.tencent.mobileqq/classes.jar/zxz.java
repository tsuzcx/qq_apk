import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class zxz
  extends AccountObserver
{
  private zxz(RegisterPush paramRegisterPush) {}
  
  public void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, long paramLong, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onlineStatusChanged isSuccess=" + paramBoolean1 + ",curStatus=" + paramStatus.toString() + ",isFriendListChang=" + paramBoolean2 + ",timeStamp=" + paramLong + ",isGatherListChange=" + paramBoolean3);
    }
    if (paramBoolean1)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */