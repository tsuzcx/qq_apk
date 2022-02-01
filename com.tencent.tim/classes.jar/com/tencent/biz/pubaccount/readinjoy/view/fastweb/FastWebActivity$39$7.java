package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import nkq;

public class FastWebActivity$39$7
  implements Runnable
{
  public FastWebActivity$39$7(nkq paramnkq, String paramString) {}
  
  public void run()
  {
    if ((this.Vu == null) || (FastWebActivity.a(this.a.this$0) == null) || (!this.Vu.equals(FastWebActivity.a(this.a.this$0).rowKey)))
    {
      QLog.d(FastWebActivity.a(this.a.this$0), 2, "handleRelatedSearchWordsResp, msg not match !" + this.Vu);
      return;
    }
    QLog.d(FastWebActivity.a(this.a.this$0), 2, "get related search words success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.7
 * JD-Core Version:    0.7.0.1
 */