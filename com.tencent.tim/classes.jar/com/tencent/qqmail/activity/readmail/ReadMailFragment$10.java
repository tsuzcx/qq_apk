package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.watcher.ReadMailDefaultWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$10
  implements ReadMailDefaultWatcher
{
  ReadMailFragment$10(ReadMailFragment paramReadMailFragment) {}
  
  public void onConvChildSuccess(long paramLong1, long paramLong2) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    ReadMailFragment.access$3300(this.this$0, paramLong);
    if (ReadMailFragment.access$400(this.this$0) == paramLong)
    {
      QMLog.log(6, "ReadMailFragment", "load mail error:" + paramLong + ", error:" + paramQMNetworkError.getCode() + "," + paramQMNetworkError.getMessage());
      ReadMailFragment.access$4600(this.this$0, new ReadMailFragment.10.3(this, paramLong, paramQMNetworkError));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(ReadMailFragment.access$200(this.this$0));
    if (localAccount != null)
    {
      if (localAccount.isQQMail()) {
        localStringBuilder.append("1;");
      }
    }
    else
    {
      if (paramQMNetworkError == null) {
        break label292;
      }
      if (!(paramQMNetworkError instanceof QMCGIError)) {
        break label267;
      }
      paramQMNetworkError = (QMCGIError)paramQMNetworkError;
      localStringBuilder.append(paramQMNetworkError.appCode).append(";").append(paramQMNetworkError.cgiName).append(";").append(paramQMNetworkError.desp);
      label185:
      QMLogStream.logWithoutUmaNow(-40018, localStringBuilder.toString(), "Event_Error");
      DataCollector.logDetailEvent("DetailEvent_ReadMail", ReadMailFragment.access$200(this.this$0), 1L, localStringBuilder.toString());
    }
    for (;;)
    {
      QMLog.log(6, "ReadMailFragment", "readMailWatcher onError: " + paramLong + ", " + localStringBuilder.toString());
      return;
      localStringBuilder.append("2;");
      break;
      label267:
      localStringBuilder.append(paramQMNetworkError.code).append(";").append(paramQMNetworkError.desp);
      break label185;
      label292:
      DataCollector.logDetailEvent("DetailEvent_ReadMail", ReadMailFragment.access$200(this.this$0), 1L, localStringBuilder.toString());
    }
  }
  
  public void onLocalSuccess(Mail paramMail)
  {
    if ((paramMail.getInformation().getId() == ReadMailFragment.access$400(this.this$0)) && (ReadMailFragment.access$000(this.this$0) != null))
    {
      QMLog.log(4, "ReadMailFragment", "load local mail success : " + ReadMailFragment.access$400(this.this$0) + "; " + paramMail.getStatus().isLoaded());
      ReadMailFragment.access$000(this.this$0).setContent(paramMail.getContent());
      ReadMailFragment.access$000(this.this$0).setIcsEvent(paramMail.getIcsEvent());
      ReadMailFragment.access$3200(this.this$0, new ReadMailFragment.10.1(this));
    }
  }
  
  public void onProcess(long paramLong1, long paramLong2, long paramLong3)
  {
    ReadMailFragment.access$4900(this.this$0, new ReadMailFragment.10.4(this, paramLong1));
  }
  
  public void onSuccess(long paramLong)
  {
    ReadMailFragment.access$3300(this.this$0, paramLong);
    if ((ReadMailFragment.access$3400(this.this$0) != null) && (ReadMailFragment.access$3400(this.this$0).getType() == 3) && (paramLong != ReadMailFragment.access$400(this.this$0))) {
      ReadMailFragment.access$402(this.this$0, paramLong);
    }
    if (paramLong == ReadMailFragment.access$400(this.this$0))
    {
      ReadMailFragment.access$3500(this.this$0);
      QMLog.log(4, "ReadMailFragment", "load mail success : " + ReadMailFragment.access$000(this.this$0).getInformation().getId() + "; " + ReadMailFragment.access$000(this.this$0).getStatus().isLoaded() + "; " + ReadMailFragment.access$2900(this.this$0, true));
      if ((ReadMailFragment.access$2400(this.this$0) != null) && (ReadMailFragment.access$2400(this.this$0).getStatus() != 0) && ((ReadMailFragment.access$3600(this.this$0) > 0) || (ReadMailFragment.access$3700(this.this$0) > 0)))
      {
        QMLog.log(4, "ReadMailFragment", "load mail success error1");
        ReadMailFragment.access$3800(this.this$0);
      }
      if (!ReadMailFragment.access$3900(this.this$0)) {
        break label257;
      }
    }
    for (;;)
    {
      QMLog.log(4, "ReadMailFragment", "readMailWatcher onSuccess:" + paramLong + "," + ReadMailFragment.access$4100(this.this$0));
      return;
      label257:
      ReadMailFragment.access$4000(this.this$0, new ReadMailFragment.10.2(this, paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.10
 * JD-Core Version:    0.7.0.1
 */