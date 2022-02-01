package com.tencent.mobileqq.activity.selectable;

import aavv;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.widget.BubblePopupWindow;

public class CommonMenuWrapper$1
  implements Runnable
{
  public CommonMenuWrapper$1(aavv paramaavv, Activity paramActivity, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.val$activity != null) {
      if (!this.val$activity.isFinishing()) {
        aavv.a(this.this$0).b(this.Af, this.nK, this.nM, true);
      }
    }
    Context localContext;
    do
    {
      return;
      localContext = this.Af.getContext();
    } while ((!(localContext instanceof Activity)) || (((Activity)localContext).isFinishing()));
    aavv.a(this.this$0).b(this.Af, this.nK, this.nM, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1
 * JD-Core Version:    0.7.0.1
 */