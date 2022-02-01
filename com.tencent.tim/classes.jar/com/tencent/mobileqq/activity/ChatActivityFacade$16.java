package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import ausj;
import auss;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import ujt;
import uju;

public final class ChatActivityFacade$16
  implements Runnable
{
  public ChatActivityFacade$16(Context paramContext, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ujt.T = (ausj)auss.a(this.I, null);
    ujt.d = this.b;
    String str = this.I.getResources().getString(2131698325);
    ujt.T.setMainTitle(str);
    ujt.T.addButton(2131692505, 3);
    ujt.T.addCancelButton(2131721058);
    ujt.T.a(new uju(this));
    ujt.T.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.16
 * JD-Core Version:    0.7.0.1
 */