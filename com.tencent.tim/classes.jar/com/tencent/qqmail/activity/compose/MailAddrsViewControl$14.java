package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.observer.ICallBack;
import java.util.HashMap;

class MailAddrsViewControl$14
  implements ICallBack
{
  MailAddrsViewControl$14(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public void callback(Object paramObject)
  {
    try
    {
      Object localObject = (HashMap)paramObject;
      paramObject = (String)((HashMap)localObject).get("address");
      String str1 = (String)((HashMap)localObject).get("name");
      String str2 = (String)((HashMap)localObject).get("mark");
      long l = Long.parseLong((String)((HashMap)localObject).get("contactId"));
      localObject = new MailContact();
      ((MailContact)localObject).setName(str1);
      ((MailContact)localObject).setNick(str1);
      ((MailContact)localObject).setAddress(paramObject);
      ((MailContact)localObject).setMark(str2);
      ((MailContact)localObject).setId(l);
      this.this$0.insertMailAddr((MailContact)localObject);
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.14
 * JD-Core Version:    0.7.0.1
 */