package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
import android.app.Dialog;
import aqha;
import aqju;
import ool.a;
import oom;
import oon;
import ooo;

public final class OuterInterceptManager$1
  implements Runnable
{
  public OuterInterceptManager$1(Activity paramActivity, ool.a parama) {}
  
  public void run()
  {
    aqju localaqju = aqha.a(this.val$activity, "正在离开QQ，前往“腾讯微视”", 2131721058, 2131721079, new oom(this), new oon(this));
    localaqju.setOnCancelListener(new ooo(this));
    localaqju.setCanceledOnTouchOutside(true);
    localaqju.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1
 * JD-Core Version:    0.7.0.1
 */