package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$36
  implements Func1<JSONObject, Observable<JSONObject>>
{
  SendMailManager$36(SendMailManager paramSendMailManager, AtomicBoolean paramAtomicBoolean) {}
  
  public Observable<JSONObject> call(JSONObject paramJSONObject)
  {
    return SendMailManager.access$400(this.this$0, paramJSONObject, this.val$isAbort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.36
 * JD-Core Version:    0.7.0.1
 */