package com.tencent.mobileqq.apollo.trace.sdk.data;

import abwx;
import abwz;
import abxa;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class TraceData
  extends Entity
  implements Serializable
{
  @notColumn
  public int endJavaHeap;
  @notColumn
  public int endNativeHeap;
  public int extra1;
  public int extra2;
  public int extra3;
  public int featureId;
  @notColumn
  public String featureKey;
  @notColumn
  public int initJavaHeap;
  @notColumn
  public int initNativeHeap;
  @notColumn
  public boolean isSampleFocus;
  @notColumn
  public BlockingQueue<abxa> mSpanQueue;
  public String packData;
  @notColumn
  public abwz result;
  public long serverTime;
  @notColumn
  public long startTime;
  public String tUid;
  public long timestamp;
  @unique
  public long traceId;
  public String uid;
  public String version;
  
  private abwz getResultData(JSONObject paramJSONObject)
    throws Exception
  {
    abwz localabwz = new abwz();
    localabwz.errCode = paramJSONObject.optInt("errCode");
    localabwz.amq = paramJSONObject.optInt("cost");
    localabwz.cti = paramJSONObject.optInt("cpu");
    localabwz.cth = paramJSONObject.optInt("memory");
    localabwz.netType = paramJSONObject.optInt("netType");
    localabwz.ctj = paramJSONObject.optInt("javaHeap");
    localabwz.ctk = paramJSONObject.optInt("nativeHeap");
    return localabwz;
  }
  
  private JSONObject getResultObject(abwz paramabwz)
    throws Exception
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", paramabwz.errCode);
    localJSONObject.put("cost", paramabwz.amq);
    localJSONObject.put("memory", paramabwz.cth);
    localJSONObject.put("cpu", paramabwz.cti);
    localJSONObject.put("netType", paramabwz.netType);
    localJSONObject.put("javaHeap", paramabwz.ctj);
    localJSONObject.put("nativeHeap", paramabwz.ctk);
    return localJSONObject;
  }
  
  public void postRead()
  {
    try
    {
      super.postRead();
      Object localObject1 = new JSONObject(this.packData);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("resultObject");
      if (localObject2 != null) {
        this.result = getResultData((JSONObject)localObject2);
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("spanArray");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        this.mSpanQueue = new LinkedBlockingQueue();
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          localObject2 = new abxa(((JSONObject)localObject3).optInt("spanId"));
          ((abxa)localObject2).timestamp = ((JSONObject)localObject3).optLong("timestamp");
          ((abxa)localObject2).serverTime = ((JSONObject)localObject3).optLong("serverTime");
          ((abxa)localObject2).result = getResultData(((JSONObject)localObject3).optJSONObject("resultObject"));
          Object localObject4 = ((JSONObject)localObject3).optJSONArray("annoArray");
          int j;
          if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
          {
            ((abxa)localObject2).l = new LinkedBlockingQueue();
            j = 0;
            while (j < ((JSONArray)localObject4).length())
            {
              Object localObject5 = ((JSONArray)localObject4).optJSONObject(j);
              localObject5 = new abwx(((JSONObject)localObject5).optString("msg"), ((JSONObject)localObject5).optLong("timestamp"), ((JSONObject)localObject5).optLong("serverTime"));
              ((abxa)localObject2).l.offer(localObject5);
              j += 1;
            }
          }
          localObject3 = ((JSONObject)localObject3).optJSONArray("extArray");
          if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
          {
            ((abxa)localObject2).je = new HashMap();
            j = 0;
            while (j < ((JSONArray)localObject3).length())
            {
              localObject4 = ((JSONArray)localObject3).optJSONObject(j);
              int k = ((JSONObject)localObject4).optInt("extKey" + j);
              long l = ((JSONObject)localObject4).optLong("extKey" + j);
              ((abxa)localObject2).je.put(Integer.valueOf(k), Long.valueOf(l));
              j += 1;
            }
          }
          this.mSpanQueue.add(localObject2);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TraceReport", 1, "Exception:", localException);
    }
  }
  
  public void prewrite()
  {
    JSONArray localJSONArray1;
    for (;;)
    {
      JSONObject localJSONObject2;
      Object localObject1;
      JSONArray localJSONArray2;
      Object localObject2;
      Object localObject3;
      try
      {
        super.prewrite();
        JSONObject localJSONObject1 = new JSONObject();
        if (this.result != null) {
          localJSONObject1.put("resultObject", getResultObject(this.result));
        }
        if ((this.mSpanQueue == null) || (this.mSpanQueue.size() <= 0)) {
          break label491;
        }
        localJSONArray1 = new JSONArray();
        localJSONObject2 = new JSONObject();
        Iterator localIterator = this.mSpanQueue.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (abxa)localIterator.next();
        localJSONObject2.put("spanId", ((abxa)localObject1).ctl);
        localJSONObject2.put("timestamp", ((abxa)localObject1).timestamp);
        localJSONObject2.put("serverTime", ((abxa)localObject1).serverTime);
        localJSONObject2.put("resultObject", getResultObject(((abxa)localObject1).result));
        if ((((abxa)localObject1).l != null) && (((abxa)localObject1).l.size() > 0))
        {
          localJSONArray2 = new JSONArray();
          localObject2 = ((abxa)localObject1).l.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (abwx)((Iterator)localObject2).next();
            JSONObject localJSONObject3 = new JSONObject();
            localJSONObject3.put("timestamp", ((abwx)localObject3).timestamp);
            localJSONObject3.put("serverTime", ((abwx)localObject3).serverTime);
            localJSONObject3.put("msg", ((abwx)localObject3).msg);
            localJSONArray2.put(localJSONObject3);
            continue;
          }
          localJSONObject2.put("annoArray", localJSONArray2);
        }
      }
      catch (Exception localException)
      {
        QLog.e("TraceReport", 1, "Exception:", localException);
        return;
      }
      if ((((abxa)localObject1).je != null) && (((abxa)localObject1).je.size() > 0))
      {
        localJSONArray2 = new JSONArray();
        int i = 0;
        localObject1 = ((abxa)localObject1).je.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("extKey" + i, ((Map.Entry)localObject2).getKey());
          ((JSONObject)localObject3).put("extValue" + i, ((Map.Entry)localObject2).getValue());
          localJSONArray2.put(localObject3);
          i += 1;
        }
        localJSONObject2.put("extArray", localJSONArray2);
      }
      localJSONArray1.put(localJSONObject2);
    }
    localException.put("spanArray", localJSONArray1);
    label491:
    this.packData = localException.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{").append("feature:").append(this.featureId).append(",traceId:").append(this.traceId).append(",result:").append(this.result.toString());
    if (this.extra1 > 0) {
      localStringBuilder.append(",extra1:").append(this.extra1);
    }
    if (this.extra2 > 0) {
      localStringBuilder.append(",extra2:").append(this.extra2);
    }
    if (this.extra3 > 0) {
      localStringBuilder.append(",extra3:").append(this.extra3);
    }
    if (this.mSpanQueue != null)
    {
      Iterator localIterator = this.mSpanQueue.iterator();
      while (localIterator.hasNext())
      {
        abxa localabxa = (abxa)localIterator.next();
        localStringBuilder.append("\n").append(localabxa.toString());
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.trace.sdk.data.TraceData
 * JD-Core Version:    0.7.0.1
 */