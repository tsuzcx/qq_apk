import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qphone.base.util.QLog;

public class aaat
  implements View.OnFocusChangeListener
{
  public aaat(LingHbFragment paramLingHbFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      LingHbFragment.a(this.a).bo(this.a.aW.getText().toString(), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LingHbFragment", 2, "onFocusChange:" + paramBoolean);
      }
      return;
      LingHbFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaat
 * JD-Core Version:    0.7.0.1
 */