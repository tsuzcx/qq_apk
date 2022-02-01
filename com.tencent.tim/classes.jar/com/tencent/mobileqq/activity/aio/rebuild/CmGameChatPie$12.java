package com.tencent.mobileqq.activity.aio.rebuild;

import abmf;
import com.tencent.mobileqq.utils.VipUtils;
import xxh;

public class CmGameChatPie$12
  implements Runnable
{
  public CmGameChatPie$12(xxh paramxxh, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = 2;
    if (xxh.a(this.this$0) == null) {
      xxh.a(this.this$0, new abmf(this.this$0.mActivity, this.this$0.app));
    }
    xxh.a(this.this$0).B(this.this$0.x);
    xxh.a(this.this$0).a(xxh.a(this.this$0), this.val$gameId, this.bXP, this.aWQ);
    xxh.a(this.this$0).show();
    xxh.a(this.this$0);
    if (this.bXP == 2) {}
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "endPage", 0, i, new String[] { this.val$gameId + "" });
      return;
      i = 1 - this.bXP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.12
 * JD-Core Version:    0.7.0.1
 */