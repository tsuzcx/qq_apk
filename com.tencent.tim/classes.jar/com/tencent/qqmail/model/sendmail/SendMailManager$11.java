package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$11
  implements Func1<List<FtnUploadInfo>, Observable<Void>>
{
  SendMailManager$11(SendMailManager paramSendMailManager, ArrayList paramArrayList) {}
  
  public Observable<Void> call(List<FtnUploadInfo> paramList)
  {
    return SendMailManager.access$800(this.this$0, paramList, this.val$attachNeedFtnUpload);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.11
 * JD-Core Version:    0.7.0.1
 */