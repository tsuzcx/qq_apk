package com.tencent.tim.mvp.me;

import android.text.TextUtils;
import aqft;
import aqgv;
import aujf;
import mqq.os.MqqHandler;

public class MePresenter$1
  implements Runnable
{
  public MePresenter$1(aujf paramaujf, String paramString) {}
  
  public void run()
  {
    String str = aqgv.o(aujf.a(this.this$0), this.val$uin);
    if (!aqft.equalsWithNullCheck(str, aujf.a(this.this$0))) {
      aujf.a(this.this$0, str);
    }
    if (!TextUtils.isEmpty(aujf.a(this.this$0))) {
      this.this$0.g.post(new MePresenter.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.me.MePresenter.1
 * JD-Core Version:    0.7.0.1
 */