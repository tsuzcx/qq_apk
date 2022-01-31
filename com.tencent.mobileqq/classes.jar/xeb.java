import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.qphone.base.util.QLog;

public class xeb
  implements PreloadImgManager.OnSingleDownloadCallback
{
  public xeb(ThemeHbFragment paramThemeHbFragment) {}
  
  public void a()
  {
    ThemeHbFragment.a(this.a, null);
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess download back obj = " + paramObject);
    }
    if (((paramObject instanceof String)) && (ThemeHbFragment.a(this.a) != null)) {
      ThemeHbFragment.a(this.a).post(new xec(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xeb
 * JD-Core Version:    0.7.0.1
 */