import android.app.Activity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class auvs
  implements View.OnFocusChangeListener
{
  public auvs(XPanelContainer paramXPanelContainer) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && ((this.g.getContext() instanceof Activity))) {
      QLog.d("XPanelContainer", 2, new Object[] { "input focus changed, hasFocus=", Boolean.valueOf(paramBoolean), ", current focus=", ((Activity)this.g.getContext()).getCurrentFocus() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvs
 * JD-Core Version:    0.7.0.1
 */