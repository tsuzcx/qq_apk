import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QzonePerformanceTracer;

public class fnx
  implements View.OnTouchListener
{
  public fnx(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      QzonePerformanceTracer.a(this.a, (int)paramMotionEvent.getX());
      QzonePerformanceTracer.b(this.a, (int)paramMotionEvent.getY());
      QzonePerformanceTracer.c(this.a, (int)paramMotionEvent.getRawX());
      QzonePerformanceTracer.d(this.a, (int)paramMotionEvent.getRawY());
      QzonePerformanceTracer.e(this.a, QzonePerformanceTracer.a(BaseApplication.getContext()));
      QzonePerformanceTracer.a(this.a, true);
    }
    do
    {
      do
      {
        return false;
        if ((paramMotionEvent.getAction() != 2) || (!QzonePerformanceTracer.a(this.a))) {
          break;
        }
        QzonePerformanceTracer.a(this.a).x = ((int)(paramMotionEvent.getRawX() - QzonePerformanceTracer.a(this.a)));
        QzonePerformanceTracer.a(this.a).y = ((int)(paramMotionEvent.getRawY() - QzonePerformanceTracer.b(this.a) - QzonePerformanceTracer.c(this.a)));
        QzonePerformanceTracer.a(this.a);
      } while (QzonePerformanceTracer.a(this.a) == null);
      QzonePerformanceTracer.a(this.a).updateViewLayout(QzonePerformanceTracer.a(this.a), QzonePerformanceTracer.a(this.a));
      return false;
    } while (paramMotionEvent.getAction() != 1);
    QzonePerformanceTracer.a(this.a, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fnx
 * JD-Core Version:    0.7.0.1
 */