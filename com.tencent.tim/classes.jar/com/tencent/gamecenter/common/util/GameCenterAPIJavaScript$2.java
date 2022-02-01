package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.CustomWebView;

class GameCenterAPIJavaScript$2
  extends FrameLayout
{
  GameCenterAPIJavaScript$2(GameCenterAPIJavaScript paramGameCenterAPIJavaScript, Context paramContext, CustomWebView paramCustomWebView)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.val$webView instanceof View)) {
      this.val$webView.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.2
 * JD-Core Version:    0.7.0.1
 */