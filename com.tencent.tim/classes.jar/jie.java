import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class jie
  implements View.OnTouchListener
{
  jie(jib paramjib) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      QLog.w(this.this$0.TAG, 1, "OnTouch Close, view[" + paramView.getResources().getResourceName(paramView.getId()) + "]");
      this.this$0.b(false, 3);
      return true;
    }
    catch (Exception paramMotionEvent)
    {
      for (;;)
      {
        QLog.w(this.this$0.TAG, 1, "OnTouch Close, view[" + paramView.getId() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jie
 * JD-Core Version:    0.7.0.1
 */