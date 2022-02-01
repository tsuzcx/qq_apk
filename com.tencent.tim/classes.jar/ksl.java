import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class ksl
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ksl(ksk paramksk, int paramInt, View paramView) {}
  
  public void onGlobalLayout()
  {
    ksk.a(this.a, this.val$position, this.val$view.getHeight());
    QLog.d("Q.readinjoy.fast_web", 2, " position : " + this.val$position + "   height:" + this.val$view.getHeight());
    this.val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksl
 * JD-Core Version:    0.7.0.1
 */