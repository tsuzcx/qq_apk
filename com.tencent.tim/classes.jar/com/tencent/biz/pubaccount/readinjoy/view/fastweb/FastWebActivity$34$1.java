package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import java.util.List;
import kxm;
import nkn;
import nnc;
import nns;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebActivity$34$1
  implements Runnable
{
  final ArticleInfo articleInfo = FastWebActivity.a(this.a.this$0);
  final FastWebArticleInfo d = FastWebActivity.a(this.a.this$0);
  
  public FastWebActivity$34$1(nkn paramnkn, long paramLong, List paramList) {}
  
  public void run()
  {
    if ((this.d == null) || (this.articleInfo == null)) {
      return;
    }
    FastWebActivity localFastWebActivity = this.a.this$0;
    ArticleInfo localArticleInfo = this.articleInfo;
    Object localObject;
    if (this.d.FP()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = kxm.a(localFastWebActivity, localArticleInfo, 0, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("open_speed", this.val$costTime);
        nns.c(this.articleInfo, "0X8008997", ((JSONObject)localObject).toString());
        FastWebActivity.k(this.a.this$0);
        FastWebActivity.f(this.a.this$0, this.articleInfo, this.d);
        nns.a(this.articleInfo, this.U);
        nnc.a(this.articleInfo.mArticleContentUrl, this.d);
        return;
        localObject = "1";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.34.1
 * JD-Core Version:    0.7.0.1
 */