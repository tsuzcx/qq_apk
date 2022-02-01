package com.tencent.mobileqq.activity.contact.addfriendverifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import yqt;

public class AddFriendBlockedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AddFriendBlockedInfo> CREATOR = new yqt();
  public String AI;
  public long Kx;
  public String aZx;
  public int age;
  public int caF;
  public String friendUin;
  public boolean isRead;
  public int sex;
  
  public AddFriendBlockedInfo() {}
  
  public AddFriendBlockedInfo(Parcel paramParcel)
  {
    this.friendUin = paramParcel.readString();
    this.AI = paramParcel.readString();
    this.age = paramParcel.readInt();
    this.sex = paramParcel.readInt();
    this.aZx = paramParcel.readString();
    this.Kx = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isRead = bool;
      this.caF = paramParcel.readInt();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AddFriendBlockedInfo {, friendUin='" + this.friendUin + '\'' + ", friendNick='" + this.AI + '\'' + ", age='" + this.age + '\'' + ", sex='" + this.sex + '\'' + ", sourceDsp='" + this.aZx + '\'' + ", blockTime='" + this.Kx + '\'' + ", isRead='" + this.isRead + '\'' + ", commFriends='" + this.caF + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.friendUin);
    paramParcel.writeString(this.AI);
    paramParcel.writeInt(this.age);
    paramParcel.writeInt(this.sex);
    paramParcel.writeString(this.aZx);
    paramParcel.writeLong(this.Kx);
    if (this.isRead) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.caF);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo
 * JD-Core Version:    0.7.0.1
 */