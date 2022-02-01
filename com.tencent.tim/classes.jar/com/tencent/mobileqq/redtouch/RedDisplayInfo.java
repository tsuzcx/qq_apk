package com.tencent.mobileqq.redtouch;

import altn;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class RedDisplayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RedDisplayInfo> CREATOR = new altn();
  private RedTypeInfo a;
  public ArrayList<RedTypeInfo> yV;
  
  public RedTypeInfo a()
  {
    return this.a;
  }
  
  public void a(RedTypeInfo paramRedTypeInfo)
  {
    this.a = paramRedTypeInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void eK(ArrayList<RedTypeInfo> paramArrayList)
  {
    this.yV = paramArrayList;
  }
  
  public List<RedTypeInfo> fT()
  {
    return this.yV;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.yV);
    paramParcel.writeSerializable(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */