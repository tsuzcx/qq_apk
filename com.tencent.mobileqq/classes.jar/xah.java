import android.view.MotionEvent;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.widget.QwScrollView.OnQwScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ScrollView;

public class xah
  implements QwScrollView.OnQwScrollListener
{
  public xah(CommonHbFragment paramCommonHbFragment) {}
  
  public void onScrollChanged(Boolean paramBoolean, ScrollView paramScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onTouch(ScrollView paramScrollView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CommonHbFragment", 2, "onScrollChanged...");
      }
      InputMethodUtil.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xah
 * JD-Core Version:    0.7.0.1
 */