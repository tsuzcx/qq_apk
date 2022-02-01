package com.tencent.mobileqq.apollo;

import abjc;
import abkv;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;

public class SettingMeApolloViewController$5$1
  implements Runnable
{
  public SettingMeApolloViewController$5$1(abjc paramabjc, int paramInt, ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.a == null) {
      return;
    }
    if (this.cpo == 1)
    {
      this.a.this$0.a.a(SettingMeApolloViewController.a(this.a.this$0), this.cc.getContext(), this.val$app);
      return;
    }
    if (this.cpo == 2)
    {
      this.a.this$0.a.b(SettingMeApolloViewController.a(this.a.this$0), this.cc.getContext(), this.val$app);
      return;
    }
    SettingMeApolloViewController.a(this.a.this$0, this.bgz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController.5.1
 * JD-Core Version:    0.7.0.1
 */