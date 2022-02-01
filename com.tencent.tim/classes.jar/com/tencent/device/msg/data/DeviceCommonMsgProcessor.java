package com.tencent.device.msg.data;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONArray;
import org.json.JSONObject;
import szy;

public class DeviceCommonMsgProcessor
{
  static String a(a parama1, a parama2)
  {
    if ((parama1 == null) || (parama2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"");
    localStringBuilder.append(parama1.key);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(parama1.value);
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("\"");
    localStringBuilder.append(parama2.key);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(parama2.value);
    localStringBuilder.append("\"");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static void c(Session paramSession, boolean paramBoolean)
  {
    try
    {
      new TaskRunnable(paramSession, paramBoolean).start();
      return;
    }
    catch (Throwable paramSession)
    {
      paramSession.printStackTrace();
    }
  }
  
  static class TaskRunnable
    implements Runnable
  {
    public Session a;
    public boolean aOi;
    
    public TaskRunnable(Session paramSession, boolean paramBoolean)
    {
      this.a = paramSession;
      this.aOi = paramBoolean;
    }
    
    public void run()
    {
      if ((this.a == null) || (this.a.actionInfo == null)) {
        return;
      }
      for (;;)
      {
        try
        {
          JSONArray localJSONArray = new JSONObject(new String(this.a.actionInfo.vServiceInfo)).getJSONArray("datapoint");
          if (localJSONArray == null) {
            break;
          }
          int j = localJSONArray.length();
          if (j <= 0) {
            break;
          }
          int i = 0;
          if (i >= j) {
            break;
          }
          try
          {
            localObject2 = localJSONArray.getJSONObject(i);
            localDataPoint = new DataPoint(((JSONObject)localObject2).optString("apiName"), ((JSONObject)localObject2).optInt("id"), ((JSONObject)localObject2).optString("type"), ((JSONObject)localObject2).optString("value"));
            localDataPoint.mSeq = ((JSONObject)localObject2).optString("seq", "0");
            localDataPoint.mDin = ((JSONObject)localObject2).optLong("din");
            if ((szy.aIl.equalsIgnoreCase(this.a.actionInfo.strServiceName)) || (szy.aIm.equalsIgnoreCase(this.a.actionInfo.strServiceName)) || (szy.aIp.equalsIgnoreCase(this.a.actionInfo.strServiceName)))
            {
              boolean bool = TextUtils.isEmpty(localDataPoint.mValue);
              if (!bool) {
                continue;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Object localObject2;
              DataPoint localDataPoint;
              Object localObject1;
              Object localObject3;
              DeviceCommonMsgProcessor.a locala;
              localException2.printStackTrace();
              continue;
              String str = "1";
            }
          }
          i += 1;
          continue;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject1 = null;
          continue;
          localObject3 = new DeviceCommonMsgProcessor.a();
          ((DeviceCommonMsgProcessor.a)localObject3).key = "path";
          ((DeviceCommonMsgProcessor.a)localObject3).value = localDataPoint.mValue;
          locala = new DeviceCommonMsgProcessor.a();
          locala.key = "ret";
          if (!this.aOi) {
            break label370;
          }
        }
        localObject2 = "0";
        locala.value = ((String)localObject2);
        localDataPoint.mValue = DeviceCommonMsgProcessor.a((DeviceCommonMsgProcessor.a)localObject3, locala);
        localObject2 = new Intent();
        ((Intent)localObject2).setAction("SmartDevice_receiveDPMsg");
        localObject3 = new Bundle();
        ((Bundle)localObject3).putParcelable("dataPoint", localDataPoint);
        ((Intent)localObject2).putExtras((Bundle)localObject3);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject2, "com.tencent.tim.smartdevice.permission.broadcast");
      }
    }
    
    public void start()
    {
      ThreadManager.post(this, 8, null, false);
    }
  }
  
  static class a
  {
    public String key;
    public String value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceCommonMsgProcessor
 * JD-Core Version:    0.7.0.1
 */