package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class MessengerService$3
  extends CardObserver
{
  MessengerService$3(MessengerService paramMessengerService) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    int j = -1;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramBoolean)
    {
      str1 = str2;
      i = j;
      if (paramObject != null)
      {
        if (!(paramObject instanceof Card)) {
          break label157;
        }
        i = 0;
        str1 = str2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "onSetCardTemplateReturn...resultCode=" + i);
      }
      if (MessengerService.access$1800(this.this$0) != null)
      {
        paramObject = new Bundle();
        MessengerService.access$1800(this.this$0).putString("cmd", "card_setSummaryCard");
        paramObject.putInt("result", i);
        paramObject.putString("message", str1);
        MessengerService.access$1800(this.this$0).putBundle("response", paramObject);
        this.this$0.onRespToClient(MessengerService.access$1800(this.this$0));
        MessengerService.access$1802(this.this$0, null);
      }
      return;
      label157:
      str1 = str2;
      i = j;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        i = ((Integer)paramObject.first).intValue();
        str1 = (String)paramObject.second;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.3
 * JD-Core Version:    0.7.0.1
 */