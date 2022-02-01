package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import kxm;
import nns;
import org.json.JSONObject;

class FastWebActivity$44
  implements Runnable
{
  FastWebActivity$44(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    FastWebActivity.p(this.this$0);
    FastWebActivity.q(this.this$0);
    ArticleInfo localArticleInfo1 = FastWebActivity.a(this.this$0);
    FastWebActivity localFastWebActivity = this.this$0;
    ArticleInfo localArticleInfo2 = FastWebActivity.a(this.this$0);
    int i = (int)FastWebActivity.a(this.this$0).mChannelID;
    if (FastWebActivity.a(this.this$0).FP()) {}
    for (String str = "2";; str = "1")
    {
      nns.c(localArticleInfo1, "0X800A09E", kxm.a(localFastWebActivity, localArticleInfo2, i, str).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.44
 * JD-Core Version:    0.7.0.1
 */