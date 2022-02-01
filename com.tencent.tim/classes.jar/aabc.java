import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class aabc
  implements zxt.a
{
  public aabc(ThemeHbFragment paramThemeHbFragment) {}
  
  public void aM(Object paramObject)
  {
    if (ThemeHbFragment.a(this.this$0) == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back context is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back drawable = " + paramObject);
      }
    } while (!(paramObject instanceof Drawable));
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess image set...");
    }
    ThemeHbFragment.a(this.this$0).post(new ThemeHbFragment.2.1(this, paramObject));
  }
  
  public void onLoadFail()
  {
    ThemeHbFragment.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabc
 * JD-Core Version:    0.7.0.1
 */