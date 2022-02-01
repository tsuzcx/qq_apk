import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class qwe
  implements qwf
{
  protected Activity activity;
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public View findViewById(int paramInt)
  {
    Activity localActivity = this.activity;
    if (localActivity != null) {
      return localActivity.findViewById(paramInt);
    }
    ram.e(getClass().getSimpleName(), "findViewById can not access after detach");
    return null;
  }
  
  public void finish()
  {
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      localActivity.finish();
      return;
    }
    ram.e(getClass().getSimpleName(), "finish can not access after detach");
  }
  
  public Activity o()
  {
    return this.activity;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAttach(@NonNull Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void onDestroy() {}
  
  public void onDetach()
  {
    this.activity = null;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setContentView(int paramInt)
  {
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      localActivity.setContentView(paramInt);
      return;
    }
    ram.e(getClass().getSimpleName(), "setContentView can not access after detach");
  }
  
  public void setResult(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      localActivity.setResult(paramInt, paramIntent);
      return;
    }
    ram.e(getClass().getSimpleName(), "finish can not access after detach");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwe
 * JD-Core Version:    0.7.0.1
 */