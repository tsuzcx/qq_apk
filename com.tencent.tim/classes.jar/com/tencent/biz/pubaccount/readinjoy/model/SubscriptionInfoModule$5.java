package com.tencent.biz.pubaccount.readinjoy.model;

import aalb;
import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import liz;
import oan;
import ocp;

public class SubscriptionInfoModule$5
  implements Runnable
{
  public SubscriptionInfoModule$5(liz paramliz, String paramString, Context paramContext) {}
  
  public void run()
  {
    oan.a().a(this.val$uin, (QQAppInterface)this.this$0.mApp, this.val$context, liz.a(this.this$0));
    int i = ocp.e((QQAppInterface)this.this$0.mApp, this.val$uin);
    aalb.l((QQAppInterface)this.this$0.mApp, this.val$uin, i);
    ((QQAppInterface)this.this$0.mApp).b().ca(this.val$uin, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.5
 * JD-Core Version:    0.7.0.1
 */