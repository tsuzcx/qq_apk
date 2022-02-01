import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SecurityProtectActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class dhm
  implements Runnable
{
  public dhm(SecurityProtectActivity paramSecurityProtectActivity) {}
  
  public void run()
  {
    SecurityProtectActivity.a(this.a, false);
    SecurityProtectActivity.a(this.a).setText(2131558466);
    SecurityProtectActivity.b(this.a).setVisibility(0);
    SecurityProtectActivity.a(this.a).setVisibility(0);
    ((LinearLayout)this.a.findViewById(2131234417)).setVisibility(8);
    FMToastUtil.a(2131562488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhm
 * JD-Core Version:    0.7.0.1
 */