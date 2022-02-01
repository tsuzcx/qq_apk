import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;

public class fgh
  implements View.OnClickListener
{
  public fgh(ScreenShot paramScreenShot) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Fgl.a(false);
    if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
      KapalaiAdapterUtil.a().b(this.a.jdField_a_of_type_AndroidViewWindow);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgh
 * JD-Core Version:    0.7.0.1
 */