package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import nmr;

class FastWebAnimationUtils$2$1
  implements Runnable
{
  FastWebAnimationUtils$2$1(FastWebAnimationUtils.2 param2) {}
  
  public void run()
  {
    AnimationSet localAnimationSet = nmr.b(this.this$0.ty, this.this$0.val$activity.getApplicationContext());
    this.this$0.ty.setVisibility(0);
    this.this$0.ty.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.2.1
 * JD-Core Version:    0.7.0.1
 */