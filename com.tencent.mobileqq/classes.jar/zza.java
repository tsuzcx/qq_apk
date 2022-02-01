import android.view.View;
import android.view.Window;

public class zza
{
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.getDecorView().setSystemUiVisibility(2);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new zzb(paramWindow));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zza
 * JD-Core Version:    0.7.0.1
 */