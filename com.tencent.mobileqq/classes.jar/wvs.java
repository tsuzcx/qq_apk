import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class wvs
  extends GetRedPointExObserver
{
  public wvs(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(Object paramObject)
  {
    this.a.g();
    if ((this.a.a != null) && (this.a.a.app != null) && (this.a.a.app.a() != null)) {
      this.a.a.app.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvs
 * JD-Core Version:    0.7.0.1
 */