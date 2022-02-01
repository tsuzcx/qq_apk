package com.tencent.qqmail.account.model;

import com.tencent.qqmail.utilities.log.QMLogStream;

final class MailAccount$3
  implements Runnable
{
  MailAccount$3(Account paramAccount) {}
  
  public void run()
  {
    QMLogStream.logWithoutUma(-40035, "recvpwdempty:" + this.val$account.getEmail() + "#md5", "Event_Error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.MailAccount.3
 * JD-Core Version:    0.7.0.1
 */