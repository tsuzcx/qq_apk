import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.qphone.base.util.QLog;

public class amiu
  implements OnApplyWindowInsetsListener
{
  public amiu(ScreenShotFragment paramScreenShotFragment) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onApplyWindowInsets current is liuhai style!");
    }
    ScreenShotFragment.b(this.this$0);
    return ViewCompat.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amiu
 * JD-Core Version:    0.7.0.1
 */