import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.util.InputMethodUtil;

public class wzq
  implements TextView.OnEditorActionListener
{
  public wzq(CommonHbFragment paramCommonHbFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (CommonHbFragment.a(this.a).isEnabled()) {
        CommonHbFragment.a(this.a).performClick();
      }
      InputMethodUtil.b(CommonHbFragment.a(this.a));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzq
 * JD-Core Version:    0.7.0.1
 */