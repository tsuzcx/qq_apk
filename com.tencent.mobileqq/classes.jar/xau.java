import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.qphone.base.util.QLog;

public class xau
  implements PreloadImgManager.OnSingleDownloadCallback
{
  public xau(ThemeHbFragment paramThemeHbFragment) {}
  
  public void a()
  {
    ThemeHbFragment.a(this.a, null);
  }
  
  public void a(Object paramObject)
  {
    if (ThemeHbFragment.a(this.a) == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back context is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back bitmap = " + paramObject);
      }
    } while (!(paramObject instanceof Bitmap));
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess image set...");
    }
    ThemeHbFragment.a(this.a).post(new xav(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xau
 * JD-Core Version:    0.7.0.1
 */