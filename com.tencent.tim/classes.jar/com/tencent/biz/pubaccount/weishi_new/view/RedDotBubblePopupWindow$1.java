package com.tencent.biz.pubaccount.weishi_new.view;

import android.os.Handler;
import android.view.View;
import aqnm;
import ooz;
import osw;

public class RedDotBubblePopupWindow$1
  implements Runnable
{
  public RedDotBubblePopupWindow$1(osw paramosw, View paramView) {}
  
  public void run()
  {
    if (osw.a(this.this$0) == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    this.val$view.getLocationOnScreen(arrayOfInt);
    osw.a(this.this$0).measure(0, 0);
    int i = osw.a(this.this$0).getMeasuredWidth();
    int j = osw.a(this.this$0).getMeasuredHeight();
    ooz.e("RedDotBubblePopupWindow", "popupWidth:" + i + " popupHeight:" + j + "   location[0]:" + arrayOfInt[0] + " location[1]:" + arrayOfInt[1] + " getWidth:" + this.val$view.getWidth() + " getHeight:" + this.val$view.getHeight());
    this.this$0.showAtLocation(this.val$view, 0, arrayOfInt[0] + this.val$view.getWidth() / 2 - i / 2, arrayOfInt[1] + this.val$view.getHeight() + aqnm.dip2px(2.0F));
    this.this$0.mMainHandler.postDelayed(new RedDotBubblePopupWindow.1.1(this), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */