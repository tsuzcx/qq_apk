import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

final class wss
  implements View.OnSystemUiVisibilityChangeListener
{
  wss(Window paramWindow) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (paramInt = 5894;; paramInt = 1799)
    {
      this.a.getDecorView().setSystemUiVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wss
 * JD-Core Version:    0.7.0.1
 */