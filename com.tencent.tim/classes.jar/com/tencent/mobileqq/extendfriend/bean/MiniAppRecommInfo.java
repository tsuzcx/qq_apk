package com.tencent.mobileqq.extendfriend.bean;

import acfp;
import aftt;
import aftu;
import afua;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MiniAppRecommInfo
  extends afua
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<MiniAppRecommInfo> CREATOR = new aftt();
  public List<MiniApp> appInfoList = new ArrayList();
  public long cacheValidTime = System.currentTimeMillis() / 1000L + 3600L;
  public String headDesc = acfp.m(2131708409);
  
  public MiniAppRecommInfo() {}
  
  public MiniAppRecommInfo(Parcel paramParcel)
  {
    this.headDesc = paramParcel.readString();
    this.appInfoList = paramParcel.createTypedArrayList(MiniApp.CREATOR);
    this.cacheValidTime = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.headDesc);
    paramParcel.writeTypedList(this.appInfoList);
    paramParcel.writeLong(this.cacheValidTime);
  }
  
  public static class MiniApp
    implements Parcelable
  {
    public static final Parcelable.Creator<MiniApp> CREATOR = new aftu();
    public int adId;
    public String appId;
    public String appName;
    public String iconUrl;
    public MiniAppInfo miniAppInfo;
    
    public MiniApp() {}
    
    public MiniApp(Parcel paramParcel)
    {
      this.appId = paramParcel.readString();
      this.appName = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.miniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.appName);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeParcelable(this.miniAppInfo, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo
 * JD-Core Version:    0.7.0.1
 */