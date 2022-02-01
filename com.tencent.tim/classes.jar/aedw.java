import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.a;

public class aedw
  implements ValueAnimator.AnimatorUpdateListener
{
  public aedw(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout1, ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout2, Point paramPoint, LinearLayout.LayoutParams paramLayoutParams, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * (ColorNoteSmallScreenRelativeLayout.b(this.this$0) / 2));
    int j = ColorNoteSmallScreenRelativeLayout.a(this.this$0, this.this$0.getRealWidth());
    int k = ColorNoteSmallScreenRelativeLayout.c(this.this$0);
    if (ColorNoteSmallScreenRelativeLayout.a(this.this$0) != null) {
      ColorNoteSmallScreenRelativeLayout.a(this.this$0).b(this.a, this.h.x - i, this.h.y, j + this.h.x - i, k + this.h.y);
    }
    this.val$params.leftMargin = (this.cMh + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedw
 * JD-Core Version:    0.7.0.1
 */