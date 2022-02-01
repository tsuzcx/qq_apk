import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;

public class yqh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public yqh(TroopView paramTroopView) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      TroopView.a(this.b);
      return;
      this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqh
 * JD-Core Version:    0.7.0.1
 */