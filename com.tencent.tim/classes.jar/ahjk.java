import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class ahjk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ahjk(ahjj paramahjj) {}
  
  public void onGlobalLayout()
  {
    if (ahjj.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        ahjj.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((ahjj.a(this.a) != null) && (this.a.b != null))
      {
        if (ahjj.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        ahjj.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (ahjj.a(this.a).getHeight() >= aqnm.dip2px(ahjj.a(this.a) + 2))
      {
        this.a.b.setMaxHeight(aqnm.dip2px(450.0F));
        this.a.b.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      ahjj.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjk
 * JD-Core Version:    0.7.0.1
 */