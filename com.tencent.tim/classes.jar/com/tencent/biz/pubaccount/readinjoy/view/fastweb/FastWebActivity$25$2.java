package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import aeej;
import android.os.Build.VERSION;
import nkd;
import nke;

public class FastWebActivity$25$2
  implements Runnable
{
  public FastWebActivity$25$2(nkd paramnkd) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.a(this.a.this$0) == null))
    {
      aeej.a(this.a.this$0, new nke(this));
      return;
    }
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2
 * JD-Core Version:    0.7.0.1
 */