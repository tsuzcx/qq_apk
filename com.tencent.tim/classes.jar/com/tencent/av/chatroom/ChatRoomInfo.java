package com.tencent.av.chatroom;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ilt;

public class ChatRoomInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChatRoomInfo> CREATOR = new ilt();
  public boolean Sq;
  public boolean Sr;
  public boolean Ss;
  private int aoN;
  public int aoO;
  public int aoP;
  public int aoQ;
  public long createTime;
  public long id;
  public long lJ;
  public long lK;
  public int type;
  
  public ChatRoomInfo(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.type = paramInt;
    this.lJ = paramLong1;
    this.id = paramLong2;
    this.createTime = paramLong3;
  }
  
  public ChatRoomInfo(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.lJ = paramParcel.readLong();
    this.id = paramParcel.readLong();
    this.createTime = paramParcel.readLong();
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return (this.type == paramInt) && (this.lJ == paramLong1) && (this.id == paramLong2) && (this.createTime == paramLong3);
  }
  
  public void aob()
  {
    this.aoN += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChatRoomInfo)) {}
    do
    {
      return false;
      paramObject = (ChatRoomInfo)paramObject;
    } while ((this.type != paramObject.type) || (this.lJ != paramObject.lJ) || (this.id != paramObject.id) || (this.createTime != paramObject.createTime));
    return true;
  }
  
  public boolean tV()
  {
    return this.aoN <= 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("ChatRoomInfo{");
    localStringBuilder.append("type: ").append(this.type);
    localStringBuilder.append(", roomID: ").append(this.lJ);
    localStringBuilder.append(", id: ").append(this.id);
    localStringBuilder.append(", createTime: ").append(this.createTime);
    localStringBuilder.append(", isFromSwitchTerminal: ").append(this.Ss);
    localStringBuilder.append(", preRoomId: ").append(this.lK);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.lJ);
    paramParcel.writeLong(this.id);
    paramParcel.writeLong(this.createTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomInfo
 * JD-Core Version:    0.7.0.1
 */