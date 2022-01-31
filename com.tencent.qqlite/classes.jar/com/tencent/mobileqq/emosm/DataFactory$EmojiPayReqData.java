package com.tencent.mobileqq.emosm;

import android.os.Bundle;

public class DataFactory$EmojiPayReqData
{
  public String appid;
  public String callbackid;
  public String discountId;
  public String other;
  public String pf;
  public String pfKey;
  public String sessionId;
  public String sessionType;
  public String tokenUrl;
  public String userId;
  public String userKey;
  public String zoneId;
  
  public DataFactory$EmojiPayReqData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.callbackid = paramString1;
    this.appid = paramString2;
    this.userId = paramString3;
    this.userKey = paramString4;
    this.sessionId = paramString5;
    this.sessionType = paramString6;
    this.zoneId = paramString7;
    this.pf = paramString8;
    this.pfKey = paramString9;
    this.tokenUrl = paramString10;
  }
  
  public DataFactory$EmojiPayReqData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.callbackid = paramString1;
    this.appid = paramString2;
    this.userId = paramString3;
    this.userKey = paramString4;
    this.sessionId = paramString5;
    this.sessionType = paramString6;
    this.zoneId = paramString7;
    this.pf = paramString8;
    this.pfKey = paramString9;
    this.tokenUrl = paramString10;
    this.discountId = paramString11;
    this.other = paramString12;
  }
  
  public static EmojiPayReqData makeEmojiPayReqData(Bundle paramBundle)
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    if (paramBundle != null)
    {
      str1 = paramBundle.getString("callbackid");
      str2 = paramBundle.getString("appid");
      str3 = paramBundle.getString("userId");
      str4 = paramBundle.getString("userKey");
      str5 = paramBundle.getString("sessionId");
      str6 = paramBundle.getString("sessionType");
      str7 = paramBundle.getString("zoneId");
      str8 = paramBundle.getString("pf");
      str9 = paramBundle.getString("pfKey");
      str10 = paramBundle.getString("tokenUrl");
      str11 = paramBundle.getString("discountId");
      str12 = paramBundle.getString("other");
    }
    return new EmojiPayReqData(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
  }
  
  public Bundle getBundleData()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackid", this.callbackid);
    localBundle.putString("appid", this.appid);
    localBundle.putString("userId", this.userId);
    localBundle.putString("userKey", this.userKey);
    localBundle.putString("sessionId", this.sessionId);
    localBundle.putString("sessionType", this.sessionType);
    localBundle.putString("zoneId", this.zoneId);
    localBundle.putString("pf", this.pf);
    localBundle.putString("pfKey", this.pfKey);
    localBundle.putString("tokenUrl", this.tokenUrl);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData
 * JD-Core Version:    0.7.0.1
 */