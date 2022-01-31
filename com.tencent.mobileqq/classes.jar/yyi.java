import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class yyi
  implements View.OnTouchListener
{
  public yyi(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramView != AbsBaseWebViewActivity.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "vg onTouch");
    }
    paramView = new HashMap(2);
    paramView.put("X", Integer.valueOf((int)paramMotionEvent.getX()));
    paramView.put("Y", Integer.valueOf((int)paramMotionEvent.getY()));
    this.a.a(8589934606L, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyi
 * JD-Core Version:    0.7.0.1
 */