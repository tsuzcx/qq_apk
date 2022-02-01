package com.tencent.qqmail.search.model;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import java.util.concurrent.Future;

public class SearchMailUI
  extends MailUI
{
  private static final long serialVersionUID = 2231249145491490983L;
  
  public SearchMailUI(Mail paramMail, long paramLong, long[] paramArrayOfLong, Future<long[]> paramFuture)
  {
    super(paramMail, 0L, paramLong);
    long l1 = l2;
    if (paramMail != null)
    {
      l1 = l2;
      if (paramMail.getInformation() != null) {
        l1 = paramMail.getInformation().getId();
      }
    }
    setTask(paramFuture);
    processRefrence(getMailIds(), l1, paramLong);
    processParentRefrence(getMailIds(), l1, paramLong);
  }
  
  public Mail getMail(long paramLong)
  {
    QMMailManager localQMMailManager = QMMailManager.sharedInstance();
    if (localQMMailManager.isRemoteSearchMail(paramLong)) {
      return localQMMailManager.readSearchMailInfo(paramLong);
    }
    return localQMMailManager.readMailInfo(paramLong, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.model.SearchMailUI
 * JD-Core Version:    0.7.0.1
 */