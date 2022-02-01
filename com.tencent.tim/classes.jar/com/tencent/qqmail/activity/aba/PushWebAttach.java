package com.tencent.qqmail.activity.aba;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.IJsonInterface;
import com.tencent.qqmail.utilities.json.JSONReader;

public class PushWebAttach
  implements Parcelable, IJsonInterface
{
  public static final Parcelable.Creator<PushWebAttach> CREATOR = new PushWebAttach.1();
  private int accountId = 0;
  private String allowSize = "";
  private String cookieSid = "";
  private String host = "";
  private String key = "";
  private String sid = "";
  private String timeStamp = "";
  
  public int describeContents()
  {
    return 0;
  }
  
  public JSONObject fromJson(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if ((paramString == null) || (paramString.containsKey("a"))) {}
    try
    {
      this.accountId = Integer.parseInt((String)paramString.get("a"));
      label37:
      String str;
      if (paramString.containsKey("host"))
      {
        str = (String)paramString.get("host");
        if (str != null) {
          this.host = str;
        }
      }
      if (paramString.containsKey("sid"))
      {
        str = (String)paramString.get("sid");
        if (str != null) {
          this.sid = str;
        }
      }
      if (paramString.containsKey("cookiesid"))
      {
        str = (String)paramString.get("cookiesid");
        if (str != null) {
          this.cookieSid = str;
        }
      }
      if (paramString.containsKey("key"))
      {
        str = (String)paramString.get("key");
        if (str != null) {
          this.key = str;
        }
      }
      if (paramString.containsKey("timestamp"))
      {
        str = (String)paramString.get("timestamp");
        if (str != null) {
          this.timeStamp = str;
        }
      }
      if (paramString.containsKey("allowsize"))
      {
        str = (String)paramString.get("allowsize");
        if (str != null) {
          this.allowSize = str;
        }
      }
      return paramString;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getAllowSize()
  {
    return this.allowSize;
  }
  
  public String getCookieSid()
  {
    return this.cookieSid;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getSid()
  {
    return this.sid;
  }
  
  public String getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.accountId = paramParcel.readInt();
    this.host = paramParcel.readString();
    this.sid = paramParcel.readString();
    this.key = paramParcel.readString();
    this.cookieSid = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAllowSize(String paramString)
  {
    this.allowSize = paramString;
  }
  
  public void setCookieSid(String paramString)
  {
    this.cookieSid = paramString;
  }
  
  public void setHost(String paramString)
  {
    this.host = paramString;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setSid(String paramString)
  {
    this.sid = paramString;
  }
  
  public void setTimeStamp(String paramString)
  {
    this.timeStamp = paramString;
  }
  
  public String toJson()
  {
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.accountId);
    paramParcel.writeString(this.host);
    paramParcel.writeString(this.sid);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.cookieSid);
    paramParcel.writeString(this.timeStamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.aba.PushWebAttach
 * JD-Core Version:    0.7.0.1
 */