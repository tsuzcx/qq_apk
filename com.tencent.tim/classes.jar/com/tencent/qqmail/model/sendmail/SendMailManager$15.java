package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$15
  implements Func1<Void, Observable<List<FtnUploadInfo>>>
{
  SendMailManager$15(SendMailManager paramSendMailManager, List paramList) {}
  
  public Observable<List<FtnUploadInfo>> call(Void paramVoid)
  {
    return Observable.create(new SendMailManager.15.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.15
 * JD-Core Version:    0.7.0.1
 */