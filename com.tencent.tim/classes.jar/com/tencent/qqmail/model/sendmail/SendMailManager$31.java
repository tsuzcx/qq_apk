package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$31
  implements Func1<JSONObject, Observable<JSONObject>>
{
  SendMailManager$31(SendMailManager paramSendMailManager, int paramInt1, int paramInt2) {}
  
  public Observable<JSONObject> call(JSONObject paramJSONObject)
  {
    return SendMailManager.access$1600(this.this$0, paramJSONObject, this.val$taskId, this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.31
 * JD-Core Version:    0.7.0.1
 */