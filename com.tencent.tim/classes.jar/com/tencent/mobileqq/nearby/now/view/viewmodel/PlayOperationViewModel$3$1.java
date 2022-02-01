package com.tencent.mobileqq.nearby.now.view.viewmodel;

import ajpj;
import ajxs;
import ajzv;
import akar;
import android.text.TextUtils;
import anov;

public class PlayOperationViewModel$3$1
  implements Runnable
{
  public PlayOperationViewModel$3$1(akar paramakar, ajpj paramajpj) {}
  
  public void run()
  {
    anov localanov = new anov(this.jdField_a_of_type_Akar.this$0.app).a("dc00899").b("grp_lbs").c("video").d("playpage_double_click").e(ajxs.bSM);
    int i = this.jdField_a_of_type_Ajpj.GA();
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
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.3.1
 * JD-Core Version:    0.7.0.1
 */