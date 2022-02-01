package com.tencent.biz.pubaccount.readinjoy.common;

import anpc;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public final class ReadInJoyUtils$7
  implements Runnable
{
  public ReadInJoyUtils$7(JSONObject paramJSONObject, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.val$jsonObject.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, this.val$jsonObject.optString(str));
      }
      anpc.a(this.val$app.getApplication()).collectPerformance(null, "actKanDianViolaPageDataNew", this.val$success, -1L, -1L, localException, null, true);
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyUtils", 2, "reportViolaPageProcessNew , error : " + localException.getMessage());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.7
 * JD-Core Version:    0.7.0.1
 */