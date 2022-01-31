package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import giv;
import java.util.ArrayList;
import java.util.List;

public class FriendListInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new giv();
  public int a;
  public List a;
  
  public FriendListInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendListInfo(int paramInt, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public FriendListInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      FriendSingleInfo localFriendSingleInfo = new FriendSingleInfo();
      localFriendSingleInfo.a(paramParcel);
      this.jdField_a_of_type_JavaUtilList.add(localFriendSingleInfo);
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_a_of_type_JavaUtilList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((FriendSingleInfo)this.jdField_a_of_type_JavaUtilList.get(i)).writeToParcel(paramParcel, paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendListInfo
 * JD-Core Version:    0.7.0.1
 */