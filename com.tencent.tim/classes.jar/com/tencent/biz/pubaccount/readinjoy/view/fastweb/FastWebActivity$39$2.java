package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import nkq;
import nlc;
import nnn;

public class FastWebActivity$39$2
  implements Runnable
{
  public void run()
  {
    if ((this.c == null) || (TextUtils.isEmpty(this.Vw)) || (FastWebActivity.a(this.a.this$0) == null) || (!this.Vw.equals(FastWebActivity.a(this.a.this$0).innerUniqueID)))
    {
      QLog.d(FastWebActivity.a(this.a.this$0), 2, "get article topic info fail, msg not match !");
      return;
    }
    nnn.a(this.ath, FastWebActivity.a(this.a.this$0), this.c, FastWebActivity.a(this.a.this$0));
    FastWebActivity.a(this.a.this$0).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.a.this$0), 2, "get article topic info success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.2
 * JD-Core Version:    0.7.0.1
 */