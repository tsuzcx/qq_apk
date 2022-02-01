import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleUtil;
import mqq.app.MobileQQ;

public class dfm
  implements View.OnClickListener
{
  public dfm(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    int i = LocaleUtil.a(this.a.b.getApplication().getApplicationContext());
    if ((i == 2) || (i == 3)) {
      paramView.putExtra("url", "http://zc.qq.com/chs/agreement1_chs.html");
    }
    for (;;)
    {
      paramView.putExtra("title", this.a.getString(2131559804));
      this.a.startActivity(paramView);
      return;
      paramView.putExtra("url", "http://passport.imqq.com/App/MobileQQ/safety.html?_wv=2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dfm
 * JD-Core Version:    0.7.0.1
 */