package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import nkq;
import nlc;

public class FastWebActivity$39$4
  implements Runnable
{
  public FastWebActivity$39$4(nkq paramnkq, int paramInt) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.a.this$0) == null) {
      return;
    }
    FastWebActivity.a(this.a.this$0).likeCnt = this.aZN;
    FastWebActivity.a(this.a.this$0).tu(FastWebActivity.a(this.a.this$0).likeCnt);
    FastWebActivity.a(this.a.this$0).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.a.this$0), 2, " handleLikeCntInfoResp likeCnt : " + FastWebActivity.a(this.a.this$0).likeCnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.4
 * JD-Core Version:    0.7.0.1
 */