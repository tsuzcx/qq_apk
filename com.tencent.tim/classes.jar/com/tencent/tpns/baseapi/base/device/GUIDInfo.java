package com.tencent.tpns.baseapi.base.device;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.Util;

public class GUIDInfo
{
  public int encrypt = 0;
  public int errCode;
  public long expiredSeconds = 0L;
  public long guid = 0L;
  public long guidLastAccessid = 0L;
  public String mqttPortList = "";
  public String mqttServer = "";
  public String mqttServerIP = "";
  public long mqttServerRefreshTime = 0L;
  public String passWord = "";
  public long refreshTime = 0L;
  public int refuseRate = 0;
  public String result = "";
  public String token = "";
  public String tokenList = "";
  public String userName = "";
  
  public static GUIDInfo getGuidInfoFromShar(Context paramContext)
  {
    GUIDInfo localGUIDInfo = new GUIDInfo();
    try
    {
      localGUIDInfo.guid = PushPreferences.getLong(paramContext, "XG_GUID_GUID", 0L);
      localGUIDInfo.expiredSeconds = PushPreferences.getLong(paramContext, "XG_GUID_EXPIRED_SECONDS", 0L);
      localGUIDInfo.refreshTime = PushPreferences.getLong(paramContext, "XG_GUID_LAST_REFRESH_TIME", 0L);
      localGUIDInfo.token = PushPreferences.getString(paramContext, "XG_GUID_TOKEN", "");
      localGUIDInfo.tokenList = PushPreferences.getString(paramContext, "XG_GUID_TOKEN_LIST", "");
      localGUIDInfo.mqttServer = PushPreferences.getString(paramContext, "XG_GUID_MQTT_SERVER", "");
      localGUIDInfo.userName = PushPreferences.getString(paramContext, "XG_GUID_MQTT_USERNAME", "");
      localGUIDInfo.passWord = PushPreferences.getString(paramContext, "XG_GUID_MQTT_PASSWORD", "");
      localGUIDInfo.guidLastAccessid = PushPreferences.getLong(paramContext, "XG_GUID_LAST_ACCESSID", 0L);
      localGUIDInfo.mqttServerRefreshTime = PushPreferences.getLong(paramContext, "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0L);
      localGUIDInfo.refuseRate = PushPreferences.getInt(paramContext, "XG_GUID_SERVER_ABANDON_RATE", 0);
      localGUIDInfo.mqttPortList = PushPreferences.getString(paramContext, "XG_GUID_MQTT_PORTLIST", "");
      localGUIDInfo.encrypt = PushPreferences.getInt(paramContext, "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
      return localGUIDInfo;
    }
    catch (Throwable paramContext) {}
    return localGUIDInfo;
  }
  
  public boolean isError()
  {
    if (this.errCode != 0) {
      return true;
    }
    if ((Util.isNullOrEmptyString(this.token)) || (Util.isNullOrEmptyString(this.mqttServer)) || (Util.isNullOrEmptyString(this.userName)) || (Util.isNullOrEmptyString(this.passWord)))
    {
      this.errCode = -5;
      this.result = "GUID check result is null";
      return true;
    }
    return false;
  }
  
  public void saveGuidToSha(Context paramContext)
  {
    if (!Util.isNullOrEmptyString(this.token)) {
      PushPreferences.putString(paramContext, "XG_GUID_TOKEN", this.token);
    }
    if (!Util.isNullOrEmptyString(this.tokenList)) {
      PushPreferences.putString(paramContext, "XG_GUID_TOKEN_LIST", this.tokenList);
    }
    if (!Util.isNullOrEmptyString(this.mqttServer)) {
      PushPreferences.putString(paramContext, "XG_GUID_MQTT_SERVER", this.mqttServer);
    }
    if (!Util.isNullOrEmptyString(this.userName)) {
      PushPreferences.putString(paramContext, "XG_GUID_MQTT_USERNAME", this.userName);
    }
    if (!Util.isNullOrEmptyString(this.passWord)) {
      PushPreferences.putString(paramContext, "XG_GUID_MQTT_PASSWORD", this.passWord);
    }
    if (this.guid >= 0L) {
      PushPreferences.putLong(paramContext, "XG_GUID_GUID", this.guid);
    }
    if (this.expiredSeconds >= 0L) {
      PushPreferences.putLong(paramContext, "XG_GUID_EXPIRED_SECONDS", this.expiredSeconds);
    }
    if (this.refreshTime >= 0L) {
      PushPreferences.putLong(paramContext, "XG_GUID_LAST_REFRESH_TIME", this.refreshTime);
    }
    if (this.guidLastAccessid >= 0L) {
      PushPreferences.putLong(paramContext, "XG_GUID_LAST_ACCESSID", this.guidLastAccessid);
    }
    if (this.refuseRate >= 0L) {
      PushPreferences.putInt(paramContext, "XG_GUID_SERVER_ABANDON_RATE", this.refuseRate);
    }
    if (this.encrypt >= 0) {
      PushPreferences.putInt(paramContext, "XG_GUID_SERVER_ENCRYPT_LEVEL", this.encrypt);
    }
    if (!Util.isNullOrEmptyString(this.mqttPortList)) {
      PushPreferences.putString(paramContext, "XG_GUID_MQTT_PORTLIST", this.mqttPortList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.device.GUIDInfo
 * JD-Core Version:    0.7.0.1
 */