package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import edk;
import java.util.ArrayList;
import java.util.List;

public class FriendGroupListInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new edk();
  public int a;
  public List a;
  
  public FriendGroupListInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendGroupListInfo(int paramInt, List paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public FriendGroupListInfo(Parcel paramParcel)
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
      FriendGroupInfo localFriendGroupInfo = new FriendGroupInfo();
      localFriendGroupInfo.b(paramParcel);
      this.jdField_a_of_type_JavaUtilList.add(localFriendGroupInfo);
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
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((FriendGroupInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramParcel);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo
 * JD-Core Version:    0.7.0.1
 */