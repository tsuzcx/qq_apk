import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.dataline.activities.LiteActivity;

class aw
  implements Runnable
{
  aw(av paramav) {}
  
  public void run()
  {
    LiteActivity.b(this.a.a);
    int[] arrayOfInt = new int[2];
    LiteActivity.a(this.a.a).getLocationOnScreen(arrayOfInt);
    LiteActivity.a(arrayOfInt[1] + LiteActivity.a(this.a.a).getHeight());
    ((WindowManager)this.a.a.a().getSystemService("window")).getDefaultDisplay().getHeight();
    if (LiteActivity.a() != 0)
    {
      LiteActivity.a(this.a.a, (int)(this.a.a.getResources().getDisplayMetrics().density * 124.0F));
      return;
    }
    LiteActivity.a(this.a.a, (int)(this.a.a.getResources().getDisplayMetrics().density * 124.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     aw
 * JD-Core Version:    0.7.0.1
 */