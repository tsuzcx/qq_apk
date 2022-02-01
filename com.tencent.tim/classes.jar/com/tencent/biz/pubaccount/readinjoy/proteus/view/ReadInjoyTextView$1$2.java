package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import kxm;
import lst;
import lsu;

public class ReadInjoyTextView$1$2
  implements Runnable
{
  public ReadInjoyTextView$1$2(lsu paramlsu) {}
  
  public void run()
  {
    this.a.a.setText(lst.a(this.a.a, this.a.val$content, kxm.ew(ReadInJoyUserInfoModule.getDefaultNickName())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.1.2
 * JD-Core Version:    0.7.0.1
 */