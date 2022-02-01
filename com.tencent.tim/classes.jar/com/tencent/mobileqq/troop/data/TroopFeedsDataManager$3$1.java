package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;
import apbn;
import apbo;
import apbq;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import org.json.JSONObject;

public class TroopFeedsDataManager$3$1
  implements Runnable
{
  public TroopFeedsDataManager$3$1(apbq paramapbq, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject = apbn.a(this.bG, "" + this.a.this$0.aj, this.a.this$0.mApp.getCurrentAccountUin());
    List localList = (List)localObject[0];
    localObject = (List)localObject[1];
    ((List)localObject).addAll(this.a.this$0.mItems);
    Message localMessage = this.a.this$0.mUIHandler.obtainMessage(3);
    localMessage.obj = this.a.this$0.m(localList, (List)localObject);
    this.a.this$0.mUIHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.1
 * JD-Core Version:    0.7.0.1
 */