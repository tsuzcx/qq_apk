import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.QQSettingMe;

public class vps
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public vps(QQSettingMe paramQQSettingMe) {}
  
  public void onGlobalLayout()
  {
    if (QQSettingMe.a(this.this$0)) {
      QQSettingMe.a(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vps
 * JD-Core Version:    0.7.0.1
 */