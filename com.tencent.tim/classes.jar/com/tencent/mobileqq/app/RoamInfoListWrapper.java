package com.tencent.mobileqq.app;

import MessageSvcPack.RoamInfo;
import aclc;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class RoamInfoListWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<RoamInfoListWrapper> CREATOR = new aclc();
  public ArrayList<RoamInfo> tE;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.tE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamInfoListWrapper
 * JD-Core Version:    0.7.0.1
 */