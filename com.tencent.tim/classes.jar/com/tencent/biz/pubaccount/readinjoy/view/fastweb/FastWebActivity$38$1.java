package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import nkp;

public class FastWebActivity$38$1
  implements Runnable
{
  public FastWebActivity$38$1(nkp paramnkp, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    try
    {
      if (this.atf)
      {
        FastWebActivity.a(this.a.this$0, this.e);
        FastWebActivity.l(this.a.this$0);
      }
      for (;;)
      {
        if ((this.atf) && (FastWebActivity.a(this.a.this$0) != null) && (!FastWebActivity.h(this.a.this$0))) {
          FastWebActivity.n(this.a.this$0);
        }
        return;
        FastWebActivity.m(this.a.this$0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.38.1
 * JD-Core Version:    0.7.0.1
 */