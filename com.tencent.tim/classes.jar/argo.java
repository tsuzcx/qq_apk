import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.mobileqq.widget.PagingScrollView;
import com.tencent.qphone.base.util.QLog;

public class argo
  implements View.OnTouchListener
{
  public argo(PagingScrollView paramPagingScrollView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.b.mIsOnSpecialView)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 3))
      {
        this.b.mIsOnSpecialView = false;
        this.b.getParent().requestDisallowInterceptTouchEvent(false);
        if (QLog.isDevelopLevel()) {
          QLog.i("PageScrollView", 4, "C.TE ACT_UP or CANCEL");
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argo
 * JD-Core Version:    0.7.0.1
 */