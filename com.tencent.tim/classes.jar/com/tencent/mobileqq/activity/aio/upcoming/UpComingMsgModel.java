package com.tencent.mobileqq.activity.aio.upcoming;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpComingMsgModel
  implements Serializable
{
  public boolean exposed;
  public String frienduin;
  public int istroop;
  public String nickName;
  public int reportType;
  public String troopUin;
  public int type;
  public List<Long> uniseq;
  
  public UpComingMsgModel() {}
  
  public UpComingMsgModel(String paramString1, String paramString2, List<Long> paramList, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.frienduin = paramString1;
    this.uniseq = new ArrayList(paramList);
    this.istroop = paramInt1;
    this.type = paramInt2;
    this.reportType = paramInt3;
    this.nickName = paramString3;
    this.troopUin = paramString2;
  }
  
  public UpComingMsgModel parseFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.frienduin = paramString.optString("key_uin");
      this.istroop = paramString.optInt("key_session_type");
      this.reportType = paramString.optInt("key_report_type");
      this.nickName = paramString.optString("key_nick_name");
      this.troopUin = paramString.optString("key_troop_uin");
      JSONArray localJSONArray = paramString.optJSONArray("key_uniseq");
      this.uniseq = new ArrayList(localJSONArray.length());
      int i = 0;
      while (i < localJSONArray.length())
      {
        this.uniseq.add(Long.valueOf(localJSONArray.optLong(i)));
        i += 1;
      }
      this.type = paramString.optInt("key_from_type");
      if (QLog.isColorLevel()) {
        QLog.d("UpComingMsgLogic.UpComingMsgModel", 2, "parseFromJson info: " + toString());
      }
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public String toJson()
  {
    Object localObject1;
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("key_uin", this.frienduin);
      ((JSONObject)localObject1).put("key_session_type", this.istroop);
      ((JSONObject)localObject1).put("key_report_type", this.reportType);
      ((JSONObject)localObject1).put("key_nick_name", this.nickName);
      ((JSONObject)localObject1).put("key_troop_uin", this.troopUin);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.uniseq.iterator();
      while (localIterator.hasNext())
      {
        localJSONArray.put((Long)localIterator.next());
        continue;
        localException1.printStackTrace();
      }
    }
    catch (Exception localException1)
    {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      for (;;)
      {
        return localObject2;
        ((JSONObject)localObject1).put("key_uniseq", localObject2);
        ((JSONObject)localObject1).put("key_from_type", this.type);
        localObject1 = ((JSONObject)localObject1).toString();
        localObject2 = localObject1;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("UpComingMsgLogic.UpComingMsgModel", 2, "toJsonStr json: " + (String)localObject1);
            return localObject1;
          }
        }
        catch (Exception localException2) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel
 * JD-Core Version:    0.7.0.1
 */