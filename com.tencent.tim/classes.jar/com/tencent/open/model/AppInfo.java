package com.tencent.open.model;

import acfp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asay;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.qqconnect.Appinfo;

public class AppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AppInfo> CREATOR = new asay();
  private boolean mChecked;
  private String mIconUrl = "";
  private int mId = -1;
  private String mName = "";
  private int mType = -1;
  
  public AppInfo(Parcel paramParcel)
  {
    this.mId = paramParcel.readInt();
    this.mType = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIconUrl = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mChecked = bool;
      return;
    }
  }
  
  public AppInfo(qqconnect.Appinfo paramAppinfo)
  {
    if (paramAppinfo.appid.has()) {
      this.mId = paramAppinfo.appid.get();
    }
    if (paramAppinfo.app_name.has()) {
      this.mName = paramAppinfo.app_name.get();
    }
    if (paramAppinfo.app_type.has()) {
      this.mType = paramAppinfo.app_type.get();
    }
    if (paramAppinfo.icon_url.has()) {
      this.mIconUrl = paramAppinfo.icon_url.get();
    }
  }
  
  public String DG()
  {
    switch (this.mType)
    {
    default: 
      return acfp.m(2131702751);
    case 0: 
      return acfp.m(2131702750);
    case 1: 
      return acfp.m(2131702752);
    case 2: 
      return "ARK应用";
    case 3: 
      return "";
    case 4: 
      return "";
    case 5: 
      return "";
    case 6: 
      return "";
    case 7: 
      return "";
    case 8: 
      return "";
    case 9: 
      return "";
    }
    return "";
  }
  
  public boolean aHE()
  {
    return this.mChecked;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getIconUrl()
  {
    return this.mIconUrl;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.mChecked = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AppInfo{");
    localStringBuilder.append("mId=").append(this.mId);
    localStringBuilder.append(", mName='").append(this.mName).append('\'');
    localStringBuilder.append(", type='").append(DG()).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mId);
    paramParcel.writeInt(this.mType);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mIconUrl);
    if (this.mChecked) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.model.AppInfo
 * JD-Core Version:    0.7.0.1
 */