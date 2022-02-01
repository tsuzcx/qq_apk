import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;

class smf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  smf(slz paramslz, int paramInt) {}
  
  public void onGlobalLayout()
  {
    this.this$0.mRoot.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.this$0.mRoot.getLayoutParams();
    int i = this.this$0.bsi - this.this$0.bxG - this.bxH * 2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "maxHeight = " + i);
    }
    if (this.this$0.mRoot.getMeasuredHeight() > i)
    {
      localLayoutParams.height = (i - 5);
      this.this$0.mRoot.setLayoutParams(localLayoutParams);
    }
    if ((this.this$0.a != null) && (this.this$0.aLY) && (this.this$0.b.getOverScroller() != null)) {
      this.this$0.b.getOverScroller().startScroll(0, 0, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smf
 * JD-Core Version:    0.7.0.1
 */