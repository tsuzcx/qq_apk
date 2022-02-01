package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import anpc;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import kbp;
import org.json.JSONObject;

public final class ReadInJoyUtils$4
  implements Runnable
{
  public ReadInJoyUtils$4(HashMap paramHashMap, boolean paramBoolean, Context paramContext, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.val$data.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(" ");
      }
      QLog.d("Q.readinjoy.video", 2, "reportKandianVideoInfo, success =" + this.val$success + ", data=" + ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap(this.val$data);
    anpc.a(this.val$context).collectPerformance(this.val$uin, "actKandianVideoWithExtraInfo", this.val$success, -1L, 0L, (HashMap)localObject, null);
    try
    {
      this.val$data.remove("param_speedList");
      label173:
      anpc.a(this.val$context).collectPerformance(this.val$uin, "actKandianVideo", this.val$success, -1L, 0L, this.val$data, null);
      try
      {
        kbp.a(null, null, "0X80096D9", "0X80096D9", 0, 0, "", "", "", new JSONObject(this.val$data).toString(), false);
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      break label173;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.4
 * JD-Core Version:    0.7.0.1
 */