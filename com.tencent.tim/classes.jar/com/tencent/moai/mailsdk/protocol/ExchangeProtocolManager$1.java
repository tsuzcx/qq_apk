package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.model.Mail;
import java.util.Comparator;

final class ExchangeProtocolManager$1
  implements Comparator<Mail>
{
  public int compare(Mail paramMail1, Mail paramMail2)
  {
    if (paramMail2.getUtc() - paramMail1.getUtc() > 0L) {
      return 1;
    }
    if (paramMail2.getUtc() - paramMail1.getUtc() < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */