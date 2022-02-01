import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.ParticipleView.b;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class argq
  implements ValueAnimator.AnimatorUpdateListener
{
  public argq(ParticipleView paramParticipleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    long l = System.currentTimeMillis();
    paramValueAnimator = ParticipleView.a(this.b).iterator();
    int i = 1;
    if (paramValueAnimator.hasNext())
    {
      ParticipleView.b localb = (ParticipleView.b)paramValueAnimator.next();
      float f = Math.min((float)(l - ParticipleView.b.a(localb)) / ParticipleView.a(this.b), 1.0F);
      ParticipleView.b.a(localb, f);
      if (f < 1.0F) {
        i = 0;
      }
      for (;;)
      {
        break;
        paramValueAnimator.remove();
      }
    }
    if (i != 0)
    {
      ParticipleView.a(this.b).cancel();
      ParticipleView.a(this.b, null);
      ParticipleView.a(this.b).clear();
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "selectedAnimation end cancel");
      }
    }
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argq
 * JD-Core Version:    0.7.0.1
 */