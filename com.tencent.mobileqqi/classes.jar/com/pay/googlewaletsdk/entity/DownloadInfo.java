package com.pay.googlewaletsdk.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadInfo> CREATOR = new Parcelable.Creator()
  {
    public DownloadInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.set_id(paramAnonymousParcel.readLong());
      localDownloadInfo.setLocal_filename(paramAnonymousParcel.readString());
      localDownloadInfo.setDestination(paramAnonymousParcel.readString());
      localDownloadInfo.setTitle(paramAnonymousParcel.readString());
      localDownloadInfo.setUri(paramAnonymousParcel.readString());
      localDownloadInfo.setDownload_status(paramAnonymousParcel.readInt());
      localDownloadInfo.setTotal_size(paramAnonymousParcel.readLong());
      localDownloadInfo.setCurrent_download_size(paramAnonymousParcel.readLong());
      localDownloadInfo.setLocal_uri(paramAnonymousParcel.readString());
      localDownloadInfo.setReason(paramAnonymousParcel.readString());
      localDownloadInfo.setKey(paramAnonymousParcel.readString());
      localDownloadInfo.setAdditional_1(paramAnonymousParcel.readString());
      localDownloadInfo.setAdditional_2(paramAnonymousParcel.readString());
      localDownloadInfo.setAddParameterInfo(paramAnonymousParcel.readBundle());
      return localDownloadInfo;
    }
    
    public DownloadInfo[] newArray(int paramAnonymousInt)
    {
      return new DownloadInfo[paramAnonymousInt];
    }
  };
  private long _id = -1L;
  private Bundle addParameterInfo;
  private String additional_1;
  private String additional_2;
  private long current_download_size;
  private String destination;
  private int download_status = -1;
  private String key;
  private String local_filename;
  private String local_uri;
  private String reason;
  private String title;
  private long total_size;
  private String uri;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject != null) && (((DownloadInfo)paramObject).getKey() == null)) || (this.key == null)) {
      return false;
    }
    return ((DownloadInfo)paramObject).getKey().equals(this.key);
  }
  
  public Bundle getAddParameterInfo()
  {
    return this.addParameterInfo;
  }
  
  public String getAdditional_1()
  {
    return this.additional_1;
  }
  
  public String getAdditional_2()
  {
    return this.additional_2;
  }
  
  public long getCurrent_download_size()
  {
    return this.current_download_size;
  }
  
  public String getDestination()
  {
    return this.destination;
  }
  
  public int getDownload_status()
  {
    return this.download_status;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getLocal_filename()
  {
    return this.local_filename;
  }
  
  public String getLocal_uri()
  {
    return this.local_uri;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public long getTotal_size()
  {
    return this.total_size;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public long get_id()
  {
    return this._id;
  }
  
  public void setAddParameterInfo(Bundle paramBundle)
  {
    this.addParameterInfo = paramBundle;
  }
  
  public void setAdditional_1(String paramString)
  {
    this.additional_1 = paramString;
  }
  
  public void setAdditional_2(String paramString)
  {
    this.additional_2 = paramString;
  }
  
  public void setCurrent_download_size(long paramLong)
  {
    this.current_download_size = paramLong;
  }
  
  public void setDestination(String paramString)
  {
    this.destination = paramString;
  }
  
  public void setDownload_status(int paramInt)
  {
    this.download_status = paramInt;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setLocal_filename(String paramString)
  {
    this.local_filename = paramString;
  }
  
  public void setLocal_uri(String paramString)
  {
    this.local_uri = paramString;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTotal_size(long paramLong)
  {
    this.total_size = paramLong;
  }
  
  public void setUri(String paramString)
  {
    this.uri = paramString;
  }
  
  public void set_id(long paramLong)
  {
    this._id = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this._id);
    paramParcel.writeString(this.local_filename);
    paramParcel.writeString(this.destination);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.uri);
    paramParcel.writeInt(this.download_status);
    paramParcel.writeLong(this.total_size);
    paramParcel.writeLong(this.current_download_size);
    paramParcel.writeString(this.local_uri);
    paramParcel.writeString(this.reason);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.additional_1);
    paramParcel.writeString(this.additional_2);
    paramParcel.writeBundle(this.addParameterInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewaletsdk.entity.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */