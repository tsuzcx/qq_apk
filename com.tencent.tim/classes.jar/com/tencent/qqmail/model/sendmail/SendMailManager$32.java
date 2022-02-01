package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$32
  implements Func1<List<JSONObject>, Observable<JSONObject>>
{
  SendMailManager$32(SendMailManager paramSendMailManager, AtomicInteger paramAtomicInteger) {}
  
  public Observable<JSONObject> call(List<JSONObject> paramList)
  {
    this.val$step.set(6);
    return Observable.from(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.32
 * JD-Core Version:    0.7.0.1
 */