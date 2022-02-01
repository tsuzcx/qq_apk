package com.tencent.qqmail.activity.compose;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmail.utilities.ui.QMUIKit;

class ComposeNoteActivity$34
  implements ValueAnimator.AnimatorUpdateListener
{
  ComposeNoteActivity$34(ComposeNoteActivity paramComposeNoteActivity, boolean paramBoolean) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (FrameLayout.LayoutParams)ComposeNoteActivity.access$4300(this.this$0).getLayoutParams();
    if (this.val$visible) {}
    for (paramValueAnimator.bottomMargin = QMUIKit.dpToPx((int)(f * 40.0F + 5.0F));; paramValueAnimator.bottomMargin = QMUIKit.dpToPx((int)(45.0F - f * 40.0F)))
    {
      ComposeNoteActivity.access$4300(this.this$0).setLayoutParams(paramValueAnimator);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.34
 * JD-Core Version:    0.7.0.1
 */