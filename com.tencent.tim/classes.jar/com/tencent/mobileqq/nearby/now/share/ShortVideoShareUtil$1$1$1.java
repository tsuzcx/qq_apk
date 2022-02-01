package com.tencent.mobileqq.nearby.now.share;

import ajpj;
import ajxe;
import ajxf;
import ajxs;
import android.text.TextUtils;
import anov;

public class ShortVideoShareUtil$1$1$1
  implements Runnable
{
  public ShortVideoShareUtil$1$1$1(ajxf paramajxf, ajpj paramajpj) {}
  
  public void run()
  {
    anov localanov = new anov(this.jdField_a_of_type_Ajxf.a.val$app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(ajxs.bSM);
    int i = this.jdField_a_of_type_Ajpj.GA();
    String str2 = ajxs.from;
    if (TextUtils.equals(ajxs.from, "2")) {}
    for (String str1 = ajxs.feedId;; str1 = "")
    {
      localanov.a(new String[] { "1", String.valueOf(i), str2, str1 }).report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.1.1
 * JD-Core Version:    0.7.0.1
 */