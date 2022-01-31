import android.view.View;
import android.view.Window;

public class ylw
{
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.getDecorView().setSystemUiVisibility(2);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new ylx(paramWindow));
  }
  
  public static void b(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.setFlags(8, 8);
  }
  
  public static void c(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylw
 * JD-Core Version:    0.7.0.1
 */