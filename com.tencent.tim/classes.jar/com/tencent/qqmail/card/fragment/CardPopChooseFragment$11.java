package com.tencent.qqmail.card.fragment;

import android.widget.LinearLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qqmail.qmui.layout.QMUIFloatLayout;

class CardPopChooseFragment$11
  implements ValueAnimator.AnimatorUpdateListener
{
  CardPopChooseFragment$11(CardPopChooseFragment paramCardPopChooseFragment, LinearLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$lp.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    CardPopChooseFragment.access$2100(this.this$0).setLayoutParams(this.val$lp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.11
 * JD-Core Version:    0.7.0.1
 */