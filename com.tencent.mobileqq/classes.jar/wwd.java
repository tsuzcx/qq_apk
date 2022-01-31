import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyTabObserver;
import cooperation.readinjoy.ReadInJoyHelper;

public class wwd
  extends ReadInJoyTabObserver
{
  public wwd(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    if (ReadInJoyHelper.g()) {
      this.a.a(39, null);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    if (!ReadInJoyHelper.f()) {}
    while (this.a.a == null) {
      return;
    }
    this.a.a.runOnUiThread(new wwf(this, paramInt, paramObject));
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(1, paramView);
  }
  
  public void d()
  {
    if (!ReadInJoyHelper.f()) {}
    while (this.a.a == null) {
      return;
    }
    this.a.a.runOnUiThread(new wwe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwd
 * JD-Core Version:    0.7.0.1
 */