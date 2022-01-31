import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.CommonWebActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bho
  implements View.OnClickListener
{
  public bho(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onClick(View paramView)
  {
    if (!RegisterPhoneNumActivity.a(this.a)) {
      return;
    }
    RegisterPhoneNumActivity.a(this.a, false);
    this.a.b.postDelayed(new bhp(this), 1000L);
    paramView = new Intent(this.a, CommonWebActivity.class);
    paramView.putExtra("uin", this.a.app.a());
    paramView.putExtra("ba_is_login", false);
    paramView.putExtra("url", "http://zc.qq.com/chs/agreement1_chs.html");
    paramView.putExtra("hide_more_button", true);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bho
 * JD-Core Version:    0.7.0.1
 */