package com.tencent.mobileqq.nearby.now.view;

import ajpj;
import ajxs;
import android.text.TextUtils;
import anov;

class ShortVideoCommentsView$28
  implements Runnable
{
  ShortVideoCommentsView$28(ShortVideoCommentsView paramShortVideoCommentsView, ajpj paramajpj) {}
  
  public void run()
  {
    anov localanov = new anov(this.this$0.app).a("dc00899").b("grp_lbs").c("video").d("playpage_com_exp").e(ajxs.bSM);
    int i = this.a.GA();
    String str2 = ajxs.from;
    if (TextUtils.equals(ajxs.from, "2")) {}
    for (String str1 = ajxs.feedId;; str1 = "")
    {
      localanov.a(new String[] { "", String.valueOf(i), str2, str1 }).report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.28
 * JD-Core Version:    0.7.0.1
 */