import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;

class apyn
  implements ValueAnimator.AnimatorUpdateListener
{
  apyn(apyl paramapyl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ((RelativeLayout.LayoutParams)this.this$0.g.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.this$0.g.requestLayout();
    if (paramValueAnimator.intValue() <= -apyl.dXW + this.this$0.mContext.getResources().getDimensionPixelSize(2131299627))
    {
      if (this.this$0.e != null) {
        this.this$0.e.Rv(false);
      }
      this.this$0.g.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyn
 * JD-Core Version:    0.7.0.1
 */