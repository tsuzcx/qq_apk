import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.common.config.AppSetting;

class apym
  implements ValueAnimator.AnimatorUpdateListener
{
  apym(apyl paramapyl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ((RelativeLayout.LayoutParams)this.this$0.g.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.this$0.g.requestLayout();
    if ((paramValueAnimator.intValue() >= this.this$0.mContext.getResources().getDimensionPixelSize(2131299627)) && (AppSetting.enableTalkBack) && (this.this$0.g.getChildCount() > 0))
    {
      paramValueAnimator = this.this$0.g.getChildAt(0);
      if (paramValueAnimator != null) {
        paramValueAnimator.requestFocusFromTouch();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apym
 * JD-Core Version:    0.7.0.1
 */