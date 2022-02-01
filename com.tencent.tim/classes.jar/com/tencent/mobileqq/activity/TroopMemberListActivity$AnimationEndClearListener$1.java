package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class TroopMemberListActivity$AnimationEndClearListener$1
  implements Runnable
{
  TroopMemberListActivity$AnimationEndClearListener$1(TroopMemberListActivity.b paramb) {}
  
  public void run()
  {
    if (this.a.rl == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    switch (this.a.bDt)
    {
    default: 
      return;
    case 0: 
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.rl.getLayoutParams();
      localLayoutParams.leftMargin += (int)(this.a.this$0.mDensity * 34.0F);
      this.a.rl.setLayoutParams(localLayoutParams);
      this.a.rl.setTag("right");
    }
    for (;;)
    {
      this.a.rl.clearAnimation();
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.rl.getLayoutParams();
      localLayoutParams.leftMargin -= (int)(this.a.this$0.mDensity * 34.0F);
      this.a.rl.setLayoutParams(localLayoutParams);
      this.a.rl.setTag("left");
      continue;
      ((ImageView)this.a.rl).setImageResource(2130850670);
      continue;
      ((ImageView)this.a.rl).setImageResource(2130850669);
      continue;
      this.a.rl.setVisibility(0);
      continue;
      this.a.rl.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.AnimationEndClearListener.1
 * JD-Core Version:    0.7.0.1
 */