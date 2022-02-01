package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import nkq;
import nlc;

public class FastWebActivity$39$5
  implements Runnable
{
  public FastWebActivity$39$5(nkq paramnkq, boolean paramBoolean) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.a.this$0) == null) {
      return;
    }
    FastWebActivity.a(this.a.this$0).isLiked = this.ati;
    FastWebActivity.a(this.a.this$0).px(FastWebActivity.a(this.a.this$0).isLiked);
    FastWebActivity.a(this.a.this$0).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.a.this$0), 2, " handleLikeStateResp isliked : " + FastWebActivity.a(this.a.this$0).isLiked);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.5
 * JD-Core Version:    0.7.0.1
 */