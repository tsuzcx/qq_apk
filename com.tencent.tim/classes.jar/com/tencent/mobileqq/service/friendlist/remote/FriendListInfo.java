package com.tencent.mobileqq.service.friendlist.remote;

import anal;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class FriendListInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FriendListInfo> CREATOR = new anal();
  public List<FriendSingleInfo> friendList;
  public int totalCount;
  
  public FriendListInfo()
  {
    this.totalCount = 0;
    this.friendList = new ArrayList();
  }
  
  public FriendListInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.totalCount = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.friendList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      FriendSingleInfo localFriendSingleInfo = new FriendSingleInfo();
      localFriendSingleInfo.readFromParcel(paramParcel);
      this.friendList.add(localFriendSingleInfo);
      i += 1;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.friendList == null) {
      this.friendList = new ArrayList();
    }
    paramParcel.writeInt(this.totalCount);
    paramParcel.writeInt(this.friendList.size());
    int i = 0;
    while (i < this.friendList.size())
    {
      ((FriendSingleInfo)this.friendList.get(i)).writeToParcel(paramParcel, paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendListInfo
 * JD-Core Version:    0.7.0.1
 */