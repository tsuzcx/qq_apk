import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.3.1;
import com.tencent.qphone.base.util.QLog;

public class aabd
  implements zxt.a
{
  public aabd(ThemeHbFragment paramThemeHbFragment) {}
  
  public void aM(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess download back obj = " + paramObject);
    }
    if (((paramObject instanceof String)) && (ThemeHbFragment.a(this.this$0) != null)) {
      ThemeHbFragment.a(this.this$0).post(new ThemeHbFragment.3.1(this, paramObject));
    }
  }
  
  public void onLoadFail()
  {
    ThemeHbFragment.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabd
 * JD-Core Version:    0.7.0.1
 */