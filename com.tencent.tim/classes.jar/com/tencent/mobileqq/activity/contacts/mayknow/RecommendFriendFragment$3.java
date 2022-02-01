package com.tencent.mobileqq.activity.contacts.mayknow;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import wja;

class RecommendFriendFragment$3
  implements Runnable
{
  RecommendFriendFragment$3(RecommendFriendFragment paramRecommendFriendFragment) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.this$0.yv != null) && (this.this$0.root != null) && (this.this$0.yv.getVisibility() == 0) && (this.this$0.yv.getMeasuredHeight() > 0) && (this.this$0.root.getMeasuredHeight() > 0))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.yv.getLayoutParams();
      if (this.this$0.cbZ <= 0) {
        break label252;
      }
    }
    label252:
    for (int i = (this.this$0.root.getMeasuredHeight() - Math.max(this.this$0.cbZ - this.this$0.cbY, 0) - this.this$0.yv.getMeasuredHeight()) / 2;; i = wja.dp2px(68.0F, this.this$0.getResources()))
    {
      if (i != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i;
        this.this$0.yv.setLayoutParams(localLayoutParams);
      }
      if (QLog.isColorLevel()) {
        QLog.i("RecommendFriendFragment", 2, "onHeadViewScrollChanged topMargin:" + localLayoutParams.topMargin + " mLastHeadViewCurrentY:" + this.this$0.cbY + " mLastHeadViewMaxY:" + this.this$0.cbZ + " rheight:" + this.this$0.root.getMeasuredHeight() + "  eheight:" + this.this$0.yv.getMeasuredHeight());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment.3
 * JD-Core Version:    0.7.0.1
 */