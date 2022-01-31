import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qqfav.QfavHelper;

class bew
  implements View.OnClickListener
{
  bew(beu parambeu) {}
  
  public void onClick(View paramView)
  {
    QfavHelper.b(this.a.a.a(), this.a.a.a.getAccount(), null, -1);
    if ((QQSetting.a(this.a.a) != null) && (QQSetting.a(this.a.a).isShowing()))
    {
      QQSetting.a(this.a.a).dismiss();
      QQSetting.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bew
 * JD-Core Version:    0.7.0.1
 */