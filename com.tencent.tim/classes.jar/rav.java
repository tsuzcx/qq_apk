import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity;

public class rav
  implements View.OnSystemUiVisibilityChangeListener
{
  public rav(DanceMachineQQBrowserActivity paramDanceMachineQQBrowserActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (paramInt = 4870;; paramInt = 775)
    {
      this.a.getWindow().getDecorView().setSystemUiVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rav
 * JD-Core Version:    0.7.0.1
 */