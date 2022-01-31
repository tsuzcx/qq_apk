import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class cxp
  extends AccountObserver
{
  private cxp(RegisterPush paramRegisterPush) {}
  
  public void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2)
  {
    RegisterPush.a(this.a).g = true;
    if (paramStatus == AppRuntime.Status.online) {
      RegisterPush.b(this.a).a.a(11L, false);
    }
    for (;;)
    {
      RegisterPush.e(this.a).a(paramBoolean2);
      if (!paramBoolean2)
      {
        paramStatus = new QQProfileItem(RegisterPush.f(this.a).a);
        RegisterPush.g(this.a).a(101, paramStatus);
      }
      if (!paramBoolean1) {
        break;
      }
      this.a.a(7);
      return;
      if (paramStatus == AppRuntime.Status.away) {
        RegisterPush.c(this.a).a.a(31L, false);
      } else if (paramStatus == AppRuntime.Status.invisiable) {
        RegisterPush.d(this.a).a.a(41L, false);
      }
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cxp
 * JD-Core Version:    0.7.0.1
 */