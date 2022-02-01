package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$12
  implements Func1<List<FtnUploadInfo>, Observable<List<FtnUploadInfo>>>
{
  SendMailManager$12(SendMailManager paramSendMailManager) {}
  
  public Observable<List<FtnUploadInfo>> call(List<FtnUploadInfo> paramList)
  {
    Log.d(SendMailManager.access$100(), "getList");
    return SendMailManager.access$900(this.this$0, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.12
 * JD-Core Version:    0.7.0.1
 */