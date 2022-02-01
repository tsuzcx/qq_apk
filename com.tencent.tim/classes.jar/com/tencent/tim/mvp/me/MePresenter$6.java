package com.tencent.tim.mvp.me;

import acff;
import auje.b;
import aujf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class MePresenter$6
  implements Runnable
{
  public MePresenter$6(aujf paramaujf, acff paramacff) {}
  
  public void run()
  {
    Card localCard = this.d.b(aujf.o(this.this$0).getCurrentAccountUin());
    if (localCard != null)
    {
      aujf.a(this.this$0).a().runOnUiThread(new MePresenter.6.1(this, localCard));
      return;
    }
    aujf.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.me.MePresenter.6
 * JD-Core Version:    0.7.0.1
 */