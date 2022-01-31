import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;

public class dfs
  implements View.OnClickListener
{
  public dfs(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(RegisterPhoneNumActivity.a(this.a))) {}
    while (!RegisterPhoneNumActivity.a(this.a)) {
      return;
    }
    RegisterPhoneNumActivity.a(this.a, false);
    this.a.b.postDelayed(new dft(this), 1000L);
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", RegisterPhoneNumActivity.a(this.a));
    paramView.putExtra("hide_more_button", true);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dfs
 * JD-Core Version:    0.7.0.1
 */