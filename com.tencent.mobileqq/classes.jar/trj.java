import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SecurityProtectActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class trj
  implements Runnable
{
  public trj(SecurityProtectActivity paramSecurityProtectActivity) {}
  
  public void run()
  {
    SecurityProtectActivity.a(this.a, false);
    SecurityProtectActivity.a(this.a).setText(2131436663);
    SecurityProtectActivity.b(this.a).setVisibility(0);
    SecurityProtectActivity.a(this.a).setVisibility(0);
    ((LinearLayout)this.a.findViewById(2131371297)).setVisibility(8);
    FMToastUtil.a(2131434613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trj
 * JD-Core Version:    0.7.0.1
 */