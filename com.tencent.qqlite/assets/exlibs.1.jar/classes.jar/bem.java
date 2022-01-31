import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bem
  implements View.OnClickListener
{
  public bem(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.a.getPreferences().getInt("nearby_people_profile_ok_new", -1);
    boolean bool = this.a.a.getPreferences().getBoolean("nearby_people_skip_guide", false);
    if ((i == -1) && (!bool))
    {
      QQSetting.a(this.a, new QQProgressDialog(this.a.a(), (int)this.a.a().getResources().getDimension(2131492887)));
      QQSetting.a(this.a).a("正在检查资料");
      QQSetting.a(this.a).show();
      paramView = (CardHandler)this.a.a.a(2);
      if (paramView != null) {
        paramView.g();
      }
      return;
    }
    NearbyActivity.a(this.a.a(), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bem
 * JD-Core Version:    0.7.0.1
 */