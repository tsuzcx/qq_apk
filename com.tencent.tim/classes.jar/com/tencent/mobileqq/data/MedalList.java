package com.tencent.mobileqq.data;

import MQQ.VipMedalInfo;
import MQQ.VipMedalList;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MedalList
{
  public ArrayList<Info> infoList = new ArrayList();
  public String jumpUrl;
  
  public static MedalList parse(@NonNull VipMedalList paramVipMedalList)
  {
    MedalList localMedalList = new MedalList();
    int i = 0;
    while (i < paramVipMedalList.medalInfo.size())
    {
      Info localInfo = new Info();
      localInfo.type = ((VipMedalInfo)paramVipMedalList.medalInfo.get(i)).type;
      localInfo.value = ((VipMedalInfo)paramVipMedalList.medalInfo.get(i)).value;
      localMedalList.infoList.add(localInfo);
      i += 1;
    }
    localMedalList.jumpUrl = paramVipMedalList.jumpUrl;
    return localMedalList;
  }
  
  public static MedalList parse(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new JSONObject(paramString);
    JSONArray localJSONArray = paramString.optJSONArray("l");
    MedalList localMedalList = new MedalList();
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        Info localInfo = new Info();
        localInfo.type = localJSONObject.optInt("t");
        localInfo.value = localJSONObject.getString("v");
        localMedalList.infoList.add(localInfo);
        i += 1;
      }
    }
    localMedalList.jumpUrl = paramString.optString("j");
    return localMedalList;
  }
  
  public String convert()
    throws JSONException
  {
    if (this.infoList.size() == 0) {
      return "";
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.infoList.size())
    {
      Info localInfo = (Info)this.infoList.get(i);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("t", localInfo.type);
      localJSONObject2.put("v", localInfo.value);
      localJSONArray.put(localJSONObject2);
      i += 1;
    }
    localJSONObject1.put("l", localJSONArray);
    if (!TextUtils.isEmpty(this.jumpUrl)) {
      localJSONObject1.put("j", this.jumpUrl);
    }
    return localJSONObject1.toString();
  }
  
  public static class Info
  {
    public int type;
    public String value;
    
    public String toString()
    {
      return "Info{type=" + this.type + ", value='" + this.value + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MedalList
 * JD-Core Version:    0.7.0.1
 */