package com.tencent.mobileqq.service.friendlist.remote;

import anaj;
import anak;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class FriendGroupListInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FriendGroupListInfo> CREATOR = new anak();
  public List<anaj> Gp;
  public int totalCount;
  
  public FriendGroupListInfo()
  {
    this.totalCount = 0;
    this.Gp = new ArrayList();
  }
  
  public FriendGroupListInfo(Parcel paramParcel)
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
    this.Gp = new ArrayList();
    int i = 0;
    while (i < j)
    {
      anaj localanaj = new anaj();
      localanaj.readFromParcel(paramParcel);
      this.Gp.add(localanaj);
      i += 1;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.Gp == null) {
      this.Gp = new ArrayList();
    }
    paramParcel.writeInt(this.totalCount);
    paramParcel.writeInt(this.Gp.size());
    paramInt = 0;
    while (paramInt < this.Gp.size())
    {
      ((anaj)this.Gp.get(paramInt)).writeToParcel(paramParcel);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo
 * JD-Core Version:    0.7.0.1
 */