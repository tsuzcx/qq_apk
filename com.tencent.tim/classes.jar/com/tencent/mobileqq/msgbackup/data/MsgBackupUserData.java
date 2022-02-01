package com.tencent.mobileqq.msgbackup.data;

import ajey;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class MsgBackupUserData
  implements Parcelable
{
  public static final Parcelable.Creator<MsgBackupUserData> CREATOR = new ajey();
  private List<Integer> Dd;
  private String bssid;
  private String ip;
  private int platform;
  private String ssid;
  
  public MsgBackupUserData(Parcel paramParcel)
  {
    this.ip = paramParcel.readString();
    paramParcel.readList(this.Dd, getClass().getClassLoader());
    this.ssid = paramParcel.readString();
    this.bssid = paramParcel.readString();
    this.platform = paramParcel.readInt();
  }
  
  private MsgBackupUserData(String paramString1, List<Integer> paramList, String paramString2, String paramString3, int paramInt)
  {
    this.ip = paramString1;
    this.Dd = paramList;
    this.ssid = paramString2;
    this.bssid = paramString3;
    this.platform = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<Integer> fE()
  {
    return this.Dd;
  }
  
  public String getBssid()
  {
    return this.bssid;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--UserData--");
    localStringBuilder.append(", ip: ").append(this.ip).append(",ports: ").append(this.Dd).append(",bssid: ").append(this.bssid).append(", ssid: ").append(this.ssid).append(", platfrom: ").append(this.platform);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ip);
    paramParcel.writeList(this.Dd);
    paramParcel.writeString(this.ssid);
    paramParcel.writeString(this.bssid);
    paramParcel.writeInt(this.platform);
  }
  
  public static class a
  {
    private List<Integer> Dd;
    private String bssid;
    private String ip;
    private int platform;
    private String ssid;
    
    public a a(int paramInt)
    {
      this.platform = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      this.ip = paramString;
      return this;
    }
    
    public a a(List<Integer> paramList)
    {
      this.Dd = paramList;
      return this;
    }
    
    public a b(String paramString)
    {
      this.ssid = paramString;
      return this;
    }
    
    public MsgBackupUserData b()
    {
      return new MsgBackupUserData(this.ip, this.Dd, this.ssid, this.bssid, this.platform, null);
    }
    
    public a c(String paramString)
    {
      this.bssid = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupUserData
 * JD-Core Version:    0.7.0.1
 */