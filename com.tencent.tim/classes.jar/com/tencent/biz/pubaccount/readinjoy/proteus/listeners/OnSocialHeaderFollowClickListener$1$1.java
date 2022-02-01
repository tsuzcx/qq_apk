package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import lcc;
import lqr;
import lqs;

public class OnSocialHeaderFollowClickListener$1$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$1$1(lqs paramlqs) {}
  
  public void run()
  {
    lqr.a(this.a.a).invalidateProteusTemplateBean();
    lcc.a().aCi();
    lcc.a().a(lqr.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */