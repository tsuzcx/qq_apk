import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForceLogoutActivity;
import com.tencent.mobileqq.activity.LoginActivity;

public class crr
  implements View.OnClickListener
{
  public crr(ForceLogoutActivity paramForceLogoutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.startActivity(new Intent(this.a, LoginActivity.class).addFlags(67108864));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crr
 * JD-Core Version:    0.7.0.1
 */