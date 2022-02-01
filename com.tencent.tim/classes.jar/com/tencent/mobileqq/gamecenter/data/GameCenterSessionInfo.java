package com.tencent.mobileqq.gamecenter.data;

import ahru;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aofk;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterSessionInfo
  implements Parcelable, Comparable<GameCenterSessionInfo>
{
  public static final Parcelable.Creator<GameCenterSessionInfo> CREATOR = new ahru();
  public long aaO;
  public String bLA;
  public String bLw;
  public String bLx;
  public String bLy;
  public String bLz;
  public int daT;
  public int daU;
  public String faceUrl;
  String gameIcon;
  public String gameId;
  public String gameName;
  boolean isSend;
  public long lastMsgTime;
  public String nickName;
  public int requestCount;
  public String sessionId;
  public int sessionType;
  
  public int Fi()
  {
    return this.daT;
  }
  
  public void KA(String paramString)
  {
    this.bLw = paramString;
  }
  
  public void KB(String paramString)
  {
    this.bLx = paramString;
  }
  
  public void Kv(String paramString)
  {
    this.gameIcon = paramString;
  }
  
  public void Kw(String paramString)
  {
    this.bLA = paramString;
  }
  
  public void Kx(String paramString)
  {
    this.bLy = paramString;
  }
  
  public void Ky(String paramString)
  {
    this.gameId = paramString;
  }
  
  public void Ky(boolean paramBoolean)
  {
    this.isSend = paramBoolean;
  }
  
  public void Kz(String paramString)
  {
    this.faceUrl = paramString;
  }
  
  public void Pn(int paramInt)
  {
    this.requestCount = paramInt;
  }
  
  public void Po(int paramInt)
  {
    this.daT = paramInt;
  }
  
  public void Pp(int paramInt)
  {
    this.daU = paramInt;
  }
  
  public int a(@NonNull GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo.lastMsgTime > this.lastMsgTime) {
      return 1;
    }
    if (paramGameCenterSessionInfo.lastMsgTime < this.lastMsgTime) {
      return -1;
    }
    return 0;
  }
  
  public JSONObject aa()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sessionType", this.sessionType);
      localJSONObject.put("sessionId", this.sessionId);
      localJSONObject.put("gameId", this.gameId);
      localJSONObject.put("gameName", wy());
      localJSONObject.put("faceUrl", this.faceUrl);
      localJSONObject.put("nickName", getNickName());
      localJSONObject.put("firstMsg", new aofk(this.bLw, 6, 32, -1).AE());
      localJSONObject.put("firstMsgTime", this.aaO);
      localJSONObject.put("requestCount", this.requestCount);
      localJSONObject.put("lastMsg", new aofk(this.bLx, 6, 32, -1).AE());
      localJSONObject.put("lastMsgTime", this.lastMsgTime);
      localJSONObject.put("unreadMsg", this.daT);
      localJSONObject.put("onlineType", this.daU);
      localJSONObject.put("onlineDesc", this.bLA);
      localJSONObject.put("gameIcon", this.gameIcon);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("GameCenterSessionInfo", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void dpv()
  {
    this.requestCount += 1;
  }
  
  public long eI()
  {
    return this.lastMsgTime;
  }
  
  public String getNickName()
  {
    if (TextUtils.isEmpty(this.nickName)) {
      this.nickName = "游戏好友";
    }
    return this.nickName;
  }
  
  public int getRequestCount()
  {
    return this.requestCount;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public int getSessionType()
  {
    return this.sessionType;
  }
  
  public void jV(long paramLong)
  {
    this.aaO = paramLong;
  }
  
  public void jW(long paramLong)
  {
    this.lastMsgTime = paramLong;
  }
  
  public String pk()
  {
    return this.bLz;
  }
  
  public void setGameName(String paramString)
  {
    this.gameName = paramString;
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSessionType(int paramInt)
  {
    this.sessionType = paramInt;
  }
  
  public String toString()
  {
    return "GameCenterSessionInfo{sessionType=" + this.sessionType + ", sessionId='" + this.sessionId + '\'' + ", gameId='" + this.gameId + '\'' + ", gameName='" + this.gameName + '\'' + ", faceUrl='" + this.faceUrl + '\'' + ", nickName='" + this.nickName + '\'' + ", firstMsg='" + this.bLw + '\'' + ", firstMsgTime=" + this.aaO + ", requestCount=" + this.requestCount + ", lastMsg='" + this.bLx + '\'' + ", lastMsgTime=" + this.lastMsgTime + ", unreadMsg=" + this.daT + ", onlienType=" + this.daU + ", roleId='" + this.bLy + '\'' + ", myRoleId='" + this.bLz + '\'' + ", onLineDesc='" + this.bLA + '\'' + ", gameIcon='" + this.gameIcon + '\'' + '}';
  }
  
  public String wA()
  {
    return this.bLx;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.sessionType);
    paramParcel.writeString(this.sessionId);
    paramParcel.writeString(this.gameId);
    paramParcel.writeString(this.gameName);
    paramParcel.writeString(this.faceUrl);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.bLw);
    paramParcel.writeLong(this.aaO);
    paramParcel.writeInt(this.requestCount);
    paramParcel.writeString(this.bLx);
    paramParcel.writeLong(this.lastMsgTime);
    paramParcel.writeInt(this.daT);
    paramParcel.writeInt(this.daU);
    paramParcel.writeString(this.bLy);
    paramParcel.writeString(this.bLz);
    paramParcel.writeString(this.bLA);
  }
  
  public String wv()
  {
    return this.gameIcon;
  }
  
  public String ww()
  {
    return this.bLy;
  }
  
  public String wx()
  {
    return this.gameId;
  }
  
  public String wy()
  {
    if (TextUtils.isEmpty(this.gameName)) {
      this.gameName = "QQ手游";
    }
    return this.gameName;
  }
  
  public String wz()
  {
    return this.faceUrl;
  }
  
  public void xx(String paramString)
  {
    this.bLz = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo
 * JD-Core Version:    0.7.0.1
 */