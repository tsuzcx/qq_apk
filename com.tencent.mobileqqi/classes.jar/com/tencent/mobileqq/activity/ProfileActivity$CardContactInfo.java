package com.tencent.mobileqq.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import czy;

public class ProfileActivity$CardContactInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new czy();
  public String a;
  public String b;
  public String c;
  
  private ProfileActivity$CardContactInfo() {}
  
  public ProfileActivity$CardContactInfo(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.b = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo
 * JD-Core Version:    0.7.0.1
 */