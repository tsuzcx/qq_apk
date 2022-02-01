package com.tencent.mobileqq.nearby.now;

import ajpj;
import ajxs;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import anov;

class SmallVideoFragment$5
  implements Runnable
{
  SmallVideoFragment$5(SmallVideoFragment paramSmallVideoFragment, ajpj paramajpj) {}
  
  public void run()
  {
    anov localanov = new anov(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(ajxs.bSM);
    int i = this.a.GA();
    String str2 = ajxs.from;
    if (TextUtils.equals(ajxs.from, "2")) {}
    for (String str1 = ajxs.feedId;; str1 = "")
    {
      localanov.a(new String[] { "4", String.valueOf(i), str2, str1 }).report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.5
 * JD-Core Version:    0.7.0.1
 */