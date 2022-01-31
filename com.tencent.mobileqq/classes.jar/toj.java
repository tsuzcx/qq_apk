import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SecurityProtectActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class toj
  implements Runnable
{
  public toj(SecurityProtectActivity paramSecurityProtectActivity) {}
  
  public void run()
  {
    SecurityProtectActivity.a(this.a, false);
    SecurityProtectActivity.a(this.a).setText(2131436646);
    SecurityProtectActivity.b(this.a).setVisibility(0);
    SecurityProtectActivity.a(this.a).setVisibility(0);
    ((LinearLayout)this.a.findViewById(2131371134)).setVisibility(8);
    FMToastUtil.a(2131434596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     toj
 * JD-Core Version:    0.7.0.1
 */