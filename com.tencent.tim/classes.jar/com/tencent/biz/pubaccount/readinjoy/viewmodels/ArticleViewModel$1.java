package com.tencent.biz.pubaccount.readinjoy.viewmodels;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import lsy;
import mqq.os.MqqHandler;
import nte;

public class ArticleViewModel$1
  implements Runnable
{
  public void run()
  {
    CharSequence localCharSequence = lsy.a((ArticleInfo)nte.a(this.this$0));
    ThreadManager.getUIHandler().post(new ArticleViewModel.1.1(this, localCharSequence));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel.1
 * JD-Core Version:    0.7.0.1
 */