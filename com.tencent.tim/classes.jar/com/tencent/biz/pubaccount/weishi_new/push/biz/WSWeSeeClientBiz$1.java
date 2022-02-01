package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import omx;
import opb;

public class WSWeSeeClientBiz$1
  implements Runnable
{
  public WSWeSeeClientBiz$1(omx paramomx, Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo) {}
  
  public void run()
  {
    opb.p(this.val$context.getApplicationContext(), "biz_src_jc_gzh_weishi", this.a.mScheme);
    omx.a(this.this$0, this.a.mScheme);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSWeSeeClientBiz.1
 * JD-Core Version:    0.7.0.1
 */