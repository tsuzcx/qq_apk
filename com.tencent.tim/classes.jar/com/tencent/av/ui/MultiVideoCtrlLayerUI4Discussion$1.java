package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import iwu;
import java.lang.ref.WeakReference;
import java.util.Map;
import jll;

class MultiVideoCtrlLayerUI4Discussion$1
  implements Runnable
{
  MultiVideoCtrlLayerUI4Discussion$1(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.mDestroy) {
      return;
    }
    String str2 = null;
    String str1;
    if (this.val$id == 2131697735)
    {
      if (this.this$0.dg.containsKey(this.val$uin)) {
        str2 = (String)this.this$0.dg.get(this.val$uin);
      }
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!TextUtils.equals(str2, "QQ")) {
          break label323;
        }
      }
      str1 = this.this$0.a.d(this.val$uin, String.valueOf(this.this$0.md), this.this$0.aqx);
    }
    label323:
    for (;;)
    {
      float f = this.this$0.mRes.getDimensionPixelSize(2131297418);
      str1 = jll.a((Context)this.this$0.mContext.get(), str1, this.this$0.mZ, f);
      str1 = str1 + this.this$0.mRes.getString(this.val$id);
      iwu.a(this.this$0.mApp, 3009, str1);
      QLog.e(this.this$0.TAG, 1, "showHrMeetingInOrOutWordingWithDelay str=" + str1);
      return;
      str2 = this.this$0.a.d(this.val$uin, String.valueOf(this.this$0.md), this.this$0.aqx);
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!TextUtils.equals(str2, "QQ")) {}
      }
      else
      {
        str1 = str2;
        if (this.this$0.dg.containsKey(this.val$uin)) {
          str1 = (String)this.this$0.dg.get(this.val$uin);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.1
 * JD-Core Version:    0.7.0.1
 */