package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import nkq;
import nlc;

public class FastWebActivity$39$6
  implements Runnable
{
  public FastWebActivity$39$6(nkq paramnkq, String paramString) {}
  
  public void run()
  {
    if ((this.Vu == null) || (FastWebActivity.a(this.a.this$0) == null) || (!this.Vu.equals(FastWebActivity.a(this.a.this$0).rowKey)))
    {
      QLog.d(FastWebActivity.a(this.a.this$0), 2, "handleRefreshList, msg not match !" + this.Vu);
      return;
    }
    FastWebActivity.a(this.a.this$0).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.a.this$0), 2, "get article topic info success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.6
 * JD-Core Version:    0.7.0.1
 */