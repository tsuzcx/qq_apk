package com.tencent.mobileqq.intervideo;

import aiby;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IVPluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<IVPluginInfo> CREATOR = new aiby();
  public int authType = 1;
  public String bMH;
  public String bMI;
  public String bMJ;
  public String bMK = "";
  public String bML;
  public String bMM;
  public int dcW;
  public int dcX;
  public String extra;
  public Bundle mExtras;
  public String mOpenType;
  public String mPackageName;
  public long mRoomId;
  public String mScheme;
  public String mSign;
  
  public IVPluginInfo() {}
  
  public IVPluginInfo(Parcel paramParcel)
  {
    this.bMH = paramParcel.readString();
    this.bMI = paramParcel.readString();
    this.mPackageName = paramParcel.readString();
    this.mRoomId = paramParcel.readLong();
    this.bMJ = paramParcel.readString();
    this.bMK = paramParcel.readString();
    this.authType = paramParcel.readInt();
    this.mExtras = paramParcel.readBundle(getClass().getClassLoader());
    this.mScheme = paramParcel.readString();
    this.dcW = paramParcel.readInt();
    this.bML = paramParcel.readString();
    this.bMM = paramParcel.readString();
    this.dcX = paramParcel.readInt();
    this.mOpenType = paramParcel.readString();
    this.extra = paramParcel.readString();
    this.mSign = paramParcel.readString();
  }
  
  public static Map<String, IVPluginInfo> ao()
  {
    HashMap localHashMap = new HashMap();
    IVPluginInfo localIVPluginInfo1 = new IVPluginInfo();
    localIVPluginInfo1.authType = 1;
    localIVPluginInfo1.bMH = "Hy";
    localIVPluginInfo1.mPackageName = "com.tencent.huayang";
    localIVPluginInfo1.bMI = "1600000419";
    IVPluginInfo localIVPluginInfo2 = new IVPluginInfo();
    localIVPluginInfo2.authType = 2;
    localIVPluginInfo2.bMH = "Od";
    localIVPluginInfo2.mPackageName = "com.tencent.od";
    localIVPluginInfo2.bMI = "1104763709";
    localIVPluginInfo2.bMK = "54";
    IVPluginInfo localIVPluginInfo3 = new IVPluginInfo();
    localIVPluginInfo3.authType = 2;
    localIVPluginInfo3.bMH = "Od";
    localIVPluginInfo3.mPackageName = "com.tencent.gvideo";
    localIVPluginInfo3.bMI = "1104763709";
    localIVPluginInfo3.bMK = "1";
    IVPluginInfo localIVPluginInfo4 = new IVPluginInfo();
    localIVPluginInfo3.authType = 2;
    localIVPluginInfo3.bMH = "Od";
    localIVPluginInfo3.mPackageName = "com.tencent.huiyin";
    localIVPluginInfo3.bMI = "1104763709";
    localIVPluginInfo3.bMK = "100";
    localHashMap.put(localIVPluginInfo1.mPackageName, localIVPluginInfo1);
    localHashMap.put(localIVPluginInfo2.mPackageName, localIVPluginInfo2);
    localHashMap.put(localIVPluginInfo3.mPackageName, localIVPluginInfo3);
    localHashMap.put(localIVPluginInfo4.mPackageName, localIVPluginInfo4);
    return localHashMap;
  }
  
  public static Map<String, IVPluginInfo> s(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramString.getJSONObject(str);
        IVPluginInfo localIVPluginInfo = new IVPluginInfo();
        localIVPluginInfo.authType = localJSONObject.optInt("authType");
        localIVPluginInfo.mPackageName = localJSONObject.optString("packageName");
        localIVPluginInfo.bMK = localJSONObject.optString("fromId");
        localIVPluginInfo.bMH = localJSONObject.optString("pluginid");
        localIVPluginInfo.bMI = localJSONObject.optString("loginAppId");
        localIVPluginInfo.mOpenType = localJSONObject.optString("openType");
        localIVPluginInfo.extra = localJSONObject.optString("extra");
        localIVPluginInfo.mRoomId = localJSONObject.optInt("roomId");
        localIVPluginInfo.mSign = localJSONObject.optString("sign");
        localHashMap.put(str, localIVPluginInfo);
      }
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bMH);
    paramParcel.writeString(this.bMI);
    paramParcel.writeString(this.mPackageName);
    paramParcel.writeLong(this.mRoomId);
    paramParcel.writeString(this.bMJ);
    paramParcel.writeString(this.bMK);
    paramParcel.writeInt(this.authType);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeString(this.mScheme);
    paramParcel.writeInt(this.dcW);
    paramParcel.writeString(this.bML);
    paramParcel.writeString(this.bMM);
    paramParcel.writeInt(this.dcX);
    paramParcel.writeString(this.mOpenType);
    paramParcel.writeString(this.extra);
    paramParcel.writeString(this.mSign);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVPluginInfo
 * JD-Core Version:    0.7.0.1
 */