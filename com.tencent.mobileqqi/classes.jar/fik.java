import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class fik
  extends AccountObserver
{
  private fik(RegisterPush paramRegisterPush) {}
  
  public void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2)
  {
    RegisterPush.a(this.a).h = true;
    if (paramStatus == AppRuntime.Status.online)
    {
      RegisterPush.b(this.a).a.a(11L, false);
      if (!paramBoolean2) {
        break label118;
      }
      RegisterPush.e(this.a).a((byte)0);
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label152;
      }
      this.a.a(7);
      return;
      if (paramStatus == AppRuntime.Status.away)
      {
        RegisterPush.c(this.a).a.a(31L, false);
        break;
      }
      if (paramStatus != AppRuntime.Status.invisiable) {
        break;
      }
      RegisterPush.d(this.a).a.a(41L, false);
      break;
      label118:
      paramStatus = new QQProfileItem(RegisterPush.f(this.a).a);
      RegisterPush.g(this.a).a(101, paramStatus);
    }
    label152:
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fik
 * JD-Core Version:    0.7.0.1
 */