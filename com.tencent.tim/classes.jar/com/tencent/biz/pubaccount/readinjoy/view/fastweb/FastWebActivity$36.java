package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.qphone.base.util.QLog;
import ksm;

class FastWebActivity$36
  implements Runnable
{
  FastWebActivity$36(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if ((FastWebActivity.a(this.this$0) == null) || (FastWebActivity.a(this.this$0) == null))
    {
      QLog.d(FastWebActivity.a(this.this$0), 1, "error! scrollToHotNewComment");
      return;
    }
    if (FastWebActivity.a(this.this$0).ahK)
    {
      FastWebActivity.a(this.this$0).aGw();
      return;
    }
    FastWebActivity.a(this.this$0).aGv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.36
 * JD-Core Version:    0.7.0.1
 */