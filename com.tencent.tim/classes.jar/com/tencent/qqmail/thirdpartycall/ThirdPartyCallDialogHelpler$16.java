package com.tencent.qqmail.thirdpartycall;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

final class ThirdPartyCallDialogHelpler$16
  implements Animator.AnimatorListener
{
  ThirdPartyCallDialogHelpler$16(boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, int paramInt, View paramView, Runnable paramRunnable, ImageButton paramImageButton, LinearLayout paramLinearLayout, ItemScrollListView paramItemScrollListView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$cancelBtn.setClickable(true);
    this.val$attachmentWrap.setClickable(true);
    if (this.val$listView != null) {
      this.val$listView.setEnabled(true);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.val$present) {
      this.val$bottomView.setVisibility(8);
    }
    if (this.val$finshed != null) {
      this.val$finshed.run();
    }
    Threads.runOnMainThread(new ThirdPartyCallDialogHelpler.16.1(this), 50L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.val$present) {
      this.val$bottomviewLp.setMargins(0, 0, 0, this.val$height * -1);
    }
    for (;;)
    {
      this.val$bottomView.setVisibility(0);
      this.val$bottomView.invalidate();
      return;
      this.val$bottomviewLp.setMargins(0, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.16
 * JD-Core Version:    0.7.0.1
 */