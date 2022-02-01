package com.tencent.open.agent.datamodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import artk;

public class Friend
  implements Parcelable
{
  public static final Parcelable.Creator<Friend> CREATOR = new artk();
  public String cCh;
  public String cCi;
  public String cCj;
  public int ekQ = -1;
  public int ekR;
  public int ekS;
  public String label;
  public String nickName;
  public String openId;
  public String uin;
  
  public Friend()
  {
    this.nickName = "";
    this.label = "";
    this.cCh = "";
    this.ekR = -1;
    this.ekS = -1;
    this.cCi = "";
    this.cCj = "";
  }
  
  public Friend(Friend paramFriend)
  {
    this.openId = paramFriend.openId;
    this.nickName = paramFriend.nickName;
    this.label = paramFriend.label;
    this.cCh = paramFriend.cCh;
    this.ekR = paramFriend.ekR;
    this.ekS = paramFriend.ekS;
    this.cCi = paramFriend.cCi;
    this.cCj = paramFriend.cCj;
    this.ekQ = paramFriend.ekQ;
    this.uin = paramFriend.uin;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (Friend)paramObject;
    } while (this.openId == null);
    return this.openId.equals(paramObject.openId);
  }
  
  public int hashCode()
  {
    if (this.openId != null) {
      return this.openId.hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.openId);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.cCh);
    paramParcel.writeInt(this.ekQ);
    paramParcel.writeString(this.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.Friend
 * JD-Core Version:    0.7.0.1
 */