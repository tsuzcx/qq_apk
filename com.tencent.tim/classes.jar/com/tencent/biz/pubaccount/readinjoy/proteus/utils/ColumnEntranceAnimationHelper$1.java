package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.animation.AnimatorSet;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import lri;

public class ColumnEntranceAnimationHelper$1
  implements Runnable
{
  public ColumnEntranceAnimationHelper$1(lri paramlri, AbsListView paramAbsListView) {}
  
  public void run()
  {
    if ((!lri.a(this.this$0)) && (lri.a(this.this$0, (ReadInJoyXListView)this.c)))
    {
      lri.a(this.this$0).start();
      lri.a(this.this$0).setVisibility(0);
      if (lri.a(this.this$0) != null) {
        lri.a(this.this$0).isColumnAnimationPlay = true;
      }
      this.this$0.a((ReadInJoyXListView)this.c);
      QLog.i("ColumnEntranceAnimationHelper", 1, "AnimationSet.start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.ColumnEntranceAnimationHelper.1
 * JD-Core Version:    0.7.0.1
 */