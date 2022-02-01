package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.Ftn.ShowUsrOutput;
import com.tencent.qqmail.model.mail.watcher.FtnQueryAccountWatcher;
import java.util.HashMap;

class FtnListActivity$2
  implements FtnQueryAccountWatcher
{
  FtnListActivity$2(FtnListActivity paramFtnListActivity) {}
  
  public void onError()
  {
    FtnListActivity.access$400(this.this$0);
  }
  
  public void onSuccess(HashMap<String, Object> paramHashMap)
  {
    paramHashMap = (ShowUsrOutput)paramHashMap.get("paramqueryaccountinfo");
    FtnListActivity.access$300(this.this$0, paramHashMap.expiredays, paramHashMap.storeday, paramHashMap.fsizelimit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.2
 * JD-Core Version:    0.7.0.1
 */