package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import lbz;
import lhu;
import nkq;
import nlc;
import nnn;

public class FastWebActivity$39$8
  implements Runnable
{
  public FastWebActivity$39$8(nkq paramnkq, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d(FastWebActivity.a(this.a.this$0), 2, "get article business success, busiFlag:" + this.aZO);
    this.c.bat = this.aZO;
    this.c.aml = this.alC;
    if ((this.aZO == 0) && (FastWebActivity.a(this.a.this$0) != null))
    {
      nnn.dj(FastWebActivity.a(this.a.this$0));
      lhu locallhu = lbz.a().a();
      if (locallhu != null) {
        locallhu.h(FastWebActivity.a(this.a.this$0).rowKey, FastWebActivity.a(this.a.this$0));
      }
      nnn.de(FastWebActivity.a(this.a.this$0));
      FastWebActivity.a(this.a.this$0).notifyDataSetChanged();
      FastWebActivity.a(this.a.this$0).l(FastWebActivity.a(this.a.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.8
 * JD-Core Version:    0.7.0.1
 */