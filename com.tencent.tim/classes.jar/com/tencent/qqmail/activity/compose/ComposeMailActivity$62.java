package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.ASContact;
import com.tencent.qqmail.trd.guava.Function;

class ComposeMailActivity$62
  implements Function<ASContact, MailContact>
{
  ComposeMailActivity$62(ComposeMailActivity paramComposeMailActivity) {}
  
  public MailContact apply(ASContact paramASContact)
  {
    MailContact localMailContact = new MailContact();
    localMailContact.setAddress(paramASContact.email_address_);
    localMailContact.setName(paramASContact.display_name_);
    localMailContact.setNick(paramASContact.display_name_);
    localMailContact.setPinyin(paramASContact.display_name_);
    return localMailContact;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.62
 * JD-Core Version:    0.7.0.1
 */