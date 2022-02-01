package com.tencent.qqmail.activity.compose;

import android.widget.Button;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.observer.ICallBack;
import java.util.ArrayList;
import java.util.LinkedList;

class MailAddrsViewControl$12
  implements ICallBack
{
  MailAddrsViewControl$12(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public void callback(Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = 0;
    if (i < MailAddrsViewControl.access$800(this.this$0).size())
    {
      String str = ((MailContact)MailAddrsViewControl.access$800(this.this$0).get(i)).getAddress();
      Button localButton = (Button)MailAddrsViewControl.access$1900(this.this$0).get(i);
      if (paramObject.contains(str))
      {
        localButton.setBackgroundResource(2130850487);
        localButton.setTag(2131365133, Boolean.valueOf(false));
        if (i == 0) {
          this.this$0.requestInputAreaFocus();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localButton.setBackgroundResource(2130850489);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.12
 * JD-Core Version:    0.7.0.1
 */