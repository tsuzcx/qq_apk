import android.view.View;
import android.view.Window;

public class shb
{
  public static void e(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.getDecorView().setSystemUiVisibility(2);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new shc(paramWindow));
  }
  
  public static void f(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.setFlags(8, 8);
  }
  
  public static void g(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shb
 * JD-Core Version:    0.7.0.1
 */