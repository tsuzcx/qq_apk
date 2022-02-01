import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class xpk
  implements xpl
{
  protected Activity a;
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a(int paramInt)
  {
    Activity localActivity = this.a;
    if (localActivity != null) {
      return localActivity.findViewById(paramInt);
    }
    xvv.e(getClass().getSimpleName(), "findViewById can not access after detach");
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      localActivity.setContentView(paramInt);
      return;
    }
    xvv.e(getClass().getSimpleName(), "setContentView can not access after detach");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      localActivity.setResult(paramInt, paramIntent);
      return;
    }
    xvv.e(getClass().getSimpleName(), "finish can not access after detach");
  }
  
  public void a(@NonNull Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.a = null;
  }
  
  public void e()
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      localActivity.finish();
      return;
    }
    xvv.e(getClass().getSimpleName(), "finish can not access after detach");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpk
 * JD-Core Version:    0.7.0.1
 */