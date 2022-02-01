package com.tencent.mobileqq.mini.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShareChatModel
  implements Parcelable
{
  public static final Parcelable.Creator<ShareChatModel> CREATOR = new ShareChatModel.1();
  public static final int TYPE_C2C = 0;
  public static final int TYPE_GROUP = 1;
  private String entryDataHash;
  public String name;
  public Map<String, String> reportData;
  public int type;
  public long uin;
  
  public ShareChatModel(int paramInt, long paramLong, String paramString)
  {
    this.type = paramInt;
    this.uin = paramLong;
    this.name = paramString;
    this.entryDataHash = UUID.randomUUID().toString();
  }
  
  private ShareChatModel(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.uin = paramParcel.readLong();
    this.name = paramParcel.readString();
    this.entryDataHash = paramParcel.readString();
    if (this.reportData == null) {
      this.reportData = new HashMap();
    }
    paramParcel.readMap(this.reportData, Map.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getEntryHash()
  {
    return this.entryDataHash;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.entryDataHash);
    paramParcel.writeMap(this.reportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.ShareChatModel
 * JD-Core Version:    0.7.0.1
 */