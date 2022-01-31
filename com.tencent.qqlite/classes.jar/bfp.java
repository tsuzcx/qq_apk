import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMe;

public class bfp
  implements View.OnClickListener
{
  public bfp(QQSettingMe paramQQSettingMe) {}
  
  public void onClick(View paramView)
  {
    if ((QQSettingMe.a(this.a) != null) && (QQSettingMe.a(this.a).isShowing())) {
      QQSettingMe.a(this.a).dismiss();
    }
    QQSettingMe.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfp
 * JD-Core Version:    0.7.0.1
 */