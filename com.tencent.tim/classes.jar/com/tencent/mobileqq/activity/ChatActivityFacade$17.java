package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import ausj;
import auss;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import ujt;
import ujv;

public final class ChatActivityFacade$17
  implements Runnable
{
  public ChatActivityFacade$17(Context paramContext, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ujt.U = (ausj)auss.a(this.I, null);
    ujt.qn = this.qo;
    String str = this.I.getResources().getString(2131698325);
    ujt.U.setMainTitle(str);
    ujt.U.addButton(2131692505, 3);
    ujt.U.addCancelButton(2131721058);
    ujt.U.a(new ujv(this));
    ujt.U.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.17
 * JD-Core Version:    0.7.0.1
 */