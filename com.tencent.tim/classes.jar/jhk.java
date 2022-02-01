import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qphone.base.util.QLog;

public class jhk
  implements View.OnTouchListener
{
  public jhk(GuideHelper paramGuideHelper, long paramLong) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.w("GuideHelper", 1, "onTouch to hide, seq[" + this.kQ + "]");
    GuideHelper.a(this.this$0, this.kQ);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhk
 * JD-Core Version:    0.7.0.1
 */