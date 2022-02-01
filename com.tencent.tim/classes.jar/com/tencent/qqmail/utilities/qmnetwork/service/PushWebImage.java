package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.IJsonInterface;
import com.tencent.qqmail.utilities.json.JSONReader;

public class PushWebImage
  implements Parcelable, IJsonInterface
{
  public static final Parcelable.Creator<PushWebImage> CREATOR = new PushWebImage.1();
  public int accountId = 0;
  public String cookidSid = "";
  public String host = "";
  public String key = "";
  public String sid = "";
  public String timeStamp = "";
  
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
          this.cookidSid = str;
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
      return paramString;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.accountId = paramParcel.readInt();
    this.host = paramParcel.readString();
    this.sid = paramParcel.readString();
    this.key = paramParcel.readString();
    this.cookidSid = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
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
    paramParcel.writeString(this.cookidSid);
    paramParcel.writeString(this.timeStamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushWebImage
 * JD-Core Version:    0.7.0.1
 */