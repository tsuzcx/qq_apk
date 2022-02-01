import android.widget.ImageButton;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ajai
  implements PopupWindow.OnDismissListener
{
  public ajai(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onDismiss  endOfAnim: %s", new Object[] { Boolean.valueOf(this.this$0.cne) }));
    }
    this.this$0.cne = true;
    this.this$0.az.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajai
 * JD-Core Version:    0.7.0.1
 */