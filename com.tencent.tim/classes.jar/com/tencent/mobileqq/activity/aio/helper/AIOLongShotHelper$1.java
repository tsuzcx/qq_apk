package com.tencent.mobileqq.activity.aio.helper;

import acfp;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

class AIOLongShotHelper$1
  implements Runnable
{
  AIOLongShotHelper$1(AIOLongShotHelper paramAIOLongShotHelper, boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = AIOLongShotHelper.a(this.this$0).mActivity;
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      if (!this.bfZ) {
        break label41;
      }
    }
    for (;;)
    {
      AIOLongShotHelper.a(this.this$0, this.val$path);
      return;
      label41:
      if (!this.val$success)
      {
        QQToast.a(AIOLongShotHelper.a(this.this$0).mContext, 1, acfp.m(2131702268), 0).show();
        AIOLongShotHelper.report("0X800A50D");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.1
 * JD-Core Version:    0.7.0.1
 */