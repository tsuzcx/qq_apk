package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.net.URLEncoder;
import kxm;

class FastWebActivity$FastWebSheetItemClickProcessor$1
  implements Runnable
{
  FastWebActivity$FastWebSheetItemClickProcessor$1(FastWebActivity.a parama) {}
  
  public void run()
  {
    String str3 = "https://post.mp.qq.com/jubao/index?";
    String str1 = str3;
    if (FastWebActivity.a(this.a.this$0) != null) {}
    try
    {
      str1 = "https://post.mp.qq.com/jubao/index?" + "articleId=" + FastWebActivity.a(this.a.this$0).mArticleID + "&puin=" + FastWebActivity.a(this.a.this$0).mSubscribeID + "&url=" + URLEncoder.encode(FastWebActivity.a(this.a.this$0).mArticleContentUrl, "utf-8") + "&key=" + FastWebActivity.a(this.a.this$0).innerUniqueID + "&type=7&_wv=3";
      kxm.aJ(this.a.this$0, str1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.FastWebSheetItemClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */