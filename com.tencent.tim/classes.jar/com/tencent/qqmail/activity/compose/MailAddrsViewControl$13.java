package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.observer.ICallBack;
import java.util.HashMap;

class MailAddrsViewControl$13
  implements ICallBack
{
  MailAddrsViewControl$13(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public void callback(Object paramObject)
  {
    try
    {
      paramObject = (HashMap)paramObject;
      String str1 = (String)paramObject.get("oldAddress");
      String str2 = (String)paramObject.get("newAddress");
      String str3 = (String)paramObject.get("newName");
      String str4 = (String)paramObject.get("newMark");
      long l = Long.parseLong((String)paramObject.get("contactId"));
      this.this$0.updateNewEmail(str1, str2, str3, str4, l);
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.13
 * JD-Core Version:    0.7.0.1
 */