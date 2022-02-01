import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.a;

public class arjb
  extends GestureDetector.SimpleOnGestureListener
{
  public arjb(SlideDetectListView paramSlideDetectListView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.l.dbB) {}
    do
    {
      return false;
      if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) && ((this.l.mScrollState == 0) || (this.l.dbC)) && (!this.l.aQV) && (Math.abs(paramFloat1) > this.l.eim))
      {
        this.l.eij = this.l.kC(this.l.mDownY);
        this.l.JF = this.l.T(this.l.eij);
        if (this.l.JF != null)
        {
          this.l.aQV = true;
          this.l.setPressed(false);
          this.l.JF.setPressed(false);
          if (SlideDetectListView.a(this.l) != null)
          {
            int i = this.l.eij;
            int j = this.l.getHeaderViewsCount();
            SlideDetectListView.a(this.l).a(this.l, this.l.JF, i - j);
          }
          this.l.mDownY = 0;
        }
        for (;;)
        {
          return true;
          this.l.dbA = true;
        }
      }
    } while (Math.abs(paramFloat1) <= Math.abs(paramFloat2) * 2.0F);
    this.l.dbA = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjb
 * JD-Core Version:    0.7.0.1
 */