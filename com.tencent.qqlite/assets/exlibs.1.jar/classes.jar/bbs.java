import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bbs
  implements View.OnTouchListener
{
  public bbs(QQBrowserActivity paramQQBrowserActivity) {}
  
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
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramView != QQBrowserActivity.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "vg onTouch");
      }
      bool1 = bool2;
    } while (this.a.a == null);
    paramView = new HashMap(2);
    paramView.put("X", Integer.valueOf((int)paramMotionEvent.getX()));
    paramView.put("Y", Integer.valueOf((int)paramMotionEvent.getY()));
    this.a.a.a(this.a.K, 22, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbs
 * JD-Core Version:    0.7.0.1
 */