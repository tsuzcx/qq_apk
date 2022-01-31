import com.tencent.mobileqq.activity.QQSetting;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class bec
  extends AccountObserver
{
  public bec(QQSetting paramQQSetting) {}
  
  protected void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2)
  {
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bec
 * JD-Core Version:    0.7.0.1
 */