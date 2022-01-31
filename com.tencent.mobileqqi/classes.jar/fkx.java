import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;

public class fkx
  implements View.OnClickListener
{
  public fkx(ScreenShot paramScreenShot) {}
  
  public void onClick(View paramView)
  {
    ScreenShot.a(this.a);
    if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
      KapalaiAdapterUtil.a().b(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fkx
 * JD-Core Version:    0.7.0.1
 */