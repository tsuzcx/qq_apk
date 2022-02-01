package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;
import apbn;
import apbo;
import apbq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

public class TroopFeedsDataManager$3$2
  implements Runnable
{
  public TroopFeedsDataManager$3$2(apbq paramapbq, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = apbn.a(this.bG, "" + this.a.this$0.aj, this.a.this$0.mApp.getCurrentAccountUin());
    List localList = (List)localObject1[0];
    localObject1 = (List)localObject1[1];
    if ((localList == null) || (localObject1 == null)) {
      return;
    }
    Object localObject2 = localList.toString();
    int i = localList.size() - 1;
    while (i >= 0)
    {
      String str = (String)localList.get(i);
      if (!this.a.this$0.ah.containsKey(str)) {
        localList.remove(str);
      }
      i -= 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "cgi callback ids, beforeFilter:" + (String)localObject2 + "|afterFilter ids:" + localList.toString());
    }
    this.a.this$0.ah.clear();
    localObject2 = this.a.this$0.mUIHandler.obtainMessage(4);
    ((Message)localObject2).obj = this.a.this$0.m(localList, (List)localObject1);
    this.a.this$0.mUIHandler.sendMessage((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.2
 * JD-Core Version:    0.7.0.1
 */