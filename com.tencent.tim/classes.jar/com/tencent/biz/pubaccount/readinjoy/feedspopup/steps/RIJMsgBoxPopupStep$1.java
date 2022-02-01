package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import kxm;
import lcx;

public class RIJMsgBoxPopupStep$1
  implements Runnable
{
  public RIJMsgBoxPopupStep$1(lcx paramlcx, Activity paramActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    if (!this.val$activity.isFinishing()) {
      kxm.a(this.val$activity, this.val$from, true, this.val$msgId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep.1
 * JD-Core Version:    0.7.0.1
 */