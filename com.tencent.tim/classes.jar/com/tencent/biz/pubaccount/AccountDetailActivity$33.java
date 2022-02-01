package com.tencent.biz.pubaccount;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import aqcx;
import aqhu;
import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$33
  implements Runnable
{
  AccountDetailActivity$33(AccountDetailActivity paramAccountDetailActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      int i = aqcx.dip2px(this.this$0, 110.0F);
      Bitmap localBitmap = aqhu.m(this.val$path, i, i);
      this.this$0.cq = new BitmapDrawable(aqhu.r(localBitmap, i, i));
      this.this$0.mHandler.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.33
 * JD-Core Version:    0.7.0.1
 */