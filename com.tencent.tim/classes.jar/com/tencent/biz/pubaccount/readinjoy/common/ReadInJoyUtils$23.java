package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams;
import java.util.Iterator;
import java.util.List;
import kbp;
import org.json.JSONObject;

public final class ReadInJoyUtils$23
  implements Runnable
{
  public ReadInJoyUtils$23(int paramInt, long paramLong) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = Aladdin.get(139);
      if (localObject == null) {}
      for (;;)
      {
        kbp.a(null, "CliOper", "", "", "0X8009EB2", "0X8009EB2", 0, 0, String.valueOf(this.aMF), String.valueOf(this.val$timeCost), "1", localJSONObject.toString(), false);
        return;
        localObject = ((AladdinConfig)localObject).getList("param_list");
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SneakyParams localSneakyParams = (SneakyParams)((Iterator)localObject).next();
            localJSONObject.put(localSneakyParams.getPackageName(), localSneakyParams.toString());
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.23
 * JD-Core Version:    0.7.0.1
 */